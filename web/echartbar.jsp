<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="echarts/js/jquery.js"></script>
<script type="text/javascript" src="echarts/js/esl/esl.js"></script>
<title>销售量条形图</title>
</head>
<body>
	<div id="bar" style="width: 1100px; height: 500px;"></div>
	<script type="text/javascript">
		var barChart;
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
		require([ 'echarts', 'echarts/chart/bar' ], displayChart);
		/* 生成条形图的方法 */
		function displayChart(ec) {
			/* 初始化条形图 */
			echarts = ec;
			barChart = ec.init(document.getElementById('bar'));
			var options = {
				/* 标题头 */
				title : {
					text : '盈利情况',
					subtext : '虚构数据'
				},
				/* 提示功能 */
				tooltip : {
					trigger : 'axis'
				},
				/*图例   默认为横向显示*/
				legend : {
					data : []
				},
				/*工具栏  */
				toolbox : {
					show : false,
					/*功能  */
					feature : {
						/*数据展示  */
						dataView : {
							show : true,
							readOnly : false
						},

						/* 重置 */
						restore : {
							show : true
						},
						/*保存图片  */
						saveAsImage : {
							show : true
						}
					}
				},
				/*是不是可以拖拽  */
				calculable : false,
				xAxis : [ {
					type : 'category',
					data : []
				} ],
				yAxis : [ {
					type : 'value',
					axisLabel : {
						formatter : '{value} 元'
					}
				} ],
				series : [ {
					name : '2013',
					type : 'bar',
					data : [],
					markPoint : {
						data : [ {
							type : 'max',
							name : '最大值'
						}, {
							type : 'min',
							name : '最小值'
						} ]
					},
					markLine : {
						data : [ {
							type : 'average',
							name : '平均值'
						} ]
					}
				}, {
					name : '2014',
					type : 'bar',
					data : [],
					markPoint : {
						data : [ {
							type : 'max',
							name : '最大值'
						}, {
							type : 'min',
							name : '最小值'
						} ]
					},
					markLine : {
						data : [ {
							type : 'average',
							name : '平均值'
						} ]
					}
				}, {
					name : '2015',
					type : 'bar',
					data : [],
					markPoint : {
						data : [ {
							name : '年最高',
							value : 182.2,
							xAxis : 7,
							yAxis : 183,
							symbolSize : 18
						}, {
							name : '年最低',
							value : 2.3,
							xAxis : 11,
							yAxis : 3
						} ]
					},
					markLine : {
						data : [ {
							type : 'average',
							name : '平均值'
						} ]
					}
				} ]
			};
			barChart.setOption(options); //先把可选项注入myChart中  
			barChart.hideLoading();
			getChartData();
		}
	</script>
	<script type="text/javascript">
		function getChartData() {
			/* 获得图表的options对象   */
			var options = barChart.getOption();
			//通过Ajax获取数据  
			$.ajax({
				type : "post",
				async : false, //同步执行  
				url : 'eChartAction_bar!getBarData',
				data : {},
				dataType : "json", //返回数据形式为json  
				success : function(data) {
					if (data) {
						/*一定要注意数据传输的方式  */
						options.legend.data = data.legend;
						options.xAxis[0].data = data.xAxis;
						options.series[0].data = data.series13;
						options.series[1].data = data.series14;
						options.series[2].data = data.series15;
						barChart.hideLoading();
						barChart.setOption(options);
					}
				},
				error : function(errorMsg) {
					alert("不好意思，图表请求数据失败啦!");
					barChart.hideLoading();
				}
			});
		}
	</script>
</body>
</html>