<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"	prefix="sec"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
 
    <link rel="stylesheet" type="text/css" href="datatables/css/jquery.dataTables.min.css">
		   
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="assets/css/sidebarr.css" />
	
	
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    
	<script type="text/javascript" language="javascript" src="datatables/js/JQERY3.3.1.js"></script>
	<script type="text/javascript" language="javascript" src="datatables/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" language="javascript" src="datatables/js/datatables.responsive.min.js"></script>
		<link rel="stylesheet" type="text/css" href="assets/css/sidebarr.css" />
	
 
 
<head>

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
						<li >
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
						<br>
						<li class="active">
							<a href="addUsers">
							<b>ADD USERS</b></a>
						</li>
						<br/>
						<li align="left">
						
							<a href="j_spring_security_logout">
							<b>LOGOUT </b></a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		
		
		
<div class="col-md-9">
        <div class="profile-content">
            <button type="button"  id="addUserMod" class="btn btn-primary">
            Add Login Users
            </button>
          <br><br><br>
          
<!--           This modal is for the addition of new user .     -->
			   
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
       <label id="lblHeading">ADD USERS DETAILS</label>
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
        <label>DEPARTMENT NAME : </label>&nbsp;&nbsp;
        <input class="form-control" type="text" id="deptId" placeholder="Department Name">		  	
	  <br/> 
	  <label>ROLE: </label>&nbsp;&nbsp;&nbsp; 
        <select class="form-control" id="selRole" name="selRole">      
<%-- 	        <c:forEach var="venr" items="${vendorInAmc}">      
 --%>	        	  
 					<option value='DEP'>USER</option> 
 					<option value='ADMIN'>ADMIN</option>
 					     
<%-- 	        </c:forEach>                                          
 --%>       </select>   
	  <br/>
        <label>EMAIL ADDRESS: </label>&nbsp;&nbsp;&nbsp;       
			<input type="text" class="form-control" type="text" id="userName" >     
     
      <br/>
        <label>PASSWORD: </label>&nbsp;&nbsp;&nbsp;       
			<input type="password" class="form-control" type="text" id="userPass" >     
      
      <br/>
        <label>RE-TYPE PASSWORD: </label>&nbsp;&nbsp;&nbsp;       
			<input type="password" class="form-control" type="text" id="userPass1" >     
      <br/>		   
	   <div align="center"><a id="addUserBtn" class="btn btn-primary">Submit</a> 
	   </div>	       
        <br>         
	</div>			
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<!-- This modal is for update of the user detail.  -->

<div class="modal fade" tabindex="-1" role="dialog" aria-hidden="true" id="updmakerChk" >
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
       <label id="lblHeading">ADD USERS DETAILS</label>
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
	    <input class="form-control" type="hidden" id="upduserId">		  	
	 
        <label>DEPARTMENT NAME : </label>&nbsp;&nbsp;
        <input class="form-control" type="text" id="upddeptId" placeholder="Department Name">		  	
	  <br/> 
	  <label>ROLE: </label>&nbsp;&nbsp;&nbsp; 
        <select class="form-control" id="updselRole" name="selRole">      
        	  
 					<option value='DEP'>USER</option> 
 					<option value='ADMIN'>ADMIN</option>
 					     
       </select>   
	  <br/>
        <label>EMAIL ADDRESS: </label>&nbsp;&nbsp;&nbsp;       
			<input type="text" class="form-control" type="text" id="upduserName" >     
     
      <br/>
        <label>PASSWORD: </label>&nbsp;&nbsp;&nbsp;       
			<input type="password" class="form-control" type="text" id="upduserPass" >     
      
      <br/>
        <label>RE-TYPE PASSWORD: </label>&nbsp;&nbsp;&nbsp;       
			<input type="password" class="form-control" type="text" id="upduserPass1" >     
      <br/>		   
	   <div align="center"><a id="updUserBtn" class="btn btn-primary">Submit</a> 
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
						                <th>Department Name</th>
						                <th>Role</th>
						                <th>Email</th>
						                <th>Action</th>
						            </tr>
						        </thead>
					       			<tbody>
					                      <c:forEach var="test" items="${listusers}">
								             <tr>
							                    	<td align="center"><h5 id="tduserGrp">${test.userGroup}</h5></td>
							                       	<td align="center"><h5 id="tduserRole">${test.userRole}</h5></td>
							                    	<td align="center"><h5 id="tduserUserName">${test.userName}</h5></td>
							                    	<td align="center">
								                    	<input type="button" onClick="showUserUpdate('${test.id}','${test.userGroup}','${test.userRole}','${test.userName}');" class="btn btn-primary" value="Update">&nbsp;&nbsp;
 								                    	<input type="button" onClick="deleteUser('${test.userName}');" class="btn btn-danger" value="Delete">
 							                   
 							                    </td>
							                    	
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
          	        
          	        paging: false
          	    } );   
            	 
             });
             
           
             
