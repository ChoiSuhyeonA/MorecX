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
package kr.co.irlink.zirecx.zigate.service;

import java.io.Serializable;

public class ZigateVO implements Serializable {
	
	private static final long serialVersionUID = -5713181628704249214L;
	
	//allCallInfoInsert, allCallInfoUpdate
	String REC_ID = "";
	String SIP_CALL_ID = "";
	String END_POINT = "";
	String USER_ID = "";
	String PHONE_NUMBER = "";
	String PHONE_CODE = "";
	String CALL_START_DATE = "";
	String CALL_START_TIME = "";
	String CALL_CONNECT_TIME = "";
	String CALL_END_DATE = "";
	String CALL_END_TIME = "";
	String REC_START_TIME_PC = "";
	String REC_START_TIME_MEMORY = "";
	String REC_START_TIME_MEM = "";
	String REC_END_TIME_PC = "";
	String REC_END_TIME_MEMORY = "";
	String REC_END_TIME_MEM = "";
	String UPLOAD_DATE_PC = "";
	String UPLOAD_TIME_PC = "";
	String UPLOAD_DATE_MEMORY = "";
	String UPLOAD_TIME_MEMORY = "";
	String UPLOAD_DATE_MEM = "";
	String UPLOAD_TIME_MEM = "";
	String WRAPUP_DATE = "";
	String WRAPUP_TIME = "";
	String CUSTOMER_ID = "";
	String CUSTOMER_NAME = "";
	String SOCIAL_ID = "";
	String CAMPAIGN_ID = "";
	String CAMPAIGN_UNIQUE_CODE = "";
	String CALL_RELATION_CODE = "";
	String CALL_OUTCOME_CODE_MASTER = "";
	String CALL_OUTCOME_CODE = "";
	String CALL_OUTCOME_MASTER = "";
	String CALL_OUTCOME = "";
	String CALL_MEMO = "";
	String INOUTBOUND_CODE = "";
	String CALL_CODE = "";
	String PARTNERBY_FLAG = "";
	String REC_SUCCESS_CODE_PC = "";
	String UPLOAD_SUCCESS_CODE_PC = "";
	String REC_SUCCESS_CODE_MEMORY = "";
	String UPLOAD_SUCCESS_CODE_MEMORY = "";
	String REC_PATH_PC = "";
	String REC_FILENAME_PC = "";
	String REC_PATH_MEMORY = "";
	String REC_FILENAME_MEMORY = "";
	String REC_PATH_REMOTE_PC = "";
	String REC_FILENAME_REMOTE_PC = "";
	String REC_PATH_REMOTE_MEMORY = "";
	String REC_FILENAME_REMOTE_MEMORY = "";
	String SYSTEM_ID = "";
	String PROCESS_STATUS = "";
	String CARD_NO = "";
	String CARD_EXPIRE_DATE = "";
	String FACE_TO_FACE = "";
	String VISIT_PLACE = "";
	String VISIT_DATE = "";
	String VISIT_DATE_CLASS = "";
	String RECORD_MODE_CODE = "";

	
	String DURATION_RING = "0";
	String DURATION_TALK = "0";
	String DURATION_CALL = "0";
	String DURATION_WRAPUP;
	
	String CUSTOMER_UNIQUE_CODE = "";
	String CAMPAIGN_NAME = "";
	String ACCIDENT_ID = "";
	String RECORD_SUCCESS_CODE_PC = "";
	String RECORD_SUCCESS_CODE_MEMORY = "";
	String RECORD_PATH_PC = "";
	String RECORD_FILENAME_PC = "";
	String RECORD_PATH_FAIL_MEMORY = "";
	String RECORD_FILENAME_MEMORY = "";
	String RECORD_PATH_REMOTE_PC = "";
	String RECORD_FILENAME_REMOTE_PC = "";
	String RECORD_PATH_REMOTE_MEMORY = "";
	String RECORD_FILENAME_REMOTE_MEMORY = "";
	
	String ZIRECXID = "";
	
	String REC_SUCCESS_CODE_MEM = "";
	String UPLOAD_SUCCESS_CODE_MEM = "";
	String REC_PATH_MEM = "";
	String REC_FILENAME_MEM = "";
	String REC_PATH_REMOTE_MEM = "";
	String REC_FILENAME_REMOTE_MEM = "";
	
