//1. USA
//Define function getUSA()
//Find the html element that contains "USA". Print that element's contents.

function getUSA(){
	var all = document.getElementsByTagName('*');
	
	for (var i=0; i<all.length; i++) {
		if(all[i].firstChild){
			if (all[i].firstChild.textContent.includes('USA')){
				console.log(all[i].outerHTML);
			}
		}
	}
	
};

getUSA();

//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.

function getPeopleInSales(){
	var table = document.getElementsByTagName('table')[0];
	for (var i = 0; i < table.rows.length; i++){
		if (table.rows[i].innerText.includes('Sales')){
			console.log(table.rows[i].innerText);
		}
	}	
}
getPeopleInSales();

//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child. Print the contents of <span>

function getAnchorChildren(){
	var anchor = document.getElementsByTagName('a');
	for (var i = 0; i<anchor.length; i++){
		for (var j = 0; j < anchor[i].childNodes.length; j++){
			if (anchor[i].childNodes[j].tagName ==='SPAN'){
				console.log(anchor[i].childNodes[j].innerHTML);
			}
		}
	}
}	
getAnchorChildren();

//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element. Print the value and the contents.

function getHobbies(){
	var skillsSelected = document.getElementsByTagName('select').skills;
	
	for (var i = 0; i < skillsSelected.children.length; i++){
		if (skillsSelected.children[i].selected){
			console.log(skillsSelected.children[i].outerHTML);
		}
	}
	
}
getHobbies();

//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute Print the value of the attribute.
//Print the element that has the attribute.

function getCustomAttribute(){
	var all = document.getElementsByTagName('*');
	for (var i = 0; i < all.length; i++){
		if (all[i].getAttribute('data-customAttr')){
			console.log("Value: " + all[i].getAttribute('data-customAttr') + ', ' + "Element: " + all[i].tagName);
		}
		
	}
}
getCustomAttribute();

//6. Sum Event
//NOTE: Write unobtrusive Javascript Regarding these elements:
//<input id="num1" class="nums" type="text"/> 
//<input id="num2" class="nums" type="text"/> 
//<h3>Sum: <span id="sum"></span></h3>

//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element

function getEventSum(){
	var sum = parseFloat(document.getElementById('num1').value) + parseFloat(document.getElementById('num2').value);
	if (sum){
		document.getElementById('sum').innerHTML = sum;
	}
}
document.getElementById('num1').addEventListener('change', getEventSum);
document.getElementById('num2').addEventListener('change', getEventSum);

//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//"Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.

document.getElementsByName('skills')[0].addEventListener('change', getSkillConfirmation);

function getSkillConfirmation(){
	var skills = document.getElementsByName('skills');
	var thisSkill = "";
	for (var i=0; i<skills[0].options.length; i++){
		if (skills[0].options[i].selected){
			thisSkill = skills[0].options[i].value;
		}
	}
		alert('Are you sure ' + thisSkill + ' is one of your skills?');
	
}

//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//"So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

var favColor = document.getElementById('firstForm').elements['favoriteColor'];

function changeColor(){
	var selectedColor;
for(var i = 0; i< favColor.length; i++){
	favColor[i].onclick = function() {
		if (!selectedColor){
			selectedColor = this.value;
			favColor.style.backgroundColor = this.value;
		} else if (this.value != selectedColor){
			alert('So you like ' + this.value + ' more than ' + selectedColor + ' now?');
			selectedColor = this.value;
			favColor.style.backgroundColor = this.value;
		}
	}
}
}

changeColor();


//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//Hide the name if shown.
//Show the name if hidden.

function hideOrShow(){
	event.target.style.opacity = (event.target.style.opacity === '0') ? 1:0;
}
function hover(){
	var emp = document.getElementsByClassName('empName');
	
	for(var i = 0; i < emp.length; i++){
		emp[i].addEventListener('mouseover', hideOrShow);
	}
}
hover();

//10. Current Time
//Regarding this element:
//<h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.
var timeNow = document.getElementById('currentTime');

document.addEventListener('DOMContentLoaded', function() {
	var timeNow = document.getElementById('currentTime');

	var interval = setInterval(function(){
	var date = new Date();
	var hour = date.getHours();
	var min = date.getMinutes();
	var sec = date.getSeconds();
	var set = (hour < 12) ? 'AM' : 'PM';
	timeNow.innerHTML = (hour % 12) + ':' + min + ':' + sec + ' ' + set;}, 1000);
});

//timeNow.addEventListener('load', setInterval(currentTime(), 1000));
//11. Delay
//Regarding this element:
//<p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.

document.addEventListener('DOMContentLoaded', function(){
	var randomColor = document.getElementById('helloWorld');
	
	randomColor.addEventListener('click', function(){
		setTimeout(function(){

			var red = Math.floor(Math.random() * 255);
			var green = Math.floor(Math.random() * 255);
			var blue = Math.floor(Math.random() * 255);
			randomColor.style.color = "rgb(" + red +","+ green +","+ blue +")"; }, 3000);
	});
});

//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).

function walkTheDOM(node, func){
	func(node);
	node = node.firstChild;
	while (node) {
		walkTheDOM(node, func);
		node = node.nextSibling;
	}
}