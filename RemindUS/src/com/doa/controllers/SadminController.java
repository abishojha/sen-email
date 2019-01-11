package com.doa.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doa.beans.Response;
import com.doa.dao.InsertDAO;
import com.google.gson.Gson;



@Controller
public class SadminController {
	
	 
	@RequestMapping(value = "/insertVendorNames", method = RequestMethod.POST)
	public @ResponseBody String insertUserAccess(HttpServletRequest request,
			HttpServletResponse response) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username=authentication.getName();		
		 
	    System.out.println("Login: "+username);
		
	    InsertDAO insertdao=new InsertDAO();
		
		Response r=new Response();
	
	    String vendorName=request.getParameter("vendorName");
	    String vendorPurpose=request.getParameter("vendorPurpose");
	    
	    System.out.println("Vendor Name"+vendorName+" Vendor Purpose"+vendorPurpose);
	    
	    if(vendorName==""||vendorPurpose==""){
	    	r.setRescode("200");
			r.setResmsg("Insert the valid data.");    	
	    }	    
	    else if(insertdao.insertVendorDAO(vendorName,vendorPurpose)==true){
	    	r.setRescode("100");
			r.setResmsg(" Vendor has been added.");
	    }
	    else{
	    	r.setRescode("200");
			r.setResmsg("Could not add the record.");		    	
	    }	    
	    Gson g=new Gson();
		String result=g.toJson(r);
		System.out.println(result);
		return result;
	}
	
	/*@RequestMapping(value = "/getVendorList", method = RequestMethod.GET)	
	public ModelAndView getUserAccess(HttpServletRequest request,HttpServletResponse response) {
		
	ModelAndView mv=new ModelAndView();	
	Response r=new Response();	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username=authentication.getName();		
	    FetchDataDAO  ftd=new FetchDataDAO();	
	    
		List<Vendor> listVendors= ftd.fetchVendor();
		
	    			    	
			mv.addObject("lb", listVendors);
	    	mv.setViewName("sadmin");			
			return mv;		    
	}
	*/
	
	
	
	
	
}
