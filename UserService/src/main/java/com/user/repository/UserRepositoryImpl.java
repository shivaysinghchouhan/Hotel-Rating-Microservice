package com.user.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Autowired
	private SessionFactory sessionFactory;

	/*@Override
	public User saveUserDetails(User user) {
		Integer userId =(Integer) sessionFactory.getCurrentSession().save(user);
		User obj = new User();
		obj.setUserId(userId);
		return obj;
	}*/
	
	public User saveUserDetails(User user) {
	    Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();
	    try {
	        Integer userId = (Integer) session.save(user);
	        user.setUserId(userId);
	        transaction.commit();
	        return user;
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	        return null;
	    } finally {
	        session.close();
	    }
	}

	public List<User> getAllUser() {
	    Session session = sessionFactory.openSession();
	    List<User> list = session.createNativeQuery("SELECT * FROM user", User.class).getResultList();
	    session.close();
	    return list;
	}

	public User getUserDetailsByUserId(Integer userId) {
	    Session session = sessionFactory.openSession();
	    User user = session.get(User.class, userId);
	    session.close();
	    return user;
	}

	

}
