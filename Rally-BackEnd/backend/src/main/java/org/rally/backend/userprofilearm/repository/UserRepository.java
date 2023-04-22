package org.rally.backend.userprofilearm.repository;

import org.rally.backend.userprofilearm.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserName(String userName);
    Boolean existsByUserName(String username);
}