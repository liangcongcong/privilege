<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../fragment/basePath.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Link Manage Page</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/app/bootstrap/theme.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyUI/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyUI/themes/color.css">
	<script type="text/javascript" src="<%=basePath%>js/easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyUI/plugins/jquery.edatagrid.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyUI/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/helper.js"></script>
</head>
<body>
	<div id="controlBox">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="gridDialog.edatagrid('addRow')">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="gridDialog.edatagrid('cancelRow')">取消</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="gridDialog.edatagrid('destroyRow')">删除</a>
	</div>	
	<table id="datagridDialog"></table>
	
	<script>
	var gridDialog;
	var id = $('#dlg').dialog('options')["queryParams"]["id"]; 
	console.log(id);
    $(document).ready(function () {
    	 gridDialog=$("#datagridDialog").edatagrid({
	            method: 'post',
	            url: '<%=basePath%>manage/classField/list',
	            saveUrl: '<%=basePath%>manage/classField/add',
	            updateUrl: '<%=basePath%>manage/classField/update',
	            //只传id
	            destroyUrl: '<%=basePath%>manage/classField/del',
					border : false,
					rownumbers : true,
					remoteSort : true,
					nowrap : false,
					singleSelect : true,
					fitColumns : true,
					pagination : true,
					striped : true,
					autoSave : true,
					idField : "id",
					columns : [ [ {
						field : 'id',
						title : 'ID',
						width : 50,
						sortable : true,
						align : 'center',
						halign : 'center'
					}, {
						field : 'fieldName',
						title : '属性路径',
						width : 50,
						align : 'center',
						sortable : true,
						halign : 'center',
						editor : {
							type : 'validatebox',
							options : {
								validType : 'length[1,32]',
								invalidMessage : '有效长度1-32',
								required : true
							}
						}

					},
					{
						field : 'fieldType',
						title : '类型',
						width : 50,
						align : 'center',
						sortable : true,
						halign : 'center',
						editor : {
							type : 'validatebox',
							options : {
								validType : 'length[1,32]',
								invalidMessage : '有效长度1-32',
								required : true
							}
						}

					}]],
					destroyMsg : {
						norecord : {
							title : '警告',
							msg : '首先需要选中记录，然后在点击删除按钮'
						},
						confirm : {
							title : '确认',
							msg : '是否删除选中记录?'
						}
					},
					onSuccess : function(index, result) {
						gridDialog.datagrid("reload");
						$.messager.show({
							title : "消息",
							msg : result.msg
						});
					},
					onDestroy : function(index, result) {
						gridDialog.datagrid("reload");
						$.messager.show({
							title : "消息",
							msg : result.msg
						});
					}
	        });
    	  gridDialog.datagrid('load', {
 			classId:id
 			});
       
	})
	</script>
</body>
</html>