//this method is not dependent on any other modules
define(["app/utils","app/fightClub"],function (utils, fc) {
//if dependen on other moduels use this instead
//define(["app/moduleName", "app/moduleName2"], function(module1, module2){
	//then you can use the modules like: module1.method1();

	var p = {};
	
	p.init = function(){
		//there isn't any just yet
	};//end document ready
	
    //method 1
	p.test = function(){
		return 'print(' + utils.test() + ':' + fc.test() + ')';
	};
	
	p.printLeftNav = function(arr){
		var finalStr = "";
		var startStr = "<ul>";
		var endStr = "</ul>";
		
		var navStr = "";
		
		//generate html string
		for(var i=0; i<arr.length; i++){
			navStr += '<li id="' + arr[i].id + '">' + arr[i].linkName + '</li>';
		}
		
		finalStr += startStr + navStr + endStr;
		return finalStr;
	};
	
	//prints the next upcoming fCards using the date
	p.printNextMatchFcards = function(obj){
	
		var nextMatchDate = fc.getNextMatchDate(obj);
		console.log("next date: " + nextMatchDate);
		var matchId = fc.getMatchIdByMatchDate(nextMatchDate, obj);
		
		
		// WHERE I LEFT OFF **************************************************************************************************************
		
		var divStr = "";
		for(var i in obj.matches){
		
			//get the correct match
			if(matchId == obj.matches[i].matchId){
				
				//print all fcards from the match
				for(var j in obj.matches[i].fCardIds){
					
					divStr += p.printFcardByFcardId(obj.matches[i].fCardIds[j], obj);
					//var fCardId = obj.fcards[index].id;
					
					//str composite
					/*
					divStr += '<div class="fcard">'
					+	'<header>Fight Card: ' + 'fCardId' + 'matchId: ' + obj.matches[i].matchId + 'Date: ' + obj.matches[i].date + '</header>'
					+	'<section class="main">'
					+		'<span class="fighterName">' + "test1" + '</span>'
					+		'<span class="vs"> VS </span>'
					+		'<span class="fighterName">' + "test2" + '</span>'
					+	'</section>'
					+	'<footer>Result: ' + "footer"+ '</footer>'
					+'</div>';
					*/
			
				}
			}
			
		}
		
		return divStr;
	};
	
	p.printFCardsByMatchId= function(matchId, obj){
		
	};
	
	//print fCard by fCardId
	p.printFcardByFcardId= function(fCardId, obj){
		var divStr = "";
		var names = fc.getNamesByFcardId( fCardId, obj);
		var result = fc.getResultByFcardId( fCardId, obj);
		
		divStr += '<div class="fcard">'
		+	'<header>Fight Card: ' + fCardId + '</header>'
		+	'<section class="main">'
		+		'<span class="fighterName">' + names[0] + '</span>'
		+		'<span class="vs"> VS </span>'
		+		'<span class="fighterName">' + names[1] + '</span>'
		+	'</section>'
		+	'<footer>Result: ' + result + '</footer>'
		+'</div>';
		
		return divStr;
	};
	
	//dynmically creating the div per match
	//using the for in loop, the return is an index, not an object
	p.printAllFcardsToHTMLDiv = function(obj){
		var finalStr = "";
		for(var index in obj.fcards){
			var fCardId = obj.fcards[index].id;
			finalStr += p.printFcardByFcardId(fCardId, obj);
		}
		return finalStr;
	};
	
	//print all fcards
	p.printAllFcardsToHTMLString = function(obj){
		var finalStr = "";
	
		for(var i=0; i<obj.fcards.length; i++){
			finalStr += p.printFcardToHTMLStringByFcardId(obj.fcards[i].id, obj);
		}
		return finalStr;
	};
	
	//print on fcard
	p.printFcardToHTMLStringByFcardId = function(fCardId, obj){
		var finalStr = "";
		
		//print fCardId
		finalStr = utils.compositeStrWithColon(finalStr, "Fcard", fCardId);
		
		var names = fc.getNamesByFcardId(fCardId, obj);
		finalStr += utils.arrayToStringWithNewLine(names);
		finalStr += "<br><br>";
		
		return finalStr;	//turn off when done testing
	};
	
	//turn on if you want to see the pretty json in the console
	p.printJsonObjToConsole = function(){
		var objStr = JSON.stringify(fc.getJsonObj(), null, 5);
		console.log(objStr);	
	};
	
	return p;
});