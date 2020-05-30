<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../fragment/basePath.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Role Field Manage Page</title>
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
	<div id="tb" style="padding:5px;height:auto">
		<!-- 两个联动的下拉框 -->
		项目名称：<input id="projectName" class="easyui-combobox" />
		<!--<a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="previousComboboxDatas()">点击加载上一批下拉框数据</a>-->
		<!--<a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="nextComboboxDatas()">点击加载下一批下拉框数据</a>-->
	</div>
	<script>
	var grid;
    $(document).ready(function () {
        grid = $('#grid').edatagrid({
			title: '',
            method: 'post',
            toolbar:"#tb",
            url: '<%=basePath%>manage/roleField/list',
            saveUrl: '<%=basePath%>manage/roleField/add',
            updateUrl: '<%=basePath%>manage/roleField/update',
            //只传id
            destroyUrl: '<%=basePath%>manage/roleField/del',
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
				//	field : 'id',
				//	title : 'ID',
				//	width : 50,
				//	sortable : true,
				//	align : 'center',
				//	halign : 'center'
				//}, {
					field : 'fieldName',
					title : '属性名',
					width : 50,
					align : 'center',
					sortable : true,
					halign : 'center',
					editor : {
						type : 'validatebox',
						options : {
							validType : 'length[1,64]',
							invalidMessage : '有效长度1-64',
							required : true
						}
					}

				},
				{
					field : 'fieldType',
					title : '属性类型',
					width : 50,
					align : 'center',
					sortable : true,
					halign : 'center',
					editor : {
						type : 'validatebox',
						options : {
							validType : 'length[1,128]',
							invalidMessage : '有效长度1-128',
							required : true
						}
					}

				},
				{
					field : 'description',
					title : '描述',
					width : 50,
					align : 'center',
					sortable : true,
					halign : 'center',
					editor : {
						type : 'text',
						options : {
							/*validType : 'length[1,10]',
							invalidMessage : '有效长度1-10',*/
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
				onSuccess : function(index, result) {
					//getRemoteData(requestUserClassParam,getRemoteUserClassUrl,loadDataUserClassList,false);
					grid.datagrid("reload");
					$.messager.show({
						title : "消息",
						msg : result.msg
					});
				},
				onDestroy : function(index, result) {
					grid.datagrid("reload");
					$.messager.show({
						title : "消息",
						msg : result.msg
					});
				}
			});
          $("#projectName").combobox({
				editable:true,
				panelHeight:320,
				valueField:"id",//项目的id
				textField:"projectName",
				method:"post",
				url:"<%=basePath%>manage/project/comboBoxList",
				/*queryParams:{
					page:pageForCombobox,
					rows:pageSizeForCombobox
				},*/
            	onSelect: function (record) {
            		//alert("projectId="+record.id);
            		//var projectId=$("#projectName").combobox("getValue");
            		grid.datagrid('load', {
            			projectId:record.id
           			});
            		//grid.datagrid('load',{});加{}这个参数，会清空额外携带的参数。
            		
            		//不加{}，会保留额外的参数。但是，参数值不变。
            		//grid.datagrid('load');
            	},
   				onLoadSuccess:function(){
				    //var data=$("#projectName").combobox("getData");
				    $('#projectName').combobox("setValue","请选择");
				    /*if(data.length>0){
				    	//默认选择第一个学校
				    	//$('#projectName').combobox("setValue",data[0].id);
				   	}*/
				}
          });
		grid.datagrid("getPager").pagination({
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50, 100 ]
		});
		grid.datagrid('resize', {
			height : ($(window).height() - 36)
		});
    });
	</script>
</body>
</html>