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

    List<TechnicalSkillsEntity> findByhTMLCssJavascriptGreaterThan(int value);



    List<TechnicalSkillsEntity> findBydockerGreaterThan(int i);

    List<TechnicalSkillsEntity> findByhibernateGreaterThan(int i);

    List<TechnicalSkillsEntity> findByangularGreaterThan(int i);

    List<TechnicalSkillsEntity> findByreactGreaterThan(int i);

    List<TechnicalSkillsEntity> findByspringGreaterThan(int i);

    List<TechnicalSkillsEntity> findBygitGreaterThan(int i);

    List<TechnicalSkillsEntity> findByrestfulGreaterThan(int i);

    List<TechnicalSkillsEntity> findByjenkinsGreaterThan(int i);

    List<TechnicalSkillsEntity> findByawsGreaterThan(int i);

}
