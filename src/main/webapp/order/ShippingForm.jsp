<%@ include file="../common/IncludeTop.jsp" %>
     <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="Catalog">

  <form action="<%=basePath %>/order/ViewOrder.jsp"  method="post">

    <table>
      <tr><th colspan=2>
     送货地址
      </th></tr>

      <tr><td>
      姓名:</td><td><input type="text" value="ABC" />
      </td></tr>
      <tr><td>
       姓:</td><td><input type="text" value="XYX" />
      </td></tr>
      <tr><td>
       地址1:</td><td><input type="text" size="40" value="901 San Antonio Road" />
      </td></tr>
      <tr><td>
    地址 2:</td><td><input type="text" size="40" value="MS UCUP02-206" />
      </td></tr>
      <tr><td>
        城市: </td><td><input type="text" size="40" value="Palo Alto" />
      </td></tr>
      <tr><td>
        州、邦:</td><td><input type="text" size="4" value="CA" />
      </td></tr>
      <tr><td>
       邮政编码:</td><td><input type="text" size="10" value="94303" />
      </td></tr>
      <tr><td>
       国家: </td><td><input type="text" size="15" value="USA" />
      </td></tr>


    </table>

    <input type="submit" name="submit" value="继续">

  </form>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>