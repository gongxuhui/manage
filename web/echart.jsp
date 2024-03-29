<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="echarts-2.0.1/doc/asset/js/esl/esl.js"></script>

<script type="text/javascript">
	// 路径配置  
	require.config({
		paths : {
			'echarts' : 'js/echarts',
			'echarts/chart/pie' : 'js/echarts'
		}
	});
	 require(  
	            [  
	                'echarts',  
	                'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载  
	            ],  
	            function (ec) {  
	                // 基于准备好的dom，初始化echarts图表  
	                var myChart = ec.init(document.getElementById('<span style="font-family:SimSun;">picturePlace</span><span style="font-family:FangSong_GB2312;">'</span>));   
	                  
	                option = {  
	                        title : {  
	                            text: '某站点用户访问来源',  
	                            subtext: '纯属虚构',  
	                            x:'center'  
	                        },  
	                        tooltip : {  
	                            trigger: 'item',  
	                            formatter: "{a} <br/>{b} : {c} ({d}%)"  
	                        },  
	                        legend: {  
	                            orient : 'vertical',  
	                            x : 'left',  
	                            data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']  
	                        },  
	                        toolbox: {  
	                            show : true,  
	                            feature : {  
	                                mark : {show: true},  
	                                dataView : {show: true, readOnly: false},  
	                                restore : {show: true},  
	                                saveAsImage : {show: true}  
	                            }  
	                        },  
	                        calculable : true,  
	                        series : [  
	                            {  
	                                name:'访问来源',  
	                                type:'pie',  
	                                radius : '55%',  
	                                center: ['50%', '60%'],  
	                                data:[  
	                                    {value:335, name:'直接访问'},  
	                                    {value:310, name:'邮件营销'},  
	                                    {value:234, name:'联盟广告'},  
	                                    {value:135, name:'视频广告'},  
	                                    {value:1548, name:'搜索引擎'}  
	                                ]  
	                            }  
	                        ]  
	                    };  
	          
	                // 为echarts对象加载数据   
	                myChart.setOption(option);   
	            }  
	        );  
</script>
<title>饼状图</title>
</head>
<body>
	<div id="pie"></div>
</body>
</html>