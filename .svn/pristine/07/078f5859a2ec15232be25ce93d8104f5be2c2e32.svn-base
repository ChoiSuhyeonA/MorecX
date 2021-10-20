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
import javax.servlet.http.HttpSession;

import kr.co.irlink.zirecx.login.service.MainFrameService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class MainFrameController {
	
	/** MainFrameService */
    @Resource(name = "mainFrameService")
    private MainFrameService mainFrameService;

    /**
	 * topFrame 화면을 조회한다.
	 * @return "common/topFrame"
	 * @exception Exception
	 */
    @RequestMapping("/common/top.do")
    public String topFrameView() throws Exception {
        return "common/top";
    }
    
    @RequestMapping("/common/menu.do")
    public String menuView() throws Exception {
        return "common/menu";
    }

	/**
	 * bottomFrame 화면을 조회한다.
	 * @return "common/bottomFrame"
	 * @exception Exception
	 */
    @RequestMapping("/common/bottomFrame.do")
    public String bottomFrameView() throws Exception {
        return "common/bottomFrame";
    }

    /**
	 * menuFrame 화면을 조회한다.
	 * @return "common/menuFrame"
	 * @exception Exception
	 */
/*    @RequestMapping("/common/menuFrame.do")
    public String menuFrameView(
            @ModelAttribute("loginVO") LoginVO loginVO, Model model
            ) throws Exception {
        model.addAttribute("loginVO", new LoginVO());
        return "common/menuFrame";
    }*/
    
    /**
	 * 메뉴리스트를 받아온다.
	 * @return "/common/menuFrame"
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	@RequestMapping("/common/menuFrame.do")
    public String selectMenu(
    		Model model, HttpSession session
            ) throws Exception {
    	String userSeq = (String)session.getAttribute("zmsUserSeq");
    	//String userSeq = "11";
    	List listMenu = mainFrameService.selectMenu(userSeq);
    	model.addAttribute("menuList", listMenu);
    	
    	return "common/menuFrame";
    }
}