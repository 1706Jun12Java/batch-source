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



