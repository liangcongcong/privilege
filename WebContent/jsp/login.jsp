<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="fragment/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login Page</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/login.css?v=20191221" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyUI/themes/material-blue/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyUI/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyUI/themes/my-custom/demo.css">
	<script type="text/javascript" src="<%=basePath%>js/easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyUI/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<div>
<form id="ff" method="GET" >
  <div>
    <h1>用户登录</h1>
  </div>
  <div>
    <input id="text" class="easyui-textbox" data-options="iconCls:'icon-man',iconWidth:30,iconAlign:'left',prompt:'用户名',required:true" name="username" style="width:100%;height:35px;" />
  </div>
  <div>
    <input id="password" class="easyui-passwordbox" data-options="iconWidth:30,iconAlign:'left',prompt:'密码' ,required:true" name="password"  style="width:100%;height:35px;" />
  </div>
  <div id="submit">
    <input id="btnSubmit" class="easyui-linkbutton" type="submit" value="登陆"  style="width:40%;height:35px;margin-right: 10%;" />
    <input id="btnReset" class="easyui-linkbutton"  type="button" value="重置" style="width:40%;height:35px;float: right;" />
  </div>
  </form>
 </div>
</body>
<script>
	$('#ff').form({
	    url:'<%=basePath%>request/login',
	    //成功提交之后
	    success:function(data){   	
			var js = $.parseJSON(data);
			var url = js.url;
			//alert(js.url);
			console.log(js.errorInfo);
			if(js.errorInfo==null){
				//重定向页面
				window.location.href='<%=basePath%>'+url;
			}else{
				alert(js.errorInfo);
			}
		}
	});  
	
	 $("#btnReset").click(function(){
         $("#ff").get(0).reset();
     });
</script>
</html>