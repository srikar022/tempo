package com.pack.SpringBootRoleBasedSecurity.model;

public class changePassword {
private String uname;
private String opwd;
private String npwd;
private String pwd;
public changePassword() {
	super();
	// TODO Auto-generated constructor stub
}


public changePassword(String uname, String opwd, String npwd, String pwd) {
	super();
	this.uname = uname;
	this.opwd = opwd;
	this.npwd = npwd;
	this.pwd = pwd;
}


public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getOpwd() {
	return opwd;
}
public void setOpwd(String opwd) {
	this.opwd = opwd;
}
public String getNpwd() {
	return npwd;
}
public void setNpwd(String npwd) {
	this.npwd = npwd;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}


@Override
public String toString() {
	return "changePassword [uname=" + uname + ", opwd=" + opwd + ", npwd=" + npwd + ", pwd=" + pwd + "]";
}


}
