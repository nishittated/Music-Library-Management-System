<!-- Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Music Library Management System
 * This project is licensed under the MIT License, see LICENSE.
 */ -->
<%@page import="com.emusic.common.EMusicLiterals"%> 
<%@page import="com.emusic.beans.Song"%> 
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="span-17" style="padding-left:20px;"> 
<br/>
<div class="span-16">
<%-- 
Add Song Form
--%>
<c:if test="${sessionScope.MODULE != null && sessionScope.MODULE == 'ADMIN_MODULE'}">
<h3>Add Songs to Album</h3>
<hr/>
<p>Add more songs in this Album</p>
<div class="span-10">
<form action="album.do?action=addSong" method="post" enctype="multipart/form-data" >
  <table style="border:1px solid #9DBCEB;">
    <tr>
      <th colspan="3" bgcolor="#9DBCEB" scope="col">Create Song Form</th>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td><input type="hidden" name="albumId" value="<%=request.getParameter("albumId")%>" /></td>
    </tr>
    <tr>
      <td width="164">Lyrics</td>
      <td width="12">&nbsp;</td>
      <td width="216"><input type="text" name="lyric" /></td>
    </tr>
    <tr>
      <td>Singer</td>
      <td>&nbsp;</td>
      <td><input type="text" name="singer" maxlength="200" size="40" /></td>
    </tr>
    <tr>
      <td>Song Length</td>
      <td>&nbsp;</td>
      <td><input type="text" name="length" size="10" /></td>
    </tr>
    <tr>
      <td>Upload</td>
      <td>&nbsp;</td>
      <td><input type="file" name="upload" size="30" /></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td><input type="submit" value="Create Album" /></td>
    </tr>
  </table>
</form>
</div>
</c:if>
<%--
View all List of Song
--%>
<hr/>
<p>List of all available Songs in e-Music System</p>
<table style="border:1px solid #9DBCEB;">
  <tr>
    <th bgcolor="#9DBCEB" scope="col"><span class="style1">Lyrics</span></th>
    <th bgcolor="#9DBCEB" scope="col"><span class="style1">Singer</span></th>
    <th bgcolor="#9DBCEB" scope="col"><span class="style1">Album</span></th>
    <th bgcolor="#9DBCEB" scope="col"><span class="style1">Length</span></th>
    <th bgcolor="#9DBCEB" scope="col"><span class="style1">Download</span></th>
  </tr>
  <%
  List<Song> songs = (List<Song>)request.getAttribute(EMusicLiterals.SONGS_LIST);
  for(Song s : songs){
  %>
  <tr>
    <td style="border-bottom:1px dotted #9DBCEB;"><%=s.getLyric() %></td>
    <td style="border-bottom:1px dotted #9DBCEB;"><%=s.getSinger()%></td>
    <td style="border-bottom:1px dotted #9DBCEB;"><%=s.getAlbum().getName() %></td>
    <td style="border-bottom:1px dotted #9DBCEB;">
    <% 
    String fileName = s.getFileName();
    String ext = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
   // System.out.println("ext : "+ext);
    if(ext.equalsIgnoreCase("mp3") || ext.equalsIgnoreCase("mpeg") || ext.equalsIgnoreCase("mp4")){
    %>
    <audio controls="controls">
		<source src="<%=s.getFileName()%>" type="audio/mpeg" >
		<source src="<%=s.getFileName()%>" type="audio/ogg" >
		<embed height="50" width="100" src="<%=s.getFileName()%>" >
	</audio>
    <% 
    }
    else if(ext.equalsIgnoreCase("wmv")) {
    %>
    
	<OBJECT ID="MediaPlayer" WIDTH="192" HEIGHT="190" CLASSID="CLSID:22D6F312-B0F6-11D0-94AB-0080C74C7E95" STANDBY="Loading Windows Media Player components..." TYPE="application/x-oleobject">
		<PARAM NAME="FileName" VALUE="<%=s.getFileName()%>">
		<PARAM name="ShowControls" VALUE="true">
		<param name="ShowStatusBar" value="false">
		<PARAM name="ShowDisplay" VALUE="false">
		<PARAM name="autostart" VALUE="false">
		<EMBED TYPE="application/x-mplayer2" SRC="<%=s.getFileName()%>" NAME="MediaPlayer" WIDTH="192" HEIGHT="190" ShowControls="1" ShowStatusBar="0" ShowDisplay="0" autostart="0"> </EMBED>
	</OBJECT>

    <% 
    }
    else 
    {
    %>
    Format Not Supported.	
    <%
    } 
    %>
    </td>
    <td style="border-bottom:1px dotted #9DBCEB;">
    	<a href="download.do?songId=${s.id}">${s.downloadCount} times</a>
    </td>
  </tr>          
  <% } %>
</table>
</div>
</div>
