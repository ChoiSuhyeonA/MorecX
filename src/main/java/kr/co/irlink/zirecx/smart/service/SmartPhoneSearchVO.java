package kr.co.irlink.zirecx.smart.service;

import java.io.Serializable;

public class SmartPhoneSearchVO implements Serializable {
    private static final long serialVersionUID = 674326700254267991L;
    private int id;
    private String groupId;
    private String phoneNumber;
    private String imei;
    private String useStatusFlag;
    private String memo;
    private String updateUserId;
    private String dateUpdated;
    private String dateCreated;
    private String schGroupName;
    private String schGroupId = "";
    private String schUserName;
    private String schUserZirecxId;
    private String[] arrGroupSeq;
    private String strSessionGroupId;
    private int pageIndex = 1;
    private int pageUnit = 10;
    private int pageSize = 10;
    private int firstIndex = 1;
    private int lastIndex = 1;
    private int countPerPage = 10;
    private String pagelist;
    private int maxPage;
    private String nowpage;
    private String rownum;
    private String orderKey;
    private String orderType;
    private String orderKeyDate;
    private String orderTypeDate;
    
    
    //selectedId 추가 
    private String selectedId = "";
    private String[] arrSelectedId;
    

    public SmartPhoneSearchVO() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getUseStatusFlag() {
        return this.useStatusFlag;
    }

    public void setUseStatusFlag(String useStatusFlag) {
        this.useStatusFlag = useStatusFlag;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getUpdateUserId() {
        return this.updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getDateUpdated() {
        return this.dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getSchGroupName() {
        return this.schGroupName;
    }

    public void setSchGroupName(String schGroupName) {
        this.schGroupName = schGroupName;
    }

    public String getSchGroupId() {
        return this.schGroupId;
    }

    public void setSchGroupId(String schGroupId) {
        this.schGroupId = schGroupId;
    }

    public String getSchUserName() {
        return this.schUserName;
    }

    public void setSchUserName(String schUserName) {
        this.schUserName = schUserName;
    }

    public String getSchUserZirecxId() {
        return this.schUserZirecxId;
    }

    public void setSchUserZirecxId(String schUserZirecxId) {
        this.schUserZirecxId = schUserZirecxId;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageUnit() {
        return this.pageUnit;
    }

    public void setPageUnit(int pageUnit) {
        this.pageUnit = pageUnit;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getFirstIndex() {
        return this.firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public int getLastIndex() {
        return this.lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public int getCountPerPage() {
        return this.countPerPage;
    }

    public void setCountPerPage(int countPerPage) {
        this.countPerPage = countPerPage;
    }

    public String getPagelist() {
        return this.pagelist;
    }

    public void setPagelist(String pagelist) {
        this.pagelist = pagelist;
    }

    public int getMaxPage() {
        return this.maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public String getNowpage() {
        return this.nowpage;
    }

    public void setNowpage(String nowpage) {
        this.nowpage = nowpage;
    }

    public String[] getArrGroupSeq() {
        return this.arrGroupSeq;
    }

    public void setArrGroupSeq(String[] arrGroupSeq) {
        this.arrGroupSeq = arrGroupSeq;
    }

    public String getStrSessionGroupId() {
        return this.strSessionGroupId;
    }

    public void setStrSessionGroupId(String strSessionGroupId) {
        this.strSessionGroupId = strSessionGroupId;
    }

    public String getRownum() {
        return this.rownum;
    }

    public void setRownum(String rownum) {
        this.rownum = rownum;
    }

    public String getOrderKey() {
        return this.orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderKeyDate() {
        return this.orderKeyDate;
    }

    public void setOrderKeyDate(String orderKeyDate) {
        this.orderKeyDate = orderKeyDate;
    }

    public String getOrderTypeDate() {
        return this.orderTypeDate;
    }

    public void setOrderTypeDate(String orderTypeDate) {
        this.orderTypeDate = orderTypeDate;
    }

	public String getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
	}

	public String[] getArrSelectedId() {
		return arrSelectedId;
	}

	public void setArrSelectedId(String[] arrSelectedId) {
		this.arrSelectedId = arrSelectedId;
	}
	
	
    
    
}