package com.skillTracker.repository;

import com.skillTracker.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Integer> {

   // List<UserEntity> findByUserId(Integer userId);

    List<UserEntity> findByUserNameLike(String userName);

    List<UserEntity> findByAssociateId(String associateId);
}
