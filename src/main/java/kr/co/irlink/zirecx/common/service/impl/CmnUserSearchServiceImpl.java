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

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import kr.co.irlink.zirecx.common.service.CmnUserSearchService;
import kr.co.irlink.zirecx.common.service.CmnUserSearchVO;
import kr.co.irlink.zirecx.system.service.impl.UserManageDAO;


@Service("cmnUserSearchService")
public class CmnUserSearchServiceImpl extends AbstractServiceImpl implements
        CmnUserSearchService {
	
	/** UserPopDAO */
    @Resource(name="cmnUserSearchDAO")
    private CmnUserSearchDAO cmnUserSearchDAO;
    
    @Resource(name="userManageDAO")
    private UserManageDAO userManageDAO;
    
    /**
   	 * 사용자 팝업 리스트를 조회한다.
   	 */
   	public List selectUserPopList(CmnUserSearchVO userPopSearchVO) throws Exception {
    	List userPopList = cmnUserSearchDAO.selectUserPopList(userPopSearchVO);
        if (userPopList == null)
            throw processException("info.nodata.msg");
        return userPopList;
    }
   	
   	
   	public List selectUserCheck(CmnUserSearchVO cmnUserSearchVO){
   		//조건 추가 
   		if(cmnUserSearchVO.getPageType().equals("system")) {
   		// 로그인한 사람의 권한을 알아온다
   	    	String strLoginUserAuth = cmnUserSearchDAO.selectLoginUserAuth(cmnUserSearchVO);
   	    	cmnUserSearchVO.setStrLoginUserAuth(strLoginUserAuth);
   		}
   		
    	return cmnUserSearchDAO.selectUserCheck(cmnUserSearchVO);
	}
   	
   	public List selectUserList(CmnUserSearchVO cmnUserSearchVO){
   	//조건 추가 
   		if(cmnUserSearchVO.getPageType().equals("system")) {
   		// 로그인한 사람의 권한을 알아온다
   	    	String strLoginUserAuth = cmnUserSearchDAO.selectLoginUserAuth(cmnUserSearchVO);
   	    	cmnUserSearchVO.setStrLoginUserAuth(strLoginUserAuth);
   		}
   		
    	return cmnUserSearchDAO.selectUserList(cmnUserSearchVO);
	}
   		
}
