/* Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Online Election Voting System
 * This project is licensed under the MIT License, see LICENSE.
 */
package com.emusic.controllers;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.techzoo.aqsa.View;

import com.emusic.beans.Request;
import com.emusic.beans.User;
import com.emusic.common.EMusicLiterals;
import com.emusic.common.Message;
import com.emusic.utils.ConnectionUtils;

public class UserController extends BaseController {
	
	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String action = request.getParameter("action")!= null ? request.getParameter("action") : "view";
		
		if(action.equals("create")){
			String sql = "INSERT INTO tbl_users (name, pwd, email, address, phone_no, type) " +
					"values(?,PASSWORD(?),?,?,?,?)";
			Connection con =  null; 
			int update = 0;
			try {
				con = ConnectionUtils.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,request.getParameter("userName"));
				ps.setString(2,request.getParameter("password"));
				ps.setString(3,request.getParameter("email"));
				ps.setString(4,request.getParameter("address"));
				ps.setString(5,request.getParameter("phoneNo"));
				ps.setString(6, EMusicLiterals.USER);
				update = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(con != null) con.close();
			Message m = null;
			if(update == 1){
				m = new Message();
				m.setMessageType(Message.SUCCESS);
				m.setHeader("Registration Succuessful.");
				m.setDescription("Your Registration is successfully completed. <br/>" +
						"You can <a href=\"user.do?action=view\">Login Now</a>");
			}
			else {
				m = new Message();
				m.setMessageType(Message.ERROR);
				m.setHeader("Registration Failed.");
				m.setDescription("Your Registration is failed Beacause of some Reasons.<br/>" +
						"You can re-try using <a href=\"user.do?action=register\">Register Now</a> Link");
			}
			Map<String, Message> map = new HashMap<String, Message>();
			map.put(EMusicLiterals.MESSAGE, m);
			return new View("message", map);
		}
		else if(action.equals("register")){
			return new View("register");
		}
		
		else if(action.equals("login")){
			String query = "SELECT id, name, email, type FROM tbl_users WHERE name = ? " +
					"AND pwd = PASSWORD(?) AND type = 'USER'";
			Connection con = ConnectionUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, request.getParameter("name"));
			ps.setString(2, request.getParameter("password"));
			ResultSet rs = ps.executeQuery();
			User u = null;
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setUserType(rs.getString(4));
			}
			if(con != null) con.close();
			if(u != null) {
				HttpSession session = request.getSession();
				session.setAttribute(EMusicLiterals.USER_DETAILS, u);
				session.setAttribute(EMusicLiterals.MODULE, EMusicLiterals.USER_MODULE);
				return new View("success");
			}
			else {
				return new View("error");
			}
		}
		else if(action.equals("main")){
			return new View("main");
		}
		else if(action.equals("reqform")) {
			return new View("reqform");
		}
		else if(action.equals("reqhistory")) {
			User u = (User)request.getSession().getAttribute(EMusicLiterals.USER_DETAILS);
			List<Request> requests = getAllRequestById(u.getId(), false);
			Map<String, List<Request>> map = new HashMap<String, List<Request>>();
			map.put(EMusicLiterals.REQUEST_LIST, requests);
			return new View("request", map);
		}
		else if(action.equals("request")) {
			User u = (User)request.getSession().getAttribute(EMusicLiterals.USER_DETAILS);
			int uid = u.getId();
			String sql = "INSERT INTO tbl_song_request (uid, lyrics, album, description, req_date_time, is_avbl, avbl_date_time) " +
					"VALUES (?, ?, ?, ?, NOW(), 'N', ?)";
			Connection con =  null; 
			int update = 0;
			try {
				con = ConnectionUtils.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,uid);
				ps.setString(2,request.getParameter("lyric"));
				ps.setString(3,request.getParameter("album"));
				ps.setString(4,request.getParameter("desc"));
				ps.setString(5,"");
				update = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(con != null) con.close();
			Message m = null;
			if(update == 1){
				m = new Message();
				m.setMessageType(Message.SUCCESS);
				m.setHeader("Request Send.");
				m.setDescription("Your song request is plased successfully. <br/>" +
						"Please stay tuned! Your request is expected to complete in 24 Working Hours <br/>" +
						"Meanwhile you can continue <a href=\"album.do?action=viewall\">Downloading..</a>");
			}
			else {
				m = new Message();
				m.setMessageType(Message.ERROR);
				m.setHeader("Request Failed.");
				m.setDescription("Your Request is failed Beacause of some Reasons.<br/>" +
						"You can re-try using <a href=\"user.do?action=request\">Register Now</a> Link");
			}
			Map<String, Message> map = new HashMap<String, Message>();
			map.put(EMusicLiterals.MESSAGE, m);
			return new View("message", map);
		}
		else if(action.equals("logout")) {
			HttpSession session = request.getSession();
			if(session.getAttribute(EMusicLiterals.USER_DETAILS) != null){
				session.removeAttribute(EMusicLiterals.USER_DETAILS);
				session.removeAttribute(EMusicLiterals.MODULE);
			}
			Message m = new Message();
			m.setMessageType(Message.SUCCESS);
			m.setHeader("Logout Succuessful.");
			m.setDescription("You are successfully exit from the system. <br/>" +
					"You can <a href=\"user.do?action=view\">Login Now</a>");
			Map<String, Message> map = new HashMap<String, Message>();
			map.put(EMusicLiterals.MESSAGE, m);
			return new View("message",map);
		}
		else {
			return new View("login");
		}
	}//execute
}
