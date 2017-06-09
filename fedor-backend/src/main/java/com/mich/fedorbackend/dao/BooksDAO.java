package com.mich.fedorbackend.dao;

import java.util.List;

import com.mich.fedorbackend.dto.Books;

public interface BooksDAO {
	/*
	 * CRUD
	 */
	Books get(int booksId);

	List<Books> list();

	boolean add(Books book);

	boolean update(Books book);

	boolean delete(Books book);

	/*
	 * Active books
	 */
	List<Books> listActiveBooks();
	/*
	 * Active books by category
	 * */

	List<Books> listActiveProductsByCategory(int categoryId);
	/*
	 * Last books added
	 * */
	List<Books> getLatestActiveBooks(int count);
}
