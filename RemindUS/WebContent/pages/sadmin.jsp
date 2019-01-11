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
      <li id="editUser" class="active"><a href="#">MANAGE USER/ACCESS</a></li> 
      <li id="viewBranch" class="active"><a href="#">EXPORT BRANCH ACCESS</a></li>
      <li id="seacrhUser" class="active"><a href="#">SEARCH USER</a></li>      
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="j_spring_security_logout">Log Out</a></li>
    </ul>
  </div>
</nav>
  
<%-- <H2>Welcome to : ${ROLE} </H2>
 --%><br><br>

<div id="dataTest">

<div  class="col-lg-12" align="center">
                        <h2><span class="label label-primary">SEARCH USER AND BRANCH ACCESS</span></h2><br>
                 </div>  

<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
               <th>Branch</th>
                                      <th>User Name</th>
                                      <th>CBS ID</th>
                                      <th>Job Title</th>
                                      <th>User Group</th> 
                                      <th>Status</th>                                         
                                      <th>Remarks</th> 
            </tr>
        </thead>
       <tbody>
                           	 <c:forEach var="test" items="${listUserAcc}">
			                      <tr>
			
		                        	<td align="center">${test.branchName}</td>
		                            <td align="center">${test.userName}</td>		                        	
		                        	<td align="center">${test.cbsId}</td>
		                            <td align="center">${test.jobTitle}</td>
		                           	<td align="center">${test.cbsAccess}</td>
		                           	<td align="center">${test.status}</td>
		                           	<td align="center">${test.remarks}</td>
		                           	
		                           
			                    	</tr>
		                       	</c:forEach>
		                    </tbody>
 </table>

 </div>
 <br> <br>
  </br>
 
 	<div class="footer"><div align="center"  style="color:#0C0E75;"class="container"><B>Designed and Developed By:<br/> IT DEPARTMENT <br/>SANIMA BANK PVT. LTD</B></div></div>
 


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
       	<input  type="hidden" id="grpAcc"> <p id="grpAcc"></p> 	      
       <label>REMARKS: </label>&nbsp;&nbsp;&nbsp;       
	  <input class="form-control" type="textarea" id="userRemarks" >		
	   <br/><br/>	   
	   <div align="center"><a id="addAccess" class="btn btn-primary">ADD ACCESS</a> 
	   </div>	       
        <br>         
	</div>			
					</div>
				</div>
			</div>
		</div>
	</div>
</div>




<!-- ****************************UPDATE ACCESS**************************************************** -->

<div class="modal fade" tabindex="-1" role="dialog" aria-hidden="true" id="updateModal" >
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
       <label id="lblHeading">UPDATE USER AND ACCESS</label>
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
       <select class="form-control" id="updBranch" name="updBranch">      
	        <c:forEach var="brnch" items="${lb}">      
	        	<option value=${brnch.id}>${brnch.branch}</option>        
	        </c:forEach>                      
       </select>       
	  <br/>
        <label>USER NAME: </label>&nbsp;&nbsp;&nbsp;       
			<input class="form-control" type="text" id="updAccName" placeholder="ABISH OJHA">					
	 <br/>
        <label>CBS ID: </label>&nbsp;&nbsp;&nbsp;       
			<input class="form-control" type="text" id="updcbsId">		  	
	  <br/>      
       <label>JOB TITLE:</label>&nbsp;&nbsp;&nbsp; 
       <select class="form-control" id="updTitle"  onchange="updmyFunction()">
       <c:forEach var="accss" items="${la}">      
	        	<option value=${accss.group}>${accss.title}</option>        
	        </c:forEach>                     
       </select>       
       <br/>       
       <input  type="hidden" id="updgrpAcc"><p id="updgrpAcc"></p> 	      
       <label>REMARKS: </label>&nbsp;&nbsp;&nbsp;       
	  <input class="form-control" type="textarea" id="updRemarks" >		
	   <br/><br/>	   
	   <div align="center"><a id="updateAccess" class="btn btn-primary">UPDATE ACCESS</a> 
	   </div>	       
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

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">




<!--   <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 -->  <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
 
 
 <script> 
 
 $(document).ready(function () {
     $('#example').dataTable();
 });
 
 $("#addUser").click(function(){  
     $("#dataTest").hide();    
      $("#makerChk").modal({
	         backdrop: 'static',
	         keyboard: false,
	     })     
  });   
    
  $("#editUser").click(function(){
	     $("#dataTest").hide();   
         $("#updateModal").modal({
   	         backdrop: 'static',
   	         keyboard: false,
   	     })      
  }); 
  
  $("#viewBranch").click(function () {
	  $("#dataTest").show();  
  });
</script>      
 </html>
 
 