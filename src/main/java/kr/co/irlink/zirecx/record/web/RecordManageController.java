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
package kr.co.irlink.zirecx.record.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.core.Util;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.co.irlink.zirecx.common.service.CmnGroupSearchService;
import kr.co.irlink.zirecx.common.service.CmnGroupSearchVO;
import kr.co.irlink.zirecx.common.service.CmnPrivateService;
import kr.co.irlink.zirecx.common.service.CmnPrivateVO;
import kr.co.irlink.zirecx.record.service.RecordEditVO;
//import kr.co.irlink.zirecx.common.service.CommonService;
import kr.co.irlink.zirecx.record.service.RecordManageService;
import kr.co.irlink.zirecx.record.service.RecordPenVO;
import kr.co.irlink.zirecx.record.service.RecordSearchVO;
import kr.co.irlink.zirecx.util.AES256FileEncCBC;
import kr.co.irlink.zirecx.util.FileUtil;
import kr.co.irlink.zirecx.util.TextUtil;
import kr.co.irlink.zirecx.util.ZipUtil;
import net.sf.json.JSONObject;


@Controller

public class RecordManageController {
	
	/** CommonService */
//    @Resource(name = "commonService")
//    private CommonService commonService;

	/** RecordManageService */
    @Resource(name = "recordManageService")
    private RecordManageService recordManageService;

	/** GroupPopService */
    @Resource(name = "cmnGroupSearchService")
    private CmnGroupSearchService cmnGroupSearchService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    /** CmnPrivateService */
    @Resource(name = "cmnPrivateService")
    private CmnPrivateService cmnPrivateService;
    
    @Resource(name="messageSource")
	MessageSource messageSource ;

	private WebApplicationContext context = null;

    /**
	 * 녹취관리 화면을 조회한다.
	 */
    /*@SuppressWarnings({ "rawtypes"})
	@RequestMapping("/record/recordManageMain.do")
    public String recordManageMainView(
            @ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, Model model, HttpSession session
            ) throws Exception {
    	CmnPrivateVO cmnPrivateVO = new CmnPrivateVO();
    	
    	String[] privName = {
    			  messageSource.getMessage("message.db_new", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_save", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_group_select", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_group_tree", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_excel", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_recfile_down", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_goodcall_select", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_file_cvt", null, Locale.getDefault())
    	};
		
    	cmnPrivateVO.setPrivName(privName);
    	cmnPrivateVO.setStrSecurityGroupId((String)session.getAttribute("security_group_id"));
    	
    	List listPrivate = cmnPrivateService.selectPrivateList(cmnPrivateVO);
    	
    	String strPrivName = 
    			  messageSource.getMessage("message.db_new", null, Locale.getDefault()) + "," + "btn_new" + "," + "버튼" +"|"
    			+ messageSource.getMessage("message.db_save", null, Locale.getDefault()) + "," + "btn_save" + "," + "버튼" + "|"
    			+ messageSource.getMessage("message.db_group_select", null, Locale.getDefault()) + "," + "" + "," + "그룹" + "|"
    			+ messageSource.getMessage("message.db_group_tree", null, Locale.getDefault()) + "," + "" + "," + "그룹트리" + "|"
    			+ messageSource.getMessage("message.db_excel", null, Locale.getDefault()) + "," + "" + "," + "엑셀다운" + "|"
    			+ messageSource.getMessage("message.db_recfile_down", null, Locale.getDefault()) + "," + "" + "," + "파일다운" + "|"
    			+ messageSource.getMessage("message.db_goodcall_select", null, Locale.getDefault()) + "," + "" + "," + "굿콜지정" + "|"
    			+ messageSource.getMessage("message.db_file_cvt", null, Locale.getDefault()) + "," + "btn_cvt" + "," + "버튼"
    	;
    	model.addAttribute("strPrivName", strPrivName);
    	model.addAttribute("listPrivate", listPrivate);
    	
        return "record/recordManageMain";
    }*/
    
	
	/**
	 * 녹취관리 리스트를 조회한다.
	 */
    /*@SuppressWarnings("rawtypes")
	@RequestMapping("/record/recordManageList.do")
    public String selectRecordList(
    		@ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, HttpServletRequest request
    		, Model model, HttpSession session
            ) throws Exception {
    	
    	TextUtil textUtil = TextUtil.getInstance();
    	
    	recordSearchVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
		recordSearchVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
		recordSearchVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("group_id")) );
		recordSearchVO.setZirecxId((String)session.getAttribute("zirecx_id")); 
		
		*//** 현재 선택된 그룹의 하위그룹까지 가져온다. *//*
    	CmnGroupSearchVO cmnGroupSearchVO = new CmnGroupSearchVO();
		if(recordSearchVO.getSchGroupId().equals("")){
			cmnGroupSearchVO.setGroupSearchSeq(recordSearchVO.getStrSessionGroupId());
		}else{
	    	cmnGroupSearchVO.setGroupSearchSeq(recordSearchVO.getSchGroupId());
		}
		String strGroupSeq = cmnGroupSearchService.subGroupSeq(cmnGroupSearchVO);
    	String[] arrGroupSeq = strGroupSeq.split(",");
    	recordSearchVO.setArrGroupSeq(arrGroupSeq);
    	
    	*//** url 검색. *//*
    	String serverUrl = "";
    	List<RecordSearchVO> webPathList = recordManageService.selectWebPath(recordSearchVO);
		recordSearchVO.setWebHostName(webPathList.get(0).getAudioHostName());
		recordSearchVO.setWebTcpPort(webPathList.get(0).getAudioTcpPort());
		recordSearchVO.setContext(webPathList.get(0).getZirecxContext());
		
		if (recordSearchVO.getWebHostName() == null && recordSearchVO.getWebTcpPort() == null){
			serverUrl = "";
		} else {
			serverUrl = "http://" + recordSearchVO.getWebHostName() + ":" + recordSearchVO.getWebTcpPort() + "/" + recordSearchVO.getContext();
		}
		
		model.addAttribute("serverUrl", serverUrl);
    	
    	*//** EgovPropertyService.sample *//*
//    	recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	recordSearchVO.setPageSize(propertiesService.getInt("pageSize"));

    	if(recordSearchVO.getPagelist().equals("10")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit10"));
    	}else if(recordSearchVO.getPagelist().equals("50")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit50"));
    	}else if(recordSearchVO.getPagelist().equals("100")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit100"));
    	}else if(recordSearchVO.getPagelist().equals("200")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit200"));
    	}
    	
    	*//** paging setting *//*
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(recordSearchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(recordSearchVO.getPageUnit());
		paginationInfo.setPageSize(recordSearchVO.getPageSize());
		
		recordSearchVO.setFirstIndex(paginationInfo.getFirstRecordIndex()+1);
		recordSearchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		recordSearchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		recordSearchVO.setAuth((String) session.getAttribute("zirecx_id"));
		
		List recordList = recordManageService.selectRecordList(recordSearchVO);
    	model.addAttribute("recordList", recordList);
    	
    	int totCnt = recordManageService.selectRecordListTotCnt(recordSearchVO);
    	
		paginationInfo.setTotalRecordCount(totCnt);
		
		if(totCnt%Integer.parseInt(recordSearchVO.getPagelist())<1){
			if(totCnt/Integer.parseInt(recordSearchVO.getPagelist())<1){
				recordSearchVO.setMaxpage(1);
			}else{
				recordSearchVO.setMaxpage(totCnt/Integer.parseInt(recordSearchVO.getPagelist()));
			}
		}else{
			if(totCnt/Integer.parseInt(recordSearchVO.getPagelist())<1){
				recordSearchVO.setMaxpage(1);
			}else{
				recordSearchVO.setMaxpage((totCnt/Integer.parseInt(recordSearchVO.getPagelist()))+1);
			}
		}
		
		recordSearchVO.setTotalCount(totCnt);
		
		model.addAttribute("totalCount", recordSearchVO.getTotalCount());
		model.addAttribute("maxPage", recordSearchVO.getMaxpage());
        model.addAttribute("paginationInfo", paginationInfo);
        
         페이징 숫자 더하기 
    	int cnt = 0;
        if(recordSearchVO.getPageIndex() > 1){
        	cnt = (recordSearchVO.getPageIndex() - 1) * recordSearchVO.getPageUnit();
        }
        model.addAttribute("cnt", cnt);
    	
        return "record/recordManageList";
    }*/
    
