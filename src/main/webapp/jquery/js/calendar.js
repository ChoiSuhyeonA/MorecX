var target;																	
var stime;
var monthFlag;
//document.writeln("<div id=minical oncontextmenu='return false' ondragstart='return false' onselectstart='return false' style=\"background:buttonface; margin:5; padding:5;margin-top:2;border-top:1 solid buttonshadow;border-left: 1 solid buttonshadow;border-right: 1 solid buttonshadow;border-bottom:1 solid buttonshadow;width:160;display:none;position: absolute; z-index: 1\">");
document.writeln('<div id="cal" style="background: buttonface; margin:5; border: 0 solid buttonshadow; width:160; display:none; position:absolute;left:0px; top:0px;  z-index:1">');
document.writeln('<iframe id="Cal_iFrame" width=480 height=305 src=../jquery/js/cal.html scrolling=no frameborder=no border=0 style="position:absolute;left:-50px; top:0px;" bordercolor=black></iframe>');
document.writeln('</div>');
document.writeln('<div id="minical" style="background: buttonface; margin:5; border: 0 solid buttonshadow; width:160; display:none; position:absolute;left:0px; top:0px;  z-index:1">');
document.writeln('<iframe id="Cal_mini_iFrame" width=185 height=255 src=../jquery/js/cal.html scrolling=no frameborder=no border=0 style="position:absolute;left:-50px; top:0px;" bordercolor=black></iframe>');
document.writeln('</div>');

function Calendar_D(obj,tgt) {
	monthFlag = "D"									// jucke
	target =tgt;
	
	var now = target.value.split("-");
//	var now = obj.value.split("-");
	var x, y;
	
//	target = obj;																
	
	x = (document.layers) ? loc.pageX : event.clientX;
	y = (document.layers) ? loc.pageY : event.clientY;
	
	cal.style.pixelTop	= y+5;
	
	cal.style.pixelLeft	= x-200;
	 
	
	cal.style.display = (cal.style.display == "block") ? "none" : "block";
		
	if (now.length == 3) {														
		Cal_iFrame.Show_cal(now[0],now[1],now[2]);											
	} else {
		now = new Date();
		Cal_iFrame.Show_cal(now.getFullYear(), now.getMonth()+1, now.getDate());			
	}
}

function Calendar_D_loc(obj,tgt,locX,locY,imgSrcMove,imgSrcClose,imgSrcTitle) {
	monthFlag = "D"									// jucke
	target = tgt;
	
	var now = target.value.split("-");
//	var now = obj.value.split("-");
	var x, y;
	
//	target = obj;																
	
	x = (document.layers) ? loc.pageX : event.clientX;
	y = (document.layers) ? loc.pageY : event.clientY;
	
	cal.style.pixelTop	= y+5+locX;
	
	cal.style.pixelLeft	= x-200+locY;
	 
	
	cal.style.display = (cal.style.display == "block") ? "none" : "block";
		
	if (now.length == 3) {														
		Cal_iFrame.Show_cal(now[0],now[1],now[2],imgSrcMove,imgSrcClose,imgSrcTitle);											
	} else {
		now = new Date();
		Cal_iFrame.Show_cal(now.getFullYear(), now.getMonth()+1, now.getDate(),imgSrcMove,imgSrcClose,imgSrcTitle);			
	}
}

function Calendar_M(obj,tgt) {		
	monthFlag = "M"							// jucke
	target =tgt;
	
	var now = target.value.split("-");
//	var now = obj.value.split("-");
	var x, y;
	
//	target = obj;																
	
	x = (document.layers) ? loc.pageX : event.clientX;
	y = (document.layers) ? loc.pageY : event.clientY;
	
	cal.style.pixelTop	= y+5;
	cal.style.pixelLeft	= x-200;
	cal.style.display = (cal.style.display == "block") ? "none" : "block";
		
	if (now.length == 3) {														
		Cal_iFrame.Show_cal(now[0],now[1],now[2]);											
	} else {
		now = new Date();
		Cal_iFrame.Show_cal(now.getFullYear(), now.getMonth()+1, now.getDate());			
	}
}

