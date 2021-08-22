package sun.institute.repository;

import org.springframework.data.repository.CrudRepository;

import sun.institute.model.AITRecord;

public interface IAITRepo extends CrudRepository<AITRecord, Integer> {

}
