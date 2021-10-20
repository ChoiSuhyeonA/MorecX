
#2020.11.16

1. Quartz 주기 변경 (02시 배치)
2. ZigateWeb Login Interface 사용자 정보 업데이트 오류 수정 

#2020.11.06

1. ZiphonePlayer 버전 업그레이드
2.1.2.26 => 2.1.2.42(사운드 장치 오픈 에러메세지 수정)


#2020.09.07 

1. 녹취청취 URL http => https
2. 녹취청취 녹취 다운로드 시 통화/부재 컬럼 추가 


#2020.07.14 

1. quartz test code 추가, DB IP 하드코딩 => localhost로 변경(IP교체작업 대응)
2. datasource DEV, PROD 구분 


#2020.07.08  v2.0

1. 로그인 세션 수정 
  - 세션 추가     :  "parent_group_id" 부모 조직 id 컬럼 추가 
  - 세션 값 수정 :  삭제된 권한 조회 제거, SmartPhone관리 추가
  
2. 페이지 타입 분리 : 권한 분류를 위해 추가 
  - 녹취관리 : record 
  - 시스템관리 : system
  - 스마트폰관리 : smartPhone  

  - 페이지 권한은  orkprivpoint 내 [기능]조직선택,조직도,사용자선택 부분은 시스템관리 외에서 전체 사용한다(녹취관리,콜통계, 스마트폰관리)
                             [기능]시스템조직선택, 조직도, 사용자선택 부분은 시스템관리에서만 사용한다.(시스템관리) 
                             
  - 웰컴론 요청사항으로 관리자 권한은 녹취관리 부분에서는 groupUp(상위 그룹의 권한을 가짐)권한을 사용하고, 시스템관리에서는 all(전체권한)을 사용한다.
  
 3. 컨트롤러 수정 
   3.1  CmnUserSearchController  : /common/userPopMain.do, /common/userPopList.do 미사용 주석처리 
                                    /common/selectUserCheck.do groupUp 권한설정 
                                    /common/selectUserList.do  groupUp 권한설정
                                    /common/smartPhoneUsercommonPopMain.do => SmartPhoneController로 이동 
                                    
   3.2 LoginController        : /common/loginProcess.do 세선추가(parent_group_id), 미사용 권한삭제 로그인 분기 오류 수정 
    
   3.3 CmnGroupSearchController : /common/selectGroupUserList.do, /common/groupUserCommonPopMain.do 제거 
                                   /common/groupUserTreePopMain.do, /common/groupUserTreeList.do 제거 
                                   /common/systemGrouTreeList.do 추가(시스템관리 그룹트리 리스트)  
    
   3.4 RecordManageController : /record/recordManageMain.do, /record/recordManageList.do 미사용 주석처리 
    								/record/recordRefreshList.do,/record/recordManageCheckExcelList.do 미사용 주석처리 
    								/record/linkPenCallRefreshList.do 추가 
    								/record/linkPenCallManageCheckExcelList.do 추가 
    						        excel 다운 컨트롤러 excel 파일 열기 시 excel list 컨트롤러 재호출되는 버그 발생 => param null 처리 완료 
    								
   3.5 SmartPhoneManageController : /smart/smartPhoneManageListExcel.do 엑셀 리스트 오류로 리스트 분리 및 엑셀 컨트롤러 DAO 추가 
                                     /smart/smartPhonUserPopMain.do, /smart/selectSmartPhoneUserList.do 총무 리스트 조회 팝업 추가
                                     
   3.6 GroupManageMainController : /system/groupManageMain.do  센터관리. 권한 시스템권한으로 변경 
    
   3.7 UserManageMainController  :  /system/userManageMain.do 사용자관리. 권한 시스템권한으로 변경
    
 4. 객체 수정 /추가 
    kr.co.irlink.zirecx.common.service.CmnUserSearchVO =>  pageType, strLoginUserAuth 추가 
    kr.co.irlink.zirecx.record.web.LinkPenCallManageExcelDownload => 펜녹취 엑셀다운로드 추가 
    kr.co.irlink.zirecx.qurtz.ReportDailyInsert => 아이피, DB 설정 수정(통계 INSERT 시 사용함) 
    
    
 5. 뷰 제거    
 	groupUserCommonPopMain.jsp 
 	groupUserTreeCommonPopList.jsp
 	userPopList.jsp
 	userPopMain.jsp 
 	smartPhoneUserCommonPopList.jsp => smart/smartPhoneUserPopList.jsp 로 변경 
 	smartPhoneUserCommonPopMain.jsp => smart/smartPhoneUserPopMain.jsp 로 변경 
 	
 	
 6. 추가 수정 사항 
    
   6.1 녹취 관리 : pageType = record
     
   6.2 펜녹취 관리 : pageType = record 
    			      조회 재생길이 sort 오류 => 제거 
    			      녹취 업로드 팝업 필수 입력값 마킹 처리 
    			      펜녹취 refresh 조회 오류 수정 
    			      엑셀다운로드 추가 
    			      
   6.3 녹취다운로드 관리  : pageType = record	      
    
   6.4 사용자관리 : pageType = system
                                    시스템 조직도, 조직선택, 사용자관리로 변경  		
                                    관리자 조회 오류 수정(본인조회=> 전체조회)
                                    정렬 오류 수정
    
   6.5 센터관리 : 조회 오류 수정, 정렬 오류 수정 
                              디테일 센터추가(상위) Key press 13 이벤트 시 조회되는 오류 처리
    
   6.6 콜통계 : 정렬 수정, 센터 groupUp권한 추가 
    
   6.7 스마트폰 관리 : pageType = smartPhone
                                     작업자 검색 오류 수정, 엑셀 다운로드 오류 수정  
    
   6.8 공통 스크립트 : Key Press Event 팝업 수정                   
                
   6.9 조직팝업   : 권한에 따른 조직 불러오게 수정. groupUp의 경우 상위 조직부터 불러온다.
   
   6.10 사용자팝업 : 권한에 따라 사용자 불러오게 수정. 전체 사용자 관리 팝업은 전체 사용자 조회. 시스템 관리 사용자 조회 팝업은  자신의 권한보다 높은 권한은 제외한다.
   
   6.11 쿼리 수정/추가  
      - CmnGroup_SQL.xml : selectGroupCheck => groupUp 조건 추가 
      - CmnUser_SQL.xml  : selectUserCheck => groupUp 조건추가 pageType 추가 (pageType = system 인경우 상위 권한 사용자 조회 X) 
                           selectUserList => groupUp 조건 추가 
                           selectLoginUserAuth 추가 (사용자 권한 등급 리턴) 
                           selectSmartPhoneUserList => smartphone 관리로 이동 
      - Login_SQL.xml     : selectUserLogin => 부모 그룹 아이디 컬럼 조회 추가 
                            selectUserAuth => 삭제 권한 조회 안되게 수정 
      - Record_SQL.xml    : selectLinkCallList, selectLinkCallListTotCnt => groupUp 조건 추가 
        					selectLinkPenCallList,selectLinkPenCallListTotCnt => groupUp 조건 추가 
                            selectCheckLinkCallExcelList => groupUp 조건 추가 
                            selectCheckPenCallExcelList => 신규 생성 
                            selectCallHistoryList, selectCallHistoryListTotCnt => groupUp 조건 추가 
      - Linkage_Report.xml : 통계 리스트 전체 => groupUp 조건 추가 
      - SmartPhone_SQL.xml : selectSmartPhoneManageList => 정렬 오류로 ORDER BY 수정 
                             selectSmartPhoneUserList => 작업자(총무권한) 조회 
      - Group_SQL.xml      : selectGroupList => groupUp 조건 추가, own 이외의 그룹에 대해 arrChildGroup 조건 추가
                             schGroupId param 값 있는 경우 없는경우 분기 처리 
      - User_SQL.xml       : selectUserList, selectUserCnt => groupUp 조건 추가 
      - Zigate_SQL.xml  : getLogin => LISTEN_INFO_REQ param 값 REQ 대문자 처리로 수정 
                             
      
   
  7. DB INSERT 
 	
   7.1 시스템 권한 분리를 위해서 시스템 권한 추가  
   insert into orkprivpoint ( id, name, checkbox_flag, action, deleted) values(42,'[기능]시스템조직도',0,null,0);
   insert into orkprivpoint ( id, name, checkbox_flag, action, deleted) values(43,'[기능]시스템조직선택',0,null,0);
   insert into orkprivpoint ( id, name, checkbox_flag, action, deleted) values(44,'[기능]시스템사용자선택',0,null,0);
   
   
 	
 	
 	
    
     
  
  