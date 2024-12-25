"commonUtil.js"

var CommonUtil = {};

$(function(){
	/** 숫자만 입력 **/
	$(document).on("keyup", "input[type='text'].numberFormat", function(){
		var number = $(this).val().replace(/[^-\.0-9]/g, "");
		$(this).val(number);
	});

	/** 금액만 입력 가능 **/
	$(document).on("keyup", "input[type='text'].moneyFormat", function(){
		var money = CommonUtil.toMoney( $(this).val() );
		$(this).val(money);
	});

	CommonUtil.setRequired();
});

/**
 * 기간에 속하는 일자 List 가져오기
 */
CommonUtil.getDiffDateList = function( _startDt, _endDt ){

	var array = new Array();
	var startDtStr = _startDt.replace(/[^0-9]/g, "");
	var endDtStr = _endDt.replace(/[^0-9]/g, "");
	var startDt = new Date(Number(startDtStr.substr(0,4)), Number(startDtStr.substr(4,2)) - 1, Number(startDtStr.substr(6,2)));
	var endDt = new Date(Number(endDtStr.substr(0,4)), Number(endDtStr.substr(4,2)) - 1, Number(endDtStr.substr(6,2)));
	var dayCnt = (endDt.getTime() - startDt.getTime()) / (1000 * 60 * 60 * 24) + 1;

	for(var i = 0; i < dayCnt; i++){
		var year = startDt.getFullYear();
		var month = startDt.getMonth() + 1 < 10 ? "0" + (startDt.getMonth() + 1) : "" + (startDt.getMonth() + 1);
		var day = startDt.getDate() < 10 ? "0" + startDt.getDate() : "" + startDt.getDate();
		array.push(year + month + day);
		startDt.setDate(startDt.getDate() + 1);
	}
	return array;
}

/**
 * 일자 차이 계산
 */
CommonUtil.getDiffTime = function( _startDt, _endDt ){

	var startDtStr = _startDt.replace(/[^0-9]/g, "");
	var endDtStr = _endDt.replace(/[^0-9]/g, "");
	var startDt = new Date(Number(startDtStr.substr(0,4)), Number(startDtStr.substr(4,2)), Number(startDtStr.substr(6,2)));
	var endDt = new Date(Number(endDtStr.substr(0,4)), Number(endDtStr.substr(4,2)), Number(endDtStr.substr(6,2)));
	var dayCnt = (endDt.getTime() - startDt.getTime()) / (1000 * 60 * 60 * 24) + 1;
	return dayCnt;
}

/**
 * 시간 차이 계산
 */
CommonUtil.getDiffTime = function( _startTime, _endTime, _dedStartTime, _dedEndTime ){
	var tenMinUnitList = new Array();
	var startTimeMin = Number(_startTime.substring(0, 2)) * 60 + Number(_startTime.substring(2, 4));
	var endTimeMin = Number(_endTime.substring(0, 2)) * 60 + Number(_endTime.substring(2, 4));
	while(startTimeMin < endTimeMin){
		var hour = Math.floor(startTimeMin / 60);
		var key = Math.floor((startTimeMin % 60) / 10);
		tenMinUnitList.push(hour + "" + key);
		startTimeMin += 10;
	}

	var tempStartTime = _dedStartTime||'0000';
	var tempEndTime = _dedEndTime||'0000';

	var tempStartMin = Number(tempStartTime.substring(0, 2)) * 60 + Number(tempStartTime.substring(2, 4));
	var tempEndMin = Number(tempEndTime.substring(0, 2)) * 60 + Number(tempEndTime.substring(2, 4));
	while(tempStartMin < tempEndMin) {
		var hour = Math.floor(tempStartMin / 60);
		var key = Math.floor((tempStartMin % 60) / 10);
		var idx = tenMinUnitList.indexOf(hour + "" + key);
		if(idx >= 0){tenMinUnitList.splice(idx, 1);}
		tempStartMin += 10;
	}

	return tenMinUnitList.length * 10;
}

/**
 * 중복 시간 계산
 */
CommonUtil.getOverlapTime = function( _startTime, _endTime, _tempStartTime, _tempEndTime ){
	var tenMinUnitList = new Array();
	var startTimeMin = Number(_startTime.substring(0, 2)) * 60 + Number(_startTime.substring(2, 4));
	var endTimeMin = Number(_endTime.substring(0, 2)) * 60 + Number(_endTime.substring(2, 4));
	while(startTimeMin < endTimeMin){
		var hour = Math.floor(startTimeMin / 60);
		var key = Math.floor((startTimeMin % 60) / 10);
		tenMinUnitList.push(hour + "" + key);
		startTimeMin += 10;
	}

	var tempStartTime = _tempStartTime;
	var tempEndTime = _tempEndTime;

	var list = new Array();
	var tempStartMin = Number(tempStartTime.substring(0, 2)) * 60 + Number(tempStartTime.substring(2, 4));
	var tempEndMin = Number(tempEndTime.substring(0, 2)) * 60 + Number(tempEndTime.substring(2, 4));
	while(tempStartMin < tempEndMin) {
		var hour = Math.floor(tempStartMin / 60);
		var key = Math.floor((tempStartMin % 60) / 10);
		var idx = tenMinUnitList.indexOf(hour + "" + key);
		if(idx >= 0){list.push(hour + "" + key);}
		tempStartMin += 10;
	}

	return list.length * 10;
}

/**
 * 중복 시간대 계산
 */
