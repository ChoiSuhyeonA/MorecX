package kr.co.irlink.zirecx.smart.service.impl;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import java.util.List;
import javax.annotation.Resource;

import kr.co.irlink.zirecx.common.service.CmnUserSearchVO;
import kr.co.irlink.zirecx.smart.service.SmartPhoneManageService;
import kr.co.irlink.zirecx.smart.service.SmartPhoneSearchVO;
import org.springframework.stereotype.Service;

@Service("smartPhoneManageService")
public class SmartPhoneManageServiceImpl extends AbstractServiceImpl implements SmartPhoneManageService {
  
	@Resource(name = "smartPhoneManageDAO")
    private SmartPhoneManageDAO smartPhoneManageDAO;

    public List selectSmartPhoneList(SmartPhoneSearchVO vo) throws Exception {
        List smartPhoneList = smartPhoneManageDAO.selectSmartPhoneList(vo);
        if (smartPhoneList == null) {
            throw processException("info.nodata.msg");
        } else {
            return smartPhoneList;
        }
    }

    public List selectSmartPhoneDetail(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception {
        List userList = smartPhoneManageDAO.selectSmartPhoneDetail(smartPhoneSearchVO);
        if (userList == null) {
            throw processException("info.nodata.msg");
        } else {
            return userList;
        }
    }

    public int updateSmartPhone(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception {
        int result = smartPhoneManageDAO.updateSmartPhone(smartPhoneSearchVO);
        return result;
    }

    public int updateAdminSmartPhone(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception {
        int result = smartPhoneManageDAO.updateAdminSmartPhone(smartPhoneSearchVO);
        return result;
    }

    public int insertSmartPhone(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception {
        int result = smartPhoneManageDAO.insertSmartPhone(smartPhoneSearchVO);
        return result;
    }

    public int selectSmartPhoneCnt(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception {
        return smartPhoneManageDAO.selectSmartPhoneCnt(smartPhoneSearchVO);
    }
    
	//스마트폰 유저 리스트 
    public List selectSmartPhoneUserList(final CmnUserSearchVO cmnUserSearchVO) throws Exception {
        final List userPopList = smartPhoneManageDAO.selectSmartPhoneUserList(cmnUserSearchVO);
        if (userPopList == null) {
            throw processException("info.nodata.msg");
        }
        return userPopList;
    }

    //스마트폰 엑셀 리스트 
	public List selectSmartPhoneExcelList(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception {
		return smartPhoneManageDAO.selectSmartPhoneManageExcelList(smartPhoneSearchVO);
	}
    
    
}
