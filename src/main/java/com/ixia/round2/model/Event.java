package com.ixia.round2.model;

import java.time.LocalDateTime;

//@Entity
public class Event {
	
	//@Id
	String Id;
	String eventname, host, category;
	LocalDateTime starttime;
	LocalDateTime endtime;
	
	public Event() {
		super();
	}

	public Event(String id, String eventname, String host, String category, LocalDateTime starttime, LocalDateTime endtime) {
		super();
		Id = id;
		this.eventname = eventname;
		this.host = host;
		this.category = category;
		this.starttime = starttime;
		this.endtime = endtime;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDateTime getStarttime() {
		return starttime;
	}

	public void setStarttime(LocalDateTime localDateTime) {
		this.starttime = localDateTime;
	}

	public LocalDateTime getEndtime() {
		return endtime;
	}

	public void setEndtime(LocalDateTime localDateTime) {
		this.endtime = localDateTime;
	}

	@Override
	public String toString() {
		return "Event [Id=" + Id + ", eventname=" + eventname + ", host=" + host + ", category=" + category
				+ ", starttime=" + starttime + ", endtime=" + endtime + "]";
	}
	
}
