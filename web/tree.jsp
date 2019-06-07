<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--引入js和css样式  -->
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="easyui/js/home.js"></script>
<script type="text/javascript" src="easyui/js/tree_table.js"></script>
<script type="text/javascript" src="easyui/js/validatebox.js"></script>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<title>左侧树</title>
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
	<!--左侧树的显示位置  -->
	<div region="west" split="true" style="width: 180px;" id="west">
		<ul id="tree">
		</ul>
	</div>
	<!--员工信息的显示位置  -->
	<div region="center"
		style="width: 500px; height: 300px; padding: 1px; background: #eee; overflow-y: hidden">
		<div id="grid" fit="true"></div>
	</div>
	<!--添加修改用户信息的显示位置  -->
	<div id="eidt-window" title="员工信息" style="width: 650px; height: 250px;">
		<div style="">
			<form class="easyui-form" method="post" validate:true>
				<table b width="600px" border="0" cellpadding="0" cellspacing="0"
					bgcolor="#FFFFFF" align="center" style="margin-top: 8px">
					<tr>
						<td align="center" bgcolor="#FAFAF1" height="30px" width="80px">员工编号:</td>
						<td align='left' bgcolor="#FFFFFF" height="22px" width="80px"><input
							name="empId" onfocus="this.blur();" class="easyui-validatebox" /></td>
						<td align="center" bgcolor="#FAFAF1" height="30px" width="80px">名字:</td>
						<td align='left' bgcolor="#FFFFFF" height="22px" width="80px"><input
							id="emplname" name="empName" class="easyui-validatebox"
							validType="emp_name" /></td>
					</tr>
					<tr>
						<td align="center" bgcolor="#FAFAF1" height="30px" width="80px">年龄:</td>
						<td align='left' bgcolor="#FFFFFF" height="22px" width="80px">
							<input name="empAge" class="easyui-validatebox"
							validType="numberCheckSub" />
						</td>
						<td align="center" bgcolor="#FAFAF1" height="30px" width="80px">性别:</td>
						<td align='left' bgcolor="#FFFFFF" height="22px" width="80px">男<input
							type="radio" name="empSex" value="男" /> 女<input type="radio"
							name="empSex" value="女" /></td>
					</tr>
					<tr>
						<td align="center" bgcolor="#FAFAF1" height="30px" width="80px">入职时间:</td>
						<td align='left' bgcolor="#FFFFFF" height="22px" width="80px"><input
							name="empHiredate" class="easyui-datebox" /></td>
						<td align="center" bgcolor="#FAFAF1" height="30px" width="80px">学历:</td>
						<td onclick="getAreaBox()" align='left' bgcolor="#FFFFFF"
							height="22px" width="80px"><input id="area" name="empArea"
							class="easyui-combobox" /></td>
					</tr>
					<tr>
						<td align="center" bgcolor="#FAFAF1" height="30px" width="80px">等级:</td>
						<td onclick="getLevelBox()" align='left' bgcolor="#FFFFFF"
							height="22px" width="80px"><input id="level" name="empLevel"
							class="easyui-combobox" /></td>
						<td align="center" bgcolor="#FAFAF1" height="30px" width="80px"">薪水:</td>
						<td align='left' bgcolor="#FFFFFF" height="22px" width="80px"><input
							name="empSalary" class="easyui-validatebox"
							validType="numberCheckSub" /></td>
					</tr>
					<tr>
						<td align="center" bgcolor="#FAFAF1" height="30px" width="80px">部门:</td>
						<td onclick="getGroupBox()" align='left' bgcolor="#FFFFFF"
							height="22px" width="80px"><input id="group" name="empGroup"
							class="easyui-combobox" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="text-align: center; padding: 30px;">
			<a href="javascript:void(0)" onclick="saveData()" id="btn-save"
				icon="icon-save">保存</a> <a href="javascript:void(0)"
				onclick="closeWindow()" id="btn-cancel" icon="icon-cancel"> 取消</a>
		</div>
	</div>
	<!--查询员工信息的显示位置  -->
	<div id="search-window" title="高級查询"
		style="width: 390px; height: 200px;">
		<div style="">
			<!-- <form method="post">
				<table align="center" border="1" bordercolor="#E0ECFF"
					style="padding: 10px;" bgcolor="#E0ECFF">
					<tr>
						<td width="100" height="30" bgcolor="#E0ECFF">员工编号：</td>
						<td width="100"><input name="emp_id" id="emp_id"
							style="width: 100px; height: 30px;" /></td>
					</tr>
					<tr>
						<td bgcolor="#E0ECFF">入职时间：</td>
						<td><input name="emp_hiredate" id="emp_hiredate"
							class="easyui-datebox" style="width: 100px; height: 30px;" /></td>
						<td bgcolor="#E0ECFF">到：</td>
						<td><input name="emp_hiredate1" id="emp_hiredate1"
							class="easyui-datebox" style="width: 100px; height: 30px;" /></td>
					</tr>
				</table>
			</form> -->
			<form class="easyui-form" method="post" validate:true>
				<table  border="0" cellpadding="0" cellspacing="0"
					bgcolor="#FFFFFF" align="center" style="margin-top: 8px">
					<tr>
						<td bgcolor="#FAFAF1" height="30px" width="100px">员工编号：</td>
						<td bgcolor="#FFFFFF" height="22px" width="40px"><input
						 id="emp_id" name="emp_id"  width="40px" /></td>
					</tr>
					<tr>
						<td bgcolor="#FAFAF1" height="30px" width="100px">入职时间：</td>
						<td bgcolor="#FFFFFF" height="22px" width="40px"><input
							id="emp_hiredate" name="emp_hiredate" class="easyui-datebox"
							width="40px" /></td>
						<td bgcolor="#FAFAF1" height="30px" width="50px">到：</td>
						<td bgcolor="#FFFFFF" height="22px" width="40px"><input
							id="emp_hiredate1" name="emp_hiredate1" class="easyui-datebox"
							width="40px" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="text-align: center; padding: 10px;"">
			<a href="javascript:void(0)" onclick="SearchOK()" id="btn-search"
				icon="icon-ok">搜索</a><a href="javascript:void(0)"
				onclick="closeSearchWindow()" id="btn-search-cancel"
				icon="icon-cancel"> 取消</a>
		</div>
	</div>
</body>
</html>