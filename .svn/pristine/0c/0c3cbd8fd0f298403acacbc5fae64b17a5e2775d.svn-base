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
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import kr.co.irlink.zirecx.system.service.AccessManageService;
import kr.co.irlink.zirecx.system.service.AccessSearchVO;
import kr.co.irlink.zirecx.system.service.GradeSearchVO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;


@Service("accessManageService")
public class AccessManageServiceImpl extends AbstractServiceImpl implements
		AccessManageService {
	
	/** AccessManageDAO */
    @Resource(name="accessManageDAO")
    private AccessManageDAO accessManageDAO;
    
    /**
	 * 접근권한메뉴리스트를 조회한다.
	*/
    public List selectAccessMenuList(AccessSearchVO accessSearchVO) throws Exception {
    	List accessMenuList = accessManageDAO.selectAccessMenuList(accessSearchVO);
        if (accessMenuList == null)
            throw processException("info.nodata.msg");
        return accessMenuList;
    }
    
    /**
	 * 접근권한컬럼리스트를 조회한다.
	*/
    public List selectAccessColumnList(AccessSearchVO accessSearchVO) throws Exception {
    	List accessColumnList = accessManageDAO.selectAccessColumnList(accessSearchVO);
        if (accessColumnList == null)
            throw processException("info.nodata.msg");
        return accessColumnList;
    }
    
    /**
	 * 접근권한데이타리스트를 조회한다.
	*/
    public List selectAccessDataList(AccessSearchVO accessSearchVO) throws Exception {
    	List accessDataList = accessManageDAO.selectAccessDataList(accessSearchVO);
        if (accessDataList == null)
            throw processException("info.nodata.msg");
        return accessDataList;
    }
    
    /**
	 * 접근권한리스트상세정보를 조회한다.
	*/
    public List selectAccessDetail(AccessSearchVO accessSearchVO) throws Exception {
    	List accessDetail = accessManageDAO.selectAccessDetail(accessSearchVO);
        if (accessDetail == null)
            throw processException("info.nodata.msg");
        return accessDetail;
    }
    
    /**
   	 * 권한 삭제
   	 */
    public int deletePolicy(AccessSearchVO accessSearchVO)throws Exception{
    	return accessManageDAO.deletePolicy(accessSearchVO);
	}
    
    /**
   	 * 권한 업데이트
   	 */
    public int updatePolicy(AccessSearchVO accessSearchVO)throws Exception{
    	return accessManageDAO.updatePolicy(accessSearchVO);
	}
	
    /**
   	 * 권한 인서트
   	 */
    public int insertPolicy(AccessSearchVO accessSearchVO)throws Exception{
    	return accessManageDAO.insertPolicy(accessSearchVO);
	}
}
