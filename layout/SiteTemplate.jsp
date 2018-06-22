<!-- Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Music Library Management System
 * This project is licensed under the MIT License, see LICENSE. 
 */ -->
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	isELIgnored="false"  %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>e-Music System</title>
<link rel="stylesheet" href="css/screen.css" type="text/css" media="screen, projection" />
<link rel="stylesheet" href="css/menu.css" type="text/css" />
<link rel="stylesheet" href="css/print.css" type="text/css" media="print" />
<style>
	body{ margin-top:20px; background-color:#E1E0E6;}
	myfooter {padding-top:20px; border-top:1px #C40807 dashed;}
</style>
</head>
<body>
<div class="container">

<div class="span-24">
	<jsp:include page="${template.viewPart['header']}" />
</div>

<div class="span-6 border">
	<jsp:include page="${template.viewPart['menu']}" />
</div>
	
<div class="span-18 last">
	<jsp:include page="${template.viewPart['body']}" />
</div>	
			
<div class="span-24" class="myfooter"> 
	<jsp:include page="${template.viewPart['footer']}" />
</div>		

</div>

</body>
</html>
