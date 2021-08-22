package sun.institute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sun.institute.model.AITRecord;

public interface IAITRepo extends CrudRepository<AITRecord, Integer> {
	
	@Query("SELECT a from AITRecord a WHERE a.userName=:userName ORDER BY a.mockTest DESC")
	List<AITRecord> findLatestMockTest(@Param("userName")String userName);
	
	@Query("SELECT COUNT(a) from AITRecord a WHERE a.mockTest = :mockTest")
	Integer findTotalRecordsForAMocktest(@Param("mockTest") String mockTest);
	
	@Query("SELECT COUNT(a) from AITRecord a WHERE a.totalMarks < :totalMarks AND a.mockTest = :mockTest")
	Integer findTotalStudentsBehind(@Param("totalMarks") Integer totalMarks, @Param("mockTest") String mockTest);

}
