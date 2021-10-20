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
package kr.co.irlink.zirecx.zigate.service;

import kr.co.irlink.zirecx.record.service.RecordPenVO;

public interface ZigateService {
	
	int allCallInfoInsert(ZigateVO zigateVO) throws Exception;
	
	int faceCallInfoInsert(RecordPenVO recordPenVO) throws Exception;
	
	String selectGroupNamePath(ZigateVO zigateVO) throws Exception;
	
	String selectUserId(ZigateVO zigateVO) throws Exception;
	
	String selectUserId2(ZigateVO zigateVO) throws Exception;
	
	int allCallInfoUpdate(ZigateVO zigateVO) throws Exception;
	
	ZigateVO getInitInfo(ZigateVO zigateVO) throws Exception;
	
	ZigateVO getLogin(ZigateVO zigateVO) throws Exception;
	
	int userHistoryInsert(ZigateVO zigateVO) throws Exception;
	
	int userUpdate(ZigateVO zigateVO) throws Exception;
	
	ZigateVO getTime(ZigateVO zigateVO) throws Exception;
	
	ZigateVO getVersion(ZigateVO zigateVO) throws Exception;
	
	int selectUserLoginFirst(ZigateVO zigateVO) throws Exception;
	
	int setStatus(ZigateVO zigateVO) throws Exception;
}
