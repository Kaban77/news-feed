package ru.demidov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.demidov.interfaces.NewsManager;
import ru.demidov.objects.News;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsManager newsManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMainPage() {
        return "index";
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<News> getNews() {
        return newsManager.getAllNews();
    }

    @RequestMapping(value = "/find-news", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<News> findNews(@RequestParam(value = "text") String searchLine) {
        return newsManager.searchNewsByContent(searchLine);
    }
}
