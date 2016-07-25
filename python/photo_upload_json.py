import sys

import nviso_api
from nviso_api import *
import json, ast

# Define the different parameters
file = "./data/dataPhoto/happy.jpg"
format = "v2-Full"
distance = "near"
multiple_faces = False
x_min = 0
x_max = 1
y_min = 0
y_max = 1
app_id = "AppId"
app_key = "AppKey"

# Use the class PhotoApi
photo_api = PhotoApi()

# Make the call
response = photo_api.photo_process_upload(file, format=format, distance=distance, multiple_faces=multiple_faces, x_min=x_min, x_max=x_max, y_min=y_min, y_max=y_max, app_id=app_id, app_key=app_key)

# Transform the response into a dictionary
json_dic = ast.literal_eval(response)

# Print the dictionnary
print json.dumps(json_dic)
