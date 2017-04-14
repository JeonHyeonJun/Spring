package model;

import java.util.Date;

public class Board {
	private int num;
	private String name;
	private String pass;
	private String content;
	private String email;
	private int readcount;
	private Date writedate;
	private String title;
	private String fileuri;
	private int fileid;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFileuri() {
		return fileuri;
	}
	public void setFileuri(String fileuri) {
		this.fileuri = fileuri;
	}
	public int getFileid() {
		return fileid;
	}
	public void setFileid(int fileid) {
		this.fileid = fileid;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", name=" + name + ", pass=" + pass + ", content=" + content + ", email=" + email
				+ ", readcount=" + readcount + ", writedate=" + writedate + ", title=" + title + ", fileuri=" + fileuri
				+ ", fileid=" + fileid + "]";
	}
	
	
}
