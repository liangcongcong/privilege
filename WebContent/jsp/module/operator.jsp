<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../fragment/basePath.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Operator Manage Page</title>
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
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="grid.edatagrid('addRow')">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="grid.edatagrid('cancelRow')">取消</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="grid.edatagrid('destroyRow')">删除</a>
	</div>
	
	<table id="grid"></table>
	
	<script>
    $(document).ready(function () {
    	//填充字典数据
    	//getRemoteData(requestUserClassParam,getRemoteUserClassUrl,loadDataUserClassList,false);
        //配置表格
        grid = $('#grid').edatagrid({
			title: '条件连接符管理',
            method: 'post',
            url: '<%=basePath%>manage/operator/list',
            saveUrl: '<%=basePath%>manage/operator/add',
            updateUrl: '<%=basePath%>manage/operator/update',
            //只传id
            destroyUrl: '<%=basePath%>manage/operator/del',
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
			columns : [ [
					{
						field : 'caption',
						title : '运算符',
						width : 50,
						align : 'center',
						sortable : true,
						halign : 'center',
						editor :
							{
								type : 'validatebox',
								options : 
									{
										validType : 'length[1,16]',
										invalidMessage : '有效长度1-16',
										required : true
									}
							}

					},
					{
						field : 'description',
						title : '描述',
						width : 80,
						align : 'center',
						sortable : true,
						halign : 'center',
						editor : {
									type : 'text',
									options : {
												required : false
											}
								}
					} ] ],
					
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
			
			onSuccess : function(index,result) {
							grid.datagrid("reload");
							$.messager.show(
									{
										title : "消息",
										msg : result.msg
									});
						},
			onDestroy : function(index,result) {
								grid.datagrid("reload");
								$.messager.show(
									{
										title : "消息",
										msg : result.msg
									});
						},
			onEdit:function(index,row){
				
						}
						
			}); // edatagrid end

			grid.datagrid("getPager").pagination({
						pageSize : 10,
						pageList : [ 10, 20, 30, 40, 50, 100 ]
			});
			
			grid.datagrid('resize', {
						height : ($(window).height() - 36)
						
			});
			
	}); // ready end

	function doSearch() {
		grid.datagrid("load", {
				caption : $("#fieldSearchByCaption").val()
		});
	}
	</script>
</body>
</html>