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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import kr.co.irlink.zirecx.login.service.MainFrameService;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("mainFrameService")
public class MainFrameServiceImpl extends AbstractServiceImpl implements
        MainFrameService {
	
	/** LoginDAO */
    @Resource(name="mainFrameDAO")
    private MainFrameDAO mainFrameDAO;
    
    /**
	 * 대메뉴 정보를 조회한다.
	 * @param userSeq - 사용자SEQ
	 * @return 조회한 대메뉴 리스트
	 * @exception Exception
	 */
    @SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public List selectMenu(String userSeq) throws Exception {
    	List listMenu = new ArrayList();
    	
    	//상위메뉴를 가져온다
    	List listMenuTop = mainFrameDAO.selectMenuTop(userSeq);
    	
    	//상위메뉴에 따른 하위메뉴를 가져온다.
    	for (int i = 0; i < listMenuTop.size(); i++) {
    		EgovMap topMenuMap = (EgovMap)listMenuTop.get(i);
    		
    		//상위메뉴를 Return할 LIST에 넣는다.
    		listMenu.add(listMenuTop.get(i));

    		HashMap param = new HashMap();
    		param.put("rowNum", topMenuMap.get("rowNum"));
    		param.put("parentMenuSeq", topMenuMap.get("menuSeq"));
    		param.put("userSeq", userSeq);
    		
    		//하위메뉴를 가져온다.
    		List listMenuSub = mainFrameDAO.selectMenuSub(param);

    		for (int j = 0; j < listMenuSub.size(); j++) {
    			EgovMap subMenuMap = (EgovMap)listMenuSub.get(j);

    			//하위메뉴를 Return할 LIST에 넣는다.
    			listMenu.add(listMenuSub.get(j));
    		}
    	}
    	
        return listMenu;
    }
}