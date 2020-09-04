package com.springboot.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongodb.model.Booking;
import com.springboot.mongodb.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/createBooking")
	public Booking createBooking(@RequestBody Booking booking) {
		return bookingService.createBooking(booking);
	}

	@GetMapping("/fetchBookingById/{id}")
	public Booking fetchBookingById(@PathVariable String id) {
		return bookingService.fetchBookingById(id);
	}

	@PutMapping("updateBooking")
	public Booking updateBooking(@RequestBody Booking booking) {
		return bookingService.updateBooking(booking);
	}

	@DeleteMapping("deleteBookingById/{id}")
	public void deleteBookingById(@PathVariable String id) {
		bookingService.deleteBookingById(id);
	}
}
