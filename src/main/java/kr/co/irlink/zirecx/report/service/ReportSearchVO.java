package kr.co.irlink.zirecx.report.service;

import java.io.Serializable;
import java.util.Arrays;

public class ReportSearchVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6180934950109306264L;

	/** 검색 시작일 */
	private String strStartDate;
	
	/** 검색 종료일 */
	private String strEndDate;
	
	/** 당일 날짜 */
	private String strToday;

	/** 센터명 */
	private String schGroupName;
	
	/** 센터코드 */
	private String schGroupId;

	/** 상위조직 배열 */
    private String[] arrGroupSeq;
    
	/** 퇴사자 포함(checkbox) */
	private String includeRetired;
	
	/** 실사용자만 표시(checkbox) */
	private String onlyRealUser;
	
	/** sesseion 의 zirecx_id */
	private String sessionZirecxId;
	
	/** sesseion 의 groupid */
	private String sessionGroupId;
	
	/** 조직선택 scope 값 */
	private String accessPolicy;
	
	/** 조회구분(상담원/조직/캠페인)  */
	private String selSearchType;
	
	/** 정렬 키 */
	private String orderKey;
	
	/** 정렬 방식 */
	private String orderType;
	
	/** 기존자료 조회 조건 체크 (시작일자가 종료일자보다 작거나 같을 경우. 단, 당일자료 포함 조회시에는 종료일자는 -1) */
	private String chkSql1;
	
	/** 당일자료 조회 조건 체크 (종료일자가 오늘날짜와 같을 경우) */
	private String chkSql2;
	

	public String getChkSql1() {
		return chkSql1;
	}

	public void setChkSql1(String chkSql1) {
		this.chkSql1 = chkSql1;
	}

	public String getChkSql2() {
		return chkSql2;
	}

	public void setChkSql2(String chkSql2) {
		this.chkSql2 = chkSql2;
	}

	public String getSelSearchType() {
		return selSearchType;
	}

	public void setSelSearchType(String selSearchType) {
		this.selSearchType = selSearchType;
	}
	
	public String getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String[] getArrGroupSeq() {
		return arrGroupSeq;
	}

	public void setArrGroupSeq(String[] arrGroupSeq) {
		this.arrGroupSeq = arrGroupSeq;
	}
	
	public String getSessionZirecxId() {
		return sessionZirecxId;
	}

	public void setSessionZirecxId(String sessionZirecxId) {
		this.sessionZirecxId = sessionZirecxId;
	}

	public String getSessionGroupId() {
		return sessionGroupId;
	}

	public void setSessionGroupId(String sessionGroupId) {
		this.sessionGroupId = sessionGroupId;
	}
	
	public String getAccessPolicy() {
		return accessPolicy;
	}

	public void setAccessPolicy(String accessPolicy) {
		this.accessPolicy = accessPolicy;
	}

	public String getStrStartDate() {
		return strStartDate;
	}

	public void setStrStartDate(String strStartDate) {
		this.strStartDate = strStartDate;
	}
	
	public String getStrEndDate() {
		return strEndDate;
	}

	public void setStrEndDate(String strEndDate) {
		this.strEndDate = strEndDate;
	}

	public String getStrToday() {
		return strToday;
	}

	public void setStrToday(String strToday) {
		this.strToday = strToday;
	}
	
	public String getIncludeRetired() {
		return includeRetired;
	}

	public void setIncludeRetired(String includeRetired) {
		this.includeRetired = includeRetired;
	}

	public String getOnlyRealUser() {
		return onlyRealUser;
	}

	public void setOnlyRealUser(String onlyRealUser) {
		this.onlyRealUser = onlyRealUser;
	}

	public String getSchGroupName() {
		return schGroupName;
	}

	public void setSchGroupName(String schGroupName) {
		this.schGroupName = schGroupName;
	}

	public String getSchGroupId() {
		return schGroupId;
	}

	public void setSchGroupId(String schGroupId) {
		this.schGroupId = schGroupId;
	}
}
