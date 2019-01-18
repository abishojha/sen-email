package com.amc.controllers;


import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.amc.beans.Access;
import com.amc.beans.Response;
import com.amc.beans.Users;
import com.amc.beans.Vendor;
import com.amc.dao.FetchDataDAO;
import com.amc.dao.InsertDAO;
import com.amc.dao.LoginDAO;
import com.google.gson.Gson;


@Controller
public class LoginController {

	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView conIndex(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		System.out.println("I am inside / in LoginController");
		
		System.out.println("Logout done ");


		mv.setViewName("login");
		return mv;
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		System.out.println("Inside LOGIN CONTROLLER");
		
		if (request.isUserInRole("ADMIN")
				|| request.isUserInRole("ROLE_DEP")) {
			mv.setViewName("redirect:/route");
			return mv;
		}

		String err = request.getParameter("err");
		System.out.println("ErrorMessage...."+err);
		if (err != null && err.trim().equalsIgnoreCase("1")) {
			System.out.println("ErrorMessage....1...."+err);

			mv.addObject("err", 1);
			mv.addObject("errMsg", "Username/Password do not match.");
		} else if (err != null && err.trim().equalsIgnoreCase("2")) {
			System.out.println("ErrorMessage....2...."+err);

			mv.addObject("err", 1);
			mv.addObject("errMsg",
					"You need to login with appropriate credentials in order to view this page.");
		}
			
		return mv;
	}

	@RequestMapping(value = "/route", method = RequestMethod.GET)
	public ModelAndView getRoute(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
	    FetchDataDAO  ftd=new FetchDataDAO();
	    
		System.out.println("Inside ROUTE CONTROLLER.. It appears if the credentails provided are fine");
		
		List<Vendor> listvendors= ftd.fetchVendor();

		System.out.println("LIST OF VENDORS... "+ listvendors);
		
		
	    if (request.isUserInRole("ROLE_DEP")) {
	    	 
	    	mv.setViewName("user");
			mv.addObject("ROLE", "Super Admin");
			return mv;
		} 
		
	    else if (request.isUserInRole("ADMIN")) {
	    	
	    	System.out.println("I am inside Admin Role.");
	    
			mv.addObject("ROLE", "admin");
			mv.addObject("vendors", listvendors);
			mv.setViewName("adminbkkp");
		    
			return mv;

		} 
			
	    
	    /*else if (request.isUserInRole("USER")) {
			mv.addObject("ROLE", "user");
			mv.setViewName("user");
			return mv;

		}*/
	    else {
			mv.setViewName("redirect:login");
		}
		return mv;
	    
	}


	@RequestMapping(value = "/**", method = RequestMethod.GET)
	public String getOthers(HttpServletRequest request,
			HttpServletResponse response) {
		return "redirect:login";
	}
	

	@RequestMapping(value = "/addUsers", method = RequestMethod.GET)	
	public ModelAndView addUsers(HttpServletRequest request,HttpServletResponse response) {
		
	ModelAndView mv=new ModelAndView();	
	Response r=new Response();	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username=authentication.getName();	
    
    FetchDataDAO  ftd=new FetchDataDAO();	
    
	  List<Users> listusers= ftd.fetchUsers();
    
  //  new SadminController().doLogin();
	  
    
		mv.addObject("adduser", "Inside Add user section");
		mv.addObject("listusers", listusers);

		mv.setViewName("addusers");
	    
		return mv;		    
	}
	
	@RequestMapping(value = "/insertUserLogin", method = RequestMethod.POST)	
	public @ResponseBody String insertUserLogin(HttpServletRequest request,HttpServletResponse response) {
		
			LoginDAO logindao=new LoginDAO();
			
			Response r=new Response();	
		    
		    String deptName=request.getParameter("deptName");
		    String selRole=request.getParameter("selRole");
		    String userName=request.getParameter("userName");
		    String userPass=request.getParameter("userPass");	
		    String userPass1=request.getParameter("userPass1");
		    
		    System.out.println("ABCDEFGHIJ"+deptName+" "+selRole+" "+userName+" "+userPass+" "+userPass1);

		    if(userPass.equals(userPass1)==false) {
		    	r.setRescode("101");
				r.setResmsg("Could not add the record. Password didn't matched."); 
		    }
		    	    
		    else  if(deptName==""||selRole==""||userName==""||userPass==""||userPass1==""){
		    	r.setRescode("102");
				r.setResmsg("Please enter data in all the fields.");    	
		    }
		   
		    else if(logindao.insertUserDetail(deptName,selRole,userName,userPass)==true){
		    	r.setRescode("103");
				r.setResmsg("User Added.");
		    }
		    else{
		    	r.setRescode("104");
				r.setResmsg("Could not update the record.");		    	
		    }   
		    Gson g=new Gson();
			String result=g.toJson(r);
			System.out.println(result);
			return result;		    
	}
	
	
	@RequestMapping(value = "/updateUserLogin", method = RequestMethod.POST)	
	public @ResponseBody String updateUserLogin(HttpServletRequest request,HttpServletResponse response) {
		
			LoginDAO insdao=new LoginDAO();
			
			Response res=new Response();	
					    
		    String id=request.getParameter("updid");
		    String deptName=request.getParameter("upddeptName");
		    String selRole=request.getParameter("updselRole");
		    String userName=request.getParameter("upduserName");
		    String userPass=request.getParameter("upduserPass");	
		    String userPass1=request.getParameter("upduserPass1");
		    
		    System.out.println("Inside user update "+id+" "+deptName+" "+selRole+" "+userName+" "+userPass+" "+userPass1);
		    

		    if(userPass.equals(userPass1)==false) {
		    	res.setRescode("101");
				res.setResmsg("Could not update the record. Password didn't matched."); 
		    }
		    	    
		    else  if(deptName==""||selRole==""||userName==""||userPass==""||userPass1==""){
		    	res.setRescode("102");
				res.setResmsg("Please enter data in all the fields.");    	
		    }
		   
		    else if(insdao.updateUserDetail(Integer.parseInt(id),deptName,selRole,userName,userPass)==true){
		    	res.setRescode("103");
				res.setResmsg("User updated.");
		    }
		    
		    else{
		    	res.setRescode("104");
				res.setResmsg("Could not update the record.");		    	
		    }   
		    Gson g=new Gson();
			String result=g.toJson(res);
			System.out.println(result);
			return result;		    
	}
	
	@RequestMapping(value = "/deleteUserLogin", method = RequestMethod.POST)	
	public @ResponseBody String deleteUserLogin(HttpServletRequest request,HttpServletResponse response) {
		
			LoginDAO logindao=new LoginDAO();
			Response res=new Response();	
		    String uName=request.getParameter("userName");
		    
		    System.out.println("Inside user update "+uName=="ADMIN");
		    	    	    
		    if(uName==""){
		    	res.setRescode("500");
				res.setResmsg("Whoops! Something went wrong.");    	
		    }
		   
		    else if(uName.equalsIgnoreCase("ADMIN")==false){
		    	logindao.deleteUserDetail(uName);
		    	res.setRescode("501");
				res.setResmsg("User deleted.");
		    }
		    
		    else{
		    	res.setRescode("502");
				res.setResmsg("Could not delete the user.");		    	
		    }   
		    Gson g=new Gson();
			String result=g.toJson(res);
			System.out.println("User delete result"+result);
			return result;		    
	}
	
	
	
}
