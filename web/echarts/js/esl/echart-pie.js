/* ajax请求后台action */
var pieChart;
var fileLocation = 'echarts/js/echarts';
require.config({
	paths : {
		'echarts' : fileLocation,
		'echarts/chart/line' : fileLocation,
		'echarts/chart/bar' : fileLocation,
		'echarts/chart/pie' : fileLocation
	}
});

/* 作为入口 */
require([ 'echarts', 'echarts/chart/pie' ],

displayChart

);
var obj = [];
function getChartData() {
	$.ajax({
		url : 'eChartAction_pie!getPieData',
		type : 'GET',
		async : false,
		dataType : "json",
		success : function(data) {
			obj = data.sss;
		}
	});
}
alert(obj);
/* console.log(this.object); */
/* 生成pie饼状图的方法 */
function displayChart(ec) {
	/* 初始化饼图 */
	pieChart = ec.init(document.getElementById('pie'));
	getChartData();
	pieChart.setOption(pieChartOption);
}

/* 获得Pie图的选项和数据 */
var pieChartOption = {
	// 图表头信息
	title : {
		text : '产品库存量',
		subtext : '纯属虚构',
		x : 'center'
	},
	// 提示信息
	tooltip : {
		show : true,
		formatter : "{a} <br/>{b} : {c} ({d}%)"
	},
	// 图表图例
	legend : {
		// 保证图例上下排列
		orient : 'vertical',
		x : 'left',
		data : obj
	},
	// 是否允许拖拽
	calculable : false,
	series : [ {
		name : '访问来源',
		type : 'pie',
		// 给图表添加自定义事件
		selectedMode : 'single',
		// 半径
		radius : [ 0, '50%' ],
		label : {
			normal : {
				position : 'inner'
			}
		},
		labelLine : {
			normal : {
				show : false
			}
		},
		// data : sdate
		data : [ {
			value : 335,
			name : '手机'
		}, {
			value : 310,
			name : '电脑'
		}, {
			value : 234,
			name : '联盟广告'
		}, {
			value : 135,
			name : '视频广告'
		}, {
			value : 1548,
			name : '搜索引擎'
		} ]
	} ]
}
