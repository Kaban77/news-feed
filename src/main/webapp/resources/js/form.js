var id = null;

function checkForm() {
    if(document.getElementById("caption").value !== "" &&
       document.getElementById("body").value !== "") {
        return true;
    }
    return false;

}

function endOfSaving() {
    alert("Данные успешно сохранены");
}

function saveNews() {
    if(!checkForm()) {
        alert("Заполните, пожалуйста, все поля");
        return;
    }

    let news = {
        id: id,
        caption: document.getElementById("caption").value,
        body: document.getElementById("body").value,
        publicationDate: null,
        category: document.getElementById("category").value
    };

    sendRequest("POST", "save-news", news, endOfSaving);
}