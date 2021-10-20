package kr.co.irlink.zirecx.util;
//import system.exception.Exception;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;
import java.net.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.nio.channels.FileChannel;


public class FileUtil {
	static final Logger logger = Logger.getLogger("irlink.util.FileUtil");
    
    public boolean isRemoteFileExist(URL url, String fileName){
    	try {
    		//URL strUrl = new URL(url + fileName);
    		URLConnection conn = url.openConnection();
    		
    		HttpURLConnection http = (HttpURLConnection)conn;
    		
    		if (http.getResponseCode() == 404 || http.getResponseCode() == 400){
				logger.debug(" File doesn't Exist.  FileName = " + url + fileName);
				return false;
			} else if (http.getResponseCode() == 200){
				logger.debug(" File Exists.  FileName = " + url + fileName);
				return true;
			}
    	} catch (FileNotFoundException e){
    	    		logger.error(this.getClass().getName(), e);
    	    		return false;
    	} catch (Exception e){
    		logger.error(this.getClass().getName(), e);
    		return false;
    	}
    	return false;
    }
 /*   DBManager 문제로 일단 주석처리함.-yoyokoo-
  * 
    public boolean restoreFile(String sourcePath, String targetFile, String callId) throws Exception{
    	
    	String strFileName;
    	// 소스 파일명 DB로부터 받아오기 조건은 callId
    	StringBuffer sbSql = new StringBuffer();
		DBManager manager = DBManager.getInstance();
		
		sbSql.append(" SELECT  tape.fileName ");
		sbSql.append(" FROM orktag tag, orkTape tape, orkSegment seg ");
		sbSql.append(" WHERE seg.id = tag.taggedSegment_id ");
		sbSql.append(" AND seg.tape_id = tape.id ");
		sbSql.append(" AND tag.text ='" + callId+ "'");
		logger.info(sbSql.toString());
		strFileName = manager.excuteQueryString(sbSql.toString());
		
    	// 소스 파일을 타겟 파일로 카피
    	
    	return copyFile(sourcePath + strFileName, targetFile);
    }
    */
    private boolean copyFile(String source, String target) throws Exception{
    	
    	File sourceFile = new File(source);
    	
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		FileChannel fcin = null;
		FileChannel fcout = null;
		boolean returnValue = false;
		
    	try {
    		inputStream = new FileInputStream(sourceFile);
    		outputStream = new FileOutputStream(target);
    		fcin = inputStream.getChannel();
    		fcout = outputStream.getChannel();
    		
    		long size = fcin.size();
    		long transSize = fcin.transferTo(0, size, fcout);
    		logger.info(transSize);
    		if (transSize> 0 ){
    			returnValue = true;
    		}
    		
    	} catch (Exception e){
    		logger.error(this.getClass().getName(), e);
    	} finally {
    		try { fcout.close(); } catch(IOException ioe) {}
    		try { fcin.close(); } catch(IOException ioe) {}
    		try { outputStream.close(); } catch(IOException ioe) {}
    		try { inputStream.close(); } catch(IOException ioe) {}
    	}
		return returnValue;
    }
    
    public static String unEscapeSingleLine(String in)
    {
      StringBuffer out = new StringBuffer();
      int iin = 0;

      if (in == null) {
        return "";
      }
      while (iin < in.length())
      {
        if (in.charAt(iin) == '%')
        {
          iin++;

          switch (in.charAt(iin))
          {
          case 's':
            out.append(' ');
            break;
          case 'e':
            out.append('=');
            break;
          case 'p':
            out.append('%');
          default:
            break;
          }

        }
        else
        {
          out.append(in.charAt(iin));
        }
        iin++;
      }
      return out.toString();
    }
    
    public static String escapeSingleLine(String in)
    {
      StringBuffer out = new StringBuffer();

      if (in == null) {
        return "";
      }
      for (int i = 0; i < in.length(); i++)
      {
        char c = in.charAt(i);
        if (c == ' ')
          out.append("%s");
        else if (c == '=')
          out.append("%e");
        else if (c == '%')
          out.append("%p");
        else
          out.append(c);
      }
      return out.toString();
    }
    
