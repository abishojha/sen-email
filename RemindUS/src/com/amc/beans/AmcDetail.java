package com.amc.beans;

import java.sql.Date;
import java.sql.Timestamp;

public class AmcDetail {
	
	private String vendorNm;
	private String amcPurpose;
	private Date amcStartDate;
	private Date amcEndDate;
	private String amcStatus;
	private Integer daysLeft;
	private String emailStatus;
	public String getVendorNm() {
		return vendorNm;
	}
	public void setVendorNm(String vendorNm) {
		this.vendorNm = vendorNm;
	}
	public String getAmcPurpose() {
		return amcPurpose;
	}
	public void setAmcPurpose(String amcPurpose) {
		this.amcPurpose = amcPurpose;
	}
	public Date getAmcStartDate() {
		return amcStartDate;
	}
	public void setAmcStartDate(Date amcStartDate) {
		this.amcStartDate = amcStartDate;
	}
	public Date getAmcEndDate() {
		return amcEndDate;
	}
	public void setAmcEndDate(Date amcEndDate) {
		this.amcEndDate = amcEndDate;
	}
	public String getAmcStatus() {
		return amcStatus;
	}
	public void setAmcStatus(String amcStatus) {
		this.amcStatus = amcStatus;
	}
	public Integer getDaysLeft() {
		return daysLeft;
	}
	public void setDaysLeft(Integer daysLeft) {
		this.daysLeft = daysLeft;
	}
	public String getEmailStatus() {
		return emailStatus;
	}
	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}
	@Override
	public String toString() {
		return "AmcDetail [vendorNm=" + vendorNm + ", amcPurpose=" + amcPurpose + ", amcStartDate=" + amcStartDate
				+ ", amcEndDate=" + amcEndDate + ", amcStatus=" + amcStatus + ", daysLeft=" + daysLeft
				+ ", emailStatus=" + emailStatus + "]";
	}
	
	
	
}
