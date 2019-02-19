<!-- Copyright (c) Nishit Tated. All Rights Reserved. 
   Project name: Music Library Management System
 * This project is licensed under the MIT License, see LICENSE.
 */ -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<div class="span-17" style="padding-left:20px;"> 
<br/> 
<h3>User Registration</h3> 
<hr/>
<p>All Users who want to access the e-Music System and don't have any account, can register Here.</p>
<div class="span-10">
<form action="user.do?action=create" method="post">
  <table style="border:1px solid #9DBCEB;">
    <tr>
      <th colspan="3" bgcolor="#9DBCEB" scope="col">User Registration Form </th>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td width="164">User Name </td>
      <td width="12">&nbsp;</td>
      <td width="216">
        <input type="text" name="userName" />
      </td>
    </tr>
    <tr>
      <td>Password</td>
      <td>&nbsp;</td>
      <td>
        <input type="password" name="password" />
      </td>
    </tr>
    <tr>
      <td>Email ID </td>
      <td>&nbsp;</td>
      <td>
        <input type="text" name="email" />
      </td>
    </tr>
    <tr>
      <td>Address</td>
      <td>&nbsp;</td>
      <td valign="top">
        <textarea name="address" cols="5" rows="2"></textarea>
      </td>
    </tr>
    <tr>
      <td>Phone No </td>
      <td>&nbsp;</td>
      <td>
        <input type="text" name="phoneNo" />
      </td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td><input type="submit" value="Register Now" /></td>
    </tr>
  </table>
</form>
</div>
</div>
