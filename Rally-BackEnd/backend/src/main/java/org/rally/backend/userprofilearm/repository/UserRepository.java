package org.rally.backend.userprofilearm.repository;

import org.rally.backend.userprofilearm.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByUserName(String userName);

}