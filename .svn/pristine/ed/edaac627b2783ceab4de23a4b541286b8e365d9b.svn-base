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

import kr.co.irlink.zirecx.record.service.RecordPenVO;
import kr.co.irlink.zirecx.zigate.service.ZigateVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("zigateDAO")
public class ZigateDAO extends EgovAbstractDAO {
	
	public int allCallInfoInsert(ZigateVO zigateVO) {
		return (Integer) insert("zigateDAO.allCallInfoInsert",zigateVO);
	}
	 
	public int faceCallInfoInsert(RecordPenVO recordPenVO) throws Exception{
		return (Integer) insert("zigateDAO.faceCallInfoInsert",recordPenVO);
	}
	
	public String selectGroupNamePath(ZigateVO zigateVO) throws Exception {
		return (String) selectByPk("zigateDAO.selectGroupNamePath", zigateVO);
	}
	
	public String selectUserId(ZigateVO zigateVO) throws Exception {
		return (String) selectByPk("zigateDAO.selectUserId", zigateVO);
	}
	
	public String selectUserId2(ZigateVO zigateVO) throws Exception {
		return (String) selectByPk("zigateDAO.selectUserId2", zigateVO);
	}
	
	public int allCallInfoUpdate(ZigateVO zigateVO) throws Exception{
		return (Integer) update("zigateDAO.allCallInfoUpdate", zigateVO);
	}
	
	public ZigateVO getInitInfo(ZigateVO zigateVO) throws Exception{
		return (ZigateVO) selectByPk("zigateDAO.getInitInfo", zigateVO);
	}
	
	public ZigateVO getLogin(ZigateVO zigateVO) throws Exception{
		return (ZigateVO) selectByPk("zigateDAO.getLogin", zigateVO);
	}
	
	public int userHistoryInsert(ZigateVO zigateVO) throws Exception{
		return (Integer) update("zigateDAO.userHistoryInsertOld",zigateVO);
	}
	
	public int userUpdate(ZigateVO zigateVO) throws Exception{
		return (Integer) update("zigateDAO.userUpdate", zigateVO);
	}
	
	public ZigateVO getTime(ZigateVO zigateVO) throws Exception{
		return (ZigateVO) selectByPk("zigateDAO.getTime", zigateVO);
	}
	
	public ZigateVO getVersion(ZigateVO zigateVO) throws Exception{
		return (ZigateVO) selectByPk("zigateDAO.getVersion", zigateVO);
	}
	
	public int selectUserLoginFirst(ZigateVO zigateVO) throws Exception{
		return (Integer) selectByPk("zigateDAO.selectUserLoginFirst", zigateVO);
	}
	
	public int setStatus(ZigateVO zigateVO) throws Exception{
		return update("zigateDAO.userHistoryInsert",zigateVO);
	}
}
