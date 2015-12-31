//should be called only on specific pages
//and after common is called
//wraps the encryption classes
require(['Aes', 'AesCounter'], function (Aes, AesC) {
	console.log("[module encryptors] loaded");
	
	// encryption test
	/*
	var password = 'pass';
	var plaintext = 'plaintext';
	var ciphertext = Aes.Ctr.encrypt(plaintext, password, 256);
	var origtext = Aes.Ctr.decrypt(ciphertext, password, 256);
	
	alert(ciphertext);
	*/
	
	//var result = Aes.cipher("abc", arr2x2);
	//alert(arr2x2);
	
	$(function(){	//on document ready
	
		$('#encryptBtn').click(function(e){
			var ciphertext = Aes.Ctr.encrypt(getTxt(), getPass(), 256);
			$("#displayTxt").val(ciphertext);	//set textarea value
		});
		
		$('#decryptBtn').click(function(e){
			var origTxt = Aes.Ctr.decrypt(getTxt(), getPass(), 256);
			$("#displayTxt").val(origTxt);
		});
		
	});	
	
	//private method only available when called within this file
	function getTxt(){
		var text = $("#incomTxt").val();	////get value from textarea
		return text;
	}
	
	//private method
	function getPass(){
		var pass = $("#incomPass").val();	//get value from textarea
		return pass;
	}
	
	
	
});