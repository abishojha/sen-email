package com.amc.controllers;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.amc.beans.AmcBeforeThirty;
import com.amc.beans.AmcDetail;
import com.amc.beans.Response;
import com.amc.beans.Users;
import com.amc.beans.Vendor;
import com.amc.dao.FetchDataDAO;
import com.amc.dao.InsertDAO;
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
	
	@RequestMapping(value = "/insertAmcDetails", method = RequestMethod.POST)
	public @ResponseBody String addAmcStartEnd(HttpServletRequest request,
			HttpServletResponse response) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username=authentication.getName();		
		 
	    System.out.println("Login: "+username);
		
	    InsertDAO insertdao=new InsertDAO();
		
		Response r=new Response();
		
	
	    String vendorId=request.getParameter("vendorName");
	    String vendorPurpose=request.getParameter("vendorPurpose");
	    String amcStartDate=request.getParameter("amcStartDate");
	    String amcEndDate=request.getParameter("amcEndDate");
	    
	    
	    System.out.println("Vendor Name"+vendorId+" Vendor Purpose"+vendorPurpose);
	    System.out.println("Start Date"+amcStartDate+" End Date"+amcEndDate);

	    
	    if(vendorId==""||vendorPurpose==""||amcStartDate==""||amcEndDate==""){
	    	r.setRescode("200");
			r.setResmsg("Insert the valid data.");    	
	    }
	    
	    else if(insertdao.insertAmcDetails(vendorId,vendorPurpose,amcStartDate,amcEndDate)==true){
	    	r.setRescode("100");
			r.setResmsg(" AMC detail has been added.");
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
	
	
	@RequestMapping(value = "/updateAmcDetails", method = RequestMethod.POST)
	public @ResponseBody String updateAmcDetails(HttpServletRequest request,
			HttpServletResponse response) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username=authentication.getName();		
		 
	    System.out.println("Login: "+username);
		
	    InsertDAO insertdao=new InsertDAO();
		
		Response r=new Response();
		
	
	    String amcId=request.getParameter("updAmcId");
	    String amcPurpose=request.getParameter("amcPurposeUpdId");
	    String amcStartDate=request.getParameter("updamcStartDate");
	    String amcEndDate=request.getParameter("updamcEndDate");
	    
	    
	    System.out.println("UPDATE DETAILS AMC ID"+amcId+" AMC Purpose"+amcPurpose);
	    System.out.println("Start Date"+amcStartDate+" End Date"+amcEndDate);

	    
	    if(amcId==""||amcPurpose==""||amcStartDate==""||amcEndDate==""){
	    	r.setRescode("200");
			r.setResmsg("Insert the valid data.");    	
	    }
	   
	    else if(insertdao.updateAmcDetail(amcId,amcPurpose,amcStartDate,amcEndDate)==true){
	    	r.setRescode("100");
			r.setResmsg(" AMC detail has been updated.");
	    }
	    else{
	    	r.setRescode("200");
			r.setResmsg("Could not update the record.");		    	
	    }   
	    Gson g=new Gson();
		String result=g.toJson(r);
		System.out.println(result);
		return result;
	}
	
	
	
	@RequestMapping(value = "/addAmcDetailpage", method = RequestMethod.GET)	
	public ModelAndView getUserAccess(HttpServletRequest request,HttpServletResponse response) {
		
	ModelAndView mv=new ModelAndView();	
	Response r=new Response();	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username=authentication.getName();		
	   
    FetchDataDAO  ftd=new FetchDataDAO();
	    List<AmcDetail> listAmcDetail=ftd.fetchAmcDetails();
	    
	    System.out.println("List of AMCs"+listAmcDetail);
	    List<Vendor> listVendors= ftd.fetchVendor();
	    
	    System.out.println("List of vendors "+listVendors);
	    
    	mv.addObject("listAmcDetail", listAmcDetail);	
    	mv.addObject("vendorInAmc", listVendors);			
    	mv.setViewName("addAmcDates");			
		
    	return mv;		    
	}
	
	@RequestMapping(value = "/getVendorDetail", method = RequestMethod.GET)	
	public ModelAndView getVendor(HttpServletRequest request,HttpServletResponse response) {
		
	ModelAndView mv=new ModelAndView();	
	Response r=new Response();	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username=authentication.getName();		
	    FetchDataDAO  ftd=new FetchDataDAO();	
	    
	    List<Vendor> listVendors= ftd.fetchVendor();
	    
		System.out.println("INSIDE VENDOR DETAIL PAGE OF VENDORS... "+ listVendors);

	
		System.out.println("LIST OF VENDORS... "+ listVendors);

		mv.addObject("ROLE", "admin");
		mv.addObject("vendors", listVendors);
		mv.setViewName("adminbkkp");
	    
		return mv;		    
	}
	
	@RequestMapping(value = "/addBeforeMonth", method = RequestMethod.GET)	
	public ModelAndView getAmcBeforeMonth(HttpServletRequest request,HttpServletResponse response) {
		
	ModelAndView mv=new ModelAndView();	
	Response r=new Response();	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username=authentication.getName();	
    
  //  new SadminController().doLogin();
	  
    FetchDataDAO  ftd=new FetchDataDAO();	
	    
	   List<Vendor> listVendors= ftd.fetchVendor();

	   String timeStamp = new SimpleDateFormat("yyyy:MM:dd").format(Calendar.getInstance().getTime());

		System.out.println("Check Timestamp"+timeStamp);
		
		Date date=new Date();
		Timestamp timestamp = new Timestamp(date.getTime());//instead of date put your converted date
		Timestamp myTimeStamp= timestamp;
		System.out.println("Time check"+myTimeStamp);
		 
		List<AmcBeforeThirty> listAmcDetail=ftd.fetchAmcDetailBeforeThirty(myTimeStamp);
	
		System.out.println("AMC BEDORE LIST OF VENDORS... "+ listVendors);

		mv.addObject("ROLE", "admin");
		mv.addObject("listAmcDetail", listAmcDetail);
		mv.addObject("vendorsIn", listVendors);
		mv.setViewName("amcBeforeMonth");
	    
		return mv;		    
	}
	
	
	private void doLogin() {
        // Sender's email ID needs to be mentioned
                            String from = "Abish.Ojha@gibl.com.np";

                            // Assuming you are sending email from localhost
                            String host = "mail.gibl.com.np";

                            // Get system properties object
                            Properties properties = System.getProperties();

                            // Setup mail server
                            properties.setProperty("mail.user", "Abish.Ojha");
                            properties.setProperty("mail.password", "jan@2019");
                            properties.setProperty("mail.smtp.host", host);
                            properties.setProperty("mail.smtp.port", "587");
                          

                            // Get the default Session object.
                            Session mailSession = Session.getInstance(properties);
                            
                            try
                            {
                                   // Create a default MimeMessage object.
                                   MimeMessage message = new MimeMessage(mailSession);
                                   // Set From: header field of the header.
                                   message.setFrom(new InternetAddress(from));
                                   // Set To: header field of the header.
                                   
                                   message.addRecipient(Message.RecipientType.TO,new InternetAddress("abish.ojha@gibl.com.np"));
                                   // Set Subject: header field
                                   message.setSubject("TEST SUBJECT");
                                   // Create the message part
                                   //BodyPart messageBodyPart = new MimeBodyPart();

                                   // Fill the message
                                   
                                   message.setText("DEMO TEXT");

                                   //messageBodyPart.setContent(htmlText, "text/html");
                                   //message.setContent(multipart);
                                   Transport.send(message);
                                   System.out.println("MAIL SEND");
                            }
                            catch (Exception e) {
                                   // TODO: handle exception
                                   e.printStackTrace();
                            }

 }


	
}
