package kr.co.irlink.zirecx.smart.service;

import java.util.List;

import kr.co.irlink.zirecx.common.service.CmnUserSearchVO;

public interface SmartPhoneManageService {
    List selectSmartPhoneList(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception;

    List selectSmartPhoneDetail(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception;

    int updateSmartPhone(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception;

    int updateAdminSmartPhone(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception;

    int insertSmartPhone(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception;

    int selectSmartPhoneCnt(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception;
    
	//스마트폰 유저 검색 리스트
   	List selectSmartPhoneUserList(CmnUserSearchVO cmnUserSearchVO) throws Exception;
   	
   	List selectSmartPhoneExcelList(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception;
    
}

