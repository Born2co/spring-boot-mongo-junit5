package com.springboot.mongodb;


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.springboot.mongodb.exception.BookingException;
import com.springboot.mongodb.model.Booking;
import com.springboot.mongodb.repository.BookingRepository;
import com.springboot.mongodb.service.BookingServiceImpl;

public class BookingServiceImplTest {

	@Mock
    private BookingRepository bookingRepository;
    
	@InjectMocks
    private BookingServiceImpl bookingServiceImpl;
    
    @MockBean
    private Booking booking ;
    

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        booking= new Booking("1", "car", "Hyderabad");
    }


    @Test
    public void createBookingSuccess() {
    	when(bookingRepository.findById(booking.getId())).thenReturn(Optional.ofNullable(null));
        when(bookingRepository.insert((Booking) any())).thenReturn(booking);
        Booking resultBooking = bookingServiceImpl.createBooking(booking);
        assertEquals(booking, resultBooking);
    }

    @Test
    public void createBookingFailure() {
    	when(bookingRepository.findById(booking.getId())).thenReturn(Optional.of(booking));
        assertThrows(BookingException.class,  () -> {
        	bookingServiceImpl.createBooking(booking);
        });
     }

    @Test
    public void fetchBookingByIdSuccess() {
        when(bookingRepository.findById(booking.getId())).thenReturn(Optional.of(booking));
        Booking fetchBooking = bookingServiceImpl.fetchBookingById(booking.getId());
        assertEquals(booking, fetchBooking);
    }
    
    @Test
    public void fetchBookingByIdFailure() {
        when(bookingRepository.findById(booking.getId())).thenReturn(Optional.ofNullable(null));
        assertThrows(BookingException.class,  () -> {
            bookingServiceImpl.fetchBookingById(booking.getId());
        });
    }
    
    @Test
    public void updateBookingSuccess() {
        when(bookingRepository.findById(booking.getId())).thenReturn(Optional.of(booking));
        when(bookingRepository.save(booking)).thenReturn(booking);
        Booking updatedBooking = bookingServiceImpl.updateBooking(booking);
        assertEquals(booking, updatedBooking);
    }
    
    @Test
    public void updateBookingFailure() {
        when(bookingRepository.findById(booking.getId())).thenReturn(Optional.ofNullable(null));
        assertThrows(BookingException.class,  () -> {
        	bookingServiceImpl.updateBooking(booking);
        });
    }
    
    @Test
    public void deleteBookingFailure() {
        when(bookingRepository.findById(booking.getId())).thenReturn(Optional.ofNullable(null));
        assertThrows(BookingException.class,  () -> {
        	bookingServiceImpl.deleteBookingById(booking.getId());
        });
    }

   
}