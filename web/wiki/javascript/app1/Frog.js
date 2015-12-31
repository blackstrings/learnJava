//constructor for custom object/class
var Frog = function(name, hp){
	//these properties will belong to this object when created
	this.name = name;
	this.hp = hp;
};

Frog.prototype.getHp = function(){
	return this.hp;
};
Frog.prototype.setHp = function(hp){
	this.hp = hp;
};
Frog.prototype.getHp = function(hp){
	this.hp += hp;
};


//creating Custom object/class
//var person1 = new Person();
//var person2 = new Person();