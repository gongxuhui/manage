<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="echarts/js/jquery.js"></script>
<script type="text/javascript" src="echarts/js/esl/esl.js"></script>
<title>销售情况分布情况</title>
</head>
<body>
	<div id="map" style="width: 800px; height: 600px;"></div>
	<script type="text/javascript">
		var mapChart;
		var echart;
		/* 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径   */
		var fileLocation = 'echart/js/echarts-map';
		require.config({

			paths : {
				'echarts' : fileLocation,
				'echarts/chart/map' : fileLocation
			}
		});
		/* 作为入口 */
		require([ 'echarts', 'echarts/chart/map' ], displayChart);
		/* 生成pie饼状图的方法 */
		function displayChart(ec) {
			/* 初始化饼图 */
			echarts = ec;
			mapChart = ec.init(document.getElementById('map'));

			var options = {
				title : {
					text : '产品销售情况',
					subtext : '虚构数据',
					x : 'center'
				},
				tooltip : {
					trigger : 'item'
				},
				legend : {
					orient : 'vertical',
					x : 'left',
					data : [ 'iphone3', 'iphone4', 'iphone5' ]
				},
				dataRange : {
					min : 0,
					max : 2500,
					x : 'left',
					y : 'bottom',
					text : [ '高', '低' ], // 文本，默认为数值文本
					calculable : true
				},
				toolbox : {
					show : true,
					orient : 'vertical',
					x : 'right',
					y : 'center',
					feature : {
						mark : {
							show : true
						},
						dataView : {
							show : true,
							readOnly : false
						},
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
				series : [ {
					name : 'iphone3',
					type : 'map',
					mapType : 'china',
					roam : true,
					itemStyle : {
						normal : {
							label : {
								show : true
							}
						},
						emphasis : {
							label : {
								show : true
							}
						}
					},
					data : [ {
						name : '北京',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '天津',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '上海',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '重庆',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '河北',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '河南',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '云南',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '辽宁',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '黑龙江',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '湖南',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '安徽',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '山东',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '新疆',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '江苏',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '浙江',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '江西',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '湖北',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '广西',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '甘肃',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '山西',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '内蒙古',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '陕西',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '吉林',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '福建',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '贵州',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '广东',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '青海',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '西藏',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '四川',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '宁夏',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '海南',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '台湾',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '香港',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '澳门',
						value : Math.round(Math.random() * 1000)
					} ]
				}, {
					name : 'iphone4',
					type : 'map',
					mapType : 'china',
					itemStyle : {
						normal : {
							label : {
								show : true
							}
						},
						emphasis : {
							label : {
								show : true
							}
						}
					},
					data : [ {
						name : '北京',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '天津',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '上海',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '重庆',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '河北',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '安徽',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '新疆',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '浙江',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '江西',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '山西',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '内蒙古',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '吉林',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '福建',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '广东',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '西藏',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '四川',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '宁夏',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '香港',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '澳门',
						value : Math.round(Math.random() * 1000)
					} ]
				}, {
					name : 'iphone5',
					type : 'map',
					mapType : 'china',
					itemStyle : {
						normal : {
							label : {
								show : true
							}
						},
						emphasis : {
							label : {
								show : true
							}
						}
					},
					data : [ {
						name : '北京',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '天津',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '上海',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '广东',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '台湾',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '香港',
						value : Math.round(Math.random() * 1000)
					}, {
						name : '澳门',
						value : Math.round(Math.random() * 1000)
					} ]
				} ]
			};
			mapChart.setOption(options); //先把可选项注入myChart中  
			mapChart.hideLoading();

		}
	</script>
</body>
</html>