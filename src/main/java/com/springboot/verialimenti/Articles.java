package com.springboot.verialimenti;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Articles {

	private @Id @GeneratedValue Long id;
	private String name;
	private float kprice;
	private float tprice;
	private int   amount;

	Articles() {}

	Articles(String name, float kprice, float tprice, int amount) {
		this.name = name;
		this.kprice = kprice;
		this.tprice = tprice;
		this.amount = amount;
	}
}
