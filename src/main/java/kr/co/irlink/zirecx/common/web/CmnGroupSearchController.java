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
package kr.co.irlink.zirecx.common.web;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.irlink.zirecx.common.service.CmnGroupSearchService;
import kr.co.irlink.zirecx.common.service.CmnGroupSearchVO;
import kr.co.irlink.zirecx.common.service.CmnPrivateService;
import kr.co.irlink.zirecx.common.service.CmnPrivateVO;
import kr.co.irlink.zirecx.util.TextUtil;
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
//import kr.co.irlink.zirecx.system.service.UserSearchVO;

@Controller

public class CmnGroupSearchController {
	
	/** GroupPopService */
    @Resource(name = "cmnGroupSearchService")
    private CmnGroupSearchService cmnGroupSearchService;
    
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
   	MessageSource messageSource;
	
    
    /**
	 * 사용자의 부모 조직을 가져온다.
	 */
    
    @RequestMapping(value="/common/selectParentGroup.do", method = RequestMethod.POST)
    public @ResponseBody String selectParentGroup (@RequestParam(value="seq", required=true) String seq) throws Exception   {
    	String parentGroup = cmnGroupSearchService.selectParentGroup(seq);
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("parentGroup", parentGroup);
        return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");

    }
    
    /**
	 * 조직도 팝업.
	 */
    @RequestMapping("/common/groupTreePopMain.do")
    public String groupTreePopMainView(
            @ModelAttribute("cmnGroupSearchVO") CmnGroupSearchVO cmnGroupSearchVO, Model model, HttpSession session
            ) throws Exception {
    	model.addAttribute("cmnGroupSearchVO", new CmnGroupSearchVO());
        return "common/groupTreePopMain";
    }

	/**
	 * 조직도 리스트를 조회한다.
	 */
    @RequestMapping("/common/groupTreeList.do")
    public String selectGroupTreeList(
    		CmnGroupSearchVO cmnGroupSearchVO, Model model, HttpSession session
            ) throws Exception {
    	
    	cmnGroupSearchVO.setAuth((String) session.getAttribute("zirecx_id"));
    	/*
    	// 권한 설정
    	TextUtil textUtil = TextUtil.getInstance();
    	
    	//cmnGroupSearchVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
    	cmnGroupSearchVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
    	cmnGroupSearchVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("group_id")) );
    	
    	if(!cmnGroupSearchVO.getStrSessionLoginString().equals("admin")) {
    		
	    	String strChildGroupId = "";
			CmnPrivateVO cmmPrivateVO = new CmnPrivateVO();
			
			cmmPrivateVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("group_id")) );
			strChildGroupId = cmnPrivateService.selectChildGroupId(cmmPrivateVO);
			
			String[] temp = strChildGroupId.split(",");
			cmnGroupSearchVO.setArrChildGroupId(temp);
			
    	}
    	
    	List groupTreeList = cmnGroupSearchService.selectGroupTreeList(cmnGroupSearchVO);
    	model.addAttribute("groupTreeList", groupTreeList);
    	*/
    	
    	/* admin 이 아니면 조직도의 범위를 조회 */
    	if(!session.getAttribute("zirecx_id").equals("admin")){
    		CmnPrivateVO cmnPrivateVO = new CmnPrivateVO();
        	//String privName[] = {"[기능]조직선택","[기능]조직도"};
        	String[] privName = {
        			  messageSource.getMessage("message.db_group_select", null, Locale.getDefault())
        			, messageSource.getMessage("message.db_group_tree", null, Locale.getDefault())		
        	};
        	
    		cmnPrivateVO.setPrivName(privName);
        	cmnPrivateVO.setStrSecurityGroupId((String)session.getAttribute("security_group_id"));
        	
        	List listPrivate = cmnPrivateService.selectPrivateList(cmnPrivateVO);
        	
        	EgovMap scope = (EgovMap)listPrivate.get(1);    // 조직도의 범위를 알아본다.
        	cmnGroupSearchVO.setGroupScope(scope.get("scope").toString());
    	}else{
    		cmnGroupSearchVO.setGroupScope("all");
    	}
    	
    	cmnGroupSearchVO.setGroupSearchSeq(session.getAttribute("group_id").toString());
    	List groupTreeList = cmnGroupSearchService.selectGroupTreeList(cmnGroupSearchVO);   
    	
    	if(!cmnGroupSearchVO.getGroupScope().equals("all")){
    		EgovMap groupTreeScope = (EgovMap)groupTreeList.get(0);    // 조직도의 범위를 알아본다.
        	groupTreeScope.setValue(1, "0");        	
        	groupTreeList.set(0, groupTreeScope);
    	}
    	model.addAttribute("groupTreeList", groupTreeList);
    	
        return "common/groupTreePopList";
    }
    
    
    /**
     * 시스템관리 사용자 그룹 트리 
     * 
     * @param cmnGroupSearchVO
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/common/systemGroupTreeList.do")
    public String selectGroupUserTreeList(
    		CmnGroupSearchVO cmnGroupSearchVO, Model model, HttpSession session
            ) throws Exception {
    	
    	cmnGroupSearchVO.setAuth((String) session.getAttribute("zirecx_id"));
	
    	/* admin 이 아니면 조직도의 범위를 조회 */
    	if(!session.getAttribute("zirecx_id").equals("admin")){
    		CmnPrivateVO cmnPrivateVO = new CmnPrivateVO();
        	//String privName[] = {"[기능]조직선택","[기능]조직도"};
        	String[] privName = {
        			  messageSource.getMessage("message.db_sys_group_select", null, Locale.getDefault())
        			, messageSource.getMessage("message.db_sys_group_tree", null, Locale.getDefault())		
        	};
        	
    		cmnPrivateVO.setPrivName(privName);
        	cmnPrivateVO.setStrSecurityGroupId((String)session.getAttribute("security_group_id"));
        	
        	List listPrivate = cmnPrivateService.selectPrivateList(cmnPrivateVO);
        	
        	EgovMap scope = (EgovMap)listPrivate.get(1);    // 조직도의 범위를 알아본다.
        	cmnGroupSearchVO.setGroupScope(scope.get("scope").toString());
    	}else{
    		cmnGroupSearchVO.setGroupScope("all");
    	}
    	
