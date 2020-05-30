<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../fragment/basePath.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>上传jar文件</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/app/bootstrap/theme.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/easyUI/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/easyUI/themes/color.css">

<script type="text/javascript"
	src="<%=basePath%>js/easyUI/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/easyUI/plugins/jquery.edatagrid.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/easyUI/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>js/helper.js"></script>
</head>
<style>
#panel {
	width: 40%;
	min-width: 40%;
	position: absolute;
	left: 30%;
	top: 25%;
}
</style>
<body>
	<div id="panel">
		<div class="easyui-panel" title="Upload File"
			style="padding: 30px 70px 50px 70px">
			<form id="form" method="post" enctype="multipart/form-data">
				<div style="margin-bottom: 20px">
					<input class="easyui-filebox" name="file"
						data-options="prompt:'Choose a file...'" style="width: 100%">
				</div>
				<div>
					<input class="easyui-linkbutton" type="button" value="重启服务器"
						style="width: 40%; height: 35px; margin-right: 10%;" /> <input
						class="easyui-linkbutton" type="submit" value="上传"
						style="width: 40%; height: 35px; float: right;" />
				</div>
			</form>
		</div>
	</div>
	<script>
	function show(data)
	{
		$.messager.show(
				{
					title : "消息",
					msg :data
				});
	}
    $('#form').form({
    url:'<%=basePath%>request/api/fileUpload/upload',
			//成功提交之后
	success : function(data) {
			  var js = $.parseJSON(data);
			  var msg = js.msg;
				show(msg);
			}
		});
	</script>
</body>
</html>