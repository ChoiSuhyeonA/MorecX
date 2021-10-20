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

import kr.co.irlink.zirecx.system.service.UserSearchVO;

public interface UserManageService {
	
    /**
   	 * 사용자 팝업 리스트를 조회한다.
   	 */
   	List selectUserList(UserSearchVO userSearchVO) throws Exception;
   	
   	/**
	 * 사용자 총 갯수를 조회한다.
	 */
    int selectUserCnt(UserSearchVO userSearchVO) throws Exception;
    
    /**
   	 * 사용자 디테일.
   	 */
   	List selectUserDetail(UserSearchVO userSearchVO) throws Exception;
	
    /**
	 * 권한콤보리스트를 조회한다.
	 * @param vo - 조회할 정보가 담긴 VO
	 * @return 권한콤보리스트
	 * @exception Exception
	 */
	List selectAuthList(UserSearchVO userSearchVO) throws Exception;
	
    /**
	 * 사용자를 수정한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 사용자 수정 성공여부
	 * @exception
	 */
    int updateUser(UserDetailVO userDetailVO) throws Exception;
    
    /**
	 * 사용자를 생성한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 사용자 수정 성공여부
	 * @exception
	 */
    int insertUser(UserDetailVO userDetailVO) throws Exception;
    
    /**
   	 * 사용자 그래프 그릴 통계.
   	 */
   	List selectUserGraph(UserSearchVO userSearchVO) throws Exception;
    
    int updateUserPasswordInit(UserDetailVO userDetailVO) throws Exception;
    
   	
}
