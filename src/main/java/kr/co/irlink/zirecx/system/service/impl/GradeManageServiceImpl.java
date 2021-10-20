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

import kr.co.irlink.zirecx.system.service.GradeManageService;
import kr.co.irlink.zirecx.system.service.GradeSearchVO;
import kr.co.irlink.zirecx.system.service.GroupSearchVO;
import kr.co.irlink.zirecx.system.service.UserSearchVO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;


@Service("gradeManageService")
public class GradeManageServiceImpl extends AbstractServiceImpl implements
        GradeManageService {
	
	/** GradeManageDAO */
    @Resource(name="gradeManageDAO")
    private GradeManageDAO gradeManageDAO;
    
    /**
   	 * 권한 팝업 리스트를 조회한다.
   	 */
   	public List selectGradePopList(GradeSearchVO gradeSearchVO) throws Exception {
    	List gradePopList = gradeManageDAO.selectGradePopList(gradeSearchVO);
        if (gradePopList == null)
            throw processException("info.nodata.msg");
        return gradePopList;
    }
   	
    /**
	 * 권한리스트를 조회한다.
	*/
    public List selectGradeList(GradeSearchVO gradeSearchVO) throws Exception {
    	List gradeList = gradeManageDAO.selectGradeList(gradeSearchVO);
        if (gradeList == null)
            throw processException("info.nodata.msg");
        return gradeList;
    }
	
    /**
   	 * 권한리스트 총 갯수를 조회한다.
   	 */
    public int selectGradeListTotCnt(GradeSearchVO gradeSearchVO) {
   		return gradeManageDAO.selectGradeListTotCnt(gradeSearchVO);
    }
   
    /**
	 * 권한리스트를 조회한다.
	 */
    public List selectGradeDetail(GradeSearchVO gradeSearchVO) throws Exception {
    	List gradeList = gradeManageDAO.selectGradeDetail(gradeSearchVO);
        if (gradeList == null)
           throw processException("info.nodata.msg");
        return gradeList;
    }
    
    /**
   	 * 권한 인서트
   	 */
    public int insertGroup(GradeSearchVO gradeSearchVO)throws Exception{
    	return gradeManageDAO.insertGrade(gradeSearchVO);
	}
    
    /**
   	 * 권한 인서트
   	 */
    public int updateGrade(GradeSearchVO gradeSearchVO)throws Exception{
    	return gradeManageDAO.updateGrade(gradeSearchVO);
	}
}
