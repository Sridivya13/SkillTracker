package com.skillTracker.producer;



import com.skillTracker.entity.UserEntity;

import com.skillTracker.utils.ServiceConstants;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

@Service

@Slf4j

public class SkillTrackerProducer {

    @Autowired

    private KafkaTemplate<String, UserEntity> kafkaTemplate;

    /**

     * To send message to Kafka Topic

     *

     * @param userEntity

     */

    public void sendMessage(UserEntity userEntity) {

        log.info("Kafka Topic Produce Message: {}", userEntity.toString());

        this.kafkaTemplate.send(ServiceConstants.TOPIC_NAME, userEntity);

    }

}










