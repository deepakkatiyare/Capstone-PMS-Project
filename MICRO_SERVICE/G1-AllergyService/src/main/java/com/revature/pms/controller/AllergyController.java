package com.revature.pms.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.revature.pms.model.Allergy;
import com.revature.pms.service.AllergyService;


@RestController
public class AllergyController {
	
	@Autowired
	private AllergyService allergyService;
	
	@GetMapping("/allergy")
	public ResponseEntity<List<Allergy>> getAll(){
		List<Allergy> allergies = null;
		try {
			 allergies= allergyService.getAllergies();
			if(allergies.isEmpty())
				return new ResponseEntity<List<Allergy>>(allergies,HttpStatus.NO_CONTENT);
		}
		catch (NullPointerException e){
			return new ResponseEntity<>(allergies, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Allergy>>(allergies,HttpStatus.OK);
	}
	
	@GetMapping("/allergy/{id}")
	public  ResponseEntity<Allergy> getAllergy(@PathVariable int id){
		Allergy allergy = null;
		try {
			allergy = allergyService.getAllergy(id);
		}catch (NullPointerException e){
			return new ResponseEntity<>(allergy,HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(NoSuchElementException e){
			return new ResponseEntity<Allergy>(allergy,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Allergy>(allergy,HttpStatus.OK);
	}
//	@GetMapping("/users")
//	public String getUser() throws UnirestException {
//		HttpResponse<String> response = Unirest.post("https://dev-85rf4haa0cxb2bmc.us.auth0.com/oauth/token")
//				  .header("content-type", "application/json")
//				  .body("{\"client_id\":\"OIEQBpanAwWPrsCe4d3n4ng1yLkMWLMd\",\"client_secret\":\"PPmyV19VwGVuZMsOliyJbCme6riSkowsataqsbret7l2RXysYmCMiRsUymjKUdJR\",\"audience\":\"https://dev-85rf4haa0cxb2bmc.us.auth0.com/api/v2/\",\"grant_type\":\"client_credentials\"}")
//				  .asString();
//		HttpResponse<String> response1= Unirest.post("https://dev-85rf4haa0cxb2bmc.us.auth0.com/api/v2/users")
//				.header("authorization", response.getBody())
//				.asString();
//		
//		return response.getBody();
//	}
}
