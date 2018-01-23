/* Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Online Election Voting System
 * This project is licensed under the MIT License, see LICENSE.
 */
package com.emusic.beans;

import java.util.List;

public class Album 
{

	private int id, price;
	private String name, artist, music, company;
	private List<Song> songs;
	
	public Album() {super();}
	public Album(int id, int price, String name, String artist, String music,
			String company, List<Song> songs) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.artist = artist;
		this.music = music;
		this.company = company;
		this.setSongs(songs);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	
}