    /**
	 * 녹취관리 리스트를 새로고침한다. 
	 */
    /*@SuppressWarnings("rawtypes")
	@RequestMapping("/record/recordrefreshList.do")
    public String selectrefreshList(
    		@ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, HttpServletRequest request, Model model, HttpSession session
            ) throws Exception {
    	
    	TextUtil textUtil = TextUtil.getInstance();
    	
    	recordSearchVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
		recordSearchVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
		recordSearchVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("group_id")) );
		recordSearchVO.setZirecxId((String)session.getAttribute("zirecx_id"));
		
		*//** 현재 선택된 그룹의 하위그룹까지 가져온다. *//*
    	CmnGroupSearchVO cmnGroupSearchVO = new CmnGroupSearchVO();
		if(recordSearchVO.getSchGroupId().equals("")){
			cmnGroupSearchVO.setGroupSearchSeq(recordSearchVO.getStrSessionGroupId());
		}else{
	    	cmnGroupSearchVO.setGroupSearchSeq(recordSearchVO.getSchGroupId());
		}
		String strGroupSeq = cmnGroupSearchService.subGroupSeq(cmnGroupSearchVO);
    	String[] arrGroupSeq = strGroupSeq.split(",");
    	recordSearchVO.setArrGroupSeq(arrGroupSeq);
    	
    	*//** url 검색. *//*
    	String serverUrl = "";
    	List<RecordSearchVO> webPathList = recordManageService.selectWebPath(recordSearchVO);
		recordSearchVO.setWebHostName(webPathList.get(0).getAudioHostName());
		recordSearchVO.setWebTcpPort(webPathList.get(0).getAudioTcpPort());
		recordSearchVO.setContext(webPathList.get(0).getZirecxContext());
		
		if (recordSearchVO.getWebHostName() == null && recordSearchVO.getWebTcpPort() == null){
			serverUrl = "";
		} else {
			serverUrl = "http://" + recordSearchVO.getWebHostName() + ":" + recordSearchVO.getWebTcpPort() + "/" + recordSearchVO.getContext();
		}
		
		model.addAttribute("serverUrl", serverUrl);
    	
    	*//** EgovPropertyService.sample *//*
//    	recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	recordSearchVO.setPageSize(propertiesService.getInt("pageSize"));

    	if(recordSearchVO.getPagelist().equals("10")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit10"));
    	}else if(recordSearchVO.getPagelist().equals("50")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit50"));
    	}else if(recordSearchVO.getPagelist().equals("100")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit100"));
    	}else if(recordSearchVO.getPagelist().equals("200")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit200"));
    	}
    	
    	*//** paging setting *//*
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(recordSearchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(recordSearchVO.getPageUnit());
		paginationInfo.setPageSize(recordSearchVO.getPageSize());
		
		recordSearchVO.setFirstIndex(paginationInfo.getFirstRecordIndex() + 1);
		recordSearchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		recordSearchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		recordSearchVO.setAuth((String) session.getAttribute("zirecx_id"));
		
		recordSearchVO.setSchUserZirecxId(recordSearchVO.getRefuserId());
		recordSearchVO.setSchGroupId(recordSearchVO.getRefgroupSeq());
		recordSearchVO.setSearchKeyword(recordSearchVO.getRefsearchKeyword());
		recordSearchVO.setStrStartDate(recordSearchVO.getRefstrStartDate());
		recordSearchVO.setStrEndDate(recordSearchVO.getRefstrEndDate());
		
		List recordList = recordManageService.selectRecordList(recordSearchVO);
    	model.addAttribute("recordList", recordList);
    	
    	int totCnt = recordManageService.selectRecordListTotCnt(recordSearchVO);
		paginationInfo.setTotalRecordCount(totCnt);

		if(totCnt%Integer.parseInt(recordSearchVO.getPagelist())<1){
			if(totCnt/Integer.parseInt(recordSearchVO.getPagelist())<1){
				recordSearchVO.setMaxpage(1);
			}else{
				recordSearchVO.setMaxpage(totCnt/Integer.parseInt(recordSearchVO.getPagelist()));
			}
		}else{
			if(totCnt/Integer.parseInt(recordSearchVO.getPagelist())<1){
				recordSearchVO.setMaxpage(1);
			}else{
				recordSearchVO.setMaxpage((totCnt/Integer.parseInt(recordSearchVO.getPagelist()))+1);
			}
		}
		
		recordSearchVO.setTotalCount(totCnt);
		
		model.addAttribute("totalCount", recordSearchVO.getTotalCount());
		model.addAttribute("maxPage", recordSearchVO.getMaxpage());
        model.addAttribute("paginationInfo", paginationInfo);
        
         페이징 숫자 더하기 
    	int cnt = 0;
        if(recordSearchVO.getPageIndex() > 1){
        	cnt = (recordSearchVO.getPageIndex() - 1) * recordSearchVO.getPageUnit();
        }
        model.addAttribute("cnt", cnt);
    	
        return "record/recordManageList";
    }*/
	
	/**
	 * 체크된 녹취관리 Excel 다운로드를 한다.
	 */
   /* @SuppressWarnings("rawtypes")
	@RequestMapping("/record/recordManageCheckExcelList.do")
    public ModelAndView selectCheckRecordExcelList(
    		@ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, HttpServletRequest request, HttpSession session
            ) throws Exception {
    	
    	TextUtil textUtil = TextUtil.getInstance();
    	
    	recordSearchVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
		recordSearchVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
		recordSearchVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("group_id")) );
		recordSearchVO.setZirecxId((String)session.getAttribute("zirecx_id"));
		
		*//** 현재 선택된 그룹의 하위그룹까지 가져온다. *//*
    	CmnGroupSearchVO cmnGroupSearchVO = new CmnGroupSearchVO();
		if(recordSearchVO.getSchGroupId().equals("")){
			cmnGroupSearchVO.setGroupSearchSeq(recordSearchVO.getStrSessionGroupId());
		}else{
	    	cmnGroupSearchVO.setGroupSearchSeq(recordSearchVO.getSchGroupId());
		}
		String strGroupSeq = cmnGroupSearchService.subGroupSeq(cmnGroupSearchVO);
    	String[] arrGroupSeq = strGroupSeq.split(",");
    	recordSearchVO.setArrGroupSeq(arrGroupSeq);
    	
    	String[] arrSelectedRecId = recordSearchVO.getSelectedRecId().split(",");
    	recordSearchVO.setArrSelectedRecId(arrSelectedRecId);
    	
    	*//** 체크된 항목이 없을경우 경고. *//*
    	if(Arrays.toString(arrSelectedRecId).equals("[]")){
			return new ModelAndView("common/recordAlertCheck");
    	}
    	
    	List recordExcelList = recordManageService.selectCheckRecordExcelList(recordSearchVO);
     
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("recordExcel", recordExcelList);
    	return new ModelAndView("recordManageExcelDownload", "recordExcelMap", map);
    	
    }*/
	
    /**
	 * 녹취연동관리 화면을 조회한다. // 
	 */
    @SuppressWarnings({ "rawtypes"})
	@RequestMapping("/record/linkCallManageMain.do")
    public String linkCallManageMainView(
            @ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, Model model, HttpSession session
            ) throws Exception {
    	CmnPrivateVO cmnPrivateVO = new CmnPrivateVO();
    	
    	String[] privName = {
    			  messageSource.getMessage("message.db_new", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_save", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_group_select", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_group_tree", null, Locale.getDefault())
    			//사용자 선택 추가 
    			, messageSource.getMessage("message.db_user_select", null, Locale.getDefault())
    			
    			, messageSource.getMessage("message.db_excel", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_recfile_down", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_goodcall_select", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_file_cvt", null, Locale.getDefault())
    	};
		
    	cmnPrivateVO.setPrivName(privName);
    	cmnPrivateVO.setStrSecurityGroupId((String)session.getAttribute("security_group_id"));
    	
    	List listPrivate = cmnPrivateService.selectPrivateList(cmnPrivateVO);
    	
    	String strPrivName = 
    			  messageSource.getMessage("message.db_new", null, Locale.getDefault()) + "," + "btn_new" + "," + "버튼" +"|"
    			+ messageSource.getMessage("message.db_save", null, Locale.getDefault()) + "," + "btn_save" + "," + "버튼" + "|"
    			+ messageSource.getMessage("message.db_group_select", null, Locale.getDefault()) + "," + "" + "," + "그룹" + "|"
    			+ messageSource.getMessage("message.db_group_tree", null, Locale.getDefault()) + "," + "" + "," + "그룹트리" + "|"
    			//사용자추가 
    			+ messageSource.getMessage("message.db_user_select", null, Locale.getDefault()) + "," + "" + "," + "사용자" + "|"
    			
    			+ messageSource.getMessage("message.db_excel", null, Locale.getDefault()) + "," + "" + "," + "엑셀다운" + "|"
    			+ messageSource.getMessage("message.db_recfile_down", null, Locale.getDefault()) + "," + "" + "," + "파일다운" + "|"
    			+ messageSource.getMessage("message.db_goodcall_select", null, Locale.getDefault()) + "," + "" + "," + "굿콜지정" + "|"
    			+ messageSource.getMessage("message.db_file_cvt", null, Locale.getDefault()) + "," + "btn_cvt" + "," + "버튼"
    			;
    	model.addAttribute("strPrivName", strPrivName);
    	model.addAttribute("listPrivate", listPrivate);
    	
    	List callresultList = recordManageService.selectCallresult(recordSearchVO);
    	model.addAttribute("callresultList", callresultList);
        return "record/linkCallManageMain";
    }
    
	
    
    /**
	 * 녹취연동관리 리스트를 조회한다.
	 */
    @SuppressWarnings("rawtypes")
	@RequestMapping("/record/linkCallManageList.do")
    public String selectLinkCallList(
    		@ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, HttpServletRequest request, Model model, HttpSession session
            ) throws Exception {
    	
    	TextUtil textUtil = TextUtil.getInstance();
    	
    	recordSearchVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
		recordSearchVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
		recordSearchVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("group_id")) );
		recordSearchVO.setZirecxId((String)session.getAttribute("zirecx_id"));
		
		// 2017-03-30 iklee 
		// 	- 쿼리 튜닝으로 DATE형태로 비교하지 않고 INT로 비교. 따라서 "-" 제거
		recordSearchVO.setStrStartDate(recordSearchVO.getStrStartDate().replaceAll("-", ""));
		recordSearchVO.setStrStartTime(recordSearchVO.getStrStartTime().replaceAll("-", ""));
		recordSearchVO.setStrEndDate(recordSearchVO.getStrEndDate().replaceAll("-", ""));
		recordSearchVO.setStrEndTime(recordSearchVO.getStrEndTime().replaceAll("-", ""));
		
		/** 현재 선택된 그룹의 하위그룹까지 가져온다. */
    	CmnGroupSearchVO cmnGroupSearchVO = new CmnGroupSearchVO();
		if(recordSearchVO.getSchGroupId().equals("")){
			//admin과 groupUp권한일 수 있다.
			cmnGroupSearchVO.setGroupSearchSeq(
					session.getAttribute("zirecx_id").equals("admin") ? recordSearchVO.getStrSessionGroupId()
																	  : (String) session.getAttribute("parent_group_id"));
		}else{
	    	cmnGroupSearchVO.setGroupSearchSeq(recordSearchVO.getSchGroupId());
		}
		String strGroupSeq = cmnGroupSearchService.subGroupSeq(cmnGroupSearchVO);
    	String[] arrGroupSeq = strGroupSeq.split(",");
    	recordSearchVO.setArrGroupSeq(arrGroupSeq);
    	
    	/** url 검색. */
    	String serverUrl = "";
    	List<RecordSearchVO> webPathList = recordManageService.selectWebPath(recordSearchVO);
		recordSearchVO.setWebHostName(webPathList.get(0).getAudioHostName());
		recordSearchVO.setWebTcpPort(webPathList.get(0).getAudioTcpPort());
		recordSearchVO.setContext(webPathList.get(0).getZiphoneContext());
		
		if (recordSearchVO.getWebHostName() == null && recordSearchVO.getWebTcpPort() == null){
			serverUrl = "";
		} else {
			serverUrl = "https://" + recordSearchVO.getWebHostName() + ":" + recordSearchVO.getWebTcpPort() + "/" + recordSearchVO.getContext();
		}
		
		model.addAttribute("serverUrl", serverUrl);
    	/** EgovPropertyService.sample */
//    	recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	recordSearchVO.setPageSize(propertiesService.getInt("pageSize"));

    	if(recordSearchVO.getPagelist().equals("10")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit10"));
    	}else if(recordSearchVO.getPagelist().equals("50")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit50"));
    	}else if(recordSearchVO.getPagelist().equals("100")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit100"));
    	}else if(recordSearchVO.getPagelist().equals("200")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit200"));
    	}
    	/** paging setting */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(recordSearchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(recordSearchVO.getPageUnit());
		paginationInfo.setPageSize(recordSearchVO.getPageSize());
		
		recordSearchVO.setFirstIndex(paginationInfo.getFirstRecordIndex() + 1);
		recordSearchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		recordSearchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		recordSearchVO.setAuth((String) session.getAttribute("zirecx_id"));
		
//		recordSearchVO.setStrStartDate(recordSearchVO.getStrStartDate().replace("-",""));
//		recordSearchVO.setStrEndDate(recordSearchVO.getStrEndDate().replace("-",""));
		
		List<RecordSearchVO> linkCallList = recordManageService.selectLinkCallList(recordSearchVO);		
		/* 개행문자 처리 */
		for(int i=0; i<linkCallList.size(); i++){
			if(linkCallList.get(i).getCallMemo() != null){
				linkCallList.get(i).setCallMemo(linkCallList.get(i).getCallMemo().replaceAll("\r\n|\n", "<br>"));
			}
		}
    	model.addAttribute("linkCallList", linkCallList);
    	
    	int totCnt = recordManageService.selectLinkCallListTotCnt(recordSearchVO);
		paginationInfo.setTotalRecordCount(totCnt);

		if(totCnt%Integer.parseInt(recordSearchVO.getPagelist())<1){
			if(totCnt/Integer.parseInt(recordSearchVO.getPagelist())<1){
				recordSearchVO.setMaxpage(1);
			}else{
				recordSearchVO.setMaxpage(totCnt/Integer.parseInt(recordSearchVO.getPagelist()));
			}
		}else{
			if(totCnt/Integer.parseInt(recordSearchVO.getPagelist())<1){
				recordSearchVO.setMaxpage(1);
			}else{
				recordSearchVO.setMaxpage((totCnt/Integer.parseInt(recordSearchVO.getPagelist()))+1);
			}
		}
		
		recordSearchVO.setTotalCount(totCnt);
		
		model.addAttribute("totalCount", recordSearchVO.getTotalCount());
		model.addAttribute("maxPage", recordSearchVO.getMaxpage());
        model.addAttribute("paginationInfo", paginationInfo);
        
        /* 페이징 숫자 더하기 */
    	int cnt = 0;
        if(recordSearchVO.getPageIndex() > 1){
        	cnt = (recordSearchVO.getPageIndex() - 1) * recordSearchVO.getPageUnit();
        }
        model.addAttribute("cnt", cnt);
    	
        return "record/linkCallManageList";
    }
    
    /**
	 * 녹취연동관리 리스트를 새로고침 한다.
	 */
    @SuppressWarnings("rawtypes")
	@RequestMapping("/record/linkCallRefreshList.do")
    public String selectLinkCallRefreshList(
    		@ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, HttpServletRequest request, Model model, HttpSession session
            ) throws Exception {

    	TextUtil textUtil = TextUtil.getInstance();
    	
    	recordSearchVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
		recordSearchVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
		recordSearchVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("group_id")) );
		recordSearchVO.setZirecxId((String)session.getAttribute("zirecx_id"));
		
