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

import kr.co.irlink.zirecx.system.service.AccessSearchVO;

public interface AccessManageService {
	
	/**
	 * 접근권한메뉴리스트를 조회한다.
	 */
	List selectAccessMenuList(AccessSearchVO accessSearchVO) throws Exception;
	
	/**
	 * 접근권한컬럼리스트를 조회한다.
	 */
	List selectAccessColumnList(AccessSearchVO accessSearchVO) throws Exception;
	
	/**
	 * 접근권한데이타리스트를 조회한다.
	 */
	List selectAccessDataList(AccessSearchVO accessSearchVO) throws Exception;
	
	/**
	 * 접근권한리스트상세정보를 조회한다.
	 */
	List selectAccessDetail(AccessSearchVO accessSearchVO) throws Exception;
	
	/**
	 * 권한삭제.
	 */
	int deletePolicy(AccessSearchVO accessSearchVO) throws Exception;
	
	/**
	 * 권한업데이트.
	 */
	int updatePolicy(AccessSearchVO accessSearchVO) throws Exception;
	
	/**
	 * 권한인서트.
	 */
	int insertPolicy(AccessSearchVO accessSearchVO) throws Exception;
}
