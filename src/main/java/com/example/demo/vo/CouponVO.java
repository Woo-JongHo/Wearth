package com.example.demo.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Coupon")
public class CouponVO {

	@Id
	private int couponNo;
	private int userNo;
	private int couponCnt;
	private int couponDisCount;
	private String couponName;
	private String couponInfo;
	private Date couponDate;
	private int couponPeriod;
}
