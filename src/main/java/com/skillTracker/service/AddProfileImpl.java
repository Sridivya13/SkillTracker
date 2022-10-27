package com.skillTracker.service;

import com.skillTracker.entity.NonTechnicalSkillsEntity;
import com.skillTracker.entity.TechnicalSkillsEntity;
import com.skillTracker.entity.UserEntity;
import com.skillTracker.model.*;
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

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class AddProfileImpl implements AddProfile {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TechnicalSkillsRepository technicalSkillsRepository;

    @Autowired
    NonTechnicalSkillsRepository nonTechnicalSkillsRepository;


    /**
     * To register user
     *
     * @param user
     * @return UserResponse
     */
    @Transactional
    public ResponseEntity<UserResponse> registerUser(User user) {
        try {
            UserEntity userentity = UserEntity.builder()
                    .userName(user.getUserName())
                    .associateId(user.getAssociateId())
                    .email(user.getEmail())
                    .mobileNumber(user.getMobileNumber())
                    .lastUpdatedDate(LocalDateTime.now())
                    .build();

            UserEntity newUser = userRepository.save(userentity);

            TechnicalSkillsEntity technicalSkillsEntity = TechnicalSkillsEntity.builder()
                    .angular(user.getAngular())
                    .aws(user.getAws())
                    .docker(user.getDocker())
                    .hibernate(user.getHibernate())
                    .hTMLCssJavascript(user.getHTMLCssJavascript())
                    .react(user.getReact())
                    .git(user.getGit())
                    .restful(user.getRestful())
                    .spring(user.getSpring())
                    .userId(newUser.getUserId())
                    .jenkins(user.getJenkins())
                    .build();

            technicalSkillsRepository.save(technicalSkillsEntity);


            NonTechnicalSkillsEntity nonTechnicalSkillsEntity = NonTechnicalSkillsEntity.builder()
                    .aptitude(user.getAptitude())
                    .communication(user.getCommunication())
                    .spoken(user.getSpoken())
                    .userId(newUser.getUserId())
                    .build();

            nonTechnicalSkillsRepository.save(nonTechnicalSkillsEntity);


            return new ResponseEntity<>(UserResponse.builder().userId(newUser.getUserId()).message(ServiceConstants.ID_CREATED)
                    .messageCode(HttpStatus.OK)
                    .messageType(ServiceConstants.SUCCESS)
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error while creating profile {}", e.getMessage());
        }
        return new ResponseEntity<>(UserResponse.builder().message(ServiceConstants.FAILURE)
                .messageCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .messageType(ServiceConstants.FAILURE)
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<UpdateResponse> updateProfile(Integer userId, Skills skills) {
        try {
            Optional<UserEntity> userEntity = userRepository.findById(userId);
            if (userEntity.isPresent()) {
                UserEntity userEntity1 = userEntity.get();
                if ((Duration.between(LocalDateTime.now().toLocalDate().atStartOfDay(), userEntity1.getLastUpdatedDate().toLocalDate().atStartOfDay()).toDays() > ServiceConstants.TEN)) {
                    TechnicalSkillsEntity technicalSkillsEntity = TechnicalSkillsEntity.builder()
                            .angular(skills.getAngular())
                            .aws(skills.getAws())
                            .docker(skills.getDocker())
                            .hibernate(skills.getHibernate())
                            .hTMLCssJavascript(skills.getHTMLCssJavascript())
                            .react(skills.getReact())
                            .git(skills.getGit())
                            .restful(skills.getRestful())
                            .spring(skills.getSpring())
                            .jenkins(skills.getJenkins())
                            .build();

                    technicalSkillsRepository.save(technicalSkillsEntity);


                    NonTechnicalSkillsEntity nonTechnicalSkillsEntity = NonTechnicalSkillsEntity.builder()
                            .aptitude(skills.getAptitude())
                            .communication(skills.getCommunication())
                            .spoken(skills.getSpoken())
                            .build();

                    nonTechnicalSkillsRepository.save(nonTechnicalSkillsEntity);

                }

            } else {
                return new ResponseEntity<>(UpdateResponse.builder()
                        .message(ServiceConstants.USER_NOT_PRESENT)
                        .messageCode(HttpStatus.INTERNAL_SERVER_ERROR)
                        .messageType(ServiceConstants.FAILURE)
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(UpdateResponse.builder()
                    .message(ServiceConstants.SUCCESS)
                    .messageCode(HttpStatus.OK)
                    .messageType(ServiceConstants.SUCCESS)
                    .build(), HttpStatus.OK);

        } catch (Exception e) {
            log.error("Error while updating profile {}", e.getMessage());
        }
        return new ResponseEntity<>(UpdateResponse.builder()
                .message(ServiceConstants.USER_NOT_UPDATED)
                .messageCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .messageType(ServiceConstants.FAILURE)
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
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
                    return new ResponseEntity<>(SearchResponse.builder()
                            .userList(userList)
                            .message(ServiceConstants.SUCCESS)
                            .messageCode(HttpStatus.OK)
                            .messageType(ServiceConstants.SUCCESS)
                            .build(), HttpStatus.OK);
                }
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
                    return new ResponseEntity<>(SearchResponse.builder()
                            .userList(userList)
                            .message(ServiceConstants.SUCCESS)
                            .messageCode(HttpStatus.OK)
                            .messageType(ServiceConstants.SUCCESS)
                            .build(), HttpStatus.OK);
                }
            } else if (criteria.equalsIgnoreCase("skill")) {
                if (ServiceConstants.technicalSkills.contains(criteriaValue)) {
                    technicalSkillsEntityList = technicalSkillsRepository.findBySkill(criteriaValue);
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
                        return new ResponseEntity<>(SearchResponse.builder()
                                .userList(userList)
                                .message(ServiceConstants.SUCCESS)
                                .messageCode(HttpStatus.OK)
                                .messageType(ServiceConstants.SUCCESS)
                                .build(), HttpStatus.OK);
                    }
                } else if (ServiceConstants.nonTechnicalSkills.contains(criteriaValue)) {
                    nonTechnicalSkillsEntityList = nonTechnicalSkillsRepository.findBySkill(criteriaValue);
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
                        return new ResponseEntity<>(SearchResponse.builder()
                                .userList(userList)
                                .message(ServiceConstants.SUCCESS)
                                .messageCode(HttpStatus.OK)
                                .messageType(ServiceConstants.SUCCESS)
                                .build(), HttpStatus.OK);
                    }
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
