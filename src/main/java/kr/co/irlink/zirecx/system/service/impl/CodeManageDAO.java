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

import kr.co.irlink.zirecx.system.service.CodeSearchVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("codeManageDAO")
public class CodeManageDAO extends EgovAbstractDAO {
	/**
  	 * 마스터코드 리스트를 가져온다.
  	 */
    public List selectCodeMasterList(CodeSearchVO codeSearchVO) throws Exception {
        return list("codeManageDAO.selectCodeMasterList", codeSearchVO);
        		
    }
    
    /**
  	 * 상세코드 리스트를 가져온다.
  	 */
    public List selectCodeDetailList(CodeSearchVO codeSearchVO) throws Exception {
        return list("codeManageDAO.selectCodeDetailList", codeSearchVO);
        		
    }
    
    /**
  	 * 마스터코드를 수정한다.
  	 */
    public int updateCodeManageMaster(CodeSearchVO codeSearchVO) throws Exception {
        return update("codeManageDAO.updateCodeManageMaster", codeSearchVO);
    }
    
    /**
  	 * 마스터코드를 저장한다.
  	 */
    public int insertCodeManageMaster(CodeSearchVO codeSearchVO) throws Exception {
        return update("codeManageDAO.insertCodeManageMaster", codeSearchVO);
    }
    
    /**
  	 * 상세코드를 수정한다.
  	 */
    public int updateCodeManageDetail(CodeSearchVO codeSearchVO) throws Exception {
        return update("codeManageDAO.updateCodeManageDetail", codeSearchVO);
    }
    
    /**
  	 * 상세코드를 저장한다.
  	 */
    public int insertCodeManageDetail(CodeSearchVO codeSearchVO) throws Exception {
        return update("codeManageDAO.insertCodeManageDetail", codeSearchVO);
    }
}
