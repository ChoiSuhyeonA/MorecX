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

public interface CodeManageService {
	/**
	 * 마스터코드 조회.
	 */
	List selectCodeMasterList(CodeSearchVO vo) throws Exception;
	
	/**
	 * 상세코드 조회.
	 */
	List selectCodeDetailList(CodeSearchVO vo) throws Exception;
	
	/**
	 * 마스터코드 수정.
	 */
	int updateCodeManageMaster(CodeSearchVO vo) throws Exception;
	
	/**
	 * 마스터코드 저장.
	 */
	int insertCodeManageMaster(CodeSearchVO vo) throws Exception;
	
	/**
	 * 상세코드 수정.
	 */
	int updateCodeManageDetail(CodeSearchVO vo) throws Exception;
	
	/**
	 * 상세코드 저장.
	 */
	int insertCodeManageDetail(CodeSearchVO vo) throws Exception;
}
