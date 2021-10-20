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
package kr.co.irlink.zirecx.common.service;

import java.util.List;

public interface CmnGroupSearchService {
	
    /**
	 * 하위조직 코드를 가져온다.
	 */
    String subGroupSeq(CmnGroupSearchVO cmnGroupSearchVO) throws Exception;
    /**
	 * 사용자의 부모조직을 가져온다.
	 */
    String selectParentGroup(String seq) throws Exception;
    
    /**
	 * 조직도 조회.
	 */
	List selectGroupTreeList(CmnGroupSearchVO cmnGroupSearchVO) throws Exception;
	
	List selectGroupUserTreeList(CmnGroupSearchVO cmnGroupSearchVO) throws Exception;
	
	/**
	 * 조직도의 플러스 버튼을 눌러서 하위 조직 조회.
	 */
	List selectGroupTreeSeq(String strSeq) throws Exception;
	
	
	List selectGroupCheck(CmnGroupSearchVO cmnGroupSearchVO) throws Exception;
	
	List selectGroupList(CmnGroupSearchVO cmnGroupSearchVO) throws Exception;
	
	/**
	 * 제일 하위 조직인지 체크 한다.(실시간 모니터링 부하를 줄이기 위해)
	 */
    int checkGroupToCnt(String seq) throws Exception;
    
}