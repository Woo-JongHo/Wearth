package com.example.demo.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class OrdersVO {

	@Id
	private int ordersNo;
	private int payNo;
	private int ordersPrice;
	private Date ordersDate;
	private String ordersStatus;
	private int addrNo;
	private String ordersContent;
	private int ordersCnt;
	private int goodsNo;
}
