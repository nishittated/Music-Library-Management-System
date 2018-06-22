<!-- Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Music Library Management System 
 * This project is licensed under the MIT License, see LICENSE.
 */ -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="span-17" style="padding-left: 20px;"> 
	<br /> 
	<c:if test="${MESSAGE.messageType == 'SUCCESS'}">
		<img src="images/apply.png" style="float:left;margin-right:10px;" /> <h3 style="color:#33FF00;">${MESSAGE.header}</h3>
	</c:if>
	<c:if test="${MESSAGE.messageType == 'ERROR'}">
		<img src="images/cancel.png" style="float:left;margin-right:10px;" /> <h3 style="color:#FF3300;">${MESSAGE.header}</h3>
	</c:if>
	<c:if test="${MESSAGE.messageType == 'INFO'}">
		<img src="images/info.png" style="float:left;margin-right:10px;" /> <h3 style="color:#3300FF;">${MESSAGE.header}</h3>
	</c:if>
	<hr />
	<p>${MESSAGE.description}</p>
</div>
