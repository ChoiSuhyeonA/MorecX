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
package kr.co.irlink.zirecx.login.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.irlink.zirecx.login.service.ChangePasswordVO;
import kr.co.irlink.zirecx.login.service.LoginService;
import kr.co.irlink.zirecx.login.service.LoginVO;
import kr.co.irlink.zirecx.util.EncryptionUtil;
import kr.co.irlink.zirecx.util.RandomUtil;
import kr.co.irlink.zirecx.util.TextUtil;
import nTree.hpg.HPGComm;
import net.sf.json.JSONObject;

import org.apache.taglibs.standard.tag.common.core.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.n2soft.common.StringMap;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;


@Controller

public class LoginController {
	
	/** LoginService */
    @Resource(name = "loginService")
    private LoginService loginService;

	/**
	 * 로그인 화면을 조회한다.
	 * @param loginVO - 로그인 정보가 담긴 VO
	 * @param model
	 * @return "common/login"
	 * @exception Exception
	 */
    @RequestMapping("/common/login.do")
    public String loginView(
            @ModelAttribute("loginVO") LoginVO loginVO, Model model)
            throws Exception {
    	String loginSuccessYN = "INIT";
    	model.addAttribute("loginSuccessYN", loginSuccessYN);
        return "common/login";
    }

    /**
	 * 로그인정보를 조회한다.
	 * @param loginVO - 로그인 정보가 담긴 VO
	 * @param model
	 * @return "common/mainFrame"
	 * @exception Exception
	 */
    @SuppressWarnings("static-access")
	@RequestMapping("/common/loginProcess.do")
    public String selectUserLogin(
            LoginVO loginVO, Model model, HttpSession session)
            throws Exception {
    	String loginSuccessYN = "SUCCESS";
     	String retValue = "";
    	String inToSecuGrpId = "";
    	
    	try {
    		TextUtil textUtil = TextUtil.getInstance();
    		
    		loginVO.setStrZirecxId(textUtil.validateParam(loginVO.getStrZirecxId())); // id를 받아와서 변환 후 세팅
    		
    		// 1. 패스워드가 welcome 일 경우 패스워드 비교하여 처음 로그인 확인
    		if(loginVO.getStrPassword().equals("welcome")) {
    			int intLoginFirstResult = loginService.selectUserLoginFirst(loginVO);
    			if(intLoginFirstResult > 0) {
    				loginSuccessYN = "FIRST";
    				retValue = "common/login";
    			} else {
    				loginSuccessYN = "FAIL";
    				retValue = "common/login";
    			}
    			
    			model.addAttribute("loginSuccessYN", loginSuccessYN);
				return retValue;
    		} else {
    			// 2. 처음 로그인이 아닐 경우 사용자 조회, salt 값 조회
    			List listUserLogin = loginService.selectUserLogin(loginVO);
    			
    			if(listUserLogin.size() > 0) {
    				EncryptionUtil eUtil = new EncryptionUtil();
    				session.setMaxInactiveInterval(-1);
    				
    				
    				//size가 1인 경우는 그룹에 들어가있지 않는 관리자임 
    				if(listUserLogin.size() == 1) {
    					EgovMap eGovMap = (EgovMap)listUserLogin.get(0);
    					
    					if(eGovMap.get("resetPasswordFlag").toString().equals("Y")) {
    						loginSuccessYN = "RANDOMPASS";
    	    				retValue = "common/login";
    					} else {
    						String tempPasswordBefore = eGovMap.get("password").toString();
        					String tempPasswordAfter = eUtil.byteToBase64(eUtil.getHash(loginVO.getStrPassword(), eUtil.base64ToByte(eGovMap.get("salt").toString())));
        					
        					/*
        					System.out.println("####################################################");
        					System.out.println("## 패스워드 비교");
        					System.out.println("## Before : " + tempPasswordBefore);
        					System.out.println("## After : " + tempPasswordAfter);
        					System.out.println("####################################################");
        					*/
        					
        					if(tempPasswordBefore.equals(tempPasswordAfter)) {
        						session.setAttribute("user_id"			, eGovMap.get("idtouserid").toString() );
        		        		session.setAttribute("login_string"		, eGovMap.get("loginString").toString() );
        		        		session.setAttribute("user_name"		, eGovMap.get("firstname").toString() );
        		        		session.setAttribute("login_date"		, eGovMap.get("loginDate").toString() );
        		        		session.setAttribute("login_time"		, eGovMap.get("loginTime").toString() );
        		        		session.setAttribute("security_group_id", eGovMap.get("secuGrpId").toString() );
        		        		session.setAttribute("group_id"			, "" ); //관리자는 그룹없음
        		        		session.setAttribute("group_name"		, "" ); //관리자는 그룹없음 
        		        		session.setAttribute("zirecx_id"		, eGovMap.get("zirecxId").toString() );
        		        		session.setAttribute("parent_group_id", ""); 	//관리자는 그룹없음
        		        		
        		        		//inToSecuGrpId = eGovMap.get("secuGrpId").toString();
        		        		
        		        		
        		        		//Administrators 
        		        		//if(inToSecuGrpId.equals("2")){
        		        			//session.setAttribute("recordManageAuth", "block");             미사용 
    		        			session.setAttribute("linkCallManageAuth", "block");             //orkprivpoint.id 2
    		        			session.setAttribute("goodCallManageAuth", "block");             //3
    		        			session.setAttribute("moniterManageAuth", "block");              //4
    		        			session.setAttribute("userManageAuth", "block");                 //5
    		        			session.setAttribute("groupManageAuth", "block");                //6
    		        			session.setAttribute("codeManageAuth", "block");                 //7
    		        			session.setAttribute("configAuth", "block");                     //8
    		        			session.setAttribute("gradeManageAuth", "block");                //9
    		        			session.setAttribute("accessManageAuth", "block");               //10
    		        			session.setAttribute("reportManageAuth", "block");               //11
    		        			session.setAttribute("reportHourlyManageAuth", "block");         //12
    		        			session.setAttribute("reportDurationManageAuth", "block");       //13
    		        			session.setAttribute("linkageReportManageAuth", "block");        //33
    		        			session.setAttribute("linkageReportHourlyManageAuth", "block");  //34
    		        			session.setAttribute("linkageReportDurationManageAuth", "block");//35
    		        			session.setAttribute("linkPenCallManageMainAuth", "block");      //39
    		        			session.setAttribute("callHistoryManageAuth", "block");          //40                                               //
    		        			session.setAttribute("smartPhoneManageAuth", "block");           //41
        		        			//18개 메뉴 권한 block 설정 .. 
        		        		//}
        		        		
        		        		loginSuccessYN = "SUCCESS";
        		        		retValue = "common/frame_setting";
        					} else {
        						loginSuccessYN = "FAIL";
        						retValue = "common/login";
        					}
    					}
    					
    				} 
    				//관리자 아닌 경우 => 그룹을 가지고 있음. 따라서 listUserLogin.size() == 2 
    				else if(listUserLogin.size() == 2) {
    					EgovMap eGovMap = (EgovMap)listUserLogin.get(1);
    					
    					if(eGovMap.get("resetPasswordFlag").toString().equals("Y")) {
    						loginSuccessYN = "RANDOMPASS";
    	    				retValue = "common/login";
    					} else {
    					
	    					String tempPasswordBefore = eGovMap.get("password").toString();
	    					String tempPasswordAfter = eUtil.byteToBase64(eUtil.getHash(loginVO.getStrPassword(), eUtil.base64ToByte(eGovMap.get("salt").toString())));
	    					/*
	    					System.out.println("####################################################");
	    					System.out.println("## 패스워드 비교");
	    					System.out.println("## Before : " + tempPasswordBefore);
	    					System.out.println("## After : " + tempPasswordAfter);
	    					System.out.println("####################################################");
	    					*/
	    					if(tempPasswordBefore.equals(tempPasswordAfter)) {
		    					session.setAttribute( "user_id"			, eGovMap.get("idtouserid").toString() );
		    	        		session.setAttribute("login_string"		, eGovMap.get("loginString").toString() );
		    	        		session.setAttribute("user_name"		, eGovMap.get("firstname").toString() );
		    	        		session.setAttribute("login_date"		, eGovMap.get("loginDate").toString() );
		    	        		session.setAttribute("login_time"		, eGovMap.get("loginTime").toString() );
		    	        		session.setAttribute("security_group_id", eGovMap.get("secuGrpId").toString() );
		    	        		session.setAttribute("group_id"			, eGovMap.get("id").toString() );
		    	        		session.setAttribute("group_name"		, eGovMap.get("groupName").toString() );
		    	        		session.setAttribute("zirecx_id"		, eGovMap.get("zirecxId").toString() );
		    	        		session.setAttribute("parent_group_id"  , eGovMap.get("parentGroupId").toString());  //부모 그룹 세션 추가 
	    	        		
		    	        		//inToSecuGrpId = eGovMap.get("secuGrpId").toString();
		    	        		
		    	        		
		    	        		//열로올수가없음;
		    	        		/*if(inToSecuGrpId.equals("2")){
	    		        			session.setAttribute("recordManageAuth", "block");
	    		        			session.setAttribute("linkCallManageAuth", "block");
	    		        			session.setAttribute("goodCallManageAuth", "block");
	    		        			session.setAttribute("moniterManageAuth", "block");
	    		        			session.setAttribute("userManageAuth", "block");
	    		        			session.setAttribute("groupManageAuth", "block");
	    		        			session.setAttribute("codeManageAuth", "block");
	    		        			session.setAttribute("configAuth", "block");
	    		        			session.setAttribute("gradeManageAuth", "block");
	    		        			session.setAttribute("accessManageAuth", "block");
	    		        			session.setAttribute("reportManageAuth", "block");
	    		        			session.setAttribute("reportHourlyManageAuth", "block");
	    		        			session.setAttribute("reportDurationManageAuth", "block");
	    		        			session.setAttribute("linkageReportManageAuth", "block");
	    		        			session.setAttribute("linkageReportHourlyManageAuth", "block");
	    		        			session.setAttribute("linkageReportDurationManageAuth", "block");
	    		        			session.setAttribute("linkPenCallManageMainAuth", "block");
	    		        			session.setAttribute("callHistoryManageAuth", "block");
	    		        			*//** 추가 *//*
	    		        			session.setAttribute("smartPhoneManageAuth", "block");
		    	        		}*/
		    	        		//무조건 여기 타야됨;;
		    	        		//else{
		    	        			
    		        			loginVO.setSecuGrpId(eGovMap.get("secuGrpId").toString());
    		            		List listUserAuth = loginService.selectUserAuth(loginVO); /** Login User 메뉴 권한 조회 2.0 삭제 권한 제거 조건 추가*/
    	            		
    		            		//메뉴 권한 18개 
    		            		
    		            		EgovMap eGovMap2 = (EgovMap)listUserAuth.get(0); //녹취청취 
    		            		session.setAttribute("linkCallManageAuth"			, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(1);//굿콜청취
    		            		session.setAttribute("goodCallManageAuth"			, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(2);//실시간모니터링
    		            		session.setAttribute("moniterManageAuth"			, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(3);//사용자관리
    		            		session.setAttribute("userManageAuth"				, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(4);//영업실관리
    		            		session.setAttribute("groupManageAuth"				, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(5);//공통코드관리
    		            		session.setAttribute("codeManageAuth"				, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(6);//환경설정
    		            		session.setAttribute("configAuth"					, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(7);//권한관리
    		            		session.setAttribute("gradeManageAuth"				, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(8);//접근권한관리
    		            		session.setAttribute("accessManageAuth"				, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(9);//콜통계 (X)
    		            		session.setAttribute("reportManageAuth"				, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(10);//시간대별콜통계 (X)
    		            		session.setAttribute("reportHourlyManageAuth"		, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(11);//통화길이별콜통계(X)
    		            		session.setAttribute("reportDurationManageAuth"		, eGovMap2.get("securityGroupId").toString() );

    		            		eGovMap2 = (EgovMap)listUserAuth.get(31);//콭통계(연동형)
    		            		session.setAttribute("linkageReportManageAuth"		, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(32);//시간대별콜통계(연동형)
    		            		session.setAttribute("linkageReportHourlyManageAuth"		, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(33);//통화길이별콜통계(연동형)
    		            		session.setAttribute("linkageReportDurationManageAuth"		, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(37);//펜녹취이력조회
    		            		session.setAttribute("linkPenCallManageMainAuth"		, eGovMap2.get("securityGroupId").toString() );
    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(38);//녹취다운내역
    		            		session.setAttribute("callHistoryManageAuth"		, eGovMap2.get("securityGroupId").toString() );
	    		            		
    		            		eGovMap2 = (EgovMap)listUserAuth.get(39);//스마트폰관리
	    		            	session.setAttribute("smartPhoneManageAuth"		, eGovMap2.get("securityGroupId").toString() );
	    		            		            		
	    		        		//}
		    	        		loginSuccessYN = "SUCCESS";
		    	        		retValue = "common/frame_setting";
	    					} else {
	    						loginSuccessYN = "FAIL";
	    						retValue = "common/login";
	    					}
    					}
    				}
    				
    			} else {
    				loginSuccessYN = "FAIL";
    				retValue = "common/login";
    			}
    		}
        	
		} catch (EgovBizException bizEx) {
			loginSuccessYN = "FAIL";
			retValue = "common/login";
		} catch (Exception e){
			loginSuccessYN = "FAIL";
			retValue = "common/login";
		}
    	model.addAttribute("loginSuccessYN", loginSuccessYN);
        return retValue;
    }

	/**
	 * 로그아웃 후  로그인화면으로 이동한다.
	 * @param loginVO - 로그인 정보가 담긴 VO
	 * @param model
	 * @return "/common/login"
	 * @exception Exception
	 */
    @RequestMapping("/common/logoutProcess.do")
    public String logoutView(
            @ModelAttribute("loginVO") LoginVO loginVO, Model model, HttpSession session)
            throws Exception {
    	String loginSuccessYN = "OUT";
        session.invalidate();
       // System.out.println("the end");
        model.addAttribute("loginSuccessYN", loginSuccessYN);
        return "/common/login";
    }

	/**
	 * Password변경 화면을 조회한다.
	 * @param loginVO - 로그인 정보가 담긴 VO
	 * @param model
	 * @return "common/changePasswordMain"
	 * @exception Exception
	 */
    
    /** 비밀번호 초기화 */
    @RequestMapping("/common/changePasswordMain.do")
    public String resetPasswordMain(
            @ModelAttribute("changePasswordVO") ChangePasswordVO changePasswordVO
            , HttpServletRequest request
            , Model model)
            throws Exception {
    	
    	model.addAttribute("strUserIdParam", request.getParameter("strUserIdParam"));
    	
    	return "common/resetPassword";
    }
    
    /** PIN 번호 */
    @RequestMapping("/common/pinNumberMain.do")
    public String pinNumberMain(
            @ModelAttribute("changePasswordVO") ChangePasswordVO changePasswordVO
            , HttpServletRequest request
            , Model model)
            throws Exception {
    	
    	model.addAttribute("strUserIdParam", request.getParameter("strUserIdParam"));

        return "common/pinNumber";
    }
    
    // 임시 패스워드 발송
    @RequestMapping("/common/sendRandomPassword.do")
    public @ResponseBody String sendRandomPassword(
    		HttpServletRequest request, Model model)
    		throws Exception {
    	
    	JSONObject jsonObject = new JSONObject();
    	String strRandomPassword = "";
    	
    	ChangePasswordVO changePasswordVO = new ChangePasswordVO();
    	changePasswordVO.setUserId(request.getParameter("userId"));
    	changePasswordVO.setPinNumber(request.getParameter("pinNumber"));
    	List listPinNumberConfirmList = loginService.selectPinNumberConfirm(changePasswordVO);
    	
    	if(listPinNumberConfirmList.size() > 0) {
    		EgovMap eGovMap = (EgovMap)listPinNumberConfirmList.get(0);
    		String tempCheckFlag = "N";
    		String tempToday = eGovMap.get("today").toString();
    		String tempResetDate = eGovMap.get("resetDate").toString();
    		String tempResetLimitCount = eGovMap.get("resetLimitCount").toString();
    		
    		if(tempToday.equals(tempResetDate)) {
    			if(Integer.parseInt(tempResetLimitCount) > 3) {
    				jsonObject.put("result", "LIMIT");
    				tempCheckFlag = "N";
    			} else {
    				tempCheckFlag = "Y";
    				changePasswordVO.setResetDate(tempToday);
    				changePasswordVO.setResetLimitCount(Integer.toString(Integer.parseInt(tempResetLimitCount)+1));
    			}
    		} else {
    			tempCheckFlag = "Y";
    			changePasswordVO.setResetDate(tempToday);
    			changePasswordVO.setResetLimitCount("1");
    		}
    		
    		if(tempCheckFlag.equals("Y")) {
    			// 임시 비밀번호 발송
        		RandomUtil tempPw = new RandomUtil();
        		strRandomPassword = tempPw.getRandomPassword();
        		/*
        		System.out.println("######################################");
            	System.out.println("## 랜덤 비밀번호 테스트 : " + strRandomPassword);
            	System.out.println("######################################");
            	*/
            	// SMS 전송 구간
            	HPGComm mgr = new HPGComm();
            	StringMap param = new StringMap();
            	param.put("userno", changePasswordVO.getUserId().toString());				// 사번
            	param.put("telfullno", eGovMap.get("phoneNumber").toString());								// 고객 전화번호
            	param.put("smsmsg", "[웰컴론] 고객님의 임시 비밀번호["+strRandomPassword+"]를 입력해 주세요.");		// 메세지 내용
            	param.put("cmd", "utl_610S01");										// 이 부분은 웰컴론에서 저 값으로 전송 요청
            	
            	StringMap res =  mgr.doCommService("utl_610S01", param);
            	String rescd = res.get("retcd","");			// 0000이 아니면 전부 오류 메세지로 간주
            	String resmsg = res.get("retmsg","");		// 오류 메세지
            	/*
            	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            	System.out.println("@@ 임시 비밀번호 SMS 전송 테스트 Return Code : " + rescd);
            	System.out.println("@@ 임시 비밀번호 SMS 전송 테스트 Return Msg : " + resmsg);
            	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            	*/
            	if(rescd.equals("0000")) {
            		// DB에 임시비밀번호 저장
                	EncryptionUtil eUtil = new EncryptionUtil();
                	byte[] bSalt = eUtil.getSalt();
                	byte[] bDigest = eUtil.getHash(strRandomPassword, bSalt);
                	changePasswordVO.setUserRandomPassword(eUtil.byteToBase64(bDigest));
                	changePasswordVO.setSalt(eUtil.byteToBase64(bSalt));
                	changePasswordVO.setId(eGovMap.get("id").toString());
                	
                	int result = loginService.updateRandomPassword(changePasswordVO);
                	
                	if(result > 0) {
                		jsonObject.put("result", "SUCCESS");
                		jsonObject.put("sms", strRandomPassword);
                	} else {
                		jsonObject.put("result", "FAILURE");
                	}
            	} else {
            		jsonObject.put("result", "FAILURE");
            	}
            	
    		}
    	} else {
    		jsonObject.put("result", "NOTCONFIRM");
    	}
    	
    	return Util.URLEncode(jsonObject.toString(), "UTF-8");
    }
    
    /** PIN 번호 발송 */
    @RequestMapping("/common/sendPinNumber.do")
    public @ResponseBody String sendPinNumber(
            HttpServletRequest request, Model model)
            throws Exception {
    	
    	JSONObject jsonObject = new JSONObject();
    	ChangePasswordVO changePasswordVO = new ChangePasswordVO();
    	String strPinNumber = "";
    	
    	// 사용자 전화번호 확인
    	changePasswordVO.setUserId(request.getParameter("userId"));
    	List listUserPhoneNumber = loginService.selectUserPhoneNumber(changePasswordVO);
    	if(listUserPhoneNumber.size() > 0) {
    		EgovMap eGovMap = (EgovMap)listUserPhoneNumber.get(0);
    		
    		// PIN 번호 발생
        	RandomUtil pin = new RandomUtil();
        	strPinNumber = pin.getPinNumber();
        	/*
        	System.out.println("######################################");
        	System.out.println("## PIN 넘버 테스트 : " + strPinNumber);
        	System.out.println("######################################");
        	*/
        	
        	// SMS 전송 구간
        	HPGComm mgr = new HPGComm();
        	StringMap param = new StringMap();
        	param.put("userno", changePasswordVO.getUserId().toString());				// 사번
        	param.put("telfullno", eGovMap.get("phoneNumber").toString());				// 고객 전화번호
        	param.put("smsmsg", "[웰컴론] 고객님의 PIN번호["+strPinNumber+"]를 입력해 주세요.");		// 메세지 내용
        	param.put("cmd", "utl_610S01");										// 이 부분은 웰컴론에서 저 값으로 전송 요청
        	
        	StringMap res =  mgr.doCommService("utl_610S01", param);
        	String rescd = res.get("retcd","");			// 0000이 아니면 전부 오류 메세지로 간주
        	String resmsg = res.get("retmsg","");		// 오류 메세지
        	/*
        	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        	System.out.println("@@ PIN SMS 전송 테스트 Return Code : " + rescd);
        	System.out.println("@@ PIN SMS 전송 테스트 Return Msg : " + resmsg);
        	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        	*/
        	if(rescd.equals("0000")) {
        		// DB에 PIN 번호 저장
            	changePasswordVO.setPinNumber(strPinNumber);
            	changePasswordVO.setId(eGovMap.get("id").toString());
            	int result = loginService.updatePinNumber(changePasswordVO);
            	
            	if(result > 0) {
            		jsonObject.put("result", "SUCCESS");
            		jsonObject.put("sms", strPinNumber);
            	} else {
            		jsonObject.put("result", "FAILURE");
            	}
        	} else {
        		jsonObject.put("result", "FAILURE");
        	}
        	
    	} else {
    		jsonObject.put("result", "NOTUSER");
    	}
		
    	return Util.URLEncode(jsonObject.toString(), "UTF-8");
    }

    /**
	 * 사용자 Password를 수정한다.
	 * @return "common/updatePassword"
	 * @exception Exception
	 */
    @SuppressWarnings("static-access")
	@RequestMapping("/common/updatePassword.do")
    public @ResponseBody String updatePassword(
    		LoginVO loginVO, HttpServletRequest request
            ) throws Exception {
    	
    	EncryptionUtil eUtil = new EncryptionUtil();
    	
    	JSONObject jsonObject = new JSONObject();
    	ChangePasswordVO changePasswordVO = new ChangePasswordVO();
    	int updateCnt = 0;
    	
    	try {
    		TextUtil textUtil = TextUtil.getInstance();
    		loginVO.setStrZirecxId(textUtil.validateParam(request.getParameter("userId")));
    		
    		List listUserLogin = loginService.selectUserLogin(loginVO);
    		if(listUserLogin.size() == 0) {
    			jsonObject.put("result", "NOTEXIST");
    		} else {
    			EgovMap eGovMap = null;
    			if(listUserLogin.size() == 1) {
    				eGovMap = (EgovMap)listUserLogin.get(0);
    			} else {
    				eGovMap = (EgovMap)listUserLogin.get(1);
    			}
    			
    			if(eGovMap.get("password").toString().equals("welcome")) {
    				if(request.getParameter("userCurrentPassword").equals("welcome")) {
    					if(request.getParameter("userNewPassword").equals(request.getParameter("userConfirmPassword"))) {
    						changePasswordVO.setIdtouserid(eGovMap.get("idtouserid").toString());
    						changePasswordVO.setUserCurrentPassword(request.getParameter("userCurrentPassword"));
    						byte[] bSalt = eUtil.getSalt();
    			    		byte[] bDigest = eUtil.getHash(request.getParameter("userNewPassword"), bSalt);
    			    		changePasswordVO.setUserNewPassword(eUtil.byteToBase64(bDigest));
    			    		changePasswordVO.setSalt(eUtil.byteToBase64(bSalt));
    			    		
    			    		updateCnt = loginService.updatePassword(changePasswordVO);
    			    		
    			    		if(updateCnt > 0){
    		        			jsonObject.put("result", "SUCCESS");
    		        		}else{
    		        			jsonObject.put("result", "FAILURE");
    		        		}
    			    		
    					} else {
    						jsonObject.put("result", "NOTPASS");
    					}
    				} else {
    					jsonObject.put("result", "NOTPASS");
    				}
    			} else {
    				String strEncPasswordCurrentServer = eGovMap.get("password").toString();
    				String strEncPasswordCurrentPage = eUtil.byteToBase64(eUtil.getHash(request.getParameter("userCurrentPassword"), eUtil.base64ToByte(eGovMap.get("salt").toString())));
    				
    				if(strEncPasswordCurrentServer.equals(strEncPasswordCurrentPage)) {
    					if(request.getParameter("userNewPassword").equals(request.getParameter("userConfirmPassword"))) {
    						changePasswordVO.setIdtouserid(eGovMap.get("idtouserid").toString());
    						changePasswordVO.setUserCurrentPassword(strEncPasswordCurrentPage);
    						byte[] bSalt = eUtil.getSalt();
    			    		byte[] bDigest = eUtil.getHash(request.getParameter("userNewPassword"), bSalt);
    			    		changePasswordVO.setUserNewPassword(eUtil.byteToBase64(bDigest));
    			    		changePasswordVO.setSalt(eUtil.byteToBase64(bSalt));
    			    		
    			    		updateCnt = loginService.updatePassword(changePasswordVO);
    			    		
    			    		if(updateCnt > 0){
    		        			jsonObject.put("result", "SUCCESS");
    		        		}else{
    		        			jsonObject.put("result", "FAILURE");
    		        		}
    			    		
    					} else {
    						jsonObject.put("result", "NOTPASS");
    					}
    				} else {
    					jsonObject.put("result", "NOTPASS");
    				}
    			}
    		}
        	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return Util.URLEncode(jsonObject.toString(), "UTF-8");
    }
}