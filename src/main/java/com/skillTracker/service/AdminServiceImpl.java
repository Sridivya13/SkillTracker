package com.skillTracker.service;



import com.skillTracker.entity.NonTechnicalSkillsEntity;

import com.skillTracker.entity.TechnicalSkillsEntity;

import com.skillTracker.entity.UserEntity;

import com.skillTracker.model.SearchResponse;

import com.skillTracker.model.User;

import com.skillTracker.repository.NonTechnicalSkillsRepository;

import com.skillTracker.repository.TechnicalSkillsRepository;

import com.skillTracker.repository.UserRepository;

import com.skillTracker.utils.ServiceConstants;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import java.util.List;

import java.util.Optional;

@Service

@Slf4j

public class AdminServiceImpl implements AdminService {

    @Autowired

    UserRepository userRepository;

    @Autowired

    TechnicalSkillsRepository technicalSkillsRepository;

    @Autowired

    NonTechnicalSkillsRepository nonTechnicalSkillsRepository;

    @Override

    @Transactional

    public ResponseEntity<SearchResponse> searchProfile(String criteria, String criteriaValue) {

        List<User> userList = new ArrayList<>();

        List<UserEntity> userEntList = new ArrayList<>();

        List<TechnicalSkillsEntity> technicalSkillsEntityList = new ArrayList<>();

        List<NonTechnicalSkillsEntity> nonTechnicalSkillsEntityList = new ArrayList<>();

        try {

            if (criteria.equalsIgnoreCase("userName")) {

                userEntList = userRepository.findByUserNameLike(criteriaValue);

                for (UserEntity userEntity : userEntList) {

                    Optional<TechnicalSkillsEntity> technicalSkillsEntity1 = technicalSkillsRepository.findByUserId(userEntity.getUserId());

                    if (technicalSkillsEntity1.isPresent()) {

                        TechnicalSkillsEntity technicalSkillsEntity = technicalSkillsEntity1.get();

                        Optional<NonTechnicalSkillsEntity> nonTechnicalSkillsEntity1 = nonTechnicalSkillsRepository.findByUserId(userEntity.getUserId());

                        if (nonTechnicalSkillsEntity1.isPresent()) {

                            NonTechnicalSkillsEntity nonTechnicalSkillsEntity = nonTechnicalSkillsEntity1.get();

                            User user = User.builder()

                                    .userName(userEntity.getUserName())

                                    .associateId(userEntity.getAssociateId())

                                    .email(userEntity.getEmail())

                                    .mobileNumber(userEntity.getMobileNumber())

                                    .hTMLCssJavascript(technicalSkillsEntity.getHTMLCssJavascript())

                                    .angular(technicalSkillsEntity.getAngular())

                                    .react(technicalSkillsEntity.getReact())

                                    .spring(technicalSkillsEntity.getSpring())

                                    .restful(technicalSkillsEntity.getRestful())

                                    .hibernate(technicalSkillsEntity.getHibernate())

                                    .jenkins(technicalSkillsEntity.getJenkins())

                                    .aws(technicalSkillsEntity.getAws())

                                    .docker(technicalSkillsEntity.getDocker())

                                    .git(technicalSkillsEntity.getGit())

                                    .aptitude(nonTechnicalSkillsEntity.getAptitude())

                                    .communication(nonTechnicalSkillsEntity.getCommunication())

                                    .spoken(nonTechnicalSkillsEntity.getSpoken())

                                    .build();

                            userList.add(user);

                        }

                    }

                }

                return new ResponseEntity<>(SearchResponse.builder()

                        .userList(userList)

                        .message(ServiceConstants.SUCCESS)

                        .messageCode(HttpStatus.OK)

                        .messageType(ServiceConstants.SUCCESS)

                        .build(), HttpStatus.OK);

            } else if (criteria.equalsIgnoreCase("associateId")) {

                userEntList = userRepository.findByAssociateId(criteriaValue);

                for (UserEntity userEntity : userEntList) {

                    Optional<TechnicalSkillsEntity> technicalSkillsEntity1 = technicalSkillsRepository.findByUserId(userEntity.getUserId());

                    if (technicalSkillsEntity1.isPresent()) {

                        TechnicalSkillsEntity technicalSkillsEntity = technicalSkillsEntity1.get();

                        Optional<NonTechnicalSkillsEntity> nonTechnicalSkillsEntity1 = nonTechnicalSkillsRepository.findByUserId(userEntity.getUserId());

                        if (nonTechnicalSkillsEntity1.isPresent()) {

                            NonTechnicalSkillsEntity nonTechnicalSkillsEntity = nonTechnicalSkillsEntity1.get();

                            User user = User.builder()

                                    .userName(userEntity.getUserName())

                                    .associateId(userEntity.getAssociateId())

                                    .email(userEntity.getEmail())

                                    .mobileNumber(userEntity.getMobileNumber())

                                    .hTMLCssJavascript(technicalSkillsEntity.getHTMLCssJavascript())

                                    .angular(technicalSkillsEntity.getAngular())

                                    .react(technicalSkillsEntity.getReact())

                                    .spring(technicalSkillsEntity.getSpring())

                                    .restful(technicalSkillsEntity.getRestful())

                                    .hibernate(technicalSkillsEntity.getHibernate())

                                    .jenkins(technicalSkillsEntity.getJenkins())

                                    .aws(technicalSkillsEntity.getAws())

                                    .docker(technicalSkillsEntity.getDocker())

                                    .git(technicalSkillsEntity.getGit())

                                    .aptitude(nonTechnicalSkillsEntity.getAptitude())

                                    .communication(nonTechnicalSkillsEntity.getCommunication())

                                    .spoken(nonTechnicalSkillsEntity.getSpoken())

                                    .build();

                            userList.add(user);

                        }

                    }

                }

                return new ResponseEntity<>(SearchResponse.builder()

                        .userList(userList)

                        .message(ServiceConstants.SUCCESS)

                        .messageCode(HttpStatus.OK)

                        .messageType(ServiceConstants.SUCCESS)

                        .build(), HttpStatus.OK);

            } else if (criteria.equalsIgnoreCase("skill")) {

                if (ServiceConstants.technicalSkills.contains(criteriaValue)) {

                    switch (criteriaValue) {

                        case "hTMLCssJavascript":

                            technicalSkillsEntityList = technicalSkillsRepository.findByhTMLCssJavascriptGreaterThan(10);

                            break;

                        case "angular":

                            technicalSkillsEntityList = technicalSkillsRepository.findByangularGreaterThan(10);

                            break;

                        case "react":

                            technicalSkillsEntityList = technicalSkillsRepository.findByreactGreaterThan(10);

                            break;

                        case "spring":

                            technicalSkillsEntityList = technicalSkillsRepository.findByspringGreaterThan(10);

                            break;

                        case "restful":

                            technicalSkillsEntityList = technicalSkillsRepository.findByrestfulGreaterThan(10);

                            break;

                        case "git":

                            technicalSkillsEntityList = technicalSkillsRepository.findBygitGreaterThan(10);

                            break;

                        case "docker":

                            technicalSkillsEntityList = technicalSkillsRepository.findBydockerGreaterThan(10);

                            break;

                        case "jenkins":

                            technicalSkillsEntityList = technicalSkillsRepository.findByjenkinsGreaterThan(10);

                            break;

                        case "aws":

                            technicalSkillsEntityList = technicalSkillsRepository.findByawsGreaterThan(10);

                            break;

                        case "hibernate":

                            technicalSkillsEntityList = technicalSkillsRepository.findByhibernateGreaterThan(10);

                            break;

                        default:

                            throw new RuntimeException();

                    }

                    for (TechnicalSkillsEntity technicalSkillsEntity : technicalSkillsEntityList) {

                        Optional<UserEntity> userEntity1 = userRepository.findById(technicalSkillsEntity.getUserId());

                        if (userEntity1.isPresent()) {

                            UserEntity userEntity = userEntity1.get();

                            Optional<NonTechnicalSkillsEntity> nonTechnicalSkillsEntity1 = nonTechnicalSkillsRepository.findByUserId(technicalSkillsEntity.getUserId());

                            if (nonTechnicalSkillsEntity1.isPresent()) {

                                NonTechnicalSkillsEntity nonTechnicalSkillsEntity = nonTechnicalSkillsEntity1.get();

                                User user = User.builder()

                                        .userName(userEntity.getUserName())

                                        .associateId(userEntity.getAssociateId())

                                        .email(userEntity.getEmail())

                                        .mobileNumber(userEntity.getMobileNumber())

                                        .hTMLCssJavascript(technicalSkillsEntity.getHTMLCssJavascript())

                                        .angular(technicalSkillsEntity.getAngular())

                                        .react(technicalSkillsEntity.getReact())

                                        .spring(technicalSkillsEntity.getSpring())

                                        .restful(technicalSkillsEntity.getRestful())

                                        .hibernate(technicalSkillsEntity.getHibernate())

                                        .jenkins(technicalSkillsEntity.getJenkins())

                                        .aws(technicalSkillsEntity.getAws())

                                        .docker(technicalSkillsEntity.getDocker())

                                        .git(technicalSkillsEntity.getGit())

                                        .aptitude(nonTechnicalSkillsEntity.getAptitude())

                                        .communication(nonTechnicalSkillsEntity.getCommunication())

                                        .spoken(nonTechnicalSkillsEntity.getSpoken())

                                        .build();

                                userList.add(user);

                            }

                        }

                    }

                    return new ResponseEntity<>(SearchResponse.builder()

                            .userList(userList)

                            .message(ServiceConstants.SUCCESS)

                            .messageCode(HttpStatus.OK)

                            .messageType(ServiceConstants.SUCCESS)

                            .build(), HttpStatus.OK);

                } else if (ServiceConstants.nonTechnicalSkills.contains(criteriaValue)) {

                    switch (criteriaValue) {

                        case "spoken":

                            nonTechnicalSkillsEntityList = nonTechnicalSkillsRepository.findByspokenGreaterThan(10);

                            break;

                        case "communication":

                            nonTechnicalSkillsEntityList = nonTechnicalSkillsRepository.findBycommunicationGreaterThan(10);

                            break;

                        case "aptitude":

                            nonTechnicalSkillsEntityList = nonTechnicalSkillsRepository.findByaptitudeGreaterThan(10);

                            break;

                        default:

                            throw new RuntimeException();

                    }

                    for (NonTechnicalSkillsEntity nonTechnicalSkillsEntity : nonTechnicalSkillsEntityList) {

                        Optional<UserEntity> userEntity1 = userRepository.findById(nonTechnicalSkillsEntity.getUserId());

                        if (userEntity1.isPresent()) {

                            UserEntity userEntity = userEntity1.get();

                            Optional<TechnicalSkillsEntity> technicalSkillsEntity1 = technicalSkillsRepository.findByUserId(userEntity.getUserId());

                            if (technicalSkillsEntity1.isPresent()) {

                                TechnicalSkillsEntity technicalSkillsEntity = technicalSkillsEntity1.get();

                                User user = User.builder()

                                        .userName(userEntity.getUserName())

                                        .associateId(userEntity.getAssociateId())

                                        .email(userEntity.getEmail())

                                        .mobileNumber(userEntity.getMobileNumber())

                                        .hTMLCssJavascript(technicalSkillsEntity.getHTMLCssJavascript())

                                        .angular(technicalSkillsEntity.getAngular())

                                        .react(technicalSkillsEntity.getReact())

                                        .spring(technicalSkillsEntity.getSpring())

                                        .restful(technicalSkillsEntity.getRestful())

                                        .hibernate(technicalSkillsEntity.getHibernate())

                                        .jenkins(technicalSkillsEntity.getJenkins())

                                        .aws(technicalSkillsEntity.getAws())

                                        .docker(technicalSkillsEntity.getDocker())

                                        .git(technicalSkillsEntity.getGit())

                                        .aptitude(nonTechnicalSkillsEntity.getAptitude())

                                        .communication(nonTechnicalSkillsEntity.getCommunication())

                                        .spoken(nonTechnicalSkillsEntity.getSpoken())

                                        .build();

                                userList.add(user);

                            }

                        }

                    }

                    return new ResponseEntity<>(SearchResponse.builder()

                            .userList(userList)

                            .message(ServiceConstants.SUCCESS)

                            .messageCode(HttpStatus.OK)

                            .messageType(ServiceConstants.SUCCESS)

                            .build(), HttpStatus.OK);

                } else {

                    return new ResponseEntity<>(SearchResponse.builder()

                            .message(ServiceConstants.ERROR_SEARCH)

                            .messageCode(HttpStatus.INTERNAL_SERVER_ERROR)

                            .messageType(ServiceConstants.FAILURE)

                            .build(), HttpStatus.INTERNAL_SERVER_ERROR);

                }

            }

        } catch (Exception e) {

            log.error("Error while searching profile {}", e.getMessage());

        }

        return new ResponseEntity<>(SearchResponse.builder()

                .message(ServiceConstants.ERROR_SEARCH)

                .messageCode(HttpStatus.INTERNAL_SERVER_ERROR)

                .messageType(ServiceConstants.FAILURE)

                .build(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

}



































