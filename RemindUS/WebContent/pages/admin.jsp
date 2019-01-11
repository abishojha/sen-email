<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       
        <title>Remind Us</title>

         <!-- Bootstrap CSS CDN -->
  		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <!-- Our Custom CSS -->
        <link rel="stylesheet" href="bootstrap/css/style4.css">
        
    </head>
    <body>



        <div class="wrapper">
            <!-- Sidebar Holder -->
            <nav id="sidebar">
                <div class="sidebar-header">
                
              	<img src="img/giblll.jpg">
                
                    <h3>REMIND US APP</h3>
                    <strong>BS</strong>
                </div>

                <ul class="list-unstyled components">
                    <li class="active">
                        <a href="#">
                            
                            All AMC's
                            </a>
                        
                    </li>
                    <li>
                        <a href="#">
                            Add Vendors
                        </a>
                        <a href="#">
                            Add AMC Dates
                        </a>
                        
                    </li>
                    <li>
                        <a href="#">
                            AMC expires on 30 days 
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            Email Sent Details
                        </a>
                    </li>
                    
                    
                </ul>
                
                <ul class="list-unstyled components">
                    <li>
						<a href="logout">logout </a>
                    </li>
                 </ul>

               
            </nav>

            <!-- Page Content Holder -->
            <div id="content">

               
					<div id="paraggg">
					
						<a href="#demo" class="btn btn-info" data-toggle="collapse"><span class="glyphicon glyphicon-plus"> <I> Add Vendors</I></span></a>
						
						<div id="demo" class="collapse">
						   
						   	<div class="panel-body">
							<fieldset>
								<div class="form-group col-md-8">
								<label>Name of Vendor:</label>	<input class="form-control" id="vendorId" type="text" required="required">
								</div>
							
								<div class="form-group col-md-8">
								<label>Purpose of AMC</label><input class="form-control"  id="amcId"	type="text" required="required">
								</div>
								
								<div class="form-group col-md-8" align="center">
								<button type='submit' id="addVendors"  class="btn btn-info" data-style="expand-center"><b>SUBMIT</b></button>
							   </div>
							</fieldset>
					</div>
						   
						  </div>
						  
						  <br>
						  <br>
						  <br>
						  
					
					  
						  

                 </div> 
                 
                 <div>
                 	  <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
						        <thead>
						            <tr>
						                                      <th>Vendor Name</th>
						                                      <th>Purpose of AMC</th>
						                                      <th>Status</th>
						                                      
						            </tr>
						        </thead>
					       <tbody>
					                           	 <c:forEach var="test" items="${vendors}">
								                      <tr>
								
							                        	
							                           	<td align="center">'${test.vendor}'</td>
							                           	<td align="center">${test.vendorPurpose}</td>
							                           	<td align="center">${test.status}</td>
							                           	
							                           	
							                           
								                    	</tr>
							                       	</c:forEach>
							                    </tbody>
 </table>
                 </div>
                 
           </div>
        </div>

		<script src="bootstrap/js/jquery-1.10.2.js"></script>
  	 	<script src="bootstrap/js/bootstrap.min.js"></script>
  	 	
  	 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">




<!--   <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 -->  <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>

     <script type="text/javascript">
             $(document).ready(function () {
            	 
            	 alert("done");
            	 
                 $('#example').dataTable();

            	 
                 
             });
             
           
           $("#addVendors").click(function(){
         		$("#addVendors").prop('disabled', 'disabled');         		
         		
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
