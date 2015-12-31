define(['./Base'], function (Base) {
	var controller = new Base();
	
	//set all the config for the controller here
	var navArrayList = [
		{
			"linkName":"Show All", 
			"id":"showAll"
		}, 
		{
			"linkName":"Show Upcoming",
			"id":"showUpcoming"
		}
	];
	controller.setNavList(navArrayList);
	
	return controller;
});