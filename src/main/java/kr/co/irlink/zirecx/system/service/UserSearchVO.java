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
package kr.co.irlink.zirecx.system.service;

import java.io.Serializable;
import java.util.Arrays;

public class UserSearchVO implements Serializable  {
	
	/** UID */
	private static final long serialVersionUID = 7764033057719401717L;
	
	/** 조직명 */
    private String schGroupName;
    /** 조직코드 */
    private String schGroupId;
    /** 사용자명 */
    private String schUserName;
    /** 사용자아이디 */
    private String schUserZirecxId;
    /** 사용자아이디 */
    private String schEndPointId;

	/** 조직명 */
    private String groupName;
	/** 조직코드 */
    private String groupId;
    /** 사용자명 */
    private String userName;
    /** 사용자코드 */
    private String userId;
    /** 사용자아이디 */
    private String zirecxId;
    
    private String deleteYn;
    
    private String recordYn;
   
	/** 상위조직 배열 */
    private String[] arrGroupSeq;
    
	/** 정렬 키 */
	private String orderKey;
	
	/** 정렬 방식 */
	private String orderType;
	
	/** 선택한 ZirecxId */
	private String detailZirecxId;
	
	/** 선택한 loginstring */
	private String detailLoginstring;

	/** 그래프표현방식 */
	private String searchType;
	
	private String logoutSupported;
	private String autoUploadSupported;
	
   
	/** 현재페이지 */
    private int pageIndex = 1;
    /** 페이지갯수 */
    private int pageUnit = 10;
    /** 페이지사이즈 */
    private int pageSize = 10;
    /** firstIndex */
    private int firstIndex = 1;
    /** lastIndex */
    private int lastIndex = 1;
    /** recordCountPerPage */
    private int countPerPage = 10;
    
    private String pagelist;

    private int maxPage;
    private String nowpage;
    
    /** admin 권한 추가 */
	private String auth;
	
	private String strSessionLoginString;
	
	private String strAccessPolicy;
	
	private String hidAccessPolicy;
	private String strSessionGroupId;
	
	private String rownum;
	
	private String strLoginUserAuth;
	
	public String getLogoutSupported() {
		return logoutSupported;
	}

	public void setLogoutSupported(String logoutSupported) {
		this.logoutSupported = logoutSupported;
	}

	public String getAutoUploadSupported() {
		return autoUploadSupported;
	}

	public void setAutoUploadSupported(String autoUploadSupported) {
		this.autoUploadSupported = autoUploadSupported;
	}

	public String getStrSessionGroupId() {
		return strSessionGroupId;
	}

	public void setStrSessionGroupId(String strSessionGroupId) {
		this.strSessionGroupId = strSessionGroupId;
	}

	public String getHidAccessPolicy() {
		return hidAccessPolicy;
	}

	public void setHidAccessPolicy(String hidAccessPolicy) {
		this.hidAccessPolicy = hidAccessPolicy;
	}

	public String getStrAccessPolicy() {
		return strAccessPolicy;
	}

	public void setStrAccessPolicy(String strAccessPolicy) {
		this.strAccessPolicy = strAccessPolicy;
	}

	public String getStrSessionLoginString() {
		return strSessionLoginString;
	}

	public void setStrSessionLoginString(String strSessionLoginString) {
		this.strSessionLoginString = strSessionLoginString;
	}

	public String getDetailZirecxId() {
		return detailZirecxId;
	}

	public void setDetailZirecxId(String detailZirecxId) {
		this.detailZirecxId = detailZirecxId;
	}

	public String getDetailLoginstring() {
		return detailLoginstring;
	}

	public void setDetailLoginstring(String detailLoginstring) {
		this.detailLoginstring = detailLoginstring;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
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
    public String getNowpage() {
		return nowpage;
	}

	public void setNowpage(String nowpage) {
		this.nowpage = nowpage;
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

	public String getSchUserName() {
		return schUserName;
	}

	public void setSchUserName(String schUserName) {
		this.schUserName = schUserName;
	}

	public String getSchUserZirecxId() {
		return schUserZirecxId;
	}

	public void setSchUserZirecxId(String schUserZirecxId) {
		this.schUserZirecxId = schUserZirecxId;
	}

	public String getSchEndPointId() {
		return schEndPointId;
	}

	public void setSchEndPointId(String schEndPointId) {
		this.schEndPointId = schEndPointId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getZirecxId() {
		return zirecxId;
	}

	public void setZirecxId(String zirecxId) {
		this.zirecxId = zirecxId;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public String getPagelist() {
		return pagelist;
	}

	public void setPagelist(String pagelist) {
		this.pagelist = pagelist;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	 public String[] getArrGroupSeq() {
		return arrGroupSeq;
	}

	public void setArrGroupSeq(String[] arrGroupSeq) {
		this.arrGroupSeq = arrGroupSeq;
	}
	
	 public String getRecordYn() {
		return recordYn;
	}

	public void setRecordYn(String recordYn) {
		this.recordYn = recordYn;
	}

	public String getRownum() {
		return rownum;
	}

	public void setRownum(String rownum) {
		this.rownum = rownum;
	}

	public String getStrLoginUserAuth() {
		return strLoginUserAuth;
	}

	public void setStrLoginUserAuth(String strLoginUserAuth) {
		this.strLoginUserAuth = strLoginUserAuth;
	}
	
}
