package kr.co.irlink.zirecx.smart.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.core.Util;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.co.irlink.zirecx.common.service.CmnGroupSearchService;
import kr.co.irlink.zirecx.common.service.CmnPrivateService;
import kr.co.irlink.zirecx.common.service.CmnPrivateVO;
import kr.co.irlink.zirecx.common.service.CmnUserSearchVO;
import kr.co.irlink.zirecx.smart.service.SmartPhoneManageService;
import kr.co.irlink.zirecx.smart.service.SmartPhoneSearchVO;
import net.sf.json.JSONObject;

@Controller
public class SmartPhoneManageController {
	
    @Resource(name = "smartPhoneManageService")
    private SmartPhoneManageService smartPhoneManageService;
    
    @Resource(name = "cmnPrivateService")
    private CmnPrivateService cmnPrivateService;
    
    @Resource(name = "cmnGroupSearchService")
    private CmnGroupSearchService cmnGroupSearchService;
    
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    @Resource(name = "messageSource")
    MessageSource messageSource;

    @RequestMapping({"/smart/smartPhoneManageMain.do"})
    public String SmartPhoneManageMainView(@ModelAttribute("smartPhoneSearchVO") SmartPhoneSearchVO smartPhoneSearchVO, Model model, HttpSession session) throws Exception {
        CmnPrivateVO cmnPrivateVO = new CmnPrivateVO();
        
        /**
         *  신규, 저장, 조직선택, 조직도, 엑셀 
         */
        String[] privName = {
        		messageSource.getMessage("message.db_new", null, Locale.getDefault())
              , messageSource.getMessage("message.db_save", null, Locale.getDefault())
              , messageSource.getMessage("message.db_group_select", null, Locale.getDefault())
              , messageSource.getMessage("message.db_group_tree", null, Locale.getDefault())
              , messageSource.getMessage("message.db_user_select", null, Locale.getDefault())
              , messageSource.getMessage("message.db_excel", null, Locale.getDefault())
        };
        
        cmnPrivateVO.setPrivName(privName);
        cmnPrivateVO.setStrSecurityGroupId((String)session.getAttribute("security_group_id"));
        
        List listPrivate = cmnPrivateService.selectPrivateList(cmnPrivateVO);
        
        /**
         * @@ 권한관련 Fuction 6가지 
         * 	1. 버튼 신규
         *  2. 버튼 저장
         *  3. 그룹선택 권한
         *  4. 그룹트리 권한
         *  5. 엑셀 다운로드 권한
         */
        String strPrivName = 
        		messageSource.getMessage("message.db_new", null, Locale.getDefault()) + "," + "btn_new" + "," + "버튼" + "|"
        	  + messageSource.getMessage("message.db_save", null, Locale.getDefault()) + "," + "btn_save" + "," + "버튼" + "|" 
        	  + messageSource.getMessage("message.db_group_select", null, Locale.getDefault()) + "," + "," + "그룹" + "|"
        	  + messageSource.getMessage("message.db_group_tree", null, Locale.getDefault()) + "," + "," + "그룹트리" + "|"
        	  + messageSource.getMessage("message.db_user_select", null, Locale.getDefault()) + "," + "" + "," + "사용자" + "|"
        	  + messageSource.getMessage("message.db_excel", null, Locale.getDefault()) + "," + "," + "엑셀다운";
        
        
        model.addAttribute("strPrivName", strPrivName);
        model.addAttribute("listPrivate", listPrivate);
        return "smart/smartPhoneManageMain";
    }

    @RequestMapping({"/smart/smartPhoneManageInitList.do"})
    public String smartPhoneManageInitList(HttpServletRequest request, @ModelAttribute("smartPhoneSearchVO") SmartPhoneSearchVO smartPhoneSearchVO, Model model, HttpSession session) throws Exception {
        ArrayList<EgovMap> newSmartPhoneList = new ArrayList();
        model.addAttribute("smartPhoneList", newSmartPhoneList);
        model.addAttribute("totCnt", 0);
        return "smart/smartPhoneManageList";
    }
    