		// 2017-03-30 iklee 
		// 	- 쿼리 튜닝으로 DATE형태로 비교하지 않고 INT로 비교. 따라서 "-" 제거
		recordSearchVO.setStrStartDate(recordSearchVO.getStrStartDate().replaceAll("-", ""));
		recordSearchVO.setStrStartTime(recordSearchVO.getStrStartTime().replaceAll("-", ""));
		recordSearchVO.setStrEndDate(recordSearchVO.getStrEndDate().replaceAll("-", ""));
		recordSearchVO.setStrEndTime(recordSearchVO.getStrEndTime().replaceAll("-", ""));
		
		/** 현재 선택된 그룹의 하위그룹까지 가져온다. */
    	CmnGroupSearchVO cmnGroupSearchVO = new CmnGroupSearchVO();
		if(recordSearchVO.getSchGroupId().equals("")){
			//admin과 groupUp권한일 수 있다.
			cmnGroupSearchVO.setGroupSearchSeq(
					session.getAttribute("zirecx_id").equals("admin") ? recordSearchVO.getStrSessionGroupId()
																	  : (String) session.getAttribute("parent_group_id"));
		}else{
	    	cmnGroupSearchVO.setGroupSearchSeq(recordSearchVO.getSchGroupId());
		}
		String strGroupSeq = cmnGroupSearchService.subGroupSeq(cmnGroupSearchVO);
    	String[] arrGroupSeq = strGroupSeq.split(",");
    	recordSearchVO.setArrGroupSeq(arrGroupSeq);
    	
    	/** url 검색. */
    	String serverUrl = "";
    	List<RecordSearchVO> webPathList = recordManageService.selectWebPath(recordSearchVO);
		recordSearchVO.setWebHostName(webPathList.get(0).getAudioHostName());
		recordSearchVO.setWebTcpPort(webPathList.get(0).getAudioTcpPort());
		recordSearchVO.setContext(webPathList.get(0).getZiphoneContext());
		
		if (recordSearchVO.getWebHostName() == null && recordSearchVO.getWebTcpPort() == null){
			serverUrl = "";
		} else {
			serverUrl = "https://" + recordSearchVO.getWebHostName() + ":" + recordSearchVO.getWebTcpPort() + "/" + recordSearchVO.getContext();
		}
		
		model.addAttribute("serverUrl", serverUrl);
    	
    	/** EgovPropertyService.sample */
//    	recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	recordSearchVO.setPageSize(propertiesService.getInt("pageSize"));

    	if(recordSearchVO.getPagelist().equals("10")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit10"));
    	}else if(recordSearchVO.getPagelist().equals("50")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit50"));
    	}else if(recordSearchVO.getPagelist().equals("100")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit100"));
    	}else if(recordSearchVO.getPagelist().equals("200")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit200"));
    	}
    	
    	/** paging setting */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(recordSearchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(recordSearchVO.getPageUnit());
		paginationInfo.setPageSize(recordSearchVO.getPageSize());
		
		recordSearchVO.setFirstIndex(paginationInfo.getFirstRecordIndex() + 1);
		recordSearchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		recordSearchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		recordSearchVO.setAuth((String) session.getAttribute("zirecx_id"));
		
		
		recordSearchVO.setSchUserZirecxId(recordSearchVO.getRefuserId());
		recordSearchVO.setSchGroupId(recordSearchVO.getRefgroupSeq());
		recordSearchVO.setSearchKeyword(recordSearchVO.getRefsearchKeyword());
		recordSearchVO.setStrStartTime(recordSearchVO.getRefstrStartTime());
		recordSearchVO.setStrEndTime(recordSearchVO.getRefstrEndTime());
		recordSearchVO.setCallresult(recordSearchVO.getRefcallresult());
		recordSearchVO.setCampaign(recordSearchVO.getRefcampaign());
//		recordSearchVO.setStrStartDate(recordSearchVO.getRefstrStartDate().replace("-",""));
//		recordSearchVO.setStrEndDate(recordSearchVO.getRefstrEndDate().replace("-",""));
		
		List<RecordSearchVO> linkCallList = recordManageService.selectLinkCallList(recordSearchVO);		
		/* 개행문자 처리 */
		for(int i=0; i<linkCallList.size(); i++){
			if(linkCallList.get(i).getCallMemo() != null){
				linkCallList.get(i).setCallMemo(linkCallList.get(i).getCallMemo().replaceAll("\r\n", "<br>"));
			}
		}
		
    	model.addAttribute("linkCallList", linkCallList);
    	
    	int totCnt = recordManageService.selectLinkCallListTotCnt(recordSearchVO);
		paginationInfo.setTotalRecordCount(totCnt);

		if(totCnt%Integer.parseInt(recordSearchVO.getPagelist())<1){
			if(totCnt/Integer.parseInt(recordSearchVO.getPagelist())<1){
				recordSearchVO.setMaxpage(1);
			}else{
				recordSearchVO.setMaxpage(totCnt/Integer.parseInt(recordSearchVO.getPagelist()));
			}
		}else{
			if(totCnt/Integer.parseInt(recordSearchVO.getPagelist())<1){
				recordSearchVO.setMaxpage(1);
			}else{
				recordSearchVO.setMaxpage((totCnt/Integer.parseInt(recordSearchVO.getPagelist()))+1);
			}
		}
		
		recordSearchVO.setTotalCount(totCnt);
		
		model.addAttribute("totalCount", recordSearchVO.getTotalCount());
		model.addAttribute("maxPage", recordSearchVO.getMaxpage());
        model.addAttribute("paginationInfo", paginationInfo);
        
        /* 페이징 숫자 더하기 */
    	int cnt = 0;
        if(recordSearchVO.getPageIndex() > 1){
        	cnt = (recordSearchVO.getPageIndex() - 1) * recordSearchVO.getPageUnit();
        }
        model.addAttribute("cnt", cnt);
    	
        return "record/linkCallManageList";
    }
    
