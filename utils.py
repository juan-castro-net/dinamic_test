#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri May  3 10:29:31 2024

@author: usco
"""

import os


class Utils:
    
    def __init__(self):
        pass
    
    
    def create_folder(self, class_name, package_name, source_directory):
        
        folders = package_name.split(".")
        
        if len(class_name) > 0:
            folders.append(class_name.lower())
        
        folder_name = os.path.join(
            source_directory,
            "src",
            "main",
            "java"
            )
        
        for folder in folders:
            folder_name = os.path.join(
                folder_name,
                folder
            )
        
            if os.path.exists(folder_name) == False:
                os.makedirs(folder_name)
        
        return folder_name