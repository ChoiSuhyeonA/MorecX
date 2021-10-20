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

import kr.co.irlink.zirecx.common.service.CmnPrivateService;
import kr.co.irlink.zirecx.common.service.CmnPrivateVO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;


@Service("cmnPrivateService")
public class CmnPrivateServiceImpl extends AbstractServiceImpl implements
        CmnPrivateService {
	
	/** CmnPrivateDAO */
    @Resource(name="cmnPrivateDAO")
    private CmnPrivateDAO cmnPrivateDAO;
    
	public List selectPrivateList(CmnPrivateVO cmnPrivateVO){
    	return cmnPrivateDAO.selectPrivateList(cmnPrivateVO);
	}
	
	public String selectChildGroupId(CmnPrivateVO cmnPrivateVO) {
		return cmnPrivateDAO.selectChildGroupId(cmnPrivateVO);
	}
	
	public String selectChildGroupIdUp(CmnPrivateVO cmnPrivateVO) {
		return cmnPrivateDAO.selectChildGroupIdUp(cmnPrivateVO);
	}
	
	public String selectParentGroupId(CmnPrivateVO cmnPrivateVO) {
		return cmnPrivateDAO.selectParentGroupId(cmnPrivateVO);
	}
}