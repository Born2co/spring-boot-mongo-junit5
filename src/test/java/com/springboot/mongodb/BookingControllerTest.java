package com.springboot.mongodb;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.mongodb.controller.BookingController;
import com.springboot.mongodb.model.Booking;
import com.springboot.mongodb.service.BookingService;

@WebMvcTest(BookingController.class)
@AutoConfigureMockMvc
public class BookingControllerTest {

	@Autowired
    MockMvc mockMvc;
	
    ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    BookingService bookingService;
    
    @Test
    void testCreateBooking() throws Exception {
        Booking booking = new Booking("1", "car", "Hyderabad");;
        String json = objectMapper.writeValueAsString(booking);
        when(bookingService.createBooking(booking)).thenReturn(booking);
        mockMvc.perform(post("/createBooking")
        .content(json)
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void testFetchBookingById() throws Exception {
        Booking booking = new Booking("1", "car", "Hyderabad");;
        String json = objectMapper.writeValueAsString(booking);
        when(bookingService.fetchBookingById(booking.getId())).thenReturn(booking);
        mockMvc.perform(get("/fetchBookingById/{id}", booking.getId())
        .content(json)
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    
    @Test
    void testUpdateBooking() throws Exception {
        Booking booking = new Booking("1", "car", "Hyderabad");;
        String json = objectMapper.writeValueAsString(booking);
        when(bookingService.updateBooking(booking)).thenReturn(booking);
        mockMvc.perform(put("/updateBooking")
        .content(json)
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void testDeleteBookingById() throws Exception {
        Booking booking = new Booking("1", "car", "Hyderabad");;
        String json = objectMapper.writeValueAsString(booking);
        when(bookingService.fetchBookingById(booking.getId())).thenReturn(booking);
        mockMvc.perform(delete("/deleteBookingById/{id}", booking.getId())
        .content(json)
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}