<%@ page language="java" import="java.util.*,com.clps.jPet.pojo.*"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<base href="<%=basePath%>">

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>


<head>
    <meta name="generator"
          content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org"/>
    <title>JPetStore 案例</title>
    <meta content="text/html; charset=windows-1252"
          http-equiv="Content-Type"/>
    <meta http-equiv="Cache-Control" content="max-age=0"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT"/>
    <meta http-equiv="Pragma" content="no-cache"/>

    <link rel="StyleSheet" href="<%=basePath%>/css/jpetstore.css" type="text/css" media="screen"/>
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        $(function () {

            $("#SearchContent form input:last").click(function () {
                location.href = "queryLikeAction?value=" + $("#SearchContent form input:first").val();
            });

            $("#QuickLinks a img").first().attr("title", "FISH");
            $("#QuickLinks a img").eq(1).attr("title", "DOGS");
            $("#QuickLinks a img").eq(3).attr("title", "CATS");
            $("#QuickLinks a img").eq(2).attr("title", "REPTILES");
            $("#QuickLinks a img").eq(4).attr("title", "BIRDS");
            $("#QuickLinks a img").click(function () {

                location.href = "categoryAction?category.catid=" + $(this).attr("title");

            });


            $("#login").click(function () {

                if ($("#login").html() == "登录") {
                    location.href = "account/SignonForm.jsp";

                } else {

                    $("#login").html("登录");
                    location.href = "dropUserAction";

                }


            });

            if ("${userid}" == "" || "${userid}" == null) {
                $("#account").css("display", "none");

            } else {

                $("#account").css("display", "inline");
                $("#login").html("登出");
            }


            $("#account").click(function () {


                location.href = "queryInfoByUserAction?signon.username=<%=session.getAttribute("userid")%>";

            });


            $("#MenuContent a:first").click(function () {
                <%-- alert("<%=session.getAttribute("userid")%>"); --%>
                if ("<%=session.getAttribute("userid")%>" === "null") {
                    location.href = "cart/Cart.jsp";
                } else {
                    location.href = "queryShoppingAction?signon.username=<%=session.getAttribute("userid")%>";
                }
            })
        });
    </script>
</head>

<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="<%=basePath%>catalog/Main.jsp">
                <img width="227" src="<%=basePath%>/images/logo-topbar.gif"/>
            </a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <a href="javascript:void(0)">
                <img align="middle" name="img_cart" src="<%=basePath%>/images/cart.gif"/>
            </a>
            <img align="middle" src="<%=basePath%>/images/separator.gif"/>
            <a href="javascript:void(0)" id="login">登录</a>
            <img align="middle" src="<%=basePath%>/images/separator.gif"/>
            <a href="javascript:void(0)" id="account" style="display:none">我的账户</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form method="post" action="">
                <input name="keyword" size="14"/>&nbsp;
                <input type="button" name="SearchButton" value="搜索"/>
            </form>
        </div>
    </div>

    <div id="QuickLinks">
        <a> <img src="<%=basePath%>images/sm_fish.gif"/></a> <img
            src="<%=basePath%>images/separator.gif"/> <a> <img
            src="<%=basePath%>images/sm_dogs.gif"/></a> <img
            src="<%=basePath%>images/separator.gif"/> <a> <img
            src="<%=basePath%>images/sm_reptiles.gif"/></a> <img
            src="<%=basePath%>images/separator.gif"/> <a> <img
            src="<%=basePath%>images/sm_cats.gif"/></a> <img
            src="<%=basePath%>images/separator.gif"/> <a> <img
            src="<%=basePath%>images/sm_birds.gif"/></a>
    </div>

</div>

<div id="Content"></div>
</body>
</html>