    @RequestMapping("/smart/smartPhoneManageListExcel.do")
    public ModelAndView selectCheckSmartPhoneExcelList(
    		@ModelAttribute("smartPhoneSearchVO") SmartPhoneSearchVO smartPhoneSearchVO, HttpServletRequest request, HttpSession session
    		) throws Exception {
    	
    	ModelAndView mav = new ModelAndView("smart/smartPhoneManageListExcel");
    	
    	smartPhoneSearchVO.setPageSize(this.propertiesService.getInt("pageSize"));
        if (smartPhoneSearchVO.getPagelist().equals("10")) {
            smartPhoneSearchVO.setPageUnit(this.propertiesService.getInt("pageUnit10"));
        } else if (smartPhoneSearchVO.getPagelist().equals("50")) {
            smartPhoneSearchVO.setPageUnit(this.propertiesService.getInt("pageUnit50"));
        } else if (smartPhoneSearchVO.getPagelist().equals("100")) {
            smartPhoneSearchVO.setPageUnit(this.propertiesService.getInt("pageUnit100"));
        } else if (smartPhoneSearchVO.getPagelist().equals("200")) {
            smartPhoneSearchVO.setPageUnit(this.propertiesService.getInt("pageUnit200"));
        }

        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(smartPhoneSearchVO.getPageIndex());
        paginationInfo.setRecordCountPerPage(smartPhoneSearchVO.getPageUnit());
        paginationInfo.setPageSize(smartPhoneSearchVO.getPageSize());
        smartPhoneSearchVO.setFirstIndex(paginationInfo.getFirstRecordIndex() + 1);
        smartPhoneSearchVO.setLastIndex(paginationInfo.getLastRecordIndex());
        smartPhoneSearchVO.setCountPerPage(paginationInfo.getRecordCountPerPage());
        
        String[] arrSelectedId = smartPhoneSearchVO.getSelectedId().split(",");
        if(Arrays.toString(arrSelectedId).equals("[]")){
        	return new ModelAndView("common/recordAlertCheck");
        }
        	
        smartPhoneSearchVO.setArrSelectedId(arrSelectedId);
        List smartPhoneList = smartPhoneManageService.selectSmartPhoneExcelList(smartPhoneSearchVO);
        
        mav.addObject("smartPhoneList", smartPhoneList);
        int totCnt = this.smartPhoneManageService.selectSmartPhoneCnt(smartPhoneSearchVO);
        mav.addObject("totCnt", totCnt);
        paginationInfo.setTotalRecordCount(totCnt);
        smartPhoneSearchVO.setMaxPage(totCnt / Integer.parseInt(smartPhoneSearchVO.getPagelist()));
        mav.addObject("maxPage", smartPhoneSearchVO.getMaxPage());
        mav.addObject("paginationInfo", paginationInfo);
        int cnt = 0;
        if (smartPhoneSearchVO.getPageIndex() > 1) {
            cnt = (smartPhoneSearchVO.getPageIndex() - 1) * smartPhoneSearchVO.getPageUnit();
        }

        mav.addObject("cnt", cnt);

        return mav;

    }

    @RequestMapping("/smart/smartPhoneManageList.do")
    public String smartPhoneManageList(HttpServletRequest request, @ModelAttribute("smartPhoneSearchVO") SmartPhoneSearchVO smartPhoneSearchVO, Model model, HttpSession session) throws Exception {
        smartPhoneSearchVO.setPageSize(this.propertiesService.getInt("pageSize"));
        if (smartPhoneSearchVO.getPagelist().equals("10")) {
            smartPhoneSearchVO.setPageUnit(this.propertiesService.getInt("pageUnit10"));
        } else if (smartPhoneSearchVO.getPagelist().equals("50")) {
            smartPhoneSearchVO.setPageUnit(this.propertiesService.getInt("pageUnit50"));
        } else if (smartPhoneSearchVO.getPagelist().equals("100")) {
            smartPhoneSearchVO.setPageUnit(this.propertiesService.getInt("pageUnit100"));
        } else if (smartPhoneSearchVO.getPagelist().equals("200")) {
            smartPhoneSearchVO.setPageUnit(this.propertiesService.getInt("pageUnit200"));
        }

        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(smartPhoneSearchVO.getPageIndex());
        paginationInfo.setRecordCountPerPage(smartPhoneSearchVO.getPageUnit());
        paginationInfo.setPageSize(smartPhoneSearchVO.getPageSize());
        smartPhoneSearchVO.setFirstIndex(paginationInfo.getFirstRecordIndex() + 1);
        smartPhoneSearchVO.setLastIndex(paginationInfo.getLastRecordIndex());
        smartPhoneSearchVO.setCountPerPage(paginationInfo.getRecordCountPerPage());
        
        List smartPhoneList = smartPhoneManageService.selectSmartPhoneList(smartPhoneSearchVO);
        
        model.addAttribute("smartPhoneList", smartPhoneList);
        int totCnt = this.smartPhoneManageService.selectSmartPhoneCnt(smartPhoneSearchVO);
        model.addAttribute("totCnt", totCnt);
        paginationInfo.setTotalRecordCount(totCnt);
        smartPhoneSearchVO.setMaxPage(totCnt / Integer.parseInt(smartPhoneSearchVO.getPagelist()));
        model.addAttribute("maxPage", smartPhoneSearchVO.getMaxPage());
        model.addAttribute("paginationInfo", paginationInfo);
        int cnt = 0;
        if (smartPhoneSearchVO.getPageIndex() > 1) {
            cnt = (smartPhoneSearchVO.getPageIndex() - 1) * smartPhoneSearchVO.getPageUnit();
        }

        model.addAttribute("cnt", cnt);
        return "smart/smartPhoneManageList";
    }

