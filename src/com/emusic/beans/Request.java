/* Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Online Election Voting System
 * This project is licensed under the MIT License, see LICENSE.
 */
package com.emusic.beans;
 
public class Request {
	private int id;
	private String lyrics, album, description, reqDateTime, isAvailable, availableDateTime;
	private User user;

	public Request() {super();}

	public Request(int id, User user, String lyrics, String album,
			String description, String reqDateTime, String isAvailable,
			String availableDateTime) {
		super();
		this.id = id;
		this.setUser(user);
		this.lyrics = lyrics;
		this.album = album;
		this.description = description;
		this.reqDateTime = reqDateTime;
		this.isAvailable = isAvailable;
		this.availableDateTime = availableDateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReqDateTime() {
		return reqDateTime;
	}

	public void setReqDateTime(String reqDateTime) {
		this.reqDateTime = reqDateTime;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getAvailableDateTime() {
		return availableDateTime;
	}

	public void setAvailableDateTime(String availableDateTime) {
		this.availableDateTime = availableDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
}
