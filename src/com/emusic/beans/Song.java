/* Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Online Election Voting System
 * This project is licensed under the MIT License, see LICENSE.
 */
package com.emusic.beans;
 
public class Song {
	
	private int id, downloadCount; 
	private String lyric, singer, length, fileName;
	private Album album;
	
	public Song(){}

	public Song(int id, int downloadCount, String lyric, String fileName, String singer,
			String length, Album album) {
		super();
		this.id = id;
		this.setFileName(fileName);
		this.downloadCount = downloadCount;
		this.lyric = lyric;
		this.singer = singer;
		this.length = length;
		this.album = album;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

}
