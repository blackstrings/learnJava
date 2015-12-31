/*
Just beneath the require.config() is where all our core libraries are required for this page, 
and also any modules that you might want to load and initialise on every page. Keeping it simple again:
*/

//Seeing as we’re just loading these libraries 
//(our modules will actually use them) we can leave the callback empty.
//require(['jquery', 'handlebars'], function() {});
//for jqueryui you don't have to use the ui all packaged is avaialbe. such as autocomplete
require(['jquery', 'jquery-ui/jquery-ui.min', 'app/wikiNav', 'app/wikiUtils'], function ($, ui, nav, utils){	//when you need to init something
//require(function(){ //when you don't need any other required classes
	
	
	$(function(){	// this is the short version of the jquery document.ready()
		
		//anything you want to auto load, do it in here
		
		//wikiNav.test();
		//utils.test();
		
		//display header
		$("#mainNav").html( nav.init('main'));
		
		//searchbox
		var searchBox = '<form id="mainNavForm" >' +
							'<div class="ui-widget" >' +
							'<label for="tags">Search: </label>' +
								'<input id="tags" >' +
							'</div>';
						'</form>';
		
		//display the searchBox
		$("#searchBar").html(searchBox);
		
		//search box autocomplete - load all available navigation tags intot he auto complete data searchBox
		var availableTags = nav.getAllTags();
			$( "#tags" ).autocomplete({
			source: availableTags
		});
		
		/*
		This method handles the jquery autocomplete search bar submission
		On enter, next page will go to the tag's mapped url
		*/
		$("#mainNavForm").submit(function() {
			//for forms use alert to see the test, not console log as the refresh will wipe your log b 4 u can see it
			//alert('You submitted the form!');
			var tagName = $("#tags").val();	//grab input value
			
			var url = nav.getUrlByTagName(tagName);
			
			window.location.href = url;
			return false;	//have to return false
		});
		
		console.log("[module mainNav] loaded - dynamic nav is ready");
		
		//want to auto load something into this id, you can do this with jquery
		//$('#main').html(wikiNav.init());
		
		//test that the modles are working
		//console.log(fc.test());
		//console.log(p.test());
		
		//when document is loaded and ready do the below
		//document.getElementById("demoF_Right").innerHTML = p.printAllFcardsToHTMLDiv(fc.getJsonObj());
		
		
		//TODO -- these should be moved into a controller module
		//events
		//hide method
		/*
		$("#showAll").click(function(){
			//$(this).hide();
			//console.log("clicked show all");
			
			//fade out first
			$("#demoF_Right").fadeOut(100, function(){
				//set a property if want
				$(this).prop('isFadeOut', true);
				//when done fading out, apply the change
				document.getElementById("demoF_Right").innerHTML = p.printAllFcardsToHTMLDiv(fc.getJsonObj());
				
				//fade back in
				$("#demoF_Right").fadeIn(100, function(){
					$(this).prop('isFadeOut', false);
				});
			});
			
			
		});
		*/
		
		//show method
		/*
		$("#showUpcoming").click(function(){
			//$("li").show();
			//$("#demoF_Right").fadeOut("slow");
		
			//fade out first
			$("#demoF_Right").fadeOut(100, function(){
				//set a property if want
				$(this).prop('isFadeOut', true);
				//when done fading out, apply the change
				document.getElementById("demoF_Right").innerHTML =  p.printNextMatchFcards(fc.getJsonObj());
				
				//fade back in
				$("#demoF_Right").fadeIn(100, function(){
					$(this).prop('isFadeOut', false);
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
		*/
		
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