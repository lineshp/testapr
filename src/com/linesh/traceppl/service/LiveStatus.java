package com.linesh.traceppl.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.linesh.traceppl.model.CaseInfo;
import com.linesh.traceppl.model.Country;

public interface LiveStatus {

	 public CaseInfo getCountryData(String country);
	 
	 public List<Country> getAllCountries();
}
