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

import kr.co.irlink.zirecx.system.service.AccessSearchVO;
import kr.co.irlink.zirecx.system.service.GradeSearchVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;



@Repository("accessManageDAO")
public class AccessManageDAO extends EgovAbstractDAO {
   	
	/**
	 * 접근권한메뉴리스트를 조회한다.
	 */
    public List selectAccessMenuList(AccessSearchVO accessSearchVO) throws Exception {
        return list("accessManageDAO.selectAccessMenuList", accessSearchVO);
    }
    
    /**
	 * 접근권한컬럼리스트를 조회한다.
	 */
    public List selectAccessColumnList(AccessSearchVO accessSearchVO) throws Exception {
        return list("accessManageDAO.selectAccessColumnList", accessSearchVO);
    }
    
    /**
	 * 접근권한데이타리스트를 조회한다.
	 */
    public List selectAccessDataList(AccessSearchVO accessSearchVO) throws Exception {
        return list("accessManageDAO.selectAccessDataList", accessSearchVO);
    }
    
    /**
	 * 접근권한리스트상세정보를 조회한다.
	 */
    public List selectAccessDetail(AccessSearchVO accessSearchVO) throws Exception {
        return list("accessManageDAO.selectAccessDetail", accessSearchVO);
    }
    
    /**
   	 * 권한 삭제.
   	 */
    public int deletePolicy(AccessSearchVO accessSearchVO) {
    	int deleteCnt = 0;
    	
    	deleteCnt = delete("accessManageDAO.deletePolicy1", accessSearchVO);
		
    	deleteCnt = delete("accessManageDAO.deletePolicy2", accessSearchVO);
		
		return deleteCnt;
    }
    
    /**
   	 * 권한 업데이트.
   	 */
    public int updatePolicy(AccessSearchVO accessSearchVO) {
    	int updateCnt = 0;
    	
    	updateCnt = update("accessManageDAO.updatePolicy", accessSearchVO);
		
		return updateCnt;
    }
    
    /**
   	 * 권한 인서트.
   	 */
    public int insertPolicy(AccessSearchVO accessSearchVO) {
    	int insertCnt = 0;
    	String strLastInsertID = "";
    	
    	int tempResult = (Integer) insert("accessManageDAO.insertPolicy1", accessSearchVO);
    	strLastInsertID = Integer.toString(tempResult);
    	/*
    	insertCnt = update("accessManageDAO.insertPolicy1", accessSearchVO);
    	strLastInsertID = (String)getSqlMapClientTemplate().queryForObject("accessManageDAO.selectLastInsertID", accessSearchVO);
    	*/
    	accessSearchVO.setStrLastInsertID(strLastInsertID);
		
    	insertCnt = update("accessManageDAO.insertPolicy2", accessSearchVO);
		
    	if(insertCnt > 0)
    		insertCnt = Integer.parseInt(strLastInsertID);
    	
		return insertCnt;
    }
}
