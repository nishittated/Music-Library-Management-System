/* Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Online Election Voting System
 * This project is licensed under the MIT License, see LICENSE.  
 */
package com.emusic.controllers;

import java.io.File;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.techzoo.aqsa.View;

import com.emusic.beans.Album;
import com.emusic.beans.Song;
import com.emusic.common.EMusicLiterals;
import com.emusic.common.Message;
import com.emusic.utils.ConnectionUtils;

public class AlbumController extends BaseController 
{

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String action = request.getParameter("action")!= null ? request.getParameter("action") : "viewall";
		
		if(action.equals("viewall")){
			List<Album> albams = getAllAlbums();
			Map<String, List<Album>> map = new HashMap<String, List<Album>>();
			map.put(EMusicLiterals.ALBUM_LIST, albams);
			return new View("albums", map);
		}
		else if(action.equals("form")) {
			return new View("form");
		}
		else if(action.equals("create")) {
			String sql = "INSERT INTO tbl_albums (name, artists, music, price, company ) " +
					"values(?,?,?,?,?)";
			Connection con =  null; 
			int update = 0;
			try {
				con = ConnectionUtils.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,request.getParameter("albumName"));
				ps.setString(2,request.getParameter("artist"));
				ps.setString(3,request.getParameter("music"));
				ps.setInt(4,Integer.parseInt(request.getParameter("price")));
				ps.setString(5,request.getParameter("company"));
				update = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(con != null) con.close();
			Message m = null;
			if(update == 1){
				m = new Message();
				m.setMessageType(Message.SUCCESS);
				m.setHeader("Album Created.");
				m.setDescription("New Album is added successfully. <br/>" +
						"To view a List of all albums <a href=\"album.do?action=viewall\">Click here...</a>");
			}
			else {
				m = new Message();
				m.setMessageType(Message.ERROR);
				m.setHeader("Album Creation Failed.");
				m.setDescription("Album creation failed Beacause of some Reasons.<br/>" +
						"You can re-try using <a href=\"album.do?action=form\">Create Album</a> Link");
			}
			Map<String, Message> map = new HashMap<String, Message>();
			map.put(EMusicLiterals.MESSAGE, m);
			return new View("message", map);
		}
		else if(action.equals("detail")) {
			int albumId = Integer.parseInt(request.getParameter("albumId"));
			List<Song> allSongs = getAllSongsByAlbumId(albumId);
			Map<String, List<Song>> map = new HashMap<String, List<Song>>();
			map.put(EMusicLiterals.SONGS_LIST, allSongs);
			return new View("songs", map);
		}
		else if(action.equals("addSong")) {
			List<FileItem> fileItems = initRequest(request);
			File uploadedFile = uploadFile(fileItems, EMusicLiterals.UPLOAD_DIR, false);
			String lyric = getFieldValue(fileItems, "lyric");
			String singer = getFieldValue(fileItems, "singer");
			String length = getFieldValue(fileItems, "length");
			int albumId = Integer.parseInt(getFieldValue(fileItems, "albumId"));
			String sql = "INSERT INTO tbl_songs (lyrics, file_name, aid, singer, length, down_count) " +
					"VALUES (?, ?, ?, ?, ?, 0)";
			Connection con = ConnectionUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, lyric);
			ps.setString(2, uploadedFile.getName());
			ps.setInt(3, albumId);
			ps.setString(4, singer);
			ps.setString(5, length);
			int update = ps.executeUpdate();
			if(con != null) con.close();
			Message m = null;
			if(update == 1){
				m = new Message();
				m.setMessageType(Message.SUCCESS);
				m.setHeader("Song added Succuessful.");
				m.setDescription("New song added successfully to the Ablum. <br/>" +
						"To view a List of all albums <a href=\"album.do?action=viewall\">Click here...</a>");
			}
			else {
				m = new Message();
				m.setMessageType(Message.ERROR);
				m.setHeader("Song adding Failed.");
				m.setDescription("Adding song is failed Beacause of some Reasons.<br/>" +
						"To view a List of all albums <a href=\"album.do?action=viewall\">Click here...</a>");
			}
			Map<String, Message> map = new HashMap<String, Message>();
			map.put(EMusicLiterals.MESSAGE, m);
			return new View("message", map);
		}
		return null; 
	}
}
