<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>库存量饼状图</title>
<script type="text/javascript" src="echarts/js/jquery.js"></script>
<script type="text/javascript" src="echarts/js/esl/esl.js"></script>
</head>
<body>
	<div id="pie" style="width: 800px; height: 500px;"></div>
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
				'echarts/chart/pie' : fileLocation
			}
		});
		/* 作为入口 */
		require([ 'echarts', 'echarts/chart/pie' ], displayChart);
		/* 生成pie饼状图的方法 */
		function displayChart(ec) {
			/* 初始化饼图 */
			echarts = ec;
			pieChart = ec.init(document.getElementById('pie'));
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
					name : '库存量',
					type : 'pie',
					// 给图表添加自定义事件
					selectedMode : 'single',
					// 半径
					radius : [ 0, '30%' ],
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
				}, {
					name : '生产总数',
					type : 'pie',
					radius : [ '50%', '70%' ],
					data : []
				} ]
			};
			/* 先把可选项注入myChart中   */
			pieChart.setOption(options);
			pieChart.hideLoading();
			getChartData();
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
				url : 'eChartAction_pie!getPieData',
				data : {},
				dataType : "json", //返回数据形式为json  
				success : function(data) {
					if (data) {
						/*一定要注意数据传输的方式  */
						options.legend.data = data.legend;
						options.series[0].data = data.series;
						options.series[1].data = data.series1;
						console.log(data.series1);
						console.log(data.series);
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
	</script>
</body>
</html>