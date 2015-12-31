/*
Just beneath the require.config() is where all our core libraries are required for this page, 
and also any modules that you might want to load and initialise on every page. Keeping it simple again:
*/

//Seeing as we’re just loading these libraries 
//(our modules will actually use them) we can leave the callback empty.
//require(['jquery', 'handlebars'], function() {});

require(['jquery','app/fightClub', 'app/print', 'app/FightCard', 'app/controllers/indexController'], function ($,fc,p,FightCard, indexController){	//when you need to init something
//require(function(){ //when you don't need any other required classes
	
	
	$(function(){	// this is the short version of the jquery document.ready() when the dom is all loaded
		
		//test that the modles are working
		//console.log(fc.test());
		//console.log(p.test());
		
		//when document is loaded and ready do the below
		document.getElementById("demoF_Right").innerHTML = p.printAllFcardsToHTMLDiv(fc.getJsonObj());
		
		//indexController.loadNav();
		//left nav buttons
		var navArrayList = [
			{
				"linkName":"Show All", 
				"id":"showAll"
			}, 
			{
				"linkName":"Show Upcoming",
				"id":"showUpcoming"
			}
		];
		document.getElementById("demoFnav").innerHTML = p.printLeftNav(navArrayList);
		
		
		//FightCard test
		var card = new FightCard(10001002, fc.getJsonObj());
		//fcard.init(10001002, fightClub.commonMethods.getJsonObj());
		//console.log(fcard.getFCardId());
		//console.log(fcard.getFighterIds().toString());
		//console.log(fcard.callPrivateMethod());
		//console.log(fcard.getFighterNames().toString());
		console.log("test: " + card.getFighterNames());
		
		//TODO -- these should be moved into a controller module
		//events
		//hide method
		$("#showAll").click(function(){
			//$(this).hide();
			//console.log("clicked show all");
			
			//fade out first
			$("#demoF_Right").fadeOut(100, function(){
				//set a property if want
				//$(this).prop('isFadeOut', true);
				//when done fading out, apply the change
				document.getElementById("demoF_Right").innerHTML = p.printAllFcardsToHTMLDiv(fc.getJsonObj());
				
				//fade back in
				$("#demoF_Right").fadeIn(100, function(){
					//$(this).prop('isFadeOut', false);
				});
			});
			
			
		});
		
		//show method
		$("#showUpcoming").click(function(){
			//$("li").show();
			//$("#demoF_Right").fadeOut("slow");
		
			//fade out first
			$("#demoF_Right").fadeOut(100, function(){
				//set a property if want
				//$(this).prop('isFadeOut', true);
				//when done fading out, apply the change
				document.getElementById("demoF_Right").innerHTML =  p.printNextMatchFcards(fc.getJsonObj());
				
				//fade back in
				$("#demoF_Right").fadeIn(100, function(){
					//$(this).prop('isFadeOut', false);
				});
			});
			
			//console.log("clicked show upcoming");
		});
		
		//test panel - can be turned off
		$(".testButton").click(function(){
			console.log("clicked");
			//$(this).hide();
			//console.log("clicked show all");
			//document.getElementById("demoF_Right").innerHTML = ;
		});
		
	});	//end of jquery doc ready
	
});	//end of require
//or
/*
define(function(require) {
    var $        = require('jquery');
    // domReady would be necessary at this point as this module
    // may load before the page is ready
    var domReady = require('domready');
    var Nav      = require('modules/Navigation')
                   require('handlebars');

    domReady(function() {
        // Init common module code here
        new Nav($('#nav'));
    });
});
*/
//above can be written like
/*
define(['jquery', 'handlebars', 'domready', 'modules/Navigation'], function($, Handlebars, domReady, Nav) {
    // etc
});
*/