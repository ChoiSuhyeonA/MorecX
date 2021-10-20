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
package kr.co.irlink.zirecx.system.service;

import java.util.List;

import kr.co.irlink.zirecx.system.service.GradeSearchVO;

public interface GradeManageService {
	
	 /**
   	 * 권한팝업 리스트를 조회한다.
   	 */
   	List selectGradePopList(GradeSearchVO gradeSearchVO) throws Exception;
	/**
	 * 권한리스트를 조회한다.
	 */
	List selectGradeList(GradeSearchVO gradeSearchVO) throws Exception;
	
	 /**
	 * 권한리스트 총 갯수를 조회한다.
	 */
    int selectGradeListTotCnt(GradeSearchVO gradeSearchVO);
    
    /**
	 * 권한 상세정보를 조회한다.
	 */
	List selectGradeDetail(GradeSearchVO gradeSearchVO) throws Exception;
	
	/**
	 * 권한 인서트.
	 */
	int insertGroup(GradeSearchVO gradeSearchVO) throws Exception;
	
	/**
	 * 권한 업데이트.
	 */
	int updateGrade(GradeSearchVO gradeSearchVO) throws Exception;
}
