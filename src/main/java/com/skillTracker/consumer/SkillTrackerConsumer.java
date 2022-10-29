package com.skillTracker.consumer;


import com.skillTracker.entity.UserEntity;

import com.skillTracker.repository.UserRepository;

import com.skillTracker.service.EngineerService;

import com.skillTracker.utils.ServiceConstants;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.function.Consumer;

@Configuration

@Slf4j

public class SkillTrackerConsumer {


}

