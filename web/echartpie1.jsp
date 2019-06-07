<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>销售信息饼状图</title>
<script type="text/javascript" src="echarts/js/jquery.js"></script>
<script type="text/javascript" src="echarts/js/esl/esl.js"></script>
</head>
<body>

	<div id="pie" style="width: 600px; height: 500px; float: left;"></div>
	<div id="pie1" style="width: 300px; height: 500px; float: left";></div>
	<!--地区销售情况  -->
	<script type="text/javascript">
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
		require([ 'echarts', 'echarts/chart/pie', 'echarts/config', ],
				displayChart);
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
				//图表头信息
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
			/* 先把可选项注入myChart中   */
			pieChart.setOption(options);
			pieChart.hideLoading();
			getChartData();
		}
	</script>
	<!--地区中产品详细销售情况  -->
	<script type="text/javascript">
		var pieChart1;
		var echart1;
		/* 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径   */
		var fileLocation = 'echarts/js/echarts';
		require.config({
			paths : {
				'echarts' : fileLocation,
				'echarts/chart/line' : fileLocation,
				'echarts/chart/bar' : fileLocation,
				'echarts/chart/pie' : fileLocation,
			}
		});
		/* 作为入口 */
		require([ 'echarts', 'echarts/chart/pie', ], displayChart);
		/* 生成pie饼状图的方法 */
		function displayChart(ec) {
			/* 初始化饼图 */
			echarts1 = ec;
			pieChart1 = ec.init(document.getElementById('pie1'));

			var options = {
				//图表头信息
				/* title : {
					text : '产品',
					subtext : '虚构信息',
					x : 'center'
				}, */
				// 提示信息
				tooltip : {
					show : true,
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				// 图表图例
				legend : {
					//orient : 'vertical',
					//x : 'left',
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
					radius : [ '30%', '50%' ],
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
			/* 先把可选项注入myChart中   */
			pieChart1.setOption(options);
			pieChart1.hideLoading();
		}
	</script>
	<script type="text/javascript">
		function getChartData() {
			/* 获得图表的options对象   */
			var options = pieChart.getOption();
			//通过Ajax获取数据  
			$.ajax({
				type : "post",
				async : false, //同步执行  
				url : 'eChartAction_indentPie!getIndentPieData',
				data : {},
				dataType : "json", //返回数据形式为json  
				success : function(data) {
					if (data) {
						/*一定要注意数据传输的方式  */
						options.legend.data = data.legend;
						options.series[0].data = data.series;
						pieChart.hideLoading();
						pieChart.setOption(options);
					}
				},
				error : function(errorMsg) {
					alert("不好意思，图表请求数据失败啦!");
					myChart.hideLoading();
				}
			});
		}

		function getChartData1(dataIndex) {
			/* 获得图表的options对象   */
			var options = pieChart1.getOption();
			for (i = 0; i <= options.legend.length - 1; i++) {
				options.legend = null;
			}
			alert(dataIndex);
			//通过Ajax获取数据  
			$.ajax({
				type : "post",
				async : false, //同步执行  
				url : 'eChartAction_areaPie!getAreaPieData?dataIndex='
						+ dataIndex,
				data : {},
				dataType : "json", //返回数据形式为json  
				success : function(data) {
					if (data) {
						/*一定要注意数据传输的方式  */
						legend = data.legend;
						options.legend.data = data.legend;
						options.series[0].data = data.series;
						pieChart1.hideLoading();
						/* 高大上属性 */
						pieChart1.setOption(options, true);
					}
				},
				error : function(errorMsg) {
					alert("不好意思，图表请求数据失败啦!");
					myChart1.hideLoading();
				}
			});
		}
	</script>
</body>
</html>