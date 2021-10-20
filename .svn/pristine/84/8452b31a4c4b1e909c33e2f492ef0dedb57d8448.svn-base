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
import javax.servlet.http.HttpSession;

import kr.co.irlink.zirecx.common.service.CmnPrivateService;
import kr.co.irlink.zirecx.common.service.CmnPrivateVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.rte.fdl.property.EgovPropertyService;
//import kr.co.irlink.zirecx.system.service.UserSearchVO;

@Controller

public class CmnPrivateController {
	
	/** CmnPrivateService */
    @Resource(name = "cmnPrivateService")
    private CmnPrivateService cmnPrivateService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /** Validator */
    @Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
    
    /**
	 * 사용자관리 페이지의 각 권한을 불러오는 메소드
	 */
    //@RequestMapping("/common/selectPrivateList.do")
    public List getPriv(@ModelAttribute("cmnPrivateVO") CmnPrivateVO cmnPrivateVO, Model model, HttpSession session) throws Exception {
    	
    	cmnPrivateVO.setStrSecurityGroupId((String)session.getAttribute("security_group_id"));
    	List listPrivate = cmnPrivateService.selectPrivateList(cmnPrivateVO);
    	
    	return listPrivate;
    }
}