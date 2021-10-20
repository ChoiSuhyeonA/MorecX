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

public class GroupSearchVO implements Serializable {

	/** UID */
	private static final long serialVersionUID = -7775153012427142690L;

	
	private String schGroupName;
	
	private String schGroupId;
    
	 /** 검색조직명 */
    private String groupSearchName;
    
    /** 검색조직코드 */
    private String groupSearchSeq;
    
    /** 조직명 */
    private String groupName;
    
    /** 조직코드 */
    private String groupSeq;
    
    /** 상위조직 */
    private String parentGroupName;
    
    /** 조직depth */
    private String groupDepth;
    
    /** 상위조직코드 */
    private String parentGroupSeq;
    
    /** 삭제여부 */
    private String deleteYn;
    
    /** 회사코드 */
    private String officeCode;
    
    /** 조직코드 */
    private String groupCode;
    
    /** 상위조직 배열 */
    private String[] arrGroupSeq;
    
    /** 입력조직명 */
    private String inputGroupName;
    
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
    
    /** 정렬 키 */
	private String orderKey;
	
	/** 정렬 방식 */
	private String orderType;
	
	/** 조직 scope*/
    private String groupScope;
    
    private String licenseCnt;
    
    private String listenSupported;
    
    private String storagePeriod;
    
    private int id = 0;
    
    
    public String getListenSupported() {
		return listenSupported;
	}

	public void setListenSupported(String listenSupported) {
		this.listenSupported = listenSupported;
	}

	public String getStoragePeriod() {
		return storagePeriod;
	}

	public void setStoragePeriod(String storagePeriod) {
		this.storagePeriod = storagePeriod;
	}

	public String getLicenseCnt() {
		return licenseCnt;
	}

	public void setLicenseCnt(String string) {
		this.licenseCnt = string;
	}

	public String getGroupScope() {
		return groupScope;
	}

	public void setGroupScope(String groupScope) {
		this.groupScope = groupScope;
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

	public String[] getArrGroupSeq() {
		return arrGroupSeq;
	}

	public void setArrGroupSeq(String[] arrGroupSeq) {
		this.arrGroupSeq = arrGroupSeq;
	}

	public String getGroupSearchName() {
		return groupSearchName;
	}

	public void setGroupSearchName(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}

	public String getGroupSearchSeq() {
		return groupSearchSeq;
	}

	public void setGroupSearchSeq(String groupSearchSeq) {
		this.groupSearchSeq = groupSearchSeq;
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

	public String getParentGroupName() {
		return parentGroupName;
	}

	public void setParentGroupName(String parentGroupName) {
		this.parentGroupName = parentGroupName;
	}

	public String getInputGroupName() {
		return inputGroupName;
	}

	public void setInputGroupName(String inputGroupName) {
		this.inputGroupName = inputGroupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupSeq() {
		return groupSeq;
	}

	public void setGroupSeq(String groupSeq) {
		this.groupSeq = groupSeq;
	}

	public String getGroupDepth() {
		return groupDepth;
	}

	public void setGroupDepth(String groupDepth) {
		this.groupDepth = groupDepth;
	}

	public String getParentGroupSeq() {
		return parentGroupSeq;
	}

	public void setParentGroupSeq(String parentGroupSeq) {
		this.parentGroupSeq = parentGroupSeq;
	}

	/** admin 권한 추가 */
	private String auth;
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	// 센터관리 상세정보 변수 - 병우
	private String groupNameUpperDT;
	private String groupNameDT;
	private String deleteYnDT;
	private String groupSeqDT;
	private String groupSeqUpperDT;
	private String groupDepthDT;
	private String groupSortOrderDT;
	private String lastInsertID;

	public String getGroupNameUpperDT() {
		return groupNameUpperDT;
	}

	public void setGroupNameUpperDT(String groupNameUpperDT) {
		this.groupNameUpperDT = groupNameUpperDT;
	}

	public String getGroupNameDT() {
		return groupNameDT;
	}

	public void setGroupNameDT(String groupNameDT) {
		this.groupNameDT = groupNameDT;
	}

	public String getDeleteYnDT() {
		return deleteYnDT;
	}

	public void setDeleteYnDT(String deleteYnDT) {
		this.deleteYnDT = deleteYnDT;
	}

	public String getGroupSeqDT() {
		return groupSeqDT;
	}

	public void setGroupSeqDT(String groupSeqDT) {
		this.groupSeqDT = groupSeqDT;
	}

	public String getGroupSeqUpperDT() {
		return groupSeqUpperDT;
	}

	public void setGroupSeqUpperDT(String groupSeqUpperDT) {
		this.groupSeqUpperDT = groupSeqUpperDT;
	}

	public String getGroupDepthDT() {
		return groupDepthDT;
	}

	public void setGroupDepthDT(String groupDepthDT) {
		this.groupDepthDT = groupDepthDT;
	}

	public String getGroupSortOrderDT() {
		return groupSortOrderDT;
	}

	public void setGroupSortOrderDT(String groupSortOrderDT) {
		this.groupSortOrderDT = groupSortOrderDT;
	}

	public String getLastInsertID() {
		return lastInsertID;
	}

	public void setLastInsertID(String lastInsertID) {
		this.lastInsertID = lastInsertID;
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

	public String getNowpage() {
		return nowpage;
	}

	public void setNowpage(String nowpage) {
		this.nowpage = nowpage;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	
	//김해동 추가  테스트;;
	
	private String hidAccessPolicy;
	
	private String strSessionLoginString;
	
	private String strSessionGroupId;
	
	private String zirecxId;


	public String getHidAccessPolicy() {
		return hidAccessPolicy;
	}

	public void setHidAccessPolicy(String strAccessPolicy) {
		this.hidAccessPolicy = strAccessPolicy;
	}

	public String getStrSessionLoginString() {
		return strSessionLoginString;
	}

	public void setStrSessionLoginString(String strSessionLoginString) {
		this.strSessionLoginString = strSessionLoginString;
	}

	public String getStrSessionGroupId() {
		return strSessionGroupId;
	}

	public void setStrSessionGroupId(String strSessionGroupId) {
		this.strSessionGroupId = strSessionGroupId;
	}

	public String getZirecxId() {
		return zirecxId;
	}

	public void setZirecxId(String zirecxId) {
		this.zirecxId = zirecxId;
	}
	
}
