package com.doa.controllers;


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
import org.springframework.web.servlet.ModelAndView;

import com.doa.beans.Access;
import com.doa.beans.Vendor;
import com.doa.beans.UserAccess;
import com.doa.dao.FetchDataDAO;


@Controller
public class LoginController {

	
	@RequestMapping(value="/logout", method=RequestMethod.GET)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        System.out.println(auth.getName());
        Cookie[] cookies = request.getCookies();
        cookies[0].setMaxAge(0);
        response.addCookie(cookies[0]);
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/";  
     } 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView conIndex(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		System.out.println("I am inside / in LoginController");
		
		System.out.println("Out ");


		mv.setViewName("login");
		return mv;
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		System.out.println("Inside LOGIN CONTROLLER");
		
		

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
	    
		
		/*List<Access> listaccess=ftd.fetchAccess();
		List<UserAccess> listUserAcc= ftd.fetchUserAccess();
		
		System.out.println("^&*((((((((((((((((((()))))))))))))"+listUserAcc);

*/

		
		
		System.out.println("Inside ROUTE CONTROLLER.. It appears if the credentails provided are fine");
		
	    if (request.isUserInRole("SADMIN")) {
	    	
			/*mv.addObject("la", listaccess);	
			mv.addObject("listUserAcc", listUserAcc);		    	
*/
	    //	 System.out.println(listbranches);
	    //	 System.out.println(listaccess);    	 
	    	 
	    	mv.setViewName("sadmin");
			mv.addObject("ROLE", "Super Admin");
			return mv;
		} 
		
	    else if (request.isUserInRole("ADMIN")) {
	    
			List<Vendor> listvendors= ftd.fetchVendor();

			System.out.println("LIST OF VENDORS "+ listvendors);

			mv.addObject("ROLE", "admin");
			mv.addObject("vendors", listvendors);
			mv.setViewName("admin");
		    
			return mv;

		} 
/*		else if (request.isUserInRole("USER")) {
*/			
	    
	    else if (request.isUserInRole("USER")) {
			mv.addObject("ROLE", "user");
			mv.setViewName("user");
			return mv;

		}
	    mv.setViewName("login");
		return mv;
	    
	}


	@RequestMapping(value = "/**", method = RequestMethod.GET)
	public String getOthers(HttpServletRequest request,
			HttpServletResponse response) {
		return "login";
	}
	
	
}