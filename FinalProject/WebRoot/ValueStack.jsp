<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <!--<base href="<%=basePath%>">-->
    
    <title>Value Stack</title>
    <!--
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	-->
  </head>
  
  <body>
    Entered value : <s:property value="name"/><br/>
    Value of key 1 : <s:property value="key1" /><br/>
    Value of key 2 : <s:property value="key2" /> <br/>
  </body>
</html>
