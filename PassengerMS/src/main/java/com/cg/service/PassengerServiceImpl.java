package com.cg.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.PassengerDto;
import com.cg.entity.Passenger;
import com.cg.repository.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService{
	
	@Autowired
	private PassengerRepository passengerRepo;

	@Override
	public List<Passenger> addNewPassengerDetails(List<Passenger> pssgnList) {
		List<Passenger> savedPssgnList =passengerRepo.saveAll(pssgnList);
		return savedPssgnList;
	}
	
	//read
	
	@Override
	public List<Passenger> getAllPassengerDetails() {		
		return passengerRepo.findAll();
	}
	
	@Override
	public List<Passenger> getPassengerDetailsByBookingID(Long bookingId) {
		List<Passenger> pssgnList = passengerRepo.findAllByBookingId(bookingId);
		return pssgnList;
	}

	@Override
	public Passenger getPassengerDetailByTicketNo(Long ticketNo) {		
		return passengerRepo.findById(ticketNo).get();
	}

	@Override
	public List<Passenger> getPassengerDetailByName(String pssgnName) {
		return passengerRepo.findAllByPassengerName(pssgnName);
	}

	@Override
	public List<Passenger> getPassengerDetailsBybusId(Long busId) {
		return passengerRepo.findAllByBusId(busId);
	}

	@Override
	public List<Passenger> getPassengerDetailsBybusIdAndSeatNo(Long busId, Integer seatNo) {
		return passengerRepo.findAllByBusIdAndSeatNo(busId, seatNo);
	}

//	@Override
//	public List<Passenger> updatePassengerDetailsByBookingId(Long bookingId, List<Passenger> pssgnList) {
//		List<Passenger> pssgnListTemp =passengerRepo.findAllByBookingId(bookingId);
//		for(int i=0;i<pssgnListTemp.size();i++) {
//			pssgnListTemp.add(pssgnList.get(i));
//		}
//		passengerRepo.saveAll(pssgnListTemp);
//		
//		return null;
//	}

	@Override
	public Passenger updatePassengerDetailByTicketNo(Long ticketNo, Passenger pssgn) {
		Passenger tempPassenger = passengerRepo.findById(ticketNo).get();
		tempPassenger.setBusId(pssgn.getBusId());
		tempPassenger.setPassengerName(pssgn.getPassengerName());
		tempPassenger.setAge(pssgn.getAge());
		tempPassenger.setGender(pssgn.getGender());
		return passengerRepo.save(pssgn);
	}

	@Override
	public Passenger updatePassengerTicketStatusToRejectedByTicketNo(Long ticketNo) {
		Passenger pssgn= passengerRepo.findById(ticketNo).get();
		pssgn.setTicketStatus("Rejected");
		return passengerRepo.save(pssgn);
	}

	@Override
	public List<Passenger> updatePassengerTicketStatusToRejectedByBookingID(Long bookingId) {
		 
		List<Passenger> pssgnListTemp = passengerRepo.findAllByBookingId(bookingId);
		for(int i=0;i<pssgnListTemp.size();i++) {
			pssgnListTemp.get(i).setTicketStatus("Rejected");
			passengerRepo.save(pssgnListTemp.get(i));
		}
		return passengerRepo.findAllByBookingId(bookingId);
	}

	
	
	
	
	
	
	

}
