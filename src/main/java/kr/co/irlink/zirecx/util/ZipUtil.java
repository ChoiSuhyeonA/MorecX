package kr.co.irlink.zirecx.util;
//import system.exception.Exception;

import org.apache.log4j.Logger;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.net.*;
import java.util.ArrayList;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipOutputStream;

import net.sf.jazzlib.ZipOutputStream;

import net.sf.jazzlib.ZipEntry;
//import net.sf.jazzlib.ZipInputStream;


public class ZipUtil {
	static final Logger logger = Logger.getLogger("irlink.util.ZipUtil");
    static final int COMPRESSION_LEVEL = 8;
    static final int BUFFER_SIZE = 64*1024;
    private Map filePathMap;
    private String errMethod; 
    
    public String[] compressFile(ArrayList<Object> listSingleData, String serverURL, String zipStorePath) throws Exception{
    	
    	String[] zipFileName = {"",""};
    	String strZipStorePath = "";
    	try {
	    	if ("".equals(zipStorePath)){
		    	Properties prop = new Properties();
				ClassLoader loader = Thread.currentThread().getContextClassLoader();
				prop.load(new FileInputStream(loader.getResource("zirecx.properties").getFile()));
				strZipStorePath = prop.getProperty("zipFolder");
	    	} else {
	    		strZipStorePath = zipStorePath;
	    	}
	    	
	    	File filePath = new File(strZipStorePath);
	    	if (!filePath.exists()){
	    		filePath.mkdirs();
	    	}
	    	
	    	/* 녹취파일 한개만 다운로드시 */
	    	if(listSingleData.size() == 1){
	    		String sqlArray[] = (String[])null;
	    		sqlArray = listSingleData.get(0).toString().split("/");
	    		//zipFileName[0] = "downloads" + listSingleData.get(0).toString();
	    		//zipFileName[0] = "/home/zisender/recdata/downloads/" + FileUtil.decodeFilename(sqlArray[sqlArray.length-1], false); //"downloads/" + sqlArray[sqlArray.length-1];
	    		zipFileName[0] = "d:/downloads/" + FileUtil.decodeFilename(sqlArray[sqlArray.length-1], false); //"downloads/" + sqlArray[sqlArray.length-1];
	    	}else{
	    		//zipFileName[0] = "/home/zisender/recdata/downloads/" + "Recording_" + System.currentTimeMillis() + ".zip"; //strZipStorePath + "/" + "Recording_" + System.currentTimeMillis() + ".zip";
	    		zipFileName[0] = "d:/downloads/" + "Recording_" + System.currentTimeMillis() + ".zip"; //strZipStorePath + "/" + "Recording_" + System.currentTimeMillis() + ".zip";
	    	}
	    	
	    	initFileMap(listSingleData, serverURL);
	    	zipFileName[1] = ZipUtil.compressFileMapToStream(zipFileName[0], filePathMap, false, "http");
	    	if(zipFileName[1].equals("")){
	    		zipFileName[1] = "0";
	    	}
    	}catch(FileNotFoundException e){
			//Sparrow 문제로 인해 Exception 처리 (2012.08.17 김정원)
    		logger.error(this.getClass().getName() , e);
		} catch (Exception ex) {
    		logger.error(this.getClass().getName() , ex);
			setErrMethod(this.getClass().getName());                
			throw ex; 
    	}
		return  zipFileName;
    }
    
    private void initFileMap(ArrayList<Object> listSingleData, String serverURL) throws UnsupportedEncodingException
    {
        filePathMap = new HashMap();
        String playURL = "";
        String descriptiveFileName = "";
        
        for(Iterator iterator = listSingleData.iterator(); iterator.hasNext();)
        {
            Object recSegmentResult = iterator.next();
            if(recSegmentResult != null)
            {
                playURL = serverURL + recSegmentResult.toString();
                descriptiveFileName = FileUtil.decodeFilename(recSegmentResult.toString(), false);
               // descriptiveFileName = URLDecoder.decode(recSegmentResult.toString(), "UTF-8");
                
                if(logger.isDebugEnabled()){
                    logger.debug((new StringBuilder("InitFileMap: URL=")).append(playURL).toString());
                    logger.debug((new StringBuilder("InitFileMap: descriptiveFileName=")).append(descriptiveFileName));
                }
                filePathMap.put(playURL, descriptiveFileName);
            } 
            
            
        }
    }
    
