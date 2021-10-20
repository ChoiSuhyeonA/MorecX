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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.irlink.zirecx.system.service.MainService;
import kr.co.irlink.zirecx.system.service.MainVO;


import org.apache.taglibs.standard.tag.common.core.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;


@Controller

public class MainController {
	
	/** MainService */
    @Resource(name = "mainService")
    private MainService mainService;

    /** 권한에 따라 첫번째 화면의 분기를 잡아줌 */
    @RequestMapping("/common/main.do")
    public String mainView(
            @ModelAttribute("mainVO") MainVO mainVO, Model model, HttpSession session)
            throws Exception {
    	if(!session.getAttribute("zirecx_id").equals("admin")){
//    		return "forward:" + ;
//    		String startMenu = mainService.selectStartMenu(session.getAttribute("security_group_id").toString());
//    		if(startMenu == null){
//    			return "forward:/record/recordManageMain.do";
//    		}else{
//    			return "forward:" + startMenu;
//    		}
    	}    	
    	
    	//return "common/main";
//    	return "forward:/common/main.do";
    	return "forward:/common/main_frame.do";
    }
    
    @RequestMapping("/common/main_frame.do")
    public String mainFrameView(
            @ModelAttribute("mainVO") MainVO mainVO, Model model, HttpSession session)
            throws Exception {
    	
    	//246 총무 권한 :: 실서버 
    	if (session.getAttribute("security_group_id").equals("246")) {
            model.addAttribute("target", "/smart/smartPhoneManageMain.do"); 
        }
        else {
            model.addAttribute("target", "/record/linkCallManageMain.do");
        }
        return "common/main";
    }
    
    @RequestMapping("/common/leftMenuTab.do")
    public String leftMenuTabView(
            @ModelAttribute("mainVO") MainVO mainVO, Model model)
            throws Exception {
    	return "common/leftMenuTab";
    }
    
    @RequestMapping("/common/leftMenu.do")
    public String leftMenuView(
            @ModelAttribute("mainVO") MainVO mainVO, Model model)
            throws Exception {
    	return "common/leftMenu";
    }
}
