/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kr.co.irlink.zirecx.zigate.web;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.irlink.zirecx.record.service.RecordPenVO;
import kr.co.irlink.zirecx.util.EncryptionUtil;
import kr.co.irlink.zirecx.zigate.service.ZigateService;
import kr.co.irlink.zirecx.zigate.service.ZigateVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class ZigateController {
	
	@Resource(name = "zigateService")
	private ZigateService zigateService;
	
	@RequestMapping("/ZigateWeb/ZigateAllCallInfoInsert.do")
	public @ResponseBody String allCallInfoInsert(
			@ModelAttribute("zigateVO") ZigateVO zigateVO, 
			HttpServletRequest request, HttpServletResponse response, 
			Model model, HttpSession session
			) throws Exception {
		
		System.out.println("requestUrl: "+request.getRequestURI());
		System.out.println("getQueryString: "+request.getQueryString());
		
		if(zigateVO.getCALL_CODE().equals("C")){
			zigateVO.setUSER_ID(zigateService.selectUserId(zigateVO));
		}
		
		if(zigateVO.getCALL_CONNECT_TIME().equals("")){
			zigateVO.setDURATION_RING(getDuration(zigateVO.getCALL_END_DATE(), zigateVO.getCALL_END_TIME(), 
					zigateVO.getCALL_START_DATE(), zigateVO.getCALL_START_TIME()));
			
			zigateVO.setDURATION_CALL(zigateVO.getDURATION_RING());
			
		}else{
			zigateVO.setDURATION_RING(getDuration(zigateVO.getCALL_START_DATE(), zigateVO.getCALL_CONNECT_TIME(), 
					zigateVO.getCALL_START_DATE(), zigateVO.getCALL_START_TIME()));
			
			zigateVO.setDURATION_CALL(getDuration(zigateVO.getCALL_END_DATE(), zigateVO.getCALL_END_TIME(), 
					zigateVO.getCALL_START_DATE(), zigateVO.getCALL_START_TIME()));
			
		}
		System.out.println("inoutbound code: "+zigateVO.getINOUTBOUND_CODE());
		System.out.println("duration talk: "+zigateVO.getDURATION_TALK());
		System.out.println("getDuration: "+getDuration(zigateVO.getCALL_END_DATE(), zigateVO.getCALL_END_TIME(), zigateVO.getCALL_START_DATE(), zigateVO.getCALL_START_TIME()));
		
		System.out.println("zigateVO.getCALL_END_DATE()"+zigateVO.getCALL_END_DATE());
		System.out.println("zigateVO.getCALL_END_TIME()"+zigateVO.getCALL_END_TIME());
		System.out.println("zigateVO.getCALL_START_DATE()"+zigateVO.getCALL_START_DATE());
		System.out.println("zigateVO.getCALL_START_TIME()"+zigateVO.getCALL_START_TIME());
		
		if(zigateVO.getINOUTBOUND_CODE().equals("F")){
			zigateVO.setDURATION_TALK(getDuration(zigateVO.getCALL_END_DATE(), zigateVO.getCALL_END_TIME(), 
					zigateVO.getCALL_START_DATE(), zigateVO.getCALL_START_TIME()));
		}
		
		zigateVO.setDURATION_WRAPUP(getDuration(zigateVO.getWRAPUP_DATE(), zigateVO.getWRAPUP_TIME(), 
				zigateVO.getCALL_END_DATE(), zigateVO.getCALL_END_TIME()));
		
		zigateVO.setCALL_START_TIME(toTimeFormat(zigateVO.getCALL_START_TIME()));
		zigateVO.setCALL_CONNECT_TIME(toTimeFormat(zigateVO.getCALL_CONNECT_TIME()));
		zigateVO.setCALL_END_TIME(toTimeFormat(zigateVO.getCALL_END_TIME()));
		zigateVO.setREC_START_TIME_PC(toTimeFormat(zigateVO.getREC_START_TIME_PC()));
		zigateVO.setREC_START_TIME_MEM(toTimeFormat(zigateVO.getREC_START_TIME_MEM()));
		zigateVO.setREC_END_TIME_PC(toTimeFormat(zigateVO.getREC_END_TIME_PC()));
		zigateVO.setREC_END_TIME_MEM(toTimeFormat(zigateVO.getREC_END_TIME_MEM()));
		zigateVO.setUPLOAD_TIME_PC(toTimeFormat(zigateVO.getUPLOAD_TIME_PC()));
		zigateVO.setUPLOAD_TIME_MEM(toTimeFormat(zigateVO.getUPLOAD_TIME_MEM()));
		zigateVO.setWRAPUP_TIME(toTimeFormat(zigateVO.getWRAPUP_TIME()));
		zigateVO.setGROUP_NAME(zigateService.selectGroupNamePath(zigateVO));
		
		
		int REC_ID = 0;
		String RTN_VALUE = "RESULT=ZigateAllCallInfoInsert";
		
		try {
			REC_ID = zigateService.allCallInfoInsert(zigateVO);
			
			if(REC_ID>0){
				RTN_VALUE += "|0||" + REC_ID + "|1";
			}
		} catch (Exception e) {
			// TODO: handle exception
			RTN_VALUE += "|-1||" + e.getMessage() + "|" + REC_ID + "|0";
		}
		
		RTN_VALUE +="|end";
		System.out.println("return value: "+RTN_VALUE);
		return RTN_VALUE;
		
	}
	
	@RequestMapping("/ZigateWeb/ZigateFaceCallInfoInsert.do")
	public @ResponseBody String faceCallInfoInsert(
			@ModelAttribute("zigateVO") ZigateVO zigateVO, 
			HttpServletRequest request, HttpServletResponse response, 
			Model model, HttpSession session
			) throws Exception {
		
		RecordPenVO recordPenVO = new RecordPenVO();
		recordPenVO.setSchUserZirecxId(zigateService.selectUserId2(zigateVO));
		recordPenVO.setZirecxId(zigateVO.getEND_POINT());
		recordPenVO.setPhoneNumber(zigateVO.getPHONE_NUMBER());
		recordPenVO.setCustomerName(zigateVO.getCUSTOMER_NAME());
		recordPenVO.setFaceToFace(zigateVO.getFACE_TO_FACE());
		recordPenVO.setVisitPlace(zigateVO.getVISIT_PLACE());
		recordPenVO.setVisitDate(zigateVO.getVISIT_DATE().replaceAll("-", ""));
		recordPenVO.setVisitDateClass(zigateVO.getVISIT_DATE_CLASS());
		recordPenVO.setPlayTime(
        		getDuration(
        				zigateVO.getCALL_END_DATE(),
        				zigateVO.getCALL_END_TIME(),
        				zigateVO.getCALL_START_DATE(), 
        				zigateVO.getCALL_START_TIME()
        				)
				);
		recordPenVO.setRecordFilePath(zigateVO.getREC_PATH_REMOTE_MEM());
		recordPenVO.setRecordFileName(zigateVO.getREC_FILENAME_REMOTE_MEM());
		recordPenVO.setRecordModeCode(zigateVO.getRECORD_MODE_CODE());
        
        int REC_ID = 0;
		String RTN_VALUE = "RESULT=ZigateFaceCallInfoInsert";
		
		try {
			REC_ID = zigateService.faceCallInfoInsert(recordPenVO);
			
			if(REC_ID>0){
				RTN_VALUE += "|0||" + REC_ID + "|1";
			}
		} catch (Exception e) {
			// TODO: handle exception
			RTN_VALUE += "|-1||" + e.getMessage() + "|" + REC_ID + "|0";
		}
		
		RTN_VALUE +="|end";
		//System.out.println("return value: "+RTN_VALUE);
		return RTN_VALUE;
	}
	
	/*
	 * 시간 구간길이 계산
	 */
	public String getDuration(String endDate, String endTime, String startDate, String startTime) {
		boolean bValidate = true;
		String sEndDate = endDate;
		String sEndTime = endTime;
		String sStartDate = startDate;
		String sStartTime = startTime;
		
		try {
			// 숫자만 빼고 나머지 문자들은 모두 없앤다
			sEndDate = sEndDate.replaceAll("-", "").replaceAll(":", "");
			sEndTime = sEndTime.replaceAll("-", "").replaceAll(":", "");
			sStartDate = sStartDate.replaceAll("-", "").replaceAll(":", "");
			sStartTime = sStartTime.replaceAll("-", "").replaceAll(":", "");
			
			// 날짜, 시간 길이 체크
			if(sEndDate.length() != 8)
				bValidate = false;
			else if(sEndTime.length() != 6)
				bValidate = false;
			else if(sStartDate.length() != 8)
				bValidate = false;
			else if(sStartTime.length() != 6)
				bValidate = false;
			
			// 날짜, 시간 값 중에서 한개라도 이상이 있으면 0으로 리턴
			if(!bValidate)
				return "0";
			
			String result = "";

			long end_sec = 0;
			long start_sec = 0;
			
			Calendar cal = Calendar.getInstance();
			
			// 종료일을 cal 객체에 할당
			cal.set(Integer.parseInt(sEndDate.trim().substring(0,4)), 
					Integer.parseInt(sEndDate.trim().substring(4,6)) - 1, 
					Integer.parseInt(sEndDate.trim().substring(6,8)),
					Integer.parseInt(sEndTime.trim().substring(0,2)),
					Integer.parseInt(sEndTime.trim().substring(2,4)),
					Integer.parseInt(sEndTime.trim().substring(4,6)));
			end_sec = cal.getTimeInMillis();
			
			// 시작일을 cal 객체에 할당
			cal.set(Integer.parseInt(sStartDate.trim().substring(0,4)), 
					Integer.parseInt(sStartDate.trim().substring(4,6)) - 1, 
					Integer.parseInt(sStartDate.trim().substring(6,8)),
					Integer.parseInt(sStartTime.trim().substring(0,2)),
					Integer.parseInt(sStartTime.trim().substring(2,4)),
					Integer.parseInt(sStartTime.trim().substring(4,6)));
			start_sec = cal.getTimeInMillis();
			
			// 시작일과 종료일이 바뀌어도 날짜와 시간차이를 계산하고 절대값으로 리턴 함.
			result = String.valueOf(Math.abs((end_sec - start_sec) / 1000));
			
			return result;
		} catch (NumberFormatException e) {
			return "0";
		} catch (Exception e) {
			return "0";
		}
	}
	
	/*
	 *	시간 표현형식 변경, HHMMSS -> HH:MM:SS
	 */
	public String toTimeFormat(String time){
		String sTime = time;
		String newTime;
		
		if(sTime == null){
			newTime = "";
		}else{
			sTime = sTime.replaceAll("-", "").replaceAll(":", "");
			newTime = sTime;
			
			if(sTime.length() == 6){
				newTime = sTime.substring(0, 2) + ":" + sTime.substring(2, 4) + ":" + sTime.substring(4);
			}
		}
		
		return newTime;
	}
	
	@RequestMapping("/ZigateWeb/ZigateAllCallInfoUpdate.do")
	public @ResponseBody String allCallInfoUpdate(
			@ModelAttribute("zigateVO") ZigateVO zigateVO, 
			HttpServletRequest request, HttpServletResponse response, 
			Model model, HttpSession session
			) throws Exception {
		
		System.out.println("requestUrl: "+request.getRequestURI());
		System.out.println("getQueryString: "+request.getQueryString());
		
		if(zigateVO.getCALL_CODE().equals("C")){
			zigateVO.setUSER_ID(zigateService.selectUserId(zigateVO));
		}
		
		if(zigateVO.getCALL_CONNECT_TIME().equals("")){
			zigateVO.setDURATION_RING(getDuration(zigateVO.getCALL_END_DATE(), zigateVO.getCALL_END_TIME(), 
					zigateVO.getCALL_START_DATE(), zigateVO.getCALL_START_TIME()));
			
			zigateVO.setDURATION_CALL(zigateVO.getDURATION_RING());
			
		}else{
			zigateVO.setDURATION_RING(getDuration(zigateVO.getCALL_START_DATE(), zigateVO.getCALL_CONNECT_TIME(), 
					zigateVO.getCALL_START_DATE(), zigateVO.getCALL_START_TIME()));
			
			zigateVO.setDURATION_CALL(getDuration(zigateVO.getCALL_END_DATE(), zigateVO.getCALL_END_TIME(), 
					zigateVO.getCALL_START_DATE(), zigateVO.getCALL_START_TIME()));
		}
		
		if(zigateVO.getINOUTBOUND_CODE().equals("F")){
			zigateVO.setDURATION_TALK(getDuration(zigateVO.getCALL_END_DATE(), zigateVO.getCALL_END_TIME(), 
					zigateVO.getCALL_START_DATE(), zigateVO.getCALL_START_TIME()));
		}
		
		zigateVO.setDURATION_WRAPUP(getDuration(zigateVO.getWRAPUP_DATE(), zigateVO.getWRAPUP_TIME(), 
				zigateVO.getCALL_END_DATE(), zigateVO.getCALL_END_TIME()));
		
		int REC_ID = 0;
		String RTN_VALUE = "RESULT=ZigateAllCallInfoUpdate";
		
		try {
			REC_ID = zigateService.allCallInfoUpdate(zigateVO);
			
			if(REC_ID>0){
				RTN_VALUE += "|0||" + REC_ID + "|1";
				
			}else{
				throw new SQLException("No row was updated");
			}
		} catch (Exception e) {
			// TODO: handle exception
			RTN_VALUE += "|-1||" + e.getMessage() + "|" + REC_ID + "|0";
		}
		
		RTN_VALUE +="|end";
		System.out.println("return value: "+RTN_VALUE);
		return RTN_VALUE;
	}
	
	@RequestMapping("/ZigateWeb/ZigateGetInitInfo.do")
	public @ResponseBody String getInitInfo(
			@ModelAttribute("zigateVO") ZigateVO zigateVO, 
			HttpServletRequest request, HttpServletResponse response, 
			Model model, HttpSession session
			) throws Exception {
		
		System.out.println("requestUrl: "+request.getRequestURI());
		System.out.println("getQueryString: "+request.getQueryString());
		
		String RTN_VALUE = "RESULT=ZigateGetInitInfo";
		
		try {
			zigateVO = zigateService.getInitInfo(zigateVO);
			
			if(zigateVO.getDeleted().equals("") || zigateVO.getDeleted().equals("1")){
				RTN_VALUE += "|-3|resignation user||||||||||||||||||||||";
			}else{
				RTN_VALUE += "";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			RTN_VALUE += "|-2||" + e.getMessage() + "||||||||||||||||||||||";
		}
		
		/*PrintWriter out = response.getWriter();
		out.append(RTN_VALUE+"|end");
		out.flush();
		out.close();*/
		RTN_VALUE +="|end";
		System.out.println("return value: "+RTN_VALUE);
		return RTN_VALUE;
	}
	
	@RequestMapping("/ZigateWeb/ZigateGetLogout.do")
	public void getLogout(
			@ModelAttribute("zigateVO") ZigateVO zigateVO, 
			HttpServletRequest request, HttpServletResponse response, 
			Model model, HttpSession session
			) throws Exception {
		try {
			zigateVO.setUSER_STATUS("LogOut");
			zigateService.setStatus(zigateVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/ZigateWeb/ZigateGetLogin.do")
	public @ResponseBody String getLogin(
			@ModelAttribute("zigateVO") ZigateVO zigateVO, 
			HttpServletRequest request, HttpServletResponse response, 
			Model model, HttpSession session
			) throws Exception {
		
		System.out.println("requestUrl: "+request.getRequestURI());
		System.out.println("getQueryString: "+request.getQueryString());
		
		String RTN_VALUE = "RESULT=ZigateGetLogin";
		
		try {
			// 1. 패스워드가 welcome 일 경우 패스워드 비교하여 처음 로그인 확인
			if(zigateVO.getUSER_PW().equals("welcome")) {
				int intLoginFirstResult = zigateService.selectUserLoginFirst(zigateVO);
    			if(intLoginFirstResult > 0) {
    				RTN_VALUE += "|99|Login_First|||||||||||||||||||||";
    			} else {
    				RTN_VALUE += "|-1|No_Data_Selected|||||||||||||||||||||";
    			}
			} else {
				// 2. 처음 로그인이 아닐 경우 사용자 조회, salt 값 조회
				ZigateVO loginZigate = new ZigateVO();
				loginZigate = zigateService.getLogin(zigateVO);
				if(loginZigate != null){
					EncryptionUtil eUtil = new EncryptionUtil();
					if(loginZigate.getResetPasswordFlag().equals("Y")) {
						RTN_VALUE += "|98|Random_Password|||||||||||||||||||||";
					} else {
						String tempPasswordBefore = loginZigate.getPassword();
						if(tempPasswordBefore.equals("welcome") && !zigateVO.getUSER_PW().equals("welcome")) {
							RTN_VALUE += "|-1|No_Data_Selected|||||||||||||||||||||";
						} else {
							if(!zigateVO.getLISTEN_INFO_REQ().equals("REQ")){
								String tempPasswordAfter = eUtil.byteToBase64(eUtil.getHash(zigateVO.getUSER_PW(), eUtil.base64ToByte(loginZigate.getSalt())));
								/*
		    					System.out.println("####################################################");
		    					System.out.println("## 패스워드 비교");
		    					System.out.println("## Before : " + tempPasswordBefore);
		    					System.out.println("## After : " + tempPasswordAfter);
		    					System.out.println("####################################################");
		    					*/
								if(tempPasswordBefore.equals(tempPasswordAfter)) {
		    						zigateVO.setID(String.valueOf(loginZigate.getId()));
		    						zigateVO.setUSER_STATUS("LogIn");
		    						zigateService.userUpdate(zigateVO);
		    						
		    						zigateService.setStatus(zigateVO);
		    						RTN_VALUE += "|0|login_success|"+loginZigate.getLogoutsupported()+"|"+loginZigate.getAutouploadsupported()+"||||||||||||||||||";
		    					} else {
		    						RTN_VALUE += "|-1|No_Data_Selected|||||||||||||||||||||";
		    					}
							}else{
								
								RTN_VALUE += "|"+loginZigate.getListenSupported()+"|"+loginZigate.getStoragePeriod()+"|||||||||||||||||";
							}
						}
					}
					
				}else{
					RTN_VALUE += "|-1|No_Data_Selected|||||||||||||||||||||";
				}
			}
			
			
			/*
			ZigateVO loginZigate = new ZigateVO();
			loginZigate = zigateService.getLogin(zigateVO);
			
			if(loginZigate != null){
				
				if(!loginZigate.getLISTEN_INFO_REQ().equals("REQ")){
					
					zigateService.userHistoryInsert(loginZigate);
					
					zigateVO.setID(loginZigate.getID());
					zigateService.userUpdate(zigateVO);
					
					RTN_VALUE += "|0|login_success|"+loginZigate.getLogoutsupported()+"|"+loginZigate.getAutouploadsupported()+"||||||||||||||||||";
					
				}else{
					
					RTN_VALUE += "|"+loginZigate.getListenSupported()+"|"+loginZigate.getStoragePeriod()+"|||||||||||||||||";
				}
						
			}else{
				
				RTN_VALUE += "|-1|No_Data_Selected|||||||||||||||||||||";
			}
			*/
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			RTN_VALUE += "|-2||" + e.getMessage() + "||||||||||||||||||||||";
		}
		
		/*PrintWriter out = response.getWriter();
		out.append(RTN_VALUE+"|end");
		out.flush();
		out.close();*/
		RTN_VALUE +="|end";
		System.out.println("return value: "+RTN_VALUE);
		return RTN_VALUE;
	}
	
	@RequestMapping("/ZigateWeb/ZigateGetTime.do")
	public @ResponseBody String getTime(
			@ModelAttribute("zigateVO") ZigateVO zigateVO, 
			HttpServletRequest request, HttpServletResponse response, 
			Model model, HttpSession session
			) throws Exception {
		
		System.out.println("requestUrl: "+request.getRequestURI());
		System.out.println("getQueryString: "+request.getQueryString());
		
		String RTN_VALUE = "TIME=";
		
		try {
			zigateVO = zigateService.getTime(zigateVO);
			RTN_VALUE += zigateVO.getDB_DATE()+"|"+zigateVO.getDB_TIME();
			
		} catch (Exception e) {
			// TODO: handle exception
			RTN_VALUE += "|";
		}
		
		RTN_VALUE +="|end";
		System.out.println("return value: "+RTN_VALUE);
		return RTN_VALUE;
	}
	
	@RequestMapping("/ZigateWeb/ZigateGetVersion.do")
	public @ResponseBody String getVersion(
			@ModelAttribute("zigateVO") ZigateVO zigateVO, 
			HttpServletRequest request, HttpServletResponse response, 
			Model model, HttpSession session
			) throws Exception {
		
		System.out.println("requestUrl: "+request.getRequestURI());
		System.out.println("getQueryString: "+request.getQueryString());
		
		String RTN_VALUE = "RETURN=ZigateGetVersion";
		
		try {
			zigateVO = zigateService.getVersion(zigateVO);
			
			if(zigateVO != null){
				
				RTN_VALUE += "|"+zigateVO.getVer()+"|"+zigateVO.getMarket()+"|";
			}else{
				RTN_VALUE += "|0|";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			RTN_VALUE += "|-2||" + e.getMessage() + "|||||||||||||||||||||";
		}
		
		RTN_VALUE += "|end";
		System.out.println("return value: "+RTN_VALUE);
		return RTN_VALUE;
	}
	
}
