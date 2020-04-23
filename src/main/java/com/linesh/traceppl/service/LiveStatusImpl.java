package com.linesh.traceppl.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linesh.traceppl.model.CaseInfo;
import com.linesh.traceppl.model.Country;

@Service
public class LiveStatusImpl implements LiveStatus{

	@Override
	public CaseInfo getCountryData(String country) throws JsonParseException, JsonMappingException, IOException {
		final String uri = "https://covid-19-data.p.rapidapi.com/country/code?format=json&code="+country;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.put("x-rapidapi-host",   Arrays.asList(new String("covid-19-data.p.rapidapi.com")));
		headers.put("x-rapidapi-key",   Arrays.asList(new String("9c456ba4a6msh1bcbbb00f80b8a0p1090afjsn2758eb875fd2")));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		String s=  result.getBody();
		ObjectMapper mapper = new ObjectMapper();
		List<CaseInfo> cs = Arrays.asList(mapper.readValue(s, CaseInfo[].class));
		return cs.get(0);

	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		final String uri = "https://covid-19-data.p.rapidapi.com/country?format=json&name=italy";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.put("x-rapidapi-host",   Arrays.asList(new String("covid-19-data.p.rapidapi.com")));
		headers.put("x-rapidapi-key",   Arrays.asList(new String("9c456ba4a6msh1bcbbb00f80b8a0p1090afjsn2758eb875fd2")));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		String s =  result.getBody();
		ObjectMapper mapper = new ObjectMapper();
		List<CaseInfo> cs = Arrays.asList(mapper.readValue(s, CaseInfo[].class));
		System.out.println(cs.get(0).getConfirmed());
	}

	@Override
	public List<Country> getAllCountries() throws JsonParseException, JsonMappingException, IOException, RestClientException {
		final String uri = "https://covid-19-data.p.rapidapi.com/country/all?format=json";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.put("x-rapidapi-host",   Arrays.asList(new String("covid-19-data.p.rapidapi.com")));
		headers.put("x-rapidapi-key",   Arrays.asList(new String("9c456ba4a6msh1bcbbb00f80b8a0p1090afjsn2758eb875fd2")));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		String s=  result.getBody();
		ObjectMapper mapper = new ObjectMapper();
		List<Country> cs = Arrays.asList(mapper.readValue(s, Country[].class));
		System.out.println(cs.get(0).getConfirmed());
		return cs;
	}

}
