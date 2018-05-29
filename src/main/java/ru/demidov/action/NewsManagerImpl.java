package ru.demidov.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.demidov.interfaces.NewsManager;
import ru.demidov.objects.News;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewsManagerImpl implements NewsManager {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(NewsManagerImpl.class);

    @Transactional(readOnly = true)
    public List<News> searchNewsByContent(String searchLine) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "from News n where n.body like :searchLine";
            Query query = session.createQuery(hql);
            return query.setParameter("searchLine", "%" + searchLine + "%").getResultList();
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ArrayList<News>();
        }
    }

    @Transactional(readOnly = true)
    public List<News> getAllNews() {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("from News").list();

        } catch(Exception e) {
            logger.info(e.getMessage());
            return new ArrayList<News>();
        }
    }

    public List<News> getNewsByCategory(String category) {
        //TODO
        return null;
    }
}