	String USER_PHONE_NUMBER = "";
	String USER_PHONE_NUMBER_GUBUN = "";
	
	String GROUP_NAME = "";
	
	//getInitInfo
	String firstname;
	String groupName;
	String groupCode;
	String uploadType;
	String httpAddress;
	String httpUserId;
	String httpPassword;
	String httpPort;
	String httpMode;
	String ftpAddress;
	String ftpUserId;
	String ftpPassword;
	String ftpPort;
	String ftpMode;
	String httpPage;
	String httpCharaterset;
	String storageDate;
	String deleted;
	String loginstring;
	String sipAddress;
	String sipDomain;
	String autoSaveTime;
	
	//getLogin
	int id = 0;
	String ID = "";
	String USER_PW = "";
	String CENTER_NAME = "";
	String LISTEN_INFO_REQ = "";
	String APP_VER = "";
	String OS_VER = "";
	String IMEI = "";
	String MODEL_NO = "";
	String logoutsupported = "";
	String autouploadsupported = "";
	String listenSupported = "";
	String storagePeriod = "";
	String resetPasswordFlag = "";
	String password = "";
	String salt = "";
	String USER_STATUS = "";
	
	//getTime
	String DB_DATE = "";
	String DB_TIME = "";
	
	//getVersion
	String ver = "";
	String market = "";
	