/*              This method is to show the modal */

			$("#addUserMod").click(function(){  
                  $("#makerChk").modal({
            	         backdrop: 'static',
            	         keyboard: false,
            	     })     
              });  
             
          
			/*              This method is to add the user detail in modal */

           $("#addUserBtn").click(function(){

         		document.getElementById("addUserBtn").disabled = true;
         		var url="insertUserLogin";	    		
         		var postinsert = $.post(url, insertUserLogin());
         	    postinsert.done(function(data) {	
         		alertresponse(data);
         		//window.location.reload(true);    		
         		});
         	});


	         function insertUserLogin(){
	         	 var insertUserLogin={
	         				deptName:$("#deptId").val(),
	         				selRole:$("#selRole").val(),
	         				userName:$("#userName").val(),
	         				userPass:$("#userPass").val(),
	         				userPass1:$("#userPass1").val()
	         							
	         	   };	
	         		return insertUserLogin;		
	         }
         

         function alertresponse(json)
         {
         	var jsono = $.parseJSON(json);
         		
         		if(jsono.rescode=="101")
         			{
         			alert(jsono.resmsg); 
         			
         			$("#userPass").val(""),
     				$("#userPass1").val("")
         			document.getElementById("userPass").focus();
         			document.getElementById("userPass1").focus();

         			}
         		else if(jsono.rescode=="102")
     			{
         			alert(jsono.resmsg);     
         			
     			}
         		
         		else if(jsono.rescode=="103")
     			{
         			alert(jsono.resmsg);  
             		window.location.reload(true);    		

     			}
         		else if(jsono.rescode=="104")
     			{
         			alert(jsono.resmsg);  
             		window.location.reload(true);    		

     			}
         		
         		 else if(jsono.rescode=="500")
     			{
         			alert(jsono.resmsg);     
     			}
         		
         		else if(jsono.rescode=="501")
     			{
         			alert(jsono.resmsg);  
             		window.location.reload(true);    		
     			}
         		
         		else if(jsono.rescode=="502")
     			{
         			alert(jsono.resmsg);     
     			} 
         		
         		else 
     			{
         			alert(jsono.resmsg); 
             		window.location.reload(true);    		
         		}
         	
         }
         
         
/*        This method is for showing the update modal of the user detail    */         
        
		function showUserUpdate(id,deptName,userRole,userNm){
	// alert(id+" "+deptName+" "+userRole+" "+userNm);
				 $("#upduserId").val(id);
				 $("#upddeptId").val(deptName);
				 $("#updselRole").val(userRole);
				 $("#upduserName").val(userNm); 

     		 $("#updmakerChk").modal({
     	         backdrop: 'static',
     	         keyboard: false,
     	   		  })  
     		 }
             
             
         $("#updUserBtn").click(function(){
      		//document.getElementById("addUserBtn").disabled = true;
      		var url="updateUserLogin";	    		
      		var postinsert = $.post(url, updateUserLogin());
      	    postinsert.done(function(data) {	
      		alertresponse(data);
      		//window.location.reload(true);    		
      		});
      	});
         
         
         function updateUserLogin(){
         	 var updateUserLogin={
      					updid:$("#upduserId").val(),
         				upddeptName:$("#upddeptId").val(),
         				updselRole:$("#updselRole").val(),
         				upduserName:$("#upduserName").val(),
         				upduserPass:$("#upduserPass").val(),
         				upduserPass1:$("#upduserPass1").val()
         							
         	   };	
         		return updateUserLogin;		
         }
         
         
/*          Below function Deletes the  user login */       

		function deleteUser(userNam){
	      			      		
      		var url="deleteUserLogin?userName="+userNam;	    		
      		var postinsert = $.post(url);
      	    postinsert.done(function(data) {	
      		alertresponse(data);
      		//window.location.reload(true);    		
      		
      	    });
}
         
         
		</script>
    </body>
</html>