    	cmnGroupSearchVO.setGroupSearchSeq(session.getAttribute("group_id").toString());
    	List groupTreeList = cmnGroupSearchService.selectGroupTreeList(cmnGroupSearchVO);   
    	
    	if(!cmnGroupSearchVO.getGroupScope().equals("all")){
    		EgovMap groupTreeScope = (EgovMap)groupTreeList.get(0);    // 조직도의 범위를 알아본다.
        	groupTreeScope.setValue(1, "0");        	
        	groupTreeList.set(0, groupTreeScope);
    	}
    	model.addAttribute("groupTreeList", groupTreeList);
    	
        return "common/groupTreePopList";
    }
    
    
	/**
	 * 조직도의 플러스 아이콘을 눌렀을 때 하위 조직을 조회한다.
	 */
    
    @RequestMapping(value="/common/selectGroupTreeSeq.do", method = RequestMethod.POST)
    public @ResponseBody String selectGroupTreeSeq (@RequestParam(value="seq", required=true) String seq) throws Exception   {
    	List groupTreeChildList = cmnGroupSearchService.selectGroupTreeSeq(seq);
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("list", groupTreeChildList);
    	jsonObject.put("size", groupTreeChildList.size());
        return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
    
    /**
   	 * 그룹 검색 카운트 조회
   	 */
    @RequestMapping("/common/selectGroupCheck.do")
    public @ResponseBody String selectGroupCheck(
    		HttpServletRequest request, CmnGroupSearchVO cmnGroupSearchVO, HttpSession session
    		) throws Exception {
    	// 권한 설정
    	TextUtil textUtil = TextUtil.getInstance();
    	
    	cmnGroupSearchVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
    	cmnGroupSearchVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
    	cmnGroupSearchVO.setStrSessionGroupId( request.getParameter("hidAccessPolicy").equals("groupUp") 
    			? textUtil.validateParam((String)session.getAttribute("parent_group_id")) 
    			: textUtil.validateParam((String)session.getAttribute("group_id")));

 		if(!cmnGroupSearchVO.getStrSessionLoginString().equals("admin")) {
		
    	String strChildGroupId = "";
		CmnPrivateVO cmmPrivateVO = new CmnPrivateVO();
		
		cmmPrivateVO.setStrSessionGroupId( 
				request.getParameter("hidAccessPolicy").equals("groupUp") 
				? textUtil.validateParam((String)session.getAttribute("parent_group_id")) 
    			: textUtil.validateParam((String)session.getAttribute("group_id")));
		strChildGroupId = cmnPrivateService.selectChildGroupId(cmmPrivateVO);
		
		String[] temp = strChildGroupId.split(",");
			cmnGroupSearchVO.setArrChildGroupId(temp);
			
    	}
    	//--
    	JSONObject jsonObject = new JSONObject();
   		
    	cmnGroupSearchVO.setSearchType(request.getParameter("searchType"));
    	cmnGroupSearchVO.setSearchText(request.getParameter("searchText"));
   		
   		List<CmnGroupSearchVO> groupCheckList = cmnGroupSearchService.selectGroupCheck(cmnGroupSearchVO);
   		
   		if (groupCheckList.size() == 1){
   			jsonObject.put("count", groupCheckList.size());
   			jsonObject.put("groupId", groupCheckList.get(0).getGroupId());
			jsonObject.put("groupName", groupCheckList.get(0).getGroupName());
		} else {
			jsonObject.put("count", groupCheckList.size());
		}
   			
		return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
    
    /**
	 * 그룹 리스트 팝업.
	 */
    @RequestMapping("/common/groupCommonPopMain.do")
    public String groupCommonPopMainView(
            @ModelAttribute("cmnGroupSearchVO") CmnGroupSearchVO cmnGroupSearchVO, Model model, HttpSession session
            ) throws Exception {
        return "common/groupCommonPopMain";
    }
    

    
    /**
	 * 그룹 리스트 조회 (팝업버튼############)
	 */
    @RequestMapping("/common/selectGroupList.do")
    public String selectGroupList(@ModelAttribute("cmnGroupSearchVO") CmnGroupSearchVO cmnGroupSearchVO, HttpServletRequest request, Model model, HttpSession session) throws Exception {
    	
    	// 권한 설정
    	TextUtil textUtil = TextUtil.getInstance();
    	cmnGroupSearchVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
    	cmnGroupSearchVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
    	cmnGroupSearchVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("group_id")) );
    	
    	if(cmnGroupSearchVO.getStrSessionLoginString().equals("admin")){
    		cmnGroupSearchVO.setStrAccessPolicy("all");
    	} else {
    		if(cmnGroupSearchVO.getStrAccessPolicy().equals("groupUp")){
    			//test
    			String strChildGroupId = "";
    			CmnPrivateVO cmmPrivateVO = new CmnPrivateVO();
    			
    			cmmPrivateVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("parent_group_id")) );
    			strChildGroupId = cmnPrivateService.selectChildGroupId(cmmPrivateVO);
    			
    			String[] temp = strChildGroupId.split(",");
    			cmnGroupSearchVO.setArrChildGroupId(temp);
    			
    		}
    		else if(cmnGroupSearchVO.getStrAccessPolicy().equals("group")) {
    			String strChildGroupId = "";
    			CmnPrivateVO cmmPrivateVO = new CmnPrivateVO();
    			
    			cmmPrivateVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("group_id")) );
    			strChildGroupId = cmnPrivateService.selectChildGroupId(cmmPrivateVO);
    			
    			String[] temp = strChildGroupId.split(",");
    			cmnGroupSearchVO.setArrChildGroupId(temp);
    			
    		} else if(cmnGroupSearchVO.getStrAccessPolicy().equals("own")) {
    			String arrTemp[] = new String[1];
        		arrTemp[0] = session.getAttribute("group_id").toString();
        		cmnGroupSearchVO.setArrChildGroupId(arrTemp);
    		}
    	}

    	List groupList = cmnGroupSearchService.selectGroupList(cmnGroupSearchVO);
    	model.addAttribute("groupList", groupList);
    	
    	return "common/groupCommonPopList";
    }
    
    
    /*  @RequestMapping("/common/groupUserCommonPopMain.do")
    public String groupUserCommonPopMainView(
            @ModelAttribute("cmnGroupSearchVO") CmnGroupSearchVO cmnGroupSearchVO, Model model, HttpSession session
            ) throws Exception {
        return "common/groupUserCommonPopMain";
    }*/
    
    
    
    /*@RequestMapping("/common/selectGroupUserList.do")
    public String selectGroupUserList(@ModelAttribute("cmnGroupSearchVO") CmnGroupSearchVO cmnGroupSearchVO, HttpServletRequest request, Model model, HttpSession session) throws Exception {
    	
    	// 권한 설정
    	TextUtil textUtil = TextUtil.getInstance();
    	cmnGroupSearchVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
    	cmnGroupSearchVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
    	cmnGroupSearchVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("group_id")) );
    	
    	if(cmnGroupSearchVO.getStrSessionLoginString().equals("admin")){
    		cmnGroupSearchVO.setStrAccessPolicy("all");
    	} else {
    		
    		if(cmnGroupSearchVO.getStrAccessPolicy().equals("group")) {
    			String strChildGroupId = "";
    			CmnPrivateVO cmmPrivateVO = new CmnPrivateVO();
    			
    			cmmPrivateVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("group_id")) );
    			String strParentGroupId = cmnPrivateService.selectParentGroupId(cmmPrivateVO);
    			
    			cmmPrivateVO.setStrSessionGroupId( strParentGroupId );
    			strChildGroupId = cmnPrivateService.selectChildGroupId(cmmPrivateVO);
    			
    			String[] temp = strChildGroupId.split(",");
    			cmnGroupSearchVO.setArrChildGroupId(temp);
    			
    		} else if(cmnGroupSearchVO.getStrAccessPolicy().equals("own")) {
    			String arrTemp[] = new String[1];
        		arrTemp[0] = session.getAttribute("group_id").toString();
        		cmnGroupSearchVO.setArrChildGroupId(arrTemp);
        		
    		}
    	}

    	List groupList = cmnGroupSearchService.selectGroupList(cmnGroupSearchVO);
    	model.addAttribute("groupList", groupList);
    	
    	return "common/groupCommonPopList";
    }*/
}