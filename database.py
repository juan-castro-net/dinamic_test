#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Apr 29 07:30:06 2024

@author: usco
"""

from db_postgres import DBPostgres

class DataBase:
    
    def __init__(self, parameters):
        self.parameters = parameters
        
        if self.parameters["db_engine"]  == "postgresql":
            self.db = DBPostgres(parameters)
        
    
    def create_role(self, data):
        username = data["username"]
        password = data["password"]
        sql = "CREATE ROLE {} WITH LOGIN ENCRYPTED PASSWORD '{}';"
        sql = sql.format(
            username,
            password)
        print("sql:", sql)
        result = self.db.execute(sql)
        # ecommerce WITH LOGIN ENCRYPTED PASSWORD 'ecommerce';
        print(result)
    
    
    def create_database(self, data):
        db_name = data["db_name"]
        db_owner = data["db_owner"]
        
        sql = "CREATE DATABASE {}"
        sql += " WITH"
        sql += " OWNER = {}"
        sql += " ENCODING = 'UTF8'"
        sql += " TABLESPACE = pg_default"
        sql += " CONNECTION LIMIT = -1;"
        sql = sql.format(
            db_name, 
            db_owner
            )
        
        print(sql)
        
        result = self.db.execute(sql)
        print(result)
        

    def create_table(self, data):
        CREATE TABLE categories (
        id bigserial NOT NULL,
        published integer NOT NULL DEFAULT '0',
        name varchar (255) NOT NULL,
        icon varchar (255) NOT NULL,
        created_at timestamp without time zone DEFAULT now (),
        updated_at timestamp without time zone DEFAULT now (),
        CONSTRAINT categories_pkey PRIMARY KEY (id)
        )
        WITH (
        OIDS=FALSE
        );
        ALTER TABLE public.categories
        OWNER TO ecommerce;




parameters = {}

parameters["db_engine"] = "postgresql"
parameters["db_name"] = "postgres"
parameters["db_user"] = "postgres"
parameters["db_password"] = "ia2023"
parameters["db_host"] = "localhost"
parameters["db_port"] = 5432
 
 
database = DataBase(parameters) 
 
data = {} 
data["username"] = "prueba2"
data["password"] = "prueba2"
database.create_role(data)
    
data = {}
data["db_name"] = "prueba2"
data["db_owner"] = "prueba2"
database.create_database(data)
    
    
 
 
# import psycopg2
# from psycopg2 import sql


# conn = psycopg2.connect(database=parameters["db_name"],
#                         host=parameters["db_host"],
#                         user=parameters["db_user"],
#                         password=parameters["db_password"],
#                         port=parameters["db_port"])

# conn.autocommit = True
# cursor = conn.cursor()

# sql_string = sql.SQL("CREATE ROLE prueba WITH LOGIN ENCRYPTED PASSWORD 'prueba';")
# cursor.execute(sql_string)
# print(cursor.fetchone())



# sql_string = sql.SQL("CREATE DATABASE prueba WITH OWNER = prueba ENCODING = 'UTF8' TABLESPACE = pg_default CONNECTION LIMIT = -1;")
# cursor.execute(sql_string)
# print(cursor.fetchone())

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 