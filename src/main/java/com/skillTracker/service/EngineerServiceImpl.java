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

import java.util.Optional;


@Service
@Slf4j
public class EngineerServiceImpl implements EngineerService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TechnicalSkillsRepository technicalSkillsRepository;

    @Autowired
    NonTechnicalSkillsRepository nonTechnicalSkillsRepository;

    @Autowired
    SequenceService  sequenceService;


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
                    .userId(sequenceService.getNextSequence(UserEntity.SEQUENCE_NAME))
                    .userName(user.getUserName())
                    .associateId(user.getAssociateId())
                    .email(user.getEmail())
                    .mobileNumber(user.getMobileNumber())
                    .lastUpdatedDate(LocalDateTime.now())
                    .build();

            UserEntity newUser = userRepository.save(userentity);

            TechnicalSkillsEntity technicalSkillsEntity = TechnicalSkillsEntity.builder()
                    .technicalSkillsId(sequenceService.getNextSequence(TechnicalSkillsEntity.SEQUENCE_NAME))
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
                    .nonTechnicalSkillsId(sequenceService.getNextSequence(NonTechnicalSkillsEntity.SEQUENCE_NAME))
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

}
