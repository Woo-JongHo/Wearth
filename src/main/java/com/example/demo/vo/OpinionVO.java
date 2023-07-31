package com.example.demo.vo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "opinion")
public class OpinionVO {
	
	@Id
	private int opinionNO;
	private int eduNo;
	private int goodsNo;
	private int userNo;
	private String ID;
	private String opinionName;
	private String opinionContent;
	private Date opinionDate;
	private boolean opinionSecret;
	private String opinionPwd;
	private String opinionStatus;
	private int opinionScore;
	private int answerNo;
}
