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

import kr.co.irlink.zirecx.system.service.GroupSearchVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;



@Repository("groupManageDAO")
public class GroupManageDAO extends EgovAbstractDAO {

    /**
	 * 사용자의 부모조직 정보를 조회한다.
	 */
    public String selectParentGroup(String seq) throws Exception {
        return (String)getSqlMapClientTemplate().queryForObject("groupManageDAO.selectParentGroup", seq);
    }
    
    /**
  	 * 검색 된 조직의 하위 조식 코드를 가져온다.
  	 */
    public List subGroupSeq(GroupSearchVO groupSearchVO) throws Exception {
        return list("groupManageDAO.subGroupSeq", groupSearchVO);
        		
    }
    
    /**
	 * 조직도를 Select한다.
	 */
    public List selectGroupTreeList(GroupSearchVO vo) throws Exception {
        return (List) list("groupManageDAO.selectGroupTreeList", vo);
    }
    
    /**
  	 * 조직도의 플러스 버튼을 눌러서 하위 조직 조회.
  	 */
    public List selectGroupTreeSeq(String strSeq) throws Exception {
        return (List) list("groupManageDAO.selectGroupTreeSeq", strSeq);
    }
    
    /**
	 * 센터관리 리스트를 조회한다.
	 */
    public List selectGroupList(GroupSearchVO groupSearchVO) throws Exception {
        return list("groupManageDAO.selectGroupList", groupSearchVO);
    }
    
    /**
	 * 센터 상세정보를 조회한다.
	 */
    public List selectGroupDetail(GroupSearchVO groupSearchVO) throws Exception {
        return list("groupManageDAO.selectGroupDetail", groupSearchVO);
    }
    
    /**
	 * 센터 상세정보를 조회한다.
	 */
    public List selectGroupUpper(GroupSearchVO groupSearchVO) throws Exception {
        return list("groupManageDAO.selectGroupUpper", groupSearchVO);
    }

    /**
	 * 녹취리스트 총 갯수를 조회한다.
	 */
    public int selectGroupListTotCnt(GroupSearchVO groupSearchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("groupManageDAO.selectGroupListTotCnt", groupSearchVO);
    }
    
    public int insertGroup(GroupSearchVO groupSearchVO) throws Exception{
    	
    	int insertCnt = 0;
    	String strLastInsertID = "";
    	String strLicenseCnt = "";
    	
    	if( !groupSearchVO.getGroupSeqUpperDT().equals("") ) {
    		
    		List listResult = list("groupManageDAO.selectGroupDepth", groupSearchVO);
    		for(int i=0; i<listResult.size(); i++) {
    			EgovMap eGovMap = (EgovMap)listResult.get(i);
    			groupSearchVO.setGroupDepthDT(Integer.toString(Integer.parseInt(eGovMap.get("depth").toString()) + 1));
        		groupSearchVO.setGroupSortOrderDT(eGovMap.get("sortOrder").toString());
    		}
    		int tempResult = (Integer) insert("groupManageDAO.insertGroup", groupSearchVO);
    		strLastInsertID = Integer.toString(tempResult);
    		/*
    		insertCnt = update("groupManageDAO.insertGroup", groupSearchVO);
    		strLastInsertID = (String)getSqlMapClientTemplate().queryForObject("groupManageDAO.selectLastInsertID", groupSearchVO);
    		*/
    		groupSearchVO.setLastInsertID(strLastInsertID);
    		
    		update("groupManageDAO.insertGroupToGroup", groupSearchVO);
    		
    	} else {
    		groupSearchVO.setGroupDepthDT("0");
    		groupSearchVO.setGroupSeqUpperDT("0");
    		groupSearchVO.setGroupSortOrderDT("0");
    		
    		int tempResult = (Integer) insert("groupManageDAO.insertGroup", groupSearchVO);
    		strLastInsertID = Integer.toString(tempResult);
    		/*
    		insertCnt = update("groupManageDAO.insertGroup", groupSearchVO);
    		strLastInsertID = (String)getSqlMapClientTemplate().queryForObject("groupManageDAO.selectLastInsertID", groupSearchVO);
    		*/
    		groupSearchVO.setLastInsertID(strLastInsertID);
    		
    		update("groupManageDAO.updateSortOrder", groupSearchVO);
    		groupSearchVO.setGroupSeqDT(strLastInsertID);
    		// selectlicensecnt
    		strLicenseCnt = (String)getSqlMapClientTemplate().queryForObject("groupManageDAO.selectLicenseCnt", groupSearchVO);
    		
    		if ("".equals(strLicenseCnt) || (null == strLicenseCnt) || ("null".equals(strLicenseCnt))){
    			update("groupManageDAO.insertLicense", groupSearchVO);
    		} else {
    			update("groupManageDAO.insertLicenseHist", groupSearchVO);
    			update("groupManageDAO.updateLicense", groupSearchVO);
    		}
    		
    	}
    	
		return Integer.parseInt(strLastInsertID);
	}
    
    /**
     * 센터관리 Update
     */
    public int updateGroup(GroupSearchVO groupSearchVO) {
    	
    	int deleteCnt = 0;
    	int updateCnt = 0;
    	String strLicenseCnt = "";
    	
    	deleteCnt = delete("groupManageDAO.deleteChildGroup", groupSearchVO);
    	
    	if( groupSearchVO.getGroupSeqUpperDT().equals("") || groupSearchVO.getGroupSeqUpperDT().equals("0") ) {
    		groupSearchVO.setGroupDepthDT("0");
    		groupSearchVO.setGroupSeqUpperDT("0");
    		groupSearchVO.setGroupSortOrderDT("0");
    		
    		updateCnt = update("groupManageDAO.updateGroup", groupSearchVO);
    		
    		// selectlicensecnt
    		strLicenseCnt = (String)getSqlMapClientTemplate().queryForObject("groupManageDAO.selectLicenseCnt", groupSearchVO);
    		
    		if ("".equals(strLicenseCnt) || (null == strLicenseCnt) || ("null".equals(strLicenseCnt))){
    			update("groupManageDAO.insertLicense", groupSearchVO);
    		} else {
    			if (!strLicenseCnt.equals(groupSearchVO.getLicenseCnt())) {
	    			update("groupManageDAO.insertLicenseHist", groupSearchVO);
	    			update("groupManageDAO.updateLicense", groupSearchVO);
    			}
    		}
    		
    	} else {
    		List listResult = list("groupManageDAO.selectGroupDepth", groupSearchVO);
    		for(int i=0; i<listResult.size(); i++) {
    			EgovMap eGovMap = (EgovMap)listResult.get(i);
    			groupSearchVO.setGroupDepthDT(Integer.toString(Integer.parseInt(eGovMap.get("depth").toString()) + 1));
        		groupSearchVO.setGroupSortOrderDT(eGovMap.get("sortOrder").toString());
    		}
    		
    		updateCnt = update("groupManageDAO.updateGroup", groupSearchVO);
    		
    		if(updateCnt > 0) {
    			insert("groupManageDAO.insertChildGroup", groupSearchVO);
    			
        	}
    		
    	}

    	return updateCnt;
    }
}
