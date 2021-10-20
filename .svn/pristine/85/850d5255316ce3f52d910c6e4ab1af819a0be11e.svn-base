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

import kr.co.irlink.zirecx.system.service.GradeSearchVO;
import kr.co.irlink.zirecx.system.service.GroupSearchVO;
import kr.co.irlink.zirecx.system.service.UserSearchVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;



@Repository("gradeManageDAO")
public class GradeManageDAO extends EgovAbstractDAO {
	
	/**
   	 * 권한 팝업 리스트를 조회한다.
   	 */
   	public List selectGradePopList(GradeSearchVO gradeSearchVO) throws Exception {
        return list("gradeManageDAO.selectGradePopList", gradeSearchVO);
    }
   	
	/**
	 * 권한리스트를 조회한다.
	 */
    public List selectGradeList(GradeSearchVO gradeSearchVO) throws Exception {
        return list("gradeManageDAO.selectGradeList", gradeSearchVO);
    }
    
    /**
   	 * 권한리스트 총 갯수를 조회한다.
   	 */
    public int selectGradeListTotCnt(GradeSearchVO gradeSearchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("gradeManageDAO.selectGradeListTotCnt", gradeSearchVO);
    }
    
    /**
	 * 권한 상세정보를 조회한다.
	 */
    public List selectGradeDetail(GradeSearchVO gradeSearchVO) throws Exception {
        return list("gradeManageDAO.selectGradeDetail", gradeSearchVO);
    }
    
    /**
   	 * 권한 인서트.
   	 */
    public int insertGrade(GradeSearchVO gradeSearchVO) {
    	int insertCnt = 0;
    	String strLastInsertID = "";
    	
    	int tempResult = (Integer) insert("gradeManageDAO.insertGrade", gradeSearchVO);
    	strLastInsertID = Integer.toString(tempResult);
    	/*
		insertCnt = update("gradeManageDAO.insertGrade", gradeSearchVO);
		strLastInsertID = (String)getSqlMapClientTemplate().queryForObject("gradeManageDAO.selectLastInsertID", gradeSearchVO);
		*/
		gradeSearchVO.setStrLastInsertID(strLastInsertID);
		
		return Integer.parseInt(strLastInsertID);
    }
    
    /**
     * 권한 Update
     */
    public int updateGrade(GradeSearchVO gradeSearchVO) {
    	
    	int updateCnt = 0;
    		
		updateCnt = update("gradeManageDAO.updateGrade", gradeSearchVO);
    		
    	return updateCnt;
    }
}
