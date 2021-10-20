<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<%

String user_id=(String)session.getAttribute("user_id"); 
String login_string=(String)session.getAttribute("login_string"); 
String user_name=(String)session.getAttribute("user_name"); 
String login_date=(String)session.getAttribute("login_date"); 
String login_time=(String)session.getAttribute("login_time"); 
String security_group_id=(String)session.getAttribute("security_group_id"); 
String group_id=(String)session.getAttribute("group_id"); 
String group_name=(String)session.getAttribute("group_name"); 
String zirecx_id=(String)session.getAttribute("zirecx_id"); 

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>MorecX</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javaScript" language="javascript" defer="defer">
/* 로그아웃 function */
function fn_logout() {
	$("#loginVO").attr("action","<c:url value='/common/logoutProcess.do'/>");
	$("#loginVO").submit();
}
</script>
</head>
<body>
	여기
</body>
</html>