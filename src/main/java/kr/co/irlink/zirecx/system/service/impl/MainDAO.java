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
package kr.co.irlink.zirecx.system.service.impl;



import kr.co.irlink.zirecx.system.service.MainVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("mainDAO")
public class MainDAO extends EgovAbstractDAO {

    public MainVO selectUser(MainVO mainVO) throws Exception {
        return (MainVO) selectByPk("mainDAO.selectUser", mainVO);
    }
    
    /**
	 * 초기 메뉴 하면을 검색
	 * @param String - 권한아이디
	 * @return 메뉴 do
	 * @exception Exception
	 */
    public String selectStartMenu(String strStartMenu) throws Exception {
    	String result = (String)getSqlMapClientTemplate().queryForObject("mainDAO.selectStartMenu", strStartMenu);
        return result;
    }
}
