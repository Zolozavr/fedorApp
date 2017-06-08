package com.mich.fedorbackend.dao;

import java.util.List;

import com.mich.fedorbackend.dto.Category;

public interface CategoryDAO {
	boolean add(Category category);

	List<Category> list();

	Category get(int id);
}
