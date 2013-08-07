function sendAsync(seq) {
	var data = new Object();
	data.seq = seq;
	$.ajax({
		url: "/async",
		type: 'GET',
		data: data,
		
		success: function (data) {
			$("#ares-"+data).text("reponse "+data);
        },
		error:function(data,status,er) {
			alert("error: "+data+" status: "+status+" er:"+er);
		}
	});
}


$(document).ready(function(){
	$("#start").click(function(){
		
		$("tr:has(td)").remove();
		
		for(i = 1 ; i < 5 ; i++){
			$("#asyncResponse").append($('<tr/>')
					.append($('<td/>').text("request -"+i))
					.append($("<td id='ares-"+i+"' />").text("processing.."))
			);	
			sendAsync(i);
		}
	});
	
	
	$("#exit").click(function(){
		sendAsync("exit");
	});
})
