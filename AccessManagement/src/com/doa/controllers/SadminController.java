package com.doa.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.doa.beans.Access;
import com.doa.beans.Branch;
import com.doa.beans.Response;
import com.doa.beans.UserAccess;
import com.doa.dao.AdminManageDAO;
import com.doa.dao.FetchDataDAO;
import com.doa.dao.InsertDAO;
import com.google.gson.Gson;



@Controller
public class SadminController {

	@RequestMapping(value = "/insertCategory", method = RequestMethod.POST)
	public @ResponseBody String coninsertthree(HttpServletRequest request,
			HttpServletResponse response) {
		
		Response r=new Response();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username=authentication.getName();
	    
	    String category=request.getParameter("cat");
			
	    System.out.println("username is .."+username+"category..."+category);
	    AdminManageDAO  admin=AdminManageDAO.getInstance();
	    if(admin.insertCategory(category,username)==true){
	    	r.setRescode("100");
			r.setResmsg(" Category has been added.");
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
	
	

	@RequestMapping(value = "/insertUserAccess", method = RequestMethod.POST)
	public @ResponseBody String insertUserAccess(HttpServletRequest request,
			HttpServletResponse response) {
		
	    InsertDAO insertdao=new InsertDAO();
		
		Response r=new Response();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username=authentication.getName();	    
	    	    
	    String selBranch=request.getParameter("selBranch");
	    String userAccName=request.getParameter("userAccName");
	    String cbsId=request.getParameter("cbsId");
	    String seltitle=request.getParameter("seltitle");
	    String grpAcc=request.getParameter("grpAcc");
	    String userRemarks=request.getParameter("userRemarks");
	    
	    if(selBranch==""||userAccName==""||seltitle==""||grpAcc==""){
	    	r.setRescode("200");
			r.setResmsg("Insert the valid data.");    	
	    }	    
	    else if(insertdao.insertAccessDAO(selBranch,userAccName,cbsId,seltitle,grpAcc,userRemarks)==true){
	    	r.setRescode("100");
			r.setResmsg(" User access has been added.");
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
	
	@RequestMapping(value = "/getBranchandAccess", method = RequestMethod.GET)	
	public ModelAndView getUserAccess(HttpServletRequest request,HttpServletResponse response) {
		
	ModelAndView mv=new ModelAndView();	
	Response r=new Response();	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username=authentication.getName();		
	    FetchDataDAO  ftd=new FetchDataDAO();	    
		List<Branch> listbranches= ftd.fetchBranch();
		List<Access> listaccess=ftd.fetchAccess();
		
	    if(listbranches.get(1).getBranch()!=null&&listaccess.get(1).getId()!=""){	    	
	    	r.setRescode("101");	    		
	    }
	    else{
	    	r.setRescode("201");	    	
	    }			    	
			mv.addObject("lb", listbranches);
			mv.addObject("la", listaccess);	
			mv.addObject("rescode", r);	
			mv.addObject("ROLE","GET USER ACCESS METHOD");	    	 
	    	mv.setViewName("sadmin");			
			return mv;		    
	}
	
	
	@RequestMapping(value = "/updateUserAccess", method = RequestMethod.POST)
	public @ResponseBody String updateUserAccess(HttpServletRequest request,
			HttpServletResponse response) {
		
	    InsertDAO insertdao=new InsertDAO();
		
		Response r=new Response();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username=authentication.getName();	    
	    	    
	    String selBranch=request.getParameter("updBranch");
	    String userAccName=request.getParameter("updAccName");
	    String cbsId=request.getParameter("updcbsId");
	    String seltitle=request.getParameter("updTitle");
	    String grpAcc=request.getParameter("updgrpAcc");
	    String userRemarks=request.getParameter("updRemarks");
	    
	    System.out.println(selBranch+"......"+userAccName+"......"+cbsId+".......");
	    System.out.println(seltitle+"......"+grpAcc+"......"+userRemarks+".......");

	    
	    if(selBranch==""||userAccName==""||seltitle==""||grpAcc==""||cbsId==""){
	    	r.setRescode("200");
			r.setResmsg("Insert the valid data.");
	    	
	    }
	    
	    else if(insertdao.updateAccessDAO(selBranch,userAccName,cbsId,seltitle,grpAcc,userRemarks)==true){
	    	r.setRescode("100");
			r.setResmsg(" User updated.");
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
	
	
	@RequestMapping(value = "	/userDetail", method = RequestMethod.GET)	
	public ModelAndView getUserDetail(HttpServletRequest request,HttpServletResponse response) {
		
	       ModelAndView mv=new ModelAndView();		
	       FetchDataDAO  ftd=new FetchDataDAO();
	       
			List<UserAccess> listUserAcc= ftd.fetchUserAccess();
			mv.addObject("listUserAcc", listUserAcc);	     	
			mv.addObject("ROLE","GET USER ACCESS METHOD");	    	 
	    	mv.setViewName("sadmin");			
			return mv;		    
	}
	
	
}
