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
package kr.co.irlink.zirecx.record.service;

import java.util.List;

public interface RecordManageService {
	
	/**
	 * 녹취리스트를 조회한다.
	 */
	List selectRecordList(RecordSearchVO recordSearchVO) throws Exception;
    
	/**
	 * 녹취연동리스트를 조회한다.
	 */
	List<RecordSearchVO> selectLinkCallList(RecordSearchVO recordSearchVO) throws Exception;
	
	/**
   * 펜녹취리스트를 조회한다.
   */
	List<RecordPenVO> selectLinkPenCallList(RecordPenVO recordPenVO) throws Exception;
	
    /**
	 * 녹취리스트 총 갯수를 조회한다.
	 */
    int selectRecordListTotCnt(RecordSearchVO recordSearchVO);
    
    /**
	 * 녹취연동리스트 총 갯수를 조회한다.
	 */
    int selectLinkCallListTotCnt(RecordSearchVO recordSearchVO);
    
    /**
     * 펜녹취연동리스트 총 갯수를 조회한다.
     */
    int selectLinkPenCallListTotCnt(RecordPenVO recordPenVO);

	/**
	 * Excel로 변환할 선택된 녹취리스트를 조회한다.
	 */
	
	List selectCheckRecordExcelList(RecordSearchVO recordSearchVO) throws Exception;
	
	/**
	 * Excel로 변환할 선택된 연동형리스트를 조회한다.
	 */
	
	List selectCheckLinkCallExcelList(RecordSearchVO recordSearchVO) throws Exception;
	
	/**
	 * Excel로 변환할 선택된 펜녹취리스트를 조회한다. 김해동추가 
	 */
	List selectCheckPenCallExcelList(RecordPenVO recordPenVO) throws Exception;
	
	
	/**
	 * Excel로 변환할 선택된 굿콜리스트를 조회한다.
	 */
	
	List selectCheckGoodCallExcelList(RecordSearchVO recordSearchVO) throws Exception;
	
	
	/**
	 * 굿콜을 등록한다.
	 */
    int insertGoodCall(RecordSearchVO recordSearchVO) throws Exception;
    
    /**
	 * 굿콜을 삭제한다.
	 */
    int removeGoodCall(RecordSearchVO recordSearchVO) throws Exception;
    
    /**
	 * 파일 다운 리스트를 조회한다.
	 */
	List<RecordSearchVO> fileDownload(RecordSearchVO recordSearchVO) throws Exception;
	
	/**
	 * 연동형 파일 다운 리스트를 조회한다.
	 */
	List<RecordSearchVO> linkCallFileDownload(RecordSearchVO recordSearchVO) throws Exception;
	
	/**
	 * 굿콜 파일 다운 리스트를 조회한다.
	 */
	List<RecordSearchVO> goodCallFileDownload(RecordSearchVO recordSearchVO) throws Exception;
	
	/**
	 * 펜 녹취 파일 다운 리스트를 조회한다.
	 */
	List<RecordSearchVO> fileDownloadPen(RecordPenVO recordPenVO) throws Exception;
	
	/**
	 * web path를 조회한다.
	 */
	List<RecordSearchVO> selectWebPath(RecordSearchVO recordSearchVO) throws Exception;
	
	/**
   * web path를 조회한다.
   */
  List<RecordPenVO> selectWebPathPen(RecordPenVO recordPenVO) throws Exception;
	
	/**
	 * 상담결과 리스트를 조회한다.
	 */
	List selectCallresult(RecordSearchVO recordSearchVO) throws Exception;
	
	/**
   * 상담결과 리스트를 조회한다.
   */
  List selectPenCallresult(RecordPenVO recordPenVO) throws Exception;
	
	int updateMemo(RecordEditVO recordEditVO) throws Exception;
	
	int insertDownHist(RecordSearchVO recordSearchVO) throws Exception;
	
	List<RecordSearchVO> selectCallHistoryList(RecordSearchVO recordSearchVO) throws Exception;
	
	int selectCallHistoryListTotCnt(RecordSearchVO recordSearchVO);
	
	int insertPenCallInfo(RecordPenVO recordPenVO) throws Exception;
}
