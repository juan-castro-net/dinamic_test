#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu May  2 09:06:40 2024

@author: usco
"""

import os
import json

from utils import Utils


class RepositoryBuilder:
    
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
            "{}Repository.java".format(class_name_camelcase)
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
    
    def get_data(self):
        self.f = open(self.model_filename)
        data = json.load(self.f)
        
        return data
    
    def build(self):
        # f = open(self.model_filename)
        # data = json.load(f)
        
        data = self.get_data()
        
        classes = data["classes"]

        sql_text = ""
        for _class in classes:
            class_name = _class["name"]
            print("class_name", class_name)
            
            class_name_lower = class_name.lower()
            class_name_camelcase = class_name[0].upper() + class_name[1:]
            
            utils = Utils()
            folder_name = utils.create_folder(
                class_name, 
                self.package_name, 
                self.source_directory
                )
            
            
            template_filename = self.get_template_filename("Repository")
            
            f = open(template_filename, "r")
            content = f.read()

            content = content.replace("$PACKAGE_NAME$", self.package_name)
            
            content = content.replace("$CLASS_NAME$", class_name_camelcase)
            
            object_name = class_name_lower
            content = content.replace("$OBJECT_NAME$", object_name)
            
            
            attributes = _class["attributes"]
            
            
            pk_attribute_data_type, pk_attribute_name = self.get_pk_data(attributes)
            content = content.replace("$PK_ATTRIBUTE_DATA_TYPE$", pk_attribute_data_type)
            content = content.replace("$PK_ATTRIBUTE_NAME$", pk_attribute_name)
            
            
            # close file to save changes
            jdbc_repository_filename = self.get_jdbc_repository_filename(
                folder_name, 
                class_name_camelcase)
            
            f = open(jdbc_repository_filename, "w")
            f.write(content)
            f.close()
            













    
