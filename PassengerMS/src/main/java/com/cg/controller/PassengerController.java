package com.cg.controller;

import java.util.List;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Passenger;
import com.cg.service.PassengerService;

@RestController
@RequestMapping(value ="/passengerCtrl")
public class PassengerController {
	
	@Autowired
	private PassengerService passengerService;
	
	
	
	
//	Create functionality
//	Add list of passenger
	//http://localhost:9090/passengerCtrl/create
	@PostMapping(value ="/create",consumes = MediaType.APPLICATION_JSON_VALUE,
	headers="Accept=application/json",produces=MediaType.APPLICATION_JSON_VALUE)
	List<Passenger> createPassengers(@RequestBody List<Passenger> pssg){
		return passengerService.addNewPassengerDetails(pssg);
	}
	
//	Read functionality
	
	//getAll passenger details
//	http://localhost:9090/passengerCtrl/getAllPassenger
	@GetMapping(value ="/getAllPassenger", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Passenger> fetchAllPassengerDetails(){
		return passengerService.getAllPassengerDetails();// passengerService.getPassengerDetailsByBookingID(bId);
	}	
	
	//get passenger List By booking id
//	http://localhost:9090/passengerCtrl/fetchPassenger/bId=6001
	@GetMapping(value = "/fetchPassenger/bId={bkId}", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Passenger> fetchPassengerDetailsByBookingId(@PathVariable("bkId")Long bId){
		return passengerService.getPassengerDetailsByBookingID(bId);
	}	
	
	//get passenger by Ticket No.
//	http://localhost:9090/passengerCtrl/fetchPassenger/tNo=1002
	@GetMapping(value = "/fetchPassenger/tNo={TcNo}", produces=MediaType.APPLICATION_JSON_VALUE)
	Passenger fetchPassengerDetailsByTicketNo(@PathVariable("TcNo")Long tNo){
		return passengerService.getPassengerDetailByTicketNo(tNo);// passengerService.getPassengerDetailsByBookingID(bId);
	}
	
	//get passenger list by passenger Name--->for admin only(here we will get passenger by name and here we are using list because 1 person van have 2 or more bookings in different bus on different date )
//	http://localhost:9090/passengerCtrl/fetchPassenger/pName=Akash Yadav
	@GetMapping(value ="/fetchPassenger/pName={name}", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Passenger> fetchPassengerDetailsByName(@PathVariable("name")String pName){
		return passengerService.getPassengerDetailByName(pName);// passengerService.getPassengerDetailsByBookingID(bId);
	}
	
	
	//get passenger list by Bus id--->for admin only and internal use 
//	http://localhost:9090/passengerCtrl/fetchPassengerlist/busId=5001
	@GetMapping(value ="/fetchPassengerlist/busId={bID}", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Passenger> fetchAllPassengerDetailsByBusId(@PathVariable("bID")Long busId){
		return passengerService.getPassengerDetailsBybusId(busId);//passengerService.getPassengerDetailByName(pName);// passengerService.getPassengerDetailsByBookingID(bId);
	}
	
	//get passenger by bus id and seat no. --->for admin only
//	http://localhost:9090/passengerCtrl/fetchPassengerlist/busId=5002/seatNo=6
	@GetMapping(value ="/fetchPassengerlist/busId={bID}/seatNo={sNo}", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Passenger> fetchAllPassengerDetailsByBusIdAndSeatNo(@PathVariable("bID")Long busId,@PathVariable("sNo")Integer seatNo){
		return passengerService.getPassengerDetailsBybusIdAndSeatNo(busId, seatNo);//passengerService.getPassengerDetailByName(pName);// passengerService.getPassengerDetailsByBookingID(bId);
	}
		
	//***********get passenger list by user id can be done via Booking service********
	
	
	
//	Update functionality
	//update passenger details by booking Id
//	@PutMapping(value ="/updatePassengerlist/bid= {bkId}",consumes = MediaType.APPLICATION_JSON_VALUE,
//			headers="Accept=application/json",produces=MediaType.APPLICATION_JSON_VALUE)
////	List<Passenger> createPassengerDetailsByBookingId(@RequestBody List<Passenger> pssg){
////		return passengerService.addNewPassengerDetails(pssg);
////	}
	//update passenger details by Ticket No.--only done by admin at busoffice
	@PutMapping(value ="/updatePassenger/tNo= {tkId}",consumes = MediaType.APPLICATION_JSON_VALUE,
	headers="Accept=application/json",produces=MediaType.APPLICATION_JSON_VALUE)
	Passenger updatePassengerDetailsByTicketNo(@PathVariable("tkId")Long tNo,@RequestBody Passenger pssg){
	return passengerService.updatePassengerDetailByTicketNo(tNo, pssg);
	}
	
	
	
//	Cancel functionality
	//update ticket status of passenger to rejected by booking Id
	@PutMapping(value ="/cancelPassenger/bkId= {bId}",consumes = MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json",produces=MediaType.APPLICATION_JSON_VALUE)
	List<Passenger> cancelPassengerlistTicketsByBookingId(@PathVariable("bId")Long bookId){
		return passengerService.updatePassengerTicketStatusToRejectedByBookingID(bookId);
		}
	
	
	
	//update ticket status of passenger to rejected by ticket No.-->for admin use only(if some one wants that from there booking ,
	//they want to remove one passenger--then they can approach admin at Booking office)
	@PutMapping(value ="/cancelPassenger/tNo= {tkId}",consumes = MediaType.APPLICATION_JSON_VALUE,
	headers="Accept=application/json",produces=MediaType.APPLICATION_JSON_VALUE)
	Passenger cancelPassengerTicketByTicketNo(@PathVariable("tkId")Long tNo){
	return passengerService.updatePassengerTicketStatusToRejectedByTicketNo(tNo);
	}
	
	
//	delete functionality(delete is not added as it can erase our record who has canceled)
	

}
