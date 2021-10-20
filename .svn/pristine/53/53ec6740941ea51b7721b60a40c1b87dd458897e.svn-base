	
package kr.co.irlink.zirecx.util;

import java.text.NumberFormat;

public class TextUtil {
	private static TextUtil instance = new TextUtil();
	public static TextUtil getInstance(){
		return instance;
	}
	private TextUtil(){}
	
    public String GetGender(String objResidentNumber)
    {
        if (objResidentNumber == null || objResidentNumber == "" || objResidentNumber.length() < 6) return "-";
        String strJumin1 = objResidentNumber;
        String strSex = strJumin1.substring(6, 7);
        if (strSex.equals("3")||strSex.equals("5")){
        	strSex = "1";
        } else if (strSex.equals("4")||strSex.equals("6")){
        	strSex = "2";
        }
        return strSex;
        
    }
	
    public String GetDob(String strSocialID)
    {
       
        int intBirthYear = 0;

        String strReturnValue = "";
		String strGender = strSocialID.substring(6, 7);
		if(strGender.equals("1") || strGender.equals("2") || strGender.equals("5") || strGender.equals("6"))
			intBirthYear = 1900 + Integer.parseInt(strSocialID.substring(0, 2));
		else
			intBirthYear = 2000 + Integer.parseInt(strSocialID.substring(0, 2));
        
        strReturnValue = Integer.toString(intBirthYear) + "-" + strSocialID.substring(2, 4)+ "-" + strSocialID.substring(4, 6);
 
        return strReturnValue;
    }
	
    public String GetConvertBooleanInt(String strBoolean)
    {
		 if(strBoolean.equals("true")){
			 return "1";
		 }else{
			 return "0";
		 }
    }
    
    public String GetConvertStringBoolean(String strBoolean)
    {
		 if(strBoolean.equals("1")){
			 return "true";
		 }else{
			 return "false";
		 }
    }
	
    
    
    public String getOnlyNum(String str){
        StringBuffer sb = new StringBuffer();
        String number = "1234567890.";
        
        for(int i=0; i<str.length(); i++){
                if(number.indexOf(str.charAt(i)) > -1){
                        sb.append(str.charAt(i));
                }
        }
        
        return sb.toString();
    }
    
    public String getRealOnlyNum(String str){
        StringBuffer sb = new StringBuffer();
        String number = "1234567890";
        
        for(int i=0; i<str.length(); i++){
                if(number.indexOf(str.charAt(i)) > -1){
                        sb.append(str.charAt(i));
                }
        }
        
        return sb.toString();
    }
    
    /**
     * 검색어, 전화번호, 주민등록번호를 체크합니다.
     * @param str 검사 검색어
     * return 치환된 검사 문자열 
     * return 값 1=검색어, 2=주민등록번호, 3=전화번호
     */
    public String getCheckValue(String str) {
    	String result = "";
    	String number = "1234567890";
    	
    	for(int i=0; i<str.length(); i++) {				// 검색어
    		if(str.length() < 7) {
    			result = "1";
    		}
    		if(number.indexOf(str.charAt(i)) > -1) {	// 숫자일때
    			if(str.length() == 13) {				// 주민등록 번호
    				result = "2";
    			} else {								// 전화번호
    				result = "3";
    			}
    		} else {									// 검색어
    			result = "1";
    		}
    	}
    	
       	return result;
    }
    
    /** 
     * 특수한 character를 치환합니다.
     * @param strText 검사 문자열 매개변수
     * return 치환된 검사 문자열
     */
     public String validateParam(String strText)
     {
      if(strText == null || strText == "") return "";
      
      String strValidateText = "';@%&\"#|+<>()*";     //검사 문자열(만약 새로운 특수문자를 추가하려면 strValidateText와 strReplaceText에 정확한 위치에 추가한다.)
      String strReplaceText = "´；＠％＆˝＃｜┼＜＞（）＊"; //치환될 문자열
      
      for(int i=0; i<strText.length(); i++)
      {
       char ch = strText.charAt(i);
       int intStartIndex = strValidateText.indexOf(ch);
       if(intStartIndex != -1) strText = strText.replace(ch, strReplaceText.charAt(intStartIndex));
      }
      return strText;
     }
     
