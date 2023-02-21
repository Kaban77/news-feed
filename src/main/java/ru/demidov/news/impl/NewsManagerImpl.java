package ru.demidov.news.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.Query;
import ru.demidov.news.News;
import ru.demidov.news.NewsManager;

@Component
public class NewsManagerImpl implements NewsManager {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsManagerImpl.class);

    @Transactional(readOnly = true)
    public List<News> searchNewsByContent(String searchLine) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "from News n where n.body like :searchLine";
            Query query = session.createQuery(hql);
            return query.setParameter("searchLine", "%" + searchLine + "%").getResultList();
        } catch (Exception e) {
			LOGGER.error("Error!", e);
			return List.of();
        }
    }

    @Transactional(readOnly = true)
    public List<News> getAllNews() {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("from News").list();

        } catch(Exception e) {
			LOGGER.error("Error!", e);
			return List.of();
        }
    }

    public List<News> getNewsByCategory(String category) {
        //TODO
        return null;
    }
}
