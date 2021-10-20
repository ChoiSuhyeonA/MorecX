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
package kr.co.irlink.zirecx.system.web;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.irlink.zirecx.common.service.CmnGroupSearchVO;
import kr.co.irlink.zirecx.common.service.CmnGroupSearchService;
import kr.co.irlink.zirecx.common.service.CmnPrivateService;
import kr.co.irlink.zirecx.common.service.CmnPrivateVO;
import kr.co.irlink.zirecx.record.service.RecordSearchVO;
import kr.co.irlink.zirecx.system.service.GroupManageService;
import kr.co.irlink.zirecx.system.service.GroupSearchVO;
import kr.co.irlink.zirecx.system.service.UserDetailVO;
import kr.co.irlink.zirecx.system.service.UserManageService;
import kr.co.irlink.zirecx.system.service.UserSearchVO;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.taglibs.standard.tag.common.core.Util;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


@Controller

public class UserManageController {
	
	/** LoginService */
    @Resource(name = "userManageService")
    private UserManageService userManageService;
    
	/** GroupService */
    @Resource(name = "groupManageService")
    private GroupManageService groupManageService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    /** CmnPrivateService */
    @Resource(name = "cmnPrivateService")
    private CmnPrivateService cmnPrivateService;
    
    /** CmnPrivateService */
    @Resource(name = "cmnGroupSearchService")
    private CmnGroupSearchService cmnGroupSearchService;
    
    @Resource(name="messageSource")
	MessageSource messageSource ;
    
