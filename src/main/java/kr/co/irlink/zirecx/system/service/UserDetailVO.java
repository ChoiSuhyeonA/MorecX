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

public class UserDetailVO implements Serializable  {
	/** UID */
	private static final long serialVersionUID = -5154649396837149984L;
	
	private String groupname;
	private String zirecxId;
	private String firstname;
	private String password;
	private String recordable;
	private String deleted;
	private String grpId;
	private String usrId;
	private String phonenumber;
	private String phonenumberOffice1;
	private String phonenumberOffice2;
	private String depth;
	private String sortOrder;
	private String useMonitoring;
	private String loginstring;
	private String userId;
	private String securityGroupName;
	private String changeZirecxIdYn;
	private String changeLoginstringYn;
	private String logoutSupported;
	private String autoUploadSupported;
	
	
	private int iDeleted;
	private int iRecordable;
	private int iUseMonitoring;
	private int iLogoutSupported;
	private int iAutoUploadSupported;
	
	private int id=0;
	
	public int getiLogoutSupported() {
		return iLogoutSupported;
	}
	public void setiLogoutSupported(int iLogoutSupported) {
		this.iLogoutSupported = iLogoutSupported;
	}
	public int getiAutoUploadSupported() {
		return iAutoUploadSupported;
	}
	public void setiAutoUploadSupported(int iAutoUploadSupported) {
		this.iAutoUploadSupported = iAutoUploadSupported;
	}
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
	
	public int getiDeleted() {
		return iDeleted;
	}
	public void setiDeleted(int iDeleted) {
		this.iDeleted = iDeleted;
	}
	public int getiRecordable() {
		return iRecordable;
	}
	public void setiRecordable(int iRecordable) {
		this.iRecordable = iRecordable;
	}
	public int getiUseMonitoring() {
		return iUseMonitoring;
	}
	public void setiUseMonitoring(int iUseMonitoring) {
		this.iUseMonitoring = iUseMonitoring;
	}
		
	public String getChangeZirecxIdYn() {
		return changeZirecxIdYn;
	}
	public void setChangeZirecxIdYn(String changeZirecxIdYn) {
		this.changeZirecxIdYn = changeZirecxIdYn;
	}
	public String getChangeLoginstringYn() {
		return changeLoginstringYn;
	}
	public void setChangeLoginstringYn(String changeLoginstringYn) {
		this.changeLoginstringYn = changeLoginstringYn;
	}	
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getZirecxId() {
		return zirecxId;
	}
	public void setZirecxId(String zirecxId) {
		this.zirecxId = zirecxId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRecordable() {
		return recordable;
	}
	public void setRecordable(String recordable) {
		this.recordable = recordable;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getGrpId() {
		return grpId;
	}
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getUseMonitoring() {
		return useMonitoring;
	}
	public void setUseMonitoring(String useMonitoring) {
		this.useMonitoring = useMonitoring;
	}
	public String getLoginstring() {
		return loginstring;
	}
	public void setLoginstring(String loginstring) {
		this.loginstring = loginstring;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSecurityGroupName() {
		return securityGroupName;
	}
	public void setSecurityGroupName(String securityGroupName) {
		this.securityGroupName = securityGroupName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhonenumberOffice1() {
		return phonenumberOffice1;
	}
	public void setPhonenumberOffice1(String phonenumberOffice1) {
		this.phonenumberOffice1 = phonenumberOffice1;
	}
	public String getPhonenumberOffice2() {
		return phonenumberOffice2;
	}
	public void setPhonenumberOffice2(String phonenumberOffice2) {
		this.phonenumberOffice2 = phonenumberOffice2;
	}
	
}
