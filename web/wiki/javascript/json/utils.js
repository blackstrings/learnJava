//using ES6 aks Harmony module pattern
//properties
var id = 12345;
var y = 10;

//one way to do it without have to put the function name into a array export
export function multi(){
	console.log("Mult is called");
	/*
	return function(y){
		
		return x * y;
	};
	*/
};

//another way to put methods into the export
/*
var method2 = function(){
	return "some string";
}
var method3 = function(){
	return "method 3";
}
*/
//another way to put the function into the export
//export { method2, method3 }

