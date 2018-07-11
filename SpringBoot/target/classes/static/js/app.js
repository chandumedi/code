function showCustomerDetails() {
	$.ajax({
		type : "GET",
		url : "viewcustomerdetails.htm",
		dataType : "text",
		contentType: "application/json",
		data : {
			"name" : "chandu"
		},
		sucess : function(data) {
		},
		error : function(errorData) {
		}
	});
}