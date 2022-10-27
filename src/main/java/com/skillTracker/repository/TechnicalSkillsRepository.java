package com.skillTracker.repository;

import com.skillTracker.entity.TechnicalSkillsEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TechnicalSkillsRepository extends MongoRepository<TechnicalSkillsEntity, Integer> {

    Optional<TechnicalSkillsEntity> findByUserId(Integer userId);

    @Query("{ criteriaValue : { $gt: ?10 } }")
    List<TechnicalSkillsEntity> findBySkill(String criteriaValue);

}
