#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Apr 30 14:28:07 2024

@author: usco
"""

import os
import json


base_path = "/home/usco/Documents/test/pruebas/pruebas"
package_name = "org.usco.test"


data_dict = {
    "int": "int",
    "string":"String",
    "date":"Date",
    "timestamp":"TimeStamp",
    "boolean":"boolean"
    }


model_filename = "/home/usco/Documents/test/pruebas/pruebas2/pruebas1.json"
f = open(model_filename)
data = json.load(f)
 
# print(data)


classes = data["classes"]

sql_text = ""
for _class in classes:
    class_name = _class["name"]
    print("class_name", class_name)
    

    folder_name = os.path.join(
        base_path,
        "src",
        package_name,
        class_name.lower(),
        "model"
        )

    if os.path.exists(folder_name) == False:
        # Create the directory 'ihritik'
        os.makedirs(folder_name)
        # print("Directory '%s' created" % directory)



    f = open("/home/usco/Documents/test/pruebas/pruebas/templates/Model.java", "r")
    content = f.read()

    class_name = class_name[0].upper() + class_name[1:]
    content = content.replace("$CLASS_NAME$", class_name)


    model_filename = os.path.join(
        folder_name,
        class_name + ".java"
        )
        
    
    
    attributes = _class["attributes"]
    print(attributes)
    
    
    
    # sql_text += "CREATE TABLE {} (\n"
    # sql_text = sql_text.format(class_name)
    attribute_list = ""
    indentation = ""
    for attribute in attributes:
        attribute_name = attribute["name"]            
        attribute_data_type = attribute["data_type"]   
        
        attribute_data_type = data_dict[attribute_data_type]
        
        attribute_text = indentation + "private {} {};\n".format(
            attribute_data_type,
            attribute_name
            )
        attribute_list += attribute_text
        indentation = "\t"
    content = content.replace("$ATTRIBUTE_LIST$", attribute_list)
    
    
    
    
    this_attribute_list = ""
    indentation = ""
    for attribute in attributes:
        attribute_name = attribute["name"]            
        attribute_data_type = attribute["data_type"]   
        
        attribute_text = indentation + "this.{} = {};\n".format(
            attribute_name,
            attribute_name
            )
        this_attribute_list += attribute_text
        indentation = "\t\t"
    content = content.replace("$THIS_ATTRIBUTES$", this_attribute_list)
    
    
    
    
    # $THIS_ATTRIBUTES_NOT_ID$
    
    
    this_attribute_not_id_list = ""
    indentation = ""
    for attribute in attributes:
        attribute_name = attribute["name"]            
        attribute_data_type = attribute["data_type"]   
        attribute_pk = attribute["pk"]  
        
        if attribute_pk == False:
            attribute_text = indentation + "this.{} = {};\n".format(
                attribute_name,
                attribute_name
                )
            this_attribute_not_id_list += attribute_text
            indentation = "\t\t"
            
    content = content.replace("$THIS_ATTRIBUTES_NOT_ID$", this_attribute_not_id_list)
    
    
    
    
    # $GETTER_AND_SETTER$
    getter_and_setter = ""
    indentation = ""
    for attribute in attributes:
        attribute_name = attribute["name"]            
        attribute_data_type = attribute["data_type"]   
        
        attribute_data_type = data_dict[attribute_data_type]
        
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
    content = content.replace("$GETTER_AND_SETTER$", getter_and_setter)
    
    
    
    # $PARAMETERS$
    parameters = ""
    indentation = ""
    for attribute in attributes:
        attribute_name = attribute["name"]            
        attribute_data_type = attribute["data_type"]   
        
        attribute_data_type = data_dict[attribute_data_type]
        
        parameters += indentation + attribute_data_type + " " + attribute_name
        
        indentation = ", "
    content = content.replace("$PARAMETERS$", parameters)
    
    
    # $PARAMETERS_NOT_ID$
    # $PARAMETERS$
    parameters_not_id = ""
    indentation = ""
    for attribute in attributes:
        attribute_name = attribute["name"]            
        attribute_data_type = attribute["data_type"]   
        attribute_pk = attribute["pk"]  
        
        
        attribute_data_type = data_dict[attribute_data_type]
        
        if attribute_pk == False:
            parameters_not_id += indentation + attribute_data_type + " " + attribute_name
            
            indentation = ", "
    content = content.replace("$PARAMETERS_NOT_ID$", parameters_not_id)
    
    
    
    
    # $TO_STRING$
    

    to_string = "\"{} [".format(class_name)
    indentation = ""
    separator = ""
    for attribute in attributes:
        attribute_name = attribute["name"]    
        to_string += separator + "{}=\" + {}".format(attribute_name,attribute_name)   
        separator = " + \", "
    to_string += " + \"]\";"    
        
        
        # return "$CLASS_NAME$ [id=" + id + ", pais=" + pais + ", nombre=" + nombre + ", acronimo=" + acronimo + "]";
        

            
        # indentation = ", "
    content = content.replace("$TO_STRING$", to_string)
    
    

	
    
    
    
    
    
    
    
    f = open(model_filename, "w")
    f.write(content)
    f.close()
    


# class_name = "Municipio"


