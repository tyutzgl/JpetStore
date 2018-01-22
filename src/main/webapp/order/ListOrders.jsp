<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#order a").click(function(){
		
			location.href = "saveOrderTwoAction?signon.username=" + "${userid }" + "&orders.orderid=" + $(this).html();
		
		})
	})

</script>
<div id="Catalog">
<h2>我的订单</h2>

<table id="order">
  <tr><th>订单编号</th>  <th>日期</th>  <th>总金额</th></tr>

    <tr>		
      <td><a href="<%=basePath %>/order/ViewOrder.jsp">1000 </a></td>
      <td>2013/02/18 10:53:01 </td>
      <td>$16.50</td>
    </tr>
    
            <s:iterator value="orderslist" var="orders">
		    	<tr>
		    	
		            <td><a href="javascript:void(0)"><s:property value="#orders.orderid"/></a></td>
		            <td><s:property value="#orders.orderdate"/></td>
		            <td><s:property value="#orders.totalprice"/></td>   
		    		
		    	</tr>
    		
    	</s:iterator>
  
</table>


  <a href="historyOrdersAction?begin=${begin-1 }&signon.userid=${userid }" class="Button">&lt;&lt; 上一页</a>

  <a href="historyOrdersAction?begin=${begin+1 }&signon.userid=${userid }" Class="Button">下一页 &gt;&gt;</a>

</div>
<%@ include file="../common/IncludeBottom.jsp" %>


