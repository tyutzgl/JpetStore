<%@ page language="java"
         import="java.util.*,com.clps.jPet.pojo.*,java.lang.Integer"
         pageEncoding="UTF-8" %>


<%@ include file="../common/IncludeTop.jsp" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">

    $(function () {

        $(".textview").bind({
            focus: function () {
                console.log($(this).parent().parent().children().children().first().html());
                console.log($(this).val());
            },
            blur: function () {

                var param = "item.itemid=" + $(this).parent().parent().children().children().first().html() + "&item.count=" + $(this).val() + "&signon.userid=0";
                console.log(param);
                $.ajax({
                    url: "saveCountAction",
                    data: param,
                    type: "GET",
                    dataType: "json"
                })
            }
        });

        $(".textviewtwo").bind({
            focus: function () {
                console.log($(this).parent().parent().children().children().first().html());
                console.log($(this).val());
            },
            blur: function () {
                var param = "item.itemid=" + $(this).parent().parent().children().children().first().html() + "&item.count=" + $(this).val() + "&signon.userid=" + "${userid }" +
                    "&item.listprice=" + $(this).parent().parent().children().eq(5).html();
                console.log(param);
                $.ajax({
                    url: "saveCountAction.action",
                    data: param,
                    type: "GET",
                    dataType: "json",
                    success: function (data) {
                        console.log(data.sumPrice);
                        //$(this).parent().parent().children().eq(6).html(data.sumPrice);
                    },
                    error: function () {
                    }
                })

                var price = $(this).parent().parent().children().eq(5).html();
                var sumprice = $(this).parent().parent().children().eq(6).html();
                var count = $(this).val();
                $(this).parent().parent().children().eq(6).html(price * count);

            }
        });


        $(".btnTwo").click(function () {
            alert($(this).parent().parent().children().children().first().html());
            location.href = "deleteShoppingAction?signon.username=" + "${userid }" + "&item.itemid=" + $(this).parent().parent().children().children().first().html();
        });

        $(".btnOne").click(function () {

            location.href = "deleteShoppingAction?item.itemid=" + $(this).parent().parent().children().children().first().html() + "&signon.username=0";


        });

        var sum = 0;
        $(".sumprice").each(function () {
            var price = $(this).parent().parent().children().eq(5).html();
            var sumprice = $(this).parent().parent().children().eq(6).html();
            var count = $(this).parent().parent().children().eq(4).children().val();
            $(this).html(price * count);
            var countPirce = parseInt($(this).html());

            sum = sum + countPirce;
        })


        $(".sumpriceTwo").each(function () {
            var price = $(this).parent().parent().children().eq(5).html();
            var sumprice = $(this).parent().parent().children().eq(6).html();
            var count = $(this).parent().parent().children().eq(4).children().val();
            $(this).html(price * count);
            var countPirce = parseInt($(this).html());

            sum = sum + countPirce;

        })
        $("#maxprice").html(sum);

        $(".textviewtwo").parent().parent().children().find("a").click(function () {
            if ($(this).html() != "取消") {
                location.href = "queryQtyAction?item.itemid=" + $(this).html();
            }
        });


        $("#buy").click(function () {
            if ("${userid }" == "") {
                location.href = "account/SignonForm.jsp";
            } else {
                location.href = "queryShoppingTwoAction?signon.username=" + "${userid }";
            }
        })

        if ("${profile.mylistopt}" == 0) {
            $("#MyList").css("display", "none");

        }

    });
</script>


<div id="Catalog">

    <div id="BackLink">
        <a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>
    </div>
    <div id="Cart">

        <h2>购物车</h2>
        <form method="post">
            <table id="shopping">
                <tr>
                    <th><b>商品编号</b></th>
                    <th><b>产品编号</b></th>
                    <th><b>产品描述</b></th>
                    <th><b>有库存?</b></th>
                    <th><b>产品数量</b></th>
                    <th><b>定价</b></th>
                    <th><b>总成本</b></th>
                    <th>&nbsp;</th>
                </tr>

                <%
                    if (session.getAttribute("userid") == null) {
                %>
                <%
                    List<Item> itemlist = (List<Item>) session.getAttribute("itemlist");
                    if (itemlist == null) {
                %>
                <tr>
                    <td colspan="8"><b>你的购物车是空的.</b></td>
                </tr>
                <%
                } else {
                %>
                <s:iterator value="itemMap" var="column">
                    <tr>
                        <td><a href="javascript:void(0)"><s:property
                                value="#column.itemid"/></a></td>
                        <td><s:property value="#column.product.productid"/></td>
                        <td><s:property value="#column.attr1"/></td>
                        <td>有</td>
                        <td><input type="text" class="textview" name="inStock"
                                   size="5" value="<s:property value="#column"/>"/></td>
                        <td><s:property value="#column.listprice"/></td>
                        <td>$<span class="sumpriceTwo"></span></td>
                        <td><a class="btnOne" href="javascript:void(0)"> 取消</a></td>

                    </tr>

                </s:iterator>
                <%
                    }
                %>
                <%
                } else {
                %>


                <s:iterator value="listcart" var="cart">
                    <tr>
                        <td>
                            <a href="javascript:void(0)">
                                <s:property value="#cart.item.itemid"/>
                            </a>
                        </td>
                        <td>
                            <s:property value="#cart.item.product.productid"/>
                        </td>
                        <td>
                            <s:property value="#cart.item.attr1"/>
                        </td>
                        <td>
                                <%-- <s:property value="#cart.item.attr1"/> --%>
                            有
                        </td>
                        <td>
                            <input type="text" name="inStock" class="textviewtwo" size="5"
                                   value="<s:property value="#cart.quantity"/>"/>
                        </td>
                        <td>
                            <s:property value="#cart.item.listprice"/>
                        </td>
                        <td>
                            $<span class="sumprice"></span>
                        </td>
                        <td>
                            <a class="btnTwo" href="javascript:void(0)">取消</a>
                        </td>
                    </tr>
                </s:iterator>
                <%
                    }
                %>
                <tr>
                    <td colspan="7">总金额:$ <span id="maxprice">0000</span>
                        <!-- <input type="submit" name="update" value="更新购物车" class="Button" /> -->
                    </td>
                    <td>
                        &nbsp;
                    </td>
                </tr>
            </table>


            <a class="Button"
               href="queryShoppingAction?signon.username=${userid }">&lt;&lt;
                上一页</a> <a class="Button"
                           href="queryShoppingAction?&signon.username=${userid }">下一页
            &gt;&gt;</a>


        </form>

        <a class="Button" id="buy" href="javascript:void(0)">付款</a>


    </div>
    <div id="MyList" style="margin-top:10px;">
        <%@ include file="IncludeMyList.jsp" %>
    </div>
    <div id="Separator">&nbsp;</div>

</div>


<%@ include file="../common/IncludeBottom.jsp" %>



