<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>

<%@ taglib uri="/struts-tags" prefix="s" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("table tr td a").click(function(){
			location.href="queryItemAction?product.productid=" + $(this).html();
		})
		
		
		$(".span").each(function(){
		
			$(this).parent().find("span").eq(0).html($(this).text());
		})
	
	});
	
	
</script>



<div id="Catalog">
<div id="BackLink">

  <a href="<%=basePath %>/catalog/Main.jsp">返回主菜单</a>

</div>
  <table>
    <tr><th>&nbsp;</th>  <th>产品编号</th>  <th>产品名称</th></tr>

      
       <s:iterator value="productlist" var="product">
		    	<tr>
		    		<td><span></span>
		    			<p class="span" style="display:none">
		    				<s:property value='#product.descn'/>
		    			</p>
		    		</td>
		    		<td><a><s:property value="#product.productid"/></a></td>
		    		<td><s:property value="#product.name"/></td>
		    		
		    	</tr>
    		
    	</s:iterator>

    <tr>
      <td>
       
          <a href="queryLikeAction?begin=${begin-1 }&value=${value }">&lt;&lt; 上一页</a>
      
          <a href="queryLikeAction?begin=${begin+1 }&value=${value }">下一页 &gt;&gt;</a>
   
      </td>
    </tr>

  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>




