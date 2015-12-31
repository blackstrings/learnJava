//global namespace to prevent conflict naming
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Introduction_to_Object-Oriented_JavaScript

// this is how you define a top-level namespace for usage
var MYAPP = MYAPP || {};
//var NEWNAMESPACE = NEWNAMESPACE || {};	// if you want to make more namespaces

// sub namespace utils
MYAPP.utils = {};
//MYAPP.servers = {};	//if you want to make more packages

//add methods to sub namespace to keep organization
MYAPP.utils.addOnePlusOne = function(){
	return 1+1;
};

MYAPP.utils.isOneGreaterThanTwo = function(){
	return 1>2;
};

//create container to hold a set of common methods and properties
MYAPP.commonMethod = {
	property1: "Code",
	property2: 333,
	validateName: function(name){
		return name == "Cool";
	},
	validateOldAge: function(age){
		return age > 65;
	},
	generateRandom: function(){
		var randomNum  = Math.random(5);
		console.log(randomNum);
		return randomNum;
	}
};

//constructor for custom object/class
var Person = function(name, age){
	//these properties will belong to this object when created
	this.name = name;
	this.age = age;
};

Person.prototype.run = function(){
	var str = this.name + " is running.";
	console.log(str);
	return str;
};

Person.prototype.smile = function(){
	//this is a local str variable only in this scope
	var str = this.name + " is smiling.";
	console.log(str);
	return str;
}

//creating Custom object/class
//var person1 = new Person();
//var person2 = new Person();
