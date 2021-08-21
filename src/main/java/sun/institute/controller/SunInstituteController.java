package sun.institute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sun.institute.repository.ISunInstituteRepository;

@RestController
@CrossOrigin
public class SunInstituteController {
	
//	@Autowired
//	ISunInstituteRepository sunRepo;
	
	@GetMapping("/") 
	public String homePage() {
		return "Welcome to Sun Institute";
	}

}
