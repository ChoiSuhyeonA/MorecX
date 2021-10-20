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

import javax.annotation.Resource;

import kr.co.irlink.zirecx.record.service.RecordSearchVO;
import kr.co.irlink.zirecx.system.service.UserDetailVO;
import kr.co.irlink.zirecx.system.service.UserManageService;
import kr.co.irlink.zirecx.system.service.UserSearchVO;

import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.engine.scope.SessionScope;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;


@Service("userManageService")
public class UserManageServiceImpl extends AbstractServiceImpl implements
        UserManageService {
	
	/** UserManageDAO */
    @Resource(name="userManageDAO")
    private UserManageDAO userManageDAO;
    
    /**
   	 * 사용자 팝업 리스트를 조회한다.
   	 */
   	public List selectUserList(UserSearchVO userSearchVO) throws Exception {
   		// 로그인한 사람의 권한을 알아온다
    	String strLoginUserAuth = userManageDAO.selectLoginUserAuth(userSearchVO);
    	userSearchVO.setStrLoginUserAuth(strLoginUserAuth);
    	
    	List userList = userManageDAO.selectUserList(userSearchVO);
        if (userList == null)
            throw processException("info.nodata.msg");
        return userList;
    }
   	
    /**
   	 * 사용자 총 갯수를 조회한다.
   	 */
    public int selectUserCnt(UserSearchVO userSearchVO) throws Exception {
    	// 로그인한 사람의 권한을 알아온다
    	String strLoginUserAuth = userManageDAO.selectLoginUserAuth(userSearchVO);
    	userSearchVO.setStrLoginUserAuth(strLoginUserAuth);
    	
    	return userManageDAO.selectUserCnt(userSearchVO);
    }
       
   /**
  	 * 사용자 디테일.
  	 */
  	public List selectUserDetail(UserSearchVO userSearchVO) throws Exception{
		List userList = userManageDAO.selectUserDetail(userSearchVO);
	    if (userList == null)
	        throw processException("info.nodata.msg");
	    return userList;
  	}
  	
	/**
	 * 권한콤보리스트를 조회한다.
	 * @param vo - 조회할 정보가 담긴 VO
	 * @return 권한콤보리스트
	 * @exception Exception
	 */
    public List selectAuthList(UserSearchVO userSearchVO) throws Exception {
    	// 로그인한 사람의 권한을 알아온다
    	String strLoginUserAuth = userManageDAO.selectLoginUserAuth(userSearchVO);
    	userSearchVO.setStrLoginUserAuth(strLoginUserAuth);
    	
    	List authList = userManageDAO.selectAuthList(userSearchVO);
        if (authList == null)
            throw processException("info.nodata.msg");
        return authList;
    }
    
    /**
	 * 사용자를 수정한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 사용자 수정 성공여부
	 * @exception
	 */
    public int updateUser(UserDetailVO userDetailVO)throws Exception{
    	int result = 0;
    	
    	if(!userDetailVO.getDeleted().equals("1")){
    		if(userDetailVO.getChangeZirecxIdYn().equals("Y")){    // 기존 사용자의 아이디가 변경이 됐다면
        		result = userManageDAO.checkZirecxId(userDetailVO.getZirecxId());
    			if(result != 0){    // 아이디가 동일한게 있음.
    				result = -1;
    				return result;
    			}
        	}
        	
    		/*
        	if(userDetailVO.getChangeLoginstringYn().equals("Y")){    // 기존 사용자의 end point id 가  변경이 됐다면
    			result = userManageDAO.checkEndPointId(userDetailVO.getLoginstring());
    			if(result != 0){     // end point id 동일한게 있음.
    				result = -2;
    				return result;
    			}
    		}   
        	*/
    	} 	
    	
    	result = userManageDAO.deleteGrpToUsr(userDetailVO);
    	result = userManageDAO.insertGrpToUsr1(userDetailVO);
    	result = userManageDAO.insertGrpToUsr2(userDetailVO);
    	result = userManageDAO.updateUser(userDetailVO);
    	
    	/*
    	 * result 값의 의미
    	 * -2 : 중복된 end point id
    	 * -1 : 중복된 zirecx id
    	 * 0 : update 실패
    	 * 1 : update 성공
    	 * */

		return result;
	}
    
    /**
   	 * 사용자를 추가한다.
   	 * @param searchVO - 조회할 정보가 담긴 VO
   	 * @return 사용자 추가 성공여부
   	 * @exception
   	 */
    public int insertUser(UserDetailVO userDetailVO)throws Exception{
		int result = 0;
  
		result = userManageDAO.checkZirecxId(userDetailVO.getZirecxId());
		if(result != 0){    // 아이디가 동일한게 있음.
			result = -1;
			return result;
		}
		/*
		result = userManageDAO.checkEndPointId(userDetailVO.getLoginstring());
		if(result != 0){     // end point id 동일한게 있음.
			result = -2;
			return result;
		}
		*/
		//userDetailVO.setUserId(tbUserSeq.getNextStringId());
		//result = userManageDAO.insertUser(userDetailVO);
		//String strResult = userManageDAO.selectUserSeq();
		String strResult = userManageDAO.insertUser(userDetailVO);
		
		userDetailVO.setUserId(strResult);
		//result = userManageDAO.insertUserHistory(userDetailVO);
		result = userManageDAO.insertLoginstring(userDetailVO);
		//result = userManageDAO.insertLoginstringHistory(userDetailVO);
    	result = userManageDAO.insertGrpToUsr1(userDetailVO);
    	result = userManageDAO.insertGrpToUsr2(userDetailVO);
    	
    	/*
    	 * result 값의 의미
    	 * -2 : 중복된 end point id
    	 * -1 : 중복된 zirecx id
    	 * 0 : insert 실패
    	 * 1 : insert 성공
    	 * */

		return result;	   
    }
    
    /**
   	 * 사용자 그래프 그릴 통계.
   	 */
    public List selectUserGraph(UserSearchVO userSearchVO) throws Exception{
    	List userList = userManageDAO.selectUserGraph(userSearchVO);
	    if (userList == null)
	        throw processException("info.nodata.msg");
	    return userList;   		
   	}
   	
    public int updateUserPasswordInit(UserDetailVO userDetailVO) throws Exception {
    	return userManageDAO.updateUserPasswordInit(userDetailVO);
    }
}
