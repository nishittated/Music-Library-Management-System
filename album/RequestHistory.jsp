<!-- Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Music Library Management System 
 * This project is licensed under the MIT License, see LICENSE.
 */ -->                               
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="span-17" style="padding-left:20px;">
<br/>
<h3>View Song Request History</h3>
<hr/>
<p>List of all Songs Request submitted by you to e-Music System Administrator</p>
<div class="span-16">
 
<table style="border:1px solid #9DBCEB;">
  <tr>
    <th bgcolor="#9DBCEB" scope="col"><span class="style1">Lyrics</span></th>
    <th bgcolor="#9DBCEB" scope="col"><span class="style1">Album</span></th>
    <th bgcolor="#9DBCEB" scope="col"><span class="style1">Request Date/Time</span></th>
    <th bgcolor="#9DBCEB" scope="col"><span class="style1">Availability Status</span></th>
    <th bgcolor="#9DBCEB" scope="col"><span class="style1">Available Date/Time</span></th>
    <th bgcolor="#9DBCEB" scope="col"><span class="style1">Action</span></th>
  </tr>
  <c:forEach var="r" items="${REQUEST_LIST}">
  <tr>
    <td style="border-bottom:1px dotted #9DBCEB;">${r.lyrics}</td>
    <td style="border-bottom:1px dotted #9DBCEB;">${r.album}</td>
    <td style="border-bottom:1px dotted #9DBCEB;">${r.reqDateTime}</td>
    <td style="border-bottom:1px dotted #9DBCEB;">${r.isAvailable}</td>
    <td style="border-bottom:1px dotted #9DBCEB;">${r.availableDateTime}</td>
    <td style="border-bottom:1px dotted #9DBCEB;">
    	<a href="admin.do?action=available&reqId=${r.id}">Action</a>
    </td>
  </tr>
  </c:forEach>
</table>

</div>
</div>
