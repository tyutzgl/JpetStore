<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		
		$("#accountSubmit").click(function(){
			var userid = $("#accountTable input:first").val();
			var password = $("#accountTable input:eq(0)").val();
		 
			
		});
		
		$("#accountTable input:first").bind({
			focus:function(){
			
				$("#userid").css("display","inline");
				$("#userid").html("输入用户名");
			},
			blur:function(){
			
				if($(this).val() == ""){
					$("#userid").html("用户名不能为空");
					$("#userid").css("color","red");
				}else{
					$("#userid").css("display","none");
				}
			}
		
		
		})
		
		
		$("#accountSubmit").click(function(){
			var userid = $("#accountTable input:first").val();
			var password = $("#accountTable input:eq(0)").val();
		 
			
		});
		
		$("#accountTable input:eq(1)").bind({
			focus:function(){
			
				$("#password").css("display","inline");
				$("#password").html("输入密码");
			},
			blur:function(){
			
				if($(this).val() == ""){
					$("#password").html("密码不能为空");
					$("#password").css("color","red");
				}else{
					$("#password").css("display","none");
				}
			}
		
		
		})
		$("#accountTable input:eq(2)").bind({
			focus:function(){
			
				$("#passwordcommit").css("display","inline");
				$("#passwordcommit").html("请重复密码");
			},
			blur:function(){
			
				if($(this).val() == ""){
					$("#passwordcommit").html("密码不能为空");
					$("#passwordcommit").css("color","red");
				}else if($("#accountTable input:eq(1)").val() != $("#accountTable input:eq(2)").val()){
					$("#passwordcommit").html("密码不一样，请重新输入");
					$("#passwordcommit").css("color","red");
				}else{
					$("#passwordcommit").css("display","none");
				}
			}
		
		
		})
		
		
	
	});
	
	
</script>
<div id="Catalog">

  <form action="insertAction" method="post">

    

    <h3>账户信息</h3>

    <table id="accountTable">
      <tr>
        <td>账户:</td><td><input type="text" id="" name="signon.username"/></td>
        <td><span id="userid"></span></td>
      </tr><tr>
      <td>新密码:</td><td><input type="password" id="" name="signon.password" /></td>
   		 <td><span id="password"></span></td>
    </tr><tr>
      <td>重复密码:</td><td><input type="password"/></td>
      <td><span id="passwordcommit"></span></td>
    </tr>
    </table>

    <%@ include file="IncludeAccountFields.jsp" %>

    <input type="submit" id="accountSubmit" name="submit" value="创建账户" class="Button" />

  </form>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>