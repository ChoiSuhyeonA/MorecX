package kr.co.irlink.zirecx.smart.service.impl;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import java.util.List;

import kr.co.irlink.zirecx.common.service.CmnUserSearchVO;
import kr.co.irlink.zirecx.smart.service.SmartPhoneSearchVO;
import kr.co.irlink.zirecx.util.TextUtil;
import org.springframework.stereotype.Repository;

@Repository("smartPhoneManageDAO")
public class SmartPhoneManageDAO extends EgovAbstractDAO {

    public List selectSmartPhoneList(SmartPhoneSearchVO vo) throws Exception {
        TextUtil textUtil = TextUtil.getInstance();
        String strGroupId = textUtil.validateParam(vo.getSchGroupId());
        String strDateUpdated = textUtil.validateParam(vo.getSchUserZirecxId());
        vo.setGroupId(strGroupId);
        vo.setDateUpdated(strDateUpdated);
        String groupId = "";
        String dateUpdated = "";
        if (!strGroupId.equals("") || !strDateUpdated.equals("")) {
            groupId = strGroupId;
            dateUpdated = strDateUpdated;
        }
        return list("smartPhoneManageDAO.selectSmartPhoneManageList", vo);
    }
    
    public List selectSmartPhoneManageExcelList(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception {
   	TextUtil textUtil = TextUtil.getInstance();
        String strGroupId = textUtil.validateParam(smartPhoneSearchVO.getSchGroupId());
        String strDateUpdated = textUtil.validateParam(smartPhoneSearchVO.getSchUserZirecxId());
        smartPhoneSearchVO.setGroupId(strGroupId);
        smartPhoneSearchVO.setDateUpdated(strDateUpdated);
        String groupId = "";
        String dateUpdated = "";
        if (!strGroupId.equals("") || !strDateUpdated.equals("")) {
            groupId = strGroupId;
            dateUpdated = strDateUpdated;
        }
        return list("smartPhoneManageDAO.selectSmartPhoneManageExcelList", smartPhoneSearchVO);
    }
    
    

    public List selectSmartPhoneDetail(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception {
        return list("smartPhoneManageDAO.selectSmartPhoneDetail", smartPhoneSearchVO);
    }

    public int updateSmartPhone(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception {
        int resultVal = this.update("smartPhoneManageDAO.updateSmartPhone", smartPhoneSearchVO);
        if (resultVal > 0) {
            this.insert("smartPhoneManageDAO.insertSmartPhoneHistory", smartPhoneSearchVO);
        }

        return resultVal;
    }

    public int updateAdminSmartPhone(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception {
        int resultVal = this.update("smartPhoneManageDAO.updateAdminSmartPhone", smartPhoneSearchVO);
        if (resultVal > 0) {
            this.insert("smartPhoneManageDAO.insertSmartPhoneHistory", smartPhoneSearchVO);
        }

        return resultVal;
    }

    public int insertSmartPhone(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception {
        int result = (Integer)this.insert("smartPhoneManageDAO.insertSmartPhone", smartPhoneSearchVO);
        insert("smartPhoneManageDAO.insertSmartPhoneHistory", smartPhoneSearchVO);
        return result;
    }

    public int selectSmartPhoneCnt(SmartPhoneSearchVO smartPhoneSearchVO) throws Exception {
        return (Integer)this.getSqlMapClientTemplate().queryForObject("smartPhoneManageDAO.selectSmartPhoneCnt", smartPhoneSearchVO);
    }
    
    //스마트폰 유저 리스트
    public List selectSmartPhoneUserList(final CmnUserSearchVO cmnUserSearchVO) {
        return this.list("smartPhoneManageDAO.selectSmartPhoneUserList", (Object)cmnUserSearchVO);
    }
}