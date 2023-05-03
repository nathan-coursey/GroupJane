package org.rally.backend.resourcesarm.models.data;

import jakarta.transaction.Transactional;
import org.rally.backend.resourcesarm.models.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional

public interface ResourceRepository extends CrudRepository<Resource, Integer> {
}
