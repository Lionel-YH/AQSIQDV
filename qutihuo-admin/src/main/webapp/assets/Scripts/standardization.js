﻿var dataAll = [253,220,215,211,208,205,203,199,185,179,169,140,139,137,131,124,122,121,118,94,94,93,90,90,78,71,67,63,52,50,10];
var yAxisData = ['安徽省','四川省','江苏省','山西省','广西壮族自治区','山东省','辽宁省','黑龙江省','吉林省','河南省','广东省','新疆维吾尔自治区','甘肃省','宁夏回族自治区','内蒙古自治区','河北省','天津市','北京市','湖南省','湖北省','贵州省','云南省','福建省','重庆市','海南省','上海市','陕西省','青海省','江西省','浙江省','西藏自治区'];
var std_zxd_option = {

	title:[
		{text:"按制、修订分",x: '2%', y: '1%',textStyle:{color:"#000",fontSize:"14"}},
		{text:"各省标准制修订数（单位：个）",x: '40%', y: '1%',textStyle:{color:"#000",fontSize:"14"}},
		{text:"按性质分",x: '2%', y: '50%',textStyle:{color:"#000",fontSize:"14"}},
	],
	grid: [
		{x: '50%', y: '7%', width: '45%', height: '90%'},
	],
	tooltip: {
		formatter: '{b} ({c})'
	},
	xAxis: [
		{gridIndex: 0, axisTick: {show:false},axisLabel: {show:false},splitLine: {show:false},axisLine: {show:false }},
	],
	yAxis: [
		 {  gridIndex: 0, interval:0,data:yAxisData.reverse(),
			axisTick: {show:false}, axisLabel: {show:true},splitLine: {show:false},
			axisLine: {show:true,lineStyle:{color:"#6173a3"}},
		}
	],
	series: [
		{
			name: '按制、修订分',
			type: 'pie',
			radius : '30%',
			center: ['22%', '25%'],
			color:['#86c9f4','#4da8ec','#3a91d2','#005fa6','#315f97'],
			data:[
				{value:3848, name:'制订'},

				{value:283, name:'修订'}
			],
			labelLine:{normal:{show:true}},
			itemStyle: {normal: {label:{ show: true,  formatter: '{b} {c}个 \n ({d}%)', textStyle:{color:'#000'}} },},
		},
		{
			name: '按性质分',
			type: 'pie',
			radius : '30%',
			center: ['22%', '75%'],
			color:['#86c9f4','#4da8ec','#3a91d2','#005fa6','#315f97'],
			labelLine:{normal:{show:true}},
			data:[
				 {value:3868, name:'推荐'},
				{value:263, name:'强制'},


			],
			itemStyle: {normal: {label:{ show: true,  formatter: '{b}  {c}个\n({d}%)', textStyle:{color:'#000'}} },},
		},
		{
			name: '各省标准制修订数（单位：个）',
			type: 'bar',xAxisIndex: 0,yAxisIndex: 0,barWidth:'45%',
			itemStyle:{normal:{color:'#86c9f4'}},
			label:{normal:{show:true, position:"right",textStyle:{color:"#9EA7C4"}}},
			data: dataAll.reverse()
		},

	]
};