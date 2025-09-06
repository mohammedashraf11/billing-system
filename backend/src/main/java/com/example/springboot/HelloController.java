package com.example.springboot;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	public ArrayList<String>  hotels = new ArrayList<String>();

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/hotels")
	public String hotels() {
		if(hotels.isEmpty()==true){
			hotels.add("hotel 1 - bangalore - 001011");
			hotels.add("hotel 2 - hyderabad - 101010");
			hotels.add("hotel 3 - vizag - 1010101");
		}
		String ans = String.join(", ",hotels);
		return ans;
	}

	@GetMapping("/hotel/{id}")
	public String hotel1Detail(@PathVariable("id") String id){
		return hotels.get(Integer.parseInt(id));
	}

	@PostMapping("/hotels")
	public String addHotel(@RequestBody String hotelInfo){
		hotels.add(hotelInfo);
		return "Added Hotel";
	}
}
