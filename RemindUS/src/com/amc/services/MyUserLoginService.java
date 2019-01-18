package com.amc.services;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.amc.beans.MemberLogin;
import com.amc.dao.LoginDAO;


public class MyUserLoginService implements UserDetailsService {
	protected static Logger logger=Logger.getLogger("MyUserLoginService");
	private LoginDAO myDao=LoginDAO.getInstance();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user=null;		
		try {
			
			System.out.println("I am in Service class top");
			
			MemberLogin memberLoginBean=(MemberLogin)myDao.searchDatabase(username);		
			logger.log(Level.WARNING,"SuppliedUsername="+username+", Bean username="+memberLoginBean.getUsername()+", password="+memberLoginBean.getPassword());
			
			ArrayList<String> l=new ArrayList<String>();
			l.add(memberLoginBean.getRole());
			l.add(memberLoginBean.getUsrGrp());
			
			user=new User(memberLoginBean.getUsername(),memberLoginBean.getPassword(),true,true,true,true,getAdminAuthorities(l));
			
			System.out.println("I am in Service"+"....."+"Username"+memberLoginBean.getUsername()+"...Password ..."+memberLoginBean.getPassword());
			
		} catch (Exception ex) {
			logger.log(Level.WARNING, "ERROR IN LoadByUsername in MyUserLoginService..."+ex.toString());
			//throw ex;
		}		
		return user;
	}
	
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();			
		
		return authorities;
	}
	
	@SuppressWarnings("deprecation")
	public Collection<GrantedAuthority> getAdminAuthorities(ArrayList<String> l) {
		List<GrantedAuthority> adminAuthority=new ArrayList<GrantedAuthority>();
		for(String s:l)
			adminAuthority.add(new GrantedAuthorityImpl(s));
		return adminAuthority;
	}
}
