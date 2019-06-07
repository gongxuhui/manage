$(function() {
	var pieChart;
	var echart;
	/* 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径   */
	var fileLocation = 'echarts/js/echarts';
	require.config({
		paths : {
			'echarts' : fileLocation,
			'echarts/chart/line' : fileLocation,
			'echarts/chart/bar' : fileLocation,
			'echarts/chart/pie' : fileLocation,
			'echarts/config' : fileLocation
		}
	});
	/* 作为入口 */
	require([ 'echarts', 'echarts/chart/pie', 'echarts/config', ], displayChart);
	/* 生成pie饼状图的方法 */
	function displayChart(ec) {
		/* 初始化饼图 */
		echarts = ec;
		pieChart = ec.init(document.getElementById('pie'));
		var ecConfig = require('echarts/config');
		/* 点击事件 */
		pieChart.on(ecConfig.EVENT.CLICK, function(param) {
			var dataIndex = param.dataIndex;
			getChartData1(dataIndex);
		});
		var options = {
			// 图表头信息
			title : {
				text : '产品库存量',
				subtext : '虚构信息',
				x : 'center'
			},
			// 提示信息
			tooltip : {
				show : true,
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			// 图表图例
			legend : {
				orient : 'vertical',
				x : 'left',
				data : []
			},
			// 是否允许拖拽
			calculable : false,
			series : [ {
				name : '总销售情况',
				type : 'pie',
				// 给图表添加自定义事件
				selectedMode : 'single',
				// 半径
				radius : [ '50%', '70%' ],
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
				/* 数据 */
				data : []
			} ]
		};
		/* 先把可选项注入myChart中 */
		pieChart.setOption(options);
		pieChart.hideLoading();
		getChartData();
	}
});