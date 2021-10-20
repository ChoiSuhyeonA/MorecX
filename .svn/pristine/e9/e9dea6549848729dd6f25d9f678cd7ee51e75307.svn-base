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
package kr.co.irlink.zirecx.login.service;

import java.util.List;

public interface LoginService {
	
	/**
	 * 로그인 정보를 조회.
	 */
	List selectUserLogin(LoginVO loginVO) throws Exception;
    
    /**
   	 * 비밀번호 변경시 해당 아이디가 존재하는지 검사.
   	 */
    LoginVO selectUserId(LoginVO LoginVO) throws Exception;
    
    /**
	 * 암호화 여부 검사.
	 */
    int selectSecuCnt(LoginVO LoginVO) throws Exception;
       
    /**
	 * 비밀번호 변경시 기존 패스워드가 맞는지 검사.
	 */
    int selectUserCnt(ChangePasswordVO changePasswordVO) throws Exception;

    /**
	 * 사용자 비밀번호를 변경.
	 */
    int updatePassword(ChangePasswordVO changePasswordVO) throws Exception;
    
    /**
	 * 메뉴 권한 조회
	 */
	List selectUserAuth(LoginVO loginVO) throws Exception;
	
	
	int selectUserLoginFirst(LoginVO loginVO) throws Exception;
	
    List selectUserPhoneNumber(ChangePasswordVO changePasswordVO) throws Exception;
    
    int updatePinNumber(ChangePasswordVO changePasswordVO) throws Exception;
    
    List selectPinNumberConfirm(ChangePasswordVO changePasswordVO) throws Exception;
    
    int updateRandomPassword(ChangePasswordVO changePasswordVO) throws Exception;
}