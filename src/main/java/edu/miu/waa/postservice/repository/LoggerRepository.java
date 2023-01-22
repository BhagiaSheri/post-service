package edu.miu.waa.postservice.repository;

import edu.miu.waa.postservice.domain.entity.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends CrudRepository<Logger, Long> {
}
