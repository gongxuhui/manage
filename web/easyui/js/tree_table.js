$(function() {
	/* 添加员工信息 */
	$('#btn-save,#btn-cancel').linkbutton();
	win = $('#eidt-window').window({
		closed : true,
		modal : true,
		shadow : false
	});

	form = win.find('form');
	/* 查询员工信息 */
	$('#btn-search,#btn-search-cancel').linkbutton();
	searchWin = $('#search-window').window({
		closed : true,
		modal : true
	});
	searchForm = searchWin.find('form');
	/* 左侧树的实现 */
	tree = $('#tree').tree({
		checkbox : false,// 定义是否显示checkbox在所有节点之前
		lines : true,// 定义是否显示树线
		url : 'treeAction!getTree',
		/* 左侧树中的点击事件可以获得节点id */
		onClick : function(node) {
			$('#grid').datagrid('load', {
				id : node.id
			});
			clickTree();
		}
	});
	/* 数据表格加载 */
	grid = $('#grid').datagrid({
		title : '员工信息',
		iconCls : 'icon-save',
		url : '',// url为空，所以第一次加载页面时，没有数据
		sortName : 'ID',// 排序名称
		sortOrder : 'desc',// 排序顺序
		idField : 'empId',// 列中的id
		pageSize : 15,// 默认选择的分页是每页10行数据
		pageList : [ 5, 10, 15, 20 ],// 可以选择的分页集合
		fit : true,
		striped : true,// 设置为true将交替显示行背景。
		collapsible : true,// 显示可折叠按钮
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		//表头
		columns : [ [ {
			field : 'empId',
			title : '员工编号',
			width : 100,
			sortable : true
		}, {
			field : 'empName',
			title : '名字',
			width : 100
		}, {
			field : 'empAge',
			title : '年龄',
			width : 50
		}, {
			field : 'empSex',
			title : '性别',
			width : 50
		}, {
			field : 'empHiredate',
			title : '入职时间',
			width : 100
		}, {
			field : 'empArea',
			title : '学历',
			width : 100
		}, {
			field : 'empLevel',
			title : '等级',
			width : 100
		}, {
			field : 'empSalary',
			title : '薪水',
			width : 100
		}, {
			field : 'empGroup',
			title : '部门',
			width : 100
		} ] ],
		pagination : true,
		rownumbers : true,
		singleSelect : false,
		//工具按钮
		toolbar : [ {
			text : '新增',
			iconCls : 'icon-add',
			handler : add
		}, '-', {
			text : '修改',
			iconCls : 'icon-edit',
			handler : edit
		}, '-', {
			text : '删除',
			iconCls : 'icon-remove',
			handler : del
		}, '-', {
			text : '查找',
			iconCls : 'icon-search',
			handler : OpensearchWin
		}, '-', {
			text : 'excle导出',
			iconCls : 'icon-save',
			handler : getExcle
		} ]
	});
	$('body').layout();

	/*
	 * $('#emplname').blur(function() { var name = $('#emplname').val();
	 * alert(name); // 回显用户 getEmplId(name); })
	 */

});

var tree;
var grid;
var win;
var form;
var searchWin;
var searchForm;
/* 点击左侧树时触发的事件 会根据节点把不同部门的员工查询出来 */
function clickTree() {
	grid.datagrid({
		url : 'employeeAction_searchAll!searchAll',
	});
	grid.datagrid('clearSelections');
}
/* 添加用户信息的函数 */
function add() {
	win.window('open');
	form.form('clear');
	form.url = 'employeeAction_add!add';
}
/* 判断员工信息是否添加的函数 */
function saveData() {
	form.form('submit', {
		url : form.url,
		success : function(data) {
			eval('data=' + data);
			if (data.success) {
				grid.datagrid('reload');
				win.window('close');
			} else {
				alert(data.msg);
			}
		}
	});
}
/* 修改用户信息的函数 */
function edit() {
	var rows = grid.datagrid('getChecked');
	var num = rows.length;
	if (num == 0) {
		$.messager.alert('提示', '请选择一条记录进行操作!', 'info');
		return;
	} else if (num > 1) {
		$.messager.alert('提示', '您选择了多条记录,只能选择一条记录进行修改!', 'info');
		return;
	} else {
		win.window('open');
		form.form('clear');
		form.form('load', rows[0]);
		form.url = 'employeeAction_edit!edit';
	}
}
/* 删除员工信息的函数 */
function del() {
	var arr = getSelectedArr();
	if (arr.length > 0) {
		$.messager.confirm('提示信息', '您确认要删除吗?', function(data) {
			// alert("aaa" + data);
			if (data) {
				$.ajax({
					url : 'employeeAction_del!del?did=' + arr2str(arr),
					type : 'GET',
					timeout : 1000,
					error : function() {
						$.messager.alert('错误', '删除失败!', 'error');
					},
					success : function(data) {
						alert('data=' + data);
						eval('data=' + data);
						if (data.success) {
							grid.datagrid('reload');
							grid.datagrid('clearSelections');
						} else {
							$.messager.alert('错误', data.msg, 'error');
						}
					}
				});
			}
		});
	} else {
		$.messager.show({
			title : '警告',
			msg : '请先选择要删除的记录。'
		});
	}
}
/* 获得选中项的ids数组 */
function getSelectedArr() {
	var ids = [];
	var rows = grid.datagrid('getSelections');
	for (var i = 0; i < rows.length; i++) {
		ids.push(rows[i].empId);
	}
	return ids;
}

function getSelectedID() {
	var ids = getSelectedArr();
	return ids.join(',');
}
function arr2str(arr) {
	return arr.join(',');
}
/* 获得excle */
function getExcle() {
	$.ajax({
		url : 'downLoadAction!getExcle.action',
	});
}
/* 查询员工消息 */
function OpensearchWin() {
	searchWin.window('open');
	searchForm.form('clear');
}
function closeWindow() {
	win.window('close');
}

function SearchOK() {
	var id = $("#emp_id").val();
	var date = $("#emp_hiredate").datebox("getValue");
	var date1 = $("#emp_hiredate1").datebox("getValue");
	// alert(date);
	grid.datagrid({
		url : 'employeeAction_search!search?sid=' + id + '&shiredate=' + date
				+ '&shiredate1=' + date1,
	});
	searchWin.window('close');
}
function closeSearchWindow() {
	searchWin.window('close');
}

function getGroupBox() {
	/* 下拉框 */
	$('#group').combobox({
		url : 'boxAction!getGroupBox',
		valueField : 'valueField',
		textField : 'textField'
	});
}
function getAreaBox() {
	/* 下拉框 */
	$('#area').combobox({
		url : 'boxAction!getAreaBox',
		valueField : 'valueField',
		textField : 'textField'
	});
}
function getLevelBox() {
	/* 下拉框 */
	$('#level').combobox({
		url : 'boxAction!getLevelBox',
		valueField : 'valueField',
		textField : 'textField'
	});
}
/*
 * 在失去光标时，回显用户id function getEmplId(name) { $.ajax({ url :
 * 'employeeAction_getEmplId!getEmplId?emp_name=' + name,
 * 
 * }); }
 */