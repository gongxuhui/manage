$(function() {
	/* 左侧树的实现 */
	tree = $('#trees').tree({
		checkbox : false,
		lines : true,
		url : 'treeActionp!getProductTree',
		onClick : function(node) {
			clickTree(node.id);
			alert(node.id);
		}
	});
});

/* 点击左侧树时触发的事件 */
function clickTree(nodeid) {
	grid.datagrid({
		url : 'employeeAction_searchAll!searchAll',
	});
	grid.datagrid('clearSelections');
}

function saveData(){
	alert("66666");
} 