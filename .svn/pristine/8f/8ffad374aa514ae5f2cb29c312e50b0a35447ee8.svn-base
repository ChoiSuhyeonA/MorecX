/**
 * 시스템명 	: 보험 ASP
 * 업무명    	: AJAX 관련
 * 프로그램명	: ajax.js
 * 설명     	: AJAX 관련 XML REQUEST
 * 작성자    	: IRLINK
 * 변경내역  	:  
 * 변경내용  	:  
 */

/*******************************************************************************
* XML REQUEST 를 POST 방식으로 GET처럼 붙여보냄(한글처리)
*******************************************************************************/
function getXMLHttpRequest(strUrl,strParam){
	var xmlRequest = new ActiveXObject("Microsoft.XMLHTTP");
	xmlRequest.Open("POST", strUrl + "?" + strParam, false);
	xmlRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlRequest.Send(null);					
	return xmlRequest;
}

/*******************************************************************************
* XML REQUEST 를 POST 방식으로 SEND 에 넣어보냄
*******************************************************************************/
function getXMLHttpRequestParam(strUrl,strParam){
	var xmlRequest = new ActiveXObject("Microsoft.XMLHTTP");
	xmlRequest.Open("POST", strUrl, false);
	xmlRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	//xmlRequest.Send(strParam);					
	xmlRequest.Send(encodeURI(strParam));
	return xmlRequest;
}

/*******************************************************************************
* XML REQUEST 를 GET 방식보냄
*******************************************************************************/
function getXMLHttpRequestGet(strUrl,strParam){
	var xmlRequest = new ActiveXObject("Microsoft.XMLHTTP");
	xmlRequest.Open("GET", strUrl + "?" + strParam, false);
	xmlRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlRequest.Send(null);					
	return xmlRequest;
}

/*******************************************************************************
* XML REQUEST 를 POST로 보내서 텍스트로 리턴받음
*******************************************************************************/
function getXMLHttpRequestText(strUrl,strParam){
	var returnXmlRequest = getXMLHttpRequestParam(strUrl,strParam);
	return returnXmlRequest.responseText;
}

/*******************************************************************************
* XML REQUEST 를 POST로 보내서 텍스트로 리턴받음
*******************************************************************************/
function getXMLHttpRequestXML(strUrl,strParam){
	var returnXmlRequest = getXMLHttpRequestParam(strUrl,strParam);
	return returnXmlRequest.responseXML;
}

/*******************************************************************************
* XML REQUEST 를 GET으로 보내서 텍스트로 리턴받음
*******************************************************************************/
function getXMLHttpRequestGetText(strUrl,strParam){
	var returnXmlRequest = getXMLHttpRequestGet(strUrl,strParam);
	return returnXmlRequest.responseText;
}


function newXMLHttpRequest(){
	var xmlreq = false;
	if (window.XMLHttpRequest){
		xmlreq = new XMLHttpRequest();
	} else if (window.ActiveXObject){
		try {
			xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e1) {
			try {
				xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e2){
				alert("XML Fail");
				xmlreq = false;
			}
		}
	}
	
	return xmlreq;
}

function getReadyStateHandler(req, responseXmlHandler) {
	return function() {
		if (req.readyState == 4) {
			if (req.status == 200) {
				responseXmlHandler(req.responseXML);
			} else if (req.status == 12029){
				
				var xmldoc = new ActiveXObject("Msxml2.DOMDocument");
			    xmldoc.async =false;
			    var root,success, tempValue;
			    
			    root = xmldoc.createElement("response");
			    success = xmldoc.createElement("sucess");
		        tempValue = xmldoc.createTextNode("Fail");
				
				root.appendChild(success);
				success.appendChild(tempValue); 
				xmldoc.appendChild(root);
				responseXmlHandler(xmldoc);;
			} else {
				alert("HTTP error " + req.status + ": " + req.statusText);
			}
		}
	}
}
