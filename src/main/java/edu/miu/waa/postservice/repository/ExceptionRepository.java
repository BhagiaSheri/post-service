package edu.miu.waa.postservice.repository;

import edu.miu.waa.postservice.domain.entity.Exception;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepository extends CrudRepository<Exception, Long> {
}
