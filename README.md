# OpJdataURL
This piece of software can combine multiple csv/xls/xlsx files into one Google Sheet depending on the ranges the user defined for each file.

The user must define:
 <table>
  <tr>
    <td width="16%"><B>Title</B></td> <td>[optional]</td>  <td width="74%">The title the new sheet will have. This will be also printed on header of the new sheet. If not supplied a 
default value (opj followed by the current date) will be used </td>      
  </tr>
 
   <tr>
  <td><B>Github</B></td> <td>[optional]</td>  <td>The link to a github page</td>  
  </tr>
  
   <tr>
  <td><B>Author</B></td> <td>[optional]</td>  <td>The name of the author</td>  
  </tr>
   <tr>
  <td><B>Auth</B></td> <td>[optional]</td>  <td>A folder where the authentication file will be stored. If not used the new file will be created on a default user</td>  
  </tr>
   <tr>
  <td><B>Folder</B></td> <td>[optional]</td>  <td>The Google Drive folder under where the new file will be stored</td>  
  </tr>
   <tr>
  <td><B>Share</B></td> <td>[optional]</td>  <td>If used the new file will be shared with anyone with a link. If not used and no user authentication is supplied, the new file will not be available to you</td>  
  </tr>
  
  </table>
  
  [The following block is multiple accepted for multiple files]  
<table>
  <tr>
    <td><B>File</B></td> <td></td>  <td>The local path to the file</td>      
  </tr>
  <tr>
    <td><B>Range</B></td> <td></td>  <td>A range from the above file to be copied. For multiple ranges repeat the option or combine with with /. ie -range A1:B2 -range A3:B6/A9:A10</td>      
  </tr>
  <tr>
    <td><B>Keyword</B></td> <td>[optional multiple available]</td>  <td>The keywords to describe the current datasource</td>      
  </tr>
  <tr>
    <td><B>Source</B></td> <td></td>  <td>The source (textual or other) of the data</td>      
  </tr>
 <tr>
    <td><B>Url</B></td> <td>[optional]</td>  <td>The url/web address of the source or the query/API call used</td>      
  </tr>
 <tr>
    <td><B>From</B></td> <td>[optional]</td>  <td>The starting date of the data is referenced</td>      
  </tr>
 <tr>
    <td><B>To</B></td> <td>[optional]</td>  <td>The ending date of the data is referenced</td>      
  </tr>
  </table>

  

