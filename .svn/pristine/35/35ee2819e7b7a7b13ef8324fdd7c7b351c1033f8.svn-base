package kr.co.irlink.zirecx.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidAlgorithmParameterException;
import org.apache.commons.codec.binary.Base64;
 
public class AES256Cipher {
	
	private static volatile AES256Cipher INSTANCE;
	 
	final static String secretKey   = "qwertyuiopasdfghqwertyuiopasdfgh"; //32bit
	 
	public static AES256Cipher getInstance(){
	    if(INSTANCE==null){
	        synchronized(AES256Cipher.class){
	            if(INSTANCE==null)
	                INSTANCE=new AES256Cipher();
	        }
	    }
	    return INSTANCE;
	}
	 
	 //암호화
	public static String AES_Encode(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
	    byte[] keyData = secretKey.getBytes();
		SecretKey secureKey = new SecretKeySpec(keyData, "AES");
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.ENCRYPT_MODE, secureKey);
		byte[] encrypted = c.doFinal(str.getBytes());
		String enStr = new String(Base64.encodeBase64(encrypted));
		
		return enStr;
	}
	 
	 //복호화
	public static String AES_Decode(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
	   byte[] keyData = secretKey.getBytes();
	   SecretKey secureKey = new SecretKeySpec(keyData, "AES");
	   Cipher c = Cipher.getInstance("AES");
	   c.init(Cipher.DECRYPT_MODE, secureKey);
	   byte[] byteStr = Base64.decodeBase64(str.getBytes());
	   return new String(c.doFinal(byteStr));
	}
}