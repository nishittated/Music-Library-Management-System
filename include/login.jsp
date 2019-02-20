<!-- Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Music Library Management System  
 * This project is licensed under the MIT License, see LICENSE.
 */ --> 
<div class="span-12" style="margin:50px 0px;"> 
<table width="100%" border="1" cellspacing="0" cellpadding="0" style="padding:10px;">
  <tr>
    <td>
		<img src="images/SharedMusic.png" width="180" height="180" />	
	</td>
    <td> 
	<h2 style="font-size:18px;">User Login</h2>
		<form method="post" name="frmLogin" id="frmLogin" action="user.do?action=login">
		 <div class="errorMessage" align="center"></div>
         <strong>Name : </strong><input name="name" type="text" id="name"  size="10" maxlength="20"><br/><br/>
         <strong>Password : </strong><input name="password" type="password"  id="txtPassword"  size="10" /><br/>
         <br/>
         <br/><input name="btnLogin" type="submit" id="btnLogin" value="Login Now"  
         	style="font-weight: bold;color:red; padding:5px 10px; font-family: verdana;" />
      </form>
	</td>
  </tr>
  <tr>
  <td colspan="2" align="right">If you don't have any Account then <a href="user.do?action=register">Register</a> for Login.</td>
  </tr>
</table>
</div>
<div class="span-5 last">&nbsp;</div>
