package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int qualityOfProduct;
	private int responseSpeed;
	private int satisfactionOfProduct;
	private int overallExperience;
	private int likelyToRecommend;
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQualityOfProduct() {
		return qualityOfProduct;
	}

	public void setQualityOfProduct(int qualityOfProduct) {
		this.qualityOfProduct = qualityOfProduct;
	}

	public int getResponseSpeed() {
		return responseSpeed;
	}

	public void setResponseSpeed(int responseSpeed) {
		this.responseSpeed = responseSpeed;
	}

	public int getSatisfactionOfProduct() {
		return satisfactionOfProduct;
	}

	public void setSatisfactionOfProduct(int satisfactionOfProduct) {
		this.satisfactionOfProduct = satisfactionOfProduct;
	}

	public int getOverallExperience() {
		return overallExperience;
	}

	public void setOverallExperience(int overallExperience) {
		this.overallExperience = overallExperience;
	}

	public int getLikelyToRecommend() {
		return likelyToRecommend;
	}

	public void setLikelyToRecommend(int likelyToRecommend) {
		this.likelyToRecommend = likelyToRecommend;
	}
	
}
