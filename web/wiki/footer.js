// Variables
var startYear = 2014;

var date = new Date();
var currentYear = date.getFullYear()


function createFooter()
{
	document.write("<footer id=\"main\">");
	
	document.write("Copyright &copy; " + startYear + " - " + currentYear);
	
	document.write("</footer>");
}
