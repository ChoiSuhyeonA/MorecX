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

public class CampaignPopSearchVO implements Serializable  {
	
	/** UID */
	private static final long serialVersionUID = -8060067319482358619L;
	
    /** 캠페인코드 */
    private String strCampSeq;
    
    private String code; 

	/** 캠페인명 */
    private String strCampName;
    
    private String name; 


	public String getStrCampSeq() {
		return strCampSeq;
	}

	public void setStrCampSeq(String strCampSeq) {
		this.strCampSeq = strCampSeq;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getStrCampName() {
		return strCampName;
	}

	public void setStrCampName(String strCampName) {
		this.strCampName = strCampName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}