package com.mannygram.urlShortner.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mannygram.urlShortner.repository.URLRepository;
import com.mannygram.urlShortner.valueObject.URLDetails;

@RestController
@RequestMapping("/URLShortner")
public class UrlActionController {
	
	@Autowired URLRepository repo;
	
	static int count=2;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public void getShortUrl(@PathVariable("id") String id,HttpServletResponse response) throws IOException {
		System.out.println(id);
		URLDetails urlDetails = repo.getURLDetails(id);
		response.sendRedirect(urlDetails.getUrl());
	}

	@RequestMapping(value="/getId",method=RequestMethod.POST)
	public ResponseEntity<String> getId(@RequestBody(required=true) String url) {
		URLDetails details = new URLDetails();
		details.setId(""+count++);
		details.setUrl(url);
		details=repo.save(details);
		return new ResponseEntity<String>(details.getId(),HttpStatus.OK);
	}

}
