define(["app/fightClub"],function(fc){
	
	//private properties
	//these properties will belong to this object when created
	var _fCardId = 0;
	//don't init array variables if you are not going to be pushing in data, 
	//but instead you are planning to set the variable to a new array
	var _fighterIds;
	var _fighterNames;
	var _obj = null;
	
	//constructor
	var FightCard = function FightCard(fCardId, obj){
		this.init(fCardId, obj);
	};
	
	//constructor init - assign the values to the private variables for later accessing them within the obj
	FightCard.prototype.init=function(fCardId, obj) {
      _fCardId = _fCardId 			|| fCardId;
	  _obj = _obj 					|| obj;
      _fighterIds = _fighterIds  	|| fc.getFighterIdsByFcardId(_fCardId, _obj);
	  _fighterNames = _fighterNames || fc.getNamesByFighterIds(_fighterIds, _obj);
	  _obj = _obj 					|| obj;
    };
	//if (arguments.length) this.init(fCardId, obj);	//run it
	
	//public properties no accessors required
	this.type = "fight card";
	
	//public methods get/set
	FightCard.prototype.getFCardId = function() { 
		return _fCardId; 
	};
	//another way to do setters/getters for minimizing lines
	FightCard.prototype.setFCardId = function(fCardId) { _fCardId = fCardId;  }; 
	FightCard.prototype.getFighterIds = function() {  return _fighterIds;  };
	FightCard.prototype.getFighterNames = function() {  return _fighterNames;  };
	
	//private methods -- meaning these methods cannot be called on the class and can only be called in here only
	function privateMethod(){
		return "I am private method";
	};
	//public method that calls the private function above
	FightCard.prototype.callPrivateMethod = function(){
		return privateMethod();
	};
	
	return FightCard;
});