# Client library for java gui

This library enables to use the java API embedded in a GUI

## Requirements

To run the application you will the Java JRE 1.7 or higher installed. 
http://www.oracle.com/technetwork/java/javase/downloads/jre7-downloads-1880261.html

## Installation
This project was initially built using Eclipse Neon, but you can build it anyway you want. Note the main function is in the file
NVisoGuiMainFrame.java.

## Getting started
Using Eclipse, you can run the project by right clicking on the file NVisoGuiMainFrame.java -> RunAs -> Java Application.
This will open the window application.
We povide a runnable file NVisoGUI.jar which can be executed using the following command :
```shell
java -jar NVisoGui.jar SESSION_ID SESSION_KEY
```
where SESSION_ID and SESSION_KEY are optional paramters indication the id and key of the session.


## How to use
The interface is very easy tu use, it contains 3 buttons :
- SELECT FOLDER which enables you to upload the folder containing the files you want to process (only selects files with .jpg, .jpeg or .png extension).
Once you have selected a set a files, they are displayed in a tab and are marked as "Not processed". You can click on a file to display the corresponding image.
- PROCESS which enables you to process all the files currently loaded. This is done asynchronously and you can observe the work progression in the progress bar.
Once the processing for a file is finished, it is marked as "Processing OK" or "Processing failed" depending on wether the processing has succeeded or failed.
The images for which the processing succeeded are displayed with red dots corresponding to the landmarks used during the processing. Just under the image
is displayed the json returned by the process.
- EXTRACT which enables you to upload the processing results in a file in csv format.
By clicking on select you can specify a folder to process. The application will search all image
files in that folder with extension .jpg, .jpeg, or .png. It will then process the images and you can export the results as
a CSV file.



## Author

info@nviso.ch
