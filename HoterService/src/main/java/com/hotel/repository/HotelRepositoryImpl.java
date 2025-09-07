package com.hotel.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hotel.entity.Hotel;

@Repository
public class HotelRepositoryImpl implements HotelRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Hotel saveHotelDetails(Hotel hotel) {
        Session session = null;
        Transaction transaction = null;
        Hotel savedHotel = new Hotel();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Integer hotelId = (Integer) session.save(hotel);
            savedHotel.setHotelId(hotelId);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return savedHotel;
    }


    @Override
    public List<Hotel> getAllHotels() {
        Session session = null;
        List<Hotel> hotelList = null;
        try {
            session = sessionFactory.openSession();
            hotelList = session.createQuery("from Hotel", Hotel.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return hotelList;
    }

    // ✅ Get Hotel By ID
    @Override
    public Hotel getHotelDetailsById(Integer hotelId) {
        Session session = null;
        Hotel hotel = null;
        try {
            session = sessionFactory.openSession();
            hotel = session.get(Hotel.class, hotelId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return hotel;
    }
}
