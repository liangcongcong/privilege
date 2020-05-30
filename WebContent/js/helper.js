
function getRemoteData(url,callBack,async){
	return request({},"post",url,callBack,async);
}

function fromCode2Caption(code, arrayList) {
	var items = $(arrayList);
	for(var index = 0;index<items.length;index++){     	
    	if(items[index].code==code){
			return items[index].caption;			
    	}
	}
	return "";
}
function fromProjectId2ProjectName(projectId, arrayList) {
	var items = $(arrayList);
	for(var index = 0;index<items.length;index++){     	
    	if(items[index].id==projectId){
			return items[index].projectName;			
    	}
	}
	return "";
}
function request(object,method,methodURL,successFunction,async){	
	$.ajax({
        cache: true,
        async:async,
        type: method,
        datatype:"json",
        contentType: "application/json",
        url:methodURL,
        data:JSON.stringify(object),
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        	 alert(XMLHttpRequest.status+"\r\n"+XMLHttpRequest.readyState+"\r\n"+textStatus);
        },
        success: successFunction
    });			
 } 

function requestForm(object,method,methodURL,successFunction,async){
	$.ajax({
        cache: true,
        async:async,
        type: method,
        url:methodURL,
        data:object,
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        	
        	 alert(XMLHttpRequest.status+"\r\n"+XMLHttpRequest.readyState+"\r\n"+textStatus);
        },
        success: successFunction
    });			
 } 

Date.prototype.format = function(format)
{
	var o = {		 
		 "M+" : this.getMonth()+1, //month
		 "d+" : this.getDate(),    //day
		 "H+" : this.getHours(),   //hour
		 "m+" : this.getMinutes(), //minute
		 "s+" : this.getSeconds(), //second
		 "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
		 "S" : this.getMilliseconds() //millisecond
	 };
	 if(/(y+)/.test(format)) 
		 format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
	 
	 for(var k in o)
		 	if(new RegExp("("+ k +")").test(format))
		 			format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
	 return format;
}