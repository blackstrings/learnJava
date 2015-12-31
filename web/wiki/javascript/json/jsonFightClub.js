//global namespace to prevent conflict naming
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Introduction_to_Object-Oriented_JavaScript
// http://addyosmani.com/blog/essential-js-namespacing/

//** object literal notation though is an older way to manage modules or classes -- use require.js for a better way to handle modules

//namespace is important as it prevents conflicts with other third party methods that have the same name as your functions
//there are many ways to setup namespace naming patterns for you application, below a few advance examples

// this is how you define a top-level namespace for usage
// var namespace = namespace || {};
var fightClub = fightClub || {};		//fightClub namespace

// a named immediately-invoked function expression (IIFE), these type of function invokes itself immediately after being defined
(function foobar(){ /*..*/}());

// sub namespace packages
fightClub.utils = {};
//fightClub.print = {};
//-------------------------
//fightClub.common = {};
//fightClub.server = {};
//fightClub.data = {};

//before you can use the design pattern below for namespace, you must define the above first, ex: fightClub.utils = {};
fightClub.utils.capFirstLetter = function(str){
	return str.charAt(0).toUpperCase() + str.slice(1);	//slice returns the index to slice out and returns the remaining
};

//comp str
fightClub.utils.compositeStrWithColon = function(finalStr, str2, str3){
	return finalStr += str2 + " : " + str3 + "<br>";
};

//convert array element into strings
fightClub.utils.arrayToStringWithNewLine = function(arr){
	var str = "";
	for(var i=0; i<arr.length; i++){
		str += arr[i] + "<br>";
	}
	return str;
};
//cap first letter
fightClub.utils.capFirstLetter = function(str){
	return str.charAt(0).toUpperCase() + str.slice(1);
};
//today's date in pretty format
fightClub.utils.getTodaysDate = function(){
	return new Date().toJSON().slice(0,10).toString();
};
//converts 1 digit into 2 digit if less than 10
fightClub.utils.convertToTwoDigit = function(num){
	if(num == 0){
		console.log("error: number is zero");
	}else if(num < 10){
		return "0" + num;
	}else{
		return num;
	}
};
fightClub.utils.getCurrentDateAsEightDigitNumber = function(){
	var currentDate = new Date();
	var day = fightClub.utils.convertToTwoDigit( currentDate.getDate() );
	var month = fightClub.utils.convertToTwoDigit( currentDate.getMonth() + 1);
	var year = currentDate.getFullYear();
	
	//convert current date into a 8 digit number, should get something like 20150320
	return year.toString() + month.toString() + day.toString();
	//console.log(currentDateToInt + " : " + (currentDateToInt > 20150316));
};
fightClub.utils.strIsEmptyBlank = function(str){
	var isEmpty = (!str || 0 === str.length);
	var isBlank = /^\s*$/.test(str);
	return isEmpty && isBlank;
};

//Object literal notation pattern for namespace naming - same setup as Json structure
//with this method you have to put a comma after every function or property
//create container to hold a set of common methods and properties

