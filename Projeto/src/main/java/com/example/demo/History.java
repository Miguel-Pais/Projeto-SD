package com.example.demo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "history")
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int historyID;
	private Date startDate;
	private Date endDate;
	@OneToOne
	@JoinColumn(name = "userID", referencedColumnName = "userID")
	private User user;
	@OneToOne
	@JoinColumn(name = "serviceID", referencedColumnName = "serviceID")
	private Service service;
	@OneToOne
	@JoinColumn(name = "workerID", referencedColumnName = "workerID")
	private Worker worker;

	public int getHistoryID() {
		return historyID;
	}

	public void setHistoryID(int historyID) {
		this.historyID = historyID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

}
