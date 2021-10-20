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

import java.util.List;

import javax.annotation.Resource;

import kr.co.irlink.zirecx.system.service.MainService;
import kr.co.irlink.zirecx.system.service.MainVO;
import kr.co.irlink.zirecx.system.service.UserSearchVO;



import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("mainService")
public class MainServiceImpl extends AbstractServiceImpl implements
        MainService {
	
	/** MainDAO */
    @Resource(name="mainDAO")
    private MainDAO mainDAO;
    

    public MainVO selectUser(MainVO mainVO) throws Exception {
    	MainVO resultVO = mainDAO.selectUser(mainVO);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }
    
    /**
   	 * 초기 메뉴 하면
   	 */
   	public String selectStartMenu(String strStartMenu) throws Exception{
 		String result = mainDAO.selectStartMenu(strStartMenu);
 	    return result;
   	}
}