    public static String compressFileMapToStream(String outStream, Map filePaths, boolean keepDirectory, String protocol)
    {
    	long beginTime = System.currentTimeMillis();
    	String strCounter = "";
    	if(logger.isDebugEnabled())
    		logger.debug((new StringBuilder("compressFileMapToStream() called with number of files to add to ZIP: ")).append(filePaths.size()).toString());
    	if(protocol.equals("http"))
    	{
    		HashSet urls = new HashSet();
    		HashMap urlMap = new HashMap();
    		Set realPaths = filePaths.keySet();
    		for(Iterator iterator = realPaths.iterator(); iterator.hasNext();)
    		{
    			String file = (String)iterator.next();
    			try
    			{
    				urlMap.put(new URL(file), (String)filePaths.get(file));
    			}
    			catch(MalformedURLException mue)
    			{
    				logger.error((new StringBuilder("invalid url ")).append(file).toString(), mue);
    			}
    		}
    		strCounter = compressHttpFileMapToStream(outStream, urlMap, keepDirectory, filePaths);
    	}
    	
    	long msec = System.currentTimeMillis() - beginTime;
        logger.debug("Check :: >> " + msec/1000 + "." + (msec % 1000) + " sec. elapsed...");
        
        return strCounter;
    }
  
    
    private static String compressHttpFileMapToStream(String outStream, HashMap<URL, String> urls, boolean keepDirectory, Map<String, String> filePaths)
    {
	  	if (logger.isDebugEnabled()) {
	  		logger.debug("compressHttpFileMapToStream() called with number of files to add to ZIP: " + urls.size());
	  	}
	  	int counter = 0;
	  	String strCounter = "";
	  	byte[] buffer = new byte[18024];
	  	ZipOutputStream out = null;
	  	InputStream in = null;
	  	FileOutputStream foutput = null;
	  	net.sf.jazzlib.ZipOutputStream zoutput = null;
	  	try
	  	{
	  		Set urlKeys = urls.keySet();
	  		URL url;
	      
	  		// Zip 파일을 만든다.
	        File zfile = new File(outStream);
	        // Zip 파일 객체를 출력 스트림에 넣는다.
	        foutput = new FileOutputStream(zfile);
	        // 	녹취파일 다운로드가 파일 한개가 아닌 경우
			if(urls.size() != 1){
		        // 집출력 스트림에 집파일을 넣는다.
		        zoutput = new net.sf.jazzlib.ZipOutputStream((OutputStream)foutput);
			}
	        net.sf.jazzlib.ZipEntry zentry = null;
	        
	  		for(Iterator iterator = urlKeys.iterator(); iterator.hasNext();)
	  		{
	  			if (logger.isDebugEnabled()) {
	  				logger.debug("get url from list - total count: " + urlKeys.size());
	  			}
	  			url = (URL)iterator.next();
	  			String descriptiveFileName = (String)urls.get(url);
	  			boolean fileExists = false;
	  			try
	  			{
	  				if (logger.isDebugEnabled())
	  					logger.debug("open http input stream");
	  				logger.debug("url " + url);
	  				in = url.openStream();
	  				counter ++;
	  				fileExists = true;
	  				
	  				// 녹취파일 다운로드가 파일 한개가 아닌 경우
	  				if(urls.size() != 1){
		  		        zentry = new net.sf.jazzlib.ZipEntry(descriptiveFileName);
		  		        zoutput.putNextEntry(zentry);
	  				}
	  		        if (logger.isDebugEnabled()) {
	  		        	logger.debug("Target File Name for Compression : "
	  		        		  + descriptiveFileName
                              + ", File Size : " 
                              + in.available());
	  		        	logger.debug("adding new zip entry: URL: " + url.toString() + " descriptive file name: " + descriptiveFileName);
	  		        }
	  		        strCounter = String.valueOf(counter);
	  				if (fileExists)
	  				{
  					
	  					if (logger.isDebugEnabled()) {
	  						logger.debug("transfer bytes from input stream to zip output stream");
	  					}
	  					int len;
	  					
		  				// 녹취파일 다운로드가 파일 한개가 아닌 경우
	  					if(urls.size() != 1){
	  						while ((len = in.read(buffer)) != -1) {
	  							zoutput.write(buffer, 0, len);
		  	                }
	  					}else{
	  						while ((len = in.read(buffer)) != -1) {
	  							foutput.write(buffer, 0, len);
		  	                }
	  					}
	  					
	  					in.close();
	  				}
	  			} catch (IOException ioe) {
	  				logger.error("error occurred adding file to zip stream " + 
	  						ioe.getMessage());
	  			}
	  			finally 
	  			{
	  				if (logger.isDebugEnabled())
	  					logger.debug("close http input stream");
	  				if (in != null) {
	  					in.close();
	  				}
	  				if (logger.isDebugEnabled())
	  					logger.debug("close zip entry");
	  			}

	  			if (counter == 0)
	  			{
	  				logger.warn("No audio file found");
	  			}
	  		}
  		
	  	} catch (IllegalArgumentException iae) {
	  		logger.error("error export", iae);
	  	} catch (FileNotFoundException fnfe) {
	  		logger.error("error export", fnfe);
	  	} catch (IOException ioe) {
	  		logger.error("error export", ioe);
	  	}
	  	finally
	  	{
	  		try
	  		{
	  			if (logger.isDebugEnabled())
	  				logger.debug("flush remaining data to out stream");
	  			if (out != null)
	  				out.finish();
	  			if (zoutput != null){
	  				zoutput.closeEntry();
	  				zoutput.close();
	  			}
	  			if (foutput != null)
	  				foutput.close();
	  		}
	  		catch (IOException ioe)
	  		{
	  			if (logger.isDebugEnabled()) {
	  				logger.debug("failed close zip entry");
	  				logger.debug("exception message: " + ioe.getMessage());
	  			}
	  		}
	  	}
	  	return strCounter;
    }

        
    private static ZipOutputStream openOutStream(OutputStream outStream)
    {
        if(logger.isDebugEnabled())
            logger.debug("opening ZipOutputStream");
        ZipOutputStream out = new ZipOutputStream(outStream);
        if(logger.isDebugEnabled())
            logger.debug("set compression lvl");
        out.setLevel(0);
        return out;
    }
    
    private static ZipEntry createZipEntryFromString(String fileName)
    {
        if(logger.isDebugEnabled())
            logger.debug((new StringBuilder("createZipEntry: ")).append(fileName).toString());
        return new ZipEntry(fileName);
    }
    
    public String getErrMethod() {
		return errMethod;
	}
	public void setErrMethod(String errMethod) {
		this.errMethod = errMethod;
	}
}
