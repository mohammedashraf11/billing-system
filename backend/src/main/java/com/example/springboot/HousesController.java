package com.example.springboot;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.Models.HouseDetail;

@RestController
public class HousesController {
	ArrayList<String> houses = new ArrayList<>();
	ArrayList<String> owner = new ArrayList<>();
	ArrayList<HouseDetail> houseDetails = new ArrayList<>();

	@GetMapping("/owners")
	public String owners(){
		for(HouseDetail houseDetail:houseDetails){
			owner.add(houseDetail.Owner);
		}
		return String.join(",",owner);
	}
    @GetMapping("/houses")
	public String houses() {
		if(houseDetails.isEmpty()==true){	
			houseDetails.add(new HouseDetail("House 1 - blr", "Jalabuddin", "10000"));
			houseDetails.add(new HouseDetail("House 2 - koramangala", "Julius", "12000"));
			houseDetails.add(new HouseDetail("House 3 - ylk", "Jalbhushan", "14000"));
		}
		ArrayList<String> houseNames = new ArrayList<>();
		for (HouseDetail houseDetail : houseDetails) {
			houseNames.add(houseDetail.Name);
		}
		return String.join(", ", houseNames);
	}

	@GetMapping("/houses/{id}")
	public String housedetails(@PathVariable("id") String id){
		HouseDetail hou = houseDetails.get(Integer.parseInt(id));
		String ans = hou.Name + hou.Owner;
		return ans;
	}
	@PostMapping("/houses")
	public String houseinfo(@RequestBody String houseinfo){
		houses.add(houseinfo);
		return "house added"; 
	}
}