     /**
	  * 입력된 전화번호에 대해 "-" 를 넣어 리턴해줌
	  * @param strPhoneNo 걸려고 하는 전화번호
	  * @return 형식에 맞게 만들어짐
	*/
	public  String getPhoneNoFormat(String strPhoneNo) {
		String strReturnValue = "";
		try {
			strReturnValue = strPhoneNo.replace(" ", "");
			
			if(strReturnValue.length() > 4){
				if (strReturnValue.substring(0,2).equals("02")){
					if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,2) + "-" + strReturnValue.substring(2,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());  
					}else if(strReturnValue.length() == 9){
						strReturnValue = strReturnValue.substring(0,2) + "-" +  strReturnValue.substring(2,5) + "-" +   strReturnValue.substring(5,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("031")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("032")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("033")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("041")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("042")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("043")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("051")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("052")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("053")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("054")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("055")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("061")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("062")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("063")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("064")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("010")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("011")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("016")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("017")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("018")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("019")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("070")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.substring(0,3).toString().equals("080")){
					if(strReturnValue.length() == 11){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,7) + "-" +   strReturnValue.substring(7,strReturnValue.length());  
					}else if(strReturnValue.length() == 10){
						strReturnValue = strReturnValue.substring(0,3) + "-" +  strReturnValue.substring(3,6) + "-" +   strReturnValue.substring(6,strReturnValue.length());
					}else{
						strReturnValue = "";
					}
				}else if (strReturnValue.length() < 8){
					strReturnValue = strReturnValue.substring(0,3) + "-" +   strReturnValue.substring(3,strReturnValue.length());
				}else{
					strReturnValue = strReturnValue.substring(0,4) + "-" +   strReturnValue.substring(4,strReturnValue.length());
				}
			}else{
				strReturnValue = strPhoneNo;
			}
			
		}catch(StringIndexOutOfBoundsException e){
			//Sparrow 문제로 인해 Exception 처리 (2012.08.17 김정원)
			e.printStackTrace();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return strReturnValue;
	}
	
	 public String toHalfChar(String src)
     {
         StringBuffer strBuf = new StringBuffer();
         char c = 0;
         int nSrcLength = src.length();
         for (int i = 0; i < nSrcLength; i++)
         {
             c = src.charAt(i);
             //영문이거나 특수 문자 일경우.
             if (c >= '！' && c <= '～'){
                 c -= 0xfee0;
             }else if (c == '　'){
                 c = 0x20;
             }
             // 문자열 버퍼에 변환된 문자를 쌓는다
             strBuf.append(c);
         }
         return strBuf.toString();
     }    
	 
	 /**
      * 특수한 character를 치환합니다. html때문에 그럼
      * @param strText 검사 문자열 매개변수
      * return 치환된 검사 문자열
      */
      public String validateParamTag(String strText)
      {
       if(strText == null || strText == "") return "";
       
       String strValidateText = "-;@%&\"|+()*";     //검사 문자열(만약 새로운 특수문자를 추가하려면 strValidateText와 strReplaceText에 정확한 위치에 추가한다.)
       String strReplaceText = "―；＠％＆˝｜┼（）＊"; //치환될 문자열
       
       for(int i=0; i<strText.length(); i++)
       {
        char ch = strText.charAt(i);
        int intStartIndex = strValidateText.indexOf(ch);
        if(intStartIndex != -1) strText = strText.replace(ch, strReplaceText.charAt(intStartIndex));
       }
       return strText;
      }    
      
      
      public static String secondsToHHmmss(int seconds)
      {
          if(seconds < 0)
              seconds = 0;
          int hours = 0;
          int minutes = 0;
          if(seconds >= 3600)
          {
              hours = seconds / 3600;
              seconds %= 3600;
          }
          if(seconds >= 60)
          {
              minutes = seconds / 60;
              seconds %= 60;
          }
          StringBuffer result = new StringBuffer();
          NumberFormat nf = NumberFormat.getInstance();
          nf.setMinimumIntegerDigits(2);
          if(hours > 0)
          {
              result.append(nf.format(hours));
              result.append(":");
          } else {
        	  result.append("00:");
          }
          result.append(nf.format(minutes));
          result.append(":");
          result.append(nf.format(seconds));
          return result.toString();
      }
      
