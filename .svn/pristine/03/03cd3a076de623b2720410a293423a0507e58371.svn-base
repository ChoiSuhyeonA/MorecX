<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<title>MorecX</title>
</head>
<script type="text/javascript">
function init(){
	explorerVer();
}

//브라우져의 버젼을 알아내어 팝업의 크기를 결정함.
function explorerVer(){
	var br_version = navigator.userAgent;
	//MSIE 부터 잘라내기 위함
	 var br_index = br_version.indexOf('MSIE');
	 //MSIE 포함한 브라우저 버전명
	 var br_info = br_version.substr(br_index,8);
	 //브라우저버전
	 var br_info_num = br_info.substr(5,2);
  
	if(br_info_num >= 8){
		document.getElementById("explorerVer").value = "480";
	}else if(br_info_num <= 7){
		document.getElementById("explorerVer").value = "527";	
	}
}
</script>
<body style="margin:0px; padding:0px; width:100%;" onload="init();">
	<input type="hidden" name="trackHostName" id="trackHostName" value="" />
	<input type="hidden" name="trackTcpPort" id="trackTcpPort" value="" />
	<input type="hidden" name="webHostName" id="webHostName" value="" />
	<input type="hidden" name="webTcpPort" id="webTcpPort" value="" />
	<input type="hidden" name="zipStorePath" id="zipStorePath" value="" />
	<input type="hidden" name="zirecxContext" id="zirecxContext" value="" />
	<input type="hidden" name="ziphoneContext" id="ziphoneContext" value="" />
	<input type="hidden" name="zirecxFilePath" id="zirecxFilePath" value="" />
	<input type="hidden" name="ziphoneFilePath" id="ziphoneFilePath" value="" />
	<input type="hidden" name="explorerVer" id="explorerVer" value="" />
	<input type="hidden" name="hidMonitoringUse" id="hidMonitoringUse" value="" />
	<input type="hidden" name="hidBtnSave" id="hidBtnSave" value="" />
	<input type="hidden" name="hidBtnSaveDisabled" id="hidBtnSaveDisabled" value="" />
	<input type="hidden" name="hidBtnModify" id="hidBtnModify" value="" />
	<input type="hidden" name="hidBtnModifyDisabled" id="hidBtnModifyDisabled" value="" />
</body>
</html>