package kr.co.irlink.zirecx.util;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptionUtil {
	 
	public EncryptionUtil() {
	}
   
// 		public static void main(String[] args) throws Exception{
// 			try{
// 				String password = "password";
//				EncryptionUtil sha = new EncryptionUtil();
//				byte[] bSalt = sha.getSalt();
// 				byte[] aSalt = sha.getSalt();
// 				byte[] bDigest = sha.getHash(password,bSalt);
// 				byte[] aDigest = sha.getHash(password,aSalt);
//				System.out.println(sha.byteToBase64(bSalt));
//				System.out.println(sha.byteToBase64(bDigest));
//				System.out.println(sha.byteToBase64(aSalt));
//				System.out.println(sha.byteToBase64(aDigest));
//				
// 			} catch (Exception e){
//			}
//		}	
   
	public byte[] getHash(String password, byte[] salt) throws Exception  {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.reset();
		digest.update(salt);
		byte[] input = digest.digest(password.getBytes("UTF-8"));
		return input;
	}
   
	public byte[] getSalt() throws Exception{
		// Uses a secure Random not a simple Random
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		// Salt generation 64 bits long
		byte[] bSalt = new byte[8];
		random.nextBytes(bSalt);
		// Digest computation
		return bSalt;
	}
   
	/**
	 * From a base 64 representation, returns the corresponding byte[] 
	 * @param data String The base64 representation
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] base64ToByte(String data) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		return decoder.decodeBuffer(data);
	}
 
	/**
	 * From a byte[] returns a base 64 representation
	 * @param data byte[]
	 * @return String
	 * @throws IOException
	 */
	public static String byteToBase64(byte[] data){
		BASE64Encoder endecoder = new BASE64Encoder();
		return endecoder.encode(data);
	}
}
