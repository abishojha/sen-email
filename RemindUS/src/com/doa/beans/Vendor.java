package com.doa.beans;

public class Vendor {
	
	private int id;
	private String vendor;
	private String vendorPurpose;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getVendorPurpose() {
		return vendorPurpose;
	}
	public void setVendorPurpose(String vendorPurpose) {
		this.vendorPurpose = vendorPurpose;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Branch [id=" + id + ", vendor=" + vendor + ", vendorPurpose=" + vendorPurpose + ", status=" + status
				+ "]";
	}
	
	
	
	
	
}
