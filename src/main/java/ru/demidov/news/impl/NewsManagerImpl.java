package ru.demidov.news.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ru.demidov.news.News;
import ru.demidov.news.NewsManager;
import ru.demidov.news.NewsRepository;

@Component
public class NewsManagerImpl implements NewsManager {

	private final NewsRepository newsRepository;

	public NewsManagerImpl(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}

    @Transactional(readOnly = true)
    public List<News> searchNewsByContent(String searchLine) {
		return newsRepository.search(searchLine);
    }

    @Transactional(readOnly = true)
    public List<News> getAllNews() {
		return newsRepository.selectAllNews();
    }

    public List<News> getNewsByCategory(String category) {
        //TODO
        return null;
    }
}
