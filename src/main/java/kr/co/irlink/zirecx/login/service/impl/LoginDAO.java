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
package kr.co.irlink.zirecx.login.service.impl;

import java.util.List;

import kr.co.irlink.zirecx.login.service.ChangePasswordVO;
import kr.co.irlink.zirecx.login.service.LoginVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("loginDAO")
public class LoginDAO extends EgovAbstractDAO {

    /**
	 * 로그인 정보를 조회.
	 */
    public List selectUserLogin(LoginVO loginVO) throws Exception {
        return list("loginDAO.selectUserLogin", loginVO);
    }

    
    /**
	 * 비밀번호 변경시 아이디 존재하는지 검사.
	 */
    public LoginVO selectUserId(LoginVO loginVO) throws Exception {
        return (LoginVO) selectByPk("loginDAO.selectUserId", loginVO);
    }
    
    /**
	 * 암호화 여부 검사.
	 */
    public int selectSecuCnt(LoginVO loginVO) throws Exception {
        return (Integer)getSqlMapClientTemplate().queryForObject("loginDAO.selectSecuCnt", loginVO);
    }
    
    /**
	 * 비밀번호 변경시 기존 패스워드가 맞는지 검사.
	 */
    public int selectUserCnt(ChangePasswordVO changePasswordVO) throws Exception {
        return (Integer)getSqlMapClientTemplate().queryForObject("loginDAO.selectUserCnt", changePasswordVO);
    }

    /**
	 * 사용자 비밀번호를 변경한다.
	 * @param vo - 변경할 정보가 담긴 ChangePasswordVO
	 * @return 영향받은 Line 갯수
	 * @exception Exception
	 */
    public int updatePassword(ChangePasswordVO changePasswordVO) throws Exception {
        return update("loginDAO.updatePassword", changePasswordVO);
    }
    
    /**
	 * 권한 메뉴를 조회.
	 */
    public List selectUserAuth(LoginVO loginVO) throws Exception {
        return list("loginDAO.selectUserAuth", loginVO);
    }
    
    public int selectUserLoginFirst(LoginVO loginVO) throws Exception {
    	return (Integer)getSqlMapClientTemplate().queryForObject("loginDAO.selectUserLoginFirst", loginVO);
    }
    
    public List selectUserPhoneNumber(ChangePasswordVO changePasswordVO) throws Exception {
    	return list("loginDAO.selectUserPhoneNumber", changePasswordVO);
    }
    
    public int updatePinNumber(ChangePasswordVO changePasswordVO) throws Exception {
    	return update("loginDAO.updatePinNumber", changePasswordVO);
    }
    
    public List selectPinNumberConfirm(ChangePasswordVO changePasswordVO) throws Exception {
    	return list("loginDAO.selectPinNumberConfirm", changePasswordVO);
    }
    
    public int updateRandomPassword(ChangePasswordVO changePasswordVO) throws Exception {
    	return update("loginDAO.updateRandomPassword", changePasswordVO);
    }
}
