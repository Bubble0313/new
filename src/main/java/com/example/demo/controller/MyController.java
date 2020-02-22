package com.example.demo.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {
	
	private RestTemplate restTemplate = new RestTemplate();
	private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);
	@Value("${myurl}")
	private String myurl;
	
	@PostMapping("/pass")
	public int passParams(@RequestParam List<Integer> p){
		HttpEntity<List<Integer>> request = new HttpEntity<List<Integer>>(p);
		ResponseEntity<Integer> result = restTemplate.exchange(myurl, HttpMethod.POST, request, int.class);
		LOGGER.info("2 params are {} and {}", request.getBody().get(0), request.getBody().get(1));
		return result.getBody();
	}
	
	/*public String passParams(String p){
		HttpEntity<String> request = new HttpEntity<String>(p);
		ResponseEntity<String> result = restTemplate.exchange(myurl, HttpMethod.POST, request, String.class);
		LOGGER.info("2 params are and {}", result);
		return result.getBody();
	}*/
	
	/*@RequestMapping("/pass")
	public int passParams(@RequestParam int param1, @RequestParam int param2){

		String url = myurl + "/" + Integer.toString(param1) + "/" + Integer.toString(param2);
		int result = restTemplate.getForObject(url, int.class);
		LOGGER.info("2 params are {} and {}", param1, param2);
		return result;
	}*/
	
	
	/*@GetMapping("/hello")
	public String Hello()
	{
		return "Hello World";
	}
	
	public ResponseEntity<String> hello(){
		return new ResponseEntity<>("Hello", HttpStatus.OK); 
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam String firstname, @RequestParam("familyname") String lastname)
	{
		return "Hello " + firstname + " " + lastname;
	}
	
	@GetMapping("/hi/{name}")
	public String hi(@PathVariable String name){
		return "Hi " + name;
	}
	
	@PostMapping("/name")
	public ResponseEntity<String> name(@RequestParam String fn, @RequestParam String ln){
		return new ResponseEntity<String>("Your name is " + fn + " " + ln, HttpStatus.CREATED);
	}*/	
}
