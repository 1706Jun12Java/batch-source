/**
 * 
 */
function colorSelect(){
		var oldColor = document.getElementByName("favoriteColor").value;
		if (document.getElementByName("favoriteColor").checked) {
			  var newColor = document.getElementByName("favoriteColor").value;
			  document.getElementByName("favoriteColor").style.backgroundColor = newColor;
			}
		alert("So you like "+newColor+" more than "+oldColor);
}