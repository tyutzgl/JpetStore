<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
	
		$("a").click(function(){
		
			
				alert("123");
		
		})
		
	})


</script>
<div id="Catalog">

<div id="BackLink">
  <a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>
</div>

请确认以下信息，然后按"继续"...

  <table>
    <tr><th align="center" colspan="2">
      <font size="4"><b>订单</b></font>
      <br/><font size="3"><b>2013/02/21 11:13:31</b></font>
    </th></tr>

    <tr><th colspan="2">
    账单地址
    </th></tr>
    <tr><td>
    姓名:</td><td>	<s:property value="account.firstname"/>
    </td></tr>
    <tr><td>
      姓:</td><td>	<s:property value="account.firstname"/> 
    </td></tr>
    <tr><td>
      地址 1:</td><td><s:property value="account.addr1"/>
    </td></tr>
    <tr><td>
      地址 2:</td><td><s:property value="account.addr1"/>    </td></tr>
    <tr><td>
      城市: </td><td>	<s:property value="account.city"/>
    </td></tr>
    <tr><td>
      州 、邦:</td><td><s:property value="account.state"/> 
    </td></tr>
    <tr><td>
     邮政编号:</td><td><s:property value="account.zip"/>
    </td></tr>
    <tr><td>
      国家: </td><td><s:property value="account.country"/> 
    </td></tr>
    <tr><th colspan="2">
  寄运地址
    </th></tr><tr><td>
    姓名:</td><td><s:property value="account.firstname"/>
  </td></tr>
    <tr><td>
      姓:</td><td><s:property value="account.firstname"/>
    </td></tr>
    <tr><td>
     地址1:</td><td><s:property value="account.addr1"/> 
    </td></tr>
    <tr><td>
      地址 2:</td><td><s:property value="account.addr1"/>
    </td></tr>
    <tr><td>
   城市: </td><td><s:property value="account.city"/> 
    </td></tr>
    <tr><td>
      州、邦:</td><td><s:property value="account.state"/>
    </td></tr>
    <tr><td>
     邮政编码:</td><td><s:property value="account.zip"/> 
    </td></tr>
    <tr><td>
     国家: </td><td><s:property value="account.country"/> 
    </td></tr>

  </table>
  
 
  
    <form action="saveOrderAction?signon.username=${userid }" method="post">
  			<input type="hidden" name="account.firstname"  value="<s:property value="account.firstname" />" />
  			<input type="hidden" name="orders.shipaddr1" value="<s:property value="account.addr1" />" />
  			<input type="hidden" name="orders.shipcity" value="<s:property value="account.city" />" />
  			<input type="hidden" name="orders.shipzip" value="<s:property value="account.zip" />" />
  			<input type="hidden" name="orders.shipcountry" value="<s:property value="account.country" />" />
  			
  			<input type="hidden" name="orders.billaddr1" value="<s:property value="account.addr1" />" />
  			<input type="hidden" name="orders.billcity" value="<s:property value="account.city" />" />
  			<input type="hidden" name="orders.courier" value="顺丰速运" />
  			<input type="hidden" name="orders.billcountry" value="<s:property value="account.country" />" />
  			<input type="hidden" name="orders.billstate" value="<s:property value="account.state" />" />
  			<input type="hidden" name="orders.billzip" value="<s:property value="account.zip" />" />
  			<input type="hidden" name="orders.billtofirstname"  value="<s:property value="account.firstname" />" />
  			<input type="hidden" name="orders.totalprice"  value="111111" />
  			<input type="hidden" name="orders.shiptofirstname"  value="<s:property value="account.firstname" />" />
  			<input type="hidden" name="orders.creditcard"  value="9999 9999 999999" />
  			<input type="hidden" name="orders.exprdate"  value="12/03" />
  			<input type="hidden" name="orders.cardtype"  value="美国运通信用卡" />
  			<input type="hidden" name="orders.shipstate"  value="22" />
  			
  			
  			
  			<input type="submit" value="确认" >
  </form>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>





