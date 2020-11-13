package com.myhu.cheela.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Entity class for predictions table
 * 
 * @author kafka
 *
 */
@Entity
@Table
public class Predictions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String cc_num;
	@Id
	@Column
	private String trans_num;
	@Column
	private String trans_time;
	@Column
	private String category;
	@Column
	private String merchant;
	@Column
	private Double merch_lat;
	@Column
	private Double merch_long;
	@Column
	private Double amt;
	
	@Column
	private String age;
	@Column
	private String is_fraud;
	

	public String getCc_num() {
		return cc_num;
	}

	public void setCc_num(String cc_num) {
		this.cc_num = cc_num;
	}

	public String getTrans_time() {
		return trans_time;
	}

	public void setTrans_time(String trans_time) {
		this.trans_time = trans_time;
	}


	public String getTrans_num() {
		return trans_num;
	}

	public void setTrans_num(String trans_num) {
		this.trans_num = trans_num;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public Double getAmt() {
		return amt;
	}

	public void setAmt(Double amt) {
		this.amt = amt;
	}

	public Double getMerch_lat() {
		return merch_lat;
	}

	public void setMerch_lat(Double merch_lat) {
		this.merch_lat = merch_lat;
	}

	public Double getMerch_long() {
		return merch_long;
	}

	public void setMerch_long(Double merch_long) {
		this.merch_long = merch_long;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String getIs_fraud() {
		return is_fraud;
	}

	public void setIs_fraud(String is_fraud) {
		this.is_fraud = is_fraud;
	}


}
