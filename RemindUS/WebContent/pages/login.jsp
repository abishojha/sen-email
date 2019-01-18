<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Test Java System</title>
<!-- Core CSS - Include with every page -->
<link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />	
<link href="assets/css/style.css" rel="stylesheet" />
</head>

<body style="background:url('img/backimg.jpg') no-repeat;">
	<div class="container" align="center">
		<div class="row">
  
		  <div>
		   	<img src="img/gibl.jpg" width=500px;>
		  </div>
			
			<div class="col-md-3 col-md-offset-4">
			
				
				<div class="col-md-12"  id="divErr" style="margin-top:100px;">
              		<input type="hidden" value="${err}" id="txtErr">
                    
                        <div class="panel-heading">
                            ${errMsg}
                    </div>
	            </div>
			
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title"><b>REMIND US ...</b></h3>

					</div>
					<div class="panel-body">
						<form role="form" name='login' id="logina" method='post'
							action='j_spring_security_check'>
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Username" id="user"
										name='j_username' type="text" >
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name='j_password' type="password" >
								</div>							
															
								
								<!-- Change this to a button or input when using this as a form -->
								
								<button type='submit' id="clickme"  class='btn btn-lg btn-danger ladda-button'
									  data-style="expand-right" ><span class="ladda-label"><b>Login</b></span></button>
							</fieldset>
						</form>
					</div>
				</div>		
			</div>
			</div>
		
	<br><br/><br/>
	</div><!-- Core Scripts - Include with every page -->
	
	
	<script src="assets/plugins/jquery-1.10.2.js"></script>
	<script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
 
 <script>
	
		$(document)
				.ready(
						function() {
							init();
							if (msieversion()) {
								alert("Browser Not Supported. Please use 'Googl Chrome' instead. Download Google Chrome from the link");
								window.location.href = "https://www.google.com/intl/en/chrome/browser/";

							} else {
							}

						});

		function msieversion() {
			var ua = window.navigator.userAgent;
			var msie = ua.indexOf("MSIE ");

			if (msie > 0) // If Internet Explorer, return version number
				return true;
			else

				return false;
		}
		function init() {
			var e = $("#txtErr").val();
			if (e != null && e != "1")
				$('#divErr').hide();
			else
				$('#divErr').show();
		}
		
		$("#clickme").click(function(e){
			$(".ladda-label").html("Authenticating.....");
			var l = Ladda.create(this);
		 	l.start();
		 	$("#logina").submit();
		 	
		 	
		});
		
		
	</script>
</body>
</html>
