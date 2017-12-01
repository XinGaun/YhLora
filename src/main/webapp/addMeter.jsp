<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'addMeter.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>

<body>
	<button id="show">add</button>
	<dir id="dd"></dir>
	<script type="text/javascript">
		
	</script>
	<script type="text/javascript">
		$(function() {
			var param = {
			/* page : 2,
			nums : 0 */
			/* hub_id : 4,//所属集中器ID
			sn : 002, //表具型号
			addr : 1001,//表具地址
			ch_sprf : 1234,//扩频因子,信道编号
			repeat_addr : 25//中继配置 *///中继配置
			sort:1
			};
			$("#show")
					.click(
							function() {
								$
										.ajax({
											url : '/YhLora/Hub/selectHub',
											type : 'post',
											contentType : "application/json;charset=utf-8",
											data : JSON.stringify(param),
											dataType : 'json',
											success : function(data) {
												if ($("#dd").text() != "") {
												} else {
													for ( var i = 0; i < data.data.length; i++) {
														$("#dd")
																.append(
																		"<p>"
																				+ JSON
																						.stringify(data.data[i])
																				+ "</p>");
													}
												}
												//var data = JSON.parse(data);
												console.log(data);
												/* 						data.length = data.length - 1;
												 console.log(data); */

											},
											error : function(data) {
												console.log('err');
											}
										});
							});

		});
	</script>
</body>
</html>
