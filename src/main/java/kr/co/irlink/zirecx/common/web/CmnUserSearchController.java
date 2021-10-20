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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.core.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import kr.co.irlink.zirecx.common.service.CmnGroupSearchService;
import kr.co.irlink.zirecx.common.service.CmnPrivateService;
import kr.co.irlink.zirecx.common.service.CmnPrivateVO;
import kr.co.irlink.zirecx.common.service.CmnUserSearchService;
import kr.co.irlink.zirecx.common.service.CmnUserSearchVO;
import kr.co.irlink.zirecx.util.TextUtil;
import net.sf.json.JSONObject;

/**
 * 2.0 미사용 컨트롤러 주석처리 
 * 
 * @author haedongkim
 *
 */
@Controller
public class CmnUserSearchController {
	
	/** CmnUserSearchService */
    @Resource(name = "cmnUserSearchService")
    private CmnUserSearchService cmnUserSearchService;
    
	/** GroupPopService */
    @Resource(name = "cmnGroupSearchService")
    private CmnGroupSearchService cmnGroupSearchService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    /** CmnPrivateService */
    @Resource(name = "cmnPrivateService")
    private CmnPrivateService cmnPrivateService;
    
    /**
	 * 사용자 검색 팝업. XXXX
	 */
    /*@RequestMapping("/common/userPopMain.do")
    public String userPopMainView(@ModelAttribute("cmnUserSearchVO") CmnUserSearchVO cmnUserSearchVO, Model model, HttpSession session) throws Exception {
    	return "common/userPopMain";
    }*/
    
    /**
	 * 사용자 검색 리스트를 조회한다. XXXX
	 */
    /*@RequestMapping("/common/userPopList.do")
    public String selectUserPopList(@ModelAttribute("cmnUserSearchVO") CmnUserSearchVO cmnUserSearchVO, Model model, HttpSession session
            ) throws Exception {
    	
//    	cmnUserSearchVO.setAuth((String) session.getAttribute("zirecx_id"));
    	
		List userPopList = cmnUserSearchService.selectUserPopList(cmnUserSearchVO);
    	model.addAttribute("userPopList", userPopList);
    	model.addAttribute("userPopListSize", userPopList.size());
    	
        return "common/userPopList";
    } */
    
	   /**
	    * 
	    * @param request
	    * @param cmnUserSearchVO (searchType, searchText, pageType)
	    * @param session
	    * @return
	    * @throws Exception
	    */
       @RequestMapping("/common/selectUserCheck.do")
       public @ResponseBody String selectUserCheck(HttpServletRequest request, CmnUserSearchVO cmnUserSearchVO, HttpSession session) throws Exception {

	   		TextUtil textUtil = TextUtil.getInstance();
	  	   
	 	    JSONObject jsonObject = new JSONObject();
			
	 	    //추가
	 	    cmnUserSearchVO.setStrAccessPolicy(request.getParameter("strAccessPolicy"));
	 	    cmnUserSearchVO.setStrSessionLoginString((String)session.getAttribute("login_string"));
	 	    cmnUserSearchVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("group_id")) );
		    cmnUserSearchVO.setStrSessionZirecxId( textUtil.validateParam((String)session.getAttribute("zirecx_id")) );
		       	
			String strChildGroupId = "";
	    	CmnPrivateVO cmnPrivateVO = new CmnPrivateVO();
	    	
	    	//searchSeq가 있는지..
	    	if(cmnUserSearchVO.getSearchGroupSeq().equals("")){
	    		//searchseq가 없는 경우 권한을 조회하여 정한다. 
	    		if(cmnUserSearchVO.getStrAccessPolicy().equals("groupUp")) {
	    			cmnPrivateVO.setStrSessionGroupId(textUtil.validateParam((String)session.getAttribute("parent_group_id")));
	    		} else {
	    			cmnPrivateVO.setStrSessionGroupId( 
	    					cmnUserSearchVO.getStrSessionLoginString().equals("admin") ? cmnUserSearchVO.getSearchGroupSeq() 
	    																			   : textUtil.validateParam((String)session.getAttribute("group_id")));
	    		}
	    	} 
	    	else {
	    		cmnPrivateVO.setStrSessionGroupId(cmnUserSearchVO.getSearchGroupSeq());
	    	}
		    
	        strChildGroupId = cmnPrivateService.selectChildGroupId(cmnPrivateVO);
			
		    String[] temp = strChildGroupId.split(",");
		    cmnUserSearchVO.setArrChildGroupId(temp);
	    
			List<CmnUserSearchVO> userCheckList = cmnUserSearchService.selectUserCheck(cmnUserSearchVO);
			
			if (userCheckList.size() == 1){
				jsonObject.put("count", userCheckList.size());
				jsonObject.put("userId", userCheckList.get(0).getUserId());
				jsonObject.put("userName", userCheckList.get(0).getUserName());
				jsonObject.put("zirecxId", userCheckList.get(0).getZirecxId());
			} else {
				jsonObject.put("count", userCheckList.size());
			}
			
			return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
	       }
       
       
    /**
   	 * 사용자 리스트 팝업.
   	 */
       @RequestMapping("/common/userCommonPopMain.do")
       public String userCommonPopMainView(
               @ModelAttribute("cmnUserSearchVO") CmnUserSearchVO cmnUserSearchVO, Model model, HttpSession session
               ) throws Exception {
           return "common/userCommonPopMain";
       }
       
       
    /**
   	 * 사용자 리스트 조회
   	 */
       @RequestMapping("/common/selectUserList.do")
       public String selectUserList(@ModelAttribute("cmnUserSearchVO") CmnUserSearchVO cmnUserSearchVO, HttpServletRequest request, Model model, HttpSession session) throws Exception {
    	   
    	   	// 권한 설정
	       	TextUtil textUtil = TextUtil.getInstance();
	       	
	       	cmnUserSearchVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
	       	cmnUserSearchVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
	       	cmnUserSearchVO.setStrSessionGroupId(textUtil.validateParam((String)session.getAttribute("group_id")));
	       	cmnUserSearchVO.setStrSessionZirecxId( textUtil.validateParam((String)session.getAttribute("zirecx_id")) );

	       	String strChildGroupId = "";
	    	CmnPrivateVO cmnPrivateVO = new CmnPrivateVO();
	    	
	    	//searchSeq가 있는지..
	    	if(cmnUserSearchVO.getSearchGroupSeq().equals("")){
	    		//searchseq가 없는 경우 권한을 조회하여 정한다. 
	    		if(cmnUserSearchVO.getStrAccessPolicy().equals("groupUp")) {
	    			cmnPrivateVO.setStrSessionGroupId(textUtil.validateParam((String)session.getAttribute("parent_group_id")));
	    		} else {
	    			cmnPrivateVO.setStrSessionGroupId( 
	    					cmnUserSearchVO.getStrSessionLoginString().equals("admin") ? cmnUserSearchVO.getSearchGroupSeq() 
	    																			   : textUtil.validateParam((String)session.getAttribute("group_id")));
	    		}
	    	} 
	    	else {
	    		cmnPrivateVO.setStrSessionGroupId(cmnUserSearchVO.getSearchGroupSeq());
	    	}
	    
	       strChildGroupId = cmnPrivateService.selectChildGroupId(cmnPrivateVO);
			
		   String[] temp = strChildGroupId.split(",");
		   cmnUserSearchVO.setArrChildGroupId(temp);
		   
    	   
    	   List userList = cmnUserSearchService.selectUserList(cmnUserSearchVO);
    	   model.addAttribute("userList", userList);
       	
    	   return "common/userCommonPopList";
       }
       

       
}