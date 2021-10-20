package kr.co.irlink.zirecx.system.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.irlink.zirecx.system.service.AccessManageService;
import kr.co.irlink.zirecx.system.service.AccessSearchVO;
import kr.co.irlink.zirecx.system.service.GradeSearchVO;

import net.sf.json.JSONObject;

import org.apache.taglibs.standard.tag.common.core.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller

public class AccessManageController {
	
	/** AccessManageService */
    @Resource(name = "accessManageService")
    private AccessManageService accessManageService;
    
    /**
	 * 접근권한관리 페이지 로딩
	 */
    @RequestMapping("/system/accessManageMain.do")
    public String gradeManageMainView(@ModelAttribute("accessSearchVO") AccessSearchVO accessSearchVO, Model model, HttpSession session) throws Exception {
    	return "system/accessManageMain";
    }
    
    /**
	 * 접근권한 리스트를 조회한다.
	 */
    @RequestMapping("/system/accessManageList.do")
    public String selectAccessList(
    		@ModelAttribute("accessSearchVO") AccessSearchVO accessSearchVO, Model model, HttpSession session
            ) throws Exception {
    	
		List accessMenuList = accessManageService.selectAccessMenuList(accessSearchVO);
    	model.addAttribute("accessMenuList", accessMenuList);
    	
    	List accessColumnList = accessManageService.selectAccessColumnList(accessSearchVO);
    	model.addAttribute("accessColumnList", accessColumnList);
    	
    	List accessDataList = accessManageService.selectAccessDataList(accessSearchVO);
    	model.addAttribute("accessDataList", accessDataList);
    	
        return "system/accessManageList";
    }
    
    /**
   	 * 접근권한 리스트상세정보를 조회한다.
   	 */
    @RequestMapping("/system/accessManageDetail.do")
    public @ResponseBody String selectAccessDetail (HttpServletRequest request, AccessSearchVO accessSearchVO, HttpSession session
    		) throws Exception   {

   		JSONObject jsonObject = new JSONObject();
   		
   		List accessDetail = accessManageService.selectAccessDetail(accessSearchVO);
       	jsonObject.put("list", accessDetail);    
    	jsonObject.put("size", accessDetail.size());
           
       	return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
    
    /**
	 * 접근권한을 변경한다.
	 */
    @RequestMapping("/system/accessManageChangePolicy.do")
    public @ResponseBody String changePolicy (
    		HttpServletRequest request, AccessSearchVO accessSearchVO, HttpSession session
    		) throws Exception   {
    	
    	accessSearchVO.setStrPrivPointId(request.getParameter("strPrivPointId"));
    	accessSearchVO.setStrGroupId(request.getParameter("strGroupId"));
    	accessSearchVO.setHidAccessPolicyId(request.getParameter("hidAccessPolicyId"));
    	accessSearchVO.setStrValue(request.getParameter("strValue"));
		
    	int result = 0;
    	
    	if(accessSearchVO.getStrValue().equals("sel") || accessSearchVO.getStrValue().equals("false")){
    		result = accessManageService.deletePolicy(accessSearchVO);
    	}else{
    		if(!accessSearchVO.getHidAccessPolicyId().equals("") && !accessSearchVO.getStrValue().equals("true")){
    			result = accessManageService.updatePolicy(accessSearchVO);
    		}else{
    			result = accessManageService.insertPolicy(accessSearchVO);
    		}
    	}
    	 
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("result", result);
        return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");

    }
    
    /**
	 * 메뉴접근권한을 변경한다.
	 */
    @RequestMapping("/system/accessManageChangeMenu.do")
    public @ResponseBody String changeMenu (
    		HttpServletRequest request, AccessSearchVO accessSearchVO, HttpSession session
    		) throws Exception   {
    	
    	accessSearchVO.setStrPrivPointId(request.getParameter("strPrivPointId"));
    	accessSearchVO.setStrGroupId(request.getParameter("strGroupId"));
    	accessSearchVO.setHidAccessPolicyId(request.getParameter("hidAccessPolicyId"));
    	accessSearchVO.setStrValue(request.getParameter("strValue"));
		
    	int result = 0;
    	
    	if(accessSearchVO.getStrValue().equals("0")){
    		result = accessManageService.deletePolicy(accessSearchVO);
    	}else{
    		if(!accessSearchVO.getHidAccessPolicyId().equals("")){
    			result = accessManageService.updatePolicy(accessSearchVO);
    		}else{
    			result = accessManageService.insertPolicy(accessSearchVO);
    		}
    	}
    	 
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("result", result);
        return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");

    }
}
