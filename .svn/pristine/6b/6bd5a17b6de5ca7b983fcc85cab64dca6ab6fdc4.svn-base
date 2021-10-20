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

import kr.co.irlink.zirecx.common.service.CmnGroupSearchVO;
import kr.co.irlink.zirecx.common.service.CmnUserSearchVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;



@Repository("cmnGroupSearchDAO")
public class CmnGroupSearchDAO extends EgovAbstractDAO {

    /**
	 * 사용자의 부모조직 정보를 조회한다.
	 */
    public String selectParentGroup(String seq) throws Exception {
        return (String)getSqlMapClientTemplate().queryForObject("cmnGroupSearchDAO.selectParentGroup", seq);
    }
    
    /**
  	 * 검색 된 조직의 하위 조식 코드를 가져온다.
  	 */
    public List subGroupSeq(CmnGroupSearchVO cmnGroupSearchVO) throws Exception {
        return list("cmnGroupSearchDAO.subGroupSeq", cmnGroupSearchVO);
        		
    }
    
    /**
	 * 조직도를 Select한다.
	 */
    public List selectGroupTreeList(CmnGroupSearchVO vo) throws Exception {
        return (List) list("cmnGroupSearchDAO.selectGroupTreeList", vo);
    }
    
    /**
  	 * 조직도의 플러스 버튼을 눌러서 하위 조직 조회.
  	 */
    public List selectGroupTreeSeq(String strSeq) throws Exception {
        return (List) list("cmnGroupSearchDAO.selectGroupTreeSeq", strSeq);
    }
    
    public List selectGroupCheck(CmnGroupSearchVO cmnGroupSearchVO) {
		return list("cmnGroupSearchDAO.selectGroupCheck", cmnGroupSearchVO);
    }
    
    public List selectGroupList(CmnGroupSearchVO cmnGroupSearchVO) {
		return list("cmnGroupSearchDAO.selectGroupList", cmnGroupSearchVO);
    }
    
    /**
   	 * 제일 하위 조직인지 체크 한다.(실시간 모니터링 부하를 줄이기 위해)
   	 */
   public int checkGroupToCnt(String seq) throws Exception {
       return (Integer)getSqlMapClientTemplate().queryForObject("cmnGroupSearchDAO.checkGroupToCnt", seq);
   }
   
   public String selectParentGroupId(CmnGroupSearchVO cmnGroupSearchVO) throws Exception {
	   return (String) selectByPk("cmnGroupSearchDAO.selectParentGroupId", cmnGroupSearchVO);
   }
}