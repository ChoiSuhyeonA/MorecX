package kr.co.irlink.zirecx.report.service.impl;

import java.util.List;

import kr.co.irlink.zirecx.report.service.ReportSearchDurationVO;
import kr.co.irlink.zirecx.report.service.ReportSearchVO;
import kr.co.irlink.zirecx.util.TextUtil;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Repository("linkageReportManageDAO")
public class LinkageReportManageDAO extends EgovAbstractDAO {
	/**
  	 * 콜통계 (연동형)
  	 */
    public List selectLinkageReportList(ReportSearchVO vo) throws Exception {
    	TextUtil textUtil = TextUtil.getInstance();
    	
    	String strGroupId = textUtil.validateParam(vo.getSchGroupId());
    	String strSessionZirecxId = textUtil.validateParam(vo.getSessionZirecxId());
    	String strSessionGroupId = textUtil.validateParam(vo.getSessionGroupId());
    	vo.setSchGroupId(strGroupId);
    	vo.setSessionZirecxId(strSessionZirecxId);
    	vo.setSessionGroupId(strSessionGroupId);
    	
    	String groupId = "";
    	if(!"".equals(strGroupId)){
    		groupId = strGroupId;
    	}else if(!"admin".equals(strSessionZirecxId)){
    		groupId = strSessionGroupId;
    	}
    	
    	String[] arrTmpGroupSeq = null;
    	List listGroupSeq = null;
    	if(!"".equals(groupId)){
    		vo.setArrGroupSeq(groupId.split(","));
        	listGroupSeq = list("linkageReportManageDAO.selectGroupList2", vo);
        	
        	arrTmpGroupSeq = new String[listGroupSeq.size() + 1];
        	arrTmpGroupSeq[0] = groupId;
        	for(int i=0; i<listGroupSeq.size(); i++) {
        		EgovMap tmpMap = (EgovMap)listGroupSeq.get(i);
        		arrTmpGroupSeq[i+1] = tmpMap.get("childGroupId").toString();
        	}
        	vo.setArrGroupSeq(arrTmpGroupSeq);
    	}
    	
    	if("user".equals(vo.getSelSearchType()))
    		return list("linkageReportManageDAO.selectLinkageReportUserList", vo);
    	else if("group".equals(vo.getSelSearchType()))
    		return list("linkageReportManageDAO.selectLinkageReportGroupList", vo);
    	
        return list("linkageReportManageDAO.selectLinkageReportUserList", vo);
    }
    
    /**
  	 * 시간대별 통계 (연동형)
  	 */
    public List selectLinkageHourlyReportList(ReportSearchVO vo) throws Exception {
    	TextUtil textUtil = TextUtil.getInstance();
    	
    	String strGroupId = textUtil.validateParam(vo.getSchGroupId());
    	String strSessionZirecxId = textUtil.validateParam(vo.getSessionZirecxId());
    	String strSessionGroupId = textUtil.validateParam(vo.getSessionGroupId());
    	vo.setSchGroupId(strGroupId);
    	vo.setSessionZirecxId(strSessionZirecxId);
    	vo.setSessionGroupId(strSessionGroupId);
    	
    	String groupId = "";
    	if(!"".equals(strGroupId)){
    		groupId = strGroupId;
    	}else if(!"admin".equals(strSessionZirecxId)){
    		groupId = strSessionGroupId;
    	}
    	
    	String[] arrTmpGroupSeq = null;
    	List listGroupSeq = null;
    	if(!"".equals(groupId)){
    		vo.setArrGroupSeq(groupId.split(","));
        	listGroupSeq = list("linkageReportManageDAO.selectGroupList2", vo);
        	
        	arrTmpGroupSeq = new String[listGroupSeq.size() + 1];
        	arrTmpGroupSeq[0] = groupId;
        	for(int i=0; i<listGroupSeq.size(); i++) {
        		EgovMap tmpMap = (EgovMap)listGroupSeq.get(i);
        		arrTmpGroupSeq[i+1] = tmpMap.get("childGroupId").toString();
        	}
        	vo.setArrGroupSeq(arrTmpGroupSeq);
    	}
    	
    	if("user".equals(vo.getSelSearchType()))
    		return list("linkageReportManageDAO.selectLinkageHourlyReportUserList", vo);
    	else if("group".equals(vo.getSelSearchType()))
    		return list("linkageReportManageDAO.selectLinkageHourlyReportGroupList", vo);
    	
        return list("linkageReportManageDAO.selectLinkageHourlyReportUserList", vo);
    }
    
    /**
  	 * 통화길이별 통계 (연동형)
  	 */
    public List selectLinkageDurationReportList(ReportSearchDurationVO vo) throws Exception {
    	TextUtil textUtil = TextUtil.getInstance();
    	
    	String strGroupId = textUtil.validateParam(vo.getSchGroupId());
    	String strSessionZirecxId = textUtil.validateParam(vo.getSessionZirecxId());
    	String strSessionGroupId = textUtil.validateParam(vo.getSessionGroupId());
    	vo.setSchGroupId(strGroupId);
    	vo.setSessionZirecxId(strSessionZirecxId);
    	vo.setSessionGroupId(strSessionGroupId);
    	
    	String groupId = "";
    	if(!"".equals(strGroupId)){
    		groupId = strGroupId;
    	}else if(!"admin".equals(strSessionZirecxId)){
    		groupId = strSessionGroupId;
    	}
    	
    	String[] arrTmpGroupSeq = null;
    	List listGroupSeq = null;
    	if(!"".equals(groupId)){
    		vo.setArrGroupSeq(groupId.split(","));
        	listGroupSeq = list("linkageReportManageDAO.selectGroupList", vo);
        	arrTmpGroupSeq = new String[listGroupSeq.size() + 1];
        	arrTmpGroupSeq[0] = groupId;
        	for(int i=0; i<listGroupSeq.size(); i++) {
        		EgovMap tmpMap = (EgovMap)listGroupSeq.get(i);
        		arrTmpGroupSeq[i+1] = tmpMap.get("childGroupId").toString();
        	}
        	vo.setArrGroupSeq(arrTmpGroupSeq);
    	}
    	
    	if("user".equals(vo.getSelSearchType())){
    		return list("linkageReportManageDAO.selecLinkagetDurationReportUserList", vo);
    	}else if("group".equals(vo.getSelSearchType())){
    		return list("linkageReportManageDAO.selectLinkageDurationReportGroupList", vo);
    	}else if("campaign".equals(vo.getSelSearchType())){
    		return list("linkageReportManageDAO.selectLinkageDurationReportCampaignList", vo);
    	}
    	
        return list("linkageReportManageDAO.selectLinkageDurationReportUserList", vo);
    }
    
    
}
