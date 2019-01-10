<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Access Management</title>

</head>

  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
   <script src="bootstrap/js/bootstrap.min.js"></script>
   
  
<body>
 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header"> 
      <a class="navbar-brand">ACCESS MANAGEMENT</a>
    </div>
    <ul class="nav navbar-nav">
      <li id="addUser" class="active"><a href="#">ADD USER ACCESS</a></li>
      <li id=editAccess class="active"><a href="#">MANAGE USER/ACCESS</a></li> 
      <li id="viewAccess" class="active"><a href="#">VIEW BRANCH ACCESS</a></li>
            <li id="viewAccess" class="active"><a href="#">SEARCH USER</a></li>
      
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="j_spring_security_logout">Log Out</a></li>
    </ul>
  </div>
</nav>
  
<H2>Welcome to : ${ROLE} </H2>

<!-- <div id="category">	
	 <div id="contact-tab" class="row well well-small" style="-moz-box-shadow: 0 0 5px #626262;
	        -webkit-box-shadow: 0 0 5px #626262;
	         box-shadow: 0 0 5px #626262;background:#F9F9F9;">
	         
	      <div class="col-sm-6">
		    <b>Category Name</b>
			<input class="form-control" type="text" id="ctname" >
			
			<br/>
			<br/>							
		 </div>
		 <div class="col-sm-2" align="left"><br/> <a id="addCategory" class="btn btn-primary">ADD</a> </div>
		 
		 	 
     </div>    
</div> -->



<!-- <div id="manage">	
	 <div id="contact-tab" class="row well well-small" style="-moz-box-shadow: 0 0 5px #626262;
	        -webkit-box-shadow: 0 0 5px #626262;
	         box-shadow: 0 0 5px #626262;background:#F9F9F9;">
	         
	      <div class="col-sm-4">
		    <b>User Name</b>
			<input class="form-control" type="text" id="ctname" >
			
			<br/>
			<br/>							
		 </div>
		 <div class="col-sm-2" align="right"><br/> <a id="submit" class="btn btn-primary">ADD</a> </div>		 	 
     </div>    
</div>

 -->


<div class="modal fade" tabindex="-1" role="dialog" aria-hidden="true" id="makerChk" >
 <div class="modal-dialog">
  <div class="modal-content"
   style='padding-bottom: 0px; margin-bottom: 0px;'>
   <div class="modal-body" style='padding: 0px;'>
    <div class="panel panel-primary" style="margin-bottom: 0px;">
     <button type="button" class="close" data-dismiss="modal"
      aria-hidden="true" title="Close" onclick="refreshModal()">
      <span style="font-size: 1.6em; padding-right: 10px;" >&times;</span>
     </button>
     <div class="panel-heading" style="">
      <h4>
       <label id="lblHeading">ADD CBS ACCESS TO USER</label>
      </h4>
     </div>
     <div class="panel-body">
      <div class="row">
       <div class="col-sm-6">
        <div id="divMsgs"></div>
       </div>
      </div>
      
      <div class="form-group">      
			
	  <label>BRANCH:</label>&nbsp;&nbsp;&nbsp; 
       <select class="form-control" id="selBranch" name="selBranch">      
	        <c:forEach var="brnch" items="${lb}">      
	        	<option value=${brnch.id}>${brnch.branch}</option>        
	        </c:forEach>                      
       </select>       
      
	  <br/>
        <label>USER NAME: </label>&nbsp;&nbsp;&nbsp;       
			<input class="form-control" type="text" id="userAccName" placeholder="ABISH OJHA">		
			
	 <br/>
        <label>CBS ID: </label>&nbsp;&nbsp;&nbsp;       
			<input class="form-control" type="text" id="cbsId">			
	  	
	  <br/>
      
       <label>JOB TITLE:</label>&nbsp;&nbsp;&nbsp; 
       <select class="form-control" id="seltitle"  onchange="myFunction()">
       <c:forEach var="accss" items="${la}">      
	        	<option value=${accss.group}>${accss.title}</option>        
	        </c:forEach>                     
       </select>
       
       <br/>
       
       	<input  type="hidden" id="grpAcc">			
       
       
       <p id="grpAcc"></p> 
       
       
       <label>REMARKS: </label>&nbsp;&nbsp;&nbsp; 
      
	  <input class="form-control" type="textarea" id="userRemarks" >
			
	   <br/><br/><br/>	   
	   
	   <div align="center"><a id="addAccess" class="btn btn-primary">SUBMIT</a> </div>	       
        <br>       
        
	</div>
	
			
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

    		
 </body>

 
 <script src="bootstrap/js/jquery-1.10.2.js"></script>
  <script src="doaweb/all.js"></script>
 
	<!-- Core Scripts - Include with every page for modal -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
   <script src="bootstrap/js/bootstrapValidator.min.js"></script>
 
 <script> 
 	$(document).ready(function(){
       $("#category").show();  
       $("#selpost").hide();        
       //$("#manage").hide(); 
    });   
     
    $("#addUser").click(function(){
  	 // $("#manage").show();    	 
      $("#category").hide();  
      $("#makerChk").modal({
	         backdrop: 'static',
	         keyboard: false,
	     })      
    }); 
    
    $("#navCategory").click(function(){
    	  $("#category").show();  
         // $("#manage").hide(); 
       }); 
    
   /*  $("#addCategory").click(function(){
  	  alert("Clicker");          	  	 
     }); */
    
     


    
 </script>
 </html>
 
 