<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%@ include file="../common/IncludeTop.jsp"%>


<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {

		$("#SidebarContent img").first().attr("title", "FISH");
		$("#SidebarContent img").eq(1).attr("title", "DOGS");
		$("#SidebarContent img").eq(2).attr("title", "CATS");
		$("#SidebarContent img").eq(3).attr("title", "REPTILES");
		$("#SidebarContent img").eq(4).attr("title", "BIRDS");
		$("#SidebarContent img").click(function() {

			location.href = "categoryAction?category.catid=" + $(this).attr("title");

		});

		$("#MainImageContent area").click(function() {

			location.href = "categoryAction?category.catid=" + $(this).attr("alt");

		});

	});
</script>

<div id="Welcome" style="background:white">
	<div id="WelcomeContent">欢迎 !"<%=session.getAttribute("userid")%>"</div>
</div>
<div id="Main">

	<div id="Sidebar">
		<div id="SidebarContent">

			<img src="<%=basePath%>/images/fish_icon.gif" /> <br /> 海水，淡水 <br />

			<img src="<%=basePath%>/images/dogs_icon.gif" /> <br /> 不同品种 <br />
			<img src="<%=basePath%>/images/cats_icon.gif" /> <br /> 不同品种，外来品种 <br />

			<img src="<%=basePath%>/images/reptiles_icon.gif" /> <br /> 蜥蜴，龟，蛇
			<br /> <img src="<%=basePath%>/images/birds_icon.gif" /> <br />外来品种
		</div>
	</div>

	<div id="MainImage">
		<div id="MainImageContent">
			<map name="estoremap">
				<area alt="BIRDS" coords="72,2,280,250" href="javascript:void(0)" shape="RECT" />
				<area alt="FISH" coords="2,180,72,250" />
				<area alt="DOGS" coords="60,250,130,320" shape="RECT" />
				<area alt="REPTILES" coords="140,270,210,340" shape="RECT" />
				<area alt="CATS" coords="225,240,295,310" shape="RECT" />
				<area alt="BIRDS" coords="280,180,350,250" shape="RECT" />
			</map>
			<img height="355" src="<%=basePath%>/images/splash.gif" align="center" usemap="#estoremap" width="350" />
		</div>
	</div>
	<div id="Separator">&nbsp;</div>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>

