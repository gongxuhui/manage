<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>公司管理系统</title>
<!--引入js和css样式   这个要先引入css样式-->
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="easyui/css/home.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="easyui/js/home.js"></script>
</head>
<body class="easyui-layout" style="overflow-y: hidden">
	<!--页面实现的上面的区域  -->
	<div id="north" region="north"
		style="overflow: hidden; height: 100px; background: #D2E0F2 repeat-x center 50%;">
		<div>
			<h1 style="text-align: center">荣天汇海管理系统</h1>
		</div>
		<div
			style="width: 30px; height: 10px; float: right; padding-right: 10px; padding-bottom: 30px">
			<a href="login.jsp"><h3>注销</h3></a>
		</div>
	</div>

	</div>
	<!--页面实现的左侧菜单   split:分离-->
	<div region="west" split="true" title="<center><h2>导航菜单</h2></center>"
		style="width: 150px;">
		<!-- fit属性:使其适应 -->
		<div id="menu" class="easyui-accordion" fit="true" border="false">
			<div title="<center><h3>人事管理</h3></center>"
				style="overflow: auto; padding: 10px;" icon="icon-edit">
				<!-- 员工信息 -->
				<div>
					<ul>
						<li>
							<div
								style="background: url('easyui/images/11.png') left no-repeat scroll;">
								<a target="mainFrame" href="tree.jsp"><h4 style="text-align: center">员工信息</h4></a>
							</div>
						</li>
					</ul>
				</div>
				<!--用户信息 -->
				<div>
					<ul>
						<li>
							<div
								style="background: url('easyui/images/12.png') left no-repeat scroll;">
								<a target="mainFrame" href="levelsalary.jsp"><h4 style="text-align: center">信息分析</h4></a>
							</div>
						</li>
					</ul>
				</div>
				<!--用户权限  -->
				<div>
					<ul>
						<li>
							<div
								style="background: url('easyui/images/13.png') left no-repeat scroll;">
								<a target="mainFrame" href="salary.jsp"><h4 style="text-align: center">薪水分析</h4></a>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div title="<center><h3>产品管理</h3></center>"
				style="overflow: auto; padding: 10px;" icon="icon-edit">
				<!--产品信息  -->
				<div>
					<ul>
						<li>
							<div
								style="background: url('easyui/images/21.png') left no-repeat scroll;">
								<a target="mainFrame" href="echartpie.jsp"><h4 style="text-align: center">产品信息</h4></a>
							</div>
						</li>
					</ul>
				</div>
				<!-- 销售信息 -->
				<div>
					<ul>
						<li>
							<div
								style="background: url('easyui/images/22.png') left no-repeat scroll;">
								<a target="mainFrame" href="echartpie1.jsp"><h4 style="text-align: center">销售信息</h4></a>
							</div>
						</li>
					</ul>
				</div>
				<!--盈利信息  -->
				<div>
					<ul>
						<li>
							<div
								style="background: url('easyui/images/23.png') left no-repeat scroll;">
								<a target="mainFrame" href="echartbar.jsp"><h4 style="text-align: center">盈利信息</h4></a>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div title="<center><h3>关于</h3></center>"
				style="overflow: auto; padding: 10px;" icon="icon-edit">
				<div>
					<ul>
						<li>
							<div
								style="background: url('easyui/images/31.png') left no-repeat scroll;">
								<a target="mainFrame" href="about.jsp"><h4 style="text-align: center">关于</h4></a>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--页面实现的中间区域（视频）  -->
	<div region="center" id="mainPanle"
		style="background: #eee; overflow: hidden;">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div title="主页" style="padding: 20px; text-align: center" id="home">
					<div
						style="font-size: 35px; font-style: italic; color: #4dbaff">
						<h2>不负春光，野蛮生长</h2>
					</div>

					<div style="font-size: 35px; font-style: italic; color: #ff3948;margin-top: 100px">
						<h2>欢迎使用荣天汇海管理系统</h2>
					</div>
			</div>
		</div>
	</div>
	<!--页面实现的下边区域  -->
	<div region="south" style="height: 20px; background: #D2E0F2;">
		<div style="text-align: center; font-weight: bold">Knight1.0版</div>
	</div>
</body>
</html>