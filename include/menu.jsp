<!-- Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Music Library Management System
 * This project is licensed under the MIT License, see LICENSE. 
 */ -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:if
	test="${sessionScope.MODULE != null && sessionScope.MODULE == 'ADMIN_MODULE'}">
	<div id="navcontainer">
		<ul>
			<li><a href="admin.do?action=main" title="">Welcome <c:out value="${sessionScope.USER_DETAILS.name}" /></a></li>
			<li><a href="album.do?action=form" title="">Create New Albums</a></li>
			<li><a href="album.do?action=viewall" title="">View all Albums</a></li>
			<li><a href="admin.do?action=request" title="View Song Request">View Song Request</a></li>
			<li><a href="admin.do?action=logout" title="">Log Out</a></li>
		</ul>
	</div>
</c:if>

<c:if
	test="${sessionScope.MODULE != null && sessionScope.MODULE == 'USER_MODULE'}">
	<div id="navcontainer">
		<ul>
			<li><a href="user.do?action=main" title="">Welcome <c:out value="${sessionScope.USER_DETAILS.name}" /></a></li>
			<li><a href="album.do?action=viewall" title="View all Ablums List">View all Albums</a></li>
			<li><a href="user.do?action=reqform" title="Request a Song">Request a Song</a></li>
			<li><a href="user.do?action=reqhistory" title="Request History">Request History</a></li>
			<li><a href="user.do?action=logout" title="Log out">Log Out</a></li>
		</ul>
	</div>
</c:if>

<c:if test="${sessionScope.MODULE == null || sessionScope.MODULE == ''}">
	<p style="padding: 10px;margin-top:20px;">This menus is Disable. You will browse the menu's after successfully Login.</p>
</c:if>
<br/>
<p style="height: 200px;"></p>
