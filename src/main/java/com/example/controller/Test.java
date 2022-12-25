package com.example.controller;

import com.example.config.RedisReadConnectionFactory;
import com.example.config.RedisWriteConnectionFactory;
import com.example.service.impl.RedisReadServiceImpl;
import com.example.service.impl.RedisWriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Autowired
    private  RedisWriteServiceImpl redisWriteService;

    @Autowired
    private RedisWriteConnectionFactory redisWriteConnectionFactory;

    @Autowired
    private RedisReadServiceImpl redisReadService;

    @Autowired
    private RedisReadConnectionFactory redisReadConnectionFactory;
    @RequestMapping("/write")
    public void test(){
        redisWriteService.setRedisConfig(redisWriteConnectionFactory);
        RedisTemplate redisTemplate = redisWriteService.getRedisTemplate();
        redisTemplate.opsForValue().set("aaa","kkk");
    }

    @RequestMapping("/read")
    public void test2(){
        redisReadService.setRedisConfig(redisReadConnectionFactory);
        RedisTemplate redisTemplate = redisReadService.getRedisTemplate();
        System.out.println(redisTemplate.opsForValue().get("aaa"));

    }
}
