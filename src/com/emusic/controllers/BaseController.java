/* Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Online Election Voting System
 * This project is licensed under the MIT License, see LICENSE.
 */
package com.emusic.controllers;
 
import static java.lang.String.format;
import java.io.File; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.techzoo.aqsa.controller.AbstractController;
import org.techzoo.aqsa.utils.AqsaUtil;

import com.emusic.beans.Album;
import com.emusic.beans.Request;
import com.emusic.beans.Song;
import com.emusic.common.EMusicLiterals;
import com.emusic.utils.ConnectionUtils;

public abstract class BaseController extends AbstractController 
{

	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; 
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; 
	private static final int REQUEST_SIZE = 1024 * 1024 * 50;  

	public List<Album> getAllAlbums()
			throws Exception {
		String query = "SELECT * FROM tbl_albums ORDER BY id ASC LIMIT 20";
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<Album> aList = new ArrayList<Album>();
		while (rs.next()) {
			Album a = new Album();
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setArtist(rs.getString(3));
			a.setMusic(rs.getString(4));
			a.setPrice(rs.getInt(5));
			a.setCompany(rs.getString(6));
			aList.add(a);
		}
		if (con != null)
			con.close();
		return aList;
	}
	
	public Song getSongById(int songId) throws Exception {
		Song s = null;
		Connection c = ConnectionUtils.getConnection();
		String sql = "SELECT id, file_name FROM tbl_songs WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, songId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			s = new Song();
			s.setId(rs.getInt(1));
			s.setFileName(rs.getString(2));
		}
		if(c != null) c.close();
		return s;
	}
	
	public boolean updateDonwloadCount(int songId) throws Exception {
		boolean isUpdated = false;
		Connection c = ConnectionUtils.getConnection();
		String sql = "UPDATE tbl_songs SET down_count = down_count+1 WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, songId);
		int update = ps.executeUpdate();
		if(update == 1) isUpdated = true;
		if(c != null) c.close();
		return isUpdated;
	}
	
	public List<Song> getAllSongsByAlbumId(int albumId) throws Exception {
		List<Song> songs = new ArrayList<Song>();
		String sql = "SELECT s.id, s.lyrics, a.id, a.name, s.singer, s.length, s.down_count, s.file_name " +
				"FROM tbl_songs s, tbl_albums a " +
				"WHERE s.aid = a.id AND s.aid  = ? " +
				"ORDER BY s.lyrics ASC LIMIT 20";
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, albumId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Song s = new Song();
			s.setId(rs.getInt(1));
			s.setLyric(rs.getString(2));
			Album a = new Album();
			a.setId(rs.getInt(3));
			a.setName(rs.getString(4));
			s.setAlbum(a);
			s.setSinger(rs.getString(5));
			s.setLength(rs.getString(6));
			s.setDownloadCount(rs.getInt(7));
			s.setFileName(EMusicLiterals.UPLOAD_DIR +"/"+rs.getString(8));
			songs.add(s);
		}
		if (con != null) con.close();
		return songs;
	} 
	
	public List<Request> getAllRequestById(int userId, boolean isAdmin) throws Exception {
		List<Request> requests = new ArrayList<Request>();
		String sqlToken = isAdmin ? "WHERE r.is_avbl = 'N' " : "WHERE r.uid = ? ";
		String sql = "SELECT r.id, r.lyrics, r.album, r.req_date_time, r.is_avbl, r.avbl_date_time " +
				"FROM tbl_song_request r " +
				sqlToken +
				"ORDER BY r.id ASC LIMIT 20";
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		if(!isAdmin) ps.setInt(1, userId);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(rs.next()){
			Request req = new Request();
			req.setId(rs.getInt(1));
			req.setLyrics(rs.getString(2));
			req.setAlbum(rs.getString(3));
			req.setReqDateTime(rs.getString(4));
			String isAvbl = rs.getString(5).equals("N") ? "No" : "Available";
			req.setIsAvailable(isAvbl);
			req.setAvailableDateTime(rs.getString(6));
			requests.add(req);
		}
		if (con != null) con.close();
		return requests;
	}
	
	protected File uploadFile(List<FileItem> formItems, String destFolder, boolean override) 
	{
		String uploadPath = destFolder;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		File newFileName = null;
		try {
			for(FileItem fi : formItems ){
				if (!fi.isFormField()) {
					String fileName = new File(fi.getName()).getName();
					File outFilePath = new File(destFolder);
			    	newFileName = new File(outFilePath, fileName);
			    	if(newFileName.exists() && !override){
			    		String fileExt = AqsaUtil.fileExtention(newFileName);
			    		String fileWithoutExt = AqsaUtil.fileNameWithoutExtention(newFileName);
			    		String dateTime = AqsaUtil.currentDateTime();
			    		String newOverriddenFile = format("%s-%s.%s", fileWithoutExt, dateTime, fileExt);
			    		newFileName = new File(outFilePath, newOverriddenFile);
			    	}
					fi.write(newFileName);
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return newFileName;
	}
	
	protected File uploadFile(List<FileItem> formItems, String destFolder) 
	{
		String uploadPath = destFolder;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		File uploadedFile = null;
		try {
			for(FileItem fi : formItems ){
				if (!fi.isFormField()) {
					String fileName = new File(fi.getName()).getName();
					String filePath = uploadPath + File.separator + fileName;
					uploadedFile = new File(filePath);
					fi.write(uploadedFile);
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return uploadedFile;
	}
	
	@SuppressWarnings("unchecked")
	protected List<FileItem> initRequest(HttpServletRequest req){
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if(!isMultipart) throw new UnsupportedOperationException();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(REQUEST_SIZE);
		List<FileItem> formItems = null;
		try {
			formItems = upload.parseRequest(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formItems;
	}
	
	protected String getFieldValue(List<FileItem> formItems, String fieldName) {
		String value = null;
		try {
			for(FileItem fi : formItems ){
				if (fi.isFormField()) {
					if(fi.getFieldName().equals(fieldName)){
						value = fi.getString();
					}
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return value;
	}
}
