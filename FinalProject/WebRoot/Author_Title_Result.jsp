<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Author Title</title>

  </head>
  
  <body>
    <table border="0" cellspacing="1" cellpadding="0" width="100%" class="boxtbl">
    <s:iterator value="books" status="statusVar">
  		<tr>
     		<td><s:property/></td>
  		</tr>
	</s:iterator>
	</table>
	<a href="index.jsp">Return</a>
  </body>
</html>
