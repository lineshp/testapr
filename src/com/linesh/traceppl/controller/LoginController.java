package com.linesh.traceppl.controller;


import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
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
	
	@RequestMapping("/traceppl")
	public ModelAndView  loadIndex(HttpServletRequest hs) throws JsonParseException, JsonMappingException, IOException {
		List<Country> countries = liveStatus.getAllCountries();
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//String currentPrincipalName = authentication.
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//System.out.println(auth.getDetails().);
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//Map<String , Object> userDetails = ((DefaultOidcUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAttributes();
      //  System.out.println(userDetails.get("name"));
      //  System.out.println(userDetails.get("email"));
     //   System.out.println(userDetails.get("given_name"));
        
		ModelAndView mv = new ModelAndView();
		mv.addObject("countryList", countries);
		mv.addObject("user", "TEST123");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}
	
	@RequestMapping("/traceppl/countryInfo")
	public ModelAndView getDataByCountry(@RequestParam(name = "selectedCountry") String countryName) throws JsonParseException, JsonMappingException, IOException {
		CaseInfo caseInfo = liveStatus.getCountryData(countryName);
		ModelAndView mv = new ModelAndView();
		mv.addObject("caseInfo", caseInfo);
		mv.setViewName("caseDisplay");
		return mv;
		
	}
}
