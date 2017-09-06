<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <!--<base href="<%=basePath%>">-->
    
    <title>Hello World</title>
    <!--
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	-->
  </head>
  
	<body>
    	<h1>Hello World From Struts2</h1>
    	<!-- Tom -->
    	<form action="countCustomers" method="post">
       			District:<br/><input type="text" name="districtName"/><br/>
 				<s:select name = "active" label = "Active"
       				list = "{'true', 'false'}" />
       			<input type="submit" value="submit"/>
       		</form>
       		
       		<form action="getPhone">
       			<label for="name">Please enter your first and last name</label><br/>
       			first name :<input type="text" name="firstName"/>
       			last name :<input type="text" name="lastName"/>
       			<input type="submit" value="submit"/>
       		</form>
       		
       		<form action="getTitle">
       			<label for="name">Please enter length</label><br/>
       			length1 :<input type="text" name="length1"/>
       			length2 :<input type="text" name="length2"/>
       			<input type="submit" value="submit"/>
       		</form>
    	
    	<!--  bruce -->
       		<form action="database" method="post">
       			Length1:<br/><input type="text" name="length1"/><br/>
       			Length2:<br/><input type="text" name="length2"/><br/>
       			<input type="submit" value="get"/>
       		</form>
       		
       		<form action="DataBaseQuery_District_Stats" method="post">
       			District Stats <input type="submit" value="get"/>
       		</form>
       		
       		<form action="DataBaseQuery_Author_Title" method="post">
       			Author Title <input type="submit" value="get"/>
       		</form>
       		
       		<form action="District_least_customer" method="post">
       			the districts that has the least number of customers: <br/>
       			Number:<br/><input type="text" name="districts_number"/>
       			<input type="submit" value="get"/>
       		</form>
	</body>
</html>
