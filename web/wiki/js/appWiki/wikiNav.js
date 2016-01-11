//this method is not dependent on any other modules
define(function () {
//if dependent on other moduels use this instead
//define(["app/moduleName", "app/moduleName2"], function(module1, module2){
	//then you can use the modules like: module1.method1();

	var mod = {};
	
    //method 1
	mod.test = function(){
		console.log("wiki nav test working");
		return "nav()";
	};
	
	//public
	mod.init = function(param) {

		if( param === 'main'){
			return createMainNav();
		}else if(param === 'tags'){
			var categoryLists = getCategoryList();
			if(categoryLists != null && categoryLists.length > 0){
				return createSectionForLists(categoryLists);
			}else{
				console.log("category list is null");
				return "categoryList was null";
			}
		}
	};
	
	//private
	function createMainNav() {
	
		finalStr = "";
		
		//links (name,path)
		var links = [
			{ 'name':'Home', 'path':"index.html" },
			{ 'name':'Service', 'path':'acc.html' }
		];
		
		finalStr += "<nav>";
		finalStr += "<ul>";
		
		for(var i in links){
			//console.log(links[i].path);
			//dynamic string
			finalStr += "<li><a href=\"" + links[i].path + "\">" + links[i].name + "</a></li>";
		}
		
		finalStr += "</ul>";
		finalStr += "</nav>";
		
		return finalStr;
	}
			
	//private
	function getCategoryList(){
		return categoryLists = 
		[ 	
			{
				"catName":"Applications",
				"links": [
					{ "name": "Deck", "path": "deck.html", "dob":2000, "type":"standalone", "lang":"java"},
					{ "name": "Flooring", "path": "flooring.html", "dob":2000, "type":"standalone", "lang":"java"},
					{ "name": "Flooring Visualizer", "path": "landscaping-visualizer.html", "dob":2000, "type":"standalone", "lang":"java"},
					{ "name": "Landscape", "path": "landscaping.html", "dob":2000, "type":"standalone", "lang":"java"},
					{ "name": "Siding", "path": "siding.html", "dob":2000, "type":"webapp", "lang":"java"},
					{ "name": "Roofing", "path": "roofing.html", "dob":2000, "type":"webapp", "lang":"java"},
					{ "name": "Gutter", "path": "gutter.html", "dob":2000, "type":"webapp", "lang":"java"},
					{ "name": "Shelving", "path": "shelving.html", "dob":2015, "type":"webapp", "lang":"javascript"},
					{ "name": "Garage", "path": "garage.html", "dob":1990, "type":"standalone", "lang":"c++"},
					{ "name": "Residential Post Frame", "path": "residential-postframe.html.html", "dob":1990, "type":"standalone", "lang":"c++"},
					{ "name": "Yard Building", "path": "yard.html", "dob":1990, "type":"standalone", "lang":"c++"},
					{ "name": "Fence", "path": "fence.html", "dob":1990, "type":"standalone", "lang":"c++"},
					{ "name": "Foundation", "path": "foundation.html", "dob":1990, "type":"standalone"},
					{ "name": "Polebarn", "path": "polebarn.html", "dob":1990, "type":"standalone", "lang":"c++"}
				]
			},
			{
				"catName":"App Misc",
				"links": [
					{ "name": "Environment Pointing", "path": "environment.html"},
					{ "name": "App Estimation Overview", "path": "estimation.html"},
					{ "name": "Building Apps", "path": "buildingApps.html"},
					{ "name": "App Updates - News - FYI", "path": "appUpdates.html"},
					{ "name": "GIM (Save and Recall)", "path": "saveandrecall.html"}
				]
			},
			{
				"catName":"Redmine Process",
				"links": [
					{ "name": "Bugfix", "path": "bugfix.html"}
				]
			},
			{
				"catName":"Internal Tools",
				"links": [
					{ "name": "Visual Studio Community 2015 (IDE) [c++ & c#]", "path": "visualstudio.html"},
					{ "name": "Eclipse (IDE) [java]", "path": "eclipse.html"},
					{ "name": "NotePad++", "path": "notepad.html"},
					{ "name": "GIT", "path": "git.html"},
					{ "name": "TortiseSVN", "path": "svn.html"},
					{ "name": "HeidiSQL", "path": "heidiSQL.html"},
					{ "name": "Wintail", "path": "wintail.html"},
					{ "name": "Balsamiq", "path": "balsamiq.html"},
					{ "name": "Blender", "path": "blender.html"},
					{ "name": "Maya", "path": "maya.html"},
					{ "name": "GIMP", "path": "gimp.html"},
					{ "name": "SketchUp", "path": "sketchup.html"},
					{ "name": "Unity", "path": "unity.html"},
					{ "name": "Dynatrace", "path": "dynatrace.html"},
					{ "name": "EvnSetter (environment)", "path": "evnsetter.html"}
						
				]
			},
			{
				"catName":"External Online Tools",
				"links": [
					{ "name": "PreEmptive", "path": "preemptive.html" },
					{ "name": "Redmine", "path": "redmine.html"},
					{ "name": "Code Collaborator", "path": "cc.html"},
					{ "name": "Code Review (Fisheye + Crucible)", "path": "codereview.html"},
					{ "name": "RQM", "path": "rqm.html"},
					{ "name": "FindBug", "path": "findbugs.html"},
					{ "name": "Jenkins", "path": "jenkins.html"},
					{ "name": "EAM", "path": "eam.html"},
					{ "name": "True Sight (real user analyzer) SLA", "path": "truesight.html"},
					{ "name": "Veracode scan", "path": "veracode.html"},
					{ "name": "Nexus build server", "path": "nexus.html"},
					{ "name": "Avetti", "path": "avetti.html"}
						
				]
			},
			{
				"catName":"Tasks",
				"links": [
					{ "name": "SLA", "path": "sla.html"},
					{ "name": "Store Testing", "path": "storetesting.html"},
					{ "name": "On Call", "path": "oncall.html"},
					{ "name": "Night & Patch Testing", "path": "nightTesting.html"},
					{ "name": "Bare Metal", "path": "baremetal.html"},
					{ "name": "Lab Testing (app)", "path": "labtesting.html"},
					{ "name": "RQM Test Plan", "path": "rqmtestplan.html"},
					{ "name": "Store Support", "path": "storesupport.html"},
					{ "name": "Accessing Database", "path": "database.html"},
				]
			},
			{
				"catName":"Terms",
				"links": [
					{ "name": "MCR", "path": "mcr.html"},
					{ "name": "DMR", "path": "#a"},
					{ "name": "Goals", "path": "goals.html"},
					{ "name": "SCRUM", "path": "scrum.html"},
					{ "name": "Webstart", "path": "webstart.html"},
					{ "name": "Release Managers", "path": "releaseManagers.html"},
					{ "name": "Network (Networking, DNS)", "path": "network.html"},
					{ "name": "EFU (Testing)", "path": "efu.html"}
				]
			},
			{
				"catName":"Programming Languages",
				"links": [
					{ "name": "Java", "path": "java.html"},
					{ "name": "C++", "path": "cpp.html"},
					{ "name": "JSP Webapps", "path": "webapps.html"},
					{ "name": "JSTL (Java Server Pages Standard Library)", "path": "jstl.html"},
					{ "name": "Javascript", "path": "javascript.html"},
					{ "name": "Jquery", "path": "jquery.html"},
					{ "name": "RequireJS", "path": "requirejs.html"},
					{ "name": "HTML5", "path": "html5.html"},
					{ "name": "JSON", "path": "json.html"},
					{ "name": "Aspect Oriented Programming (AOP)", "path": "aop.html"},
					{ "name": "LUA", "path": "lua.html"},
					{ "name": "Three JS (3d)", "path": "threeJS.html"},
					{ "name": "C# (csharp)", "path": "csharp.html"}
				]
			},
			{
				"catName":"Design Patterns",
				"links": [
					{ "name": "Domain Driven Design (DDD)", "path": "ddd.html"},
					{ "name": "Architecture Designs", "path": "architecture.html"}
				]
			},
			{
				"catName":"Plugins",
				"links": [
					{ "name": "JimGUI", "path": "jimGui.html"},
					{ "name": "Maven", "path": "maven.html"},
					{"name": "JUnit", "path": "junit.html" },
					{ "name": "Mockito", "path": "mockito.html"}
				]
			},
			{
				"catName":"In-House Frameworks",
				"links": [
					{ "name": "Mentools", "path": "mentools.html"},
					{ "name": "MenCache", "path": "#a"},
					{ "name": "Design-It Config", "path": "designitConfig.html"},
					{ "name": "Byte Array Processor", "path": "bytearrayprocessor.html"},
					{ "name": "Pattern Editor", "path": "patternEditor.html"},
					{ "name": "REAF", "path": "reaf.html"},
					{ "name": "3D Java (three)", "path": "threeD.html"}
				]
			},
			{
				"catName":"Servers",
				"links": [
					{ "name": "Server Statuses", "path": "serverstatus.html"},
					{ "name": "Altiris", "path": "altiris.html"},
					{ "name": "BuildServer", "path": "buildserver.html"},
					{ "name": "JBoss", "path": "jboss.html"},
					{ "name": "MCOM (Menards.com)", "path": "mcom.html"},
					{ "name": "System V", "path": "systemv.html"},
					{ "name": "TCServer (Tomcat Tom Cat)", "path": "tcserver.html"}
				]
			},
			{
				"catName":"Misc",
				"links": [
					{ "name": "Team", "path": "team.html"},
					{ "name": "DNS", "path": "dns.html"},
					{ "name": "FTP", "path": "ftp.html"},
					{ "name": "POM (Project Object Model)", "path": "pom.html"},
					{ "name": "INI", "path": "ini.html"},
					{ "name": "F & T Drives", "path": "drives.html"},
					{ "name": "JAR", "path": "jar.html"},
					{ "name": "Logs", "path": "logs.html"},
					{ "name": "Command Line", "path": "commandline.html"},
					{ "name": "Time Log", "path": "timelog.html"},
					{ "name": "Wifi", "path": "wifi.html"},
					{ "name": "Phone Call Handling", "path": "phonecall.html"},
					{ "name": "Send Email", "path": "sendEmail.html"},
				]
			}
		];
	};
	
	//public - return all names to use for tags
	mod.getAllTags = function() { 
		var categoryLists = getCategoryList();	// to popuate categoryList
		
		var tagNames = [];
		if(categoryLists != null && categoryLists.length > 0){
			for(var i in categoryLists){
				for(var j in categoryLists[i].links){
					tagNames.push(categoryLists[i].links[j].name);
				}
			}
		}
		
		return tagNames;
	};
	
	//public
	mod.getUrlByTagName = function(tagName){
		var url = "";
		
		var categoryLists = getCategoryList();
		
		if(categoryLists != null && categoryLists.length > 0){
			for(var i in categoryLists){
				for(var j in categoryLists[i].links){
					if(categoryLists[i].links[j].name.toLowerCase() === tagName.toLowerCase()){	//lowercase for non-case sensitive
						url = categoryLists[i].links[j].path;
						break;
					}
				}
			}
		}
		
		return url;
	};
	
	//private
	function createSectionForLists(lists){
		var finalStr = "";
		for(var i in lists){
			finalStr += createSectionByList(lists[i]);
		}
		return finalStr;
	};
	
	//private section
	function createSectionByList(categoryList){
		
		//sort from by name from a-z
		categoryList.links.sort(sortBy('name', false, function(a){return a.toUpperCase()} ));
		
		var finalStr = "";
		var listStr = "";
		var sectionHeader = "<h1>" + categoryList.catName + "</h1>";
		var strStart = "<section class='category'>" + sectionHeader;
		var strEnd = "</section>";
		
		//iterate through each link inside the list
		listStr += "<ul>";
		for(var i in categoryList.links){
			listStr += createHTMLListPerLink(categoryList.links[i]);
		}
		listStr += "</ul>";
		
		finalStr += strStart + listStr + strEnd;
		
		return finalStr;
		
	};
	
	//private - create link
	function createHTMLListPerLink(obj){

		var finalStr = "<li><a href=\"" + obj.path + "\">" + obj.name + "</a></li>";
		
		return finalStr;
		
	};
	
	//private sort by num or letters
	function sortBy(field, reverse, primer){

	   var key = primer ? 
		   function(x) {return primer(x[field])} : 
		   function(x) {return x[field]};

	   reverse = !reverse ? 1 : -1;

	   return function (a, b) {
		   return a = key(a), b = key(b), reverse * ((a > b) - (b > a));
		 } 
	};
	
	return mod;
});