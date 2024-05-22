#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu May  2 09:05:47 2024

@author: usco
"""

import os
import json

from utils import Utils

class ApplicationBuilder:
    
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
            "timestamp":"Timestamp",
            "double precision":"double",
            "boolean":"boolean",
            }

    
    
    def get_app_filename(self, folder_name, class_name):
        model_filename = os.path.join(
            folder_name,
            "{}Application.java".format(class_name)
            )
        
        return model_filename
    
    

    # def create_folder(self):
        
    #     folder_name = os.path.join(
    #         self.base_path,
    #         "src",
    #         "main",
    #         "java",
    #         self.package_name
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
        f = open(self.model_filename)
        data = json.load(f)
        
        return data
        
    
    def build(self):
        data = self.get_data()
        
        # classes = data["classes"]

        app_name = data["app_name"]
    
        app_name_camelcase = app_name[0].upper() + app_name[1:]
        # app_name_lower = app_name.lower()
        
        # folder_name = self.create_folder()
        utils = Utils()
        folder_name = utils.create_folder(
            "", 
            self.package_name, 
            self.source_directory
            )
        
        template_filename = self.get_template_filename("Application")
        f = open(template_filename, "r")
        content = f.read()

        
        # $PACKAGE_NAME$
        content = content.replace("$PACKAGE_NAME$", self.package_name)
        
        # $CLASS_NAME$
        content = content.replace("$CLASS_NAME$", app_name_camelcase)
        

        # close file to save changes
        app_filename =  self.get_app_filename(
            folder_name, 
            app_name_camelcase
            )
        
        f = open(app_filename, "w")
        f.write(content)
        f.close()
            
    
    
    