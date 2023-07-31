package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ordersDetail")
public class OrdersDetailVO {

	@Id
	private int ordersDetailNo;
	private int ordersNo;
	private int goodsNo;
	private int detailPrice;
	private int detailCnt;
}
