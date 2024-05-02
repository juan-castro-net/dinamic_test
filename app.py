#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu May  2 13:59:17 2024

@author: usco
"""

import os

from database_builder import DataBaseBuilder

from application_builder import ApplicationBuilder
from model_builder import ModelBuilder
from repository_builder import RepositoryBuilder
from jdbc_repository_builder import JdbcRepositoryBuilder
from controller_builder import ControllerBuilder

    
parameters = {}
parameters["model_name"] = "pruebas1.json"
parameters["db_execute"] = True
parameters["base_directory"] = "/home/usco/Documents/test/pruebas"
    # parameters["base_directory"],
parameters["base_path"] = os.path.join(
    "/home/usco/Documents/workspace-spring-tool-suite-4-4.20.0.RELEASE"
    "test"
    )
# parameters["package_name"] = "org.usco.test"
parameters["model_filename"] = os.path.join(
    parameters["base_directory"],
    "pruebas2",
    parameters["model_name"]
    )



# database_builder = DataBaseBuilder(parameters)
# database_builder.build()

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