    /**
	 * 체크된  연동형 Excel 다운로드를 한다.
	 */
    @SuppressWarnings("rawtypes")
	@RequestMapping("/record/linkCallManageCheckExcelList.do")
    public ModelAndView selectCheckLinkCallExcelList(
    		@ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, HttpServletRequest request, HttpSession session
            ) throws Exception {
    	
    	TextUtil textUtil = TextUtil.getInstance();
    	
    	//엑셀 열기 시 컨트롤러 재호출.. null 처리
    	if(request.getParameterMap().isEmpty()) {
    		return null;
    	}
    	
    	
    	recordSearchVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") != null ? request.getParameter("hidAccessPolicy") : "all" );
		recordSearchVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
		recordSearchVO.setStrSessionGroupId( recordSearchVO.getStrAccessPolicy().equals("groupUp") 
												? textUtil.validateParam((String)session.getAttribute("parent_group_id"))
    											: textUtil.validateParam((String)session.getAttribute("group_id")) 
		);
		recordSearchVO.setZirecxId((String)session.getAttribute("zirecx_id"));
		
		/** 현재 선택된 그룹의 하위그룹까지 가져온다. */
    	CmnGroupSearchVO cmnGroupSearchVO = new CmnGroupSearchVO();
		if(recordSearchVO.getSchGroupId().equals("")){
			cmnGroupSearchVO.setGroupSearchSeq(recordSearchVO.getStrSessionGroupId());
		}else{
	    	cmnGroupSearchVO.setGroupSearchSeq(recordSearchVO.getSchGroupId());
		}
		String strGroupSeq = cmnGroupSearchService.subGroupSeq(cmnGroupSearchVO);
    	String[] arrGroupSeq = strGroupSeq.split(",");
    	recordSearchVO.setArrGroupSeq(arrGroupSeq);
    	
    	String[] arrSelectedRecId = recordSearchVO.getSelectedRecId().split(",");
    	recordSearchVO.setArrSelectedRecId(arrSelectedRecId);
    	
    	recordSearchVO.setStrStartDate(recordSearchVO.getStrStartDate().replace("-",""));
		recordSearchVO.setStrEndDate(recordSearchVO.getStrEndDate().replace("-",""));
    	
		/** 체크된 항목이 없을경우 경고. */
    	if(Arrays.toString(arrSelectedRecId).equals("[]")){
			return new ModelAndView("common/recordAlertCheck");
    	}
    	
    	List recordExcelList = recordManageService.selectCheckLinkCallExcelList(recordSearchVO);
     
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("recordExcel", recordExcelList);
    	return new ModelAndView("linkCallManageExcelDownload", "recordExcelMap", map);
    	
    }
    
    /**
     * 펜녹취이력 화면을 조회한다.
     */
      @SuppressWarnings({ "rawtypes"})
      @RequestMapping("/record/linkPenCallManageMain.do")
      public String linkPenCallManageMainView(
              @ModelAttribute("recordPenVO") RecordPenVO recordPenVO, Model model, HttpSession session
              ) throws Exception {
    	CmnPrivateVO cmnPrivateVO = new CmnPrivateVO();
        
        String[] privName = {
              messageSource.getMessage("message.db_new", null, Locale.getDefault())
            , messageSource.getMessage("message.db_save", null, Locale.getDefault())
            , messageSource.getMessage("message.db_group_select", null, Locale.getDefault())
            , messageSource.getMessage("message.db_group_tree", null, Locale.getDefault())
            //사용자 선택 추가 
			, messageSource.getMessage("message.db_user_select", null, Locale.getDefault())
			
            , messageSource.getMessage("message.db_excel", null, Locale.getDefault())
            , messageSource.getMessage("message.db_recfile_down", null, Locale.getDefault())
            , messageSource.getMessage("message.db_goodcall_select", null, Locale.getDefault())
            , messageSource.getMessage("message.db_file_cvt", null, Locale.getDefault())
        };
      
        cmnPrivateVO.setPrivName(privName);
        cmnPrivateVO.setStrSecurityGroupId((String)session.getAttribute("security_group_id"));
        
        List listPrivate = cmnPrivateService.selectPrivateList(cmnPrivateVO);
        
        String strPrivName = 
              messageSource.getMessage("message.db_new", null, Locale.getDefault()) + "," + "btn_new" + "," + "버튼" +"|"
            + messageSource.getMessage("message.db_save", null, Locale.getDefault()) + "," + "btn_save" + "," + "버튼" + "|"
            + messageSource.getMessage("message.db_group_select", null, Locale.getDefault()) + "," + "" + "," + "그룹" + "|"
            + messageSource.getMessage("message.db_group_tree", null, Locale.getDefault()) + "," + "" + "," + "그룹트리" + "|"
          
            //사용자추가 
			+ messageSource.getMessage("message.db_user_select", null, Locale.getDefault()) + "," + "" + "," + "사용자" + "|"
          
            + messageSource.getMessage("message.db_excel", null, Locale.getDefault()) + "," + "" + "," + "엑셀다운" + "|"
            + messageSource.getMessage("message.db_recfile_down", null, Locale.getDefault()) + "," + "" + "," + "파일다운" + "|"
            + messageSource.getMessage("message.db_goodcall_select", null, Locale.getDefault()) + "," + "" + "," + "굿콜지정" + "|"
            + messageSource.getMessage("message.db_file_cvt", null, Locale.getDefault()) + "," + "btn_cvt" + "," + "버튼"
            ;
        model.addAttribute("strPrivName", strPrivName);
        model.addAttribute("listPrivate", listPrivate);
        
        List callresultList = recordManageService.selectPenCallresult(recordPenVO);
        model.addAttribute("callresultList", callresultList);
          return "record/linkPenCallManageMain";
      }
      
