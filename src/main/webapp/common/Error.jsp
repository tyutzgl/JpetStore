<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ include file="../common/IncludeTop.jsp" %>


<logic:notPresent name="BeanActionException">
  <logic:notPresent name="message">
    <h3>发生了什么事...</h3>
    <b>但没有进一步的信息提供.</b>
  </logic:notPresent>
</logic:notPresent>
<p/>
<logic:present name="BeanActionException">
  <h3>错误!</h3>
  <b><bean:write name="BeanActionException" property="class.name"/></b>

  <p/>
  <bean:write name="BeanActionException" property="message"/>
</logic:present>
<p/>
<logic:present name="BeanActionException">
  <h4>错误详情</h4>
  <pre>
    <%
      Exception e = (Exception) request.getAttribute("BeanActionException");
      e.printStackTrace(new PrintWriter(out));
    %>
  </pre>
</logic:present>

<%@ include file="../common/IncludeBottom.jsp" %>