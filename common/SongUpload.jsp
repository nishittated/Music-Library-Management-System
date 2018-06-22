<!-- Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Music Library Management System
 * This project is licensed under the MIT License, see LICENSE.
 */ --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="span-17" style="padding-left:20px;">    
<br/>
<h3>Document Upload</h3>
<hr/>
<p>Upload all the document in the system using this form. Document format expected are PDF, Power Point (PPT), Compressed Files (zip), Word Documents (doc) and HTMLs</p>
<div class="span-10">
<form action="document.do?action=upload" method="post" enctype="multipart/form-data">
  <table style="border:1px solid #9DBCEB;">
    <tr>
      <th colspan="3" bgcolor="#9DBCEB" scope="col">Document Upload Form </th>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td width="164">Upload</td>
      <td width="12">&nbsp;</td>
      <td width="216">
        <input type="file" name="uploadFile" />
      </td>
    </tr>
    <tr>
      <td>Description</td>
      <td>&nbsp;</td>
      <td valign="top">
        <textarea name="description" cols="2" rows="2" maxlength="240"></textarea>
      </td>
    </tr>
    <tr>
      <td>Course / Class Name </td>
      <td>&nbsp;</td>
      <td>
        <select name="courseId">
        <c:forEach var="c" items="${COURSE_LIST}">
	        <option value="${c.id}">
	          ${c.description}
	        </option>
      	</c:forEach>
        </select>
      </td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td><input type="submit" value="Upload Now" /></td>
    </tr>
  </table>
</form>
</div>
</div>
