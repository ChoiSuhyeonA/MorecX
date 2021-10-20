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

import kr.co.irlink.zirecx.common.service.CmnPrivateService;
import kr.co.irlink.zirecx.common.service.CmnPrivateVO;
import kr.co.irlink.zirecx.common.web.CmnPrivateController;
import kr.co.irlink.zirecx.record.service.RecordSearchVO;
import kr.co.irlink.zirecx.system.service.GroupManageService;
import kr.co.irlink.zirecx.system.service.GroupSearchVO;
import net.sf.json.JSONObject;

import org.apache.taglibs.standard.tag.common.core.Util;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller

public class GroupManageController {
	
	/** GroupService */
    @Resource(name = "groupManageService")
    private GroupManageService groupManageService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /** Validator */
    @Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
    
    /** CmnPrivateService */
    @Resource(name = "cmnPrivateService")
    private CmnPrivateService cmnPrivateService;
    
    @Resource(name="messageSource")
	MessageSource messageSource ;
	
    
    /**
	 * 사용자의 부모 조직을 가져온다.
	 */
    
    @RequestMapping(value="/system/selectParentGroup.do", method = RequestMethod.POST)
    public @ResponseBody String selectParentGroup (@RequestParam(value="seq", required=true) String seq) throws Exception   {
    	String parentGroup = groupManageService.selectParentGroup(seq);
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("parentGroup", parentGroup);
        return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");

    }
    
    /**
	 * 조직도 팝업.
	 */
    @RequestMapping("/system/groupTreePopMain.do")
    public String groupTreePopMainView(
            @ModelAttribute("groupSearchVO") GroupSearchVO groupSearchVO, Model model, HttpSession session
            ) throws Exception {
    	model.addAttribute("groupSearchVO", new GroupSearchVO());
        return "system/groupTreePopMain";
    }

	/**
	 * 조직도 리스트를 조회한다.
	 */
    @RequestMapping("/system/groupTreeList.do")
    public String selectGroupTreeList(
    		GroupSearchVO groupSearchVO, Model model, HttpSession session
            ) throws Exception {
    	
    	groupSearchVO.setAuth((String) session.getAttribute("zirecx_id"));
    	groupSearchVO.setGroupSearchSeq(session.getAttribute("group_id").toString());    	
    	List groupTreeList = groupManageService.selectGroupTreeList(groupSearchVO);    	
    	model.addAttribute("groupTreeList", groupTreeList);
        return "system/groupTreePopList";
    }
    
	/**
	 * 조직도의 플러스 아이콘을 눌렀을 때 하위 조직을 조회한다.
	 */
    
    @RequestMapping(value="/system/selectGroupTreeSeq.do", method = RequestMethod.POST)
    public @ResponseBody String selectGroupTreeSeq (@RequestParam(value="seq", required=true) String seq) throws Exception   {
    	List groupTreeChildList = groupManageService.selectGroupTreeSeq(seq);
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("list", groupTreeChildList);
    	jsonObject.put("size", groupTreeChildList.size());
        return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");

    }
    
