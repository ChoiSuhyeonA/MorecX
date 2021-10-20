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
package kr.co.irlink.zirecx.login.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("mainFrameDAO")
public class MainFrameDAO extends EgovAbstractDAO {

    /**
	 * 대메뉴 정보를 조회한다.
	 * @param userSeq - 사용자SEQ
	 * @return 조회한 대메뉴 리스트
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectMenuTop(String userSeq) throws Exception {
        return list("mainFrameDAO.selectMenuTop", userSeq);
    }

    /**
	 * Sub메뉴 정보를 조회한다.
	 * @param parentMenuSeq - 대메뉴SEQ
	 * @return 조회한 Sub메뉴 리스트
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectMenuSub(HashMap param) throws Exception {
        return list("mainFrameDAO.selectMenuSub", param);
    }
}