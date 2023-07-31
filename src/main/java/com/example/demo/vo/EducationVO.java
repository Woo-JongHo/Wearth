package com.example.demo.vo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "education")
public class EducationVO {
	
	@Id
	private int eduNO;
	private String eduName;
	private String eduContent;
	private String eduStatus;
	private String eduApp;
	private String eduAddr;
	private String educator;
	private String eduPhone;
	private String eduFile;
	private String eduSysdate;
}
