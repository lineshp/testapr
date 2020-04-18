package com.linesh.traceppl.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.linesh.traceppl.model.CaseInfo;
import com.linesh.traceppl.model.Country;
import com.linesh.traceppl.service.LiveStatus;

@Controller
public class LoginController {
	
	@Autowired
	LiveStatus liveStatus;
	
	@RequestMapping("/traceppl")
	public ModelAndView  loadIndex() {
		List<Country> countries = liveStatus.getAllCountries();
		ModelAndView mv = new ModelAndView();
		mv.addObject("countryList", countries);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}
	
	@RequestMapping("/traceppl/countryInfo")
	public ModelAndView getDataByCountry(@RequestParam(name = "selectedCountry") String countryName) {
		CaseInfo caseInfo = liveStatus.getCountryData(countryName);
		ModelAndView mv = new ModelAndView();
		mv.addObject("caseInfo", caseInfo);
		mv.setViewName("caseDisplay");
		return mv;
		
	}
}