	public String getREC_ID() {
		return REC_ID;
	}
	public void setREC_ID(String rEC_ID) {
		REC_ID = rEC_ID;
	}
	public String getSIP_CALL_ID() {
		return SIP_CALL_ID;
	}
	public void setSIP_CALL_ID(String sIP_CALL_ID) {
		SIP_CALL_ID = sIP_CALL_ID;
	}
	public String getEND_POINT() {
		return END_POINT;
	}
	public void setEND_POINT(String eND_POINT) {
		END_POINT = eND_POINT;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}
	public void setPHONE_NUMBER(String pHONE_NUMBER) {
		PHONE_NUMBER = pHONE_NUMBER;
	}
	public String getPHONE_CODE() {
		return PHONE_CODE;
	}
	public void setPHONE_CODE(String pHONE_CODE) {
		PHONE_CODE = pHONE_CODE;
	}
	public String getCALL_START_DATE() {
		return CALL_START_DATE;
	}
	public void setCALL_START_DATE(String cALL_START_DATE) {
		CALL_START_DATE = cALL_START_DATE;
	}
	public String getCALL_START_TIME() {
		return CALL_START_TIME;
	}
	public void setCALL_START_TIME(String cALL_START_TIME) {
		CALL_START_TIME = cALL_START_TIME;
	}
	public String getCALL_CONNECT_TIME() {
		return CALL_CONNECT_TIME;
	}
	public void setCALL_CONNECT_TIME(String cALL_CONNECT_TIME) {
		CALL_CONNECT_TIME = cALL_CONNECT_TIME;
	}
	public String getCALL_END_DATE() {
		return CALL_END_DATE;
	}
	public void setCALL_END_DATE(String cALL_END_DATE) {
		CALL_END_DATE = cALL_END_DATE;
	}
	public String getCALL_END_TIME() {
		return CALL_END_TIME;
	}
	public void setCALL_END_TIME(String cALL_END_TIME) {
		CALL_END_TIME = cALL_END_TIME;
	}
	public String getREC_START_TIME_PC() {
		return REC_START_TIME_PC;
	}
	public void setREC_START_TIME_PC(String rEC_START_TIME_PC) {
		REC_START_TIME_PC = rEC_START_TIME_PC;
	}
	public String getREC_START_TIME_MEMORY() {
		return REC_START_TIME_MEMORY;
	}
	public void setREC_START_TIME_MEMORY(String rEC_START_TIME_MEMORY) {
		REC_START_TIME_MEMORY = rEC_START_TIME_MEMORY;
	}
	public String getREC_END_TIME_PC() {
		return REC_END_TIME_PC;
	}
	public void setREC_END_TIME_PC(String rEC_END_TIME_PC) {
		REC_END_TIME_PC = rEC_END_TIME_PC;
	}
	public String getREC_END_TIME_MEMORY() {
		return REC_END_TIME_MEMORY;
	}
	public void setREC_END_TIME_MEMORY(String rEC_END_TIME_MEMORY) {
		REC_END_TIME_MEMORY = rEC_END_TIME_MEMORY;
	}
	public String getUPLOAD_DATE_PC() {
		return UPLOAD_DATE_PC;
	}
	public void setUPLOAD_DATE_PC(String uPLOAD_DATE_PC) {
		UPLOAD_DATE_PC = uPLOAD_DATE_PC;
	}
	public String getUPLOAD_TIME_PC() {
		return UPLOAD_TIME_PC;
	}
	public void setUPLOAD_TIME_PC(String uPLOAD_TIME_PC) {
		UPLOAD_TIME_PC = uPLOAD_TIME_PC;
	}
	public String getUPLOAD_DATE_MEMORY() {
		return UPLOAD_DATE_MEMORY;
	}
	public void setUPLOAD_DATE_MEMORY(String uPLOAD_DATE_MEMORY) {
		UPLOAD_DATE_MEMORY = uPLOAD_DATE_MEMORY;
	}
	public String getUPLOAD_TIME_MEMORY() {
		return UPLOAD_TIME_MEMORY;
	}
	public void setUPLOAD_TIME_MEMORY(String uPLOAD_TIME_MEMORY) {
		UPLOAD_TIME_MEMORY = uPLOAD_TIME_MEMORY;
	}
	public String getWRAPUP_DATE() {
		return WRAPUP_DATE;
	}
	public void setWRAPUP_DATE(String wRAPUP_DATE) {
		WRAPUP_DATE = wRAPUP_DATE;
	}
	public String getWRAPUP_TIME() {
		return WRAPUP_TIME;
	}
	public void setWRAPUP_TIME(String wRAPUP_TIME) {
		WRAPUP_TIME = wRAPUP_TIME;
	}
	public String getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}
	public void setCUSTOMER_ID(String cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}
	public String getCUSTOMER_NAME() {
		return CUSTOMER_NAME;
	}
	public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
		CUSTOMER_NAME = cUSTOMER_NAME;
	}
	public String getSOCIAL_ID() {
		return SOCIAL_ID;
	}
	public void setSOCIAL_ID(String sOCIAL_ID) {
		SOCIAL_ID = sOCIAL_ID;
	}
	public String getCAMPAIGN_ID() {
		return CAMPAIGN_ID;
	}
	public void setCAMPAIGN_ID(String cAMPAIGN_ID) {
		CAMPAIGN_ID = cAMPAIGN_ID;
	}
	public String getCALL_RELATION_CODE() {
		return CALL_RELATION_CODE;
	}
	public void setCALL_RELATION_CODE(String cALL_RELATION_CODE) {
		CALL_RELATION_CODE = cALL_RELATION_CODE;
	}
	public String getCALL_OUTCOME_CODE_MASTER() {
		return CALL_OUTCOME_CODE_MASTER;
	}
	public void setCALL_OUTCOME_CODE_MASTER(String cALL_OUTCOME_CODE_MASTER) {
		CALL_OUTCOME_CODE_MASTER = cALL_OUTCOME_CODE_MASTER;
	}
	public String getCALL_OUTCOME_CODE() {
		return CALL_OUTCOME_CODE;
	}
	public void setCALL_OUTCOME_CODE(String cALL_OUTCOME_CODE) {
		CALL_OUTCOME_CODE = cALL_OUTCOME_CODE;
	}
	public String getCALL_OUTCOME_MASTER() {
		return CALL_OUTCOME_MASTER;
	}
	public void setCALL_OUTCOME_MASTER(String cALL_OUTCOME_MASTER) {
		CALL_OUTCOME_MASTER = cALL_OUTCOME_MASTER;
	}
	public String getCALL_OUTCOME() {
		return CALL_OUTCOME;
	}
	public void setCALL_OUTCOME(String cALL_OUTCOME) {
		CALL_OUTCOME = cALL_OUTCOME;
	}
	public String getCALL_MEMO() {
		return CALL_MEMO;
	}
	public void setCALL_MEMO(String cALL_MEMO) {
		CALL_MEMO = cALL_MEMO;
	}
	public String getINOUTBOUND_CODE() {
		return INOUTBOUND_CODE;
	}
	public void setINOUTBOUND_CODE(String iNOUTBOUND_CODE) {
		INOUTBOUND_CODE = iNOUTBOUND_CODE;
	}
	public String getCALL_CODE() {
		return CALL_CODE;
	}
	public void setCALL_CODE(String cALL_CODE) {
		CALL_CODE = cALL_CODE;
	}
	public String getPARTNERBY_FLAG() {
		return PARTNERBY_FLAG;
	}
	public void setPARTNERBY_FLAG(String pARTNERBY_FLAG) {
		PARTNERBY_FLAG = pARTNERBY_FLAG;
	}
	public String getREC_SUCCESS_CODE_PC() {
		return REC_SUCCESS_CODE_PC;
	}
	public void setREC_SUCCESS_CODE_PC(String rEC_SUCCESS_CODE_PC) {
		REC_SUCCESS_CODE_PC = rEC_SUCCESS_CODE_PC;
	}
	public String getUPLOAD_SUCCESS_CODE_PC() {
		return UPLOAD_SUCCESS_CODE_PC;
	}
	public void setUPLOAD_SUCCESS_CODE_PC(String uPLOAD_SUCCESS_CODE_PC) {
		UPLOAD_SUCCESS_CODE_PC = uPLOAD_SUCCESS_CODE_PC;
	}
	public String getREC_SUCCESS_CODE_MEMORY() {
		return REC_SUCCESS_CODE_MEMORY;
	}
	public void setREC_SUCCESS_CODE_MEMORY(String rEC_SUCCESS_CODE_MEMORY) {
		REC_SUCCESS_CODE_MEMORY = rEC_SUCCESS_CODE_MEMORY;
	}
	public String getUPLOAD_SUCCESS_CODE_MEMORY() {
		return UPLOAD_SUCCESS_CODE_MEMORY;
	}
	public void setUPLOAD_SUCCESS_CODE_MEMORY(String uPLOAD_SUCCESS_CODE_MEMORY) {
		UPLOAD_SUCCESS_CODE_MEMORY = uPLOAD_SUCCESS_CODE_MEMORY;
	}
	public String getREC_PATH_PC() {
		return REC_PATH_PC;
	}
	public void setREC_PATH_PC(String rEC_PATH_PC) {
		REC_PATH_PC = rEC_PATH_PC;
	}
	public String getREC_FILENAME_PC() {
		return REC_FILENAME_PC;
	}
	public void setREC_FILENAME_PC(String rEC_FILENAME_PC) {
		REC_FILENAME_PC = rEC_FILENAME_PC;
	}
	public String getREC_PATH_MEMORY() {
		return REC_PATH_MEMORY;
	}
	public void setREC_PATH_MEMORY(String rEC_PATH_MEMORY) {
		REC_PATH_MEMORY = rEC_PATH_MEMORY;
	}
	public String getREC_FILENAME_MEMORY() {
		return REC_FILENAME_MEMORY;
	}
	public void setREC_FILENAME_MEMORY(String rEC_FILENAME_MEMORY) {
		REC_FILENAME_MEMORY = rEC_FILENAME_MEMORY;
	}
	public String getREC_PATH_REMOTE_PC() {
		return REC_PATH_REMOTE_PC;
	}
	public void setREC_PATH_REMOTE_PC(String rEC_PATH_REMOTE_PC) {
		REC_PATH_REMOTE_PC = rEC_PATH_REMOTE_PC;
	}
	public String getREC_FILENAME_REMOTE_PC() {
		return REC_FILENAME_REMOTE_PC;
	}
	public void setREC_FILENAME_REMOTE_PC(String rEC_FILENAME_REMOTE_PC) {
		REC_FILENAME_REMOTE_PC = rEC_FILENAME_REMOTE_PC;
	}
	public String getREC_PATH_REMOTE_MEMORY() {
		return REC_PATH_REMOTE_MEMORY;
	}
	public void setREC_PATH_REMOTE_MEMORY(String rEC_PATH_REMOTE_MEMORY) {
		REC_PATH_REMOTE_MEMORY = rEC_PATH_REMOTE_MEMORY;
	}
	public String getREC_FILENAME_REMOTE_MEMORY() {
		return REC_FILENAME_REMOTE_MEMORY;
	}
	public void setREC_FILENAME_REMOTE_MEMORY(String rEC_FILENAME_REMOTE_MEMORY) {
		REC_FILENAME_REMOTE_MEMORY = rEC_FILENAME_REMOTE_MEMORY;
	}
	public String getSYSTEM_ID() {
		return SYSTEM_ID;
	}
	public void setSYSTEM_ID(String sYSTEM_ID) {
		SYSTEM_ID = sYSTEM_ID;
	}
	public String getPROCESS_STATUS() {
		return PROCESS_STATUS;
	}
	public void setPROCESS_STATUS(String pROCESS_STATUS) {
		PROCESS_STATUS = pROCESS_STATUS;
	}
	public String getCARD_NO() {
		return CARD_NO;
	}
	public void setCARD_NO(String cARD_NO) {
		CARD_NO = cARD_NO;
	}
	public String getCARD_EXPIRE_DATE() {
		return CARD_EXPIRE_DATE;
	}
	public void setCARD_EXPIRE_DATE(String cARD_EXPIRE_DATE) {
		CARD_EXPIRE_DATE = cARD_EXPIRE_DATE;
	}
	public String getDURATION_RING() {
		return DURATION_RING;
	}
	public void setDURATION_RING(String dURATION_RING) {
		DURATION_RING = dURATION_RING;
	}
	public String getDURATION_TALK() {
		return DURATION_TALK;
	}
	public void setDURATION_TALK(String dURATION_TALK) {
		DURATION_TALK = dURATION_TALK;
	}
	public String getDURATION_CALL() {
		return DURATION_CALL;
	}
	public void setDURATION_CALL(String dURATION_CALL) {
		DURATION_CALL = dURATION_CALL;
	}
	public String getDURATION_WRAPUP() {
		return DURATION_WRAPUP;
	}
	public void setDURATION_WRAPUP(String dURATION_WRAPUP) {
		DURATION_WRAPUP = dURATION_WRAPUP;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getUploadType() {
		return uploadType;
	}
	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}
	public String getHttpAddress() {
		return httpAddress;
	}
	public void setHttpAddress(String httpAddress) {
		this.httpAddress = httpAddress;
	}
	public String getHttpUserId() {
		return httpUserId;
	}
	public void setHttpUserId(String httpUserId) {
		this.httpUserId = httpUserId;
	}
	public String getHttpPassword() {
		return httpPassword;
	}
	public void setHttpPassword(String httpPassword) {
		this.httpPassword = httpPassword;
	}
	public String getHttpPort() {
		return httpPort;
	}
	public void setHttpPort(String httpPort) {
		this.httpPort = httpPort;
	}
	public String getHttpMode() {
		return httpMode;
	}
	public void setHttpMode(String httpMode) {
		this.httpMode = httpMode;
	}
	public String getFtpAddress() {
		return ftpAddress;
	}
	public void setFtpAddress(String ftpAddress) {
		this.ftpAddress = ftpAddress;
	}
	public String getFtpUserId() {
		return ftpUserId;
	}
	public void setFtpUserId(String ftpUserId) {
		this.ftpUserId = ftpUserId;
	}
	public String getFtpPassword() {
		return ftpPassword;
	}
	public void setFtpPassword(String ftpPassword) {
		this.ftpPassword = ftpPassword;
	}
	public String getFtpPort() {
		return ftpPort;
	}
	public void setFtpPort(String ftpPort) {
		this.ftpPort = ftpPort;
	}
	public String getFtpMode() {
		return ftpMode;
	}
	public void setFtpMode(String ftpMode) {
		this.ftpMode = ftpMode;
	}
	public String getHttpPage() {
		return httpPage;
	}
	public void setHttpPage(String httpPage) {
		this.httpPage = httpPage;
	}
	public String getHttpCharaterset() {
		return httpCharaterset;
	}
	public void setHttpCharaterset(String httpCharaterset) {
		this.httpCharaterset = httpCharaterset;
	}
	public String getStorageDate() {
		return storageDate;
	}
	public void setStorageDate(String storageDate) {
		this.storageDate = storageDate;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getLoginstring() {
		return loginstring;
	}
	public void setLoginstring(String loginstring) {
		this.loginstring = loginstring;
	}
	public String getSipAddress() {
		return sipAddress;
	}
	public void setSipAddress(String sipAddress) {
		this.sipAddress = sipAddress;
	}
	public String getSipDomain() {
		return sipDomain;
	}
	public void setSipDomain(String sipDomain) {
		this.sipDomain = sipDomain;
	}
	public String getAutoSaveTime() {
		return autoSaveTime;
	}
	public void setAutoSaveTime(String autoSaveTime) {
		this.autoSaveTime = autoSaveTime;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getUSER_PW() {
		return USER_PW;
	}
	public void setUSER_PW(String uSER_PW) {
		USER_PW = uSER_PW;
	}
	public String getCENTER_NAME() {
		return CENTER_NAME;
	}
	public void setCENTER_NAME(String cENTER_NAME) {
		CENTER_NAME = cENTER_NAME;
	}
	public String getLISTEN_INFO_REQ() {
		return LISTEN_INFO_REQ;
	}
	public void setLISTEN_INFO_REQ(String lISTEN_INFO_REQ) {
		LISTEN_INFO_REQ = lISTEN_INFO_REQ;
	}
	public String getAPP_VER() {
		return APP_VER;
	}
	public void setAPP_VER(String aPP_VER) {
		APP_VER = aPP_VER;
	}
	public String getOS_VER() {
		return OS_VER;
	}
	public void setOS_VER(String oS_VER) {
		OS_VER = oS_VER;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getMODEL_NO() {
		return MODEL_NO;
	}
	public void setMODEL_NO(String mODEL_NO) {
		MODEL_NO = mODEL_NO;
	}
	public String getLogoutsupported() {
		return logoutsupported;
	}
	public void setLogoutsupported(String logoutsupported) {
		this.logoutsupported = logoutsupported;
	}
	public String getAutouploadsupported() {
		return autouploadsupported;
	}
	public void setAutouploadsupported(String autouploadsupported) {
		this.autouploadsupported = autouploadsupported;
	}
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
	public String getDB_DATE() {
		return DB_DATE;
	}
	public void setDB_DATE(String dB_DATE) {
		DB_DATE = dB_DATE;
	}
	public String getDB_TIME() {
		return DB_TIME;
	}
	public void setDB_TIME(String dB_TIME) {
		DB_TIME = dB_TIME;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getCUSTOMER_UNIQUE_CODE() {
		return CUSTOMER_UNIQUE_CODE;
	}
	public void setCUSTOMER_UNIQUE_CODE(String cUSTOMER_UNIQUE_CODE) {
		CUSTOMER_UNIQUE_CODE = cUSTOMER_UNIQUE_CODE;
	}
	public String getCAMPAIGN_UNIQUE_CODE() {
		return CAMPAIGN_UNIQUE_CODE;
	}
	public void setCAMPAIGN_UNIQUE_CODE(String cAMPAIGN_UNIQUE_CODE) {
		CAMPAIGN_UNIQUE_CODE = cAMPAIGN_UNIQUE_CODE;
	}
	public String getCAMPAIGN_NAME() {
		return CAMPAIGN_NAME;
	}
	public void setCAMPAIGN_NAME(String cAMPAIGN_NAME) {
		CAMPAIGN_NAME = cAMPAIGN_NAME;
	}
	public String getACCIDENT_ID() {
		return ACCIDENT_ID;
	}
	public void setACCIDENT_ID(String aCCIDENT_ID) {
		ACCIDENT_ID = aCCIDENT_ID;
	}
	public String getRECORD_SUCCESS_CODE_PC() {
		return RECORD_SUCCESS_CODE_PC;
	}
	public void setRECORD_SUCCESS_CODE_PC(String rECORD_SUCCESS_CODE_PC) {
		RECORD_SUCCESS_CODE_PC = rECORD_SUCCESS_CODE_PC;
	}
	public String getRECORD_SUCCESS_CODE_MEMORY() {
		return RECORD_SUCCESS_CODE_MEMORY;
	}
	public void setRECORD_SUCCESS_CODE_MEMORY(String rECORD_SUCCESS_CODE_MEMORY) {
		RECORD_SUCCESS_CODE_MEMORY = rECORD_SUCCESS_CODE_MEMORY;
	}
	public String getRECORD_PATH_PC() {
		return RECORD_PATH_PC;
	}
	public void setRECORD_PATH_PC(String rECORD_PATH_PC) {
		RECORD_PATH_PC = rECORD_PATH_PC;
	}
	public String getRECORD_FILENAME_PC() {
		return RECORD_FILENAME_PC;
	}
	public void setRECORD_FILENAME_PC(String rECORD_FILENAME_PC) {
		RECORD_FILENAME_PC = rECORD_FILENAME_PC;
	}
	public String getRECORD_PATH_FAIL_MEMORY() {
		return RECORD_PATH_FAIL_MEMORY;
	}
	public void setRECORD_PATH_FAIL_MEMORY(String rECORD_PATH_FAIL_MEMORY) {
		RECORD_PATH_FAIL_MEMORY = rECORD_PATH_FAIL_MEMORY;
	}
	public String getRECORD_FILENAME_MEMORY() {
		return RECORD_FILENAME_MEMORY;
	}
	public void setRECORD_FILENAME_MEMORY(String rECORD_FILENAME_MEMORY) {
		RECORD_FILENAME_MEMORY = rECORD_FILENAME_MEMORY;
	}
	public String getRECORD_PATH_REMOTE_PC() {
		return RECORD_PATH_REMOTE_PC;
	}
	public void setRECORD_PATH_REMOTE_PC(String rECORD_PATH_REMOTE_PC) {
		RECORD_PATH_REMOTE_PC = rECORD_PATH_REMOTE_PC;
	}
	public String getRECORD_FILENAME_REMOTE_PC() {
		return RECORD_FILENAME_REMOTE_PC;
	}
	public void setRECORD_FILENAME_REMOTE_PC(String rECORD_FILENAME_REMOTE_PC) {
		RECORD_FILENAME_REMOTE_PC = rECORD_FILENAME_REMOTE_PC;
	}
	public String getRECORD_PATH_REMOTE_MEMORY() {
		return RECORD_PATH_REMOTE_MEMORY;
	}
	public void setRECORD_PATH_REMOTE_MEMORY(String rECORD_PATH_REMOTE_MEMORY) {
		RECORD_PATH_REMOTE_MEMORY = rECORD_PATH_REMOTE_MEMORY;
	}
	public String getRECORD_FILENAME_REMOTE_MEMORY() {
		return RECORD_FILENAME_REMOTE_MEMORY;
	}
	public void setRECORD_FILENAME_REMOTE_MEMORY(
			String rECORD_FILENAME_REMOTE_MEMORY) {
		RECORD_FILENAME_REMOTE_MEMORY = rECORD_FILENAME_REMOTE_MEMORY;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZIRECXID() {
		return ZIRECXID;
	}
	public void setZIRECXID(String zIRECXID) {
		ZIRECXID = zIRECXID;
	}
	public String getREC_START_TIME_MEM() {
		return REC_START_TIME_MEM;
	}
	public void setREC_START_TIME_MEM(String rEC_START_TIME_MEM) {
		REC_START_TIME_MEM = rEC_START_TIME_MEM;
	}
	public String getREC_END_TIME_MEM() {
		return REC_END_TIME_MEM;
	}
	public void setREC_END_TIME_MEM(String rEC_END_TIME_MEM) {
		REC_END_TIME_MEM = rEC_END_TIME_MEM;
	}
	public String getUPLOAD_DATE_MEM() {
		return UPLOAD_DATE_MEM;
	}
	public void setUPLOAD_DATE_MEM(String uPLOAD_DATE_MEM) {
		UPLOAD_DATE_MEM = uPLOAD_DATE_MEM;
	}
	public String getUPLOAD_TIME_MEM() {
		return UPLOAD_TIME_MEM;
	}
	public void setUPLOAD_TIME_MEM(String uPLOAD_TIME_MEM) {
		UPLOAD_TIME_MEM = uPLOAD_TIME_MEM;
	}
	public String getREC_SUCCESS_CODE_MEM() {
		return REC_SUCCESS_CODE_MEM;
	}
	public void setREC_SUCCESS_CODE_MEM(String rEC_SUCCESS_CODE_MEM) {
		REC_SUCCESS_CODE_MEM = rEC_SUCCESS_CODE_MEM;
	}
	public String getUPLOAD_SUCCESS_CODE_MEM() {
		return UPLOAD_SUCCESS_CODE_MEM;
	}
	public void setUPLOAD_SUCCESS_CODE_MEM(String uPLOAD_SUCCESS_CODE_MEM) {
		UPLOAD_SUCCESS_CODE_MEM = uPLOAD_SUCCESS_CODE_MEM;
	}
	public String getREC_PATH_MEM() {
		return REC_PATH_MEM;
	}
	public void setREC_PATH_MEM(String rEC_PATH_MEM) {
		REC_PATH_MEM = rEC_PATH_MEM;
	}
	public String getREC_FILENAME_MEM() {
		return REC_FILENAME_MEM;
	}
	public void setREC_FILENAME_MEM(String rEC_FILENAME_MEM) {
		REC_FILENAME_MEM = rEC_FILENAME_MEM;
	}
	public String getREC_PATH_REMOTE_MEM() {
		return REC_PATH_REMOTE_MEM;
	}
	public void setREC_PATH_REMOTE_MEM(String rEC_PATH_REMOTE_MEM) {
		REC_PATH_REMOTE_MEM = rEC_PATH_REMOTE_MEM;
	}
	public String getREC_FILENAME_REMOTE_MEM() {
		return REC_FILENAME_REMOTE_MEM;
	}
	public void setREC_FILENAME_REMOTE_MEM(String rEC_FILENAME_REMOTE_MEM) {
		REC_FILENAME_REMOTE_MEM = rEC_FILENAME_REMOTE_MEM;
	}
	public String getFACE_TO_FACE() {
		return FACE_TO_FACE;
	}
	public void setFACE_TO_FACE(String fACE_TO_FACE) {
		FACE_TO_FACE = fACE_TO_FACE;
	}
	public String getVISIT_DATE() {
		return VISIT_DATE;
	}
	public void setVISIT_DATE(String vISIT_DATE) {
		VISIT_DATE = vISIT_DATE;
	}
	public String getVISIT_DATE_CLASS() {
		return VISIT_DATE_CLASS;
	}
	public void setVISIT_DATE_CLASS(String vISIT_DATE_CLASS) {
		VISIT_DATE_CLASS = vISIT_DATE_CLASS;
	}
	public String getVISIT_PLACE() {
		return VISIT_PLACE;
	}
	public void setVISIT_PLACE(String vISIT_PLACE) {
		VISIT_PLACE = vISIT_PLACE;
	}
	public String getRECORD_MODE_CODE() {
		return RECORD_MODE_CODE;
	}
	public void setRECORD_MODE_CODE(String rECORD_MODE_CODE) {
		RECORD_MODE_CODE = rECORD_MODE_CODE;
	}
	public String getUSER_PHONE_NUMBER() {
		return USER_PHONE_NUMBER;
	}
	public void setUSER_PHONE_NUMBER(String uSER_PHONE_NUMBER) {
		USER_PHONE_NUMBER = uSER_PHONE_NUMBER;
	}
	public String getUSER_PHONE_NUMBER_GUBUN() {
		return USER_PHONE_NUMBER_GUBUN;
	}
	public void setUSER_PHONE_NUMBER_GUBUN(String uSER_PHONE_NUMBER_GUBUN) {
		USER_PHONE_NUMBER_GUBUN = uSER_PHONE_NUMBER_GUBUN;
	}
	public String getResetPasswordFlag() {
		return resetPasswordFlag;
	}
	public void setResetPasswordFlag(String resetPasswordFlag) {
		this.resetPasswordFlag = resetPasswordFlag;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getUSER_STATUS() {
		return USER_STATUS;
	}
	public void setUSER_STATUS(String uSER_STATUS) {
		USER_STATUS = uSER_STATUS;
	}
	public String getGROUP_NAME() {
		return GROUP_NAME;
	}
	public void setGROUP_NAME(String gROUP_NAME) {
		GROUP_NAME = gROUP_NAME;
	}
	
}
