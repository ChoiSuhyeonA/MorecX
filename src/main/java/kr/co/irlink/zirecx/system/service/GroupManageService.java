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
package kr.co.irlink.zirecx.system.service;

import java.util.List;


public interface GroupManageService {
	
    /**
	 * 하위조직 코드를 가져온다.
	 */
    String subGroupSeq(GroupSearchVO groupSearchVO) throws Exception;
    /**
	 * 사용자의 부모조직을 가져온다.
	 */
    String selectParentGroup(String seq) throws Exception;
    
    /**
	 * 조직도 조회.
	 */
	List selectGroupTreeList(GroupSearchVO vo) throws Exception;
	
	/**
	 * 조직도의 플러스 버튼을 눌러서 하위 조직 조회.
	 */
	List selectGroupTreeSeq(String strSeq) throws Exception;
	
	/**
	 * 센터관리 리스트를 조회한다.
	 */
	List selectGroupList(GroupSearchVO groupSearchVO) throws Exception;
	
	/**
	 * 센터의 상세정보를 조회한다.
	 */
	List selectGroupDetail(GroupSearchVO groupSearchVO) throws Exception;
	
	/**
	 * 센터의 상세정보를 조회한다.
	 */
	List selectGroupUpper(GroupSearchVO groupSearchVO) throws Exception;
    
    /**
	 * 센터관리 리스트 총 갯수를 조회한다.
	 */
    int selectGroupListTotCnt(GroupSearchVO groupSearchVO);
    
    int insertGroup(GroupSearchVO groupSearchVO) throws Exception;
    
    /**
	 * 센터관리 Update.
	 */
    int updateGroup(GroupSearchVO groupSearchVO) throws Exception;
    
}
