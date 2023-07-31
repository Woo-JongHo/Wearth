package com.example.demo.vo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "trainingRequest")
public class TrainingRequestVO {
	
	@Id
	private int reqNo;
	private String reqTitle;
	private String reqContent;
	private String reqApp;
	private String reqAddr;
	private String reqDate;
	private String reqCompany;
	private String reqPhone;
	private Date reqSysDate;
	private int userNo;
}
