import sys

import nviso_api
from nviso_api import *
import json, ast

# Use the class PhotoApi
stream_api = StreamApi()

# Start session
sessionId = "sessionId"
data = "{\"info\": \"Test for example\"}"
app_id = "AppId"
app_key = "AppKey"
#sessionKey = stream_api.stream_session_start(sessionId, data, app_id=app_id, app_key=app_key)
key = stream_api.stream_session_start(id="nViso-Test", data="{\"info\": \"Test for example\"}").session_key


# Define the different parameters
score = None
time = None
timestamp = None
format = "v2-Full"
distance = "near"
multiple_faces = False
x_min = 0
x_max = 1
y_min = 0
y_max = 1

for i in range(1):
    filename = ""
    if i < 10:
        file = "./data/dataStream/RID_105440_00" + str(i) + ".jpg";
    else:
        file = "./data/dataStream/RID_105440_0" + str(i) + ".jpg";
    response_i = stream_api.stream_process_upload(file, key, format=format, distance=distance, multiple_faces=multiple_faces, x_min=x_min, x_max=x_max, y_min=y_min, y_max=y_max, app_id=app_id, app_key=app_key)

stream_api.stream_session_end(key, app_id=app_id, app_key=app_key)

# Perform query
query_format = "v2-Full"
sort_by = "timestamp"
limit_by = "timestamp"
start_limit = 0
end_limit = 2000000000
order = "ascending"
response = stream_api.stream_session_query(key, query_format=query_format, sort_by=sort_by, limit_by=limit_by, start_limit=start_limit, end_limit=end_limit, order=order, app_id=app_id, app_key=app_key)

# Transform the response into a dictionary
json_dic = ast.literal_eval(response)

# Print the dictionnary
print json.dumps(json_dic)
