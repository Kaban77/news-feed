package ru.demidov.news.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.demidov.news.News;
import ru.demidov.news.NewsManager;

@Controller
public class NewsController {

	private final NewsManager newsManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

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
		try {
			return newsManager.getAllNews();
		} catch (Exception e) {
			LOGGER.error("Error!", e);
			throw new RuntimeException(e);
		}
    }

	@GetMapping(value = "/find-news", produces = "application/json")
    @ResponseBody
    public List<News> findNews(@RequestParam(value = "text") String searchLine) {
		try {
			return newsManager.searchNewsByContent(searchLine);
		} catch (Exception e) {
			LOGGER.error("Error!", e);
			throw new RuntimeException(e);
		}
    }
}
