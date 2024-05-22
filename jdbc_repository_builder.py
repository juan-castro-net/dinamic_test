#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu May  2 09:04:49 2024

@author: usco
"""

import os
import json

from utils import Utils

class JdbcRepositoryBuilder:
    
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
            "double precision":"double",
            "boolean":"boolean"
            }
    
    
    def get_create_sql(self, class_name, attributes):
        sql = "\"INSERT INTO public.{}\"\n".format(class_name)
        sql += "\t\t+ \"("
        
        values = ""
        indentation = ""
        for attribute in attributes:
            attribute_name = attribute["name"]            
            # attribute_data_type = attribute["data_type"]   
            attribute_pk = attribute["pk"]  
            
            print(attribute_name, attribute_pk)
            
            # attribute_data_type = data_dict[attribute_data_type]
            
            if attribute_pk == False:
                sql += indentation + attribute_name
                values += indentation + "?"
                indentation = ", "
        sql  += ")\"\n"
        sql  += "\t\t+ \"VALUES ({})\";\n".format(values)   
        
        
        return sql


    def get_read_sql(self, class_name, attributes):
        sql = "\"SELECT "
        
        indentation = ""
        for attribute in attributes:
            attribute_name = attribute["name"]            
            
            sql += indentation + attribute_name
            indentation = ", "
        
        sql += "\"\n"
        sql += "\t\t+ \" FROM public.{}\";\n".format(class_name)
          
        return sql


    def get_update_sql(self, class_name, attributes):
        sql = "\"UPDATE public.{}\"\n".format(class_name)
        sql += "\t\t+ \" SET "
        
        indentation = ""
        for attribute in attributes:
            attribute_name = attribute["name"]            
            attribute_pk = attribute["pk"]  
            
            if attribute_pk == False:
                sql += indentation + attribute_name + "=?"
                indentation = ", "
        sql += "\"\n"
        sql += "\t\t+ \" WHERE id=?\";\n"
          
        return sql


    def get_delete_sql(self, class_name, attributes):
        sql = "\"DELETE FROM public.{}\"\n".format(class_name)
        sql += "\t\t+ \" WHERE id=?\";\n"
          
        return sql
    
    def get_pk_data(self, attributes):
        pk_attribute_data_type = ""
        pk_attribute_name = ""
        
        for attribute in attributes:
            attribute_name = attribute["name"]            
            attribute_data_type = attribute["data_type"]   
            attribute_pk = attribute["pk"]  
            
            attribute_data_type = self.data_type_dict[attribute_data_type]
            
            if attribute_pk == True:
                pk_attribute_data_type = attribute_data_type
                pk_attribute_name = attribute_name
        
        return pk_attribute_data_type, pk_attribute_name
    
    
    def get_jdbc_repository_filename(self, folder_name, class_name_camelcase):
        jdbc_repository_filename = os.path.join(
            folder_name,
            "Jdbc{}Repository.java".format(class_name_camelcase)
            )
        
        return jdbc_repository_filename
    
    
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


    def get_data(self):
        f = open(self.model_filename)
        data = json.load(f)
        
        return data
    
    
    def build(self):    
        # f = open(self.model_filename)
        # data = json.load(f)
        data = self.get_data()
        classes = data["classes"]
        
        # sql_text = ""
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
    
            template_filename = self.get_template_filename("JdbcRepository")
            f = open(template_filename, "r")
            content = f.read()
        
            # $PACKAGE_NAME$
            content = content.replace("$PACKAGE_NAME$", self.package_name)
        
            # $CLASS_NAME$
            content = content.replace("$CLASS_NAME$", class_name_camelcase)
            
            # $OBJECT_NAME$
            content = content.replace("$OBJECT_NAME$", object_name)
    
        
        
            jdbc_repository_filename = os.path.join(
                folder_name,
                "Jdbc{}Repository.java".format(class_name_camelcase)
                )
                
            
            attributes = _class["attributes"]
            # print(attributes)
        
            create_sql = self.get_create_sql(class_name_lower, attributes)
            content = content.replace("$CREATE_SQL$", create_sql)
            
            read_sql = self.get_read_sql(class_name_lower, attributes)
            content = content.replace("$READ_SQL$", read_sql)
            
            update_sql = self.get_update_sql(class_name_lower, attributes)
            content = content.replace("$UPDATE_SQL$", update_sql)
            
            delete_sql = self.get_delete_sql(class_name_lower, attributes)
            content = content.replace("$DELETE_SQL$", delete_sql)
            
            
            pk_attribute_data_type, pk_attribute_name = self.get_pk_data(attributes)
            content = content.replace("$PK_ATTRIBUTE_DATA_TYPE$", pk_attribute_data_type)
            content = content.replace("$PK_ATTRIBUTE_NAME$", pk_attribute_name)
            
            object_getters = self.get_getter_list(object_name, attributes)
            content = content.replace("$OBJECT_GETTERS$", object_getters)
        
        
            # close file to save changes
            jdbc_repository_filename = self.get_jdbc_repository_filename(
                folder_name, 
                class_name_camelcase)
            
            f = open(jdbc_repository_filename, "w")
            f.write(content)
            f.close()
    