    /**
	 * 사용자 관리 화면을 조회한다.
	 */
    @SuppressWarnings({ "rawtypes"})
	@RequestMapping("/system/userManageMain.do")
    public String userManageMainView(
            @ModelAttribute("userSearchVO") UserSearchVO userSearchVO, HttpServletRequest request, Model model, HttpSession session
            ) throws Exception {
    	
    	/************************** 권 한 설 정 **************************/
    	CmnPrivateVO cmnPrivateVO = new CmnPrivateVO();
    	//String privName[] = {"[기능]신규","[기능]저장","[기능]조직선택","[기능]조직도"};
    	//String privName[] = {"[기능]신규","[기능]저장","[기능]조직선택","[기능]조직도","[기능]사용자선택","[기능]비밀번호초기화"};
    	String[] privName = {
    			  messageSource.getMessage("message.db_new", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_save", null, Locale.getDefault())
    			/*, messageSource.getMessage("message.db_group_select", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_group_tree", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_user_select", null, Locale.getDefault())*/
    			
    			/** 김해동 수정 => 시스템 추가 */
    			, messageSource.getMessage("message.db_sys_group_select", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_sys_group_tree", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_sys_user_select", null, Locale.getDefault())
    			
    			
    			, messageSource.getMessage("message.db_set_record_user_auth", null, Locale.getDefault())
				, messageSource.getMessage("message.db_set_delete_user_auth", null, Locale.getDefault())
    			
    	};
		
    	cmnPrivateVO.setPrivName(privName);
    	cmnPrivateVO.setStrSecurityGroupId((String)session.getAttribute("security_group_id"));
    	
    	List listPrivate = cmnPrivateService.selectPrivateList(cmnPrivateVO);
    	
    	/*
    	 * @@ 권한 관련 Function 5가지
    	 *   1. 버튼 권한 			: 버튼
    	 *   2. 그룹 선택 권한 	: 그룹
    	 *   3. 사용자 선택 권한 	: 사용자
    	 *   4. 그룹 트리 권한 	: 그룹트리
    	 *   5. checkbox
    	 */
    	String strPrivName = 
    			  messageSource.getMessage("message.db_new", null, Locale.getDefault()) + "," + "btn_new" + "," + "버튼" +"|"
    			+ messageSource.getMessage("message.db_save", null, Locale.getDefault()) + "," + "btn_save" + "," + "버튼" + "|"
    					  
    		/*	
    		 *  김해동 수정 시스템 으로 
    		 * + messageSource.getMessage("message.db_group_select", null, Locale.getDefault()) + "," + "" + "," + "그룹" + "|"
    			+ messageSource.getMessage("message.db_group_tree", null, Locale.getDefault()) + "," + "" + "," + "그룹트리" + "|"
    			+ messageSource.getMessage("message.db_user_select", null, Locale.getDefault()) + "," + "" + "," + "사용자" + "|"*/
    			
    			
				+ messageSource.getMessage("message.db_sys_group_select", null, Locale.getDefault()) + "," + "" + "," + "그룹" + "|"
				+ messageSource.getMessage("message.db_sys_group_tree", null, Locale.getDefault()) + "," + "" + "," + "그룹트리" + "|"
				+ messageSource.getMessage("message.db_sys_user_select", null, Locale.getDefault()) + "," + "" + "," + "사용자" + "|"
				
    			
    			+ messageSource.getMessage("message.db_set_record_user_auth", null, Locale.getDefault()) + "," + "recordable" + "," + "check" + "|"
				+ messageSource.getMessage("message.db_set_delete_user_auth", null, Locale.getDefault()) + "," + "deleted" + "," + "check"
    	;
    	
    	model.addAttribute("strPrivName", strPrivName);
    	model.addAttribute("listPrivate", listPrivate);
    	
    	/****************************************************************************************/
    	
    	userSearchVO.setZirecxId((String)session.getAttribute("zirecx_id"));
    	List authList = userManageService.selectAuthList(userSearchVO);
    	
    	model.addAttribute("authList", authList);
        return "system/userManageMain";
    }
    
   
    @SuppressWarnings("rawtypes")
	@RequestMapping("/system/userManageList.do")
    public String selectUserList(
    		@ModelAttribute("userSearchVO") UserSearchVO userSearchVO, HttpServletRequest request, Model model
    		, HttpSession session
            ) throws Exception {

    	
    	userSearchVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
    	userSearchVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
    	userSearchVO.setStrSessionGroupId(
    			userSearchVO.getStrAccessPolicy().equals("groupUp") ? (String)session.getAttribute("parent_group_id")
    																: (String)session.getAttribute("group_id"));
    	userSearchVO.setZirecxId((String)session.getAttribute("zirecx_id")); 
		
		/** 현재 선택된 그룹의 하위그룹까지 가져온다. */
    	CmnGroupSearchVO cmnGroupSearchVO = new CmnGroupSearchVO();
		if(userSearchVO.getSchGroupId().equals("")){
			cmnGroupSearchVO.setGroupSearchSeq(userSearchVO.getStrSessionGroupId());
		}else{
	    	cmnGroupSearchVO.setGroupSearchSeq(userSearchVO.getSchGroupId());
		}
		String strGroupSeq = cmnGroupSearchService.subGroupSeq(cmnGroupSearchVO);
    	String[] arrGroupSeq = strGroupSeq.split(",");
    	userSearchVO.setArrGroupSeq(arrGroupSeq);
    	
    	/** EgovPropertyService.sample */
//    	recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	userSearchVO.setPageSize(propertiesService.getInt("pageSize"));

    	if(userSearchVO.getPagelist().equals("10")){
    		userSearchVO.setPageUnit(propertiesService.getInt("pageUnit10"));
    	}else if(userSearchVO.getPagelist().equals("50")){
    		userSearchVO.setPageUnit(propertiesService.getInt("pageUnit50"));
    	}else if(userSearchVO.getPagelist().equals("100")){
    		userSearchVO.setPageUnit(propertiesService.getInt("pageUnit100"));
    	}else if(userSearchVO.getPagelist().equals("200")){
    		userSearchVO.setPageUnit(propertiesService.getInt("pageUnit200"));
    	}
    	
    	/** paging setting */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(userSearchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(userSearchVO.getPageUnit());
		paginationInfo.setPageSize(userSearchVO.getPageSize());
		
		userSearchVO.setFirstIndex(paginationInfo.getFirstRecordIndex()+1);
		userSearchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		userSearchVO.setCountPerPage(paginationInfo.getRecordCountPerPage());
		userSearchVO.setZirecxId((String) session.getAttribute("zirecx_id"));
		
		List userList = userManageService.selectUserList(userSearchVO);
    	model.addAttribute("userList", userList);
    	
    	int totCnt = userManageService.selectUserCnt(userSearchVO);
    	model.addAttribute("totCnt", totCnt);
		paginationInfo.setTotalRecordCount(totCnt);
		userSearchVO.setMaxPage(totCnt/Integer.parseInt(userSearchVO.getPagelist()));
		model.addAttribute("maxPage", userSearchVO.getMaxPage());
        model.addAttribute("paginationInfo", paginationInfo);
        
        /* 페이징 숫자 더하기 */
    	int cnt = 0;
        if(userSearchVO.getPageIndex() > 1){
        	cnt = (userSearchVO.getPageIndex() - 1) * userSearchVO.getPageUnit();
        }
        model.addAttribute("cnt", cnt);
    	
        return "system/userManageList";
    }
    
    @RequestMapping(value="/system/userManageDetail.do", method = RequestMethod.POST)
    public @ResponseBody String selectUserDetail (@RequestParam(value="userId", required=true) String userId
    		) throws Exception   {
    	
    	UserSearchVO userSearchVO = new UserSearchVO();
    	userSearchVO.setUserId(userId);
    	
    	List detailUser = userManageService.selectUserDetail(userSearchVO);
    	
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("list", detailUser);
    	jsonObject.put("size", detailUser.size());
    	return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
    
    /**
	 * 사용자를 수정한다.
	 * @exception Exception
	 */
    @RequestMapping("/system/userInfoManage.do")
    public @ResponseBody String userInfoManage(
    		HttpServletRequest request
            ) throws Exception {
    	
    	UserDetailVO userDetailVO = new UserDetailVO();
    	userDetailVO.setGrpId(request.getParameter("groupIdDetail"));
    	userDetailVO.setSecurityGroupName(request.getParameter("securityGroupId"));
    	userDetailVO.setUserId(request.getParameter("userId"));
    	userDetailVO.setFirstname(request.getParameter("firstname"));
    	userDetailVO.setZirecxId(request.getParameter("zirecxId"));
    	userDetailVO.setPhonenumber(request.getParameter("phonenumber"));
    	userDetailVO.setLoginstring(request.getParameter("loginstring"));
    	userDetailVO.setPhonenumberOffice1(request.getParameter("phonenumberOffice1"));
    	userDetailVO.setPhonenumberOffice2(request.getParameter("phonenumberOffice2"));
    	
    	if(request.getParameter("recordable").equals("true")){
    		userDetailVO.setRecordable("1");
    		userDetailVO.setiRecordable(1);
    	}else{
    		userDetailVO.setRecordable("0");
    		userDetailVO.setiRecordable(0);
    	}
    	
    	if(request.getParameter("deleted").equals("true")){
    		userDetailVO.setDeleted("1");
    		userDetailVO.setiDeleted(1);
    	}else{
    		userDetailVO.setDeleted("0");
    		userDetailVO.setiDeleted(0);
    	}
    	/*
    	if(request.getParameter("useMonitoring").equals("true")){
    		userDetailVO.setUseMonitoring("1");
    		userDetailVO.setiUseMonitoring(1);
    	}else{
    		userDetailVO.setUseMonitoring("0");
    		userDetailVO.setiUseMonitoring(0);
    	}
    	*/
    	if(request.getParameter("detailZirecxId").equals(request.getParameter("zirecxId"))){
    		userDetailVO.setChangeZirecxIdYn("N");
    	}else{
    		userDetailVO.setChangeZirecxIdYn("Y");
    	}
    	
    	/*
    	if(request.getParameter("detailLoginstring").equals(request.getParameter("loginstring"))){
    		userDetailVO.setChangeLoginstringYn("N");
    	}else{
    		userDetailVO.setChangeLoginstringYn("Y");
    	}
    	*/
    	
    	if(request.getParameter("logoutSupported").equals("true")){
    		userDetailVO.setLogoutSupported("1");
    		userDetailVO.setiLogoutSupported(1);
    	}else{
    		userDetailVO.setLogoutSupported("0");
    		userDetailVO.setiLogoutSupported(0);
    	}
    	if(request.getParameter("autoUploadSupported").equals("true")){
    		userDetailVO.setAutoUploadSupported("1");
    		userDetailVO.setiAutoUploadSupported(1);
    	}else{
    		userDetailVO.setAutoUploadSupported("0");
    		userDetailVO.setiAutoUploadSupported(0);
    	}
    	
    	
    	int result = 0;
    	if(request.getParameter("jobType").equals("update")){
    		result = userManageService.updateUser(userDetailVO);
    	}else{
    		result = userManageService.insertUser(userDetailVO);
    	}
    	

    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("result", result);    	
        return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
    
    @RequestMapping(value="/system/userManageGraph.do", method = RequestMethod.POST)
    public String selectUserGraph (@ModelAttribute("userSearchVO") UserSearchVO userSearchVO, Model model, HttpSession session) throws Exception {    	
    	List graphUser = userManageService.selectUserGraph(userSearchVO);
    	
    	/* 표시기준이 일이 아닌 쿼리는 특성상 데이터가 없어도 0 이 나와서 그래프가 그려지기 때문에 그리지 않기 위한 처리*/
    	if(!userSearchVO.getSearchType().equals("day")){
	    	int totalCall = 0;
	    	for (int i = 0; i < graphUser.size(); i++) {
	    		EgovMap eGovMap = (EgovMap)graphUser.get(i);
	    		totalCall += Integer.parseInt(eGovMap.get("totalCall").toString());
			}
	    	
	    	if(totalCall == 0) graphUser.clear();
    	}
    	
    	model.addAttribute("list", graphUser);
    	
    	return "system/userManageGraph";
    }
    
    /**
	 * 사용자 패스워드를 초기화 한다 (사용자관리)
	 * @exception Exception
	 */
    @RequestMapping("/system/userPasswordInit.do")
    public @ResponseBody String userPasswordInit(
    		HttpServletRequest request
            ) throws Exception {
    	
    	UserDetailVO userDetailVO = new UserDetailVO();
    	userDetailVO.setUserId(request.getParameter("userId"));
    	
    	int result = 0;
    	result = userManageService.updateUserPasswordInit(userDetailVO);

    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("result", result);    	
        return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
}
