package com.linesh.traceppl.controller;


import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.linesh.traceppl.model.CaseInfo;
import com.linesh.traceppl.model.Country;
import com.linesh.traceppl.service.LiveStatus;


@Controller
public class LoginController {
	
	@Autowired
	LiveStatus liveStatus;
	
	/*@RequestMapping("/")
	public ModelAndView  loadIndex(HttpServletRequest hs) throws JsonParseException, JsonMappingException, IOException {
		List<Country> countries = liveStatus.getAllCountries();
		ModelAndView mv = new ModelAndView();
		mv.addObject("countryList", countries);
		mv.addObject("user", "TEST123");
		mv.setViewName("index");
		return mv;
	}*/
	
	@RequestMapping("user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}
	
	@RequestMapping("/countryInfo")
	@ResponseBody
	public CaseInfo getDataByCountry(@RequestParam(name = "countryName") String countryName) throws JsonParseException, JsonMappingException, IOException {
		
		System.out.println("country name" + countryName);
	//	return null;
		CaseInfo caseInfo = liveStatus.getCountryData(countryName);
	/*	ModelAndView mv = new ModelAndView();
		mv.addObject("caseInfo", caseInfo);
		mv.setViewName("caseDisplay");
		return 
		return mv;*/
		return caseInfo;
		
	}
}
