# OpJdataURL
This piece of software can combine multiple csv/xls/xlsx files into one Google Sheet depending on the ranges the user defined for each file.

The user must define:
 <table>
  <tr>
    <td><B>Title</B></td> <td>[optional]</td>  <td>The title the new sheet will have. This will be also printed on header of the new sheet. If not supplied a 
default value (opj followed by the current date) will be used  </td>
    
  </tr>
  </table>
-<B>Title</B> [optional] The title the new sheet will have. This will be also printed on header of the new sheet. If not supplied a 
default value (opj followed by the current date) will be used  
-<B>Github</B> [optional] A link to a github page  
-<B>Author</B>	me [optional] The name of the author  
-<B>Auth</B> [optional] a folder where the authentication file will be stored. If not used the new file will be created on a default user  
-<B>Folder</B> [optional] The Google Drive folder under where the new file will be stored  
-<B>Share</B> [optional] If used the new file will be shared with anyone with a link. If not used and no user authentication is supplied, the new file will not be available to you.  
  
[The following block is multiple accepted for multiple files]  

-<B>File</B> The local path to the file  
-<B>Range</B> A range from the above file to be copied. For multiple ranges repeat the option or combine with with /. ie -range A1:B2 -range A3:B6/A9:A10  
-<B>Keyword</B> [optional multiple available] The keywords to describe the current datasource  
-<B>Source</B> The source (textual or other) of the data  
-<B>Url</B> [optional] The url/web address of the source or the query/API call used  
-<B>From</B> [optional] The starting date of the data is referenced.  
-<B>To</B> [optional] The ending date of the data is referenced.  
  

