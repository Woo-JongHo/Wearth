package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "g_category")
public class GoodsCategoryVO {

	@Id
	private int categoryNo;
	private String categoryName;
}
