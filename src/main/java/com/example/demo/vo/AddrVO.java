package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "addr")
public class AddrVO {

	@Id
	private int addrNo;
	private int userNo;
	private String addrName;
	private String receiver;
	private String phone;
	private String addr;
	private String post;
	private Boolean isDefault;
}
