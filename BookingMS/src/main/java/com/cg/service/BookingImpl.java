package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.entity.Booking;
import com.cg.repository.BookingRepository;

public class BookingImpl implements BookingService{
	@Autowired
	private BookingRepository bookingRepo;

	@Override
	public Booking addNewBooking(Booking booking) {
		return bookingRepo.save(booking);
	}

	@Override
	public List<Booking> getAllBooking() {
		return bookingRepo.findAll();
	}

	@Override
	public List<Booking> getAllBookingByBusId(Long busId) {
		return bookingRepo.findAllByBusId(busId);		 
	}

	@Override
	public List<Booking> getAllBookingByUserId(Long userId) {
		return bookingRepo.findAllByUserId(userId);
	}

	@Override
	public Booking getBookingByBookingID(Long bookingId) {
		return bookingRepo.findById(bookingId).get();
	}

	@Override
	public Booking updateBookingByBookingId(Long bookingId, Booking booking) {
		Booking tempBooking=bookingRepo.findById(bookingId).get();
		tempBooking.setBusId(booking.getBusId());
		tempBooking.setRouteId(booking.getRouteId());
		tempBooking.setBookingAmount(booking.getBookingAmount());
		return bookingRepo.save(tempBooking);
	}

	@Override
	public List<Booking> updateBookingByBusId(Long busId, Booking booking) {
		Booking tempBooking= null;
		List<Booking> tempBookingList = bookingRepo.findAllByBusId(busId);
		for(int i= 0;i<tempBookingList.size();i++) {
			tempBooking=tempBookingList.get(i);
			tempBooking.setBusId(booking.getBusId());
			tempBooking.setRouteId(booking.getRouteId());
			tempBooking.setBookingAmount(booking.getBookingAmount());
			bookingRepo.save(tempBooking);			
		}		
		return bookingRepo.findAllByBusId(busId);
	}

	@Override
	public Booking updatingBookingStatusToRejectedByBookingId(Long bookingId) {
		Booking tempBooking=bookingRepo.findById(bookingId).get();
		tempBooking.setBookingStatus("Rejected");
		return bookingRepo.save(tempBooking);
	}
	

}
