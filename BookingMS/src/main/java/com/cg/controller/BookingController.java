package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Booking;
import com.cg.service.BookingService;

@RestController
@RequestMapping(value = "/bookingCtrl")
public class BookingController {
	@Autowired
	BookingService bookingService;
	
	
//	Create
	//http://localhost:9091/bookingCtrl/create
	@PostMapping(value ="/create",consumes = MediaType.APPLICATION_JSON_VALUE,
	headers="Accept=application/json",produces=MediaType.APPLICATION_JSON_VALUE)
	Booking createBooking(@RequestBody Booking booking){
		return bookingService.addNewBooking(booking);
	}
	
//	Read
//	get all booking
	//http://localhost:9091/bookingCtrl/fetchAll
	@GetMapping(value ="/fetchAll",produces=MediaType.APPLICATION_JSON_VALUE)
	List<Booking> fetchAllBookings(){
		return bookingService.getAllBooking();	
	}
	
//	get booking by Id
	//http://localhost:9091/bookingCtrl/fetchBooking/bookId={bkId}
	@GetMapping(value ="/fetch/bokId={bkId}",produces=MediaType.APPLICATION_JSON_VALUE)
	Booking fetchBookingByBookingId(@PathVariable("bkId")Long bId){
		return bookingService.getBookingByBookingID(bId);	
	}
//	get booking by busId
	//http://localhost:9091/bookingCtrl/fetchBookings/busId={bId}
	@GetMapping(value ="/fetchBookings/busId={bId}",produces=MediaType.APPLICATION_JSON_VALUE)
	List<Booking> fetchBookingsByBusId(@PathVariable("bId")Long bId){
		return bookingService.getAllBookingByBusId(bId);	
	}
//	get booking by user id
	//http://localhost:9091/bookingCtrl/fetchBookings/userId={uId}
	@GetMapping(value ="/fetchBookings/userId={uId}",produces=MediaType.APPLICATION_JSON_VALUE)
	List<Booking> fetchBookingsByUserId(@PathVariable("uId")Long uId){
		return bookingService.getAllBookingByUserId(uId);	
	}
	
	
//	Update
	//for admin use only
	@PutMapping(value ="/updateBooking/bkId= {bId}",consumes = MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json",produces=MediaType.APPLICATION_JSON_VALUE)
	Booking updateBookingdetailsByBookingId(@PathVariable("bId")Long bId,@RequestBody Booking booking) {
		return bookingService.updateBookingByBookingId(bId, booking);		//can change only busId,BookingId,Amount
	}
	
	//for admin use only
	@PutMapping(value ="/updateBooking/busId= {bId}",consumes = MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json",produces=MediaType.APPLICATION_JSON_VALUE)
	List<Booking> updateBookingdetailsByBusId(@PathVariable("bId")Long bId,@RequestBody Booking booking) {
		return bookingService.updateBookingByBusId(bId, booking);		//changes bookings related to that bus Id if bus chnages can change only busId,BookingId,Amount
	}
	
	
//	For Canceling Using update instead of delete 
	@PutMapping(value ="/updateBooking/bkId= {bId}",consumes = MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json",produces=MediaType.APPLICATION_JSON_VALUE)
	Booking cancelBookingByBookingId(@PathVariable("bId")Long bId) {
		return bookingService.updatingBookingStatusToRejectedByBookingId(bId);		
	}
	
}
