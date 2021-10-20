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
package kr.co.irlink.zirecx.zigate.service.impl;

import javax.annotation.Resource;

import kr.co.irlink.zirecx.record.service.RecordPenVO;
import kr.co.irlink.zirecx.zigate.service.ZigateService;
import kr.co.irlink.zirecx.zigate.service.ZigateVO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("zigateService")
public class ZigateServiceImpl extends AbstractServiceImpl implements
		ZigateService {
	
	@Resource(name="zigateDAO")
	private ZigateDAO zigateDAO;
	
	public int allCallInfoInsert(ZigateVO zigateVO)throws Exception{
		return zigateDAO.allCallInfoInsert(zigateVO);
	}
	
	public int faceCallInfoInsert(RecordPenVO recordPenVO) throws Exception{
		return zigateDAO.faceCallInfoInsert(recordPenVO);
	}
	
	public String selectGroupNamePath(ZigateVO zigateVO) throws Exception {
		return zigateDAO.selectGroupNamePath(zigateVO);
	}
	
	public String selectUserId(ZigateVO zigateVO) throws Exception {
		return zigateDAO.selectUserId(zigateVO);
	}
	
	public String selectUserId2(ZigateVO zigateVO) throws Exception {
		return zigateDAO.selectUserId2(zigateVO);
	}
	
	public int allCallInfoUpdate(ZigateVO zigateVO) throws Exception{
		return zigateDAO.allCallInfoUpdate(zigateVO);
	}
	
	public ZigateVO getInitInfo(ZigateVO zigateVO) throws Exception{
		return zigateDAO.getInitInfo(zigateVO);
	}
	
	public ZigateVO getLogin(ZigateVO zigateVO) throws Exception{
		return zigateDAO.getLogin(zigateVO);
	}
	
	public int userHistoryInsert(ZigateVO zigateVO)throws Exception{
		return zigateDAO.userHistoryInsert(zigateVO);
	}
	
	public int userUpdate(ZigateVO zigateVO) throws Exception{
		return zigateDAO.userUpdate(zigateVO);
	}
	
	public ZigateVO getTime(ZigateVO zigateVO) throws Exception{
		return zigateDAO.getTime(zigateVO);
	}
	
	public ZigateVO getVersion(ZigateVO zigateVO) throws Exception{
		return zigateDAO.getVersion(zigateVO);
	}
	
	public int selectUserLoginFirst(ZigateVO zigateVO) throws Exception{
		return zigateDAO.selectUserLoginFirst(zigateVO);
	}
	
	public int setStatus(ZigateVO zigateVO) throws Exception{
		return zigateDAO.setStatus(zigateVO);
	}
}
