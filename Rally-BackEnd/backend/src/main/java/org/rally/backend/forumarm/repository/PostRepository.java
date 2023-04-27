package org.rally.backend.forumarm.repository;

import org.rally.backend.forumarm.models.ForumPost;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<ForumPost, Integer> {

}
