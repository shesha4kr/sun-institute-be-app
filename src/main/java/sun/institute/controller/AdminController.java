package sun.institute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sun.institute.data.LoadDbData;
import sun.institute.repository.IAITRepo;
import sun.institute.repository.IStudentDetailsRepo;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	IStudentDetailsRepo studentRepo;
	
	@Autowired
	IAITRepo aitRepo;
	
	@Autowired
	LoadDbData loadDb;

}
