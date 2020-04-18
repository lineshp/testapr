package com.linesh.traceppl.model;

public class CaseInfo {

	String country;
	long confirmed;
	long recovered;
	long critical;
	long death;
	long latitude;
	long longitude;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(long confirmed) {
		this.confirmed = confirmed;
	}
	public long getRecovered() {
		return recovered;
	}
	public void setRecovered(long recovered) {
		this.recovered = recovered;
	}
	public long getCritical() {
		return critical;
	}
	public void setCritical(long critical) {
		this.critical = critical;
	}
	public long getDeath() {
		return death;
	}
	public void setDeath(long death) {
		this.death = death;
	}
	public long getLatitude() {
		return latitude;
	}
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	public long getLongitude() {
		return longitude;
	}
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	
	
	/*
	 * 0:{7 items
"country":"India"
"confirmed":14352
"recovered":2041
"critical":0
"deaths":486
"latitude":20.593684
"longitude":78.96288
	 */
}