      /**
       * 펜녹취관리 리스트를 조회한다.
       */
        @SuppressWarnings("rawtypes")
        @RequestMapping("/record/linkPenCallManageList.do")
        public String selectLinkPenCallList(
            @ModelAttribute("recordPenVO") RecordPenVO recordPenVO, HttpServletRequest request, Model model, HttpSession session
                ) throws Exception {
          
          TextUtil textUtil = TextUtil.getInstance();
          
          recordPenVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
          recordPenVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
          recordPenVO.setStrSessionGroupId(recordPenVO.getStrAccessPolicy().equals("groupUp") 
        		  ? textUtil.validateParam((String)session.getAttribute("parent_group_id"))
        		  : textUtil.validateParam((String)session.getAttribute("group_id")));
          recordPenVO.setZirecxId((String)session.getAttribute("zirecx_id"));
        
        // 2017-03-30 iklee 
        //  - 쿼리 튜닝으로 DATE형태로 비교하지 않고 INT로 비교. 따라서 "-" 제거
        recordPenVO.setStrStartDate(recordPenVO.getStrStartDate().replaceAll("-", ""));
//        recordPenVO.setStrStartTime(recordPenVO.getStrStartTime().replaceAll("-", ""));
        recordPenVO.setStrEndDate(recordPenVO.getStrEndDate().replaceAll("-", ""));
//        recordPenVO.setStrEndTime(recordPenVO.getStrEndTime().replaceAll("-", ""));
        
        /** 현재 선택된 그룹의 하위그룹까지 가져온다. */
          CmnGroupSearchVO cmnGroupSearchVO = new CmnGroupSearchVO();
        if(recordPenVO.getSchGroupId().equals("")){
          cmnGroupSearchVO.setGroupSearchSeq(recordPenVO.getStrSessionGroupId());
        }else{
            cmnGroupSearchVO.setGroupSearchSeq(recordPenVO.getSchGroupId());
        }
        String strGroupSeq = cmnGroupSearchService.subGroupSeq(cmnGroupSearchVO);
          String[] arrGroupSeq = strGroupSeq.split(",");
          recordPenVO.setArrGroupSeq(arrGroupSeq);
          
          /** url 검색. */
          String serverUrl = "";
          List<RecordPenVO> webPathList = recordManageService.selectWebPathPen(recordPenVO);
          recordPenVO.setWebHostName(webPathList.get(0).getAudioHostName());
        recordPenVO.setWebTcpPort(webPathList.get(0).getAudioTcpPort());
        recordPenVO.setContext(webPathList.get(0).getZiphoneContext());
        
        if (recordPenVO.getWebHostName() == null && recordPenVO.getWebTcpPort() == null){
          serverUrl = "";
        } else {
          serverUrl = "https://" + recordPenVO.getWebHostName() + ":" + recordPenVO.getWebTcpPort() + "/" + recordPenVO.getContext();
        }
        
        model.addAttribute("serverUrl", serverUrl);
          /** EgovPropertyService.sample */
//          recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit"));
        recordPenVO.setPageSize(propertiesService.getInt("pageSize"));

          if(recordPenVO.getPagelist().equals("10")){
            recordPenVO.setPageUnit(propertiesService.getInt("pageUnit10"));
          }else if(recordPenVO.getPagelist().equals("50")){
            recordPenVO.setPageUnit(propertiesService.getInt("pageUnit50"));
          }else if(recordPenVO.getPagelist().equals("100")){
            recordPenVO.setPageUnit(propertiesService.getInt("pageUnit100"));
          }else if(recordPenVO.getPagelist().equals("200")){
            recordPenVO.setPageUnit(propertiesService.getInt("pageUnit200"));
          }
          /** paging setting */
          PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(recordPenVO.getPageIndex());
        paginationInfo.setRecordCountPerPage(recordPenVO.getPageUnit());
        paginationInfo.setPageSize(recordPenVO.getPageSize());
        
        recordPenVO.setFirstIndex(paginationInfo.getFirstRecordIndex() + 1);
        recordPenVO.setLastIndex(paginationInfo.getLastRecordIndex());
        recordPenVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

        recordPenVO.setAuth((String) session.getAttribute("zirecx_id"));
        
//        recordSearchVO.setStrStartDate(recordSearchVO.getStrStartDate().replace("-",""));
//        recordSearchVO.setStrEndDate(recordSearchVO.getStrEndDate().replace("-",""));
        
        List<RecordPenVO> linkCallList = recordManageService.selectLinkPenCallList(recordPenVO);   
        /* 개행문자 처리 */
//        for(int i=0; i<linkCallList.size(); i++){
//          if(linkCallList.get(i).getCallMemo() != null){
//            linkCallList.get(i).setCallMemo(linkCallList.get(i).getCallMemo().replaceAll("\r\n|\n", "<br>"));
//          }
//        }
          model.addAttribute("linkCallList", linkCallList);
          
          int totCnt = recordManageService.selectLinkPenCallListTotCnt(recordPenVO);
        paginationInfo.setTotalRecordCount(totCnt);

        if(totCnt%Integer.parseInt(recordPenVO.getPagelist())<1){
          if(totCnt/Integer.parseInt(recordPenVO.getPagelist())<1){
            recordPenVO.setMaxpage(1);
          }else{
            recordPenVO.setMaxpage(totCnt/Integer.parseInt(recordPenVO.getPagelist()));
          }
        }else{
          if(totCnt/Integer.parseInt(recordPenVO.getPagelist())<1){
            recordPenVO.setMaxpage(1);
          }else{
            recordPenVO.setMaxpage((totCnt/Integer.parseInt(recordPenVO.getPagelist()))+1);
          }
        }
        
        recordPenVO.setTotalCount(totCnt);
        
        model.addAttribute("totalCount", recordPenVO.getTotalCount());
        model.addAttribute("maxPage", recordPenVO.getMaxpage());
            model.addAttribute("paginationInfo", paginationInfo);
            
            /* 페이징 숫자 더하기 */
          int cnt = 0;
            if(recordPenVO.getPageIndex() > 1){
              cnt = (recordPenVO.getPageIndex() - 1) * recordPenVO.getPageUnit();
            }
            model.addAttribute("cnt", cnt);
          
            return "record/linkPenCallManageList";
        }
        
        
   /**
    * 펜녹취 새로고침
    * @param recordPenVO
    * @param request
    * @param model
    * @param session
    * @return
    * @throws Exception
    */
    @SuppressWarnings("rawtypes")
    @RequestMapping("/record/linkPenCallRefreshList.do")
    public String selectLinkPenCallRefreshList(
    		@ModelAttribute("recordPenVO") RecordPenVO recordPenVO, HttpServletRequest request, Model model, HttpSession session
            ) throws Exception {
    
    	TextUtil textUtil = TextUtil.getInstance();
        
        recordPenVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
        recordPenVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
        recordPenVO.setStrSessionGroupId(recordPenVO.getStrAccessPolicy().equals("groupUp") 
      		  ? textUtil.validateParam((String)session.getAttribute("parent_group_id"))
      		  : textUtil.validateParam((String)session.getAttribute("group_id")));
        recordPenVO.setZirecxId((String)session.getAttribute("zirecx_id"));
      
      // 2017-03-30 iklee 
      //  - 쿼리 튜닝으로 DATE형태로 비교하지 않고 INT로 비교. 따라서 "-" 제거
      recordPenVO.setStrStartDate(recordPenVO.getStrStartDate().replaceAll("-", ""));
//      recordPenVO.setStrStartTime(recordPenVO.getStrStartTime().replaceAll("-", ""));
      recordPenVO.setStrEndDate(recordPenVO.getStrEndDate().replaceAll("-", ""));
//      recordPenVO.setStrEndTime(recordPenVO.getStrEndTime().replaceAll("-", ""));
      
      /** 현재 선택된 그룹의 하위그룹까지 가져온다. */
        CmnGroupSearchVO cmnGroupSearchVO = new CmnGroupSearchVO();
      if(recordPenVO.getSchGroupId().equals("")){
        cmnGroupSearchVO.setGroupSearchSeq(recordPenVO.getStrSessionGroupId());
      }else{
          cmnGroupSearchVO.setGroupSearchSeq(recordPenVO.getSchGroupId());
      }
      String strGroupSeq = cmnGroupSearchService.subGroupSeq(cmnGroupSearchVO);
        String[] arrGroupSeq = strGroupSeq.split(",");
        recordPenVO.setArrGroupSeq(arrGroupSeq);
        
        /** url 검색. */
        String serverUrl = "";
        List<RecordPenVO> webPathList = recordManageService.selectWebPathPen(recordPenVO);
        recordPenVO.setWebHostName(webPathList.get(0).getAudioHostName());
      recordPenVO.setWebTcpPort(webPathList.get(0).getAudioTcpPort());
      recordPenVO.setContext(webPathList.get(0).getZiphoneContext());
      
      if (recordPenVO.getWebHostName() == null && recordPenVO.getWebTcpPort() == null){
        serverUrl = "";
      } else {
        serverUrl = "https://" + recordPenVO.getWebHostName() + ":" + recordPenVO.getWebTcpPort() + "/" + recordPenVO.getContext();
      }
      
      model.addAttribute("serverUrl", serverUrl);
        /** EgovPropertyService.sample */
//        recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit"));
      recordPenVO.setPageSize(propertiesService.getInt("pageSize"));

        if(recordPenVO.getPagelist().equals("10")){
          recordPenVO.setPageUnit(propertiesService.getInt("pageUnit10"));
        }else if(recordPenVO.getPagelist().equals("50")){
          recordPenVO.setPageUnit(propertiesService.getInt("pageUnit50"));
        }else if(recordPenVO.getPagelist().equals("100")){
          recordPenVO.setPageUnit(propertiesService.getInt("pageUnit100"));
        }else if(recordPenVO.getPagelist().equals("200")){
          recordPenVO.setPageUnit(propertiesService.getInt("pageUnit200"));
        }
        /** paging setting */
        PaginationInfo paginationInfo = new PaginationInfo();
      paginationInfo.setCurrentPageNo(recordPenVO.getPageIndex());
      paginationInfo.setRecordCountPerPage(recordPenVO.getPageUnit());
      paginationInfo.setPageSize(recordPenVO.getPageSize());
      
      recordPenVO.setFirstIndex(paginationInfo.getFirstRecordIndex() + 1);
      recordPenVO.setLastIndex(paginationInfo.getLastRecordIndex());
      recordPenVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

      recordPenVO.setAuth((String) session.getAttribute("zirecx_id"));
      
//      recordSearchVO.setStrStartDate(recordSearchVO.getStrStartDate().replace("-",""));
//      recordSearchVO.setStrEndDate(recordSearchVO.getStrEndDate().replace("-",""));
      
      List<RecordPenVO> linkCallList = recordManageService.selectLinkPenCallList(recordPenVO);   
      /* 개행문자 처리 */
//      for(int i=0; i<linkCallList.size(); i++){
//        if(linkCallList.get(i).getCallMemo() != null){
//          linkCallList.get(i).setCallMemo(linkCallList.get(i).getCallMemo().replaceAll("\r\n|\n", "<br>"));
//        }
//      }
        model.addAttribute("linkCallList", linkCallList);
        
        int totCnt = recordManageService.selectLinkPenCallListTotCnt(recordPenVO);
      paginationInfo.setTotalRecordCount(totCnt);

      if(totCnt%Integer.parseInt(recordPenVO.getPagelist())<1){
        if(totCnt/Integer.parseInt(recordPenVO.getPagelist())<1){
          recordPenVO.setMaxpage(1);
        }else{
          recordPenVO.setMaxpage(totCnt/Integer.parseInt(recordPenVO.getPagelist()));
        }
      }else{
        if(totCnt/Integer.parseInt(recordPenVO.getPagelist())<1){
          recordPenVO.setMaxpage(1);
        }else{
          recordPenVO.setMaxpage((totCnt/Integer.parseInt(recordPenVO.getPagelist()))+1);
        }
      }
      
      recordPenVO.setTotalCount(totCnt);
      
      model.addAttribute("totalCount", recordPenVO.getTotalCount());
      model.addAttribute("maxPage", recordPenVO.getMaxpage());
          model.addAttribute("paginationInfo", paginationInfo);
          
          /* 페이징 숫자 더하기 */
        int cnt = 0;
          if(recordPenVO.getPageIndex() > 1){
            cnt = (recordPenVO.getPageIndex() - 1) * recordPenVO.getPageUnit();
          }
          model.addAttribute("cnt", cnt);
    	
          return "record/linkPenCallManageList";
    }

    
    /**
     * 펜 녹취 엑셀 
     * 
     * @param recordPenVO
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("/record/linkPenCallManageCheckExcelList.do")
    public ModelAndView selectCheckPenRecordExcelList(
    		@ModelAttribute("recordPenVO") RecordPenVO recordPenVO, HttpServletRequest request, HttpSession session
    		) throws Exception {
    	
    	TextUtil textUtil = TextUtil.getInstance();
    	
    	//엑셀 열기 시 컨트롤러 재호출.. null 처리
    	if(request.getParameterMap().isEmpty()) {
    		return null;
    	}
    	
    	recordPenVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
    	recordPenVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
    	recordPenVO.setStrSessionGroupId( recordPenVO.getStrAccessPolicy().equals("groupUp") 
												? textUtil.validateParam((String)session.getAttribute("parent_group_id"))
    											: textUtil.validateParam((String)session.getAttribute("group_id")) 
		);
    	
    	recordPenVO.setZirecxId((String)session.getAttribute("zirecx_id"));
		
		/** 현재 선택된 그룹의 하위그룹까지 가져온다. */
    	CmnGroupSearchVO cmnGroupSearchVO = new CmnGroupSearchVO();
		if(recordPenVO.getSchGroupId().equals("")){
			cmnGroupSearchVO.setGroupSearchSeq(recordPenVO.getStrSessionGroupId());
		}else{
	    	cmnGroupSearchVO.setGroupSearchSeq(recordPenVO.getSchGroupId());
		}
		String strGroupSeq = cmnGroupSearchService.subGroupSeq(cmnGroupSearchVO);
    	String[] arrGroupSeq = strGroupSeq.split(",");
    	recordPenVO.setArrGroupSeq(arrGroupSeq);
    	
