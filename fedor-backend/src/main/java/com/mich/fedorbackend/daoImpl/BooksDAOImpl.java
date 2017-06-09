package com.mich.fedorbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mich.fedorbackend.dao.BooksDAO;
import com.mich.fedorbackend.dto.Books;

@Repository("booksDAO")
@Transactional
public class BooksDAOImpl implements BooksDAO {
	@Autowired
	private SessionFactory sessionFactory;
	/*
	 * READ
	 */

	@Override
	public Books get(int booksId) {
		try {
			return sessionFactory.getCurrentSession().get(Books.class, Integer.valueOf(booksId));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Books> list() {

		return sessionFactory.getCurrentSession().createQuery("FROM Books", Books.class).getResultList();
	}
	/*
	 * CREATE
	 */

	@Override
	public boolean add(Books book) {
		try {
			sessionFactory.getCurrentSession().persist(book);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}
	/*
	 * UPDATE
	 */

	@Override
	public boolean update(Books book) {
		try {
			sessionFactory.getCurrentSession().update(book);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	/*
	 * DELETE
	 */
	@Override
	public boolean delete(Books book) {
		try {
			book.setActive(false);
			// Call update method for current book
			return this.update(book);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public List<Books> listActiveBooks() {
		String selectActiveBooks = "FROM Books WHERE active = :active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveBooks, Books.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<Books> listActiveProductsByCategory(int categoryId) {
		String selectActiveBooksByCategory = "FROM Books WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory.getCurrentSession().createQuery(selectActiveBooksByCategory, Books.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Books> getLatestActiveBooks(int count) {
		String selectActiveBooksByCategory = "FROM Books WHERE active = :active ORDER BY id";
		return sessionFactory.getCurrentSession().createQuery(selectActiveBooksByCategory, Books.class).setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

}
