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

import kr.co.irlink.zirecx.record.service.RecordSearchVO;
import kr.co.irlink.zirecx.system.service.UserDetailVO;
import kr.co.irlink.zirecx.system.service.UserSearchVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("userManageDAO")
public class UserManageDAO extends EgovAbstractDAO {

    /**
   	 * 사용자 팝업 리스트를 조회한다.
   	 */
   	public List selectUserList(UserSearchVO userSearchVO) throws Exception {
        return list("userManageDAO.selectUserList", userSearchVO);
    }
   	
    public int selectUserCnt(UserSearchVO userSearchVO) throws Exception{
        return (Integer)getSqlMapClientTemplate().queryForObject("userManageDAO.selectUserCnt", userSearchVO);
    }
    
    /**
  	 * 사용자 디테일.
  	 */
  	public List selectUserDetail(UserSearchVO userSearchVO) throws Exception{
        return list("userManageDAO.selectUserDetail", userSearchVO);
    }
  	
    /**
	 * 권한콤보리스트를 조회한다.
	 * @param vo - 조회할 정보가 담긴 VO
	 * @return 권한콤보리스트
	 * @exception Exception
	 */
    public List selectAuthList(UserSearchVO userSearchVO) throws Exception {
        return list("userManageDAO.selectAuthList", userSearchVO);
    }
    
    public String selectLoginUserAuth(UserSearchVO userSearchVO) throws Exception {
    	return (String) selectByPk("userManageDAO.selectLoginUserAuth", userSearchVO);
    }
    
    /**
	 * 사용자를 수정한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 사용자 수정 성공여부
	 * @exception
	 */
    public int updateUser(UserDetailVO userDetailVO)throws Exception{
    	int resultVal = update("userManageDAO.updateUserOrkuser",userDetailVO);
    	insert("userManageDAO.insertUserHistory",userDetailVO);
    	if(resultVal > 0) {
    		resultVal = update("userManageDAO.updateUserOrkloginstring",userDetailVO);
    		insert("userManageDAO.insertLoginstringHistory",userDetailVO);
    	}
		return resultVal;
	}
    
    /**
	 * 사용자를 추가한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 사용자 추가 성공여부
	 * @exception
	 */
    public String insertUser(UserDetailVO userDetailVO)throws Exception{
    	int result = (Integer) insert("userManageDAO.insertUser",userDetailVO);
		return Integer.toString(result);
	}
    
    public int insertUserHistory(UserDetailVO userDetailVO)throws Exception{
    	return (Integer) insert("userManageDAO.insertUserHistory",userDetailVO);
	}
    
    public String selectUserSeq(){
        return (String)getSqlMapClientTemplate().queryForObject("userManageDAO.selectUserSeq");
    }
    
    /**
	 * 사용자 Loginstring 을 추가한다
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 추가 성공여부
	 * @exception
	 */
    public int insertLoginstring(UserDetailVO userDetailVO)throws Exception{    	
		return update("userManageDAO.insertLoginstring",userDetailVO);
	}
    
    public int insertLoginstringHistory(UserDetailVO userDetailVO)throws Exception{    	
		return (Integer) insert("userManageDAO.insertLoginstringHistory",userDetailVO);
	}
    
	/**
	 * END_POINT_ID 의 중복을 체크한다.
	 * @param String endPointId
	 * @return 중복여부
	 * @exception
	 */
    public int checkEndPointId(String endPointId)throws Exception{
		return (Integer)getSqlMapClientTemplate().queryForObject("userManageDAO.checkEndPointId",endPointId);
	}
    
    /**
	 * ZirecX ID 의 중복을 체크한다.
	 * @param String zirecxId
	 * @return 중복여부
	 * @exception
	 */
    public int checkZirecxId(String zirecxId)throws Exception{
		return (Integer)getSqlMapClientTemplate().queryForObject("userManageDAO.checkZirecxId",zirecxId);
	}
    
    /**
	 * 사용자가 속한 orkgrouptouser 테이블에서 삭제한다
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 사용자 수정 성공여부
	 * @exception
	 */
    public int deleteGrpToUsr(UserDetailVO userDetailVO)throws Exception{    	
		return (Integer)getSqlMapClientTemplate().delete("userManageDAO.deleteGrpToUsr",userDetailVO);
	}
    
    /**
   	 * orkgrouptouser 테이블에 사용자를 추가한다(조직)
   	 * @param searchVO - 조회할 정보가 담긴 VO
   	 * @return 사용자 수정 성공여부
   	 * @exception
   	 */
    public int insertGrpToUsr1(UserDetailVO userDetailVO)throws Exception{    	
    	return update("userManageDAO.insertGrpToUsr1",userDetailVO);
   	}
       
   /**
  	 * orkgrouptouser 테이블에 사용자를 추가한다(권한)
  	 * @param searchVO - 조회할 정보가 담긴 VO
  	 * @return 사용자 수정 성공여부
  	 * @exception
  	 */
    public int insertGrpToUsr2(UserDetailVO userDetailVO)throws Exception{    	
    	return update("userManageDAO.insertGrpToUsr2",userDetailVO);
  	}
    
    /**
   	 * 사용자 그래프 그릴 통계.
   	 */
    public List selectUserGraph(UserSearchVO userSearchVO) throws Exception{
    	if(userSearchVO.getSearchType().equals("month")){
    		return list("userManageDAO.selectUserGraphMonth", userSearchVO);
    	}else if(userSearchVO.getSearchType().equals("week")){
    		return list("userManageDAO.selectUserGraphWeek", userSearchVO);
    	}else{
    		return list("userManageDAO.selectUserGraphDay", userSearchVO);
    	}
    }
    
    public int updateUserPasswordInit(UserDetailVO userDetailVO) throws Exception {
    	int result = update("userManageDAO.updateUserPasswordInit", userDetailVO); 
    	insert("userManageDAO.insertUserHistory",userDetailVO);
    	return result;
    }
}
