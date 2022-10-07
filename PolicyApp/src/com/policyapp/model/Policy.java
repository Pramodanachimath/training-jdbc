package com.policyapp.model;

public class Policy {
	private String policyName;
	private Integer policyNumber;
	private double premium;
	private int duration;
	private String coverage;
	private String category;
	private double sumAssured;
	private String type;

	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Policy(String policyName, Integer policyNumber, double premium, int duration, String coverage,
			String category, double sumAssured, String type) {
		super();
		this.policyName = policyName;
		this.policyNumber = policyNumber;
		this.premium = premium;
		this.duration = duration;
		this.coverage = coverage;
		this.category = category;
		this.sumAssured = sumAssured;
		this.type = type;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Integer getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(Integer policyNumber) {
		this.policyNumber = policyNumber;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(double sumAssured) {
		this.sumAssured = sumAssured;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Policy [policyName=" + policyName + ", policyNumber=" + policyNumber + ", premium=" + premium
				+ ", duration=" + duration + ", coverage=" + coverage + ", category=" + category + ", sumAssured="
				+ sumAssured + ", type=" + type + "]";
	}

}
