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

import kr.co.irlink.zirecx.common.service.CmnGroupSearchVO;
import kr.co.irlink.zirecx.common.service.CmnUserSearchVO;
import kr.co.irlink.zirecx.system.service.GroupSearchVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("cmnUserSearchDAO")
public class CmnUserSearchDAO extends EgovAbstractDAO {

    /**
   	 * 사용자 팝업 리스트를 조회한다.
   	 */
   	public List selectUserPopList(CmnUserSearchVO cmnUserSearchVO) throws Exception {
        return list("cmnUserSearchDAO.selectUserPopList", cmnUserSearchVO);
    }
   	
    public List selectUserCheck(CmnUserSearchVO cmnUserSearchVO) {
		return list("cmnUserSearchDAO.selectUserCheck", cmnUserSearchVO);
    }
    
    public List selectUserList(CmnUserSearchVO cmnUserSearchVO) {
		return list("cmnUserSearchDAO.selectUserList", cmnUserSearchVO);
    }
    
    //추가
    public String selectLoginUserAuth(CmnUserSearchVO cmnUserSearchVO) {
    	return (String) selectByPk("cmnUserSearchDAO.selectLoginUserAuth", cmnUserSearchVO);
    }
   
}