    /**
	 * 센터 관리.
	 */
    @RequestMapping("/system/groupManageMain.do")
    public String groupManageMainView(@ModelAttribute("groupSearchVO") GroupSearchVO groupSearchVO, Model model, HttpSession session) throws Exception {
    	
    	CmnPrivateVO cmnPrivateVO = new CmnPrivateVO();
    	//String privName[] = {"[기능]신규","[기능]저장","[기능]수정","[기능]시스템조직선택","[기능]시스템조직도"};
    	
    	String[] privName = {
    			  messageSource.getMessage("message.db_new", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_save", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_sys_group_select", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_sys_group_tree", null, Locale.getDefault())
    			
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
    	 */
    	String strPrivName = 
    			  messageSource.getMessage("message.db_new", null, Locale.getDefault()) + "," + "btn_new" + "," + "버튼" +"|"
    			+ messageSource.getMessage("message.db_save", null, Locale.getDefault()) + "," + "btn_save" + "," + "버튼" + "|"
    			+ messageSource.getMessage("message.db_sys_group_select", null, Locale.getDefault()) + "," + "" + "," + "그룹" + "|"
    			+ messageSource.getMessage("message.db_sys_group_tree", null, Locale.getDefault()) + "," + "" + "," + "그룹트리"
    	;
    	
    	model.addAttribute("strPrivName", strPrivName);
    	model.addAttribute("listPrivate", listPrivate);
    	
    	return "system/groupManageMain";
    }
    
    @RequestMapping("/system/groupManageList.do")
    public String selectGroupList(
    		@ModelAttribute("groupSearchVO") GroupSearchVO groupSearchVO, Model model, HttpSession session
            ) throws Exception {
    	
    	
    	GroupSearchVO gsVO = new GroupSearchVO();
    	
    	//권한주기
    	if(groupSearchVO.getSchGroupId().equals("")){
    		gsVO.setGroupSearchSeq(
    				session.getAttribute(
    						"zirecx_id").equals("admin") ? groupSearchVO.getStrSessionGroupId() // admin
												  		 : groupSearchVO.getHidAccessPolicy().equals("groupUp") ? (String) session.getAttribute("parent_group_id")
												  				 											    : (String) session.getAttribute("group_id"));
    	} else {
    		gsVO.setGroupSearchSeq(groupSearchVO.getSchGroupId());
    	}
    	
  
    	String strGroupSeq = groupManageService.subGroupSeq(gsVO);
    	String[] arrGroupSeq = strGroupSeq.split(",");
    	groupSearchVO.setArrGroupSeq(arrGroupSeq);
    	
    	/** EgovPropertyService.sample */
    	//groupSearchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	groupSearchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	if(groupSearchVO.getPagelist().equals("10")){
    		groupSearchVO.setPageUnit(propertiesService.getInt("pageUnit10"));
    	}else if(groupSearchVO.getPagelist().equals("50")){
    		groupSearchVO.setPageUnit(propertiesService.getInt("pageUnit50"));
    	}else if(groupSearchVO.getPagelist().equals("100")){
    		groupSearchVO.setPageUnit(propertiesService.getInt("pageUnit100"));
    	}else if(groupSearchVO.getPagelist().equals("200")){
    		groupSearchVO.setPageUnit(propertiesService.getInt("pageUnit200"));
    	}
    	
    	/** paging setting */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(groupSearchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(groupSearchVO.getPageUnit());
		paginationInfo.setPageSize(groupSearchVO.getPageSize());
		
		groupSearchVO.setFirstIndex(paginationInfo.getFirstRecordIndex()+1);
		groupSearchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		groupSearchVO.setCountPerPage(paginationInfo.getRecordCountPerPage());

		groupSearchVO.setAuth((String) session.getAttribute("zirecx_id"));
		
		List groupList = groupManageService.selectGroupList(groupSearchVO);
    	model.addAttribute("groupList", groupList);
    	
    	int totCnt = groupManageService.selectGroupListTotCnt(groupSearchVO);
    	//System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~ totCnt : "+totCnt);
    	model.addAttribute("totCnt", totCnt);
		paginationInfo.setTotalRecordCount(totCnt);
		groupSearchVO.setMaxPage(totCnt/Integer.parseInt(groupSearchVO.getPagelist()));
		model.addAttribute("maxPage", groupSearchVO.getMaxPage());
        model.addAttribute("paginationInfo", paginationInfo);
        
        /* 페이징 숫자 더하기 */
    	int cnt = 0;
        if(groupSearchVO.getPageIndex() > 1){
        	cnt = (groupSearchVO.getPageIndex() - 1) * groupSearchVO.getPageUnit();
        }
        model.addAttribute("cnt", cnt);
    	
    	
        return "system/groupManageList";
    }
    
    @RequestMapping(value="/system/groupManageDetail.do", method = RequestMethod.POST)
    public @ResponseBody String selectGroupDetail (@RequestParam(value="groupSeq", required=true) String groupSeq
    		) throws Exception   {
    	
    	GroupSearchVO groupSearchVO = new GroupSearchVO();
    	groupSearchVO.setGroupSeq(groupSeq);
    	
    	List detailGroup = groupManageService.selectGroupDetail(groupSearchVO);
    	
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("list", detailGroup);
    	jsonObject.put("size", detailGroup.size());
    	return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
    
    @RequestMapping(value="/system/selectGroupUpper.do", method = RequestMethod.POST)
    public @ResponseBody String selectGroupUpper (@RequestParam(value="groupSeq", required=true) String groupSeq
    		) throws Exception   {
    	
    	GroupSearchVO groupSearchVO = new GroupSearchVO();
    	groupSearchVO.setGroupSeq(groupSeq);
    	
    	List upperGroup = groupManageService.selectGroupUpper(groupSearchVO);
    	
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("list", upperGroup);
    	jsonObject.put("size", upperGroup.size());
    	return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
    
    @RequestMapping("/system/groupManageInsert.do")
    public @ResponseBody String insertGroup(
    		HttpServletRequest request, GroupSearchVO groupSearchVO, HttpSession session
            ) throws Exception {

		JSONObject jsonObject = new JSONObject();
		
		groupSearchVO.setGroupSeqUpperDT(request.getParameter("groupSeqUpperDT"));
		groupSearchVO.setGroupNameDT(request.getParameter("groupNameDT"));
		groupSearchVO.setOfficeCode(request.getParameter("officeCode"));
		groupSearchVO.setGroupCode(request.getParameter("groupCode"));
//		groupSearchVO.setLicenseCnt(request.getParameter("licenseCnt"));
		
    	int result = groupManageService.insertGroup(groupSearchVO);
    	
    	jsonObject.put("result", result);    	
        return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
    
    @RequestMapping("/system/groupManageUpdate.do")
    public @ResponseBody String updateGroup(
    		GroupSearchVO groupSearchVO, HttpServletRequest request, HttpSession session
            ) throws Exception {

    	JSONObject jsonObject = new JSONObject();
    	int updateCnt = 0;
    	groupSearchVO.setAuth((String) session.getAttribute("zirecx_id"));
    	groupSearchVO.setGroupSeqDT(request.getParameter("groupSeqDT"));
    	groupSearchVO.setGroupSeqUpperDT(request.getParameter("groupSeqUpperDT"));
    	groupSearchVO.setGroupNameDT(request.getParameter("groupNameDT"));
    	groupSearchVO.setDeleteYnDT(request.getParameter("deleteYnDT"));
    	groupSearchVO.setOfficeCode(request.getParameter("officeCode"));
		groupSearchVO.setGroupCode(request.getParameter("groupCode"));
//    	groupSearchVO.setLicenseCnt(request.getParameter("licenseCnt"));
    	
    	updateCnt = groupManageService.updateGroup(groupSearchVO);
    	
    	if(updateCnt > 0) {
			jsonObject.put("result", "SUCCESS");
		} else {
			jsonObject.put("result", "FAILURE");
		}
    	
    	return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
}
