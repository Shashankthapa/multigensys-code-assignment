package com.example.eighth;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userName;
	private String email;
	private Long busId;
	private String busName;
	private int noOfSeat;
	private double price;
	private double total;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public Transaction() {
		super();
	}

	public Transaction(Long id, String userName, String email, Long busId, String busName, int noOfSeat, double price,
			double total, Date date) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.busId = busId;
		this.busName = busName;
		this.noOfSeat = noOfSeat;
		this.price = price;
		this.total = total;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public int getNoOfSeat() {
		return noOfSeat;
	}

	public void setNoOfSeat(int noOfSeat) {
		this.noOfSeat = noOfSeat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", userName=" + userName + ", email=" + email + ", busId=" + busId
				+ ", busName=" + busName + ", noOfSeat=" + noOfSeat + ", price=" + price + ", total=" + total
				+ ", date=" + date + "]";
	}

	// Constructors, getters and setters

}
