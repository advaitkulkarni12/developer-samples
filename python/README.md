# Client library for Python

This library is used to communicate with nViso API. In this file, you will find the examples of each of the possible endpoints.

## Requirements.
Python 2.7 and later.

Python libraries:
- urllib3 (>=1.10)
- six (>=1.9)
- certifi
- python-dateutil

## Installation & Usage

You can install the package using [Setuptools](http://pypi.python.org/pypi/setuptools).

```sh
python setup.py install --user
```
(or `sudo python setup.py install` to install the package for all users)

This step is **not** mandatory. 

Then, you need to import the package in any file where you need it:
```python
import nviso_api
```

## Getting Started

Please follow the [installation procedure](#installation--usage) and then run the following:
```python
import nviso_api
from nviso_api import *

monitoring_api = MonitoringApi()
try:
    response = monitoring_api.health()
    print response
except ApiException as e:
    print "Exception when calling Monitoring->health: %s\n" % e
```
If you get the following response from this code: `{'info': 'All the workers responded to the PING.'}` It means that the API is working fine.

## Samples

We provide two examples so that you can get an idea of how to use the API:
- photo_upload_json.py shows how to process a .jpg photo using photo_process_upload method. The program then prints the result in json format.

- stream_upload_json.py starts a session, processes a stream of 27 photos and finally performs a query. It again prints the result in json format.

In order to run these programs, open a command prompt window in the directory where the files are located and type :
```shell
python program_name.py
## How to use

In the next section [Documentation for API Endpoints](#documentation-for-api-endpoints), you will find all the endpoints you can use. If you click on the link, it will redirect you to a page where you will find a small explanation, a very simple example and all the parameters. 

If you're just looking for some simple example, you can find them in the folder [*examples*](./examples). They are here just to show what you can do with the API. The examples are basic.

## Documentation for API Endpoints
All URls are relative to http://127.0.0.1:8080/nviso/api/v2

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
[*MonitoringApi*](./docs/MonitoringApi.md#) | [**health**](./docs/MonitoringApi.md#health) | **GET** /monitoring/health | Check the health of each of the workers
[*PhotoApi*](./docs/PhotoApi.md#) | [**photo_process_url**](./docs/PhotoApi.md#photo_process_url) | **GET** /photo/process/url | Process a photo given its url. Returns a JSON
[*PhotoApi*](./docs/PhotoApi.md#) | [**photo_process_upload**](./docs/PhotoApi.md#photo_process_upload) | **POST** /photo/process/upload | Process a photo taken on the computer. Returns a JSON
[*PhotoApi*](./docs/PhotoApi.md#) | [**photo_process_base64**](./docs/PhotoApi.md#photo_process_base64) | **POST** /photo/process/base64 | Process a photo using a Base 64 encoded string. Returns a JSON
[*PhotoApi*](./docs/PhotoApi.md#) | [**photo_render_url**](./docs/PhotoApi.md#photo_render_url) | **GET** /photo/render/url | Process a photo given its url. Returns a rendered image.
[*PhotoApi*](./docs/PhotoApi.md#) | [**photo_render_upload**](./docs/PhotoApi.md#photo_render_upload) | **POST** /photo/render/upload | Process a photo taken on the computer. Returns a rendered image.
[*PhotoApi*](./docs/PhotoApi.md#) | [**photo_render_base64**](./docs/PhotoApi.md#photo_render_base64) | **POST** /photo/render/upload | Process a photo using a Base 64 encoded string. Returns a rendered image.
[*StreamApi*](./docs/StreamApi.md#) | [**stream_session_start**](./docs/StreamApi.md#stream_session_start) | **POST** /stream/session/start | Start the session for the processing of the sequence of images
[*StreamApi*](./docs/StreamApi.md#) | [**stream_process_url**](./docs/StreamApi.md#stream_process_url) | **GET** /stream/process/url| Process an image given its url. Returns a JSON and also store it for later. 
[*StreamApi*](./docs/StreamApi.md#) | [**stream_process_upload**](./docs/StreamApi.md#stream_process_upload) | **POST** /stream/process/upload | Process an image taken on the computer. Returns a JSON and also store it for later. 
[*StreamApi*](./docs/StreamApi.md#) | [**stream_process_base64**](./docs/StreamApi.md#stream_process_base64) | **POST** /stream/process/stream | Process an image using a Base 64 encoded string. Returns a JSON and also store it for later. 
[*StreamApi*](./docs/StreamApi.md#) | [**stream_session_end**](./docs/StreamApi.md#stream_session_end) | **GET** /stream/session/end | End the session
[*StreamApi*](./docs/StreamApi.md#) | [**stream_session_query**](./docs/StreamApi.md#stream_session_query) | **GET** /stream/session/query | Query the results of a given session
[*StreamApi*](./docs/StreamApi.md#) | [**stream_session_data**](./docs/StreamApi.md#stream_session_data) | **GET** /stream/session/data | Query the results in a CSV format
[*StreamApi*](./docs/StreamApi.md#) | [**stream_session_graph**](./docs/StreamApi.md#stream_session_graph) | **GET** /stream/session/graph | Query the results in a graph format
[*StreamApi*](./docs/StreamApi.md#) | [**stream_session_list**](./docs/StreamApi.md#stream_session_list) | **GET** /stream/session/list | List information about the session given an ID

## Documentation For Models

 - [Key](docs/Key.md)
 - [ResponseServer](docs/ResponseServer.md)

## Documentation For Authorization

 All endpoints do not require authorization.

## Author

info@nviso.ch


