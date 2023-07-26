package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name="users")
public class UsersVO {
	@Id
	private int userno;
	private String id;
	private String pwd;
	private String u_name;
	private String date_birth;
	private String gender;
	private String email;
	private String nickname;
	private String date_reg;
	private String residence;
	private String phone;
	private int point;
	private String u_status;
}
