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

import kr.co.irlink.zirecx.record.service.RecordPenVO;
import kr.co.irlink.zirecx.record.service.RecordSearchVO;
import kr.co.irlink.zirecx.record.service.RecordEditVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("recordManageDAO")
public class RecordManageDAO extends EgovAbstractDAO {

	/**
	 * 녹취리스트를 조회한다.
	 */
    public List selectRecordList(RecordSearchVO recordSearchVO) throws Exception {
    	if(recordSearchVO.getOrderField().equals("ordertime")) {
    		if(recordSearchVO.getOrderType().equals("ASC")) {
    			recordSearchVO.setOrderString("ORDER BY ordertime ASC");
    		} else if(recordSearchVO.getOrderType().equals("DESC")) {
    			recordSearchVO.setOrderString("ORDER BY ordertime DESC");
    		}
    	} else if(recordSearchVO.getOrderField().equals("ordertime")) {
    		if(recordSearchVO.getOrderType().equals("ASC")) {
    			recordSearchVO.setOrderString("ORDER BY duration ASC");
    		} else if(recordSearchVO.getOrderType().equals("DESC")) {
    			recordSearchVO.setOrderString("ORDER BY duration DESC");
    		}
    	}
        return list("recordManageDAO.selectRecordList", recordSearchVO);
    }
    
    /**
	 * 녹취연동리스트를 조회한다.
	 */
    public List<RecordSearchVO> selectLinkCallList(RecordSearchVO recordSearchVO) throws Exception {
    	if(recordSearchVO.getOrderField().equals("")) {
    		recordSearchVO.setOrderString("ORDER BY callStartDate DESC, call_start_time DESC");
    	} else {
    		if(recordSearchVO.getOrderField().equals("campaignName")) {
    			if(recordSearchVO.getOrderType().equals("ASC")) {
    				recordSearchVO.setOrderString("ORDER BY campaign_name ASC");
    			} else if(recordSearchVO.getOrderType().equals("DESC")) {
    				recordSearchVO.setOrderString("ORDER BY campaign_name DESC");
    			}
    			
    		} else if(recordSearchVO.getOrderField().equals("callStartTime")) {
    			if(recordSearchVO.getOrderType().equals("ASC")) {
    				recordSearchVO.setOrderString("ORDER by callStartDate ASC, call_start_time ASC");
    			} else if(recordSearchVO.getOrderType().equals("DESC")) {
    				recordSearchVO.setOrderString("ORDER by callStartDate DESC, call_start_time DESC");
    			}
    			
    		} else if(recordSearchVO.getOrderField().equals("callEndTime")) {
    			if(recordSearchVO.getOrderType().equals("ASC")) {
    				recordSearchVO.setOrderString("ORDER by callStartDate ASC, call_end_time ASC");
    			} else if(recordSearchVO.getOrderType().equals("DESC")) {
    				recordSearchVO.setOrderString("ORDER by callStartDate DESC, call_end_time DESC");
    			}
    			
    		} else if(recordSearchVO.getOrderField().equals("durationCall")) {
    			if(recordSearchVO.getOrderType().equals("ASC")) {
    				recordSearchVO.setOrderString("ORDER BY duration_call ASC");
    			} else if(recordSearchVO.getOrderType().equals("DESC")) {
    				recordSearchVO.setOrderString("ORDER BY duration_call DESC");
    			}
    			
    		} else if(recordSearchVO.getOrderField().equals("durationTalk")) {
    			if(recordSearchVO.getOrderType().equals("ASC")) {
    				recordSearchVO.setOrderString("ORDER BY duration_talk ASC");
    			} else if(recordSearchVO.getOrderType().equals("DESC")) {
    				recordSearchVO.setOrderString("ORDER BY duration_talk DESC");
    			}
    			
    		}
    	}
    	
        return list("recordManageDAO.selectLinkCallList", recordSearchVO);
    }
    
    /**
     * 녹취연동리스트를 조회한다.
     */
      public List<RecordPenVO> selectLinkPenCallList(RecordPenVO recordPenVO) throws Exception {
        if(recordPenVO.getOrderField().equals("")) {
          recordPenVO.setOrderString("ORDER BY upload_date DESC");
        } else {
          if(recordPenVO.getOrderField().equals("playTime")) {
            if(recordPenVO.getOrderType().equals("ASC")) {
              recordPenVO.setOrderString("ORDER BY play_time ASC");
            } else if(recordPenVO.getOrderType().equals("DESC")) {
              recordPenVO.setOrderString("ORDER BY play_time DESC");
            }
          }
        }
        
        return list("recordManageDAO.selectLinkPenCallList", recordPenVO);
      }

    /**
	 * 녹취리스트 총 갯수를 조회한다.
	 */
    public int selectRecordListTotCnt(RecordSearchVO recordSearchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("recordManageDAO.selectRecordListTotCnt", recordSearchVO);
    }
    
    /**
	 * 녹취연동리스트 총 갯수를 조회한다.
	 */
    public int selectLinkCallListTotCnt(RecordSearchVO recordSearchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("recordManageDAO.selectLinkCallListTotCnt", recordSearchVO);
    }
    
