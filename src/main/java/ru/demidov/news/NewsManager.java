package ru.demidov.news;

import java.util.List;

public interface NewsManager {

    List<News> searchNewsByContent(String searchLine);
    List<News> getAllNews();
    List<News> getNewsByCategory(String category);
}
