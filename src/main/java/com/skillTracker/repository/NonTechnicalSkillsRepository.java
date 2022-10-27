package com.skillTracker.repository;

import com.skillTracker.entity.NonTechnicalSkillsEntity;
import com.skillTracker.entity.TechnicalSkillsEntity;
import com.skillTracker.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NonTechnicalSkillsRepository extends MongoRepository<NonTechnicalSkillsEntity, Integer> {

    Optional<NonTechnicalSkillsEntity> findByUserId(Integer userId);

    @Query("{ criteriaValue : { $gt: ?10 } }")
    List<NonTechnicalSkillsEntity> findBySkill(String criteriaValue);
}
