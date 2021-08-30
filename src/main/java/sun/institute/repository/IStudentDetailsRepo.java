package sun.institute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sun.institute.model.StudentDetails;

public interface IStudentDetailsRepo extends CrudRepository<StudentDetails, Integer> {

	StudentDetails findByUserName(String userName);

	StudentDetails findByStudId(Integer studId);

	@Query("SELECT s.userName FROM StudentDetails s WHERE s.userName !=:userName")
	List<String> findAllUserNames(@Param("userName") String userName);

}
