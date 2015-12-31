//this module is dependent on utils.js - use a comma if you need to depend on more modules
define(["app/utils"], function (utils) {

	var mod = {};
	
	mod.init=function(){
		//there isn't any just yet
	};//end document ready
	
	mod.test = function(){
		return "fightClub(" + utils.test() + ")";
	};
	
	mod.getJsonObj = function(){
		jsonStr = '{"matches":[{"matchId":10001,"name":"main event","date":20150130,"startTime":"1300","timezone":"pacific","fCardIds":[10001001,10001002,10001003,10001004,10001005]},{"matchId":10002,"name":"main event","date":20150622,"startTime":"0300","timezone":"pacific","fCardIds":[10001001,10001002,10001003]},{"matchId":10003,"name":"main event","date":20150212,"startTime":"2300","timezone":"pacific","fCardIds":[10001001,10001002,10001003]},{"matchId":10004,"name":"main event","date":20150722,"startTime":"2300","timezone":"pacific","fCardIds":[10001001,10001002,10001003]},{"matchId":10005,"name":"main event","date":20150421,"startTime":"1100","timezone":"pacific","fCardIds":[10001002,10001003,10001001,10001003]}],"fcards":[{"id":10001001,"fighterIds":[1001,1002],"w":1001},{"id":10001002,"fighterIds":[1002,1003],"w":1003},{"id":10001003,"fighterIds":[1001,1003],"w":0},{"id":10001004,"fighterIds":[1001,1004],"w":0},{"id":10001005,"fighterIds":[1002,1004],"w":0},{"id":10001006,"fighterIds":[1003,1004],"w":0}],"peoples":[{"id":1001,"fname":"tom","lname":"krome","nname":"bullet proof","w":33,"l":2,"titles":["Toprank","Toprank","AroundTheRank"]},{"id":1002,"fname":"kim","lname":"lop","nname":"silver","w":12,"l":2,"titles":["Toprank","Toprank","AroundTheRank"]},{"id":1003,"fname":"sarah","lname":"utto","nname":"","w":5,"l":3,"titles":["Toprank","Toprank","AroundTheRank"]},{"id":1004,"fname":"Mike","lname":"Monel","nname":"tails","w":1,"l":1,"titles":[]}]}';
		return JSON.parse(jsonStr);
	};
	
	//get all matches' dates
	mod.getAllMatchDates = function(obj){
		//get all matches and their date
		var allMatchDates = [];
		for(var i in obj.matches){
			allMatchDates.push(obj.matches[i].date);
		}
		//console.log("all dates: " + allMatchDates ); //
		return allMatchDates;
	};
	
	//returns dates after todays date
	mod.getMatchDatesAfterTodaysDate = function(allMatchDates){
		//current date in 8 digit num
		var currentDate = utils.getCurrentDateAsEightDigitNumber();
	
		var allDatesAfterTodaysDate = [];
		for(var j in allMatchDates){
			if(allMatchDates[j] >= currentDate){
				allDatesAfterTodaysDate.push(allMatchDates[j]);
			}
		}
		return allDatesAfterTodaysDate;
	};
	
	mod.getNextMatchDate = function(obj){
		var nextMatchDate;
		
		//get all matches and their date
		var allMatchDates = mod.getAllMatchDates(obj);
		
		//get match dates which occurs only after todays date
		var possibleDates = mod.getMatchDatesAfterTodaysDate(allMatchDates);
		
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
	};
	
	//get match id by date
	mod.getMatchIdByMatchDate = function(matchDate, obj){
		for(var i in obj.matches){
			if(obj.matches[i].date == matchDate){
				//console.log("we have a match, matchId: " + obj.matches[i].matchId);
				return obj.matches[i].matchId;
			}
		}
		
	};
	
	//get names by fCardId
	mod.getNamesByFcardId = function(fCardId, obj){
		var fighterIds = mod.getFighterIdsByFcardId(fCardId, obj);
		var names = mod.getNamesByFighterIds(fighterIds, obj);
		return names;
	};
	
	//get result - win/lose status by fCardId
	mod.getResultByFcardId = function(fCardId, obj){
		for(i=0; i<obj.fcards.length; i++){
			if(obj.fcards[i].id == fCardId){
				var result = mod.getNameByFighterId(obj.fcards[i].w, obj, 0);
				if(result == null){
					result = "pending ...";
				}
				return result;
			}
		}
	};
	
	// return a list of names by people ids
	mod.getNamesByFighterIds = function(fighterIds, obj){
		var names = [];
		for(var i=0; i<fighterIds.length; i++){
			names.push( mod.getNameByFighterId(fighterIds[i], obj, 0) );
		}
		return names;
	};
	
	// returns name by people id (id, obj, (0,1,2))
	//0 - use nick name if any or full name
	//1 - use first name
	//2 - use last name
	mod.getNameByFighterId = function(id, obj, filter){
		var fname = "";
		var lname = "";
		var nname = "";
		for(var i=0; i<obj.peoples.length; i++){
			if(obj.peoples[i].id == id){
				fname += utils.capFirstLetter(obj.peoples[i].fname);
				lname += utils.capFirstLetter(obj.peoples[i].lname);
				nname += utils.capFirstLetter(obj.peoples[i].nname);
			}
		}
		
		//use nickname
		if(filter == 0 && !utils.strIsEmptyBlank(nname)){
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
	};
	
	// returns fighter ids from fcards
	mod.getFighterIdsByFcardId = function(fCardId, obj){
		var fighterIds = [];
		var i;
		//get fighter ids from fCard
		for(i=0; i<obj.fcards.length; i++){
			if(obj.fcards[i].id == fCardId){
				for(var j=0; j<obj.fcards[i].fighterIds.length; j++){
					fighterIds.push(obj.fcards[i].fighterIds[j]);
				}
				break;
			}
		}
		return fighterIds;
	};
	
	return mod;
	
	/* old setup design before above was implemented
	function getFighterIdsByFcardId(fCardId, obj){
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
	};
    return {
        test: test,
		getJsonObj: getJsonObj,
		getAllMatchDates: getAllMatchDates
		
    };
	*/
});