#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu May  2 14:40:26 2024

@author: usco
"""

import os
import json

import psycopg2
from psycopg2 import sql


class DataBaseBuilder:
    
    def __init__(self, parameters):
        self.parameters = parameters
        
        self.db_execute = self.parameters["db_execute"]
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
            "boolean":"boolean",
            "double precision": "double"
            }
                
        self.db_postgres = {
            "int":"int",
            "string":"character varying",
            "boolean": "boolean",
            "date":"date",
            "timestamp":"timestamp",
            "double precision": "double precision"
            }

        self.crud_dict = {
            "CREATE":"insert",
            "READ":"select",
            "UPDATE":"update",
            "DELETE":"delete"
            }
        
        
        self.file1 = open("myfile.sql", "w")
        
        self.data = self.get_data()
        
        self.app_name = self.data["app_name"]
        self.db_engine = self.data["db_engine"]
        self.db_host = self.data["db_host"]
        self.db_port = self.data["db_port"]
        self.engine_databasename = self.data["engine_databasename"]
        self.dba_username = self.data["dba_username"]
        self.dba_password = self.data["dba_password"]
        self.app_database_name = self.data["app_database_name"]
        self.app_database_owner = self.data["app_database_owner"]
        self.app_database_password = self.data["app_database_password"]
        
        
    def get_data(self):
        self.f = open(self.model_filename)
        data = json.load(self.f)
        
        return data
    
    
    def get_dba_cursor(self):
        self.dba_conn = psycopg2.connect(
            database=self.engine_databasename,
            host=self.db_host,
            user=self.dba_username,
            password=self.dba_password,
            port=self.db_port)
        
        self.dba_conn.autocommit = True
        
        dba_cursor = self.dba_conn.cursor()
        
        return dba_cursor
    
    
    def get_app_cursor(self):
        self.app_conn = psycopg2.connect(
            database=self.app_database_name,
            host=self.db_host,
            user=self.app_database_owner,
            password=self.app_database_password,
            port=self.db_port)
        
        self.app_conn.autocommit = True
        
        app_cursor = self.app_conn.cursor()
       
        return app_cursor
        
    
    
    def drop_roles(self, data):
        roles = data["roles"]    

        dba_cursor = self.get_dba_cursor()
            
        for role in roles:
            role_username = role["username"]
            
            try:
                sql_text = "DROP ROLE IF EXISTS {};\n".format(role_username)
                sql_string = sql.SQL(sql_text)
                if self.db_execute == True:
                    dba_cursor.execute(sql_text)
                # print(cursor.fetchone())
                self.file1.write(sql_string)
            except:
                print("drop_roles() - Error")
                pass
            
            
            
    def create_roles(self, data):
        roles = data["roles"]    

        dba_cursor = self.get_dba_cursor()
            
        for role in roles:
            role_username = role["username"]
            role_password = role["password"]
            
            try:
                sql_text = "CREATE ROLE {} WITH LOGIN ENCRYPTED PASSWORD '{}';\n"
                sql_text = sql_text.format(role_username, role_password)
                sql_string = sql.SQL(sql_text)
                
                if self.db_execute == True:
                   dba_cursor.execute(sql_string)
                # print(cursor.fetchone())
                self.file1.write(sql_string)
            except:
                print("create_roles() - Error")
                pass



    def drop_database(self):
        dba_cursor = self.get_dba_cursor()
        
        sql_text = "DROP DATABASE IF EXISTS {};\n".format(
            self.app_database_name
            )
        sql_string = sql.SQL(sql_text)
        
        if self.db_execute == True:
            dba_cursor.execute(sql_string)
            
        self.file1.write(sql_text)


    def create_database(self):
        dba_cursor = self.get_dba_cursor()
        
        sql_text = "DROP DATABASE IF EXISTS {};\n".format(
            self.app_database_name
            )
        sql_string = sql.SQL(sql_text)
        
        if self.db_execute == True:
            dba_cursor.execute(sql_text)
        # print(cursor.fetchone())
        self.file1.write(sql_text)
        
        
        sql_text = "CREATE DATABASE {}\n"
        sql_text += " WITH\n"
        sql_text += " OWNER = {}\n"
        sql_text += " ENCODING = 'UTF8'\n"
        sql_text += " TABLESPACE = pg_default\n"
        sql_text += " CONNECTION LIMIT = -1;\n"
        
        sql_text = sql_text.format(
            self.app_database_name,
            self.app_database_owner    
            )
        
        sql_string = sql.SQL(sql_text)
        
        if self.db_execute == True:
            dba_cursor.execute(sql_string)
        # print(cursor.fetchone())
        
        self.file1.write(sql_text)
        
        
    
    def create_tables(self, data):
        classes = data["classes"]
        
        sql_text = ""
        for _class in classes:
            class_name = _class["name"]
            attributes = _class["attributes"]
            
            class_name = class_name.lower()
            
            sql_text += "\n"
            
            sql_text += "DROP TABLE IF EXISTS public.{};\n"
            sql_text = sql_text.format(class_name)
            
            sql_text += "CREATE TABLE IF NOT EXISTS public.{} (\n"
            sql_text = sql_text.format(class_name)
            
            for attribute in attributes:
                attribute_name = attribute["name"]            
                attribute_data_type = attribute["data_type"]   
                attribute_length = attribute["length"]   
                attribute_pk = attribute["pk"]  
                attribute_autoincrement = attribute["autoincrement"]
                
                sql_text +="\t" + attribute_name
                
                if attribute_autoincrement == True:
                    sql_text += " serial"
                else:
                    sql_text += " " + self.db_postgres[attribute_data_type]
                
                if attribute_data_type == "string":
                    sql_text += " (" + str(attribute_length) + ")"
                sql_text += ",\n"
            
            # sql_text = sql_text[:-2]
            # if attribute_pk == "true":
            sql_text += "CONSTRAINT {}_pkey PRIMARY KEY ({})"
            sql_text = sql_text.format(class_name, "id")
            
            
            # print("-"*60)
            relations = _class["relations"]
            
            if len(relations) > 0:
                sql_text += ",\n"
            else:
                sql_text += "\n"
            
            # separador = ""
            for relation in relations:
                # print(relation)
                local_attribute = relation["local_attribute"]
                referenced_table = relation["referenced_table"]
                referenced_attribute = relation["referenced_attribute"]
                
                sql_text += "CONSTRAINT {}_{}_{}_fkey FOREIGN KEY ({})\n"
                sql_text += "\tREFERENCES public.{} ({}) MATCH SIMPLE\n"
                sql_text += "\tON UPDATE NO ACTION\n"
                sql_text += "\tON DELETE NO ACTION,\n"
           
                
                sql_text = sql_text.format(
                    class_name,
                    referenced_table,
                    referenced_attribute,
                    local_attribute,
                    referenced_table,
                    referenced_attribute
                    )
                
            if len(relations) > 0:
                sql_text = sql_text[:-2]
                sql_text += "\n"
               	# separador = ""
            
            sql_text += ")\n"
            sql_text += "WITH (\n"
            sql_text += "OIDS=FALSE\n"
            sql_text += ");\n"
        
        
            sql_text += "ALTER TABLE IF EXISTS public.{}\n"
            sql_text += " OWNER TO {};\n"
        
            sql_text = sql_text.format(
                class_name,
                self.app_database_owner   
            )
            
            # print(sql_text)
            
            
            # print("-"*60)
            grants = _class["grants"]
            
            for grant in grants:
                # username = grant[]
                username = list(grant.keys())[0]
                permissions = grant[username]
                for perm in permissions:
                    # for username, permissions in grants.items():
                   grant_list = ", ".join(self.crud_dict[perm] for perm in permissions)
                
                sql_text += "GRANT {} ON TABLE {} TO {};\n".format(
                    grant_list, 
                    class_name, 
                    username)
                
        
        # end for loop
        sql_string = sql.SQL(sql_text)
        
        app_cursor = self.get_app_cursor()
        
        if self.db_execute == True:
            app_cursor.execute(sql_string)    
        
        # L = ["This is Delhi \n", "This is Paris \n", "This is London \n"]
         
        # \n is placed to indicate EOL (End of Line)
        self.file1.write(sql_text)




    
    def build(self):
        self.file1 = open("myfile.sql", "w")
        
        self.drop_roles(self.data)     
        
        self.create_roles(self.data)        
        
        self.drop_database()
        
        self.create_database()
        
        self.create_tables(self.data)
        
        # file1.writelines(L)
        self.file1.close()  # to change file access modes
         
        # # Closing file
        self.f.close()
        
        self.app_conn.close()
        self.dba_conn.close()
        
            
            