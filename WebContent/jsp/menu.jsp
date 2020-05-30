<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="fragment/basePath.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Menu Page</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/login.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyUI/themes/material-blue/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyUI/themes/icon.css">
	
	<script type="text/javascript" src="<%=basePath%>js/easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyUI/locale/easyui-lang-zh_CN.js"></script>
</head>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height: 60px; background: #52727A; padding: 20px;color:white">Privilege
		Management</div>
	<div data-id="leftmenu" style="width: 190px; overflow: auto;"
		data-options="region:'west',split:false,collapsible:false,style:{textAlign:'left'}">
		<ul id="menutree"></ul>
	</div>
	<!--<div
		data-options="region:'east',split:true,collapsed:true,title:'East'"
		style="width: 100px; padding: 10px;">east region</div>-->
	<div data-options="region:'south',border:false"
		style="height: 50px; background: #52727A; padding: 15px;text-align: center;color:white;">Copyright &copy;2019 Privilege Management</div>
	<div data-options="region:'center',split:true">
		<!--  -->
		<div id="mainTabs" class="easyui-tabs"
			data-options="toolPosition:'right',fit:true,border:false">
			<div title="主页">欢迎使用。</div>
		</div>
	</div>
</body>
<script>
   renderLeftMenu();
   function renderLeftMenu() {
	$("#menutree").tree({
		    url : "<%=basePath%>json/treedata.json",
			rootWidth : "184",
			kidWidth : "180",
			height : "auto",
			onSelect : function(node) {
				var isLeaf = $(this).tree('isLeaf', node.target);//只可选择tree子节点
				if (isLeaf) {
					openLeftWin(node);//打开新的tabs
				}
			}
		});
	}
	/**打开新的tabs **/
	function openLeftWin(node) {
		var tabName = node.text;
		var url = node.page;
		var content = createFrame(url);
		if ($("#mainTabs").tabs("exists", tabName)) {// 如果已存在，选中
			$("#mainTabs").tabs("select", tabName);
		} else {
			$("#mainTabs").tabs("add", {
				title : tabName,
				selected : true,
				closable : true,
				content : content,
			});
		}
	}
	function createFrame(url) {
		var s = '<iframe scrolling="auto" frameborder="0"  src="' + url
				+ '" style="width:100%;height:100%;"></iframe>';
		return s;
	}
</script>
</html>