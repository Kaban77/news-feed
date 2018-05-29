package ru.demidov.interfaces;

import ru.demidov.objects.News;

import java.util.List;

public interface NewsManager {


    List<News> searchNewsByContent(String searchLine);
    List<News> getAllNews();
    List<News> getNewsByCategory(String category);
}
