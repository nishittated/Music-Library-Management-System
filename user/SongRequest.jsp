<!-- Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Music Library Management System
 * This project is licensed under the MIT License, see LICENSE. 
 */ --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="span-17" style="padding-left:20px;"> 
<br/>
<div class="span-16">
<%-- 
Add Song Form
--%>
<h3>Song Request</h3>
<hr/>
<p>Request a Song of your choice to eMusic Admin, we will take action soon on your Request.</p>
<div class="span-10">
<form action="user.do?action=request" method="post">
  <table style="border:1px solid #9DBCEB;">
    <tr>
      <th colspan="3" bgcolor="#9DBCEB" scope="col">Song Request Form</th>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td width="164">Lyrics</td>
      <td width="12">&nbsp;</td>
      <td width="216"><input type="text" name="lyric" /></td>
    </tr>
    <tr>
      <td>Album/Film</td>
      <td>&nbsp;</td>
      <td><input type="text" name="album" maxlength="200" size="40" /></td>
    </tr>
    <tr>
      <td>Description</td>
      <td>&nbsp;</td>
      <td><textarea name="desc"></textarea></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td><input type="submit" value="Request a Song" /></td>
    </tr>
  </table>
</form>
</div>
</div>
</div>
