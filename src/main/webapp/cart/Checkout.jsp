<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>


<%@ taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		var sum = 0;
		$(".sumprice").each(function(){
				var price = $(this).parent().parent().children().eq(5).html()
			
				var count = $(this).parent().parent().children().eq(4).html();
				$(this).html(price * count);
				var countPirce = parseInt($(this).html());
			
				sum = sum + countPirce;
			
		})
		$("#maxprice").html(sum);

	
		$("#continue").click(function(){
			
			location.href="queryAccountAction?signon.username=" + "${userid}";
			
		});
	})
</script>
<div id="Catalog">
<div id="BackLink">
<a href="<%=basePath %>/queryShoppingAction?signon.username=<%=session.getAttribute("userid")%>">返回到购物车</a>
</div>

  <table>
    <tr>
      <td>
        <h2>核对信息</h2>

        <table>

          <tr>
            <td><b>商品编号</b></td>  <td><b>产品编号</b></td>  <td><b>产品描述</b></td> <td><b>In Stock?</b></td>
            <td><b>产品数量</b></td>  <td><b>定价</b></td> <td><b>总成本</b></td>
          </tr>

         
            <tr>
              <td><a href="<%=basePath %>/catalog/Product.jsp">EST-6</a></td>
              <td>F9-BD-01</td>
              <td>成年雄性斗牛犬</td>
              <td>有</td>
              <td>
                1
              </td>
              <td>$18.50</td>
              <td>$37.00</td>
            </tr>
            
        <s:iterator value="listcart" var="cart">
		    	<tr>
		    	
		            <td><a href="javascript:void(0)"><s:property value="#cart.item.itemid"/></a></td>
		            <td><s:property value="#cart.item.product.productid"/></td>
		            <td><s:property value="#cart.item.attr1"/></td>
		            <td>有</td>
		            <td><s:property value="#cart.quantity"/> </td>
		            <td><s:property value="#cart.item.listprice"/> 	</td>
		            <td>$<span class="sumprice">11</span></td>

		    	</tr>
    		
    	</s:iterator>
        
          <tr>
            <td colspan="7">
              总金额:$<span id="maxprice"></span>
            </td>
          </tr>
        </table>
        
          <a href="javascript:void(0);" class="Button">&lt;&lt; 上一页</a>
       
          <a href="javascript:void(0)" class="Button">下一页&gt;&gt;</a>
        
        <a class="Button" id="continue" href="javascript:void(0)">继续</a>
      </td>
  

    </tr>
  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>