    	String[] arrSelectedRecId = recordPenVO.getSelectedRecId().split(",");
    	recordPenVO.setArrSelectedRecId(arrSelectedRecId);
    	
    	recordPenVO.setStrStartDate(recordPenVO.getStrStartDate().replace("-",""));
    	recordPenVO.setStrEndDate(recordPenVO.getStrEndDate().replace("-",""));
    	
		/** 체크된 항목이 없을경우 경고. */
    	if(Arrays.toString(arrSelectedRecId).equals("[]")){
			return new ModelAndView("common/recordAlertCheck");
    	}
    	
    	List recordExcelList = recordManageService.selectCheckPenCallExcelList(recordPenVO);
     
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("recordExcel", recordExcelList);
    	return new ModelAndView("linkPenCallManageExcelDownload", "recordExcelMap", map);

    }
    
    
    /**
	 * 굿콜을 등록한다.
	 */
	@RequestMapping("/record/addGoodCall.do")
    public @ResponseBody String insertGoodCall(
    		HttpServletRequest request, RecordSearchVO recordSearchVO, HttpSession session
            ) throws Exception {

		recordSearchVO.setSchUserZirecxId((String)session.getAttribute("user_id"));
		
    	recordManageService.insertGoodCall(recordSearchVO);
    	  	
        return null;
    }
	
	/**
	 * 굿콜을 삭제한다.
	 */
	@RequestMapping("/record/removeGoodCall.do")
    public @ResponseBody String removeGoodCall(
    		HttpServletRequest request, RecordSearchVO recordSearchVO, HttpSession session
            ) throws Exception {

    	recordManageService.removeGoodCall(recordSearchVO);
    	   	
        return null ;
    }
	
	/**
	 * 파일을 다운로드한다.
	 */
	@RequestMapping("/record/fileDownload.do")
    public ModelAndView fileDownload(
    		@ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, HttpSession session
            ) throws Exception {
    	
		FileUtil fileUtil = new FileUtil();
		ZipUtil zipUtil = new ZipUtil();
		String serverUrl = "";
		String downloadcode = recordSearchVO.getDownloadcode();
		
		String[] arrSelectedRecId = recordSearchVO.getSelectedRecId().split(",");
    	recordSearchVO.setArrSelectedRecId(arrSelectedRecId);
    	
    	/** 체크된 항목이 없을경우 경고. */
    	if(Arrays.toString(arrSelectedRecId).equals("[]")){
			return new ModelAndView("common/recordAlertCheck");
    	}
    	
		List<RecordSearchVO> webPathList = recordManageService.selectWebPath(recordSearchVO);
		
		recordSearchVO.setWebHostName(webPathList.get(0).getAudioHostName());
		recordSearchVO.setWebTcpPort(webPathList.get(0).getAudioTcpPort());
		
		if(downloadcode.equals("Z")){
			recordSearchVO.setContext(webPathList.get(0).getZirecxContext());
		}else if(downloadcode.equals("M")){
			recordSearchVO.setContext(webPathList.get(0).getZiphoneContext());
		}
		
		recordSearchVO.setZipStorePath("downloads");
		
		ArrayList<Object> listSingleData = new ArrayList<Object>();
		
		int resultDownSeq = 0;
		if(downloadcode.equals("Z")){
			List<RecordSearchVO> fileDownloadList = recordManageService.fileDownload(recordSearchVO);
			for(int i=0; i<fileDownloadList.size(); i++){
				listSingleData.add(fileDownloadList.get(i).getFileName());
				
				recordSearchVO.setHistUserId((String)session.getAttribute("user_id"));
				recordSearchVO.setHistFileName(fileDownloadList.get(i).getFileName());
				recordSearchVO.setRecordingType("A");
				resultDownSeq = recordManageService.insertDownHist(recordSearchVO);
			}
		}else if(downloadcode.equals("M")){
			List<RecordSearchVO> fileDownloadList = recordManageService.linkCallFileDownload(recordSearchVO);
			for(int i=0; i<fileDownloadList.size(); i++){
				//listSingleData.add(fileDownloadList.get(i).getFileName());
				listSingleData.add(FileUtil.encodeFilename(fileDownloadList.get(i).getFileName(), false));
				
				recordSearchVO.setHistUserId((String)session.getAttribute("user_id"));
				recordSearchVO.setHistFileName(FileUtil.encodeFilename(fileDownloadList.get(i).getRecordFilenameRemoteMemory(), false));
				recordSearchVO.setHistId(fileDownloadList.get(i).getId());
				recordSearchVO.setRecordingType("A");
				resultDownSeq = recordManageService.insertDownHist(recordSearchVO);
			}
		}
		
    	if (recordSearchVO.getWebHostName() == null && recordSearchVO.getWebTcpPort() == null){
			serverUrl = "";
		} else {
			serverUrl = "http://" + recordSearchVO.getWebHostName() + ":" + recordSearchVO.getWebTcpPort() + "/" + recordSearchVO.getContext();
		}
    	
    	String dnloadFile[] = {"","0"};
		dnloadFile = zipUtil.compressFile(listSingleData, serverUrl, recordSearchVO.getZipStorePath());
    	
		String downFile = dnloadFile[0];
		String downFileLength = dnloadFile[1];
		
		File downloadFile = getFile(downFile);
		
		return new ModelAndView("downloadView", "downloadFile", downloadFile);
    }
    
	private File getFile(String pin) {
		String path = pin;
		return new File(path);
	}
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}
	
	/**
	 * 녹취파일 청취 팝업.
	 */
	@RequestMapping("/common/playerPop.do")
    public String playerPopView(@ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, Model model, HttpSession session) throws Exception {
    	return "common/playerPop";
    }
	
	/**
	 * 파일 변환 팝업.
	 */
	@RequestMapping("/common/fileCvtPop.do")
    public String fileCvtPopView(@ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, Model model, HttpSession session) throws Exception {
    	return "common/fileCvtPop";
    }
	
	/**
   * 녹취 업로드 팝업.
   */
	@RequestMapping("/common/uploadPenRec.do")
  public String uploadPenRecView(@ModelAttribute("recordPenVO") RecordPenVO recordPenVO, Model model, HttpSession session) throws Exception {
    return "common/uploadPenRecPop";
  }
	
	
	/**
	 * 통화 메모 팝업.
	 */
	@RequestMapping("/common/callMemoPop.do")
    public String callMemoPopView(
    		Model model, 
    		HttpSession session) throws Exception {
		//메모와 고객명 select
    	return "common/callMemoPop";
    }
	
	/**
	 * 굿콜 메모 팝업.
	 */
	@RequestMapping("/common/goodCallPop.do")
    public String goodCallPopView(@ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, Model model, HttpSession session) throws Exception {
    	return "common/goodCallPop";
    }
	
	/**
	 * 메모 수정한다.
	 * @exception Exception
	 */
    @RequestMapping("/record/updateMemo.do")
    public @ResponseBody String updateMemo(
    		@RequestParam(value="recId", required=true) int recId, 
    		@RequestParam(value="custName", required=false) String custName, 
    		@RequestParam(value="memo", required=false) String memo, 
    		Model model, 
    		HttpSession session
            ) throws Exception {
    	
    	RecordEditVO recordEditVO = new RecordEditVO();
    	recordEditVO.setRecId(recId);
    	recordEditVO.setCustName(custName);
    	recordEditVO.setCallMemo(memo);
    	
    	int result = 0;
    	result = recordManageService.updateMemo(recordEditVO);
    	

    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("result", result);    	
        return Util.URLEncode(jsonObject.toString(), "UTF-8").replace("+"," ");
    }
    
   
	
    /**
	 * 녹취 다운이력 조회 화면
	 */
    @SuppressWarnings({ "rawtypes"})
	@RequestMapping("/record/callHistoryManageMain.do")
    public String callHistoryManageMainView(
            @ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, Model model, HttpSession session
            ) throws Exception {
    	CmnPrivateVO cmnPrivateVO = new CmnPrivateVO();
    	
    	String[] privName = {
    			  messageSource.getMessage("message.db_new", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_save", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_group_select", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_group_tree", null, Locale.getDefault())
    			//사용자 선택 추가 
    			, messageSource.getMessage("message.db_user_select", null, Locale.getDefault())
    			
    			, messageSource.getMessage("message.db_excel", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_recfile_down", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_goodcall_select", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_file_cvt", null, Locale.getDefault())
    	};
		
    	cmnPrivateVO.setPrivName(privName);
    	cmnPrivateVO.setStrSecurityGroupId((String)session.getAttribute("security_group_id"));
    	
    	List listPrivate = cmnPrivateService.selectPrivateList(cmnPrivateVO);
    	
    	String strPrivName = 
    			  messageSource.getMessage("message.db_new", null, Locale.getDefault()) + "," + "btn_new" + "," + "버튼" +"|"
    			+ messageSource.getMessage("message.db_save", null, Locale.getDefault()) + "," + "btn_save" + "," + "버튼" + "|"
    			+ messageSource.getMessage("message.db_group_select", null, Locale.getDefault()) + "," + "" + "," + "그룹" + "|"
    			+ messageSource.getMessage("message.db_group_tree", null, Locale.getDefault()) + "," + "" + "," + "그룹트리" + "|"
    			//사용자추가 
    			+ messageSource.getMessage("message.db_user_select", null, Locale.getDefault()) + "," + "" + "," + "사용자" + "|"
    			
    			+ messageSource.getMessage("message.db_excel", null, Locale.getDefault()) + "," + "" + "," + "엑셀다운" + "|"
    			+ messageSource.getMessage("message.db_recfile_down", null, Locale.getDefault()) + "," + "" + "," + "파일다운" + "|"
    			+ messageSource.getMessage("message.db_goodcall_select", null, Locale.getDefault()) + "," + "" + "," + "굿콜지정" + "|"
    			+ messageSource.getMessage("message.db_file_cvt", null, Locale.getDefault()) + "," + "btn_cvt" + "," + "버튼"
    			;
    	model.addAttribute("strPrivName", strPrivName);
    	model.addAttribute("listPrivate", listPrivate);
    	
        return "record/callHistoryManageMain";
    }
    
    /**
	 * 녹취다운이력 리스트를 조회한다.
	 */
    @SuppressWarnings("rawtypes")
	@RequestMapping("/record/callHistoryManageList.do")
    public String selectCallHistoryList(
    		@ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, HttpServletRequest request, Model model, HttpSession session
            ) throws Exception {
    	
    	TextUtil textUtil = TextUtil.getInstance();
    	
    	recordSearchVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
		recordSearchVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
		//recordSearchVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("group_id")) );
		recordSearchVO.setStrSessionGroupId( recordSearchVO.getStrAccessPolicy().equals("groupUp") 
				? textUtil.validateParam((String)session.getAttribute("parent_group_id"))
				: textUtil.validateParam((String)session.getAttribute("group_id")) 
		);
		
		recordSearchVO.setZirecxId((String)session.getAttribute("zirecx_id"));
		
		// 2017-03-30 iklee 
		// 	- 쿼리 튜닝으로 DATE형태로 비교하지 않고 INT로 비교. 따라서 "-" 제거
		recordSearchVO.setStrStartDate(recordSearchVO.getStrStartDate().replaceAll("-", ""));
		recordSearchVO.setStrEndDate(recordSearchVO.getStrEndDate().replaceAll("-", ""));
		
		/** 현재 선택된 그룹의 하위그룹까지 가져온다. */
    	CmnGroupSearchVO cmnGroupSearchVO = new CmnGroupSearchVO();
		if(recordSearchVO.getSchGroupId().equals("")){
			cmnGroupSearchVO.setGroupSearchSeq(recordSearchVO.getStrSessionGroupId());
		}else{
	    	cmnGroupSearchVO.setGroupSearchSeq(recordSearchVO.getSchGroupId());
		}
		String strGroupSeq = cmnGroupSearchService.subGroupSeq(cmnGroupSearchVO);
    	String[] arrGroupSeq = strGroupSeq.split(",");
    	recordSearchVO.setArrGroupSeq(arrGroupSeq);
    	
    	/** EgovPropertyService.sample */
    	recordSearchVO.setPageSize(propertiesService.getInt("pageSize"));

    	if(recordSearchVO.getPagelist().equals("10")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit10"));
    	}else if(recordSearchVO.getPagelist().equals("50")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit50"));
    	}else if(recordSearchVO.getPagelist().equals("100")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit100"));
    	}else if(recordSearchVO.getPagelist().equals("200")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit200"));
    	}
    	/** paging setting */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(recordSearchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(recordSearchVO.getPageUnit());
		paginationInfo.setPageSize(recordSearchVO.getPageSize());
		
		recordSearchVO.setFirstIndex(paginationInfo.getFirstRecordIndex() + 1);
		recordSearchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		recordSearchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		recordSearchVO.setAuth((String) session.getAttribute("zirecx_id"));
		
		List<RecordSearchVO> callHistoryList = recordManageService.selectCallHistoryList(recordSearchVO);
		
    	model.addAttribute("callHistoryList", callHistoryList);
    	
    	int totCnt = recordManageService.selectCallHistoryListTotCnt(recordSearchVO);
		paginationInfo.setTotalRecordCount(totCnt);

		if(totCnt%Integer.parseInt(recordSearchVO.getPagelist())<1){
			if(totCnt/Integer.parseInt(recordSearchVO.getPagelist())<1){
				recordSearchVO.setMaxpage(1);
			}else{
				recordSearchVO.setMaxpage(totCnt/Integer.parseInt(recordSearchVO.getPagelist()));
			}
		}else{
			if(totCnt/Integer.parseInt(recordSearchVO.getPagelist())<1){
				recordSearchVO.setMaxpage(1);
			}else{
				recordSearchVO.setMaxpage((totCnt/Integer.parseInt(recordSearchVO.getPagelist()))+1);
			}
		}
		
		recordSearchVO.setTotalCount(totCnt);
		
		model.addAttribute("totalCount", recordSearchVO.getTotalCount());
		model.addAttribute("maxPage", recordSearchVO.getMaxpage());
        model.addAttribute("paginationInfo", paginationInfo);
        
        /* 페이징 숫자 더하기 */
    	int cnt = 0;
        if(recordSearchVO.getPageIndex() > 1){
        	cnt = (recordSearchVO.getPageIndex() - 1) * recordSearchVO.getPageUnit();
        }
        model.addAttribute("cnt", cnt);
    	
        return "record/callHistoryManageList";
    }
    
    /**
	 * 녹취연동관리 리스트를 새로고침 한다.
	 */
    @SuppressWarnings("rawtypes")
	@RequestMapping("/record/callHistoryRefreshList.do")
    public String selectCallHistoryRefreshList(
    		@ModelAttribute("recordSearchVO") RecordSearchVO recordSearchVO, HttpServletRequest request, Model model, HttpSession session
            ) throws Exception {

    	TextUtil textUtil = TextUtil.getInstance();
    	
    	recordSearchVO.setStrAccessPolicy( request.getParameter("hidAccessPolicy") );
		recordSearchVO.setStrSessionLoginString( (String)session.getAttribute("login_string") );
		recordSearchVO.setStrSessionGroupId( textUtil.validateParam((String)session.getAttribute("group_id")) );
		recordSearchVO.setZirecxId((String)session.getAttribute("zirecx_id"));
		
		// 2017-03-30 iklee 
		// 	- 쿼리 튜닝으로 DATE형태로 비교하지 않고 INT로 비교. 따라서 "-" 제거
		recordSearchVO.setStrStartDate(recordSearchVO.getStrStartDate().replaceAll("-", ""));
		recordSearchVO.setStrEndDate(recordSearchVO.getStrEndDate().replaceAll("-", ""));
		
		/** 현재 선택된 그룹의 하위그룹까지 가져온다. */
    	CmnGroupSearchVO cmnGroupSearchVO = new CmnGroupSearchVO();
		if(recordSearchVO.getSchGroupId().equals("")){
			cmnGroupSearchVO.setGroupSearchSeq(recordSearchVO.getStrSessionGroupId());
		}else{
	    	cmnGroupSearchVO.setGroupSearchSeq(recordSearchVO.getSchGroupId());
		}
		String strGroupSeq = cmnGroupSearchService.subGroupSeq(cmnGroupSearchVO);
    	String[] arrGroupSeq = strGroupSeq.split(",");
    	recordSearchVO.setArrGroupSeq(arrGroupSeq);
    	
    	/** EgovPropertyService.sample */
    	recordSearchVO.setPageSize(propertiesService.getInt("pageSize"));

    	if(recordSearchVO.getPagelist().equals("10")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit10"));
    	}else if(recordSearchVO.getPagelist().equals("50")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit50"));
    	}else if(recordSearchVO.getPagelist().equals("100")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit100"));
    	}else if(recordSearchVO.getPagelist().equals("200")){
    		recordSearchVO.setPageUnit(propertiesService.getInt("pageUnit200"));
    	}
    	
    	/** paging setting */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(recordSearchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(recordSearchVO.getPageUnit());
		paginationInfo.setPageSize(recordSearchVO.getPageSize());
		
		recordSearchVO.setFirstIndex(paginationInfo.getFirstRecordIndex() + 1);
		recordSearchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		recordSearchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		recordSearchVO.setAuth((String) session.getAttribute("zirecx_id"));
		
		
		recordSearchVO.setSchUserZirecxId(recordSearchVO.getRefuserId());
		recordSearchVO.setSchGroupId(recordSearchVO.getRefgroupSeq());
		recordSearchVO.setSearchKeyword(recordSearchVO.getRefsearchKeyword());
		recordSearchVO.setStrStartTime(recordSearchVO.getRefstrStartTime());
		recordSearchVO.setStrEndTime(recordSearchVO.getRefstrEndTime());
		recordSearchVO.setCallresult(recordSearchVO.getRefcallresult());
		recordSearchVO.setCampaign(recordSearchVO.getRefcampaign());
		
		List<RecordSearchVO> callHistoryList = recordManageService.selectCallHistoryList(recordSearchVO);		
    	model.addAttribute("callHistoryList", callHistoryList);
    	
    	int totCnt = recordManageService.selectCallHistoryListTotCnt(recordSearchVO);
		paginationInfo.setTotalRecordCount(totCnt);

		if(totCnt%Integer.parseInt(recordSearchVO.getPagelist())<1){
			if(totCnt/Integer.parseInt(recordSearchVO.getPagelist())<1){
				recordSearchVO.setMaxpage(1);
			}else{
				recordSearchVO.setMaxpage(totCnt/Integer.parseInt(recordSearchVO.getPagelist()));
			}
		}else{
			if(totCnt/Integer.parseInt(recordSearchVO.getPagelist())<1){
				recordSearchVO.setMaxpage(1);
			}else{
				recordSearchVO.setMaxpage((totCnt/Integer.parseInt(recordSearchVO.getPagelist()))+1);
			}
		}
		
		recordSearchVO.setTotalCount(totCnt);
		
		model.addAttribute("totalCount", recordSearchVO.getTotalCount());
		model.addAttribute("maxPage", recordSearchVO.getMaxpage());
        model.addAttribute("paginationInfo", paginationInfo);
        
        /* 페이징 숫자 더하기 */
    	int cnt = 0;
        if(recordSearchVO.getPageIndex() > 1){
        	cnt = (recordSearchVO.getPageIndex() - 1) * recordSearchVO.getPageUnit();
        }
        model.addAttribute("cnt", cnt);
    	
        return "record/callHistoryManageList";
    }
    
    /**
     *  펜녹취 insert 수동 
     *  
     * @param recordPenVO
     * @param req
     * @param response
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/record/insertPenCallInfo.do") 
    public @ResponseBody Map insertPenCallInfo(@ModelAttribute("recordPenVO") RecordPenVO recordPenVO, 
    		HttpServletRequest req, HttpServletResponse response,
    		Model model, HttpSession session) { 
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      Map fileInfo = null;
      /*
      System.out.println("customerNumber " + req.getParameter("customerNumber"));
      System.out.println("customerName " + req.getParameter("customerName"));
      System.out.println("faceToFace " + req.getParameter("faceToFace"));
      System.out.println("visitDateClass " + req.getParameter("visitDateClass"));
      System.out.println("visitDate " + req.getParameter("visitDate"));
      System.out.println("visitPlace " + req.getParameter("visitPlace"));
      */
      TextUtil textUtil = TextUtil.getInstance();
      /*
      System.out.println("hidAccessPolicy " + req.getParameter("hidAccessPolicy"));
      System.out.println("user_id " + (String)session.getAttribute("user_id"));
      System.out.println("group_id " + textUtil.validateParam((String)session.getAttribute("group_id")));
      System.out.println("zirecx_id " + (String)session.getAttribute("zirecx_id"));
      */
      Date today = new Date();
      SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
      SimpleDateFormat time = new SimpleDateFormat("kkmmss");
      
      String result = "업로드에 실패했습니다. 다시 시도해주세요.";
      String path = "d:"+File.separator+"RecData"+File.separator+"welcomeloan"+File.separator;
      int encResult = 0;
      
      String zirecxId = (String)session.getAttribute("zirecx_id");
      
      try {
          //  해당 디렉토리 위치에 파일 업로드
    	  //System.out.println("fileUpload Start");
          fileInfo = fileUpload(req, path+date.format(today), date.format(today), time.format(today), zirecxId);
          //System.out.println("fileInfo.size: "+fileInfo.size());
          List files = (List)fileInfo.get("files"); 
        
          if( files.size() > 0 ){ 
            
            for(int i=0;i<files.size();i++){ 
              Map file = (Map)files.get(i); 
              String origName = (String)file.get("origName"); 
              File sFile = (File)file.get("sfile"); 
//              param.put("file_name", sFile.getName()); 
//              //복호화된 파일 이름 
//              param.put("file_path", sFile.getAbsolutePath()); 
//              //물리적 저장 경로 
//              param.put("file_size", sFile.length()); 
//              //파일 크기 
//              param.put("file_orig", origName); 
              //원래 파일 명 
              
              recordPenVO.setSchUserZirecxId((String) session.getAttribute("user_id"));
              recordPenVO.setZirecxId(zirecxId);
              recordPenVO.setPhoneNumber(req.getParameter("customerNumber"));
              recordPenVO.setCustomerName(req.getParameter("customerName"));
              recordPenVO.setFaceToFace(req.getParameter("faceToFace"));
              recordPenVO.setVisitPlace(req.getParameter("visitPlace"));
              recordPenVO.setVisitDate(req.getParameter("visitDate").replaceAll("-", ""));
              recordPenVO.setVisitDateClass(req.getParameter("visitDateClass"));
              recordPenVO.setPlayTime("0");
              recordPenVO.setRecordFilePath(date.format(today));
              recordPenVO.setRecordFileName(sFile.getName());
              recordPenVO.setRecordModeCode("P");
              
              //파일 AES256암호화
              encResult = 0;
              //파일 암호화
              //System.out.println("serverFile Path: "+path+date.format(today) + File.separator + "temp" + File.separator + date +"_"+time+"_"+origName);
            	  encResult = AES256FileEncCBC.getInstance().AES256FileEncCBC(
            			  path+date.format(today) + File.separator + "temp" + File.separator + sFile.getName(), 
            			  path+date.format(today) + File.separator + sFile.getName());
              
             if(encResult>0){
            	 recordManageService.insertPenCallInfo(recordPenVO);
            	 result = "성공적으로 업로드되었습니다.";
             }
            }
            
          }
          
          PrintWriter out = response.getWriter();
          out.println("<script language=javascript charset='utf-8'>");
          out.println("alert('"+result+"');");
          out.println("self.close();");
          out.println("</script>");
          out.flush();
          out.close();
      } catch (IllegalStateException e) { 
        e.printStackTrace(); 
      } catch (Exception e) {
        e.printStackTrace();
      } 
      return null; 
    }

    
    public Map fileUpload(HttpServletRequest req, String path, String date, String time, String zirecxId) { 
      //파일이 저장될 path 설정
      Map returnObject = new HashMap(); 
      try { 
    	//System.out.println("fileUpload step 1");
    	//System.out.println("fileUpload path: "+path+", date: "+date+", time: "+time);
        // MultipartHttpServletRequest 생성
        MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req;
        mhsr.setCharacterEncoding("UTF-8");
        Iterator<String> iter = mhsr.getFileNames(); 
        MultipartFile mfile = null; 
        String fieldName = ""; 
        List resultList = new ArrayList(); 
        // 디레토리가 없다면 생성 
        File dir = new File(path); 
        if (!dir.isDirectory()) { 
          dir.mkdirs(); 
        }
        int pos = 0;
        String ext = null;
        // 값이 나올때까지 
        while (iter.hasNext()) { 
          fieldName = iter.next(); 
          // 내용을 가져와서 
          mfile = mhsr.getFile(fieldName); 
          pos = mfile.getOriginalFilename().lastIndexOf(".");
          ext = mfile.getOriginalFilename().substring(pos);
          String origName = zirecxId+ext;
          //origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8");
          System.out.println("target zirecxId : "+zirecxId);
          //origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8");
          //origName = new String(mfile.getOriginalFilename());
          //한글꺠짐 방지 
          // 파일명이 없다면
          if ("".equals(origName)) { 
            continue; 
          }
          
          File tempD = new File(path + File.separator + "temp");
          if(!tempD.isDirectory()){
        	  tempD.mkdirs();
          }
          
          // 설정한 path에 파일저장 
          File serverFile = new File(path + File.separator + "temp" + File.separator + date +"_"+time+"_"+origName); 
          mfile.transferTo(serverFile); 
          
          Map file = new HashMap(); 
          file.put("origName", origName); 
          file.put("sfile", serverFile); 
          resultList.add(file);
        } 
        returnObject.put("files", resultList); 
        returnObject.put("params", mhsr.getParameterMap());
        
      } catch (UnsupportedEncodingException e) { 
        // TODO Auto-generated catch block 
        e.printStackTrace(); 
      } catch (IllegalStateException e) { 
        // TODO Auto-generated catch block 
        e.printStackTrace(); 
      } catch (IOException e) { 
        // TODO Auto-generated catch block 
        e.printStackTrace(); 
      } 
      return returnObject; 
    } 
    
    /**
	 * 펜 녹취 파일을 다운로드한다.
	 */
	@RequestMapping("/record/fileDownloadPen.do")
    public ModelAndView fileDownloadPen(
    		@ModelAttribute("recordPenVO") RecordPenVO recordPenVO, HttpSession session
            ) throws Exception {
    	
		FileUtil fileUtil = new FileUtil();
		ZipUtil zipUtil = new ZipUtil();
		String serverUrl = "";
		
		String[] arrSelectedRecId = recordPenVO.getSelectedRecId().split(",");
		recordPenVO.setArrSelectedRecId(arrSelectedRecId);
    	
    	/** 체크된 항목이 없을경우 경고. */
    	if(Arrays.toString(arrSelectedRecId).equals("[]")){
			return new ModelAndView("common/recordAlertCheck");
    	}
    	
		List<RecordPenVO> webPathList = recordManageService.selectWebPathPen(recordPenVO);
		
		recordPenVO.setWebHostName(webPathList.get(0).getAudioHostName());
		recordPenVO.setWebTcpPort(webPathList.get(0).getAudioTcpPort());
		recordPenVO.setContext(webPathList.get(0).getZiphoneContext());
		
		recordPenVO.setZipStorePath("downloads");
		
		ArrayList<Object> listSingleData = new ArrayList<Object>();
		
		int resultDownSeq = 0;
		List<RecordSearchVO> fileDownloadList = recordManageService.fileDownloadPen(recordPenVO);
		for(RecordSearchVO rv : fileDownloadList){
			listSingleData.add(FileUtil.encodeFilename(rv.getFileName(), false));
			
			rv.setHistUserId((String)session.getAttribute("user_id"));
			rv.setHistFileName(FileUtil.encodeFilename(rv.getFileName(), false));
			rv.setHistId(rv.getId());
			rv.setRecordingType("P");
			resultDownSeq = recordManageService.insertDownHist(rv);
		}
		
    	if (recordPenVO.getWebHostName() == null && recordPenVO.getWebTcpPort() == null){
			serverUrl = "";
		} else {
			serverUrl = "http://" + recordPenVO.getWebHostName() + ":" + recordPenVO.getWebTcpPort() + "/" + recordPenVO.getContext();
		}
    	
    	String dnloadFile[] = {"","0"};
		dnloadFile = zipUtil.compressFile(listSingleData, serverUrl, recordPenVO.getZipStorePath());
    	
		String downFile = dnloadFile[0];
		String downFileLength = dnloadFile[1];
		
		File downloadFile = getFile(downFile);
		
		return new ModelAndView("downloadView", "downloadFile", downloadFile);
    }
}
