window.onload = function () {
    loadAllNews();
};

function clearPage(main) {
    while (main.firstChild) {
        main.removeChild(main.firstChild);
    }

    document.getElementById("search-line").value = "";
}

function findNews() {
    const params = "?text=" + encodeURIComponent(document.getElementById("search-line").value);

    sendRequest("GET", "find-news", params, showSearchingResults);
}

function loadAllNews() {
    sendRequest("GET", "get-all", "", showAllNews);
}

function showAllNews(news) {
    let main = document.getElementById("main");
    clearPage(main);

    for(let i = 0; i < news.length; i++) {
        showPost(news[i]);
    }
}

function showSearchingResults(news) {
    let main = document.getElementById("main");
    clearPage(main);

    if(news.length === 0) {
        let div = document.createElement("div");
        div.className = "no-result";

        let header = document.createElement("h3");
        header.innerHTML = "Ничего не найдено";
        div.appendChild(header);

        let button = document.createElement("button");
        button.onclick = loadAllNews;
        button.innerHTML = "Показать все новости";
        div.appendChild(button);

        main.appendChild(div);

        return;
    }

    for(let i = 0; i < news.length; i++) {
        showPost(news[i]);
    }
}

function showPost(post) {
    let main = document.getElementById("main");

    let div = document.createElement("div");
    div.className = "post";
    div.id = post.id;

    div.innerHTML = "<h3>" + post.caption + "</h3>" +
                    "<span class='time'>" + post.publicationDate + "</span>" +
                    "<p class='text'>" + post.body + "</p>" +
                    "<span>Пост из категории " + post.category + "</span>";

    main.appendChild(div);
}