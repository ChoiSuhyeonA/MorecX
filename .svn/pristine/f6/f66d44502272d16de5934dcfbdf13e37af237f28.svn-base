package kr.co.irlink.zirecx.util;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidAlgorithmParameterException;

public class AES256FileEncCBC {
	
	private static volatile AES256FileEncCBC INSTANCE;
	
	final static String secretKey = "a5c2e1f8152cdc1ca5c2e1f8152cdc1c";
	static String IV = "";
	
	public static AES256FileEncCBC getInstance(){
		if(INSTANCE==null){
			synchronized(AES256FileEncCBC.class){
				if(INSTANCE==null){
					INSTANCE=new AES256FileEncCBC();
				}
			}
		}
		return INSTANCE;
	}
	
	private AES256FileEncCBC(){
		IV = secretKey.substring(0,16);
	}
	
	public void encrypt(File source, File dest) throws Exception {
		crypt(Cipher.ENCRYPT_MODE, source, dest);
	}
	
	public void decrypt(File source, File dest) throws Exception {
		crypt(Cipher.DECRYPT_MODE, source, dest);
	}
	
	public void crypt(int mode, File source, File dest) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException{
	
		byte[] keyData = secretKey.getBytes();
		
		SecretKey secureKey = new SecretKeySpec(keyData, "AES");
		
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(mode, secureKey, new IvParameterSpec(IV.getBytes()));
		
		InputStream input = null;
		OutputStream output = null;
		
		try{
			input = new BufferedInputStream(new FileInputStream(source));
			output = new BufferedOutputStream(new FileOutputStream(dest));
			byte[] buffer = new byte[1024];
			int read = -1;
			
			while ((read = input.read(buffer)) != -1) {
				output.write(c.update(buffer, 0, read));
			}
			
			output.write(c.doFinal());
			
		}finally{
			if(output!=null){
				try{
					output.close();
				}catch(IOException ie){
					ie.printStackTrace();
				}
			}
			if(input!=null){
				try {
					input.close();
				}catch(IOException ie){
					ie.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * AES 256 암호화
	 * @param targetFilePath 순수파일 전체 파일경로+파일명 (ex 20181027)
	 * @param encFilePath 암호된 후 전체 파일경로+파일명
	 * @return
	 */
	public int AES256FileEncCBC(String targetFilePath, String encFilePath) {
		//System.out.println("AES256FileEncCBC start");
		int result = 0;
		
		AES256FileEncCBC a256 = AES256FileEncCBC.getInstance();
			
		File targetFile = new File(targetFilePath);
		//System.out.println("targetFile path: "+targetFilePath+", isFile: "+targetFile.isFile());
		File encFile = new File(encFilePath);
		//System.out.println("encFile path: "+encFilePath+", isFile: "+encFile.isFile());
		
		try {
			a256.encrypt(targetFile, encFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("encFile result: "+encFile.isFile());
		if(encFile.isFile()){
			if(targetFile.delete()){
				result++;
			}
		}
			
		return result;
		
	}
}