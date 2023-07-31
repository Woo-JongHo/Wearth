package com.example.demo.vo;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cart")
public class CartVO {

	@Id
	private int cartNo;
	private int userNo;
	private int goodsNo;
	private String goodsName;
	private int goodsPrice;
	private int cartCnt;
	private Date cartDate;
}
