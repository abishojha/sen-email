<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><html>

	<link rel="stylesheet" type="text/css" href="assets/css/sidebarr.css" />


	<link rel="stylesheet" type="text/css" href="datatables/css/jquery.dataTables.min.css">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" language="javascript" src="datatables/js/JQERY3.3.1.js"></script>
	<script type="text/javascript" language="javascript" src="datatables/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" language="javascript" src="datatables/js/datatables.responsive.min.js"></script>
 
<!-- <head>

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
 -->
<body>

<div class="container">
    <div class="row profile">
		<div class="col-md-3">
			<div class="profile-sidebar">
				
				<div class="profile-usertitle">
				              	<img src="img/giblll.jpg">
								              	<br><br>
				
					<div class="profile-usertitle-name">
						Remind US System
					</div>
					
				</div>
				
				<br><br>
				
				<div class="profile-usermenu">
					<ul class="nav">
						<li>
							<a href="#">
							All AMCs</a>
						</li>
						<li >
							<a href="getVendorDetail">
							Add Vendors </a>
						</li>
						<li >
							<a href="addAmcDetailpage">
							Add AMC Dates </a>
						</li>
						<li class="active">
							<a href="#">
							AMC expires on 30 days </a>
						</li>
						
						<li>
							<a href="#">
							 Email Sent Details </a>
						</li>
						<br/>
						
						<li align="left">
						
							<a href="j_spring_security_logout">
							<b>LOGOUT </b></a>
							
						
						</li>
					</ul>
				</div>
				<!-- END MENU -->
			</div>
		</div>
		
		<div class="col-md-9">
            <div class="profile-content">
            
          <div align="center"> <h2><B><U>AMC EXPIRES IN 30 DAYS</U></B></h2></div> 
            
          <br><br>
          <br>
          
<!--          This modal is for update of the AMC detail   -->			   
<div class="modal fade" tabindex="-1" role="dialog" aria-hidden="true" id="addAmcModal" >
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
       <label id="lblHeading">ADD AMC DETAILS</label>
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
                	
                	<input class="form-control" type="hidden" id="venUpdId" readonly>	   
        
        			<input class="form-control" type="text" id="venUpdName"  readonly>	   
 
						 <br/>
						   
						  <label>AMC PURPOSE: </label>&nbsp;&nbsp;&nbsp;       
								<input class="form-control" type="text" id="amcPrpUpdId" required="required" >	   
					      <br/>   
						  <label>AMC START DATE: </label>&nbsp;&nbsp;&nbsp;       
								<input class="form-control" type="date" id="updamcStartDate" required="required">	   
					      <br/> 
						  <label>AMC END DATE: </label>&nbsp;&nbsp;&nbsp;       
								<input class="form-control" type="date" id=updamcEndDate required="required" >	   
					      <br/>
					      
					        
						   <div align="center"><a id="updateAmcDates" class="btn btn-primary">Update</a> 
						   </div>	       
					        <br>         
						</div>
						</div>
				</div>
			</div>
		</div>
	</div>
</div>


    <div align="left">
                 	  <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%" >
						        <thead>
						            <tr>
						                                      <th>VENDOR NAME</th>
						                                      <th>AMC</th>
						                                      <th width=100px;>Start Date</th>
						                                      <th width=100px;>End Date</th>
						                                   	  <th>Remaining Days</th>
						                                      <th>Status</th>
						                                      <th>Action</th>
					                                      
						            </tr>
						        </thead>
					       <tbody>
					                           	 <c:forEach var="test" items="${listAmcDetail}">
<%-- 								                      <tr id="${test.vendorId}">							
 --%>							                        	<tr>
 
 
														<td align="left"><h5 id="vendorName" >${test.vendorNm}</h5> </td>
							                          	<td align="left"><h5 id="amcPurpose" >${test.amcPurpose}</h5></td>
							                          	
							                           <%-- 	<td align="center"><input type="text" style="border: 0px;"  id="vendorName" value="${test.vendorNm}" readonly> </td>
							                          	<td align="center"><input type="text" style="border: 0px;"  id="amcPurpose" value="${test.amcPurpose}" readonly> </td>
							                          	 --%>
							                          	 <td align="left">${test.amcStartDate}</td>
							                           	<td align="left">${test.amcEndDate}</td>
							                         	<td align="left">${test.daysLeft}</td>
							                           	
							                           	<td align="left">${test.amcStatus}</td>
							                           	<td align="center">
							                           	<input type="button" onClick="showUpdate('${test.vendorId}','${test.vendorNm}','${test.amcPurpose}');"  class="btn btn-primary" value="Renew"></td>
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
            	 
            	 $('#example').DataTable( {
         	        scrollY:        '50vh',
         	        scrollCollapse: true,
         	        paging:         false
         	    //   searching: false
         	    } );
          	 
      
             });
             
             function showUpdate(vendorId,venNam,venP){
            	 
            	 
                 /*  var vendorName = $('#' + vendorId + ' #vendorName').val();
                  var amcPurpose = $('#' + vendorId + ' #amcPurpose').val();
           	  */
            		 $("#venUpdName").val(venNam);
					 $("#venUpdId").val(vendorId);
					 $("#amcPrpUpdId").val(venP); 


        		 $("#addAmcModal").modal({
        	         backdrop: 'static',
        	         keyboard: false,

        	     }) 
            	
             }
             
                      
           
           $("#updateAmcDates").click(function(){
         	//	$("#addVendors").prop('disabled', 'disabled'); 
         	
         		document.getElementById("updateAmcDates").disabled = true;

         		var url="updateAmcDetails";	    		
         		var postinsert = $.post(url, updateAmcDates());
         	    postinsert.done(function(data) {	
         		alertresponse(data);
         		window.location.reload(true);    		
         		});
         	});


         function updateAmcDates(){
         	 var updateAmcDates={
         				updAmcId:$("#venUpdId").val(),
         				amcPurposeUpdId:$("#amcPrpUpdId").val(),
         				updamcStartDate:$("#updamcStartDate").val(),
         				updamcEndDate:$("#updamcEndDate").val()
         							
         	   };	
         		return updateAmcDates;		
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
