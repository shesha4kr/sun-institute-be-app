package sun.institute.repository;

import org.springframework.data.repository.CrudRepository;

import sun.institute.model.StudentDetails;

public interface IStudentDetailsRepo extends CrudRepository<StudentDetails, Integer> {
	
	StudentDetails findByUserName(String userName);

}
