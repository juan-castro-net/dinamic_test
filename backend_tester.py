#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri May  3 13:15:11 2024

@author: usco
"""

import os
import requests
import json
import random
import datetime as dt


class BackendTester:
    
    # def __init__(self):
    #     pass
    def __init__(self, parameters):
        self.parameters = parameters
        
        # self.base_path = self.parameters["base_path"]
        self.source_directory = self.parameters["source_directory"]
        
        # self.package_name = self.parameters["package_name"]
        self.model_filename = self.parameters["model_filename"]
        
        self.test_file = open("test_log.txt", "w")
        
        
    
    def get_data(self):
        f = open(self.model_filename)
        data = json.load(f)
        
        return data
    
    def get_json_data(self, _class, counter, references):
        attributes = _class["attributes"]
        
        data = "{"
        separador = ""
        for attribute in attributes:
            attribute_name = attribute["name"]            
            attribute_data_type = attribute["data_type"]   
            attribute_length = attribute["length"]   
            attribute_pk = attribute["pk"]  
            attribute_fk = attribute["fk"] 
            # attribute_autoincrement = attribute["autoincrement"]
            
            if attribute_pk == False:
                # name = attribute["name"]
                if attribute_data_type == "string":
                    value = attribute_name[0].upper() + attribute_name[1:] + " " + str(counter)
                    value = value[:attribute_length]
                    value = "\"" + value + "\""
                elif attribute_data_type == "int":
                    value = str(random.randint(1,10))
                elif attribute_data_type == "boolean":
                    value = "true" 
                elif attribute_data_type == "date":
                    date1 = dt.datetime.now()
                    date0 = date1.date()
                    value = str(date0)  
                    value = "\"" + value + "\""
                elif attribute_data_type == "timestamp":
                    date1 = dt.datetime.now()
                    value = str(date1)
                    value = value.replace(" ", "T")
                    value = "\"" + value + "\""
                
                
                if attribute_fk == True:
                    _id_list = references[attribute_name]
                    value = str(random.choice(_id_list))
                
                attribute_name = "\"" + attribute_name + "\""
                
                data += separador + attribute_name + ":" + value
                separador = ","
        data += "}"
        
        return data


    def create(self, url, data):
        headers = {'Content-type': 'application/json'}
        response = requests.post(
            url,
            data=data,
            headers=headers
            )
        
        if response.status_code == 201:
            success = True
        else:
            success = False
            
        # print("Response", success, response.status_code)
        self.test_file.write("Response" + "," + str(success) + "," + str(response.status_code) + "\n")
        
        return success

    def read(self, url):
        try:
            response = requests.get(url)
            # print("Status code: ", response.status_code)
            self.test_file.write("Status code: " + str(response.status_code) + "\n")
            json_items = response.json()
            # print(json_items)
        except:
            json_items = []
            
        return json_items



    def update(self, url, data):
        headers = {'Content-type': 'application/json'}
        response = requests.put(
            url,
            data=data,
            headers=headers
            )
        
        if response.status_code == 201:
            success = True
        else:
            success = False
            
        # print("Response", success, response.status_code)
        self.test_file.write("Response" + "," + str(success) + "," + str(response.status_code) + "\n")
        
        return success



    def delete(self, url):
        response = requests.delete(url)
        
        if response.status_code == 201:
            success = True
        else:
            success = False
            
        # print("Response", success, response.status_code)
        self.test_file.write("Response" + "," + str(success) + "," + str(response.status_code) + "\n")
        
        return success
    
    
    
    def test(self):
        data = self.get_data()
        
        classes = data["classes"]

        test_rows = 10

        number_of_classes = len(classes)
        create_test_pass = 0
        read_test_pass = 0
        update_test_pass = 0
        delete_test_pass = 0
        
        for _class in classes:
            class_name = _class["name"]
            
            relations =  _class["relations"]
            
            references = {}
            for relation in relations:
                local_attribute = relation["local_attribute"]
                referenced_table = relation["referenced_table"]
                referenced_attribute = relation["referenced_attribute"]
                
                theUrl = "http://localhost:8080/test/api/" + referenced_table
                items = self.read(theUrl)
                # print(type(items), len(items))
                # print(items)
                
                _id_list = []
                for item in items:
                    _id = item[referenced_attribute]
                    _id_list.append(_id)
                # print(_id_list)
                references[local_attribute] = _id_list
            
            # if len(relations) > 0:
            #     print(references)
              
              
              
              
            
            theUrl = "http://localhost:8080/test/api/" + class_name
            print(theUrl)
            self.test_file.write("theUrl: " + theUrl + "\n")
            
            try:
                items = self.read(theUrl)
                initial_number_of_rows = len(items)
            except:
                initial_number_of_rows = 0
            
            print("read", len(items))
            self.test_file.write("INITIAL NUMBER OF ROWS: " + str(initial_number_of_rows) + "\n")
            
            
            
            
            
            #------------------------------------------------------------
            # START CREATE
            #------------------------------------------------------------
            self.test_file.write("\n\n\n")
            self.test_file.write("CREATE TEST\n")
            # print()
            # print("create")
            # self.test_file.write("\n")
            # self.test_file.write("create\n")
            
            for counter in range(1, test_rows+1):
                
                data = self.get_json_data(
                    _class, 
                    counter,
                    references
                    )
                
                # print(theUrl)
                # print(data)
                self.test_file.write(theUrl + "\n")
                self.test_file.write(str(data) + "\n")
                response = self.create(theUrl, data)
                # print(response)
                self.test_file.write(str(response) + "\n")
                
                
            items = self.read(theUrl)
            create_number_of_rows = len(items)
            # print("read", len(items))
            self.test_file.write("\n\n")
            self.test_file.write("INITIAL NUMBER OF ROWS: " + str(initial_number_of_rows) + "\n")
            self.test_file.write("CREATE NUMBER OF ROWS AFTER CREATE: " + str(create_number_of_rows) + "\n")
            
            if (initial_number_of_rows+test_rows) == create_number_of_rows:
                create_test = 1
            else:
                create_test = 0
            
            self.test_file.write("create_test: " + str(create_test) + "\n")
            # END CREATE    
                
            
            
            
            
            #------------------------------------------------------------
            # START READ
            #------------------------------------------------------------
            self.test_file.write("\n\n\n")
            self.test_file.write("READ TEST\n")
            
            items = self.read(theUrl)
            number_of_rows = len(items)
            
            if number_of_rows == 0:
                # print("No hay datos")
                self.test_file.write("No hay datos" + "\n")
                continue
            
            # print()
            # print("read", len(items))
            # print(items)
            self.test_file.write("\n\n")
            self.test_file.write("number_of_rows: " + str(number_of_rows) + "\n")
            
            datas = str(items)
            datas = datas.replace("[", "[\n")
            datas = datas.replace("},", "},\n")
            datas = datas.replace("]", "]\n\n")
            
            self.test_file.write(datas)
            
            last_row = items[-1:][0]
            _id = last_row["id"]
            # print(_id)
            self.test_file.write("last_row _id: " + str(_id) + "\n")
            
            if number_of_rows > 0:
                read_test = 1
            else:
                read_test = 0
                
            self.test_file.write("read_test: " + str(read_test) + "\n")
            # END READ
            
            
            
            
            
            #------------------------------------------------------------
            # START UPDATE
            #------------------------------------------------------------
            self.test_file.write("\n\n\n")
            self.test_file.write("UPDATE TEST\n")
            
            original_row = items[-1:][0]
            
            updateUrl = theUrl + "/" + str(_id)
            # print(updateUrl)
            self.test_file.write(updateUrl + "\n")
            
            # data = data.replace(str(test_rows), "000")
            data = self.get_json_data(
                _class, 
                0,
                references
                )
            
            response = self.update(updateUrl, data)
            
            items = self.read(theUrl)
            last_row = items[-1:][0]
            
            # print()
            # print("read", last_row)
            self.test_file.write("\n\n")
            self.test_file.write("updata original_row: " + str(original_row) + "\n")
            self.test_file.write("updata last_row: " + str(last_row) + "\n")
            
            if original_row != last_row:
                update_test = 1
            else:
                update_test = 0
                
            self.test_file.write("update_test: " + str(update_test) + "\n")
            # END UPDATE
            
            
            
            
            #------------------------------------------------------------
            # START DELETE
            #------------------------------------------------------------
            self.test_file.write("\n\n\n")
            self.test_file.write("DELETE TEST\n")
            
            items = self.read(theUrl)
            number_of_rows = len(items)
            # print("count rows: ", count_items)
            
            self.test_file.write("number_of_rows: " + str(number_of_rows) + "\n")
            
            deleteUrl = theUrl + "/" + str(_id)
            response = self.delete(deleteUrl)
            
            items = self.read(theUrl)
            number_of_rows_after_delete = len(items)
            # print("count rows: ", count_items)
            self.test_file.write("number_of_rows_after_delete: " + str(number_of_rows_after_delete) + "\n")
            # print(data)
            
            if number_of_rows > number_of_rows_after_delete:
                delete_test = 1
            else:
                delete_test = 0
            
            self.test_file.write("delete_test: " + str(delete_test) + "\n")
            # END DELETE
            
            # print("-"*60)
            self.test_file.write("------------------------------" + "\n")
            self.test_file.write("\n\n\n")
        
            create_test_pass += create_test
            read_test_pass += read_test
            update_test_pass += update_test
            delete_test_pass += delete_test 
        
        number_of_classes = len(classes)
        
        self.test_file.write("number_of_classes: " + str(number_of_classes) + "\n")
        
        self.test_file.write("create_test_pass: " + str(create_test_pass) + "\n")
        self.test_file.write("read_test_pass: " + str(read_test_pass) + "\n")
        self.test_file.write("update_test_pass: " + str(update_test_pass) + "\n")
        self.test_file.write("delete_test_pass: " + str(delete_test_pass) + "\n")
        
        
        self.test_file.close()
            
       
        
       
        
       
parameters = {}

parameters["source_base_directory"] = "/home/server2/Documents/dinamic_test"
parameters["source_directory"] = os.path.join(
    parameters["source_base_directory"],
    "test"
    )


parameters["model_directory"] = "/home/server2/Documents/dinamic_test"
parameters["model_name"] = "pruebas1.json"

parameters["model_filename"] = os.path.join(
    parameters["model_directory"],
    parameters["model_name"]
    )


backend_tester =  BackendTester(parameters)
backend_tester.test()













# json_response = response.json()
# print(json_response)

    
# import os
# command = "curl -X POST http://localhost:8080/api/tutorials -H 'Content-Type: application/json' -d '{"title":"Title 1","description":"Description 1", "published":true}'"
# os.system(command)



# theUrl = "http://localhost:8080/api/tutorials"



# len(json_items)