CommonUtil.getOverlapTimeList = function( _startTime, _endTime, _tempStartTime, _tempEndTime ){
	var tenMinUnitList = new Array();
	var startTimeMin = Number(_startTime.substring(0, 2)) * 60 + Number(_startTime.substring(2, 4));
	var endTimeMin = Number(_endTime.substring(0, 2)) * 60 + Number(_endTime.substring(2, 4));
	while(startTimeMin <= endTimeMin){
		var hour = Math.floor(startTimeMin / 60);
		var key = Math.floor((startTimeMin % 60) / 10);
		tenMinUnitList.push(hour + "" + key);
		startTimeMin += 10;
	}

	var tempStartTime = _tempStartTime;
	var tempEndTime = _tempEndTime;

	var list = new Array();
	var tempStartMin = Number(tempStartTime.substring(0, 2)) * 60 + Number(tempStartTime.substring(2, 4));
	var tempEndMin = Number(tempEndTime.substring(0, 2)) * 60 + Number(tempEndTime.substring(2, 4));
	while(tempStartMin <= tempEndMin) {
		var hour = Math.floor(tempStartMin / 60);
		var key = Math.floor((tempStartMin % 60) / 10);
		var idx = tenMinUnitList.indexOf(hour + "" + key);
		if(idx >= 0){
			hour = Math.floor(tempStartMin / 60) < 10 ? "0" + Math.floor(tempStartMin / 60) : Math.floor(tempStartMin / 60);
			var min = (tempStartMin % 60) < 10 ? "0" + (tempStartMin % 60) : (tempStartMin % 60);
			list.push(hour + "" + min);
		}
		tempStartMin += 10;
	}

	return list;
}

/**
 * 분을 시간 문자열로 변경
 */
CommonUtil.timeFormat = function( _min, _separator ){
	var hour = Math.floor(_min / 60) < 10 ? "0" + Math.floor(_min / 60) : Math.floor(_min / 60);
	var min = (_min % 60) < 10 ? "0" + (_min % 60) : (_min % 60);
	return hour + _separator + min;
}

/**
 * 날짜객체를 문자열로 변경
 */
CommonUtil.dateFormat = function( _date, _separator ){
	var year = _date.getFullYear();
	var month = ((_date.getMonth() + 1) < 10 ? "0" + (_date.getMonth() + 1) : (_date.getMonth() + 1));
	var day = (_date.getDate() < 10 ? "0" + _date.getDate() : _date.getDate());
	return year + _separator + month + _separator + day;
}

/**
 * T_PAGE_DESC 페이지 설명 데이터 가져와서 세팅
 */
CommonUtil.setPageDesc = function( _pageCd ){
	if(_pageCd != null && _pageCd != ""){
		$("#loadingProgressBar").show();
		CommonUtil.postAjax("/common/getPageDescList", {pageCd : _pageCd}).done(function(result){
			var list = result.list;
			$.each(list, function(index, item){
				$("a[pageCd='" + item.pageCd + "'][dataCd='" + item.dataCd + "']").attr("title", item.dataDesc);

				$("a[pageCd='" + item.pageCd + "'][dataCd='" + item.dataCd + "']").off(); /** 기존 이벤트 제거 **/
				$("a[pageCd='" + item.pageCd + "'][dataCd='" + item.dataCd + "']").on("click", function(){
					var table = "";
					table += "<div class='com_ta'>";
					table += 	"<table>";
					table +=		"<colgroup>"
					table +=			"<col width='80'>"
					table +=			"<col width='200'>"
					table +=		"</colgroup>"
					table += 		"<tbody>";
					table += 			"<tr><th class='cen' style='height:36px'>명칭</th><td class='cen' style='height:36px'><input type='text' class='puddSetup' name='subject' value='" + item.subject + "' pudd-style='width:94%;' autocomplete='off'/></td></tr>";
					table += 			"<tr><th class='cen' style='height:100px'>명칭설명</th><td class='le vt' style='height:100px'><textarea class='puddSetup' name='dataDesc' pudd-style='width:100%;height:96%'>" + item.dataDesc + "</textarea></td></tr>";
					table += 			"<tr><th class='cen' style='height:60px'>기능설명</th><td class='le vt' style='height:60px'><textarea class='puddSetup' name='warning' pudd-style='width:100%;height:96%'>" + item.warning + "</textarea></td></tr>";
					table += 		"</tbody>";
					table += 	"</table>";
					table += "</div>";
					Pudd.puddDialog({
						width: 600,
						height: 250,
						modal : false,
						draggable : true,
						resize : true,
						header : {
							title : "Description",
							align : "left",
							closeButton : true
						},
						body : {
							content: table
						},
						footer : {
							buttons : [
								{
									attributes : {},
									controlAttributes : { id : "", class : "submit" },
									value : "저장",
									clickCallback : function( puddDlg ) {
										var params = {
											pageCd : item.pageCd,
											dataCd : item.dataCd,
											subject : $(puddDlg.node).find("input[name='subject']").val(),
											dataDesc : $(puddDlg.node).find("textarea[name='dataDesc']").val(),
											warning : $(puddDlg.node).find("textarea[name='warning']").val()
										}
										CommonUtil.postAjax("/common/updatePageDesc", params).done(function(result){
											alert("저장되었습니다.");
											CommonUtil.setPageDesc(item.pageCd);
											puddDlg.showDialog( false );

										}).fail(function(response) {
											alert("저장 도중 에러발생.");

										});
									}
								}, {
									attributes : { style : "margin-left:5px;" },
									controlAttributes : { id : "" },
									value : "취소",
									clickCallback : function( puddDlg ) {
										puddDlg.showDialog( false );
									}
								}
							]
						}
					});
				});
			});
		}).always(function(){
			$("#loadingProgressBar").hide();
		});
	}
}

/**
 * 특정 SelectBox에 시간 option 추가
 */
