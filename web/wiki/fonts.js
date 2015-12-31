//simply call this method, and the font will load automatically at the start of the page
function getGoogleFonts(){

  WebFontConfig = {
    google: { families: [ 'Open Sans', 'sans-serif' ] }
  };
	// 'Roboto+Condensed::latin'
		// font-family: 'Roboto Condensed', 'sans-serif';
	// 'Dosis::latin'
		// font-family: 'Dosis', 'sans-serif';
	// 'Montserrat::latin'
		// font-family: 'Montserrat', 'sans-serif';
	//	'Open Sans', 'sans-serif'
		// font-family: 'Open Sans', 'sans-serif';
  (function() {
    var wf = document.createElement('script');
    wf.src = ('https:' == document.location.protocol ? 'https' : 'http') +
      '://ajax.googleapis.com/ajax/libs/webfont/1/webfont.js';
    wf.type = 'text/javascript';
    wf.async = 'true';
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(wf, s);
  })();


}