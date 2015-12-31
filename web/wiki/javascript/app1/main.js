//global namespace to prevent conflict naming
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Introduction_to_Object-Oriented_JavaScript
var GAME = GAME || {};

// sub namespace
GAME.utils = {};

//add methods to sub namespace to keep organization
GAME.utils.addOnePlusOne = function(){
	return 1+1;
};


//create container to hold a set of common methods and properties
GAME.commonMethod = {
	isGameOver: false,
	isGameReady: false,
	isDead: function(obj){
		if(obj.isDead())
			return true;
		else
			return false;
	}
};


