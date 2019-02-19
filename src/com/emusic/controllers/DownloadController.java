/* Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Online Election Voting System
 * This project is licensed under the MIT License, see LICENSE.
 */
package com.emusic.controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream; 
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import org.techzoo.aqsa.View;
import com.emusic.beans.Song;
import com.emusic.common.EMusicLiterals;

public class DownloadController extends BaseController 
{

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		int songId = Integer.parseInt(request.getParameter("songId"));
		Song s = getSongById(songId);
		
		BufferedInputStream bis = null;
		ServletOutputStream sos = response.getOutputStream();
		String filename = s.getFileName();
		File downloadFile = new File(EMusicLiterals.UPLOAD_DIR, filename);
		String ext = filename.substring(filename.lastIndexOf("."), filename.length());
		
		if(ext.equalsIgnoreCase("mp3") || ext.equalsIgnoreCase("mpeg")) response.setContentType("audio/mpeg");
		else if(ext.equalsIgnoreCase("mp4")) response.setContentType("audio/mp4");
		
		response.addHeader("Content-Disposition", "attachment; filename=" + filename);
		response.setContentLength((int)downloadFile.length());
		FileInputStream input = new FileInputStream(downloadFile);
		bis = new BufferedInputStream(input);
        int readBytes = 0;
        //read from the file; write to the ServletOutputStream
        while ((readBytes = bis.read()) != -1) 
        {
        	sos.write(readBytes);
        }
        if (sos != null) {sos.close();}
        if (bis != null) {bis.close();}
        updateDonwloadCount(songId);
		return null;
	}

}
