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

import javax.annotation.Resource;

import kr.co.irlink.zirecx.login.service.ChangePasswordVO;
import kr.co.irlink.zirecx.login.service.LoginService;
import kr.co.irlink.zirecx.login.service.LoginVO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("loginService")
public class LoginServiceImpl extends AbstractServiceImpl implements
        LoginService {
	
	/** LoginDAO */
    @Resource(name="loginDAO")
    private LoginDAO loginDAO;
    
    /**
	 * USER 로그인 정보를 Select한다.
	 * @param vo - 조회할 정보가 담긴 LoginVO
	 * @return 조회한 Login정보
	 * @exception Exception
	 */
    public List selectUserLogin(LoginVO loginVO) throws Exception {
    	List listUserLogin = loginDAO.selectUserLogin(loginVO);
        if (listUserLogin == null)
            throw processException("info.nodata.msg");
        return listUserLogin;
    }

    
    /**
	 * 비밀번호 변경시 아이디가 존재하는지 검사한다.
	 * @param vo - 조회할 정보가 담긴 LoginVO
	 * @return 사용자 Count
	 * @exception Exception
	 */
    public LoginVO selectUserId(LoginVO loginVO) throws Exception {
    	LoginVO resultVO = loginDAO.selectUserId(loginVO);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }
    
    /**
	 * 암호화 여부를 검사한다.
	 * @param vo - 조회할 정보가 담긴 LoginVO
	 * @return 사용자 Count
	 * @exception Exception
	 */
    
    public int selectSecuCnt(LoginVO loginVO) throws Exception {
        return loginDAO.selectSecuCnt(loginVO);
    }
    
    
    /**
	 * 비밀번호 변경시 기존 패스워드가 맞는지 검사한다.
	 * @param vo - 조회할 정보가 담긴 ChangePasswordVO
	 * @return 사용자 Count
	 * @exception Exception
	 */
    
    public int selectUserCnt(ChangePasswordVO changePasswordVO) throws Exception {
        return loginDAO.selectUserCnt(changePasswordVO);
    }

    /**
	 * 사용자 비밀번호를 변경한다.
	 * @param vo - 변경할 정보가 담긴 ChangePasswordVO
	 * @return 영향받은 Line 갯수
	 * @exception Exception
	 */
    public int updatePassword(ChangePasswordVO changePasswordVO) throws Exception {
        return loginDAO.updatePassword(changePasswordVO);
    }
    
    /**
	 * 로그인 USER 메뉴 권한 정보를 Select한다.
	 * @param vo - 조회할 정보가 담긴 LoginVO
	 * @return Login 유저의 메뉴 권한 정보
	 * @exception Exception
	 */
    public List selectUserAuth(LoginVO loginVO) throws Exception {
    	List listUserAuth = loginDAO.selectUserAuth(loginVO);
        if (listUserAuth == null)
            throw processException("info.nodata.msg");
        return listUserAuth;
    }
    
    public int selectUserLoginFirst(LoginVO loginVO) throws Exception {
    	return loginDAO.selectUserLoginFirst(loginVO);
    }
    
    public List selectUserPhoneNumber(ChangePasswordVO changePasswordVO) throws Exception {
    	List listUserPhoneNumber = loginDAO.selectUserPhoneNumber(changePasswordVO);
        if (listUserPhoneNumber == null)
            throw processException("info.nodata.msg");
        return listUserPhoneNumber;
    }
    
    public int updatePinNumber(ChangePasswordVO changePasswordVO) throws Exception {
    	return loginDAO.updatePinNumber(changePasswordVO);
    }
    
    public List selectPinNumberConfirm(ChangePasswordVO changePasswordVO) throws Exception {
    	List listPinNumberConfirm = loginDAO.selectPinNumberConfirm(changePasswordVO);
        if (listPinNumberConfirm == null)
            throw processException("info.nodata.msg");
        return listPinNumberConfirm;
    }
    
    public int updateRandomPassword(ChangePasswordVO changePasswordVO) throws Exception {
    	return loginDAO.updateRandomPassword(changePasswordVO);
    }
}