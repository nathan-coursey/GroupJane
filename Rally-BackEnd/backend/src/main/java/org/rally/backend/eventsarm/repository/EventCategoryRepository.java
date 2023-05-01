package org.rally.backend.eventsarm.repository;

import org.rally.backend.eventsarm.models.EventCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCategoryRepository extends CrudRepository <EventCategory, Integer> {
}
