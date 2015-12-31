// A cross-browser requestAnimationFrame
// See https://hacks.mozilla.org/2011/08/animating-with-javascript-from-setinterval-to-requestanimationframe/
// these are the framerate methods, what's happening here is that if none of the animation methods are supported
// the last one will be called which is setTimeOut() -- this is a last resort method and least you want to use according to other sources
var requestAnimFrame = (function(){
    return window.requestAnimationFrame       ||
        window.webkitRequestAnimationFrame ||
        window.mozRequestAnimationFrame    ||
        window.oRequestAnimationFrame      ||
        window.msRequestAnimationFrame     ||
        function(callback){
            window.setTimeout(callback, 1000 / 60);
        };
})();

//create the canvas
//var canvas = document.createElement("canvas");
var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");
canvas.width = 300;
canvas.height =30;
ctx.fillStyle="#000000";
ctx.fillRect(0,0,canvas.width, canvas.height);
document.body.appendChild(canvas);

// The main game loop
var lastTime;
function main() {
    var now = Date.now();
    var dt = (now - lastTime) / 1000.0;

    update(dt);
    render();

    lastTime = now;
	requestAnimFrame(main);
};

//main init method
function init() {
    lastTime = Date.now();
    main();
}
//force start app or let something trigger such as after all loading is done, trigger the init
init();

var counter = 0;
var goLeft = false;
var counterTxt = "";
var distX = 0;

//update
function update(dt){
	//anything data that needs to get updated should be implemented here
	
	//Cube
	var speed = 50;
	
	if(counter <= 0){
		goLeft = false;
	}else if(counter >= canvas.width){
		goLeft = true;
	}
	
	if(goLeft){
		speed = -speed;
		counter--;
		
	}else if(!goLeft){
		speed = speed;
		counter++;
	}
	
	distX += speed * dt;  //move left
}

//after update takes place, render the new data
function render(){
	
	//clear canvas at start of every new frame
	ctx.fillStyle = "#000000";	//black bg
	ctx.fillRect(0,0, canvas.width, canvas.height);	//best way to clear the canvas
	
	//render text
	ctx.fillStyle = "#eeff00";				// brush color
	ctx.font = "10px Arial";
	counterText = "Counter: " + counter;
	ctx.fillText(counterText,0,10);  	//fillText(string, posX, posY);
	
	//render the sprite
	ctx.fillStyle = "#FF0000";
	ctx.fillRect(distX, 10, 10,10);
	
}