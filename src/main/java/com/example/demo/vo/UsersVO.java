package com.example.demo.vo;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity

@Table(name="users")
public class UsersVO {
	@Id
	private int userno;
	private String id;
	private String pwd;
	private String u_name;
	private LocalDate date_birth;
	private String gender;
	private String email;
	private String nickname;
	private LocalDate date_reg;
	private String residence;
	private String phone;
	private int point;
	private String u_status;
	private String role;
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
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
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public LocalDate getDate_birth() {
		return date_birth;
	}
	public void setDate_birth(LocalDate date_birth) {
		this.date_birth = date_birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public LocalDate getDate_reg() {
		return date_reg;
	}
	public void setDate_reg(LocalDate date_reg) {
		this.date_reg = date_reg;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getU_status() {
		return u_status;
	}
	public void setU_status(String u_status) {
		this.u_status = u_status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
