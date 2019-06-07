<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>公司员工管理系统</title>
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
			<center>
				<h1>公司管理系统</h1>
			</center>
		</div>
		<div
			style="width: 30px; height: 10px; float: right; padding-right: 10px; padding-bottom: 30px">
			<a href="login.jsp"><h3>注销</h3></a>
		</div>

		<!-- <div
			style="width: 50px; height: 10px; float: right; padding-right: 60px; padding-bottom: 30px">
			<h3>用户:</h3>
		</div>
 -->
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
								<a target="mainFrame" href="tree.jsp"><center>员工信息</center></a>
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
								<a target="mainFrame" href="levelsalary.jsp"><center>信息分析</center></a>
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
								<a target="mainFrame" href="salary.jsp"><center>薪水分析</center></a>
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
								<a target="mainFrame" href="echartpie.jsp"><center>产品信息</center></a>
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
								<a target="mainFrame" href="echartpie1.jsp"><center>销售信息</center></a>
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
								<a target="mainFrame" href="echartbar.jsp"><center>盈利信息</center></a>
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
								<a target="mainFrame" href="test.jsp"><center>关于</center></a>
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
			<div title="主页" style="padding: 20px;" id="home">
				<center>
					<!-- <div
						style="font: italic; font-size: 35px; font-style: italic; color: #FFFF00">
						<h1>Knight</h1>
					</div>-->
					
					 <div
						style="font: italic; font-size: 35px; font-style: italic; color: #7FFF00">
						不负春光，野蛮生长
					</div> 
					<div>
						<embed pluginspage="http://www.apple.com/quicktime/download/"
							src="11.mp4" type="application/MPEG-4 Video File"
							wmode="transparent" autostart="True" loop="True"
							controller="True" style="height: 350px; width: 1000px;" />
					</div>
				</center>
			</div>
		</div>
	</div>
	<!--页面实现的下边区域  -->
	<div region="south" style="height: 20px; background: #D2E0F2;">
		<div style="text-align: center; font-weight: bold">Knight1.0版</div>
	</div>
</body>
</html>