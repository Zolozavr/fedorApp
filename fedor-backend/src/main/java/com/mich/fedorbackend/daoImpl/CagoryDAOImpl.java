package com.mich.fedorbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.mich.fedorbackend.dao.CategoryDAO;
import com.mich.fedorbackend.dto.Category;

@Repository("category")
public class CagoryDAOImpl implements CategoryDAO {
	private static List<Category> categories = new ArrayList<>();
	static {
		Category cat = new Category();
		Category category = new Category();
		category.setId(1);
		category.setName("Fantastic");
		category.setDescription("Science fiction novels");
		category.setImageUrl("Cat_1.png");
		categories.add(category);
		category = new Category();
		category.setId(2);
		category.setName("Romance");
		category.setDescription("Steamy novels");
		category.setImageUrl("Cat_2.png");
		categories.add(category);

		category = new Category();
		category.setId(3);
		category.setName("Detective");
		category.setDescription("Steamy novels");
		category.setImageUrl("Cat_2.png");
		categories.add(category);
	}

	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}