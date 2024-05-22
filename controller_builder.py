#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu May  2 09:06:16 2024

@author: usco
"""

import os
import json

from utils import Utils


class ControllerBuilder:
    
    def __init__(self, parameters):
        self.parameters = parameters
        
        # self.base_path = self.parameters["base_path"]
        self.source_directory = self.parameters["source_directory"]
        # self.package_name = self.parameters["package_name"]
        self.model_filename = self.parameters["model_filename"]
        
        self.data = self.get_data()
        self.package_name = self.data["package_name"] + "." + self.data["app_name"]
                
        self.template_directory = os.path.join(
            "templates"
            )
        
        self.data_type_dict = {
            "int": "int",
            "string":"String",
            "date":"Date",
            "timestamp":"TimeStamp",
            "double precision": "double",
            "boolean":"boolean"
            }



    def get_getter_list(self, object_name, attributes):
        getter_list = ""
        
        indentation = ""
        for attribute in attributes:
            attribute_name = attribute["name"]            
            attribute_name_upper = attribute_name[0].upper() + attribute_name[1:]
            attribute_pk = attribute["pk"]  
            
            if attribute_pk == False:
                get_text = indentation + "{}.get{}()"
            
                get_text = get_text.format(
                    object_name,
                    attribute_name_upper
                )
                getter_list += get_text
                indentation = ", "
            
        return getter_list


    # def create_folder(self, class_name, directory_name):
        
    #     folder_name = os.path.join(
    #         self.base_path,
    #         "src",
    #         "main",
    #         "java",
    #         self.package_name,
    #         class_name.lower(),
    #         directory_name
    #         )
    
    #     if os.path.exists(folder_name) == False:
    #         os.makedirs(folder_name)
        
    #     return folder_name
    
    
    def get_template_filename(self, template_name):
        template_filename = os.path.join(
            self.template_directory,
            template_name + ".java"
            )
        
        return template_filename
    
    
    def get_controller_filename(self, folder_name, class_name_camelcase):
        controller_filename = os.path.join(
            folder_name,
            "{}Controller.java".format(class_name_camelcase)
            )
        
        return controller_filename    
            
    
            
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
            
            utils = Utils()
            folder_name = utils.create_folder(
                class_name, 
                self.package_name, 
                self.source_directory
                )
            
            # directory_name = "controller"
            # folder_name = self.create_folder(class_name, directory_name)
            
            # folder_name = os.path.join(
            #     base_path,
            #     "src",
            #     package_name,
            #     class_name_lower,
            #     "controller"
            #     )
        
            
            # if os.path.exists(folder_name) == False:
            #     os.makedirs(folder_name)
        
            template_filename = self.get_template_filename("Controller")
            
            # template_filename = os.path.join(
            #     template_directory,
            #     "Controller.java"
            #     )
            
            f = open(template_filename, "r")
            content = f.read()
        
            content = content.replace("$PACKAGE_NAME$", self.package_name)
            
            # CLASS_NAME$
            content = content.replace("$CLASS_NAME$", class_name_camelcase)
            
            
            # $OBJECT_NAME$
            content = content.replace("$OBJECT_NAME$", object_name)
                
            
            attributes = _class["attributes"]
            
            # $OBJECT_GETTERS$
            object_getters = self.get_getter_list(object_name, attributes)
            content = content.replace("$OBJECT_GETTERS$", object_getters)
            
            
            
            # close file to save changes
            controller_filename = self.get_controller_filename(
                folder_name, 
                class_name_camelcase)
            
            f = open(controller_filename, "w")
            f.write(content)
            f.close()
            







# base_path = "/home/usco/Documents/test/pruebas/pruebas"
# package_name = "org.usco.test"

# base_directory = "/home/usco/Documents/test/pruebas/pruebas"

# template_directory = os.path.join(
#     base_directory,
#     "templates"
#     )

# data_type_dict = {
#     "int": "int",
#     "string":"String",
#     "date":"Date",
#     "timestamp":"TimeStamp",
#     "boolean":"boolean"
#     }


# model_filename = "/home/usco/Documents/test/pruebas/pruebas2/pruebas1.json"
# f = open(model_filename)
# data = json.load(f)
 
# # print(data)




