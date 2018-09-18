# OpJdataURL
This piece of software can combine multiple csv/xls/xlsx files into one Google Sheet depending on the ranges the user defined for each file.

the user must define

-title [optional] The title the new sheet will have. This will be also printed on header of the new sheet. If not supplied a 
default value (opj followed by the current date) will be used  
-github [optional] A link to a github page  
-author	me [optional] The name of the author  
-auth [optional] a folder where the authentication file will be stored. If not used the new file will be created on a default user  
-folder [optional] The Google Drive folder under where the new file will be stored  
-share [optional] If used the new file will be shared with anyone with a link. If not used and no user authentication is supplied, the new file will not be available to you.  
  
[The following block is multiple accepted for multiple files]  
-file The local path to the file  
-range A range from the above file to be copied. For multiple ranges repeat the option or combine with with /. ie -range A1:B2 -range A3:B6/A9:A10  
-keyword [optional multiple available] The keywords to describe the current datasource  
-source The source (textual or other) of the data  
-url [optional] The url/web address of the source or the query/API call used  
-from [optional] The starting date of the data is referenced.  
-to [optional] The ending date of the data is referenced.  
  
*THINGS TO DO*  
store user credential path on settings file and load automatically  
store and hide our google auth file  
