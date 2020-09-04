package com.springboot.mongodb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mongodb.exception.BookingException;
import com.springboot.mongodb.model.Booking;
import com.springboot.mongodb.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	public Booking createBooking(Booking booking) throws BookingException {
		if (null != booking.getId()) {
			Optional<Booking> existingBooking = bookingRepository.findById(booking.getId());
			if (existingBooking.isPresent()) {
				throw new BookingException("Booking ID already available in the booking database");
			}
		}
		return bookingRepository.insert(booking);
	}

	public Booking fetchBookingById(String id) {
		Optional<Booking> booking = bookingRepository.findById(id);
		if (!booking.isPresent()) {
			throw new BookingException("ID not found in booking database");
		}
		return booking.get();
	}

	public Booking updateBooking(Booking booking) {
		Optional<Booking> existingBooking = bookingRepository.findById(booking.getId());
		if (!existingBooking.isPresent()) {
			throw new BookingException("ID not found in booking database. Provide valid booking ID to delete");
		}
		return bookingRepository.save(booking);
	}

	public void deleteBookingById(String id) {
		Optional<Booking> booking = bookingRepository.findById(id);
		if (!booking.isPresent()) {
			throw new BookingException("ID not found in booking database. Provide valid booking ID to delete");
		}
		bookingRepository.deleteById(id);
	}
}
