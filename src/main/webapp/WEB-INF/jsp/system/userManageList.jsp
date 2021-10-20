<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/util.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/common.js' />"></script>

<script type="text/javascript">
$(document).ready(function(){
	parent.document.getElementById("btn_search").src ="<c:url value='/images/button/btn_search.gif' />";
	parent.document.getElementById("btn_search").disabled = false;
	parent.document.getElementById("totalCnt").innerHTML = <c:out value="${totCnt}"/> + "건&nbsp;";
	parent.document.getElementById("pageCnt").innerHTML = <c:out value="${maxPage+1}"/> + "&nbsp;";
	parent.document.getElementById("maxPageCheck").value = <c:out value="${maxPage+1}"/>;
	
	$('tr').click(function(){ 
		if(this.id != '')
			changeLine('true', this.id.substring(3)); 
	});
	$('tr').mouseover(function(){
		if(this.id != ''){
			var vId = this.id.substring(3, this.id.length);
			overColor(vId);
		}
	});
	$('tr').mouseout(function(){
		if(this.id != ''){
			var vId = this.id.substring(3, this.id.length);
			outColor(vId);
		}
	});
	
	$('u').click(function(){
		if(this.id != ''){
			parent.sortField(this.id);
			parent.searchList();
		}
	});
	
	
});

/* pagination 페이지 링크 function */
function fn_user_list_page(){
	var pageNo = getOnlyNumber(parent.$("input[name=nowpage]").val());
	if(pageNo == ""){
		alert("원하시는 페이지를 입력해주십시오.");
		parent.$("input:hidden[name=nowpage]").focus();
	}else{
		parent.document.getElementById("pageIndex").value = pageNo;
		parent.document.getElementById("nowpage").value = pageNo;
		
		//historySave();
		
		parent.$("#userSearchVO").attr("target","iframeUserList");
	   	parent.$("#userSearchVO").attr("action","<c:url value='/system/userManageList.do'/>");
	   	parent.$("#userSearchVO").submit();
	}
}

function fn_user_detail(userId) {
	parent.$("input:hidden[name=userId]").val(userId);
	parent.$("input:hidden[id=jobType]").val("update");
	var params="userId="+userId;
	
	$.ajax({  
	    type: "POST",
	    url: "<c:url value='/system/userManageDetail.do'/>",
	    data:params,
	    //contentType: "application/json",
	     
	    success: function(list){  
			var jsonObj = decodeURIComponent(list);
			var searchData = $.parseJSON(jsonObj);
			   
			if(searchData.size != 0){
				parent.$('div.div_userDetail input[type=text]').val("");
				parent.$('div.div_userDetail input[type=checkbox]').removeAttr("checked");
				parent.$('div.div_userDetail input[type=text]').removeAttr("disabled");
				
				parent.document.userSearchVO.groupNameDetail.value = searchData.list[0].groupname;
				parent.document.userSearchVO.groupIdDetail.value = searchData.list[0].grpId;			
				parent.document.userSearchVO.cmbAuthSearch.value = searchData.list[0].securityGroupName;
				parent.document.userSearchVO.zirecxId.value = searchData.list[0].zirecxId;
				parent.document.userSearchVO.firstname.value = searchData.list[0].firstname;
				//parent.document.userSearchVO.loginstring.value = searchData.list[0].loginstring;
				parent.document.userSearchVO.phonenumber.value = searchData.list[0].phonenumber;
				parent.document.userSearchVO.phonenumberOffice1.value = searchData.list[0].phonenumberOffice1;
				parent.document.userSearchVO.phonenumberOffice2.value = searchData.list[0].phonenumberOffice2;
				
				parent.$("input:hidden[name=detailZirecxId]").val(searchData.list[0].zirecxId);
				//parent.$("input:hidden[name=detailLoginstring]").val(searchData.list[0].loginstring);
				
				if(searchData.list[0].recordable == "1") {
					parent.document.userSearchVO.recordable.checked = true;
				} else {
					parent.document.userSearchVO.recordable.checked = false;
				}
				
				if(searchData.list[0].deleted == "1") {
					parent.document.userSearchVO.deleted.checked = true;
					//parent.$("#loginstring").attr("disabled", true);
				} else {
					parent.document.userSearchVO.deleted.checked = false;
				}
				/* 
				if(searchData.list[0].useMonitoring == "1") {
					parent.document.userSearchVO.useMonitoring.checked = true;
				} else {
					parent.document.userSearchVO.useMonitoring.checked = false;
				}
				 */
				if(searchData.list[0].logoutSupported == "1") {
					parent.document.userSearchVO.logoutSupported.checked = true;
				} else {
					parent.document.userSearchVO.logoutSupported.checked = false;
				}
				
				if(searchData.list[0].autoUploadSupported == "1") {
					parent.document.userSearchVO.autoUploadSupported.checked = true;
				} else {
					parent.document.userSearchVO.autoUploadSupported.checked = false;
				}
				
				/* 그래프 그리기 */
				//parent.graphDraw();
			}
	    },  
	    error: function(e){  
	      alert('Error: ' + e.responseText);  
	    }  
	  });
	
}
</script>
</head>
<body>
<form:form commandName="userSearchVO" name="userSearchVO" method="post">
<input type="hidden" name="hidListCount" id="hidListCount" value="${fn:length(userList)}" />
<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
	<tr valign="top" height="">
		<td>
			<table width="100%" height="" cellpadding="0" cellspacing="0" style="border: 1px solid #cbe0dd; border-collapse: collapse;">
				<tr>
					<td width="40px" class="list_header">번호</td>
					<td width="" class="list_header"><u style="cursor:hand" id="firstname">사용자명</u></td>
					<td width="75px" class="list_header"><u style="cursor:hand" id="zirecxId">사번</u></td>
					<td width="40px" class="list_header"><u style="cursor:hand" id="recordable">녹취</u></td>
					<td width="40px" class="list_header"><u style="cursor:hand" id="deleted">삭제</u></td>
				</tr>
				<c:if test="${fn:length(userList) == 0}">
				<tr height="24px">
					<td colspan="5" align="center" class="list_no_result"><spring:message code='common.nodata.message' /></td>
				</tr>
				</c:if>			
				<c:forEach var="result" items="${userList}" varStatus="status">
				<tr height="24px" id="tr_<c:out value="${status.count + cnt}"/>" onclick="fn_user_detail('<c:out value="${result.userId}"/>');">
					<td align="right" class="list_value">
						<c:out value="${status.count + cnt}"/>&nbsp;
					</td>
					<td align="left" class="list_value">
					<div style='width:100%;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;'>
						&nbsp;
						<c:out value="${result.userName}"/>
					</div>
					</td>
					<td align="left" class="list_value">
					<div style='width:100%;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;'>
						&nbsp;
						<c:out value="${result.zirecxId}"/>
					</div>
					</td>
					<td align="center" class="list_value">
						<c:if test="${result.recordYn == '0'}">
							<input type="checkbox" disabled="disabled" />
						</c:if>
						<c:if test="${result.recordYn == '1'}">
							<input type="checkbox" disabled="disabled" checked="checked"  />
						</c:if>
					</td>
					<td align="center" class="list_value">
						<c:if test="${result.deleteYn == '0'}">
							<input type="checkbox" disabled="disabled" />
						</c:if>
						<c:if test="${result.deleteYn == '1'}">
							<input type="checkbox" disabled="disabled" checked="checked"  />
						</c:if>
					</td>
				</tr>
				</c:forEach>			
			</table>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>
