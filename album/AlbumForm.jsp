<!-- Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Music Library Management System
 * This project is licensed under the MIT License, see LICENSE.
 */ --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<div class="span-17" style="padding-left:20px;"> 
<br/>
<h3>Album Creation</h3>
<hr/>
<p>Create a New Album entry for e-Music System.</p> 
<div class="span-10">
<form action="album.do?action=create" method="post">
  <table style="border:1px solid #9DBCEB;">
    <tr>
      <th colspan="3" bgcolor="#9DBCEB" scope="col">Create Album Form</th>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td width="164">Album name</td>
      <td width="12">&nbsp;</td>
      <td width="216">
        <input type="text" name="albumName" />
      </td>
    </tr>
    <tr>
      <td>Artists</td>
      <td>&nbsp;</td>
      <td>
        <input type="text" name="artist" maxlength="200" size="40" value=""/>
      </td>
    </tr>
    <tr>
      <td>Music Director</td>
      <td>&nbsp;</td>
      <td>
        <input type="text" name="music"  size="35" />
      </td>
    </tr>
    <tr>
      <td>Price (Rs.)</td>
      <td>&nbsp;</td>
      <td>
        <input type="text" name="price"  size="10" />
      </td>
    </tr>
    <tr>
      <td>Company</td>
      <td>&nbsp;</td>
      <td>
        <input type="text" name="company" />
      </td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td><input type="submit" value="Create Album" /></td>
    </tr>
  </table>
</form>
</div>
</div>
