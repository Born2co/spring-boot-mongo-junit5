package com.springboot.mongodb.service;

import com.springboot.mongodb.exception.BookingException;
import com.springboot.mongodb.model.Booking;


public interface BookingService {

	public Booking createBooking(Booking booking) throws BookingException ;
	public Booking fetchBookingById(String id);
	public Booking updateBooking(Booking booking);
	public void deleteBookingById(String id);

}
