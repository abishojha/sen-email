<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><html>

<html>
<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
 -->
 
    <link rel="stylesheet" type="text/css" href="datatables/css/jquery.dataTables.min.css">
<!-- 	<link rel="stylesheet" type="text/css" href="datatables/css/responsive.datatables.min.css">
 -->		   
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    
	<script type="text/javascript" language="javascript" src="datatables/js/JQERY3.3.1.js"></script>
	<script type="text/javascript" language="javascript" src="datatables/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" language="javascript" src="datatables/js/datatables.responsive.min.js"></script>
	
 
 
<head>

<style>

body {
  background: #F1F3FA;
}

/* Profile container */
.profile {
  margin: 10px 0;
}

/* Profile sidebar */
.profile-sidebar {
  padding: 20px 0 10px 0;
  background: #fff;
    min-height: 600px;
  
}

.profile-userpic img {
  float: none;
  margin: 0 auto;
  width: 50%;
  height: 15%;
  -webkit-border-radius: 50% !important;
  -moz-border-radius: 50% !important;
  border-radius: 50% !important;
}

.profile-usertitle {
  text-align: center;
  margin-top: 10px;
}

.profile-usertitle-name {
  color: #5a7391;
  font-size: 16px;
  font-weight: 600;
  margin-bottom: 7px;
}

.profile-usertitle-job {
  text-transform: uppercase;
  color: #5b9bd1;
  font-size: 12px;
  font-weight: 600;
  margin-bottom: 15px;
}

.profile-userbuttons {
  text-align: center;
  margin-top: 10px;
}

.profile-userbuttons .btn {
  text-transform: uppercase;
  font-size: 11px;
  font-weight: 600;
  padding: 6px 15px;
  margin-right: 5px;
}

.profile-userbuttons .btn:last-child {
  margin-right: 0px;
}
    
.profile-usermenu {
  margin-top: 2px;
}

.profile-usermenu ul li {
  border-bottom: 1px solid #f0f4f7;
}

.profile-usermenu ul li:last-child {
  border-bottom: none;
}

.profile-usermenu ul li a {
  color: #c43733;
  font-size: 14px;
  font-weight: 400;
}

.profile-usermenu ul li a i {
  margin-right: 2px;
  font-size: 14px;
}

.profile-usermenu ul li a:hover {
  background-color: #fafcfd;
  color: #5b9bd1;
}

.profile-usermenu ul li.active {
  border-bottom: none;
}

.profile-usermenu ul li.active a {
  color: #5b9bd1;
  background-color: #f6f9fb;
  border-left: 2px solid #5b9bd1;
  margin-left: -2px;
}

/* Profile Content */
.profile-content {
  padding: 20px;
  background: #fff;
  min-height: 600px;
}
</style>
</head>

<body>

<div class="container">
    <div class="row profile">
		<div class="col-md-3">
			<div class="profile-sidebar">
				
				<div class="profile-usertitle" align="left">
				              	<img src="img/giblll.jpg">
				              	
				              	<br><br>
				              	
				
					 <div class="profile-usertitle-name">
						Remind US System
					</div> 
					<br><br>
					
				</div>
				
				
				
				<div class="profile-usermenu">
					<ul class="nav">
						<li>
							<a href="#">
							All AMCs</a>
						</li>
						<li class="active">
							<a href="getVendorDetail">
							Add Vendors </a>
						</li>
						<li>
							<a href="addAmcDetailpage">
							Add AMC Dates </a>
						</li>
						<li>
							<a href="addBeforeMonth">
							AMC expires on 30 days </a>
						</li>
						
						<li>
							<a href="#">
							 Email Sent Details </a>
						</li>
						<br/>
						<li>
							<a href="logout">
							LOGOUT </a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		
		
		
		<div class="col-md-9">
            <div class="profile-content">
            
          <a  id="addVen" class="btn btn-info" data-toggle="collapse"> Add Vendors</a>
          <br>          <br>
                    <br>
          
            
			   
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
       <label id="lblHeading">ADD VENDOR DETAILS</label>
      </h4>
     </div>
     <div class="panel-body">
      <div class="row">
       <div class="col-sm-4">
        <div id="divMsgs"></div>
       </div>
      </div>      
      <div class="form-group"> 			
           
	  <br/>
        <label>VENDOR NAME: </label>&nbsp;&nbsp;&nbsp;       
			<input class="form-control" type="text" id="vendorId" >					
	 <br/>
        <label>Details : </label>&nbsp;&nbsp;<input class="form-control" type="text" id="amcId" placeholder="Name and Contact">		  	
	  <br/>      
      <br/>	   
	   <div align="center"><a id="addVendors" class="btn btn-primary">Submit</a> 
	   </div>	       
        <br>         
	</div>			
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

    <div>
                 	  <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
						        <thead>
						            <tr>
						                                      <th>Vendor Name</th>
						                                      <th>Vendor Details</th>
						                                      <th>AMC Status</th>
						            </tr>
						        </thead>
					       			<tbody>
					                      <c:forEach var="test" items="${vendors}">
								             <tr>
							                    	<td align="center">${test.vendor}</td>
							                       	<td align="center">${test.vendorPurpose}</td>
							                    	<td align="center">${test.status}</td>
								                    	</tr>
							              	</c:forEach>
							        </tbody>
						 </table>
                 </div>



			   
            </div>
		</div>
	</div>
</div>

  	<script src="bootstrap/js/bootstrap.min.js"></script>

     <script type="text/javascript">
             $(document).ready(function () {
                 $('#example').dataTable();
             });
             
             $("#addVen").click(function(){  
                  $("#makerChk").modal({
            	         backdrop: 'static',
            	         keyboard: false,
            	     })     
              });  
             
           
           $("#addVendors").click(function(){
         			    document.getElementById("addVendors").disabled = true;
         		var url="insertVendorNames";	    		
         		var postinsert = $.post(url, insertVendorNames());
         	    postinsert.done(function(data) {	
         		alertresponse(data);
         		window.location.reload(true);    		
         		});
         	});


         function insertVendorNames(){
         	 var insertVendors={
         				vendorName:$("#vendorId").val(),
         				vendorPurpose:$("#amcId").val()
         							
         	   };	
         		return insertVendors;		
         }
         

         function alertresponse(json)
         {
         	var jsono = $.parseJSON(json);
         	alert(jsono.resmsg);
         		/*if(jsono.rescode=="100")
         			{
         				clearforms();
         			}*/
         	
         }
             
         </script>
    </body>
</html>
