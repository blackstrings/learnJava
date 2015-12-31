function drawCanvas1(){
	var sq1Size = 50;
	var canvas1 = document.getElementById("canvas1");	// the id of the canvas element
	var context = canvas1.getContext("2d");	//have to pass in 2d
	
	//rectangle brush
	context.fillStyle = "#ff0000";			
	context.fillRect(0,0,sq1Size,sq1Size);		//draw once
	context.fillRect(10,10,sq1Size,sq1Size);	//draw again
	
	//line brush
	context.moveTo(0,0);
	context.lineTo(200,100);	//(posX, posY)
	context.stroke();
	
	//circle brush
	context.fillStyle = "#ff00ff";			// brush color
	context.beginPath();
	context.arc(100,100,100,0,2*Math.PI);  	//arc(posX, posY, radius, degress
	context.stroke();
	
	//draw text brush
	context.fillStyle = "#ffffff";				// brush color
	context.font = "30px Arial";
	context.fillText("Hello World",150,50);  	//fillText(string, posX, posY);
	
	//stroke/outline text brush
	context.font = "30px Arial";
	context.strokeText("Hello World",10,50); 	//fillText(string, posX, posY);
	
	//draw image
	//var img = document.getElementById("scream");	//img has to exist with id attach to it
	//context.drawImage(img,100,100);
	
	//clear specific canvas
	//context.clearRect(0, 0, canvas1.width, canvas1.height)
}