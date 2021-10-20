package kr.co.irlink.zirecx.report.service.impl;

import java.util.List;

import javax.annotation.Resource;

import kr.co.irlink.zirecx.report.service.LinkageReportManageService;
import kr.co.irlink.zirecx.report.service.ReportSearchDurationVO;
import kr.co.irlink.zirecx.report.service.impl.LinkageReportManageDAO;
import kr.co.irlink.zirecx.report.service.ReportSearchVO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("linkageReportManageService")
public class LinkageReportManageServiceImple  extends AbstractServiceImpl implements
		LinkageReportManageService {
	/** LinkageReportManageDAO */
	@Resource(name="linkageReportManageDAO")
	private LinkageReportManageDAO linkageReportManageDAO;
	
	/**
	* 콜통계 (연동형)
	*/
	public List selectLinkageReportList(ReportSearchVO vo) throws Exception{
		List reportList = linkageReportManageDAO.selectLinkageReportList(vo);
		if (reportList == null)
		    throw processException("info.nodata.msg");
		return reportList;
	}
	
	/**
	 * 시간대별 통계 (연동형)
	 */
	public List selectLinkageHourlyReportList(ReportSearchVO vo) throws Exception{
		List reportList = linkageReportManageDAO.selectLinkageHourlyReportList(vo);
        if (reportList == null)
            throw processException("info.nodata.msg");
        return reportList;
	}
	
	/**
	 * 통화길이별 통계 (연동형)
	 */
	public List selectLinkageDurationReportList(ReportSearchDurationVO vo) throws Exception{
		List reportList = linkageReportManageDAO.selectLinkageDurationReportList(vo);
        if (reportList == null)
            throw processException("info.nodata.msg");
        return reportList;
	}
}
