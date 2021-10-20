package kr.co.irlink.zirecx.system.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.irlink.zirecx.record.service.RecordManageService;
import kr.co.irlink.zirecx.system.service.GradeManageService;
import kr.co.irlink.zirecx.system.service.GradeSearchVO;
import kr.co.irlink.zirecx.system.service.GroupManageService;
import kr.co.irlink.zirecx.system.service.GroupSearchVO;
import kr.co.irlink.zirecx.system.service.UserSearchVO;

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

public class GradeManageController {
	
	/** GradeManageService */
    @Resource(name = "gradeManageService")
    private GradeManageService gradeManageService;
    
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    /**
	 * 권한관리 페이지 로딩
	 */
    @RequestMapping("/system/gradeManageMain.do")
    public String gradeManageMainView(@ModelAttribute("gradeSearchVO") GradeSearchVO gradeSearchVO, Model model, HttpSession session) throws Exception {
    	return "system/gradeManageMain";
    }
    
    /**
   	 * 권한 팝업.
   	 */
    @RequestMapping("/system/gradePopMain.do")
    public String gradePopMainView(@ModelAttribute("gradeSearchVO") GradeSearchVO gradeSearchVO, Model model, HttpSession session) throws Exception {
    	return "system/gradePopMain";
    }
   
    /**
	 * 권한 팝업 리스트를 조회한다.
	 */
    @RequestMapping("/system/gradePopList.do")
    public String selectGradePopList(@ModelAttribute("gradeSearchVO") GradeSearchVO gradeSearchVO, Model model, HttpSession session
           ) throws Exception {
   	
		List gradePopList = gradeManageService.selectGradePopList(gradeSearchVO);
	   	model.addAttribute("gradePopList", gradePopList);
	   	model.addAttribute("gradePopListSize", gradePopList.size());
   	
       return "system/gradePopList";
    } 
    
    /**
	 * 권한 리스트를 조회한다.
	 */
    @RequestMapping("/system/gradeManageList.do")
    public String selectGradeList(
    		@ModelAttribute("gradeSearchVO") GradeSearchVO gradeSearchVO, Model model, HttpSession session
            ) throws Exception {

    	/** EgovPropertyService.sample */
    	gradeSearchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	gradeSearchVO.setPageSize(propertiesService.getInt("pageSize"));

    	if(gradeSearchVO.getPagelist().equals("10")){
    		gradeSearchVO.setPageUnit(propertiesService.getInt("pageUnit10"));
    	}else if(gradeSearchVO.getPagelist().equals("50")){
    		gradeSearchVO.setPageUnit(propertiesService.getInt("pageUnit50"));
    	}else if(gradeSearchVO.getPagelist().equals("100")){
    		gradeSearchVO.setPageUnit(propertiesService.getInt("pageUnit100"));
    	}else if(gradeSearchVO.getPagelist().equals("200")){
    		gradeSearchVO.setPageUnit(propertiesService.getInt("pageUnit200"));
    	}
    	/** paging setting */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(gradeSearchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(gradeSearchVO.getPageUnit());
		paginationInfo.setPageSize(gradeSearchVO.getPageSize());
		
		gradeSearchVO.setFirstIndex(paginationInfo.getFirstRecordIndex() + 1);
		gradeSearchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		gradeSearchVO.setGradeCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List gradeList = gradeManageService.selectGradeList(gradeSearchVO);
    	model.addAttribute("gradeList", gradeList);
    	
    	int totCnt = gradeManageService.selectGradeListTotCnt(gradeSearchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		gradeSearchVO.setMaxpage(totCnt/Integer.parseInt(gradeSearchVO.getPagelist()));
		//System.out.println(totCnt/Integer.parseInt(gradeSearchVO.getPagelist()));
		gradeSearchVO.setTotalCount(totCnt);
		
		model.addAttribute("totalCount", gradeSearchVO.getTotalCount());
		model.addAttribute("maxPage", gradeSearchVO.getMaxpage());
        model.addAttribute("paginationInfo", paginationInfo);
        
        /* 페이징 숫자 더하기 */
    	int cnt = 0;
        if(gradeSearchVO.getPageIndex() > 1){
        	cnt = (gradeSearchVO.getPageIndex() - 1) * gradeSearchVO.getPageUnit();
        }
        model.addAttribute("cnt", cnt);
    	
        return "system/gradeManageList";
    }
    
    /**
	 * 권한 상세정보를 조회한다.
	 */
    @RequestMapping(value="/system/gradeManageDetail.do", method = RequestMethod.POST)
    public @ResponseBody String selectGradeDetail (@RequestParam(value="gradeSeq", required=true) String gradeSeq
    		) throws Exception   {
    	
    	GradeSearchVO gradeSearchVO = new GradeSearchVO();
    	gradeSearchVO.setGradeSeq(gradeSeq);
    	
    	List detailGrade = gradeManageService.selectGradeDetail(gradeSearchVO);
    	
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("list", detailGrade);
    	jsonObject.put("size", detailGrade.size());
    	return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
    /**
   	 * 권한 인서트.
   	 */
    @RequestMapping("/system/gradeManageInsert.do")
    public @ResponseBody String insertGrade(
    		HttpServletRequest request, GradeSearchVO gradeSearchVO, HttpSession session
            ) throws Exception {

		JSONObject jsonObject = new JSONObject();
		
		gradeSearchVO.setGradeNameDT(request.getParameter("gradeNameDT"));
		gradeSearchVO.setGradeSortDT(request.getParameter("gradeSortDT"));
		
    	int result = gradeManageService.insertGroup(gradeSearchVO);
    	
    	jsonObject.put("result", result);    	
        return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
    
    @RequestMapping("/system/gradeManageUpdate.do")
    public @ResponseBody String updateGrade(
    		GradeSearchVO gradeSearchVO, HttpServletRequest request
            ) throws Exception {

    	JSONObject jsonObject = new JSONObject();
    	int updateCnt = 0;
    	
    	gradeSearchVO.setGradeSeq(request.getParameter("gradeSeq"));
    	gradeSearchVO.setGradeNameDT(request.getParameter("gradeNameDT"));
    	gradeSearchVO.setGradeSortDT(request.getParameter("gradeSortDT"));
    	gradeSearchVO.setDeleteYnDT(request.getParameter("deleteYnDT"));
    	
    	updateCnt = gradeManageService.updateGrade(gradeSearchVO);
    	
    	if(updateCnt > 0) {
			jsonObject.put("result", "SUCCESS");
		} else {
			jsonObject.put("result", "FAILURE");
		}
    	
    	return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
}
