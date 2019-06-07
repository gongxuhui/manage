<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<!-- <script type="text/javascript" src="easyui/js/home.js"></script> -->
<script type="text/javascript" src="echarts/js/esl/esl.js"></script>
<script type="text/javascript" src="echarts/js/esl/echart-pie.js"></script>
<script type="text/javascript" src="echarts/js/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<title>产品信息</title>
<style>
.textbox {
	height: 20px;
	margin: 0;
	padding: 0 2px;
	box-sizing: content-box;
}
</style>
</head>
<body>
	<!--chart的显示位置  -->
	<div region="west" split="true" title="产品信息树" style="width: 800px;"
		id="west">
		<div id="pie" style="width: 800px; height: 600px;"></div>
	</div>
	<!--产品信息的显示位置  -->
	<div region="center"
		style="width: 500px; height: 300px; padding: 1px; background: #eee; overflow-y: hidden">
		<div id="grid1" fit="true">欢迎来到这里的世界</div>
		<img alt="freeAction" src="freeChartAction!getProductCahrt.action" />
	</div>
</body>
</html>