package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_no")
	private Long ticketNo;
	@Column(name = "booking_id")
	private Long bookingId;
	@Column(name = "bus_id")
	private Long busId;
	@Column(name = "passenger_name")
	private String passengerName;
	@Column(name = "gender")
	private String gender;
	@Column(name = "age")
	private Integer age;
	@Column(name = "seat_no")
	private Integer seatNo;
	@Column(name = "ticket_status")
	private String ticketStatus;
	
	public Passenger() {
		super();
	}

	public Passenger(Long ticketNo, Long bookingId, Long busId, String passengerName, String gender, Integer age,
			Integer seatNo, String ticketStatus) {
		super();
		this.ticketNo = ticketNo;
		this.bookingId = bookingId;
		this.busId = busId;
		this.passengerName = passengerName;
		this.gender = gender;
		this.age = age;
		this.seatNo = seatNo;
		this.ticketStatus = ticketStatus;
	}

	public Long getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(Long ticketNo) {
		this.ticketNo = ticketNo;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	@Override
	public String toString() {
		return "Passenger [ticketNo=" + ticketNo + ", bookingId=" + bookingId + ", busId=" + busId + ", passengerName="
				+ passengerName + ", gender=" + gender + ", age=" + age + ", seatNo=" + seatNo + ", ticketStatus="
				+ ticketStatus + "]";
	}
	
	
	
	

}