    public static String unescape(String src) { 
    	StringBuffer tmp = new StringBuffer(); tmp.ensureCapacity(src.length()); 
    	int lastPos = 0, pos = 0; 
    	char ch; 
    	while (lastPos < src.length()) { 
    		pos = src.indexOf("%", lastPos); 
    		if (pos == lastPos) { 
    			if (src.charAt(pos + 1) == 'u') { 
    				ch = (char) Integer.parseInt(src .substring(pos + 2, pos + 6), 16); 
    				tmp.append(ch); lastPos = pos + 6; 
    			} 
    			else { 
    				ch = (char) Integer.parseInt(src .substring(pos + 1, pos + 3), 16); 
    				tmp.append(ch); 
    				lastPos = pos + 3; 
    			} 
    		} 
    		else { 
    			if (pos == -1) { 
    				tmp.append(src.substring(lastPos)); 
    				lastPos = src.length(); 
    			} 
    			else { 
    				tmp.append(src.substring(lastPos, pos)); 
    				lastPos = pos; 
    			} 
    		} 
    	} return tmp.toString(); 
    } 
    
    /** * String Escape 처리 * @param src * @return */ 
    public static String escape(String src) { 
    	int i; 
    	char j; 
    	StringBuffer tmp = new StringBuffer(); 
    	tmp.ensureCapacity(src.length() * 6); 
    	for (i = 0; i < src.length(); i++) { 
    		j = src.charAt(i); 
    		if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j)) 
    			tmp.append(j); 
    		else if (j < 256) { 
    			tmp.append("%"); 
    			if (j < 16) 
    				tmp.append("0"); 
    			tmp.append(Integer.toString(j, 16)); 
    			} else { 
    				tmp.append("%u"); 
    				tmp.append(Integer.toString(j, 16)); 
    			} 
    		} 
    	return tmp.toString(); 
    }
    
    public static String encodeFilename(String filename, boolean dualEncoding)
    {
      if ((filename == null) || (filename.trim().length() == 0)) {
        if (logger.isDebugEnabled())
          logger.debug("encodedFilename(): filename is blank or null. Returning blank string.");
        return "";
      }

      if (logger.isDebugEnabled()) {
        logger.debug("encodedFilename(): filename=" + filename + " dualEncoding=" + dualEncoding);
      }
      String encodedFilename = filename.startsWith("/") ? "/" : "";
      String strToEncode = "";

      StringTokenizer token = new StringTokenizer(filename, "/");
      int n = 0;

      while (token.hasMoreElements())
      {
        if (n > 0)
          encodedFilename = encodedFilename + "/";
        strToEncode = (String)token.nextElement();
        try
        {
          if (dualEncoding)
            encodedFilename = encodedFilename + URLEncoder.encode(URLEncoder.encode(strToEncode, "UTF-8"), "UTF-8");
          else
            encodedFilename = encodedFilename + URLEncoder.encode(strToEncode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        } catch (Exception e) {
        	logger.error(e);
        	logger.warn("encodeFilename(): " + e);
        }
        n++;
      }

      encodedFilename = filename.endsWith("/") ? encodedFilename + "/" : encodedFilename;

      if (logger.isDebugEnabled()) {
        logger.debug("encodedFilename(): filename=" + filename + " encodedFilename=" + encodedFilename + " dualEncoding=" + dualEncoding);
      }
      return encodedFilename;
    }
    
    public static String decodeFilename(String filename, boolean dualEncoding)
    {
      if ((filename == null) || (filename.trim().length() == 0)) {
        if (logger.isDebugEnabled())
          logger.debug("decodedFilename(): filename is blank or null. Returning blank string.");
        return "";
      }

      if (logger.isDebugEnabled()) {
        logger.debug("decodedFilename(): filename=" + filename + " dualEncoding=" + dualEncoding);
      }
      String decodedFilename = filename.startsWith("/") ? "/" : "";
      String strToDecode = "";

      StringTokenizer token = new StringTokenizer(filename, "/");
      int n = 0;

      while (token.hasMoreElements())
      {
        if (n > 0)
          decodedFilename = decodedFilename + "/";
        strToDecode = (String)token.nextElement();
        try
        {
          if (dualEncoding)
            decodedFilename = decodedFilename + URLDecoder.decode(URLDecoder.decode(strToDecode, "UTF-8"), "UTF-8");
          else
            decodedFilename = decodedFilename + URLDecoder.decode(strToDecode, "UTF-8");
          	
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        } catch (Exception e) {
        	logger.error(e);
        	logger.warn("encodeFilename(): " + e);
        }
        n++;
      }

      decodedFilename = filename.endsWith("/") ? decodedFilename + "/" : decodedFilename;

      if (logger.isDebugEnabled()) {
        logger.debug("decodedFilename(): filename=" + filename + " decodedFilename=" + decodedFilename + " dualEncoding=" + dualEncoding);
      }
      return decodedFilename;
    }

}