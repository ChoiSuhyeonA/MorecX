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

import kr.co.irlink.zirecx.common.service.CampaignPopService;
import kr.co.irlink.zirecx.common.service.CampaignPopSearchVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.fdl.property.EgovPropertyService;


@Controller

public class CampaignPopController {
	
	/** CampaignPopService */
    @Resource(name = "campaignPopService")
    private CampaignPopService campaignPopService;
	
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    /**
	 * 캠페인 팝업.
	 */
    @RequestMapping("/common/campaignPopMain.do")
    public String campaignPopMainView(@ModelAttribute("campaignPopSearchVO") CampaignPopSearchVO campaignPopSearchVO, Model model, HttpSession session) throws Exception {
    	return "common/campaignPopMain";
    }
    
    /**
	 * 캠페인 팝업 리스트를 조회한다.
	 */
    @RequestMapping("/common/campaignPopList.do")
    public String selectCampaignPopList(@ModelAttribute("campaignPopSearchVO") CampaignPopSearchVO campaignPopSearchVO, Model model, HttpSession session
            ) throws Exception {
    	
    	campaignPopSearchVO.setStrCampName("%"+campaignPopSearchVO.getStrCampName()+"%"); //해당값이 들어가는 전체 검사
		List campaignPopList = campaignPopService.selectCampaignPopList(campaignPopSearchVO);
    	model.addAttribute("campaignPopList", campaignPopList);
    	model.addAttribute("campaignPopListSize", campaignPopList.size());
    	
        return "common/campaignPopList";
    } 
}