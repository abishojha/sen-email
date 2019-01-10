package com.doa.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Date;


public class MemberLogin implements Serializable {
  
    private int id;
    private String username;
    private String password;
    private Date update_time_stamp;
    private Date insert_time_stamp;
    private char activeStat;
    private String role;
    private String UsrGrp;
    
   
	public String getUsrGrp() {
		return UsrGrp;
	}

	public void setUsrGrp(String usrGrp) {
		UsrGrp = usrGrp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private boolean success=false;

    public MemberLogin() {
    	id=-1;
    	username="";
    	password="";
    	update_time_stamp=null;
    	insert_time_stamp=null;
    	activeStat='N';
    }
    
    public MemberLogin(int id,String username,String password,Date update_time_stamp,char activeStatDate,Date insert_time_stamp) {
    	this.id=id;
    	this.username=username;
    	this.password=password;
    	this.update_time_stamp=update_time_stamp;
    	this.insert_time_stamp=insert_time_stamp;
    	this.activeStat=activeStat;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUpdate_time_stamp() {
        return update_time_stamp;
    }

    public void setUpdate_time_stamp(Date update_time_stamp) {
        this.update_time_stamp = update_time_stamp;
    }

    public Date getInsert_time_stamp() {
        return insert_time_stamp;
    }

    public void setInsert_time_stamp(Date insert_time_stamp) {
        this.insert_time_stamp = insert_time_stamp;
    }    

    public char getActiveStat() {
        return activeStat;
    }

    public void setActiveStat(char activeStat) {
        this.activeStat = activeStat;
    }

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}	
}
