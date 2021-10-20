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
package kr.co.irlink.zirecx.record.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import kr.co.irlink.zirecx.record.service.RecordEditVO;
import kr.co.irlink.zirecx.record.service.RecordManageService;
import kr.co.irlink.zirecx.record.service.RecordPenVO;
import kr.co.irlink.zirecx.record.service.RecordSearchVO;


@Service("recordManageService")
public class RecordManageServiceImpl extends AbstractServiceImpl implements
        RecordManageService {
	
	/** RecordManageDAO */
    @Resource(name="recordManageDAO")
    private RecordManageDAO recordManageDAO;
    
	/**
	 * 녹취리스트를 조회한다.
	*/
    public List selectRecordList(RecordSearchVO recordSearchVO) throws Exception {
    	List recordList = recordManageDAO.selectRecordList(recordSearchVO);
        if (recordList == null)
            throw processException("info.nodata.msg");
        return recordList;
    }
    
    /**
	 * 녹취연동리스트를 조회한다.
	*/
    public List<RecordSearchVO> selectLinkCallList(RecordSearchVO recordSearchVO) throws Exception {
    	List<RecordSearchVO> linkCallList = recordManageDAO.selectLinkCallList(recordSearchVO);
        if (linkCallList == null)
            throw processException("info.nodata.msg");
        return linkCallList;
    }
    
    /**
     * 펜녹취리스트를 조회한다.
    */
      public List<RecordPenVO> selectLinkPenCallList(RecordPenVO recordPenVO) throws Exception {
        List<RecordPenVO> linkPenCallList = recordManageDAO.selectLinkPenCallList(recordPenVO);
          if (linkPenCallList == null)
              throw processException("info.nodata.msg");
          return linkPenCallList;
      }

    /**
	 * 녹취리스트 총 갯수를 조회한다.
	 */
    public int selectRecordListTotCnt(RecordSearchVO recordSearchVO) {
    	return recordManageDAO.selectRecordListTotCnt(recordSearchVO);
    }
    
    /**
	 * 녹취연동리스트 총 갯수를 조회한다.
	 */
    public int selectLinkCallListTotCnt(RecordSearchVO recordSearchVO) {
    	return recordManageDAO.selectLinkCallListTotCnt(recordSearchVO);
    }

    /**
     * 펜녹취연동리스트 총 갯수를 조회한다.
     */
    public int selectLinkPenCallListTotCnt(RecordPenVO recordPenVO) {
      return recordManageDAO.selectLinkPenCallListTotCnt(recordPenVO);
    }
    
	/**
	 * Excel로 변환할 체크된 녹취리스트를 조회한다.
	 */
    public List selectCheckRecordExcelList(RecordSearchVO recordSearchVO) throws Exception {
    	List recordList = recordManageDAO.selectCheckRecordExcelList(recordSearchVO);
        if (recordList == null)
            throw processException("info.nodata.msg");
        return recordList;
    }
    
    /**
	 * Excel로 변환할 체크된 연동형리스트를 조회한다.
	 */
    public List selectCheckLinkCallExcelList(RecordSearchVO recordSearchVO) throws Exception {
    	List linkCallList = recordManageDAO.selectCheckLinkCallExcelList(recordSearchVO);
        if (linkCallList == null)
            throw processException("info.nodata.msg");
        return linkCallList;
    }
    
    
    /**
     * Excel로 변환할 체크된 펜녹취리스트를 조회한다.
     */
    public List selectCheckPenCallExcelList(RecordPenVO recordPenVO) throws Exception {
    	List PenCallList = recordManageDAO.selectCheckPenCallExcelList(recordPenVO);
        if (PenCallList == null)
            throw processException("info.nodata.msg");
        return PenCallList;
	}

	/**
	 * Excel로 변환할 체크된 굿콜리스트를 조회한다.
	 */
    public List selectCheckGoodCallExcelList(RecordSearchVO recordSearchVO) throws Exception {
    	List goodCallList = recordManageDAO.selectCheckGoodCallExcelList(recordSearchVO);
        if (goodCallList == null)
            throw processException("info.nodata.msg");
        return goodCallList;
    }
    
    /**
	 * 굿콜을 등록한다.
	 */
    public int insertGoodCall(RecordSearchVO recordSearchVO)throws Exception{
    	return recordManageDAO.insertGoodCall(recordSearchVO);
	}
    
    /**
   	 * 굿콜을 삭제한다.
   	 */
    public int removeGoodCall(RecordSearchVO recordSearchVO)throws Exception {
    	return recordManageDAO.removeGoodCall(recordSearchVO);
    }
    
    /**
	 * 파일 다운 리스트를 조회한다.
	 */
    public List<RecordSearchVO> fileDownload(RecordSearchVO recordSearchVO) throws Exception {
    	List<RecordSearchVO> fileDownloadList = recordManageDAO.fileDownload(recordSearchVO);
        if (fileDownloadList == null)
            throw processException("info.nodata.msg");
        return fileDownloadList;
    }
    
    /**
	 * 연동형 파일 다운 리스트를 조회한다.
	 */
    public List<RecordSearchVO> linkCallFileDownload(RecordSearchVO recordSearchVO) throws Exception {
    	List<RecordSearchVO> linkCallFileDownloadList = recordManageDAO.linkCallFileDownload(recordSearchVO);
        if (linkCallFileDownloadList == null)
            throw processException("info.nodata.msg");
        return linkCallFileDownloadList;
    }
    
    /**
	 * 굿콜 파일 다운 리스트를 조회한다.
	 */
    public List<RecordSearchVO> goodCallFileDownload(RecordSearchVO recordSearchVO) throws Exception {
    	List<RecordSearchVO> goodCallFileDownloadList = recordManageDAO.goodCallFileDownload(recordSearchVO);
        if (goodCallFileDownloadList == null)
            throw processException("info.nodata.msg");
        return goodCallFileDownloadList;
    }
    
    /**
	 * 펜 녹취 파일 다운 리스트를 조회한다.
	 */
    public List<RecordSearchVO> fileDownloadPen(RecordPenVO recordPenVO) throws Exception {
    	List<RecordSearchVO> fileDownloadList = recordManageDAO.fileDownloadPen(recordPenVO);
        if (fileDownloadList == null)
            throw processException("info.nodata.msg");
        return fileDownloadList;
    }
    
    /**
	 * web path를 조회한다.
	 */
    public List<RecordSearchVO> selectWebPath(RecordSearchVO recordSearchVO) throws Exception {
    	List<RecordSearchVO> webPathList = recordManageDAO.selectWebPath(recordSearchVO);
        if (webPathList == null)
            throw processException("info.nodata.msg");
        return webPathList;
    }
    
    /**
     * web path를 조회한다.
     */
      public List<RecordPenVO> selectWebPathPen(RecordPenVO recordPenVO) throws Exception {
        List<RecordPenVO> webPathList = recordManageDAO.selectWebPathPen(recordPenVO);
          if (webPathList == null)
              throw processException("info.nodata.msg");
          return webPathList;
      }
    
    /**
	 * 상담결과 리스트를 조회한다.
	*/
    public List selectCallresult(RecordSearchVO recordSearchVO) throws Exception {
    	List callresultList = recordManageDAO.selectCallresult(recordSearchVO);
        if (callresultList == null)
            throw processException("info.nodata.msg");
        return callresultList;
    }
    
    /**
     * 상담결과 리스트를 조회한다.
    */
      public List selectPenCallresult(RecordPenVO recordPenVO) throws Exception {
        List callresultList = recordManageDAO.selectPenCallresult(recordPenVO);
          if (callresultList == null)
              throw processException("info.nodata.msg");
          return callresultList;
      }
    
    public int updateMemo(RecordEditVO recordEditVO) throws Exception{
    	return recordManageDAO.updateMemo(recordEditVO);
    }
    
    public int insertDownHist(RecordSearchVO recordSearchVO) throws Exception {
    	return recordManageDAO.insertDownHist(recordSearchVO);
    }
    
    public List<RecordSearchVO> selectCallHistoryList(RecordSearchVO recordSearchVO) throws Exception {
    	List<RecordSearchVO> callHistoryList = recordManageDAO.selectCallHistoryList(recordSearchVO);
        if (callHistoryList == null)
            throw processException("info.nodata.msg");
        return callHistoryList;
    }
    
    public int selectCallHistoryListTotCnt(RecordSearchVO recordSearchVO) {
    	return recordManageDAO.selectCallHistoryListTotCnt(recordSearchVO);
    }
    
    public int insertPenCallInfo(RecordPenVO recordPenVO) throws Exception{
      return recordManageDAO.insertPenCallInfo(recordPenVO);
    }
}