/*url : 远程连接	animate : 动画效果	checkbox : 复选框		cascadeCheck : 是否关联
onlyLeafCheck :只有子节点有复选框	lines : 是不是有虚线	dnd : 是不是能拖拽		data :节点数据加载		
渲染节点文本内容
formatter : function (node) {
			return '[' + node.text + ']';
		}*/

$(function() {
	/* 编辑按钮 */
	$('#btn-save,#btn-cancel').linkbutton();
	win = $('#eidt-window').window({
		closed : true,
		modal : true,
		shadow : false
	});
	form = win.find('form');
	/* 查询按钮 */
	$('#btn-search,#btn-search-cancel').linkbutton();
	searchWin = $('#search-window').window({
		closed : true,
		modal : true
	});
	searchForm = searchWin.find('form');
	/* 加载生成左侧树 */
	tree = $('#tree').tree({
		url : 'treeAction!getTree',
		animate : true,
		checkbox : false,
		cascadeChek : false,
		onlyLeafCheck : true,
		lines : true,
		formatter : function(node) {
			return '[' + node.text + ']';
		},

		onClick : function(node) {
			clickTree(node.id);
			alert(node.id);
		}
	});
	/* ======数据网格的加载====== */
	grid = $('#grid').datagrid({
		title : '产品管理',
		iconCls : 'icon-save',
		url : 'Handler.ashx?action=list',
		sortName : 'ID',
		sortOrder : 'desc',
		idField : 'ID',
		pageSize : 30,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		columns : [ [ {
			field : 'title',
			title : '名称',
			width : 150
		}, {
			field : 'addTime',
			title : '添加日期',
			width : 150,
			sortable : true
		} ] ],
		pagination : true,
		rownumbers : true,
		singleSelect : false,
		/* 定义工具栏 */
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
			text : '所有',
			iconCls : 'icon-search',
			handler : showAll
		} ]
	});
	$('body').layout();
	$('body').layout();
});

var tree;
var grid;
var win;
var form;
var searchWin;
var searchForm;
/* 将节点nodeid传给grid */
function clickTree(nodeid) {
	grid.datagrid({
		url : 'Handler.ashx?action=list&PID=' + nodeid
	});
	grid.datagrid('clearSelections');
}
/*选中多行的函数*/
function getSelectedArr() {
	var ids = [];
	var rows = grid.datagrid('getSelections');
	for (var i = 0; i < rows.length; i++) {
		ids.push(rows[i].ID);
		alert(ids+"1111");
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

/* 自定义工具中的handler单击触发的事件 */
function add() {
	win.window('open');
	form.form('clear');
	form.url = 'Handler.ashx?action=save';
}

function edit() {
	var rows = grid.datagrid('getSelections');
	var num = rows.length;
	if (num == 0) {
		$.messager.alert('提示', '请选择一条记录进行操作!', 'info');
		return;
	} else if (num > 1) {
		$.messager.alert('提示', '您选择了多条记录,只能选择一条记录进行修改!', 'info');
		return;
	} else {
		win.window('open');
		form.form('load', 'Handler.ashx?action=get&id=' + rows[0].ID);
		form.url = 'Handler.ashx?action=save&id=' + rows[0].ID;
	}
}
function del() {
	var arr = getSelectedArr();
	if (arr.length > 0) {
		$.messager.confirm('提示信息', '您确认要删除吗?', function(data) {
			if (data) {
				$.ajax({
					url : 'Handler.ashx?action=del&id=' + arr2str(arr),
					type : 'GET',
					timeout : 1000,
					error : function() {
						$.messager.alert('错误', '删除失败!', 'error');
					},
					success : function(data) {
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

function showAll() {
	grid.datagrid({
		url : 'Handler.ashx?action=list'
	});
}

function closeWindow() {
	win.window('close');
}

function SearchOK() {
	var s_title = $("#s_title").val();
	searchWin.window('close');
	grid.datagrid({
		url : 'Handler.ashx?action=query',
		queryParams : {
			title : s_title
		}
	});
}
function closeSearchWindow() {
	searchWin.window('close');
}