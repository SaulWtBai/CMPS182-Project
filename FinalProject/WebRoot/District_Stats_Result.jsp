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
    
    <title>District Stats</title>

  </head>
  
  <body>
  	Overview: <br>
  	<tr>
    	<s:iterator value="districts">
        	<s:iterator value="top">
        		<td><s:property value="key"/> </td>:
            	<td><s:property value="value"/> </td><br>
        	</s:iterator>    
    	</s:iterator>
	</tr>
  </body>
  <a href="index.jsp">Return</a>
</html>
