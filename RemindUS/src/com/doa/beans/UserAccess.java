package com.doa.beans;

public class UserAccess {
	private int id;
	private int branchCode;
	private String branchName;
	private String userName;
	private String jobTitle;
	private String cbsId;
	private String cbsAccess;
	private String remarks;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getCbsId() {
		return cbsId;
	}
	public void setCbsId(String cbsId) {
		this.cbsId = cbsId;
	}
	public String getCbsAccess() {
		return cbsAccess;
	}
	public void setCbsAccess(String cbsAccess) {
		this.cbsAccess = cbsAccess;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserAccess [id=" + id + ", branchCode=" + branchCode
				+ ", branchName=" + branchName + ", userName=" + userName
				+ ", jobTitle=" + jobTitle + ", cbsId=" + cbsId
				+ ", cbsAccess=" + cbsAccess + ", remarks=" + remarks
				+ ", status=" + status + "]";
	}
	
	

}
