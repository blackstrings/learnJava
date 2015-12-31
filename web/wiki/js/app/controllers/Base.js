define(function(){
	
	var ControllerBase = function ControllerBase(){
		this.init();
	};
	
	ControllerBase.prototype.init = function(){
		//nothing as of yet
	};
	
	ControllerBase.prototype.setNavList = function(arr){
		this.navList = arr;
	}
	
	ControllerBase.prototype.render = function(dom) {
            dom.prepend('<h1> Controller Base Sup!! </h1>');
        }
	
	return ControllerBase;
	
});