package com.wjf.bean;

import java.util.Date;

public class User {
   private int id;
   private String u_name;
   private String u_psswrd;
   private String u_img;
   private Date u_birth;
   private String u_sex;
   private Date u_regist_time;
   private Date u_lastlogin_time;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getU_name() {
	return u_name;
}
public void setU_name(String u_name) {
	this.u_name = u_name;
}
public String getU_psswrd() {
	return u_psswrd;
}
public void setU_psswrd(String u_psswrd) {
	this.u_psswrd = u_psswrd;
}
public String getU_img() {
	return u_img;
}
public void setU_img(String u_img) {
	this.u_img = u_img;
}
public Date getU_birth() {
	return u_birth;
}
public void setU_birth(Date u_birth) {
	this.u_birth = u_birth;
}
public String getU_sex() {
	return u_sex;
}
public void setU_sex(String u_sex) {
	this.u_sex = u_sex;
}
public Date getU_regist_time() {
	return u_regist_time;
}
public void setU_regist_time(Date u_regist_time) {
	this.u_regist_time = u_regist_time;
}
public Date getU_lastlogin_time() {
	return u_lastlogin_time;
}
public void setU_lastlogin_time(Date u_lastlogin_time) {
	this.u_lastlogin_time = u_lastlogin_time;
}
   

}
