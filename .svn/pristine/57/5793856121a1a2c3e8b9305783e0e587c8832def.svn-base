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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.irlink.zirecx.system.service.CodeSearchVO;
import kr.co.irlink.zirecx.system.service.CodeManageService;

import net.sf.json.JSONObject;

import org.apache.taglibs.standard.tag.common.core.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class CodeManageController {

	/** CodeService */
    @Resource(name = "codeManageService")
    private CodeManageService codeManageService;
    
	/**
	 * 공통코드 관리.
	 */
    @RequestMapping("/system/codeManageMain.do")
    public String codeManageMainView(@ModelAttribute("codeSearchVO") CodeSearchVO codeSearchVO, HttpSession session) throws Exception {
    	return "system/codeManageMain";
    }
    
    
    @RequestMapping("/system/codeManageMasterList.do")
    public String selectCodeMasterList(
    		@ModelAttribute("codeSearchVO") CodeSearchVO codeSearchVO, Model model, HttpSession session
            ) throws Exception {
    	
    	/** 마스터코드 리스트를 가져온다. */
		List codeMasterList = codeManageService.selectCodeMasterList(codeSearchVO);
    	model.addAttribute("codeMasterList", codeMasterList);
    	
        return "system/codeManageMasterList";
    }
    
    @RequestMapping("/system/codeManageDetailList.do")
    public String selectCodeDetailList(
    		@ModelAttribute("codeSearchVO") CodeSearchVO codeSearchVO, Model model, HttpSession session
            ) throws Exception {
    	
    	/** 마스터코드 리스트를 가져온다. */
		List codeDetailList = codeManageService.selectCodeDetailList(codeSearchVO);
    	model.addAttribute("codeDetailList", codeDetailList);
    	
        return "system/codeManageDetailList";
    }
    
    @RequestMapping("/system/updateCodeManageMaster.do")
    public @ResponseBody String updateCodeManageMaster(
    		@ModelAttribute("codeSearchVO") CodeSearchVO codeSearchVO, HttpServletRequest request
            ) throws Exception {
    	
    	JSONObject jsonObject = new JSONObject();
    	int updateCnt = 0;
    	
    	codeSearchVO.setMasterCode(request.getParameter("masterCode"));
    	codeSearchVO.setMasterCodeName(request.getParameter("masterCodeName"));
    	codeSearchVO.setMasterDetailInfo(request.getParameter("masterDetailInfo"));
    	codeSearchVO.setMasterDeleteYn(request.getParameter("masterDeleteYn"));
    	
    	/** 마스터코드를 수정한다. */ 
    	updateCnt = codeManageService.updateCodeManageMaster(codeSearchVO);
    	
    	if(updateCnt > 0) {
			jsonObject.put("result", "SUCCESS");
		} else {
			jsonObject.put("result", "FAILURE");
		}
    	
    	return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
    
    @RequestMapping("/system/insertCodeManageMaster.do")
    public @ResponseBody String insertCodeManageMaster(
    		@ModelAttribute("codeSearchVO") CodeSearchVO codeSearchVO, HttpServletRequest request
            ) throws Exception {
    	
    	JSONObject jsonObject = new JSONObject();
    	int insertCnt = 0;
    	
    	codeSearchVO.setMasterCode(request.getParameter("masterCode"));
    	codeSearchVO.setMasterCodeName(request.getParameter("masterCodeName"));
    	codeSearchVO.setMasterDetailInfo(request.getParameter("masterDetailInfo"));
    	codeSearchVO.setMasterDeleteYn(request.getParameter("masterDeleteYn"));
    	
    	/** 마스터코드를 저장한다. */ 
    	insertCnt = codeManageService.insertCodeManageMaster(codeSearchVO);
    	
    	if(insertCnt > 0) {
			jsonObject.put("result", "SUCCESS");
		} else {
			jsonObject.put("result", "FAILURE");
		}
    	
    	return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
    
    @RequestMapping("/system/updateCodeManageDetail.do")
    public @ResponseBody String updateCodeManageDetail(
    		@ModelAttribute("codeSearchVO") CodeSearchVO codeSearchVO, HttpServletRequest request
            ) throws Exception {
    	
    	JSONObject jsonObject = new JSONObject();
    	int updateCnt = 0;
    	
    	codeSearchVO.setDetailCode(request.getParameter("detailCode"));
    	codeSearchVO.setDetailCodeName(request.getParameter("detailCodeName"));
    	codeSearchVO.setDetailOrderNum(request.getParameter("detailOrderNum"));
    	codeSearchVO.setDetailDetailInfo(request.getParameter("detailDetailInfo"));
    	codeSearchVO.setDetailDeleteYn(request.getParameter("detailDeleteYn"));
    	codeSearchVO.setMasterCode(request.getParameter("masterCode"));
    	
    	/** 마스터코드를 수정한다. */ 
    	updateCnt = codeManageService.updateCodeManageDetail(codeSearchVO);
    	
    	if(updateCnt > 0) {
			jsonObject.put("result", "SUCCESS");
		} else {
			jsonObject.put("result", "FAILURE");
		}
    	
    	return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
    
    @RequestMapping("/system/insertCodeManageDetail.do")
    public @ResponseBody String insertCodeManageDetail(
    		@ModelAttribute("codeSearchVO") CodeSearchVO codeSearchVO, HttpServletRequest request
            ) throws Exception {
    	
    	JSONObject jsonObject = new JSONObject();
    	int insertCnt = 0;
    	
    	codeSearchVO.setDetailCode(request.getParameter("detailCode"));
    	codeSearchVO.setDetailCodeName(request.getParameter("detailCodeName"));
    	codeSearchVO.setDetailDetailInfo(request.getParameter("detailDetailInfo"));
    	codeSearchVO.setDetailDeleteYn(request.getParameter("detailDeleteYn"));
    	codeSearchVO.setMasterCode(request.getParameter("masterCode"));
    	
    	/** 마스터코드를 저장한다. */ 
    	insertCnt = codeManageService.insertCodeManageDetail(codeSearchVO);
    	
    	if(insertCnt > 0) {
			jsonObject.put("result", "SUCCESS");
		} else {
			jsonObject.put("result", "FAILURE");
		}
    	
    	return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
}
