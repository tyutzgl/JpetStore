<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>

<html>
<head>
<title>JPetStore Demo</title>
<link rel="StyleSheet" href="<%=basePath%>/css/jpetstore.css" type="text/css"
	media="screen" />
</head>

<body>
	<div id="Content">
		<h2>Welcome to JPetStore 6</h2>

		<p>
			<a href="<%=basePath%>/catalog/Main.jsp">Enter the Store</a>
		</p>

		<p>
			<sub>Copyright www.mybatis.org </sub>
		</p>

	</div>
</body>
</html>
