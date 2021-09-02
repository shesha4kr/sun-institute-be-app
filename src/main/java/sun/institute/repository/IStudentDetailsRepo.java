package sun.institute.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sun.institute.model.StudentDetails;

public interface IStudentDetailsRepo extends CrudRepository<StudentDetails, Integer> {

	StudentDetails findByUserName(String userName);

	StudentDetails findByStudId(Integer studId);

	@Query("SELECT s.userName FROM StudentDetails s WHERE s.userName !=:userName")
	List<String> findAllUserNames(@Param("userName") String userName);

	@Modifying
	@Transactional
	@Query("UPDATE StudentDetails s SET s.userName=:userName WHERE s.studId =:studId")
	void updateUserName(@Param("userName") String userName, @Param("studId") Integer studId);

	@Modifying
	@Transactional
	@Query("UPDATE StudentDetails s SET s.dob=:dob WHERE s.studId =:studId")
	Integer updateDOB(@Param("dob") LocalDate dob, @Param("studId") Integer studId);
	
	@Modifying
	@Transactional
	@Query("UPDATE StudentDetails s SET s.password=:newPassword WHERE s.studId=:studId")
	Integer updatePassword(@Param("studId") Integer studId, @Param("newPassword") String newPassword);

}
