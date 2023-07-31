package com.example.demo.vo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "lecture")
public class LectureVO {
	
	@Id
	private int lecNO;
	private String lecName;
	private String lecContent;
	private String lecDate;
	private String lecAddr;
	private String lecturer;
	private String lecApp;
	private String lecPhone;
	private int lecPrice;
	private String lecFile;
	private Date lecSysdate;
}