    /**
     * 녹취연동리스트 총 갯수를 조회한다.
     */
    public int selectLinkPenCallListTotCnt(RecordPenVO recordPenVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("recordManageDAO.selectLinkPenCallListTotCnt", recordPenVO);
    }

	/**
	 * Excel로 변환할 체크된 녹취리스트를 조회한다.
	 */
    public List selectCheckRecordExcelList(RecordSearchVO recordSearchVO) throws Exception {
        return list("recordManageDAO.selectCheckRecordExcelList", recordSearchVO);
    }
    
    /**
	 * Excel로 변환할 체크된 연동형리스트를 조회한다.
	 */
    public List selectCheckLinkCallExcelList(RecordSearchVO recordSearchVO) throws Exception {
        return list("recordManageDAO.selectCheckLinkCallExcelList", recordSearchVO);
    }
    
    /**
	 * Excel로 변환할 체크된 펜녹취리스트를 조회한다.
	 */
    public List selectCheckPenCallExcelList(RecordPenVO recordPenVO) throws Exception {
    	
    	 if(recordPenVO.getOrderField().equals("")) {
             recordPenVO.setOrderString("ORDER BY upload_date DESC");
           }
    	 
        return list("recordManageDAO.selectCheckPenCallExcelList", recordPenVO);
    }
    
   
    /**
	 * Excel로 변환할 체크된 굿콜리스트를 조회한다.
	 */
    public List selectCheckGoodCallExcelList(RecordSearchVO recordSearchVO) throws Exception {
        return list("recordManageDAO.selectCheckGoodCallExcelList", recordSearchVO);
    }
    
    /**
	 * 굿콜을 등록한다.
	 */
    public int insertGoodCall(RecordSearchVO recordSearchVO)throws Exception{    	
		return update("recordManageDAO.insertGoodCall", recordSearchVO);
	}
    
    /**
	 * 굿콜을 삭제한다.
	 */
    public int removeGoodCall(RecordSearchVO recordSearchVO)throws Exception {
        return (int)delete("recordManageDAO.removeGoodCall", recordSearchVO);
    }
    
    /**
	 * 파일 다운 리스트를 조회한다.
	 */
    public List<RecordSearchVO> fileDownload(RecordSearchVO recordSearchVO) throws Exception {
        return list("recordManageDAO.fileDownload", recordSearchVO);
    }
    
    /**
	 * 연동형 파일 다운 리스트를 조회한다.
	 */
    public List<RecordSearchVO> linkCallFileDownload(RecordSearchVO recordSearchVO) throws Exception {
        return list("recordManageDAO.linkCallFileDownload", recordSearchVO);
    }
    
    /**
	 * 굿콜 파일 다운 리스트를 조회한다.
	 */
    public List<RecordSearchVO> goodCallFileDownload(RecordSearchVO recordSearchVO) throws Exception {
        return list("recordManageDAO.goodCallFileDownload", recordSearchVO);
    }
    
    /**
   	 * 펜 녹취 파일 다운 리스트를 조회한다.
   	 */
       public List<RecordSearchVO> fileDownloadPen(RecordPenVO recordPenVO) throws Exception {
           return list("recordManageDAO.fileDownloadPen", recordPenVO);
       }
    
    /**
	 * web path를 조회한다.
	 */
    public List<RecordSearchVO> selectWebPath(RecordSearchVO recordSearchVO) throws Exception {
        return list("recordManageDAO.selectWebPath", recordSearchVO);
    }
    
    /**
     * web path를 조회한다.
     */
      public List<RecordPenVO> selectWebPathPen(RecordPenVO recordPenVO) throws Exception {
          return list("recordManageDAO.selectWebPathPen", recordPenVO);
      }
    
    /**
	 * 상담결과 리스트를 조회한다.
	 */
    public List selectCallresult(RecordSearchVO recordSearchVO) throws Exception {
        return list("recordManageDAO.selectCallresult", recordSearchVO);
    }
    
    /**
     * 상담결과 리스트를 조회한다.
     */
    public List selectPenCallresult(RecordPenVO recordPenVO) throws Exception {
        return list("recordManageDAO.selectPenCallresult", recordPenVO);
    }
    
    public int updateMemo(RecordEditVO recordEditVO)throws Exception{    	
		return update("recordManageDAO.updateMemo", recordEditVO);
	}
    
    public int insertDownHist(RecordSearchVO recordSearchVO) throws Exception {
    	return (Integer) insert("recordManageDAO.insertDownHist", recordSearchVO);
    }
    
    public List<RecordSearchVO> selectCallHistoryList(RecordSearchVO recordSearchVO) throws Exception {
    	recordSearchVO.setOrderString("ORDER BY downDateTime DESC");
        return list("recordManageDAO.selectCallHistoryList", recordSearchVO);
    }
    
    public int selectCallHistoryListTotCnt(RecordSearchVO recordSearchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("recordManageDAO.selectCallHistoryListTotCnt", recordSearchVO);
    }
    
    public int insertPenCallInfo(RecordPenVO recordPenVO) {
      return update("recordManageDAO.insertPenCallInfo", recordPenVO);
    }
}