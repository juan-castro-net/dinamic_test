#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu May  2 09:05:47 2024

@author: usco
"""

import os
import json

from utils import Utils

class ModelBuilder:
    
    def __init__(self, parameters):
        self.parameters = parameters
        
        # self.base_path = self.parameters["base_path"]
        self.source_directory = self.parameters["source_directory"]
        
        # self.package_name = self.parameters["package_name"]
        self.model_filename = self.parameters["model_filename"]
        
        self.data = self.get_data()
        self.package_name = self.data["package_name"] + "." + self.data["app_name"]
        
        self.template_directory = os.path.join(
            # self.parameters["base_path"],
            "templates"
            )
        
        self.data_type_dict = {
            "int": "int",
            "string":"String",
            "date":"Date",
            "timestamp":"Timestamp",
            "double precision":"double",
            "boolean":"boolean"
            }

    
    # $IMPORT_LIST$
    def get_import_list(self):
        import_list = ""
        import_list += "import java.sql.Timestamp;\n" 
        import_list += "import java.sql.Date;\n" 

        
        return import_list
    
    
    def get_model_filename(self, folder_name, class_name):
        model_filename = os.path.join(
            folder_name,
            class_name + ".java"
            )
        
        return model_filename
        
        
    def get_attribute_list(self, attributes):
        attribute_list = ""
        
        indentation = ""
        for attribute in attributes:
            attribute_name = attribute["name"]            
            attribute_data_type = attribute["data_type"]   
            
            attribute_data_type = self.data_type_dict[attribute_data_type]
            
            attribute_text = indentation + "private {} {};\n".format(
                attribute_data_type,
                attribute_name
                )
            attribute_list += attribute_text
            indentation = "\t"
            
        return attribute_list


    
    def get_this_attribute_list(self, attributes):
        this_attribute_list = ""
        
        indentation = ""
        for attribute in attributes:
            attribute_name = attribute["name"]            
            # attribute_data_type = attribute["data_type"]   
            
            attribute_text = indentation + "this.{} = {};\n".format(
                attribute_name,
                attribute_name
                )
            this_attribute_list += attribute_text
            indentation = "\t\t"
            
        return this_attribute_list
    
    
    def get_this_attribute_not_id_list(self, attributes):
        this_attribute_not_id_list = ""
        
        indentation = ""
        for attribute in attributes:
            attribute_name = attribute["name"]            
            # attribute_data_type = attribute["data_type"]   
            attribute_pk = attribute["pk"]  
            
            if attribute_pk == False:
                attribute_text = indentation + "this.{} = {};\n".format(
                    attribute_name,
                    attribute_name
                    )
                this_attribute_not_id_list += attribute_text
                indentation = "\t\t"
                
        return this_attribute_not_id_list
    
    
    
    def get_getter_and_setter(self, attributes):
        getter_and_setter = ""
        
        indentation = ""
        for attribute in attributes:
            attribute_name = attribute["name"]            
            attribute_data_type = attribute["data_type"]   
            
            attribute_data_type = self.data_type_dict[attribute_data_type]
            
            attribute_name_upper = attribute_name[0].upper() + attribute_name[1:]
            
            set_get_text = indentation + "public {} get{}() $OPEN_BRACKET$\n"
            set_get_text += "\t\treturn {};\n"
            set_get_text += "\t$CLOSE_BRACKET$\n"
            set_get_text += "\n"
            set_get_text += "\tpublic void set{}({} {}) $OPEN_BRACKET$\n"
            set_get_text += "\t\tthis.{} = {};\n"
            set_get_text += "\t$CLOSE_BRACKET$\n"
            
            set_get_text = set_get_text.format(
                attribute_data_type,
                attribute_name_upper,
                attribute_name,
                attribute_name_upper,
                attribute_data_type,
                attribute_name,
                attribute_name,
                attribute_name
                )
            
            set_get_text = set_get_text.replace("$OPEN_BRACKET$", "{")
            set_get_text = set_get_text.replace("$CLOSE_BRACKET$", "}")
            
            getter_and_setter += set_get_text
            indentation = "\t"
            
            
        return getter_and_setter
    
    
    
    def get_parameters(self, attributes):
        parameters = ""
        indentation = ""
        for attribute in attributes:
            attribute_name = attribute["name"]            
            attribute_data_type = attribute["data_type"]   
            
            attribute_data_type = self.data_type_dict[attribute_data_type]
            
            parameters += indentation + attribute_data_type + " " + attribute_name
            
            indentation = ", "
            
        return parameters
    
    
    def get_parameters_not_id(self, attributes):
        parameters_not_id = ""
        
        indentation = ""
        for attribute in attributes:
            attribute_name = attribute["name"]            
            attribute_data_type = attribute["data_type"]   
            attribute_pk = attribute["pk"]  
            
            attribute_data_type = self.data_type_dict[attribute_data_type]
            
            if attribute_pk == False:
                parameters_not_id += indentation + attribute_data_type + " " + attribute_name
                
                indentation = ", "
                
        return parameters_not_id
    
    
    
    def get_to_string(self, class_name, attributes):
        to_string = "\"{} [".format(class_name)
        
        separator = ""
        for attribute in attributes:
            attribute_name = attribute["name"]    
            to_string += separator + "{}=\" + {}".format(attribute_name,attribute_name)   
            separator = " + \", "
        to_string += " + \"]\";"    
        
        return to_string


    # def create_folder(self, class_name):
        
    #     folders = self.package_name.split(".")
    #     folders.append(class_name.lower())
        
    #     folder_name = os.path.join(
    #         self.source_directory,
    #         "src",
    #         "main",
    #         "java"
    #         )
        
    #     for folder in folders:
    #         folder_name = os.path.join(
    #             folder_name,
    #             folder
    #         )
        
    #         if os.path.exists(folder_name) == False:
    #             os.makedirs(folder_name)
        
    #     return folder_name
    
    
    def get_template_filename(self, template_name):
        template_filename = os.path.join(
            self.template_directory,
            template_name + ".java"
            )
        
        return template_filename
    
    def get_data(self):
        f = open(self.model_filename)
        data = json.load(f)
        
        return data
    
    def build(self):
        # f = open(self.model_filename)
        # data = json.load(f)
        data = self.get_data()
        
        classes = data["classes"]

        for _class in classes:
            class_name = _class["name"]
            print("class_name", class_name)
            
            class_name_camelcase = class_name[0].upper() + class_name[1:]
            class_name_lower = class_name.lower()
            object_name = class_name_lower
            
            # # directory_name = "model"
            # folder_name = self.create_folder(
            #     class_name
            #     )
            
            utils = Utils()
            folder_name = utils.create_folder(
                class_name, 
                self.package_name, 
                self.source_directory
                )
            
            template_filename = self.get_template_filename("Model")
            # template_filename = os.path.join(
            #     self.template_directory,
            #     "Model.java"
            #     )
            f = open(template_filename, "r")
            content = f.read()

            
            # $PACKAGE_NAME$
            content = content.replace("$PACKAGE_NAME$", self.package_name)
            
            
            # $IMPORT_LIST$
            import_list = self.get_import_list()
            print(import_list)
            content = content.replace("$IMPORT_LIST$", import_list)
            
            # $OBJECT_NAME$
            content = content.replace("$OBJECT_NAME$", object_name)
            
            # $CLASS_NAME$
            content = content.replace("$CLASS_NAME$", class_name_camelcase)
            

            # model_filename = os.path.join(
            #     folder_name,
            #     class_name + ".java"
            #     )
            
            attributes = _class["attributes"]
            # print(attributes)
            
            
            # $ATTRIBUTE_LIST$
            attribute_list = self.get_attribute_list(attributes)
            content = content.replace("$ATTRIBUTE_LIST$", attribute_list)
            
            
            # $THIS_ATTRIBUTES$
            this_attribute_list = self.get_this_attribute_list(attributes)
            content = content.replace("$THIS_ATTRIBUTES$", this_attribute_list)
            
                
            # $THIS_ATTRIBUTES_NOT_ID$
            this_attribute_not_id_list = self.get_this_attribute_not_id_list(attributes)
            content = content.replace("$THIS_ATTRIBUTES_NOT_ID$", this_attribute_not_id_list)
            
                
            # $GETTER_AND_SETTER$
            getter_and_setter = self.get_getter_and_setter(attributes)
            content = content.replace("$GETTER_AND_SETTER$", getter_and_setter)
            
            
            # $PARAMETERS$
            parameters = self.get_parameters(attributes)    
            content = content.replace("$PARAMETERS$", parameters)
            
            
            # $PARAMETERS_NOT_ID$
            parameters_not_id = self.get_parameters_not_id(attributes)
            content = content.replace("$PARAMETERS_NOT_ID$", parameters_not_id)
            
            
            # $TO_STRING$
            to_string = self.get_to_string(class_name_camelcase, attributes)
            content = content.replace("$TO_STRING$", to_string)
            
            
            # close file to save changes
            model_filename =  self.get_model_filename(
                folder_name, 
                class_name_camelcase
                )
            
            f = open(model_filename, "w")
            f.write(content)
            f.close()
            
    
    
    










# class_name = "Municipio"