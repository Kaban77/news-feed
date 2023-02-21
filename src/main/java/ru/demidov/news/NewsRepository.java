package ru.demidov.news;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class NewsRepository {

	private final SessionFactory sessionFactory;

	private static final String HQL_SELECT_ALL = """
			from News
			 """;
	private static final String HQL_SEARCH = """
			from News n where n.body like :searchLine
			""";

	public NewsRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<News> selectAllNews() {
		var entityManager = sessionFactory.createEntityManager();
		return entityManager.createQuery(HQL_SELECT_ALL, News.class).getResultList();
	}

	public List<News> search(String searchLine) {
		var entityManager = sessionFactory.createEntityManager();
		var query = entityManager.createQuery(HQL_SEARCH, News.class);

		return query.setParameter("searchLine", "%" + searchLine + "%").getResultList();
	}
}
