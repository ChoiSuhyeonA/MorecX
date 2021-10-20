package kr.co.irlink.zirecx.util;
//import system.exception.Exception;



public class RandomUtil {
	public String getPinNumber() {
		double randomValue = Math.random();
		int intValue = (int)(randomValue * 999999) + 100000;
		
		return Integer.toString(intValue);
	}
	
	public String getRandomPassword() {
		char[] charSet = new char[] { 
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
				'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
		};
		
		int idx = 0;
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < 8; i++) { 
			idx = (int) (charSet.length * Math.random()); // 36 * 생성된 난수를 Int로 추출 (소숫점제거) 
			sb.append(charSet[idx]); 
		}
		
		return sb.toString();
	}
}