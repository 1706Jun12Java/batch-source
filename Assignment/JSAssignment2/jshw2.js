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
        // if (selectSkills.skills.children[i].selected === true)
        //     console.log(selectSkills.skills.children[i].outerHTML);

        if (selectSkills.children[i].defaultSelected === true)
            console.log(selectSkills.children[i].outerHTML);
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













