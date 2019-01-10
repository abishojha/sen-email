package com.doa.beans;

public class Access {
	
	private String id;
	private String group;
	private String title;
	private String post;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "Access [id=" + id + ", group=" + group + ", title=" + title
				+ ", post=" + post + "]";
	}
	
	
	
}
