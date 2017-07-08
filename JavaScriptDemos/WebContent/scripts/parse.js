/**
 * 
 */

var catText = '{"cats":[{"name":"Cat1"},{"name":"Tom"}]}';
var dogText = '{"dogs":[{"name":"Dog1"},{"name":"Jerry"}]}';
var catObj = JSON.parse(catText);
var dogObj = JSON.parse(dogText);
document.getElementById("cats").innerHTML = catObj.cats[0].name + catObj.cats[1].name;
document.getElementById("dogs").innerHTML = dogObj.dogs[0].name +dogObj.dogs[1].name;