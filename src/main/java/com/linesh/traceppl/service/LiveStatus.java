package com.linesh.traceppl.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.linesh.traceppl.model.CaseInfo;
import com.linesh.traceppl.model.Country;

public interface LiveStatus {

	 public CaseInfo getCountryData(String country) throws JsonParseException, JsonMappingException, IOException ;
	 
	 public List<Country> getAllCountries() throws JsonParseException, JsonMappingException, IOException ;
}
