<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<bean:define id="product" name="catalogBean" property="product" />
<bean:define id="item" name="catalogBean" property="item" />

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
		$(function(){
			$("a").click(function(){
			
		
				location.href="saveShoppingAction?item.itemid=<s:property value="item.itemid"/>" + 
							"&signon.username=<%=session.getAttribute("userid")%>";
			})
			//$("#itemTable tr td").first().attr("img","<s:property value='item.product.descn'/>");
			$("#aaa").html("<s:property value='item.product.descn'/>");
			$("#imagespan").html($("#aaa").text());
		})
		
	</script>

<div id="Catalog">
	<div id="BackLink">
		<a
			href="queryItemAction?product.productid=<s:property value="item.product.productid"/>">
			<s:property value="item.product.name" />
		</a>
	</div>
	<table id="itemTable">
		<tr>
			<td><span id="aaa" style="display:none"></span> <span
				id="imagespan"></span></td>
		</tr>
		<tr>
			<td><b><s:property value="item.itemid" /></b></td>
		</tr>
		<tr>
			<td><b><font size="4"> <s:property value="item.attr1" />
				</font></b></td>
		</tr>
		<tr>
			<td><s:property value="item.product.name" /></td>
		</tr>
		<tr>
			<td><s:property value="qty" />库存。</td>
		</tr>
		<tr>
			<td>$<s:property value="item.listprice" />
		<tr>
			<td><a class="Button" href="javascript:void(0)"> 添加到购物车</a></td>
		</tr>




	</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>



