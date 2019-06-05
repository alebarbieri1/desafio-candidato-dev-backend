package com.srmasset.thcepdetails.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

	private String state;
	private String city;
	private String neighborhood;
	private String address;

	@JsonProperty("estado")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("cidade")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("bairro")
	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	@JsonProperty("logradouro")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
