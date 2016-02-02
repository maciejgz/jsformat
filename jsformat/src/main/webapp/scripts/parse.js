$( document ).ready(function() {
	//download rss feed
	jQuery.ajax({
			url : 'http://localhost:8080/jsformat/simpleproxy?url=https://www.disasterscharter.org/charter-portlets/cpi-mvc/activations/feed/rss/',
			type : 'GET',
			dataType : "xml",
			success : loadXsl,
			error : function(data, status) {
				alert('error ' + data + ' status ' + status);
				// write to the console the error message 	
			}
		});
 
});



function loadXsl(data){
	console.log("feed: " + data);
	jQuery.ajax({
			url : '/jsformat/xls/disasters.xsl',
			type : 'GET',
			dataType : "xml",
			success : function (xml){
				parseFeed(data,xml);
			},
			error : function(data, status) {
				alert('error ' + data + ' status ' + status);
				// write to the console the error message 	
			}
		});
}

function parseFeed(feed, formatter){
	console.log("feed: " + data + "\n\n\n\n\nformatter" + formatter);
}
