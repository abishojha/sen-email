package com.doa.beans;

public class Branch {
	private int id;
	private String branch;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Branch [id=" + id + ", branch=" + branch + "]";
	}
	
	
	
}
