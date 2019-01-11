<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

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
						  
						  

                 </div> 
                 
           </div>
        </div>

		<script src="bootstrap/js/jquery-1.10.2.js"></script>
  	 	<script src="bootstrap/js/bootstrap.min.js"></script>

     <script type="text/javascript">
             $(document).ready(function () {
                 $('#sidebarCollapse').on('click', function () {
                     $('#sidebar').toggleClass('active');
                 });
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
