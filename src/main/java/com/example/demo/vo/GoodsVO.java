package com.example.demo.vo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity

@Table(name = "goods")
public class GoodsVO {
	
	public int getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Date getGoodsUpdate() {
		return goodsUpdate;
	}
	public void setGoodsUpdate(Date goodsUpdate) {
		this.goodsUpdate = goodsUpdate;
	}
	public String getGoodsCompany() {
		return goodsCompany;
	}
	public void setGoodsCompany(String goodsCompany) {
		this.goodsCompany = goodsCompany;
	}
	public int getShipPrice() {
		return shipPrice;
	}
	public void setShipPrice(int shipPrice) {
		this.shipPrice = shipPrice;
	}
	public int getGoodsStock() {
		return goodsStock;
	}
	public void setGoodsStock(int goodsStock) {
		this.goodsStock = goodsStock;
	}
	public int getGoodsDC() {
		return goodsDC;
	}
	public void setGoodsDC(int goodsDC) {
		this.goodsDC = goodsDC;
	}
	public int getAddPoint() {
		return addPoint;
	}
	public void setAddPoint(int addPoint) {
		this.addPoint = addPoint;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getMainFname() {
		return mainFname;
	}
	public void setMainFname(String mainFname) {
		this.mainFname = mainFname;
	}
	public String getAddFname() {
		return addFname;
	}
	public void setAddFname(String addFname) {
		this.addFname = addFname;
	}
	public String getInfoFname() {
		return infoFname;
	}
	public void setInfoFname(String infoFname) {
		this.infoFname = infoFname;
	}
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
