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
import java.util.ArrayList;

public class CmnPrivateVO implements Serializable {

	private static final long serialVersionUID = 8321842032570348523L;
	
	
	private String[] privName;
	private String strSecurityGroupId;
	
	/** 현재 사용자 group_id  */
    private String strSessionGroupId;
    
    /** childGroupId */
    private String[] arrChildGroupId;

	

	public String[] getPrivName() {
		return privName;
	}

	public void setPrivName(String[] privName) {
		this.privName = privName;
	}

	public String getStrSecurityGroupId() {
		return strSecurityGroupId;
	}

	public void setStrSecurityGroupId(String strSecurityGroupId) {
		this.strSecurityGroupId = strSecurityGroupId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
	
	

}