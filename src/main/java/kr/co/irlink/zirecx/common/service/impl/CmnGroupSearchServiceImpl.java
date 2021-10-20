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
package kr.co.irlink.zirecx.common.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.irlink.zirecx.common.service.CmnGroupSearchService;
import kr.co.irlink.zirecx.common.service.CmnGroupSearchVO;
import kr.co.irlink.zirecx.common.service.CmnPrivateVO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;


@Service("cmnGroupSearchService")
public class CmnGroupSearchServiceImpl extends AbstractServiceImpl implements
        CmnGroupSearchService {
	
	/** GroupPopDAO */
    @Resource(name="cmnGroupSearchDAO")
    private CmnGroupSearchDAO cmnGroupSearchDAO;
    
    public String subGroupSeq(CmnGroupSearchVO cmnGroupSearchVO) throws Exception {
		int i = 1;
		String strTemp = cmnGroupSearchVO.getGroupSearchSeq() + ",";
		String[] arrTemp = new String[]{cmnGroupSearchVO.getGroupSearchSeq()};
		cmnGroupSearchVO.setArrGroupSeq(arrTemp);
		List groupSeq = null;
		while (i > 0){
    		groupSeq = cmnGroupSearchDAO.subGroupSeq(cmnGroupSearchVO);
    		if(groupSeq.size() != 0){
	    		arrTemp = new String[groupSeq.size()];
	    		for (int j=0; j<arrTemp.length; j++){
	    			Map model = (Map)groupSeq.get(j);
	    			arrTemp[j] = Integer.toString((Integer)model.get("id"));
	    			strTemp += Integer.toString((Integer)model.get("id")) + ",";
	    		}
	    		cmnGroupSearchVO.setArrGroupSeq(arrTemp);
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
    	
    	String parentGroup = cmnGroupSearchDAO.selectParentGroup(seq);
        return parentGroup;
    } 
    
    /**
	 * 조직도를 Select한다.
	 */
    public List selectGroupTreeList(CmnGroupSearchVO cmnGroupSearchVO) throws Exception {
    	if(cmnGroupSearchVO.getGroupScope().equals("own")){
    		String[] arrTemp = new String[1];
    		arrTemp[0] = cmnGroupSearchVO.getGroupSearchSeq();
    		cmnGroupSearchVO.setArrGroupSeq(arrTemp);
    	} else if(cmnGroupSearchVO.getGroupScope().equals("group")){
    		String strTemp = subGroupSeq(cmnGroupSearchVO);
    		String[] arrTemp = strTemp.split(",");
    		cmnGroupSearchVO.setArrGroupSeq(arrTemp);
    	}
    	/** 김해동 테스트 */
    	else if(cmnGroupSearchVO.getGroupScope().equals("groupUp")){
			String strParentGroupId = cmnGroupSearchDAO.selectParentGroupId(cmnGroupSearchVO);
			cmnGroupSearchVO.setGroupSearchSeq(strParentGroupId);
    		String strTemp = subGroupSeq(cmnGroupSearchVO);
    		String[] arrTemp = strTemp.split(",");
    		cmnGroupSearchVO.setArrGroupSeq(arrTemp);
    	}
    	
    	List resultList = cmnGroupSearchDAO.selectGroupTreeList(cmnGroupSearchVO);
        if (resultList == null)
            throw processException("info.nodata.msg");
        return resultList;
    }
    
    public List selectGroupUserTreeList(CmnGroupSearchVO cmnGroupSearchVO) throws Exception {
    	if(cmnGroupSearchVO.getGroupScope().equals("own")){
    		String[] arrTemp = new String[1];
    		arrTemp[0] = cmnGroupSearchVO.getGroupSearchSeq();
    		cmnGroupSearchVO.setArrGroupSeq(arrTemp);
    	} 
    	/** 김해동 테스트 groupUp 제거  */
    	else if(cmnGroupSearchVO.getGroupScope().equals("group")){
    		
    		String strTemp = subGroupSeq(cmnGroupSearchVO);
    		String[] arrTemp = strTemp.split(",");
    		cmnGroupSearchVO.setArrGroupSeq(arrTemp);
    	}
    	
    	List resultList = cmnGroupSearchDAO.selectGroupTreeList(cmnGroupSearchVO);
        if (resultList == null)
            throw processException("info.nodata.msg");
        return resultList;
    }
    
    /**
	 * 조직도의 플러스 버튼을 눌러서 하위 조직 조회.
	 */
	public List selectGroupTreeSeq(String strSeq) throws Exception{
    	List resultList = cmnGroupSearchDAO.selectGroupTreeSeq(strSeq);
        if (resultList == null)
            throw processException("info.nodata.msg");
        return resultList;
    }
    
	public List selectGroupCheck(CmnGroupSearchVO cmnGroupSearchVO){
    	return cmnGroupSearchDAO.selectGroupCheck(cmnGroupSearchVO);
	}
	
	public List selectGroupList(CmnGroupSearchVO cmnGroupSearchVO){
    	return cmnGroupSearchDAO.selectGroupList(cmnGroupSearchVO);
	}
	
	 /**
	 * 제일 하위 조직인지 체크 한다.(실시간 모니터링 부하를 줄이기 위해)
	 */
    public int checkGroupToCnt(String seq) throws Exception {
    	int parentGroup = cmnGroupSearchDAO.checkGroupToCnt(seq);
        return parentGroup;
    } 
}
