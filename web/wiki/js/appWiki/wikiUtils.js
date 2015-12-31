//this method is not dependent on other module(s)
//this util class serves for pages that have specific needs that isn't loaded in every default page
define(['jquery'], function ($) {
//if dependent on other moduels use this instead
//define(["app/moduleName", "app/moduleName2"], function(module1, module2){
	//then you can use the modules like: module1.method1();

	var mod = {};
	
    //method 1
	mod.test = function(){
		console.log("wiki Utils test working");
	};
	
	//public
	mod.init = function() { 
		//dosomething
	};

	var mainWebTitlePrefix = "Wiki - ";
	mod.setMainWebTitle = function(title){
		document.title = mainWebTitlePrefix + title;
	};
			
	//private - called within other functions in here only
	function privateMethod(param){
		//do something
	};
	
	/*
	due to pages that use the collasper, section with class name box will append a block display
	call the utils.removeDisplayBlockOnBoxClass() after calling the enableCollapser() to remove this
	then just click uncollapseall to reset the page as a hack around
	*/
	mod.removeDisplayBlockOnBoxClass = function(){
		$(function(){ //shortuct jquery on doc ready
			//$('section.box')
			$('section.box').css('display', '');
		});	//end jquery
	};
	
	// only works with specific setup of the section tags
	mod.enableCommonCollapser = function(){
		$(function(){
		
			//create the collapse all buttons right afert he main nav section
			var collapseAllStr = 	'<div id="collapser">' +
										'<a class="unCollapseAll" >Uncollapse All</a>' +
										'<a class="collapseAll" >Collapse All</a>' +
									'</div>'
			//if tag not found
			if($('section#start').length){
				//move this section collapseAllStr and write it before section#start
				$('section#start').before( collapseAllStr );
			}else{
				console.warn('<section id="start"> not found! Is required for collapse buttons to appear.');
			}
			
			//collapse all at start contents except h1
			$('section section section').hide();
			
			//collapse all
			$('.collapseAll').click(function(){
				$('section section section').hide();
			});
			
			//un-collapse all
			$('.unCollapseAll').click(function(){
				$('section section section').show();
			});
			
			//hide click
			$('section section').click(function(){
				var $temp = $('section', this);	//search within this, and find section
				if($temp.is(":visible")){
					$temp.hide();
				}else{
					$temp.show();
				}
			});
		
		});
	};
	
	
	//helps create a table from a passed in 2D array and header array
	//also makes the first column a hyperlink
	mod.display2dDataWithLink = function(data2D, headers){
		var finalStr = "";
		
		//############## - print header row
		finalStr += "<tr>";
		for(headerCount=0; headerCount<headers.length; headerCount++){
			finalStr += "<th>" + headers[headerCount] + "</th>";
		}
		
		finalStr += "</tr>";
		
		
		// url link str
		var str1 = "<a href=\"";
		var str2 = "\" target=\"_blank\">";
		
		var str3 = "</a>";
		
		var size = data2D.length;	
		
		// to get size of inner array
		// var size = data2D[0].length;

		// get the first element in the 2Darray, then find it's length
		// that will determine how many col we have in each row
		var totalColOfData = data2D[0].length;
		
		// data2D has one too many than we need due to url link
		// so we need one less than total data2D size
		// for itertaion purpose, we want
		// one less than the totalColData from data2D
		totalColOfData--;	
		
		//################ - print data2D rows
		for(row=0; row<size; row++){
			
			//each row
			finalStr += "<tr>";
			
			for(col=0; col < totalColOfData; col++){
				
				//col 1
				if(col == 0){
					// we only want col 1 to have a link
					finalStr += "<td>" 
					+ str1 
					+ data2D[row][col+1] // name
					+ str2 
					+ data2D[row][col] // link
					+ str3 
					+ "</td>";
					
				}else{	// for col 2 and so on... we don't want links
				
					finalStr += "<td>" + data2D[row][col+1] + "</td>";
				
				}
				
			}
			
			finalStr += "</tr>";
		}
		
		return finalStr;
		
	};
	
	return mod;
});