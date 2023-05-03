package org.rally.backend.resourcesarm.models.data;

import org.rally.backend.resourcesarm.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Iterable<Category> findAllOrderByName(String name);
}
