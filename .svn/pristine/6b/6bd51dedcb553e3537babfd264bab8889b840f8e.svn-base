package kr.co.irlink.zirecx.report.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.irlink.zirecx.common.service.CmnPrivateService;
import kr.co.irlink.zirecx.common.service.CmnPrivateVO;
import kr.co.irlink.zirecx.report.service.ReportSearchDurationVO;
import kr.co.irlink.zirecx.report.service.ReportSearchVO;
import kr.co.irlink.zirecx.report.service.LinkageReportManageService;
import kr.co.irlink.zirecx.util.TextUtil;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller

public class LinkageReportManageController {
	/** LinkageReportManageService */
    @Resource(name = "linkageReportManageService")
    private LinkageReportManageService linkageReportManageService;
    
    /** CmnPrivateService */
    @Resource(name = "cmnPrivateService")
    private CmnPrivateService cmnPrivateService;
    
    @Resource(name="messageSource")
	MessageSource messageSource ;
    
	/**
	 * 콜통계 (연동형)
	 */
    @RequestMapping("/report/linkageReportManageMain.do")
    public String LinkageReportManageMainView(@ModelAttribute("reportSearchVO") ReportSearchVO reportSearchVO, Model model, HttpSession session) throws Exception {
    	
    	CmnPrivateVO cmnPrivateVO = new CmnPrivateVO();
    	
    	String[] privName = {
    			  messageSource.getMessage("message.db_new", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_save", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_group_select", null, Locale.getDefault())//
    			, messageSource.getMessage("message.db_group_tree", null, Locale.getDefault())//
    			, messageSource.getMessage("message.db_excel", null, Locale.getDefault())
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
    	;
    	model.addAttribute("strPrivName", strPrivName);
    	model.addAttribute("listPrivate", listPrivate);

    	return "report/linkageReportManageMain";
    }
    
    /**
	 * 콜통계 (연동형) 초기화 리스트
	 */
    @RequestMapping("/report/linkageReportManageInitList.do")
    public String linkageReportManageInitList(
    		HttpServletRequest request, @ModelAttribute("reportSearchVO") ReportSearchVO reportSearchVO, Model model, HttpSession session
            ) throws Exception {
    	ArrayList<EgovMap> newReportList = new ArrayList<EgovMap>();
    	model.addAttribute("reportList", newReportList);
    	return "report/linkageReportManageList";
    }
    
    
	
    /**
	 * 콜통계 (연동형) 리스트
	 */
    @RequestMapping(value={"/report/linkageReportManageList.do", "/report/linkageReportManageListExcel.do"})
    public String linkageReportManageList(
    		HttpServletRequest request, @ModelAttribute("reportSearchVO") ReportSearchVO reportSearchVO, Model model, HttpSession session
            ) throws Exception {

		reportSearchVO.setStrStartDate(reportSearchVO.getStrStartDate().replaceAll("-", ""));
		reportSearchVO.setStrEndDate(reportSearchVO.getStrEndDate().replaceAll("-", ""));
		reportSearchVO.setSessionZirecxId(session.getAttribute("zirecx_id").toString());
		reportSearchVO.setSessionGroupId(session.getAttribute("group_id").toString());
		reportSearchVO.setAccessPolicy(request.getParameter("hidAccessPolicy"));
		
		// 오늘 날짜 구하기 (당일 통계 포함하여 조회하는지 구분하기 위함)
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		reportSearchVO.setStrToday(simpleDateFormat.format(calendar.getTime()));	// 오늘 날짜 (YYYYMMDD)
		
		reportSearchVO.setChkSql1("");	//과거자료 조회여부
		reportSearchVO.setChkSql2("");	//당일자료 조회여부
		
		// 검색 종료일자가 오늘 날짜와 같다면 기존자료 조회시 종료일자 -1
		if (reportSearchVO.getStrEndDate().equals(reportSearchVO.getStrToday())) {
			calendar.add(calendar.DATE, -1);
			reportSearchVO.setStrEndDate(simpleDateFormat.format(calendar.getTime()));
			reportSearchVO.setChkSql2("1");
		}
		// 기존자료 조회 조건 체크 (시작일자가 종료일자보다 작거나 같을 경우. 단, 당일자료 포함 조회시에는 종료일자는 -1)
		if (Integer.parseInt(reportSearchVO.getStrStartDate()) <= Integer.parseInt(reportSearchVO.getStrEndDate())) {
			reportSearchVO.setChkSql1("1");
		}

    	/** 콜통계 리스트를 가져온다. */
		List reportList = linkageReportManageService.selectLinkageReportList(reportSearchVO);
				
    	/** 콜통계 리스트의 합계를 계산한다. */
    	Map<String, Object> totCnt = new HashMap<String, Object>();
    	//합계를 저장 할 변수 초기화
    	int[] iSum = {0, 0, 0, 0};
    	
    	//합계 계산
    	ArrayList<EgovMap> newReportList = new ArrayList<EgovMap>();
    	for(int i=0; i<reportList.size(); i++) {
    		EgovMap tmpMap = (EgovMap)reportList.get(i);
    		int[] iCnt = {0, 0, 0, 0};
    		iCnt[0] = Integer.parseInt(String.valueOf(tmpMap.get("outDurationCall")));
    		iCnt[1] = Integer.parseInt(String.valueOf(tmpMap.get("inDurationCall")));
    		iCnt[2] = Integer.parseInt(String.valueOf(tmpMap.get("outCountCall")));
    		iCnt[3] = Integer.parseInt(String.valueOf(tmpMap.get("inCountCall")));
			
			iSum[0] += iCnt[0];
			iSum[1] += iCnt[1];
			iSum[2] += iCnt[2];
			iSum[3] += iCnt[3];
			
			EgovMap newMap = new EgovMap();
			newMap.put("id", tmpMap.get("id"));
			newMap.put("groupId", tmpMap.get("groupId"));
			newMap.put("firstName", tmpMap.get("firstName"));
			newMap.put("zirecxId", tmpMap.get("zirecxId"));
			newMap.put("phonenumber", tmpMap.get("phonenumber"));
			newMap.put("totDurationCall", TextUtil.secondsToHHmmss(iCnt[0]+iCnt[1]));
			newMap.put("outDurationCall", TextUtil.secondsToHHmmss(iCnt[0]));
			newMap.put("inDurationCall", TextUtil.secondsToHHmmss(iCnt[1]));
			
			if(iCnt[2]+iCnt[3] > 0)
				newMap.put("totDurationAverage", TextUtil.secondsToHHmmss((iCnt[0]+iCnt[1])/(iCnt[2]+iCnt[3])));
			else
				newMap.put("totDurationAverage", "00:00:00");
			
			if(iCnt[2] > 0)
				newMap.put("outDurationAverage", TextUtil.secondsToHHmmss(iCnt[0]/iCnt[2]));
			else
				newMap.put("outDurationAverage", "00:00:00");
			
			if(iCnt[3] > 0)
				newMap.put("inDurationAverage", TextUtil.secondsToHHmmss(iCnt[1]/iCnt[3]));
			else
				newMap.put("inDurationAverage", "00:00:00");
			
			newMap.put("totCountCall", iCnt[2]+iCnt[3]);
			newMap.put("outCountCall", iCnt[2]);
			newMap.put("inCountCall", iCnt[3]);
			
			newReportList.add(newMap);
    	}
    	
    	model.addAttribute("reportList", newReportList);
    	
    	//합계를 model에 추가
    	totCnt.put("totDurationCall", TextUtil.secondsToHHmmss(iSum[0]+iSum[1]));
    	totCnt.put("outDurationCall", TextUtil.secondsToHHmmss(iSum[0]));
    	totCnt.put("inDurationCall", TextUtil.secondsToHHmmss(iSum[1]));
    	
    	if(iSum[2]+iSum[3] > 0)
			totCnt.put("totDurationAverage", TextUtil.secondsToHHmmss((iSum[0]+iSum[1])/(iSum[2]+iSum[3])));
		else
			totCnt.put("totDurationAverage", "00:00:00");
		
		if(iSum[2] > 0)
			totCnt.put("outDurationAverage", TextUtil.secondsToHHmmss(iSum[0]/iSum[2]));
		else
			totCnt.put("outDurationAverage", "00:00:00");
		
		if(iSum[3] > 0)
			totCnt.put("inDurationAverage", TextUtil.secondsToHHmmss(iSum[1]/iSum[3]));
		else
			totCnt.put("inDurationAverage", "00:00:00");
    	
    	totCnt.put("totCountCall", iSum[2]+iSum[3]);
    	totCnt.put("outCountCall", iSum[2]);
    	totCnt.put("inCountCall", iSum[3]);
    	
    	model.addAttribute("totCnt", totCnt);
    	
    	if(request.getRequestURI().indexOf("Excel") < 0){
    		if("user".equals(reportSearchVO.getSelSearchType()))
    			return "report/linkageReportManageList";
    		else if("group".equals(reportSearchVO.getSelSearchType()))
    			return "report/linkageReportManageGroupList";
    		
    	}else{
    		if("user".equals(reportSearchVO.getSelSearchType()))
    			return "report/linkageReportManageListExcel";
    		else if("group".equals(reportSearchVO.getSelSearchType()))
    			return "report/linkageReportManageGroupListExcel";
    	}
    	
    	return "report/linkageReportManageList";
    }
    
    
    /**
	 * 시간대별 콜통계(연동형)
	 */
    @RequestMapping("/report/linkageReportHourlyManageMain.do")
    public String LinkageReportHourlyManageMainView(@ModelAttribute("reportSearchVO") ReportSearchVO reportSearchVO, Model model, HttpSession session) throws Exception {
    
    	CmnPrivateVO cmnPrivateVO = new CmnPrivateVO();
    	
    	String[] privName = {
    			  messageSource.getMessage("message.db_new", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_save", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_group_select", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_group_tree", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_excel", null, Locale.getDefault())
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
    	;
    	model.addAttribute("strPrivName", strPrivName);
    	model.addAttribute("listPrivate", listPrivate);
    	
    	return "report/linkageReportHourlyManageMain";
    }
    
    /**
	 * 시간대별 콜통계(연동형) 초기화 리스트
	 */
    @RequestMapping("/report/linkageReportHourlyManageInitList.do")
    public String linkageReportHourlyManageInitList(
    		HttpServletRequest request, @ModelAttribute("reportSearchVO") ReportSearchVO reportSearchVO, Model model, HttpSession session
            ) throws Exception {
    	ArrayList<EgovMap> newReportList = new ArrayList<EgovMap>();
    	model.addAttribute("reportList", newReportList);
    	return "report/linkageReportHourlyManageList";
    }
    
    
	
    /**
	 * 시간대별 콜통계(연동형) 리스트
	 */
    @RequestMapping(value={"/report/linkageReportHourlyManageList.do", "/report/linkageReportHourlyManageListExcel.do"})
    public String linkageReportHourlyManageList(
    		HttpServletRequest request, @ModelAttribute("reportSearchVO") ReportSearchVO reportSearchVO, Model model, HttpSession session
            ) throws Exception {
    	
    	reportSearchVO.setStrStartDate(reportSearchVO.getStrStartDate().replaceAll("-", ""));
		reportSearchVO.setStrEndDate(reportSearchVO.getStrEndDate().replaceAll("-", ""));
		reportSearchVO.setSessionZirecxId(session.getAttribute("zirecx_id").toString());
		reportSearchVO.setSessionGroupId(session.getAttribute("group_id").toString());
		reportSearchVO.setAccessPolicy(request.getParameter("hidAccessPolicy"));
		
		// 오늘 날짜 구하기 (당일 통계 포함하여 조회하는지 구분하기 위함)
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		reportSearchVO.setStrToday(simpleDateFormat.format(calendar.getTime()));	// 오늘 날짜 (YYYYMMDD)
		
		reportSearchVO.setChkSql1("");	//과거자료 조회여부
		reportSearchVO.setChkSql2("");	//당일자료 조회여부
		
		// 검색 종료일자가 오늘 날짜와 같다면 기존자료 조회시 종료일자 -1
		if (reportSearchVO.getStrEndDate().equals(reportSearchVO.getStrToday())) {
			calendar.add(calendar.DATE, -1);
			reportSearchVO.setStrEndDate(simpleDateFormat.format(calendar.getTime()));
			reportSearchVO.setChkSql2("1");
		}
		// 기존자료 조회 조건 체크 (시작일자가 종료일자보다 작거나 같을 경우. 단, 당일자료 포함 조회시에는 종료일자는 -1)
		if (Integer.parseInt(reportSearchVO.getStrStartDate()) <= Integer.parseInt(reportSearchVO.getStrEndDate())) {
			reportSearchVO.setChkSql1("1");
		}
		/*
		if("1".equals(reportSearchVO.getChkSql1()) && "1".equals(reportSearchVO.getChkSql2())){
			reportSearchVO.setOrderKey(String.valueOf(reportSearchVO.getOrderKey().substring(reportSearchVO.getOrderKey().lastIndexOf(".")+1)));
		}
		*/
    	/** 시간대별 콜통계 리스트를 가져온다. */
		List reportList = linkageReportManageService.selectLinkageHourlyReportList(reportSearchVO);
				
    	/** 시간대별 콜통계 리스트의 합계를 계산한다. */
    	Map<String, Object> totCnt = new HashMap<String, Object>();
    	//합계를 저장 할 변수 초기화
    	int[] iSum = new int[200];
    	
    	//합계 계산
    	ArrayList<EgovMap> newReportList = new ArrayList<EgovMap>();
    	for(int i=0; i<reportList.size(); i++) {
    		
    		EgovMap tmpMap = (EgovMap)reportList.get(i);
    		
    		EgovMap newMap = new EgovMap();
    		newMap.put("groupId", tmpMap.get("groupId"));
    		if("user".equals(reportSearchVO.getSelSearchType())){
				newMap.put("id", tmpMap.get("id"));
				newMap.put("firstName", tmpMap.get("firstName"));
				newMap.put("zirecxId", tmpMap.get("zirecxId"));
				newMap.put("phonenumber", tmpMap.get("phonenumber"));
    		}
			
			int iOut = 0, iIn = 0, iOption;
			if("group".equals(reportSearchVO.getSelSearchType())){
				iOption = 1;
				newMap.put("dT16", TextUtil.secondsToHHmmss(Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(65))))));
				newMap.put("dO16", TextUtil.secondsToHHmmss(Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(66))))));
				newMap.put("dI16", TextUtil.secondsToHHmmss(Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(67))))));
				newMap.put("cT16", Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(68)))));
				newMap.put("cO16", Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(69)))));
				newMap.put("cI16", Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(70)))));
			}else{
				iOption = 5;
				newMap.put("dT16", TextUtil.secondsToHHmmss(Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(69))))));
				newMap.put("dO16", TextUtil.secondsToHHmmss(Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(70))))));
				newMap.put("dI16", TextUtil.secondsToHHmmss(Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(71))))));
				newMap.put("cT16", Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(72)))));
				newMap.put("cO16", Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(73)))));
				newMap.put("cI16", Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(74)))));
			}
			
			for (int j=0; j<16; j++){
    			iOut = Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(2*j+iOption))));	//out_duration_call_00_09
    			iIn = Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(2*j+iOption+1))));	//in_duration_call_00_09
    			newMap.put("dT"+j, TextUtil.secondsToHHmmss(iOut + iIn));
    			newMap.put("dO"+j, TextUtil.secondsToHHmmss(iOut));
    			newMap.put("dI"+j, TextUtil.secondsToHHmmss(iIn));
    			iSum[2*j] += iOut;
    			iSum[2*j+1] += iIn;
    		}
    		
    		for (int j=16; j<32; j++){
    			iOut = Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(2*j+iOption))));	//out_count_call_00_09
    			iIn = Integer.parseInt(String.valueOf(tmpMap.get(tmpMap.get(2*j+iOption+1))));	//in_count_call_00_09
    			newMap.put("cT"+(j-16), iOut + iIn);
    			newMap.put("cO"+(j-16), iOut);
    			newMap.put("cI"+(j-16), iIn);
    			iSum[2*j] += iOut;
    			iSum[2*j+1] += iIn;
    		}
    		
    		
    		newReportList.add(newMap);
    	}
    	
    	model.addAttribute("reportList", newReportList);
    	
    	int dtsum = 0;
    	int dosum = 0;
    	int disum = 0;
    	int ctsum = 0;
    	int cosum = 0;
    	int cisum = 0;
    	
    	//합계를 model에 추가
    	for (int j=0; j<16; j++){
    		totCnt.put("totDT"+j, TextUtil.secondsToHHmmss(iSum[2*j]+iSum[2*j+1]));
    		totCnt.put("totDO"+j, TextUtil.secondsToHHmmss(iSum[2*j]));
    		totCnt.put("totDI"+j, TextUtil.secondsToHHmmss(iSum[2*j+1]));
    		dtsum += iSum[2*j]+iSum[2*j+1];
    		dosum += iSum[2*j];
    		disum += iSum[2*j+1];
    	}
    	
    	for (int j=16; j<32; j++){
    		totCnt.put("totCT"+(j-16), iSum[2*j]+iSum[2*j+1]);
    		totCnt.put("totCO"+(j-16), iSum[2*j]);
    		totCnt.put("totCI"+(j-16), iSum[2*j+1]);
    		
    		ctsum += iSum[2*j]+iSum[2*j+1];
    		cosum += iSum[2*j];
    		cisum += iSum[2*j+1];
		}
    	
    	totCnt.put("totDT16" ,  TextUtil.secondsToHHmmss(dtsum));
    	totCnt.put("totDO16" ,  TextUtil.secondsToHHmmss(dosum));
    	totCnt.put("totDI16" ,  TextUtil.secondsToHHmmss(disum));
    	totCnt.put("totCT16" ,  ctsum);
    	totCnt.put("totCO16" ,  cosum);
    	totCnt.put("totCI16" ,  cisum);
    	
    	model.addAttribute("totCnt", totCnt);
    	
    	if(request.getRequestURI().indexOf("Excel") < 0){
    		if("user".equals(reportSearchVO.getSelSearchType()))
    			return "report/linkageReportHourlyManageList";
    		else if("group".equals(reportSearchVO.getSelSearchType()))
    			return "report/linkageReportHourlyManageGroupList";
    		
    	}else{
    		if("user".equals(reportSearchVO.getSelSearchType()))
    			return "report/linkageReportHourlyManageListExcel";
    		else if("group".equals(reportSearchVO.getSelSearchType()))
    			return "report/linkageReportHourlyManageGroupListExcel";
    	}
    	
    	return "report/linkageReportHourlyManageList";
    }
    
    
    /**
	 * 통화길이별통화통계(연동형).
	 */
    @RequestMapping("/report/linkageReportDurationManageMain.do")
    public String linkageReportManageDurationMainView(@ModelAttribute("reportSearchDurationVO") ReportSearchDurationVO reportSearchDurationVO, Model model, HttpSession session) throws Exception {
    
    	CmnPrivateVO cmnPrivateVO = new CmnPrivateVO();
    	
    	String[] privName = {
    			  messageSource.getMessage("message.db_new", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_save", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_group_select", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_group_tree", null, Locale.getDefault())
    			, messageSource.getMessage("message.db_excel", null, Locale.getDefault())
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
    	;
    	model.addAttribute("strPrivName", strPrivName);
    	model.addAttribute("listPrivate", listPrivate);
    	
    	return "report/linkageReportDurationManageMain";
    }
    
    /**
   	 * 통화길이별  콜통계(연동형) 초기화 리스트
   	 */
       @RequestMapping("/report/linkageReportDurationManageInitList.do")
       public String linkageReportDurationManageInitList(
       		HttpServletRequest request, @ModelAttribute("reportSearchVO") ReportSearchVO reportSearchVO, Model model, HttpSession session
               ) throws Exception {
       	ArrayList<EgovMap> newReportList = new ArrayList<EgovMap>();
       	model.addAttribute("reportList", newReportList);
       	return "report/linkageReportDurationManageList";
       }
    
	@RequestMapping(value={"/report/linkageReportDurationManageList.do", "/report/linkageReportDurationManageListExcel.do"})
    public String linkageReportManageDurationList(
    		HttpServletRequest request, @ModelAttribute("reportSearchDurationVO") ReportSearchDurationVO reportSearchDurationVO, Model model, HttpSession session
            ) throws Exception {
    	
		reportSearchDurationVO.setStrStartDate(reportSearchDurationVO.getStrStartDate().replaceAll("-", ""));
		reportSearchDurationVO.setSessionZirecxId(session.getAttribute("zirecx_id").toString());
		reportSearchDurationVO.setSessionGroupId(session.getAttribute("group_id").toString());
		reportSearchDurationVO.setAccessPolicy(request.getParameter("hidAccessPolicy"));
		
    	/** 통화길이별통화통계 리스트를 가져온다. */
		List reportList = linkageReportManageService.selectLinkageDurationReportList(reportSearchDurationVO);
		model.addAttribute("reportList", reportList);
		
    	/** 통화길이별통화통계 리스트의 합계를 계산한다. */
    	Map<String, Object> totCnt = new HashMap<String, Object>();
    	//합계를 저장 할 변수 초기화
    	int[] iSum = {0, 0, 0, 0, 0
    				, 0, 0, 0, 0, 0
    				, 0, 0};
    	
    	//합계 계산
    	for(int i=0; i<reportList.size(); i++) {
    		EgovMap tmpMap = (EgovMap)reportList.get(i);
			iSum[0] += Integer.parseInt(String.valueOf(tmpMap.get("tI")));
			iSum[1] += Integer.parseInt(String.valueOf(tmpMap.get("tO")));
			iSum[2] += Integer.parseInt(String.valueOf(tmpMap.get("less1I")));
			iSum[3] += Integer.parseInt(String.valueOf(tmpMap.get("less1O")));
			iSum[4] += Integer.parseInt(String.valueOf(tmpMap.get("less2I")));
			iSum[5] += Integer.parseInt(String.valueOf(tmpMap.get("less2O")));
			iSum[6] += Integer.parseInt(String.valueOf(tmpMap.get("less3I")));
			iSum[7] += Integer.parseInt(String.valueOf(tmpMap.get("less3O")));
			iSum[8] += Integer.parseInt(String.valueOf(tmpMap.get("less4I")));
			iSum[9] += Integer.parseInt(String.valueOf(tmpMap.get("less4O")));
			iSum[10] += Integer.parseInt(String.valueOf(tmpMap.get("less5I")));
			iSum[11] += Integer.parseInt(String.valueOf(tmpMap.get("less5O")));
    	}
    	
    	//합계를 model에 추가
    	totCnt.put("i0", iSum[0]);
    	totCnt.put("o0", iSum[1]);
    	totCnt.put("i1", iSum[2]);
    	totCnt.put("o1", iSum[3]);
    	totCnt.put("i2", iSum[4]);
    	totCnt.put("o2", iSum[5]);
    	totCnt.put("i3", iSum[6]);
    	totCnt.put("o3", iSum[7]);
    	totCnt.put("i4", iSum[8]);
    	totCnt.put("o4", iSum[9]);
    	totCnt.put("i5", iSum[10]);
    	totCnt.put("o5", iSum[11]);
    	
    	model.addAttribute("totCnt", totCnt);
    	
    	if(request.getRequestURI().indexOf("Excel") < 0){
    		if("user".equals(reportSearchDurationVO.getSelSearchType()))
    			return "report/linkageReportDurationManageList";
    		else if("group".equals(reportSearchDurationVO.getSelSearchType()))
    			return "report/linkageReportDurationManageGroupList";
    		else if("campaign".equals(reportSearchDurationVO.getSelSearchType()))
    			return "report/linkageReportDurationManageCampaignList";
    		
    	}else{
    		if("user".equals(reportSearchDurationVO.getSelSearchType()))
    			return "report/linkageReportDurationManageListExcel";
    		else if("group".equals(reportSearchDurationVO.getSelSearchType()))
    			return "report/linkageReportDurationManageGroupListExcel";
    		else if("campaign".equals(reportSearchDurationVO.getSelSearchType()))
    			return "report/linkageReportDurationManageCampaignListExcel";
    	}
    	
    	return "report/linkageReportDurationManageList";
    }
}