//--------------- PRINTS ---------------//
fightClub.print = {
	//define properties
	property1: "Code",
	property2: 333,
	generateRandom: function(){
		var randomNum  = Math.random(5);
		//console.log(randomNum);
		return randomNum;
	},
	//left navigation string
	//takes in json array
	printLeftNav: function(arr){
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
	},
	//prints the next upcoming fCards using the date
	printNextMatchFcards: function(obj){
	
		var nextMatchDate = fightClub.commonMethods.getNextMatchDate(obj);
		console.log("next date: " + nextMatchDate);
		var matchId = fightClub.commonMethods.getMatchIdByMatchDate(nextMatchDate, obj);
		
		
		// WHERE I LEFT OFF **************************************************************************************************************
		
		var divStr = "";
		for(var i in obj.matches){
		
			//get the correct match
			if(matchId == obj.matches[i].matchId){
				
				//print all fcards from the match
				for(var j in obj.matches[i].fCardIds){
					
					divStr += fightClub.print.printFcardByFcardId(obj.matches[i].fCardIds[j], obj);
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
	},
	printFCardsByMatchId: function(matchId, obj){
		
	},
	//print fCard by fCardId
	printFcardByFcardId: function(fCardId, obj){
		var divStr = "";
		var names = fightClub.commonMethods.getNamesByFcardId( fCardId, obj);
		var result = fightClub.commonMethods.getResultByFcardId( fCardId, obj);
		
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
	},
	//dynmically creating the div per match
	//using the for in loop, the return is an index, not an object
	printAllFcardsToHTMLDiv: function(obj){
		var finalStr = "";
		for(var index in obj.fcards){
			var fCardId = obj.fcards[index].id;
			finalStr += fightClub.print.printFcardByFcardId(fCardId, obj);
		}
		return finalStr;
	},
	//print all fcards
	printAllFcardsToHTMLString: function(obj){
		var finalStr = "";
	
		for(var i=0; i<obj.fcards.length; i++){
			finalStr += fightClub.print.printFcardToHTMLStringByFcardId(obj.fcards[i].id, obj);
		}
		return finalStr;
	},
	//print on fcard
	printFcardToHTMLStringByFcardId: function(fCardId, obj){
		var finalStr = "";
		
		//print fCardId
		finalStr = fightClub.utils.compositeStrWithColon(finalStr, "Fcard", fCardId);
		
		var names = fightClub.commonMethods.getNamesByFcardId(fCardId, obj);
		finalStr += fightClub.utils.arrayToStringWithNewLine(names);
		finalStr += "<br><br>";
		
		return finalStr;	//turn off when done testing
	},
	//turn on if you want to see the pretty json in the console
	printJsonObjToConsole: function(){
		var objStr = JSON.stringify(fightClub.commonMethods.getJsonObj(), null, 5);
		console.log(objStr);	
	}
};

//--------------- COMMON METHODS ---------------//
fightClub.commonMethods = {
	jsonStr : '{"matches":[{"matchId":10001,"name":"main event","date":20150130,"startTime":"1300","timezone":"pacific","fCardIds":[10001001,10001002,10001003,10001004,10001005]},{"matchId":10002,"name":"main event","date":20150622,"startTime":"0300","timezone":"pacific","fCardIds":[10001001,10001002,10001003]},{"matchId":10003,"name":"main event","date":20150212,"startTime":"2300","timezone":"pacific","fCardIds":[10001001,10001002,10001003]},{"matchId":10004,"name":"main event","date":20150722,"startTime":"2300","timezone":"pacific","fCardIds":[10001001,10001002,10001003]},{"matchId":10005,"name":"main event","date":20150421,"startTime":"1100","timezone":"pacific","fCardIds":[10001002,10001003,10001001,10001003]}],"fcards":[{"id":10001001,"fighterIds":[1001,1002],"w":1001},{"id":10001002,"fighterIds":[1002,1003],"w":1003},{"id":10001003,"fighterIds":[1001,1003],"w":0},{"id":10001004,"fighterIds":[1001,1004],"w":0},{"id":10001005,"fighterIds":[1002,1004],"w":0},{"id":10001006,"fighterIds":[1003,1004],"w":0}],"peoples":[{"id":1001,"fname":"tom","lname":"krome","nname":"bullet proof","w":33,"l":2,"titles":["Toprank","Toprank","AroundTheRank"]},{"id":1002,"fname":"kim","lname":"lop","nname":"silver","w":12,"l":2,"titles":["Toprank","Toprank","AroundTheRank"]},{"id":1003,"fname":"sarah","lname":"utto","nname":"","w":5,"l":3,"titles":["Toprank","Toprank","AroundTheRank"]},{"id":1004,"fname":"Mike","lname":"Monel","nname":"tails","w":1,"l":1,"titles":[]}]}',
	getJsonObj: function(){
		return JSON.parse(fightClub.commonMethods.jsonStr);
	},
	//get all matches' dates
	getAllMatchDates: function(obj){
		//get all matches and their date
		var allMatchDates = [];
		for(var i in obj.matches){
			allMatchDates.push(obj.matches[i].date);
		}
		console.log("all dates: " + allMatchDates );
		return allMatchDates;
	},
	//returns dates after todays date
	getMatchDatesAfterTodaysDate: function(allMatchDates){
		//current date in 8 digit num
		var currentDate = fightClub.utils.getCurrentDateAsEightDigitNumber();
	
		var allDatesAfterTodaysDate = [];
		for(var j in allMatchDates){
			if(allMatchDates[j] >= currentDate){
				allDatesAfterTodaysDate.push(allMatchDates[j]);
			}
		}
		return allDatesAfterTodaysDate;
	},
	getNextMatchDate: function(obj){
		var nextMatchDate;
		
		//get all matches and their date
		var allMatchDates = fightClub.commonMethods.getAllMatchDates(obj);
		
		//get match dates which occurs only after todays date
		var possibleDates = fightClub.commonMethods.getMatchDatesAfterTodaysDate(allMatchDates);
		
		//if not null, get the next match date
		if(possibleDates.length > 0){
			//console.log("possible dates: " + possibleDates );
			possibleDates.sort();	// so we get order from lowest to highest
			//console.log("sorted possible dates: " + possibleDates );
			
			//grab the earliest next match date, after the sort, the first index should be the next match date
			nextMatchDate = possibleDates[0];	
		}else{
			//check for null
			nextMatchDate = 0;
			console.log("no future match date exist or has been set in the data base, returning zero");
		}
		return nextMatchDate;
	},
	getMatchIdByMatchDate: function(matchDate, obj){
		for(var i in obj.matches){
			if(obj.matches[i].date == matchDate){
				//console.log("we have a match, matchId: " + obj.matches[i].matchId);
				return obj.matches[i].matchId;
			}
		}
		
	},
	//get names by fCardId
	getNamesByFcardId: function(fCardId, obj){
		var fighterIds = fightClub.commonMethods.getFighterIdsByFcardId(fCardId, obj);
		var names = fightClub.commonMethods.getNamesByFighterIds(fighterIds, obj);
		return names;
	},
	//get result - win/lose status by fCardId
	getResultByFcardId: function(fCardId, obj){
		for(i=0; i<obj.fcards.length; i++){
			if(obj.fcards[i].id == fCardId){
				var result = fightClub.commonMethods.getNameByFighterId(obj.fcards[i].w, obj, 0);
				if(result == null){
					result = "pending ...";
				}
				return result;
			}
		}
	},
	// return a list of names by people ids
	getNamesByFighterIds: function(fighterIds, obj){
		var names = [];
		for(var i=0; i<fighterIds.length; i++){
			names.push( fightClub.commonMethods.getNameByFighterId(fighterIds[i], obj, 0) );
		}
		return names;
	},
	// returns name by people id (id, obj, (0,1,2))
	//0 - use nick name if any or full name
	//1 - use first name
	//2 - use last name
	getNameByFighterId: function(id, obj, filter){
		var fname = "";
		var lname = "";
		var nname = "";
		for(var i=0; i<obj.peoples.length; i++){
			if(obj.peoples[i].id == id){
				fname += fightClub.utils.capFirstLetter(obj.peoples[i].fname);
				lname += fightClub.utils.capFirstLetter(obj.peoples[i].lname);
				nname += fightClub.utils.capFirstLetter(obj.peoples[i].nname);
			}
		}
		
		//use nickname
		if(filter == 0 && !fightClub.utils.strIsEmptyBlank(nname)){
			return nname;
		//use full name
		}else if(filter == 0){
			return fname + " " + lname;
		//use first name
		}else if(filter == 1){
			return fname;
		//use last name
		}else if(filter == 2){
			return lname;
		}
	},
	// returns people ids from fcards
	getFighterIdsByFcardId: function(fCardId, obj){
		var fighterIds = [];
		var i;
		//get people ids of fCard
		for(i=0; i<obj.fcards.length; i++){
			if(obj.fcards[i].id == fCardId){
				for(var j=0; j<obj.fcards[i].fighterIds.length; j++){
					fighterIds.push(obj.fcards[i].fighterIds[j]);
				}
				break;
			}
		}
		return fighterIds;
	}
};

//classes
//constructor for custom object/class
var FCard = function(fCardId, obj){
	
	//private properties
	//these properties will belong to this object when created
	var _fCardId = 0;
	//don't init array variables if you are not going to be pushing in data, 
	//but instead you are planning to set the variable to a new array
	var _fighterIds;
	var _fighterNames;
	var _obj = null;
	
	//constructor init
	this.init = function(fCardId, obj) {
      _fCardId = _fCardId 			|| fCardId;
	  _obj = _obj 					|| obj;
      _fighterIds = _fighterIds  	|| fightClub.commonMethods.getFighterIdsByFcardId(_fCardId, _obj);
	  _fighterNames = _fighterNames || fightClub.commonMethods.getNamesByFighterIds(_fighterIds, _obj);
	  _obj = _obj 					|| obj;
    };
	if (arguments.length) this.init(fCardId, obj);	//run it
	
	//public properties no accessors required
	this.type = "fight card";
	
	//public methods get/set
	this.getFCardId = function() { 
		return _fCardId; 
	};
	//another way to do setters/getters for minimizing lines
	this.setFCardId = function(fCardId) { _fCardId = fCardId;  }; 
	this.getFighterIds = function() {  return _fighterIds;  };
	this.getFighterNames = function() {  return _fighterNames;  };
	
	//private methods -- meaning these methods cannot be called on the class and can only be called in here only
	function privateMethod(){
		return "I am private method";
	};
	//public method that calls the private function above
	this.callPrivateMethod = function(){
		return privateMethod();
	}
	
	
};

FCard.prototype.method1 = function(){
	//dosomething
};

FCard.prototype.method2 = function(){
	//return something
}

//creating Custom object/class
//var person1 = new Person();
//var person2 = new Person();
