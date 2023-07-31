package com.example.demo.vo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "goods")
public class GoodsVO {
	
	@Id
	private int goodsNo;
	private int categoryNo;
	private String goodsName;
	private int goodsPrice;
	private Date goodsUpdate;
	private String goodsCompany;
	private int shipPrice;
	private int goodsStock;
	private int goodsDC;
	private int addPoint;
	private String origin;
	private String mainFname;
	private String addFname;
	private String infoFname;
}
