function createNav()
{
	//links (name,path)
	var links = [
		{ 'name':'Home', 'path':"index.html" },
		{ 'name':'Design-it Applications', 'path':'Design-it.html' },
		{ 'name':'Design-it Frameworks', 'path':'Design-it-frameworks.html' },
		{ 'name':'Service', 'path':'acc.html' }
	];
	
	document.write("<nav id=\"main\">");
	document.write("<ul>");
	
	for(var i in links){
		//console.log(links[i].path);
		//dynamic string
		document.write("<li><a href=\"" + links[i].path + "\">" + links[i].name + "</a></li>");
	}
	
	document.write("</ul>");
	document.write("</nav>");
	
}

