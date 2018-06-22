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

public class AdminController extends BaseController {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String action = request.getParameter("action")!= null ? request.getParameter("action") : "view"; 
		
		if(action.equals("login")){
			String query = "SELECT id, name, email, type FROM tbl_users WHERE name = ? " +
					"AND pwd = PASSWORD(?) AND type = 'ADMIN'";
			
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
				session.setAttribute(EMusicLiterals.MODULE, EMusicLiterals.ADMIN_MODULE);
				return new View("success");
			}
			else {
				return new View("error");
			}
		} 
		else if(action.equals("main")){
			return new View("main");
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
					"You can <a href=\"admin.do?action=view\">Login Now</a>");
			Map<String, Message> map = new HashMap<String, Message>();
			map.put(EMusicLiterals.MESSAGE, m);
			return new View("message", map);
		}
		else if(action.equals("request")) 
		{
			List<Request> requests = getAllRequestById(0, true);
			Map<String, List<Request>> map = new HashMap<String, List<Request>>();
			map.put(EMusicLiterals.REQUEST_LIST, requests);
			return new View("request", map);
		}
		else if(action.equals("available")) {
			int reqId = Integer.parseInt(request.getParameter("reqId"));
			String query = "UPDATE tbl_song_request SET is_avbl = 'Y', avbl_date_time = NOW() " +
					"WHERE id = ?";
			
			Connection con = ConnectionUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, reqId);
			int update = ps.executeUpdate();
			if(con != null) con.close();
			if(update == 1){
				List<Request> requests = getAllRequestById(0, true);
				Map<String, List<Request>> map = new HashMap<String, List<Request>>();
				map.put(EMusicLiterals.REQUEST_LIST, requests);
				return new View("request", map);
			}
			return new View("error");
		}
		else {
			return new View("login");
		}
	}
}
