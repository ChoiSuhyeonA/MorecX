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
package kr.co.irlink.zirecx.common.service;

import java.io.Serializable;
import java.util.Arrays;

public class CmnGroupSearchVO implements Serializable {

	/** UID */
	private static final long serialVersionUID = -5434067191390672085L;

	/** 검색조직명 */
    private String groupSearchName;
    
    /** 검색조직코드 */
    private String groupSearchSeq;
    
    /** 조직명 */
    private String groupName;
    
    /** 조직코드 */
    private String groupId;
    
    /** 상위조직 */
    private String parentGroupName;
    
    /** 조직depth */
    private String groupDepth;
    
    /** 상위조직코드 */
    private String parentGroupSeq;
    
    /** 삭제여부 */
    private String deleteYn;
    
    /** 상위조직 배열 */
    private String[] arrGroupSeq;
    
    /** 입력조직명 */
    private String inputGroupName;
    
    /** 현재 사용자의 권한값  */
    private String strAccessPolicy;
    
    /** 현재 사용자 login_string  */
    private String strSessionLoginString;
    
    /** 현재 사용자 group_id  */
    private String strSessionGroupId;
    
    /** childGroupId */
    private String[] arrChildGroupId;
    
    private String searchType;
    private String searchText;
    
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
    private int groupCountPerPage = 10;
    
    /** 조직 scope*/
    private String groupScope;
    
    
    public String getGroupScope() {
		return groupScope;
	}

	public void setGroupScope(String groupScope) {
		this.groupScope = groupScope;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
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

	public int getGroupCountPerPage() {
		return groupCountPerPage;
	}

	public void setGroupCountPerPage(int groupCountPerPage) {
		this.groupCountPerPage = groupCountPerPage;
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

	

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
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

	public String getStrSessionGroupId() {
		return strSessionGroupId;
	}

	public void setStrSessionGroupId(String strSessionGroupId) {
		this.strSessionGroupId = strSessionGroupId;
	}

	public String[] getArrChildGroupId() {
		return arrChildGroupId;
	}

	public void setArrChildGroupId(String[] arrChildGroupId) {
		this.arrChildGroupId = arrChildGroupId;
	}


	/** admin 권한 추가 */
	private String auth;
	
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	
}