#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Apr 29 07:34:11 2024

@author: usco
"""

# from sqlalchemy import create_engine
# from sqlalchemy import text

import psycopg2
from psycopg2 import sql
from pandas import DataFrame

class DBPostgres:
    def __init__(self, parameters):
        self.parameters = parameters
        # self.parameters["db_engine"] 
        # self.parameters["db_name"]
        # self.parameters["db_user"]
        # self.parameters["db_password"]
        # self.parameters["db_host"]
        # self.parameters["db_port"]
               
    def get_url_connection(self):
        url_connection = self.parameters["db_engine"] 
        url_connection += "://" + self.parameters["db_user"]
        url_connection += ":" + self.parameters["db_password"]
        url_connection += "@" + self.parameters["db_host"]
        url_connection += ":" + str(self.parameters["db_port"])
        url_connection += "/" + self.parameters["db_name"]
        
        # print(self.parameters)
        # print(url_connection)
        
        return url_connection
        
        
    def getConnection(self):
        # create connection 
        # url_connection = self.get_url_connection()
        # engine = create_engine(url_connection)
        # conn = engine.connect()
        
        conn = psycopg2.connect(
            database=self.parameters["db_name"],
            host=self.parameters["db_host"],
            user=self.parameters["db_user"],
            password=self.parameters["db_password"],
            port=self.parameters["db_port"])

        # conn.autocommit = True
        conn.autocommit = True
        
        return conn

    def execute(self, sql_text):
        # execute query
        conn = self.getConnection()
        cursor = conn.cursor()
        # sql = text(sql_text)   
        sql_string = sql.SQL(sql_text)
        
        result = cursor.execute(sql_string)
        
        # print(result)
        
        return result