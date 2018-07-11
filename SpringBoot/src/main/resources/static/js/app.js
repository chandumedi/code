function showCustomerDetails() {
	var today = new Date();
	var todayDate = today.getFullYear();
	var todayMonth = today.getMonth();
	var todayDate = today.getDate();
	if (todayMonth < 10) {
		todayMonth = '0' + todayMonth;
	}
	if (todayDate < 10) {
		todayDate = '0' + todayDate;
	}
	var trackDay = todayMonth + "/" + todayDate + "/" + todayDate;
	jsonData = {
		"name" : "chandu",
		"usedId" : "100",
		"region" : "india",
		"trackDate" : trackDay

	};
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "viewcustomerdetails.htm",
		dataType : "json",
		data : JSON.stringify(jsonData),
		sucess : function(data) {
		},
		error : function(errorData) {
		}
	});
}