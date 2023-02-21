package ru.demidov.news.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.demidov.news.News;
import ru.demidov.news.NewsManager;

@Controller
public class NewsController {

	private final NewsManager newsManager;

	public NewsController(NewsManager newsManager) {
		this.newsManager = newsManager;
	}

	@GetMapping(value = "/")
    public String getMainPage() {
        return "index";
    }

	@GetMapping(value = "/get-all", produces = "application/json")
    @ResponseBody
    public List<News> getNews() {
        return newsManager.getAllNews();
    }

	@GetMapping(value = "/find-news", produces = "application/json")
    @ResponseBody
    public List<News> findNews(@RequestParam(value = "text") String searchLine) {
        return newsManager.searchNewsByContent(searchLine);
    }
}
