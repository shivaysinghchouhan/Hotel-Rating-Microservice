package com.review.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.review.entity.Rating;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository{

	@Autowired 
	private SessionFactory sessionFactory;
	
	   // Save Rating
    public Rating saveRatingDetails(Rating rating) {
    	Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();
	    try {
	        Integer ratingId = (Integer) session.save(rating);
	        rating.setRatingId(ratingId);
	        transaction.commit();
	        return rating;
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	        return null;
	    } finally {
	        session.close();
	    }
    }

    // Get all ratings
    public List<Rating> getAllRatings() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Rating", Rating.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get rating by id
    public Rating getRatingById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Rating.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public ArrayList<Rating> getRatingByUserId(int userId) {
        try (Session session = sessionFactory.openSession()) {
            List<Rating> list = session.createQuery("FROM Rating WHERE userId = :userId", Rating.class)
                                       .setParameter("userId", userId)
                                       .getResultList();

            return new ArrayList<>(list);  // Convert List to ArrayList
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();  // Avoid returning null
        }
    }


	
	
}
