package com.mich.fedorbackend.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mich.fedorbackend.dao.UserDAO;
import com.mich.fedorbackend.dto.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

public boolean addUser(User user){
	try {
		sessionFactory.getCurrentSession().persist(user);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	
}
}
