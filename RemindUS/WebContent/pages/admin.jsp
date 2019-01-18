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
        <label>PURPOSE : </label>&nbsp;&nbsp;&nbsp;       
			<input class="form-control" type="text" id="amcId">		  	
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

               
					<div id="paraggg"  width="100%">
					
						
						<a  id="addVen" class="btn btn-info" data-toggle="collapse"> Add Vendors</a>
						
						
						
										  
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

		<script src="bootstrap/js/jquery-1.10.2.js"></script>
  	 	<script src="bootstrap/js/bootstrap.min.js"></script>
  	 	
  	 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">



<!--   <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 -->  <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>

     <script type="text/javascript">
             $(document).ready(function () {
            	 
            	// alert("done");
            	 
                 $('#example').dataTable();

            	 
                 
             });
             
             $("#addVen").click(function(){  
               //  $("#dataTest").hide();    
                  $("#makerChk").modal({
            	         backdrop: 'static',
            	         keyboard: false,
            	     })     
              });  
             
           
           $("#addVendors").click(function(){
         	//	$("#addVendors").prop('disabled', 'disabled');         		
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
