$("#addCategory").click(function(){
//	$("#addCategory").prop('disabled', 'disabled');
	var url="insertCategory";
	
	
	var postinsert = $.post(url, insertCat());
    postinsert.done(function(data) {
	
//	 $("#addCategory").removeAttr("disabled");
	 alertresponse(data);
	 /*if(jsono.rescode=="100")
		{
			clearforms();
		}*/

	 window.location.reload(true);
	
	});
});

function alertresponse(json)
{
	var jsono = $.parseJSON(json);
	alert(jsono.resmsg);
		/*if(jsono.rescode=="100")
			{
				clearforms();
			}*/
	
}

function insertCat(){

	var insertCategory=
	{
			cat:$("#ctname").val()	
   };	
	
    return insertCategory;		
}

//This method place the value of Group on change of title
function myFunction() {
    var x = document.getElementById("seltitle").value;
    document.getElementById("grpAcc").innerHTML = x;	    
}


//This method refesh the modal on exit
function refreshModal() {
	 window.location.reload( true );

	}


//insert the details in DB

$("#addAccess").click(function(){
		//$("#addAccess").prop('disabled', 'disabled');
		var url="insertUserAccess";	    		
		var postinsert = $.post(url, insertUserAccess());
	    postinsert.done(function(data) {	
		alertresponse(data);
		window.location.reload(true);    		
		});
	});


function insertUserAccess(){
	 var insertUser={
				selBranch:$("#selBranch").val(),
				userAccName:$("#userAccName").val(),
				cbsId:$("#cbsId").val(),
		        seltitle:$("#seltitle option:selected").text(),
		        grpAcc:$("#seltitle").val(),	
		        userRemarks:$("#userRemarks").val()				
	   };	
	 
	
		return insertUser;		
	 }





