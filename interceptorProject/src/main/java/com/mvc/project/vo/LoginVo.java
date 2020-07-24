package com.mvc.project.vo;

public class LoginVo {

	private String id;
	private String pw;
	private String date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "LoginVo [id=" + id + ", pw=" + pw + ", date=" + date + "]";
	}

}
