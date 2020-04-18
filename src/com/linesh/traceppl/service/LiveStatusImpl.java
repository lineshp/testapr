package com.linesh.traceppl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.linesh.traceppl.model.CaseInfo;
import com.linesh.traceppl.model.Country;

@Service
public class LiveStatusImpl implements LiveStatus{

	@Override
	public CaseInfo getCountryData(String country) {
		// TODO Auto-generated method stub
		return new CaseInfo();
	}

	@Override
	public List<Country> getAllCountries() {
		Country c1 = new Country();
		c1.setName("Australia");
		List<Country> countries= new ArrayList<Country>();
		countries.add(c1);
		return countries;
	}

}
