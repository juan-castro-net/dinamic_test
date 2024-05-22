#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu May  2 13:59:17 2024

@author: usco
"""

import os

from database_builder import DataBaseBuilder

from application_properties_builder import ApplicationPropertiesBuilder
from application_builder import ApplicationBuilder
from model_builder import ModelBuilder
from repository_builder import RepositoryBuilder
from jdbc_repository_builder import JdbcRepositoryBuilder
from controller_builder import ControllerBuilder

from backend_tester import BackendTester


parameters = {}

parameters["db_execute"] = True
<<<<<<< HEAD
parameters["base_directory"] = "/home/server2/Documents/dinamic_test"
    

parameters["source_base_directory"] = "/home/server2/Documents/dinamic_test"
=======
# parameters["base_directory"] = "/home/usco/Documents/test/pruebas"
parameters["base_directory"] = "/home/usco/dinamic_test/"

    
parameters["source_base_directory"] = "/home/usco/Documents/workspace-sts"
>>>>>>> 9f28555 (v1)
parameters["source_directory"] = os.path.join(
    parameters["source_base_directory"], 
    "agro"
    )


<<<<<<< HEAD
parameters["model_directory"] = "/home/server2/Documents/dinamic_test"
=======
parameters["model_directory"] = "/home/usco/dinamic_test/agro"
>>>>>>> 9f28555 (v1)
parameters["model_name"] = "pruebas1.json"

parameters["model_filename"] = os.path.join(
    parameters["model_directory"],
    parameters["model_name"]
    )

database_builder = DataBaseBuilder(parameters)
database_builder.build()

application_properties_builder = ApplicationPropertiesBuilder(parameters)
application_properties_builder.build()

application_builder = ApplicationBuilder(parameters)
application_builder.build()

model_builder = ModelBuilder(parameters)
model_builder.build()

repository_builder = RepositoryBuilder(parameters)
repository_builder.build()

jdbc_repository_builder = JdbcRepositoryBuilder(parameters)
jdbc_repository_builder.build()

controller_builder = ControllerBuilder(parameters)
controller_builder.build()

os.chdir(parameters["source_directory"])
os.system("mvn clean install") 
os.system("mvn spring-boot:run") 

backend_tester = BackendTester(parameters)
backend_tester.test()


# import subprocess
# command = "cd"
# subprocess.run([command, "/media/usco/data1/dev/workspace-sts/test"]) 
# command = "mvn"
# # pom_filename = "/media/usco/data1/dev/workspace-sts/test/pom.xml"
# pom_filename = "pom.xml"
# subprocess.run([command, "spring-boot:run", pom_filename]) 




<<<<<<< HEAD
=======


import os

os.chdir("/home/usco/Documents/workspace-sts/agro")
# os.system("cd /media/usco/data1/dev/workspace-sts/test") 


# os.system("mvn clean install") 

# os.system("mvn clean pom.xml")
os.system("mvn spring-boot:run") 





















>>>>>>> 9f28555 (v1)


