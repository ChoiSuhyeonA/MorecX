<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var param = $(location).attr('search').slice($(location).attr('search').indexOf('?') + 1);
		
		$.ajax({
			url : "<c:url value='/zigate/ZigateGetTime.do' />"+"?"+param,
			method : "get",
			dataType : "html",
			data : $("form").serialize(),
			success : function(result) {
				$(".result").text(result);
			},
			error : function(request, status, error) {
				alert(status+":"+error);
			}
		});
	});
</script>
<body>
<div class="result">
</div>
</body>