// 기념일 조회를 위하여 년도를 제외한 달일만 들어가도록 하는 함수
function Calendar_A(obj,tgt) {
	monthFlag = "A"									// jucke
	target =tgt;
	
	var now = target.value.split("-");
//	var now = obj.value.split("-");
	var x, y;
	
//	target = obj;																
	
	x = (document.layers) ? loc.pageX : event.clientX;
	y = (document.layers) ? loc.pageY : event.clientY;
	
	cal.style.pixelTop	= y+5;
	cal.style.pixelLeft	= x-200;
	cal.style.display = (cal.style.display == "block") ? "none" : "block";
		
	if (now.length == 3) {														
		Cal_iFrame.Show_cal(now[0],now[1],now[2]);											
	} else {
		now = new Date();
		Cal_iFrame.Show_cal(now.getFullYear(), now.getMonth()+1, now.getDate());			
	}
}

function Calendar_D_mini(obj,tgt,locationX,locationY) {		
										// jucke
	target =tgt;
	
	var now = target.value.split("-");
	var x, y;

	x = (document.layers) ? loc.pageX : event.clientX;
	y = (document.layers) ? loc.pageY : event.clientY;
	
	minical.style.pixelTop	= y+locationY;
	minical.style.pixelLeft	= x-locationX;
	minical.style.display = (minical.style.display == "block") ? "none" : "block";
		
	if (now.length == 3) {														
		Cal_mini_iFrame.Show_cal_mini(now[0],now[1],now[2]);											
	} else {
		now = new Date();
		Cal_mini_iFrame.Show_cal_mini(now.getFullYear(), now.getMonth()+1, now.getDate());			
	}
}
	
function Calendar_Click(e) {	
	var addChk = true; 
	var cal_Day = e.title;
	e.style.borderColor = "#c9c4ff";							
	e.style.backgroundColor = "#c9c4ff";	
												// 테두리 색을 빨간색으로
	if (cal_Day.length > 7) {		
										
		if(target.name == "selWorkDate"){
			if (cal_Day < document.getElementById("strLoginDate").value){
				alert("현재일자 이전은 선택하실 수 없습니다.");
				e.style.borderColor = "ffffff";
				e.style.backgroundColor = "ffffff";												// 테두리 색을 빨간색으로
				return;
			}else{
				for(var i=0;i<target.length;i++){
					if(target.options[i].value == cal_Day){
						e.style.borderColor = "ffffff";
						e.style.backgroundColor = "ffffff";												// 테두리 색을 빨간색으로
						target.options[i] = null;
						addChk = false;
					}
				}
				if(addChk){
					target.options[target.length] = new Option(cal_Day,cal_Day);
				}
			}
		}else{
			if(monthFlag == "M")
			{
				target.value=cal_Day.substring(0,7);
			} else if(monthFlag == "A")
			{
				target.value=cal_Day.substring(5,10);
			}
			else
			{
				target.value=cal_Day													// 값 설정
			}
			
		}
	}
	if(target.name != "selWorkDate"){
		cal.style.display='none';												// 화면에서 지움
	}
}

function Calendar_mini_Click(e) {	
	var cal_Day = e.title;
	e.style.borderColor = "red";							
	if (cal_Day.length > 7) {													
		target.value=cal_Day													
	}
	minical.style.display='none';												
}

function CalendarClose(){
	cal.style.display='none';	
}

function CalendarMiniClose(){
	minical.style.display='none';	
}

function chkSelDate(){
	for(var i=0;i<target.length;i++){
		if(Cal_iFrame.document.getElementById("td_" + target.options[i].value) == "[object]"){
			Cal_iFrame.document.getElementById("td_" + target.options[i].value).style.borderColor = "#c9c4ff";
			Cal_iFrame.document.getElementById("td_" + target.options[i].value).style.backgroundColor = "#c9c4ff";	
		}
	}
}
