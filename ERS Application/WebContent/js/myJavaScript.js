function viewRR() {
	//document.getElementById("rrForm").removeAttribute("class");
	var ele = document.getElementById("rrView");
	if(ele.style.display === "block") {
		ele.style.display = "none";
	}
	else {
		ele.style.display = "block"
	}
	console.log("Button has been clicked");
}