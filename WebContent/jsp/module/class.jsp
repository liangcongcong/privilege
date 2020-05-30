<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../fragment/basePath.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Role Manage Page</title>
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
<div>
	<div id="controlBox">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="grid.edatagrid('addRow')">添加</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="grid.edatagrid('cancelRow')">取消</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="grid.edatagrid('destroyRow')">删除</a>
	</div>
	<div id="tb" style="padding:5px;height:auto">
		<!-- 两个联动的下拉框 -->
		项目选择：<input id="projectName" class="easyui-combobox" />
		<!--<a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="previousComboboxDatas()">点击加载上一批下拉框数据</a>-->
		<!--<a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="nextComboboxDatas()">点击加载下一批下拉框数据</a>-->
	</div>
	<table id="grid"></table>
	</div>
	<!--这是一个弹出窗口easyui-dialog，我在它里面放了一个datagrid-->
 <div id="dlg" class="easyui-dialog"  style="width: 800px; height: auto;"
         data-options="closed:true,buttons:'#dlg-buttons'">
         <div id="content">
         <div id="controlBox">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="gridDialog.edatagrid('addRow')">添加</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="gridDialog.edatagrid('cancelRow')">取消</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="gridDialog.edatagrid('destroyRow')">删除</a>
	</div>
	<br>
        <table id="datagridDialog"></table>
        </div>
    </div> 
	<script>
	var grid;
	var gridDialog;
    $(document).ready(function () {
        grid = $('#grid').edatagrid({
			title: '类列表',
            method: 'post',
            toolbar:"#tb",
            url: '<%=basePath%>manage/classes/list',
            saveUrl: '<%=basePath%>manage/classes/add',
            updateUrl: '<%=basePath%>manage/classes/update',
            //只传id
            destroyUrl: '<%=basePath%>manage/classes/del',
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
					field : 'className',
					title : '全路径类',
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

				}, {
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
				},
				 {
                    field: 'opt', title: '操作', width: 100, align: 'center',
                    formatter: function (value,row,index) {
                    	//参数row表示当前行, 参数index表示当前行的索引值
                        //row.Id表示这个button按钮所在的那一行的Id这个字段的值
                        //按钮点击事件无效，也不晓得为啥
                        //var btn = '<input type="button" id="btn" value="类扫描"  οnclick="LoadFieldInfo('+row.id+')"/>';
                        //这里使用a链接
                         var btn='<a onclick="LoadFieldInfo('+row.id+',\''+row.className+'\')">类扫描</a>';
                        return btn;
                    }
                }] ],
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
    function LoadGridDialog()
	{
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
	};
    function LoadFieldInfo(id,className) {
        /*获取选中行*/
        //var row = $('#datagridDialog').datagrid('getSelected'); //获取选中行
        this.LoadGridDialog();       
        this.gridDialog.datagrid('load', {
			classId:id
			});
        var dlg=$("#dlg").dialog({
        	title: "属性列表(隶属类:"+className+")",  	 
        }); 
        $('#dlg').dialog('open');  //弹出这个dialog框
    };
	</script>
</body>
</html>