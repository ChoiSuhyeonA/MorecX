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
package kr.co.irlink.zirecx.common.service.impl;

import java.util.List;

import kr.co.irlink.zirecx.common.service.CmnPrivateVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;



@Repository("cmnPrivateDAO")
public class CmnPrivateDAO extends EgovAbstractDAO {
    
    public List selectPrivateList(CmnPrivateVO cmnPrivateVO) {
		return list("cmnPrivateDAO.selectPrivateList", cmnPrivateVO);
    }
    
    public String selectChildGroupId(CmnPrivateVO cmnPrivateVO) {
    	
    	String strChildGroupId = "";
    	String strChildGroupIdTotal = "";
    	
    	List listChildGroupId = null;
    	listChildGroupId = list("cmnPrivateDAO.selectChildGroupId01", cmnPrivateVO);
    	strChildGroupIdTotal = cmnPrivateVO.getStrSessionGroupId();
    	
    	while(listChildGroupId.size() != 0) {
    		for(int i=0; listChildGroupId.size() > i; i++) {
    			
    			EgovMap eGovMap = (EgovMap)listChildGroupId.get(i);
    			if(strChildGroupId.equals("")) {
    				strChildGroupId = eGovMap.get("childGroupId").toString();
    			} else {
    				strChildGroupId = strChildGroupId + "," + eGovMap.get("childGroupId").toString();
    			}
    		}
    		
    		strChildGroupIdTotal = strChildGroupIdTotal + "," + strChildGroupId;
    		//String[] arrChildGroupId = strChildGroupIdTotal.split(",");
    		String[] arrChildGroupId = strChildGroupId.split(",");
    		
    		cmnPrivateVO.setArrChildGroupId(arrChildGroupId);
    		listChildGroupId = list("cmnPrivateDAO.selectChildGroupId02", cmnPrivateVO);
    		
    		strChildGroupId = "";
    	}
    	return strChildGroupIdTotal;
    }
    
    public String selectParentGroupId(CmnPrivateVO cmnPrivateVO) {
    	String strParentGroupId = (String) selectByPk("cmnPrivateDAO.selectParentGroupId", cmnPrivateVO);
    	
    	return strParentGroupId;
    }
    
    public String selectChildGroupIdUp(CmnPrivateVO cmnPrivateVO) {
    	
    	String strChildGroupId = "";
    	String strChildGroupIdTotal = "";
    	
    	List listChildGroupId = null;
    	listChildGroupId = list("cmnPrivateDAO.selectChildGroupId01", cmnPrivateVO);
    	strChildGroupIdTotal = cmnPrivateVO.getStrSessionGroupId();
    	
    	while(listChildGroupId.size() != 0) {
    		for(int i=1; listChildGroupId.size() > i; i++) {
    			
    			EgovMap eGovMap = (EgovMap)listChildGroupId.get(i);
    			if(strChildGroupId.equals("")) {
    				strChildGroupId = eGovMap.get("childGroupId").toString();
    			} else {
    				strChildGroupId = strChildGroupId + "," + eGovMap.get("childGroupId").toString();
    			}
    		}
    		
    		strChildGroupIdTotal = strChildGroupIdTotal + "," + strChildGroupId;
    		//String[] arrChildGroupId = strChildGroupIdTotal.split(",");
    		String[] arrChildGroupId = strChildGroupId.split(",");
    		
    		cmnPrivateVO.setArrChildGroupId(arrChildGroupId);
    		listChildGroupId = list("cmnPrivateDAO.selectChildGroupId02", cmnPrivateVO);
    		
    		strChildGroupId = "";
    	}
    	return strChildGroupIdTotal;
    }
}