<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../fragment/basePath.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>User Manage Page</title>
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
	var booleanString = '[{"code":true,"caption":"管理员"},{"code":false,"caption":"普通用户"}]';
	var dataBooleanList = JSON.parse(booleanString);;
    $(document).ready(function () {
    	//填充字典数据
    	//getRemoteData(requestUserClassParam,getRemoteUserClassUrl,loadDataUserClassList,false);
        //配置表格
        grid = $('#grid').edatagrid({
			title: '内部应用授权',
            method: 'post',
            url: '<%=basePath%>manage/user/list',
            saveUrl: '<%=basePath%>manage/user/add',
            updateUrl: '<%=basePath%>manage/user/update',
            //只传id
            destroyUrl: '<%=basePath%>manage/user/del',
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
						field : 'username',
						title : '用户帐号',
						width : 50,
						align : 'center',
						sortable : true,
						halign : 'center',
						editor :
							{
								type : 'validatebox',
								options : 
									{
										validType : 'length[1,32]',
										invalidMessage : '有效长度1-32',
										required : true
									}
							}

					},
					{
						field : 'realname',
						title : '用户实名',
						width : 50,
						align : 'center',
						sortable : true,
						halign : 'center',
						editor :
							{
								type : 'validatebox',
								options : 
									{
										validType : 'length[1,32]',
										invalidMessage : '有效长度1-32',
										required : true
									}
							}
					},
					{
						field : 'isAdmin',
						title : '角色',
						width : 80,
						align : 'center',
						sortable : true,
						halign : 'center',
						formatter:function(value,row){
							return fromCode2Caption(value,dataBooleanList);
	                    },
						editor : 
							{
								type : 'combobox',
								options : 
									{
										editable:false,
			                            valueField: 'code',
			                            textField: 'caption',
			                            data: dataBooleanList,
			                            panelHeight: 'auto',
			                            required: true
									}
							}
					},
					{
						field : 'password',
						title : '密码',
						width : 80,
						align : 'center',
						sortable : true,
						halign : 'center',
						editor : {
									type : 'validatebox',
									options : {
												validType : 'length[1,32]',
												invalidMessage : '有效长度1-32',
												required :false
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
						/*
						onSelectPage:function(pageNumber, pageSize){
							//alert('翻页\n'+pageNumber+"\n"+pageSize+"\n"+userClassPage+'\n'+pageSize);
							requestUserClassParam.page=pageNumber;
							requestUserClassParam.rows=pageSize;
							//alert('翻页\n'+pageNumber+"\n"+pageSize+"\n"+userClassPage+'\n'+pageSize);
							//getRemoteData(requestUserClassParam,getRemoteUserClassUrl,loadDataUserClassList,false);
						},
						onChangePageSize:function(pageSize){
							//alert('改变大小');
							requestUserClassParam.rows=pageSize;
							//getRemoteData(requestUserClassParam,getRemoteUserClassUrl,loadDataUserClassList,false);
						}
						*/
			});
			
			grid.datagrid('resize', {
						height : ($(window).height() - 36)
						}
			);
			
	}); // ready end

	function doSearch() {
		grid.datagrid("load", {
				caption : $("#fieldSearchByCaption").val()
		});
	}
	</script>
</body>
</html>