CommonUtil.hourSet = function( _selector ){
	if( $( _selector ).length < 1 ){
		return false;
	}

	var htmlStr = "";
	for(var i = 0; i <= 30; i++){
		if(i < 10){
			htmlStr += "<option value='0" + i + "'>0" + i + "</option>";
		}else if(i > 24) {
			htmlStr += "<option value='" + i + "'>익일0" + (i - 24) + "</option>";
		}else {
			htmlStr += "<option value='" + i + "'>" + i + "</option>";
		}
	}
	$( _selector ).html(htmlStr);
}

/**
 * 특정 SelectBox에 분 option 추가
 */
CommonUtil.minSet = function( _selector, _term ){
	if( $( _selector ).length < 1 ){
		return false;
	}

	var htmlStr = "";
	for(var i = 0; i < 60; i++){
		if((i % _term) == 0){
			if(i < 10){
				htmlStr += "<option value='0" + i + "'>0" + i + "</option>"
			}else{
				htmlStr += "<option value='" + i + "'>" + i + "</option>"
			}
		}
	}
	$( _selector ).html(htmlStr);
}

/**
 * 숫자를 문자열로 변환 (마이너스 포함)
 */
CommonUtil.toMoney = function( _number ) {
	if( _number == null || _number === "" ){
		return "";
	}
	return _number.toString().replace(/[^-\.0-9]/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

/**
 * 문자열을 숫자로 변환 (마이너스 포함)
 */
CommonUtil.toNumber = function( _number ) {
	if( _number == null || _number == "" ){
		return 0;
	}
	var number = _number.toString().replace(/[^-\.0-9]/g, "");
	return Number( number );
}

/**
 * Post 방식으로 Form Submit
 */
CommonUtil.movePagePost = function( _url, _paramObj ) {

	var $form = $("<form></form>");
	$form.attr("action", _g_contextPath_ + _url);
	$form.attr("method", "post");
	for(var name in _paramObj){
		$form.append( $("<input name='" + name + "' type='hidden' value='" + _paramObj[name] + "'>") );
	}

	$form.appendTo("body").submit().remove();
}

/**
 * 특정 테이블에 데이터가 없습니다 Row 추가
 */
CommonUtil.setNoData = function( _tableId ) {
	var $table = $('tfoot tr',_tableId);
	var tdCnt = $table.find('th,td').length;
	var text = "<tr class='no-data'><td colspan='" + tdCnt + "' align='center'>데이터가 없습니다.</td></tr>";
	$('tbody', _tableId).append(text);
}

/**
 * 특정 요소에 필수항목 이미지 추가 (이미지 넣을 요소에 requiredImg 클래스 추가)
 */
CommonUtil.setRequired = function() {
	$('.requiredImg').prepend('<img src="'+_g_contextPath_+'/Images/ico/ico_check01.png" alt=""> ');
}

/**
 * 오늘날짜 가져오기
 */
CommonUtil.getToday = function( _addCnt ) {
	if( _addCnt == null ){
		_addCnt = 0;
	}
	var today = new Date();
	today.setDate( today.getDate() + _addCnt );
	var year = today.getFullYear();
	var month = today.getMonth() + 1;
	var day = today.getDate();
	if( month < 10 ){
		month = "0" + month;
	}
	if( day < 10 ){
		day = "0" + day;
	}

	return year + "-" + month + "-" + day;

}

/**
 * post 방식 Ajax, Promise객체 리턴 ( Ajax의 후처리를 위해 사용 )
 */
CommonUtil.postAjax = function( _path, _params ) {
	var _g_contextPath_ = /*[[@{/}]]*/ '';
	var url = _g_contextPath_ + _path;
	return $.ajax({
		url : url,
		type : "post",
		data : _params,
		datatype : "json",
		async : false,
	});
};

/**
 * post 방식 Ajax, Promise객체 리턴 ( Ajax의 후처리를 위해 사용 ) - async 처리방법 필요(순서가 필요해서)
 */
CommonUtil.postAjax2 = function( _path, _params ) {
	var url = _g_contextPath_ + _path;
	return $.ajax({
		url : url,
		type : "post",
		data : _params,
		datatype : "json",
		async : false,
	});
};



/**
 * 파일업로드를 위한 Ajax ( FormData 객체를 사용해야함 )
 */
CommonUtil.fileAjax = function( _path, _formData ) {
	console.log(_path)
  	console.log(_formData)
	var url = _g_contextPath_ + _path;
	console.log(url)
	return $.ajax({
		url : url,
		type : "post",
		data : _formData,
		processData: false,
		contentType: false
	});
};

/**
 * post 방식 JSON 전송
 */
CommonUtil.jsonAjax = function( _path, _params ) {
	var url = _g_contextPath_ + _path;
	return $.ajax({
		url : url,
		contentType : "application/json",
		type : "post",
		data : JSON.stringify(_params),
		datatype : "json"
	});
};

/**
 * 팝업 띄우기 ( Callback ) 설정가능
 */
CommonUtil.openPopup = function( _url, _paramObj, _popupName, _width, _height, _callback ) {
	var _g_contextPath_ = /*[[@{/}]]*/ '';
	var target = _popupName;
	var url = _g_contextPath_ + _url;

	var nWidth = Number(_width);
	var nHeight = Number(_height);

	var curX = window.screenLeft;
	var curY = window.screenTop;
	var curWidth = document.body.clientWidth;
	var curHeight = document.body.clientHeight;

	// var nLeft = curX + (curWidth / 2) - (nWidth / 2);
	// var nTop = curY + (curHeight / 2) - (nHeight / 2);

	var nLeft = (window.screen.width / 2) - (nWidth / 2);
	var nTop = (window.screen.height / 2) - (nHeight / 2);

	var strOption = "";
	strOption += "left=" + nLeft + "px,";
	strOption += "top=" + nTop + "px,";
	strOption += "width=" + nWidth + "px,";
	strOption += "height=" + nHeight + "px,";
	strOption += "toolbar=no,menubar=no,location=no,scrollbars=yes,resizable=yes,status=yes";

	var $form = $("<form id='" + _popupName + "'></form>");
	$form.attr("action", url);
	$form.attr("method", "post");
	$form.attr("target", _popupName);
	for(var name in _paramObj){
		$form.append( $("<input name='" + name + "' type='hidden' value='" + _paramObj[name] + "'>") );
	}
	$form.append( $("<input name='callback' type='hidden' value='" + _callback + "'>") );
	$form.appendTo("body");

	var winObj = window.open("", target, strOption);
	$form.submit();
	$("#" + _popupName).remove();
}

/**
 * 페이지 이동
 */
CommonUtil.pageMove = function( _url, _paramObj ) {

	var url = _g_contextPath_ + _url;

	var $form = $("<form></form>");
	$form.attr("action", url);
	$form.attr("method", "post");
	for(var name in _paramObj){
		$form.append( $("<input name='" + name + "' type='hidden' value='" + _paramObj[name] + "'>") );
	}
	$form.appendTo("body");

	$form.submit();
}

/**
 * 푸딩 Dialog 띄우기
 */
CommonUtil.openDialog = function( _id, _width, _height, _title, _fnConfirm, _fnCancel, _buttons ) {

	if( _fnConfirm == null ){
		_fnConfirm = function(){return true;}
	}

	if( _fnCancel == null ){
		_fnCancel = function(){return true;}
	}

	var divContent = document.getElementById( _id );
	if(_id == 'hiddenDialog'){
		var option = {
			width : _width,
			height : _height,
			modal : true,
			draggable : true,
			resize : true,
			header : {
				title : _title,
				align : "left",
				closeButton : true,
				closeCallback : function(puddDlg) {
					_fnCancel();
				}
			},
			body : {
				content : divContent,
				contentCallback : function(contentDiv) {
	
				}
			},
			footer : {
				buttons : [{
					attributes : {
						style : "margin-left:5px;"
					},
					controlAttributes : {
						id : "btnCancel"
					},
					value : "취소",
					clickCallback : function(puddDlg) {
						if( _fnCancel() ){
							puddDlg.showDialog(false);
						}
					}
				}]
			}
		}
	}else{
		var option = {
			width : _width,
			height : _height,
			modal : true,
			draggable : true,
			resize : true,
			header : {
				title : _title,
				align : "left",
				attributes : { style : "padding:20px;" },
				closeButton : true,
				closeCallback : function(puddDlg) {
					_fnCancel();
				}
			},
			body : {
				content : divContent,
				contentCallback : function(contentDiv) {

				}
			},
			footer : {
				buttons : [{
					attributes : {},
					controlAttributes : {
						id : "btnConfirm",
						class : "submit"
					},
					value : "확인",
					clickCallback : function(puddDlg) {
						if( _fnConfirm() ){
							puddDlg.showDialog(false);
						}
					}
				}, {
					attributes : {
						style : "margin-left:5px;"
					},
					controlAttributes : {
						id : "btnCancel"
					},
					value : "취소",
					clickCallback : function(puddDlg) {
						if( _fnCancel() ){
							puddDlg.showDialog(false);
						}
					}
				}]
			}
		}
	}

	if( _buttons != null ){
		for(var i in _buttons){
			option.footer.buttons.push(_buttons[i]);
		}
	}
	return Pudd.puddDialog(option);
}

/**
 * div를 푸딩 Select로 변환 ( 안에 option을 넣어두고 사용가능 )
 */
CommonUtil.convertPuddSelect = function( _selector, _width, _id, _name, _selectedIndex, _changeFn ) {

	if( $( _selector ).length < 1 ){
		return false;
	}

	if( _id == null ){
		_id = "";
	}

	if( _name == null ){
		_name = "";
	}

	if( _selectedIndex == null ){
		_selectedIndex = 0
	}

	if( _changeFn == null ){
		_changeFn = null;
	}

	var $selectbox = $( _selector );
	var optionList = new Array();
	$selectbox.children("option").each(function( index, option ){
		var optionObj = new Object();
		optionObj.value = $( option ).val();
		optionObj.text = $( option ).text();
		optionList.push( optionObj );
	});

	$( _selector ).empty();
	$( _selector ).css("display", "inline-block");
	var disabled = ( $selectbox.attr("disabled") || false ) == "disabled";
	Pudd( _selector ).puddComboBox({
		attributes : { style : "width:" + _width },
		controlAttributes : { id : _id, name : _name },
		dataSource : new Pudd.Data.DataSource({
			data : optionList
		}),
		dataValueField : "value",
		dataTextField : "text",
		selectedIndex : _selectedIndex,
		disabled : disabled,
		scrollListHide : false
	});
	Pudd( _selector ).getPuddObject().setSelectedIndex(_selectedIndex);

	if( _changeFn !== null ){
		var puddObj = Pudd( _selector ).getPuddObject();
		puddObj.on( "change", function( e ) {
			if( typeof( _changeFn ) === "function" ){
				_changeFn( e );
			}
		});
	}
}

/**
 * div를 푸딩 DatePicker로 변환
 */
CommonUtil.convertPuddDatepicker = function( _selector, _value, _changeFn ) {

	if( $( _selector ).length < 1 ){
		return false;
	}

	if( _value == null ){
		_value = "";
	}

	if( _changeFn == null ){
		_changeFn = function(e){return true};
	}

	var disabled = ( $( _selector ).attr("disabled") || false ) == "disabled";
	Pudd( _selector ).puddDatePicker({
		typeDisplay : "year",
		value : _value,
		disabled : disabled,
		eventCallback : {
			change : function( e ){
				_changeFn( e );
			}
		}
	});
}

/**
 * div를 푸딩 raio로 변환 ( 안에 option을 넣어두고 사용가능 )
 */
CommonUtil.convertPuddRadio = function( _selector, _id, _name, _value, _checked, _label, _clickFn ) {

	if( $( _selector ).length < 1 ){
		return false;
	}

	if( _id == null ){
		_id = "";
	}

	if( _name == null ){
		_name = "";
	}

	if( _value == null ){
		_value = "";
	}

	if( _clickFn == null ){
		_clickFn = function(e){return true};
	}

	Pudd( _selector ).puddRadio({
		attributes : {},
		controlAttributes : { name : _name, id : _id },
		value : _value,
		checked : _checked,
		disabled : false,
		label : _label,
		eventCallback : {
			"click" : function( e ) {
				_clickFn(e);
			}
		}
	});
}

/**
 * 파일 업로드 Form 생성
 */
CommonUtil.fileAreaInit = function( _selector ) {
	console.log(_selector)
	var fileList = []
	if( $( _selector ).length < 1 ) {
		return false;
	}

	if( !$( _selector ).hasClass("fileArea") ){
		$( _selector ).addClass("fileArea");
	}

	$( _selector ).empty();
	$( _selector ).off();
	$( _selector ).css({width:"96%", display: "inline-block"});
	$( _selector ).append(
		"<input type='file' multiple='multiple' style='display:none;'/>"+
		"<input type='button' class='addBtn' value='+ 파일추가' style='width:100%;border:1px dashed #a1a1a1;'>"
	);

	$( _selector ).on( "click" , ".deleteBtn" , function(e){
		var lastModified = $( e.target ).parent().children('input[name="lastModified"]').val()
		for(var i = 0; i < fileList.length; i++){
			if(fileList[i].lastModified == lastModified){
				fileList.splice(i,1)
			}
		}
		data = new FormData()
		for(var i = 0; i < fileList.length; i++){
			var file = fileList[i];
			data.append("file" + i, file);
		}
		$( e.target ).closest("div").remove();
	});

	$( _selector ).on( "click" , ".addBtn" , function(e){
		$( e.target ).closest("div").find("input[type='file']").click();
	});
	
	var fileName = ''
	$( _selector ).on( "change" , "input[type='file']" , function(e){
		for(var i = 0; i < $(this)[0].files.length; i++){
			fileList.push($(this)[0].files[i]);
		}
		fileName = $(this)[0].files
		for( var i = 0; i < fileList.length; i++ ){
			var file = fileList[i];
			data.append("file" +i, file);
		}
		console.log(data)
		

		$.each( fileName, function( index, item ){
			$( _selector ).prepend(
				"<div class='file active' style='display:inline-block;float:left;width: 100%;margin-bottom: 3.5px;'>"+
				"<input type='hidden' name='lastModified' value='" + item.lastModified + "' />"+
				"<span class='fileName' style='display:inline-block;margin-top:3px;font-size: 10pt;font-family: inherit;'>" + item.name + "</span>"+
				"<input type='button' class='deleteBtn' value='-' style='float:right;padding: 0 8px 0 8px;'/>"+
				"</div>"
			);
		});
	});
	console.log(fileList)
}

/**
 * 업로드된 파일 정보 세팅
 */
CommonUtil.fileAreaDataSet = function( _selector, _linkTable, _linkKey, _addUse, _deleteUse, _dummy1) {
	var fileList = []
	
	if( $( _selector ).length < 1 ) {
		return false;
	}

	if( !$( _selector ).hasClass("fileArea") ){
		$( _selector ).addClass("fileArea");
	}

	$( _selector ).empty();
	$( _selector ).off();
	$( _selector ).append(
		"<input type='file' multiple='multiple' style='display:none;'/>"+
		"<input type='button' class='addBtn' value='+ 파일추가' style='width:100%;border: 1px dashed #a1a1a1;'>"
	);
	$( _selector ).on( "click" , ".deleteBtn" , function(e){
		var lastModified = $( e.target ).parent().children('input[name="lastModified"]').val()
		var attatchFileId = $( e.target ).parent().children('input[name="attatchFileId"]').val()
		var attatchFileSn = $( e.target ).parent().children('input[name="attatchFileSn"]').val()
		if(attatchFileId != '' && attatchFileId != null && attatchFileId != 'undefined'){
			var list = {
				attatchFileId : attatchFileId,
				attatchFileSn : attatchFileSn,
			}
			console.log(list)
			fileDelList.push(list)	
		}
		
		for(var i = 0; i < fileList.length; i++){
			if(fileList[i].lastModified == lastModified){
				fileList.splice(i,1)
			}
		}
		data = new FormData()
		for(var i = 0; i < fileList.length; i++){
			var file = fileList[i];
			data.append("file" + i, file);
		}
		$( e.target ).closest("div").remove();
	});

	$( _selector ).on( "click" , ".addBtn" , function(e){
		$( e.target ).closest("div").find("input[type='file']").click();
	});

	var fileName = ''
	$( _selector ).on( "change" , "input[type='file']" , function(e){
		for(var i = 0; i < $(this)[0].files.length; i++){
			fileList.push($(this)[0].files[i]);
		}
		fileName = $(this)[0].files
		for( var i = 0; i < fileList.length; i++ ){
			var file = fileList[i];
			data.append("file" +i, file);
		}
		
			$.each( fileName, function( index, item ){
				$( _selector ).prepend(
					"<div class='file active' style='display:inline-block;float:left;width: 100%;margin-bottom: 3.5px;'>"+
					"<input type='hidden' name='lastModified' value='" + item.lastModified + "' />"+
					"<span class='fileName' style='display:inline-block;margin-top:3px;font-size: 10pt;font-family: inherit;'>" + item.name + "</span>"+
					"<input type='button' class='deleteBtn' value='-' style='float:right;padding: 0 8px 0 8px;'/>"+
					"</div>"
				);
			});
	});
	$( _selector ).css({width:"96%", display: "inline-block"});

	$( _selector ).on("click", ".file .fileName", function(){
		var attatchFileId = $(this).closest("div").find("input[name='attatchFileId']").val();
		var attatchFileSn = $(this).closest("div").find("input[name='attatchFileSn']").val();
		location.href = _g_contextPath_ + "/file/fileDownload?attatchFileId=" + attatchFileId + "&attatchFileSn=" + attatchFileSn;
	});

	if( _deleteUse ){
		$( _selector ).on("click", ".file .deleteBtn", function(e){
			$( e.target ).closest("div").remove();
		});
	}
	console.log(fileList)

	var param = {
		fileLinkTable : _linkTable,
		fileLinkKey : _linkKey,
		dummy1 : _dummy1
	}
	CommonUtil.postAjax( "/file/getAttatchFileLinkList", param ).done( function(result){
		var list = result.list;
		$.each( list, function( index, item ){
			if( _deleteUse ){
				$( _selector ).prepend(
					"<div class='file active' style='display:inline-block;float:left;width: 100%;height: 26px;margin-bottom: 3.5px;'>"+
					"<span href='javascript:;' class='fileName' style='display:inline-block;margin-top:3px;font-size: 10pt;font-family: inherit;cursor: pointer;'>" + item.originFileNm + "</span>"+
					"<input type='hidden' name='attatchFileId' value='" + item.attatchFileId + "' />"+
					"<input type='hidden' name='attatchFileSn' value='" + item.attatchFileSn + "' />"+
					"<input type='button' class='deleteBtn' value='-' style='float:right;padding: 0 8px 0 8px;'/>"+
					"</div>"
				);
			}else{
				$( _selector ).prepend(
					"<div class='file active' style='display:inline-block;float:left;width: 100%;height: 26px;margin-bottom: 3.5px;'>"+
					"<span href='javascript:;' class='fileName' style='display:inline-block;margin-top:3px;font-size: 10pt;font-family: 맑은고딕;cursor: pointer;'>" + item.originFileNm + "</span>"+
					"<input type='hidden' name='attatchFileId' value='" + item.attatchFileId + "' />"+
					"<input type='hidden' name='attatchFileSn' value='" + item.attatchFileSn + "' />"+
					"<input type='button' class='deleteBtn' value='-' style='float:right;padding: 0 8px 0 8px;'/>"+
					"</div>"
				);
			}
		});
	});
}

//연구과제에서 입력한 첨부파일
CommonUtil.fileAreaDataSet2 = function( _selector, _linkTable, _linkKey, _addUse, _deleteUse, _dummy1) {
	var fileList = []
	
	if( $( _selector ).length < 1 ) {
		return false;
	}

	if( !$( _selector ).hasClass("fileArea") ){
		$( _selector ).addClass("fileArea");
	}

	$( _selector ).empty();
	$( _selector ).off();


	var fileName = ''
	$( _selector ).on( "change" , "input[type='file']" , function(e){
		for(var i = 0; i < $(this)[0].files.length; i++){
			fileList.push($(this)[0].files[i]);
		}
		fileName = $(this)[0].files
		for( var i = 0; i < fileList.length; i++ ){
			var file = fileList[i];
			data.append("file" +i, file);
		}
		
			$.each( fileName, function( index, item ){
				$( _selector ).prepend(
					"<div class='file active' style='display:inline-block;float:left;width: 100%;margin-bottom: 3.5px;'>"+
					"<input type='hidden' name='lastModified' value='" + item.lastModified + "' />"+
					"<span class='fileName' style='display:inline-block;margin-top:3px;font-size: 10pt;font-family: inherit;'>" + item.name + "</span>"+
					"</div>"
				);
			});
	});
	$( _selector ).css({width:"96%", display: "inline-block"});

	$( _selector ).on("click", ".file .fileName", function(){
		var attatchFileId = $(this).closest("div").find("input[name='attatchFileId']").val();
		var attatchFileSn = $(this).closest("div").find("input[name='attatchFileSn']").val();
		location.href = _g_contextPath_ + "/file/fileDownload2?attatchFileId=" + attatchFileId + "&attatchFileSn=" + attatchFileSn;
	});

	if( _deleteUse ){
		$( _selector ).on("click", ".file .deleteBtn", function(e){
			$( e.target ).closest("div").remove();
		});
	}

	var param = {
		fileLinkTable : _linkTable,
		fileLinkKey : _linkKey,
		dummy1 : _dummy1
	}
	CommonUtil.postAjax( "/file/getAttatchFileLinkList2", param ).done( function(result){
		var list = result.list;
		$.each( list, function( index, item ){
			if( _deleteUse ){
				$( _selector ).prepend(
					"<div class='file active' style='display:inline-block;float:left;width: 100%;height: 26px;margin-bottom: 3.5px;'>"+
					"<span href='javascript:;' class='fileName' style='display:inline-block;margin-top:3px;font-size: 10pt;font-family: inherit;cursor: pointer;'>" + item.originFileNm + "</span>"+
					"<input type='hidden' name='attatchFileId' value='" + item.attatchFileId + "' />"+
					"<input type='hidden' name='attatchFileSn' value='" + item.attatchFileSn + "' />"+
					"</div>"
				);
			}else{
				$( _selector ).prepend(
					"<div class='file active' style='display:inline-block;float:left;width: 100%;height: 26px;margin-bottom: 3.5px;'>"+
					"<span href='javascript:;' class='fileName' style='display:inline-block;margin-top:3px;font-size: 10pt;font-family: 맑은고딕;cursor: pointer;'>" + item.originFileNm + "</span>"+
					"<input type='hidden' name='attatchFileId' value='" + item.attatchFileId + "' />"+
					"<input type='hidden' name='attatchFileSn' value='" + item.attatchFileSn + "' />"+
					"</div>"
				);
			}
		});
	});
}

/** 특정 데이터Row에 연결된 첨부파일 목록 알집으로 내려받기 **/
CommonUtil.fileDownZip = function( _paramObj ){
	if( _paramObj.fileLinkKey == null || _paramObj.fileLinkKey == ""){
		alert("잘못된 데이터정보입니다.");
		return false;
	}
	if( _paramObj.fileLinkTable == null || _paramObj.fileLinkTable == ""){
		alert("잘못된 데이터정보입니다.");
		return false;
	}

	var url = _g_contextPath_ + "/file/fileDownZip";

	var $form = $("<form></form>");
	$form.attr("action", url);
	$form.attr("method", "post");
	for(var name in _paramObj){
		$form.append( $("<input name='" + name + "' type='hidden' value='" + _paramObj[name] + "'>") );
	}
	$form.appendTo("body");

	$form.submit();
}

/**
 * 첨부파일 Clear
 */
CommonUtil.fileAreaClear = function( _selector ){
	if( $( _selector ).length < 1 ) {
		return false;
	}

	$( _selector ).find("div.file").remove();
}

/**
 * 날짜차이 구하기 ( 리턴값 : day )
 */
CommonUtil.getDayDiff = function( _startDate, _endDate ) {
	if( _startDate === null || _startDate === "" ){
		return 0;
	}
	if( _endDate === null || _endDate === "" ){
		return 0;
	}

	_startDate = _startDate.replace(/[-]/g,'').substr(0,4) + "-" + _startDate.replace(/[-]/g,'').substr(4,2) + "-" + _startDate.replace(/[-]/g,'').substr(6,2);
	_endDate = _endDate.replace(/[-]/g,'').substr(0,4) + "-" + _endDate.replace(/[-]/g,'').substr(4,2) + "-" + _endDate.replace(/[-]/g,'').substr(6,2);

	var startDate = new Date( _startDate );
	var endDate = new Date ( _endDate );
	var diff = ( endDate.getTime() - startDate.getTime() ) / ( 1000 * 60 * 60 * 24 ) + 1;

	if( diff < 0 ){
		diff = 0;
	}
	return diff;
}

/**
 * UniqueKey 생성
 */
CommonUtil.getUniqueKey = function( _key ) {
	if( _key == null ){
		_key = "";
	}
	var today = new Date();
	var uniqueKey = _key + "" + today.getFullYear() + "" + (today.getMonth() + 1) + "" + today.getDate() + "" + today.getHours() + "" + today.getMinutes() + "" + today.getSeconds() + "" + today.getMilliseconds();
	return uniqueKey;
}

/**
 * 요소에 Drag 이벤트 세팅
 * ( 데이터 전달 방법 : 객체 전달 안됨 )
 * event.dataTransfer.setData('data', id);
 * event.dataTransfer.getData('data', id);
 */
CommonUtil.dragInit = function( _dragSelector, _dragStartFn, _dragEndFn ) {

	if( $( _dragSelector ).length < 1 ){
		return false;
	}

	if( _dragStartFn == null ){
		_dragStartFn = function(){};
	}

	if( _dragEndFn == null ){
		_dragEndFn = function(){};
	}

	$( _dragSelector ).attr("draggable", true);
	$( _dragSelector ).on({
		dragstart : function( e ){
			if( typeof( _dragStartFn ) === "function" ){
				_dragStartFn( e );
			}
		},
		dragend : function( e ){
			if( typeof( _dragEndFn ) === "function" ){
				_dragEndFn( e );
			}
		}
	});
}

/**
 * 요소에 Drop 이벤트 세팅
 */
CommonUtil.dropInit = function( _targetSelector, _enterFn, _leaveFn, _dropFn, _dragOverFn ) {

	if( $( _targetSelector ).length < 1 ){
		return false;
	}

	if( _dropFn == null ){
		_dropFn = function(){};
	}

	if( _dragOverFn == null ){
		_dragOverFn = function(){};
	}


	$( _targetSelector ).on({
		dragenter : function(e){
			e.preventDefault();
			e.stopPropagation();
			if( typeof( _enterFn ) === "function" ){
				if($(_targetSelector).toArray().indexOf($(e.relatedTarget)[0]) >= 0){
					_enterFn( e );
				}
			}
		},
		dragleave : function(e){
			e.preventDefault();
			e.stopPropagation();
			if( typeof( _leaveFn ) === "function" ){
				if($(_targetSelector).toArray().indexOf($(e.relatedTarget)[0]) >= 0){
					_leaveFn( e );
				}
			}
		},
		dragover : function( e ){
			e.preventDefault();
			e.stopPropagation();
			if( typeof( _dragOverFn ) === "function" ){
				_dragOverFn( e );
			}
		},
		drop : function( e ){
			e.preventDefault();
			if( typeof( _dropFn ) === "function" ){
				_dropFn( e );
			}
		}
	});
}

/**
 * Pudd Grid 체크된 데이터 List 가져오기
 */
CommonUtil.getPuddGridCheckedList = function( _selector ) {

	var puddGrid = Pudd( _selector ).getPuddObject();
	if( ! puddGrid ) return null;

	var dataCheckedRow = puddGrid.getGridCheckedRowData( "gridCheckBox" );

	return dataCheckedRow;
}


/**
 * Pudd Grid 선택된 데이터 List 가져오기
 */
CommonUtil.getPuddGridSelectedData = function( _selector ) {

	var puddGrid = Pudd( _selector ).getPuddObject();
	if( ! puddGrid ) return null;

	var rowData = puddGrid.getGridSelectedRowData();

	return rowData;
}


/**
 * 더존 전자결재 연동
 */
CommonUtil.interlockDuzon = function( _processId, _pk, _subject, _contentStr ) {
	return new Promise(function(resolve, reject){

		$("#viewerForm input[name='outProcessCode']").val( _processId );
		$("#viewerForm input[name='subjectStr']").val( _subject );
		$("#viewerForm input[name='contentsStr']").val( _contentStr );
		$("#viewerForm input[name='mod']").val("W");

		var params = {
			processId : _processId,
			apprCd : _pk
		}
		CommonUtil.postAjax("/common/createApproKey", params).done(function(result){
			var approKey = result.approKey;

			if ( _processId == null && _processId == "") {
				reject( new Error("외부시스템 연동코드를 입력해주세요.") );
			}
			if ( $("#viewerForm input[name='compSeq']").val() == "") {
				reject( new Error("회사번호를 입력해주세요.") );
			}
			if ( $("#viewerForm input[name='empSeq']").val() == "") {
				reject( new Error("사원번호를 입력해주세요.") );
			}

			$("#viewerForm input[name='approKey']").val( approKey );

			var form = document.getElementById("viewerForm");
			var win = window.open("", "viewer", "width=965, height=670, scrollbars=yes, resizable=yes, status=no, top=50, left=50");
			form.action = "/gw/outProcessLogOn.do";
			form.submit();
			resolve();
		}).fail(function(response){
			try{
				var responseText = JSON.parse(response.responseText);
				reject( new Error("문서번호 채번 도중 에러가 발생했습니다. 관리자에게 문의해주세요.") );
			}catch(err){
				console.log(err);
			}
		});
	});
}

/**
 * 더존 전자결재 문서 보기
 */
CommonUtil.draftView = function( _processId, _docId ) {
	return new Promise(function(resolve, reject){

		$("#viewerForm input[name='outProcessCode']").val( _processId );
		$("#viewerForm input[name='mod']").val("V");
		$("#viewerForm input[name='docId']").val( _docId );

		var form = document.getElementById("viewerForm");
		var win = window.open("", "viewer", "width=965, height=670, resizable=yes, scrollbars=yes, status=no, top=50, left=50");
		form.action = "/gw/outProcessLogOn.do";
		form.submit();
		resolve();
	});
}

/**
 * 더존 조직도 호출
 * _mode : u(사원), d(부서), ud(사용자 부서), od(부서 조직도), oc(회사 조직도)
 * _item : s(단일선택), m(다중선택)
 * _callback : callback function
 * **/
CommonUtil.callOrgPop = function(_mode, _item, _callback) {
	if(_g_host === "localhost"){
		CommonUtil.openPopup( "/orgChart/orgChartForm", {"callback" : _callback, "popType" : _mode, "selType" : _item}, "ftSelWork", "800", "700", "" );
	}else{
		var gwDomain = "";
		var pop = window.open("", "cmmOrgPop", "width=799,height=769,scrollbars=no");
		$('#frmPop').find('input[name=popUrlStr]').val(gwDomain + "/gw/systemx/orgChartAttend.do");
		$('#frmPop').find('input[name=selectMode]').val(_mode);
		$('#frmPop').find('input[name=selectItem]').val(_item);
		$('#frmPop').find('input[name=callback]').val(_callback);
		$('#frmPop').attr("target", "cmmOrgPop");
		$('#frmPop').attr("method", "post");
		$('#frmPop').attr("action", _g_contextPath_+"/comPop/orgPop");
		$('#frmPop').submit();
		pop.focus();
	}
}

/* 데이터 그룹핑 */
CommonUtil.groupBy = function (_data, _key) {
	return _data.reduce(function (carry, el) {
		var group = 'g_' + el[_key];

		if (carry[group] === undefined) {
			carry[group] = []
		}

		carry[group].push(el)
		return carry
	}, {})
}

/* 두 기간 사이 날짜 배열로 가져오기 YYYYMMDD */
CommonUtil.betweenDates = function(_startDate, _endDate) {
	var dates = [];
	_startDate = moment(_startDate, 'YYYYMMDD');
	_endDate = moment(_endDate, 'YYYYMMDD');
	startDate = _startDate.add(1, 'days');
	while(startDate.format('M/D/YYYY') !== _endDate.format('M/D/YYYY')) {
		dates.push(startDate.format('YYYYMMDD'));
		startDate = _startDate.add(1, 'days');
	}
	return dates;
};

/** 문자열 채우기 **/
CommonUtil.lpad = function(_string, _length, _padStr){
	_string = "" + _string;
	while (_string.length < Number(_length)){
		_string = _padStr + _string;
	}
	return _string;
}

/** 문자열 채우기 **/
CommonUtil.rpad = function(_string, _length, _padStr){
	_string = "" + _string;
	while (_string.length < Number(_length)){
		_string = _string + _padStr;
	}
	return _string;
}

CommonUtil.errAlert = function(_message){
	var puddDialog = Pudd.puddDialog({
		 
		width : 300
	,	height : 100
 
	,	message : {
			type : "error"
		,	content : _message
		}
	});	
}

CommonUtil.sucAlert = function(_message){
	var puddDialog = Pudd.puddDialog({
		 
		width : 300
	,	height : 100
 
	,	message : {
			type : "success"
		,	content : _message
		}
	});	
}
