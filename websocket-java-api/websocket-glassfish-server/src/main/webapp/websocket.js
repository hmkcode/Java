var URL = "ws://localhost:8080/websocket-glassfish-server/websocket/web-client";
var websocket;

$(document).ready(function(){
	connect();	
});

function connect(){
	 	websocket = new WebSocket(URL);
	 	websocket.onopen = function(evnt) { onOpen(evnt) };
		websocket.onmessage = function(evnt) { onMessage(evnt) };
		websocket.onerror = function(evnt) { onError(evnt) };
}
function sendMessage() {
    websocket.send($("#message").val());
}
function onOpen() {
	updateStatus("connected")
}
function onMessage(evnt) {
    if (typeof evnt.data == "string") {
    	
    	$("#received_messages").append(
                		$('<tr/>')
                		.append($('<td/>').text("1"))
                		.append($('<td/>').text(evnt.data.substring(0,evnt.data.indexOf(":"))))
                		.append($('<td/>').text(evnt.data.substring(evnt.data.indexOf(":")+1))));
    } 
}
function onError(evnt) {
    alert('ERROR: ' + evnt.data);
}
function updateStatus(status){
	if(status == "connected"){
		$("#status").removeClass (function (index, css) {
		   return (css.match (/\blabel-\S+/g) || []).join(' ')
		});
		$("#status").text(status).addClass("label-success");
	}
}