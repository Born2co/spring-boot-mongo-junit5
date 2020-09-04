package com.springboot.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(collection = "booking")
public class Booking {

	@Id
	private String id;
	private String type;
	private String location;

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getLocation() {
		return location;
	}

	public Booking(String id, String type, String location) {
		this.id = id;
		this.type = type;
		this.location = location;
	}

	public Booking() {
	}

}
