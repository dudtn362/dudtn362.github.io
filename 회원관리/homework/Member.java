package org.vision.popol.homework;

public class Member {
	private long serialno;
	private String name;
	private String id;
	private String pwd;
	private String gender;
	private String tel;
	private String email;
	public long getSerialno() {
		return serialno;
	}
	public void setSerialno(long serialno) {
		this.serialno = serialno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Member [serialno=" + serialno + ", name=" + name + ", id=" + id + ", pwd=" + pwd + ", gender=" + gender
				+ ", tel=" + tel + ", email=" + email + "]";
	}
	
	
}
