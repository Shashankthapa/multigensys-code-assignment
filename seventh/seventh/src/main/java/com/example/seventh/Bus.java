package com.example.seventh;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String busName;
    private String destination;
    private String busType;
    
    @Temporal(TemporalType.TIME)
    private Date departureTime;
    
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;
    
    private int totalSeat;
    private double price;

    // Constructors, getters and setters
    
	public Bus() {
		super();
	}

	public Bus(Long id, String busName, String destination, String busType, Date departureTime, Date arrivalTime,
			int totalSeat, double price) {
		super();
		this.id = id;
		this.busName = busName;
		this.destination = destination;
		this.busType = busType;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.totalSeat = totalSeat;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", busName=" + busName + ", destination=" + destination + ", busType=" + busType
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", totalSeat=" + totalSeat
				+ ", price=" + price + "]";
	}
    
	
    
}
