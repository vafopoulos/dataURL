package com.datameans.tool.opj.convert;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import elod.tool.google.drive.Gdrive;
import elod.tool.google.sheet.WriteToSheet;
import elod.tool.google.sheet.WriteToSheet.Append;
import elod.tool.google.sheet.WriteToSheet.Read;

 class Range{
	String from;
	String to;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Range(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}
	@Override
	public String toString() {
		return "Range [" + from + ":" + to + "]";
	}
	
}
	class FileAndRange{
		

		
		@Override
		public String toString() {
			return "FileAndRange [fileId=" + fileId + ", ranges=" + ranges
					+ ", url=" + url + ", source=" + source + ", sourceFile="
					+ sourceFile + ", keywords=" + keywords + "]";
		}
		String fileId;
		List<Range> ranges;
		private String url;
		private String source; 
		private String sourceFile;
		private String from;
		private String to;
		private List<String> keywords=new ArrayList<String>();
		
		public String getFileId() {
			return fileId;
		}
		public void setFileId(String fileId) {
			this.fileId = fileId;
		}
		public List<Range> getRanges() {
			return ranges;
		}
		public void setRanges(List<Range> ranges) {
			this.ranges = ranges;
		}
	
		public void addRange(Range range) {
			this.ranges.add(range);
		}
		public FileAndRange(){
			ranges=new ArrayList<Range>();
		}
		public FileAndRange(String fileId, List<Range> ranges) {
			super();
			this.fileId = fileId;
			this.ranges = ranges;
		}
		public String getSourceFile() {
			return sourceFile;
		}
		public void setSourceFile(String sourceFile) {
			this.sourceFile = sourceFile;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public List<String> getKeywords() {
			return keywords;
		}
		public void setKeywords(List<String> keywords) {
			this.keywords = keywords;
		}
		public void addKeyword(String keyword) {
			this.keywords.add(keyword);
		}
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
	}
public class ConvertCsv {
	/**
	 * The path or url of the source
	 */
	String source="";
	private String newSheetName = null;
	private String github = null;
	private String author=null;
	private	boolean shareLink=false;
	Range r;
	List<Range> ranges=new ArrayList<Range>();
	

	
	public ConvertCsv() {
		super();
		setClientAuth(googleauth);
		setClientUploadFolder(uploadFolder);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String 	finalAuth="";
		String clientFolder="";
		String title = null;
		String github = null;
		String author=null;
		String tempFolder=null;
		boolean shareLink=false;
		String split=",";
		if(args.length==0){
			System.out.println("you havent insert any paramenters. defaults will be used.");
			args=new String[]{
					
					"-file","/home/ilias/Documents/pireus/opj/data.gov.gr.xlsx",
					"-range","A1:C62","-range","A235:C240","-range","A258:C267","-range","A278:C287","-range","A289:C333","-range","A369:C396","-range","A406:C414",
					"-keyword","ΔΗΜΟΣ ΒΟΛΟΥ","-keyword","Αρχείο επιχειρησιακού σχεδιασμού 2015-2019 τμήματος Προγραμματισμού και ανάπτυξης","-keyword","ΠΗΓΗ ΧΡΗΜΑΤΟΔΟΤΗΣΗΣ",
					"-source","data.gov.gr",
					"-url","http://www.data.gov.gr/dataset/27c9ed7a-97c6-4caa-8ade-2e9ba26d330f/resource/9b02bada-060f-43a7-9d27-167f5b0aeb65/download/.xls",
					"-from","2015",
					"-to","2019",
						
					"-title","Έργα στον Δήμο Βόλου",
					"-github","www.github.com",
					"-author","me testing",
					
					"-file","/home/ilias/Documents/pireus/opj/DIAVGEIA.xls",
					"-source","DIAVGEIA",
					"-url","https://diavgeia.gov.gr/search?advanced&query=decisionType:%22%CE%A0%CE%95%CE%A1%CE%99%CE%9B%CE%97%CE%A8%CE%97%20%CE%94%CE%99%CE%91%CE%9A%CE%97%CE%A1%CE%A5%CE%9E%CE%97%CE%A3%22&page=0&fq=organizationUid:%226058%22&fq=issueDate:%5BDT(2015-01-01T00:00:00)%20TO%20DT(2018-08-22T23:59:59)%5D",
					
					"-from","01/01/2015",	
					"-to","22/08/2018",	
					"-keyword","ΔΗΜΟΣ ΒΟΛΟΥ",	
					"-keyword","ΠΕΡΙΛΗΨΗ ΔΙΑΚΗΡΥΞΗΣ",	
					"-keyword","ΔΙΑΥΓΕΙΑ",	
					"-range","A1:C629",
					
					
					"-file","/home/ilias/Documents/pireus/opj/espa.xlsx",
					"-source","NSRF",	
					"-URL","http://anaptyxi.gov.gr/",	
					"-from","2014",	
					"-to","2020",	
					"-keyword","ΔΗΜΟΣ ΒΟΛΟΥ",	
					"-keyword","ΕΣΠΑ 2014-2020",	
					"-range","A1:G5",
						
			
					"-temp","1o0ptAoiEEVX1OhC9Ln77mVtUvRX72Ul5",
					"-auth","/home/ilias/Downloads/g_Sheets/bothAuths",//"/home/ilias/Documents/pireus/HarvesterUserGoogleAuth",
					"-folder","1OirNp5Dv9wjYoi1S0cySWutbT70s0tpi",//"15y-VgWPNy7YcTQFTvaKYWwlFda3oS5Vc",
					"-share"
				};
			for(int i=0;i<args.length;i=i+2){
				try{					System.out.println("\t\""+args[i]+"\""+","+"\""+args[i+1]+"\"");				}catch(Exception e){System.out.println("\t\""+args[i]+"\"");};
			}
		}
		
		List<FileAndRange> rangesFiles = new ArrayList<FileAndRange>();
		
		//get all arguments
		for(int i=0;i<args.length;i++){
			if(args[i].equalsIgnoreCase("-file")){
				//if a file arg is found 
				FileAndRange far=new FileAndRange();
				//get the next argument
				i++;
				//this is the source file
				far.setSourceFile(args[i]);
				//get the next argument
				i++;
				//if there are more arguments AND argument is part of the file (range/keyword/source/url)
				while(i<args.length&&(
						args[i].equalsIgnoreCase("-range")||args[i].equalsIgnoreCase("-keyword")||args[i].equalsIgnoreCase("-url")||args[i].equalsIgnoreCase("-source")
						))
				{
					while(i<args.length&&args[i].equalsIgnoreCase("-range")){
						//now expect the ranges. for every "-range" argument get the given range
						i++;
						String range=args[i];
						if(range.contains("/")){
							String[] multiples=range.split("/");
							for(String s:multiples){
								far.addRange(new Range(s.split(":")[0], s.split(":")[1]));
							}
						}else{
							far.addRange(new Range(range.split(":")[0], range.split(":")[1]));
						}
						i++;
					}
					while(i<args.length&&args[i].equalsIgnoreCase("-keyword")){
						//now expect the keywords. for every "-keyword" argument get the given keyword
						i++;
						far.addKeyword(args[i]);	
						i++;
					}
					
					if(i<args.length&&args[i].equalsIgnoreCase("-url")){
						//now expect the url. 
						i++;
						 far.setUrl(args[i]);
						i++;
					}
					
					if(i<args.length&&args[i].equalsIgnoreCase("-source")){
						//now expect the source. 
						i++;
						 far.setSource(args[i]);
						i++;
					}
					if(i<args.length&&args[i].equalsIgnoreCase("-from")){
						//now expect the from. 
						i++;
						 far.setFrom(args[i]);
						i++;
					}
					if(i<args.length&&args[i].equalsIgnoreCase("-to")){
						//now expect the to. 
						i++;
						 far.setTo(args[i]);
						i++;
					}
				}
			
				rangesFiles.add(far);	
				i--;	
			}else if(args[i].equalsIgnoreCase("-auth")){
				i++;
				finalAuth=args[i];
			}else if(args[i].equalsIgnoreCase("-folder")){
				i++;
				clientFolder=args[i];
			}else if(args[i].equalsIgnoreCase("-title")){
				i++;
				title=args[i];
			}else if(args[i].equalsIgnoreCase("-github")){
				i++;
				github=args[i];
			}else if(args[i].equalsIgnoreCase("-author")){
				i++;
				author=args[i];
			}else if(args[i].equalsIgnoreCase("-share")){
				shareLink=true;
			}else if(args[i].equalsIgnoreCase("-temp")){
				i++;	
				tempFolder=args[i];				
			}
			
		}
		
		try {
			
			ConvertCsv cc =new ConvertCsv();
			cc.setClientAuth(finalAuth);			
			cc.setClientUploadFolder(clientFolder);
			cc.setNewSheetName(title);
			cc.setGithub(github);
			cc.setAuthor(author);
			cc.setShareLink(shareLink);
			if(tempFolder!=null){
				cc.setUploadFolder(tempFolder);
			}
			if(cc.googleauth==null&&tempFolder!=null){
				cc.googleauth=cc.getClientAuth();
			}
			
			cc.createNewFile(rangesFiles);	
		
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private String googleauth=null;//"google/bothAuths";/
	private String uploadFolder="13C8nWgevPgU-pY9-lsvjRWhOmAWb0rxp";
	
	private String clientUploadFolder="1gazjOslTStd84qEzEsC5WCnFKcXDU7rf";
	private String clientAuth=googleauth;
	
	/**
	 * create a new worksheet file with the data gathered from the files supplied with the fileId
	 * @param fileId
	 * @param ranges
	 * @throws IOException
	 */
	private void createNewFile(List<FileAndRange> files) throws IOException{
		//create new file
			
		Gdrive a =new Gdrive();
		a.setAuthenticationFile(clientAuth);
		if(getAuthor()==null){
			setAuthor(a.getUserDisplayName());
		}
		List<String> parents =new ArrayList<String>();
		parents.add(clientUploadFolder);
		
		if(getNewSheetName()==null){
			setNewSheetName("opj"+new Date());
		}
		String newFileId=a.createWorkSheet(parents,getNewSheetName());
		
		
		//read data from old file
		WriteToSheet wts =new WriteToSheet();
		wts.setAuthenticationFile(googleauth);
		
		//set up the appender for the new file
		WriteToSheet clientWrite =new WriteToSheet();
		clientWrite.setAuthenticationFile(clientAuth);
		clientWrite.setWorkSheet(newFileId);
		clientWrite.setSheetId(0);
		Append append=clientWrite.new Append();
		
		List<List<Object>> data= new ArrayList<List<Object>>();
		//for every file get the id and the ranges. read the data and store on a List<List<Object>>
		
		append.addCell("creation date");
		append.addCell(new Date());
		append.addRow();
		
		append.addCell("author");
		append.addCell(getAuthor());
		append.addRow();
		
		append.addCell("title");
		append.addCell(getNewSheetName());
		append.addRow();

		append.addCell("GitHub");
		append.addCell(getGithub());
		append.addRow();
		append.addCell("");
		append.addCell("data");
		append.addRow();
		
		for( int i=0;i<files.size();i++){
			FileAndRange file=files.get(i);
		
			//copy file to drive
			File original=new File(file.getSourceFile());
			String name=original.getName();
			String fileId=uploadToDrive(original,name+new Date().getSeconds());
			file.setFileId(fileId);
			
			wts.setWorkSheet(file.getFileId());
			wts.setSheetIndex(0);	
			append.addCell("");
			append.addCell("Source "+(i+1)+" "+file.getSource());
			append.addRow();
			append.addCell("source"+(i+1));
			append.addCell(file.getSource());
			append.addRow();
			append.addCell("source"+(i+1)+"URL");
			append.addCell(file.getUrl());
			append.addRow();
			append.addCell("from");
			append.addCell(file.getFrom());
			append.addRow();
			append.addCell("to");
			append.addCell(file.getTo());
			append.addRow();
			
			for(int k=0;k<file.getKeywords().size();k++){
				append.addCell("keyword"+(k+1));
				append.addCell(file.getKeywords().get(k));
				
				append.addRow();
			}
				
			append.appendRow(newFileId);
		
			Read read=wts.new Read();
			int rangeCount=0;
			for(Range r:file.getRanges()){
				rangeCount++;
				append.addCell("range "+rangeCount);
				append.addCell(r.getFrom());
				append.addCell(r.getTo());
				append.addRow();
				
			
				
				wts.getSheetId();
				wts.setFrom(r.getFrom());
				wts.setTo(r.getTo());
				System.out.print(".");
				
				data.addAll((Collection<? extends List<Object>>) read.read());	
			}
			append.addCell("");
			append.addCell(file.getSource()+" data");
			append.addRow();
			append.appendRow(newFileId);
			append.appendRange(data, newFileId,0);append.appendRow(newFileId);	
			int sheet2=clientWrite.createNewSheet(file.getSource());//new int[]{sheet2,0}
			
			append.appendRange(data, newFileId,sheet2);append.appendRow(newFileId);

			data= new ArrayList<List<Object>>();
		}		
		System.out.println();
		if(isShareLink()||clientAuth.equalsIgnoreCase(googleauth)){
			a.shareWithLink(newFileId);
			System.out.println("the file can be shared with anyone with this link");
		}else{
			System.out.println("the file is private to you only");
		}
		System.out.println("https://docs.google.com/spreadsheets/d/"+newFileId);
		
	}
	
	/**
	 * upload the given file and return its google drive file ID
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private String uploadToDrive(File file,String name) throws IOException{
		Gdrive a =new Gdrive();
		a.setAuthenticationFile(googleauth);
		String id=null;
		final String tempFolder="1o0ptAoiEEVX1OhC9Ln77mVtUvRX72Ul5";//"1YbNGk__Kha1O9IFJQ6dixY3trwaoluJn";
		
		if(file.getName().contains(".xlsx")){
			id= a.uploadXlsX(file.getAbsolutePath(), name, tempFolder);
		}else if(file.getName().contains(".csv")){
			id= a.uploadcsv(file.getAbsolutePath(), name, tempFolder);
		}else if(file.getName().contains(".xls")){
			id= a.uploadXls(file.getAbsolutePath(), name, tempFolder);
		}else{
			throw new IOException("no supported file type. currently we only support csv/xls/xlsx");
		}
		return a.convertToGoogleFormat(id);
	}

	
	public void saveUrl(final String filename, final String urlString)
	        throws MalformedURLException, IOException {
	    BufferedInputStream in = null;
	    FileOutputStream fout = null;
	    try {
	        in = new BufferedInputStream(new URL(urlString).openStream());
	        fout = new FileOutputStream(filename);

	        final byte data[] = new byte[1024];
	        int count;
	        while ((count = in.read(data, 0, 1024)) != -1) {
	            fout.write(data, 0, count);
	        }
	    } finally {
	        if (in != null) {
	            in.close();
	        }
	        if (fout != null) {
	            fout.close();
	        }
	    }
	}



	public String getClientAuth() {
		return clientAuth;
	}



	public void setClientAuth(String clientAuth) {
		if(clientAuth!=null&&clientAuth.length()>3){
			this.clientAuth = clientAuth;
		}
	}

	public String getUploadFolder() {
		return uploadFolder;
	}

	public void setUploadFolder(String uploadFolder) {
		this.uploadFolder = uploadFolder;
	}

	public String getClientUploadFolder() {
		return clientUploadFolder;
	}

	public void setClientUploadFolder(String clientUploadFolder) {
		this.clientUploadFolder = clientUploadFolder;
	}

	public String getNewSheetName() {
		return newSheetName;
	}

	public void setNewSheetName(String newSheetName) {
		this.newSheetName = newSheetName;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isShareLink() {
		return shareLink;
	}

	public void setShareLink(boolean shareLink) {
		this.shareLink = shareLink;
	}
}
