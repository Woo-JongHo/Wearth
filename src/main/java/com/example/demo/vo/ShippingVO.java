package com.example.demo.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "shipping")
public class ShippingVO {
	
	@Id
	private int shippingNo;
	private int ordersNo;
	private int userNo;
	private String shippingStatus;
	private Date startDate;
	private Date finishDate;
	private int trackingNo;
}
