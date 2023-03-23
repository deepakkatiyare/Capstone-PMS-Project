package com.revature;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class G1ApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(G1ApiGatewayServiceApplication.class, args);
	}
	
	@GetMapping("/allergy-service-fallback")
	public ResponseEntity<ErrorResponse> allergyServiceFallback() {
		ErrorResponse errorDetails = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, LocalDateTime.now(),
				"Allergy Service is down! Please try later", "For critical support please call on 18080800000 or mail us on spport@revature.com");
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@GetMapping("/patient-info-service-fallback")
	public ResponseEntity<ErrorResponse> patientInfoServiceFallback() {
		ErrorResponse errorDetails = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, LocalDateTime.now(),
				"PatientInfo Service is down! Please try later", "For critical support please call on 18080800000 or mail us on spport@revature.com");
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@GetMapping("/authentication-service-fallback")
	public ResponseEntity<ErrorResponse> authenticationServiceFallback() {
		ErrorResponse errorDetails = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, LocalDateTime.now(),
				"Authentication Service is down! Please try later", "For critical support please call on 18080800000 or mail us on spport@revature.com");
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}

}