      public static String unEscapeSingleLine(String in)
      {
          StringBuffer out = new StringBuffer();
          int iin = 0;
          if(in == null)
              return "";
          for(; iin < in.length(); iin++)
              if(in.charAt(iin) == '%')
              {
                  iin++;
                  switch(in.charAt(iin))
                  {
                  case 115: // 's'
                      out.append(' ');
                      break;

                  case 101: // 'e'
                      out.append('=');
                      break;

                  case 112: // 'p'
                      out.append('%');
                      break;
                  }
              } else
              {
                  out.append(in.charAt(iin));
              }

          return out.toString();
      }
      
      public String sqlInjection(String strString)
      {
      	String tmpStrText = "";
      	if (strString != null && strString != ""){
      		tmpStrText = strString;
       	   tmpStrText = tmpStrText.replaceAll("\r\n", "<br/>");
       	   tmpStrText = tmpStrText.replaceAll("@", "＠");
       	   tmpStrText = tmpStrText.replaceAll("'", "＇");
       	   tmpStrText = tmpStrText.replaceAll("\"", "˝");
       	   tmpStrText = tmpStrText.replaceAll("-", "―");
       	   tmpStrText = tmpStrText.replaceAll(";", "；");
       	   tmpStrText = tmpStrText.replaceAll(":", "：");
       	   tmpStrText = tmpStrText.replaceAll("\\(", "（");
       	   tmpStrText = tmpStrText.replaceAll("\\)", "）");
       	   tmpStrText = tmpStrText.replaceAll("#", "ㅇ");
       	   tmpStrText = tmpStrText.replaceAll("[|]", "｜");
       	   tmpStrText = tmpStrText.replaceAll("[+]", "┼");
       	   tmpStrText = tmpStrText.replaceAll("<", "＜");
       	   tmpStrText = tmpStrText.replaceAll(">", "＞");
       	   tmpStrText = tmpStrText.replaceAll("%", "％");
       	   tmpStrText = tmpStrText.replaceAll("&", "＆"); 
      	} else {
      		tmpStrText = "";
      	}
      	   
      	   return tmpStrText;
      }
      
      /** zilogpro에서 뜯어온거 */
      public static String convertDuration(String strDuration){
  		String returnTime = "";
  		
  		if("".equals(strDuration) || "0".equals(strDuration) || "-".equals(strDuration)){
  			returnTime = "00:00:00";
  		}else{
  			int iHour = Integer.parseInt(strDuration) / 3600;
  			int iMinute = Integer.parseInt(strDuration) % 3600 / 60;
  			int iSecond = Integer.parseInt(strDuration) % 60;

  			String strHour = "";
  			String strMinute = "";
  			String strSecond = "";
  			
  			if(iHour < 10){
  				strHour = "0" + Integer.toString(iHour);
  			}else{
  				strHour = Integer.toString(iHour);
  			}
  			if(iMinute < 10){
  				strMinute = "0" + Integer.toString(iMinute);
  			}else{
  				strMinute = Integer.toString(iMinute);
  			}
  			if(iSecond < 10){
  				strSecond = "0" + Integer.toString(iSecond);
  			}else{
  				strSecond = Integer.toString(iSecond);
  			}
  			
  			returnTime = strHour + ":" + strMinute + ":" + strSecond;
  		}
  		
  		return returnTime;
  	}
}
