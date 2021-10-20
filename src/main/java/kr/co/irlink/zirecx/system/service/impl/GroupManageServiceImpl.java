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
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import kr.co.irlink.zirecx.login.service.ChangePasswordVO;
import kr.co.irlink.zirecx.record.service.RecordSearchVO;
import kr.co.irlink.zirecx.system.service.GroupListVO;
import kr.co.irlink.zirecx.system.service.GroupManageService;
import kr.co.irlink.zirecx.system.service.GroupSearchVO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;


@Service("groupManageService")
public class GroupManageServiceImpl extends AbstractServiceImpl implements
        GroupManageService {
	
	/** GroupManageDAO */
    @Resource(name="groupManageDAO")
    private GroupManageDAO groupManageDAO;
    
    public String subGroupSeq(GroupSearchVO groupSearchVO) throws Exception {
		int i = 1;
		String strTemp = groupSearchVO.getGroupSearchSeq() + ",";
		String[] arrTemp = new String[]{groupSearchVO.getGroupSearchSeq()};
		groupSearchVO.setArrGroupSeq(arrTemp);
		List groupSeq = null;
		while (i > 0){
    		groupSeq = groupManageDAO.subGroupSeq(groupSearchVO);
    		if(groupSeq.size() != 0){
	    		arrTemp = new String[groupSeq.size()];
	    		for (int j=0; j<arrTemp.length; j++){
	    			Map model = (Map)groupSeq.get(j);
	    			arrTemp[j] = Integer.toString((Integer)model.get("id"));
	    			strTemp += Integer.toString((Integer)model.get("id")) + ",";
	    		}
	    		groupSearchVO.setArrGroupSeq(arrTemp);
    		}else{
    			i = 0;
    			strTemp = strTemp.substring(0, strTemp.length()-1);
    		}
		}
        return strTemp;
    }
    
    


    
    /**
	 * 사용자의 부모조직 정보를 조회한다.
	*/
    public String selectParentGroup(String seq) throws Exception {
    	
    	String parentGroup = groupManageDAO.selectParentGroup(seq);
        return parentGroup;
    } 
    
    /**
	 * 조직도를 Select한다.
	 */
    public List selectGroupTreeList(GroupSearchVO groupSearchVO) throws Exception {
    	if(groupSearchVO.getGroupScope().equals("own")){
    		String[] arrTemp = new String[1];
    		arrTemp[0] = groupSearchVO.getGroupSeq();
    		groupSearchVO.setArrGroupSeq(arrTemp);
    	}else if(!groupSearchVO.getGroupSearchSeq().equals("") || !groupSearchVO.getGroupScope().equals("all")){
    		String strTemp = subGroupSeq(groupSearchVO);
    		String[] arrTemp = strTemp.split(",");
    		groupSearchVO.setArrGroupSeq(arrTemp);
    	}
    	List resultList = groupManageDAO.selectGroupTreeList(groupSearchVO);
        if (resultList == null)
            throw processException("info.nodata.msg");
        return resultList;
    }
    
    /**
	 * 조직도의 플러스 버튼을 눌러서 하위 조직 조회.
	 */
	public List selectGroupTreeSeq(String strSeq) throws Exception{
    	List resultList = groupManageDAO.selectGroupTreeSeq(strSeq);
        if (resultList == null)
            throw processException("info.nodata.msg");
        return resultList;
    }
	
	/**
	 * 센터관리 리스트를 조회한다.
	*/
    public List selectGroupList(GroupSearchVO groupSearchVO) throws Exception {
    	List groupList = groupManageDAO.selectGroupList(groupSearchVO);
        if (groupList == null)
            throw processException("info.nodata.msg");
        return groupList;
    }
    
    /**
	 * 센터관리 상세정보를 조회한다.
	*/
    public List selectGroupDetail(GroupSearchVO groupSearchVO) throws Exception {
    	List groupDetail = groupManageDAO.selectGroupDetail(groupSearchVO);
        if (groupDetail == null)
            throw processException("info.nodata.msg");
        return groupDetail;
    }
    
    /**
	 * 센터관리 상세정보를 조회한다.
	*/
    public List selectGroupUpper(GroupSearchVO groupSearchVO) throws Exception {
    	List groupUpper = groupManageDAO.selectGroupUpper(groupSearchVO);
        if (groupUpper == null)
            throw processException("info.nodata.msg");
        return groupUpper;
    }

    /**
	 * 녹취리스트 총 갯수를 조회한다.
	 */
    public int selectGroupListTotCnt(GroupSearchVO groupSearchVO) {
    	return groupManageDAO.selectGroupListTotCnt(groupSearchVO);
    }
    
    public int insertGroup(GroupSearchVO groupSearchVO)throws Exception{
    	return groupManageDAO.insertGroup(groupSearchVO);
	}
    
    /**
     * 센터관리 Update
     */
    public int updateGroup(GroupSearchVO groupSearchVO) throws Exception {
    	// 라이선스 수량 처리로직
        return groupManageDAO.updateGroup(groupSearchVO);
    }
}
