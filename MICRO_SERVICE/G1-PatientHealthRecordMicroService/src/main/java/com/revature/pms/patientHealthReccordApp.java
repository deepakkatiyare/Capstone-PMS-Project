package com.revature.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
public class patientHealthReccordApp {

	public static void main(String[] args) {
		SpringApplication.run(patientHealthReccordApp.class, args);
	}
}


//{
//    "visitId": 3,
//    "patientId": 4,
//    "height": 37.5,
//    "weight": 80.0,
//    "bloodPressureSystolic": 70,
//    "bloodPressureDiastolic": 125,
//    "bodyTemperature": 40.0,
//    "respirationRate": 32,
//    "bloodGroup": "O-",
//    "nurseEmail": "nurse3.pms@gmail.com",
//    "physicianEmail": "physician3.pms@gmail.com",
//    "appointmentId": 4,
//    "keyNotes": "qwerfvbnjuytrfdsergbnmkiuyhgfgh",
//    "allergyId": 8
//}