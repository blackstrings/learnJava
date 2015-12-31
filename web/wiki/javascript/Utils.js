//Test function to ensure file is loaded
function Utils_test(){
	document.write("Hello from Utils.js");
}

//helps create a table from a passed in 2D array and header array
//also makes the first column a hyperlink
function Utils_display2dDataWithLink(data2D, headers){
	
	//############## - print header row
	document.write("<tr>");
	for(headerCount=0; headerCount<headers.length; headerCount++){
		document.write("<th>" + headers[headerCount] + "</th>");
	}
	document.write("</tr>");
	
	
	// url link str
	var str1 = "<a href=\"";
	var str2 = "\" target=\"_blank\">";
	
	var str3 = "</a>";
	
	var size = data2D.length;	
	
	// to get size of inner array
	// var size = data2D[0].length;

	// get the first element in the 2Darray, then find it's length
	// that will determine how many col we have in each row
	var totalColOfData = data2D[0].length;
	
	// data2D has one too many than we need due to url link
	// so we need one less than total data2D size
	// for itertaion purpose, we want
	// one less than the totalColData from data2D
	totalColOfData--;	
	
	//################ - print data2D rows
	for(row=0; row<size; row++){
		
		//each row
		document.write("<tr>");
		
		for(col=0; col < totalColOfData; col++){
			
			//col 1
			if(col == 0){
				// we only want col 1 to have a link
				document.write("<td>" 
				+ str1 
				+ data2D[row][col+1] // name
				+ str2 
				+ data2D[row][col] // link
				+ str3 
				+ "</td>");
				
			}else{	// for col 2 and so on... we don't want links
			
				document.write("<td>" + data2D[row][col+1] + "</td>");
			
			}
			
		}
		
		document.write("</tr>");
	}
	
}

function getMainWebTitle()
{
	return "Wiki - "; 
	//document.write("Wiki - ");
		
}

