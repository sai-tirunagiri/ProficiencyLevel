function chart1(response,resolution){
	
	console.log(response);
	console.log(resolution);
		
 		
 		
 			
 		
 		var myArray = [];
 		var customArray = new Array();
		
		for(var i=0;i<response.length;i++){
			customArray.push(response[i]);
			myArray.push({name: response[i],y: response[++i]});
			i = i++;
		}
		
		console.log("custom array is :-" +customArray);
		console.log("===="+JSON.stringify(myArray));

		$(function () {
		    $('#container')
		        .highcharts({
		            chart: {
		                plotBackgroundColor: null,
		                plotBorderWidth: null,
		                plotShadow: false,
		                type: 'column'
		            },
		            title: {
		                text: 'SLA Response Time'

		            },
		            xAxis: {
		            	categories:customArray,
		                title: {
		                	
		                	
		                    text: 'Year'
		                }

		            },
		            yAxis: {
		                title: {
		                    text: 'Severity'
		                }

		            },
		            credits: {
		                enabled: false
		            },
		            tooltip: {
		                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		            },
		            plotOptions: {
		                pie: {
		                    allowPointSelect: true,
		                    cursor: 'pointer',
		                    dataLabels: {
		                        enabled: true,
		                        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
		                        style: {
		                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
		                        }
		                    }
		                }
		            },
		            legend: {
		                enabled: false
		               
		            },
		            exporting:false,
		            series: [{  
		                
		                colorByPoint: true,
		                data: myArray
								}]
		        });
		});
		
		var myArray1 = [];
 		var customArray1 = new Array();
		
		for(var i=0;i<resolution.length;i++){
			customArray1.push(resolution[i]);
			myArray1.push({name: resolution[i],y: resolution[++i]});
			i = i++;
		}
		
		console.log("custom array is :-" +customArray1);
		console.log("===="+JSON.stringify(myArray1));
		
		
		//This is for 2nd graph	
		$(function () {
		    $('#container1')
		        .highcharts({
		            chart: {
		                plotBackgroundColor: null,
		                plotBorderWidth: null,
		                plotShadow: false,
		                type: 'column'
		            },
		            title: {
		                text: 'SLA Resolution Time'

		            },
		            xAxis: {
		            	categories:customArray1,
		                title: {
		                	
		                    text: 'Year'
		                }

		            },
		            yAxis: {
		                title: {
		                    text: 'Severity'
		                }

		            },
		            credits: {
		                enabled: false
		            },
		            tooltip: {
		                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		            },
		            plotOptions: {
		                pie: {
		                    allowPointSelect: true,
		                    cursor: 'pointer',
		                    dataLabels: {
		                        enabled: true,
		                        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
		                        style: {
		                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
		                        }
		                    }
		                }
		            },
		            legend: {
		                enabled: false
		               
		            },
		            exporting:false,
		            series: [{  
		                
		                colorByPoint: true,
		                data: myArray1
								}]
		        });
		});
		
}