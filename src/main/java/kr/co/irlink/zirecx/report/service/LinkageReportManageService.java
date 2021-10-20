package kr.co.irlink.zirecx.report.service;

import java.util.List;

public interface LinkageReportManageService {
	/**
	 * 통화길이별통화통계 리스트 조회.
	 */
	List selectLinkageReportList(ReportSearchVO vo) throws Exception;
	
	/**
	 * 시간대별통화통계 리스트 조회.
	 */
	List selectLinkageHourlyReportList(ReportSearchVO vo) throws Exception;
	
	/**
	 * 통화길이별통화통계 리스트 조회.
	 */
	List selectLinkageDurationReportList(ReportSearchDurationVO vo) throws Exception;
}
