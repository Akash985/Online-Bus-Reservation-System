package com.cg.service;

import java.util.List;

import com.cg.entity.Passenger;

public interface PassengerService {
	
	List<Passenger> addNewPassengerDetails(List<Passenger> pssgnList);
	List<Passenger> getAllPassengerDetails();
	List<Passenger> getPassengerDetailsByBookingID(Long bookingId);
	Passenger getPassengerDetailByTicketNo(Long ticketNo);
	List<Passenger> getPassengerDetailByName(String pssgnName);
	List<Passenger> getPassengerDetailsBybusId(Long busId);
	List<Passenger> getPassengerDetailsBybusIdAndSeatNo(Long busId,Integer seatNo);
//	List<Passenger> updatePassengerDetailsByBookingId(Long bookingId,List<Passenger> pssgnList);
	Passenger updatePassengerDetailByTicketNo(Long ticketNo,Passenger pssgn);
	//for cancellation
	Passenger updatePassengerTicketStatusToRejectedByTicketNo(Long ticketNo);
	List<Passenger> updatePassengerTicketStatusToRejectedByBookingID(Long bookingId);

}
