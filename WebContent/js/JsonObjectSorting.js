function JsonObjectSorting(json){
	
	var allMonths = ['Jan-16','Feb-16','Mar-16', 'Apr-16','May-16','Jun-16','Jul-16','Aug-16','Sep-16','Oct-16','Nov-16','Dec-16','Average'];
//
//	var month = [ "Apr","May","Jun","Oct","Nov","Dec","Jul","Aug","Sep"];
//	


	var keys = [];
	for(var k in json){
		keys.push(k);
		
	}
	console.log(keys);
	
	keys.sort(function(a,b){
	    return allMonths.indexOf(a) > allMonths.indexOf(b);
	});
	
	console.log(keys);
//	month.sort(function(a,b){
//	    return allMonths.indexOf(a) > allMonths.indexOf(b);
//	});
//    
}



