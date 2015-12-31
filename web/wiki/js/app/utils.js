//this method is not dependent on any other modules
define(function () {
//if dependent on other moduels use this instead
//define(["app/moduleName", "app/moduleName2"], function(module1, module2){
	//then you can use the modules like: module1.method1();

	var mod = {};
	
	mod.init=function(){
		//there isn't any just yet
	};//end document ready
	
    //method 1
	mod.test = function(){
		return "utils()";
	};
	
	//convert array element into strings
	mod.arrayToStringWithNewLine = function(arr){
		var str = "";
		for(var i=0; i<arr.length; i++){
			str += arr[i] + "<br>";
		}
		return str;
	};
	
	//cap first letter
	mod.capFirstLetter = function(str){
		return str.charAt(0).toUpperCase() + str.slice(1);
	};
	
	//today's date in pretty format
	mod.getTodaysDate = function(){
		return new Date().toJSON().slice(0,10).toString();
	};
	
	//converts 1 digit into 2 digit if less than 10
	mod.convertToTwoDigit = function(num){
		if(num == 0){
			console.log("error: number is zero");
		}else if(num < 10){
			return "0" + num;
		}else{
			return num;
		}
	};
	
	//convert date to 8 digit
	mod.getCurrentDateAsEightDigitNumber = function(){
		var currentDate = new Date();
		var day = mod.convertToTwoDigit( currentDate.getDate() );
		var month = mod.convertToTwoDigit( currentDate.getMonth() + 1);
		var year = currentDate.getFullYear();
		
		//convert current date into a 8 digit number, should get something like 20150320
		return year.toString() + month.toString() + day.toString();
		//console.log(currentDateToInt + " : " + (currentDateToInt > 20150316));
	};
	
	//check if empty str
	mod.strIsEmptyBlank = function(str){
		var isEmpty = (!str || 0 === str.length);
		var isBlank = /^\s*$/.test(str);
		return isEmpty && isBlank;
	};
	
	/*
	return {
		//you have to return every function that's listed above if it is AMD, wich most liekly they are
		test: test,
		arrayToStringWithNewLine: arrayToStringWithNewLine,
		capFirstLetter: capFirstLetter	,
		getTodaysDate: getTodaysDate,
		convertToTwoDigit: convertToTwoDigit,
		convertToTwoDigit: convertToTwoDigit,
		getCurrentDateAsEightDigitNumber: getCurrentDateAsEightDigitNumber,
		strIsEmptyBlank: strIsEmptyBlank
    };
	*/
	
	return mod;
});