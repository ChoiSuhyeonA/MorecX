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

import kr.co.irlink.zirecx.system.service.CodeManageService;
import kr.co.irlink.zirecx.system.service.CodeSearchVO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("codeManageService")
public class CodeManageServiceImpl extends AbstractServiceImpl implements
		CodeManageService {
	
	/** CodeManageDAO */
    @Resource(name="codeManageDAO")
    private CodeManageDAO codeManageDAO;
    
	/**
	 * 마스터코드 조회.
	 */
	public List selectCodeMasterList(CodeSearchVO codeSearchVO) throws Exception{
		List codeMasterList = codeManageDAO.selectCodeMasterList(codeSearchVO);
        if (codeMasterList == null)
            throw processException("info.nodata.msg");
        return codeMasterList;
	}
	
	/**
	 * 상세코드 조회.
	 */
	public List selectCodeDetailList(CodeSearchVO codeSearchVO) throws Exception{
		List codeDetailList = codeManageDAO.selectCodeDetailList(codeSearchVO);
        if (codeDetailList == null)
            throw processException("info.nodata.msg");
        return codeDetailList;
	}
	
	/**
	 * 마스터코드 수정.
	 */
	public int updateCodeManageMaster(CodeSearchVO codeSearchVO) throws Exception{
		return codeManageDAO.updateCodeManageMaster(codeSearchVO);
	}
	
	/**
	 * 마스터코드 저장.
	 */
	public int insertCodeManageMaster(CodeSearchVO codeSearchVO) throws Exception{
		return codeManageDAO.insertCodeManageMaster(codeSearchVO);
	}
	
	/**
	 * 상세코드 수정.
	 */
	public int updateCodeManageDetail(CodeSearchVO codeSearchVO) throws Exception{
		return codeManageDAO.updateCodeManageDetail(codeSearchVO);
	}
	
	/**
	 * 상세코드 저장.
	 */
	public int insertCodeManageDetail(CodeSearchVO codeSearchVO) throws Exception{
		return codeManageDAO.insertCodeManageDetail(codeSearchVO);
	}
}
