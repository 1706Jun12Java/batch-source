console.log('~~~~Question 1~~~~');

function getUsa(){
    var allElements = document.getElementsByTagName('*');

    for (var i = 0; i < allElements.length; i++) {
        if(allElements[i].firstChild){
            if(allElements[i].firstChild.textContent.includes('USA'))
                console.log(allElements[i].outerHTML);
        }
    }
}

getUsa();

console.log('~~~~Question 2~~~~');

function getPeopleInSales(){
    var tableElements = document.getElementsByTagName('table');

    for (var i = 0; i < tableElements.length; i++) {
        for (var j = 0; j < tableElements[i].rows.length; j++) {
            if (tableElements[i].rows[j].innerText.includes('Sales'))
                console.log(tableElements[i].rows[j].innerText);
        }
    }
}

getPeopleInSales();

console.log('~~~~Question 3~~~~');

function getAnchorChildren(){
    var anchorElements = document.getElementsByTagName('a');
    for (var i = 0; i < anchorElements.length; i++) {
        for (var j = 0; j < anchorElements[i].childNodes.length; j++) {
            if (anchorElements[i].childNodes[j].tagName === 'SPAN')
                console.log(anchorElements[i].childNodes[j].outerHTML);
        } 
    }

}

getAnchorChildren();

console.log('~~~~Question 4~~~~');

// Find all checked options in the 'skills' select element.

// Print the value and the contents.

function getHobbies() {
    var selectSkills = document.getElementsByTagName('select').skills;

    for (var i = 0; i < selectSkills.children.length; i++) {
        if (selectSkills.children[i].selected === true)
            console.log(selectSkills.children[i].outerHTML);

        // if (selectSkills.children[i].defaultSelected === true)
        //     console.log(selectSkills.children[i].outerHTML);
    }

}

getHobbies();

console.log('~~~~Question 5~~~~');


// Find all elements with "data-customAttr" attribute

// Print the value of the attribute.

// Print the element that has the attribute.

function getCustomAttribute(){
    var dataElements = document.querySelectorAll('[data-customAttr]');

    for (var i = 0; i < dataElements.length; i++) {
        console.log(dataElements[i].outerHTML);
        
    }
}

getCustomAttribute();

console.log('~~~~Question 6~~~~');

// Regarding these elements:
	
// <input id="num1" class="nums" type="text"/>
	
// <input id="num2" class="nums" type="text"/>
	
// <h3>Sum: <span id="sum"></span></h3>


// Define onchange event handler.

// Add <input> element values.

// Put the sum in the <span> element.

// If values cannot be added, put "Cannot add" in the <span> element

var nums = document.getElementsByClassName('nums');
function onChangeEventHandler(event) {
    event.stopPropagation();

    var num1 = document.getElementById('num1').value;
    var num2 = document.getElementById('num2').value;
    var sums = document.getElementById('sum');

    var reg = new RegExp('^\\d+$');

    if (reg.test(num1) === true && reg.test(num2) === true){
        sums.textContent = Number(num1) + Number(num2);
    } else {
        sums.textContent = 'Cannot add';
    }
}

for (var i = 0; i < nums.length; i++) {
    nums[i].onkeyup = onChangeEventHandler;
}

console.log('~~~~Question 7~~~~');

// When user selects a skill, create an alert with a message similar to:
	
// "Are you sure CSS is one of your skills?"

// NOTE: no alert should appear when user deselects a skill.

function selectSkillAlert(){
    alert('Are you sure ' + event.target.value + ' is one of your skills?'); 
}

document.addEventListener('DOMContentLoaded',function(event) {
    var skills = document.getElementsByTagName('select').skills.onchange = selectSkillAlert;
},false);

console.log('~~~~Question 8~~~~');


// NOTE: This is regarding the favoriteColor radio buttons.

// When a user selects a color, create an alert with a message similar to:
	
// "So you like green more than blue now?"

// In this example, green is the new value and blue is the old value.

// Make the background color (of all favoriteColor radio buttons) 
// the newly selected favoriteColor

function test(event){
    var favoriteColor = document.querySelectorAll('input[name="favoriteColor"]');

    var prevColor = (favoriteColor[0].style.backgroundColor === '') ? 'no color' : favoriteColor[0].style.backgroundColor;

    alert('So you like ' + event.target.value + ' more than ' + prevColor  + ' now?');


    for (var i = 0; i < favoriteColor.length; i++) {
        favoriteColor[i].style.backgroundColor = event.target.value;
    }
}

function favoriteColor(){
    var favoriteColor = document.querySelectorAll('input[name="favoriteColor"]');

    for (var i = 0; i < favoriteColor.length; i++) {
       favoriteColor[i].addEventListener('change', test);
    }
}

favoriteColor();


console.log('~~~~Question 9~~~~');

// When user hovers over an employees name:
	
// Hide the name if shown.
// 	Show the name if hidden.

function hideAndShowName() {
    event.target.style.opacity = (event.target.style.opacity === '0') ? 1 : 0;
}

function hoverOverName(){
    var employees = document.getElementsByClassName('empName');

    for (var i = 0; i < employees.length; i++) {
       employees[i].addEventListener('mouseover', hideAndShowName);
    }
}

hoverOverName();


console.log('~~~~Question 10~~~~');

// Regarding this element:
// 	<h5 id="currentTime"></h5>

// Show the current time in this element in this format: 9:05:23 AM

// The time should be accurate to the second without having to reload the page.

document.addEventListener('DOMContentLoaded', function () {
    var currentTime = document.getElementById('currentTime');

    var interval = setInterval(function(){
        var date = new Date;
        var seconds = date.getSeconds();
        var minutes = date.getMinutes();
        var hour = date.getHours();
        var period = (hour > 12) ? 'PM' : 'AM';
        currentTime.textContent = (hour % 12) + ':' + minutes + ':' + seconds + ' ' + period;
    }, 1000);
});


console.log('~~~~Question 11~~~~');


// Regarding this element:
	
// <p id="helloWorld">Hello, World!</p>

// Three seconds after a user clicks on this element, change the text to a random color.


document.addEventListener('DOMContentLoaded', function () {
    var helloWorld = document.getElementById('helloWorld');

    helloWorld.addEventListener('click', function(){
        var interval = setInterval(function(){

            var r = Math.floor(Math.random() * 255);
            var g = Math.floor(Math.random() * 255);
            var b = Math.floor(Math.random() * 255);

            helloWorld.style.color = 'rgb('+ r + ',' + g  + ','+ b + ')';

            clearInterval(interval);
        }, 3000);
    });
});


console.log('~~~~Question 12~~~~');

function walkTheDOM(node) 
{
        if (node.outerHTML)
            console.log(node.outerHTML);

        node = node.firstChild;
        while(node) {
            walkTheDOM(node);
            node = node.nextSibling;
        }
}

walkTheDOM(document.body);