    @RequestMapping(value = {"/smart/smartPhoneManageDetail.do"},method = {RequestMethod.POST})
    @ResponseBody
    public String smartPhoneManageDetail(@RequestParam(value = "phoneNumber",required = true) String phoneNumber) throws Exception {
        SmartPhoneSearchVO smartPhoneSearchVO = new SmartPhoneSearchVO();
        smartPhoneSearchVO.setPhoneNumber(phoneNumber);
        List detailSmartPhone = this.smartPhoneManageService.selectSmartPhoneDetail(smartPhoneSearchVO);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", detailSmartPhone);
        jsonObject.put("size", detailSmartPhone.size());
        return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+", " ");
    }

    @RequestMapping({"/smart/smartPhoneInfoManage.do"})
    @ResponseBody
    public String smartPhoneInfoManage(HttpServletRequest request) throws Exception {
        SmartPhoneSearchVO smartPhoneSearchVO = new SmartPhoneSearchVO();
        smartPhoneSearchVO.setGroupId(request.getParameter("groupIdDetail"));
        smartPhoneSearchVO.setPhoneNumber(request.getParameter("detail_phoneNumber"));
        smartPhoneSearchVO.setImei(request.getParameter("detail_imei"));
        smartPhoneSearchVO.setUseStatusFlag(request.getParameter("detail_useStatusFlag"));
        smartPhoneSearchVO.setMemo(request.getParameter("detail_memo"));
        smartPhoneSearchVO.setUpdateUserId((String)request.getSession().getAttribute("user_id"));
        int result = 0;

        if (request.getParameter("jobType").equals("update")) {
            smartPhoneSearchVO.setId(Integer.parseInt(request.getParameter("id")));
            if (smartPhoneSearchVO.getUpdateUserId().equals("1")) {
                result = this.smartPhoneManageService.updateAdminSmartPhone(smartPhoneSearchVO);
                if (result > 0) {
                    result = 2;
                }
            } else {
                result = this.smartPhoneManageService.updateSmartPhone(smartPhoneSearchVO);
                if (result > 0) {
                    result = 2;
                }
            }
        } else {
            result = this.smartPhoneManageService.insertSmartPhone(smartPhoneSearchVO);
            if (result > 0) {
                result = 1;
            }
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+", " ");
    }
    
    
    /******************************* 스마트폰 관리 작업자 팝업 *************************************/
    
    
    
    @RequestMapping("/smart/smartPhoneUserPopMain.do")
    public ModelAndView smartPhoneUserPopMain(@ModelAttribute("cmnUserSearchVO") CmnUserSearchVO cmnUserSearchVO, HttpSession session)
 		   throws Exception {
 	   ModelAndView mav = new ModelAndView();
 	   mav.setViewName("smart/smartPhoneUserPopMain");
 	   
 	   return mav;
    }
    
    @RequestMapping("/smart/selectSmartPhoneUserList.do")
    public String selectSmartPhoneUserList(@ModelAttribute("cmnUserSearchVO") final CmnUserSearchVO cmnUserSearchVO, final Model model, final HttpSession session) throws Exception {
        final List userPopList = smartPhoneManageService.selectSmartPhoneUserList(cmnUserSearchVO);
        model.addAttribute("userList", (Object)userPopList);
        model.addAttribute("userListSize", (Object)userPopList.size());
        return "smart/smartPhoneUserPopList";
    }
    
}
