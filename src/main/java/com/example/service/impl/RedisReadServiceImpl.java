package com.example.service.impl;


import com.example.config.RedisConfig;
import com.example.service.RedisService;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * redis从节点
 */
@Service
public class RedisReadServiceImpl implements RedisService {



    private RedisConfig redisConfig;

    public void setRedisConfig(RedisConfig redisConfig) {
        this.redisConfig = redisConfig;
    }


    @Override
    public RedisTemplate getRedisTemplate() {
        LettuceConnectionFactory lettuceConnectionFactory = redisConfig.redisConnectionFactory();
        return redisConfig.redisTemplate(lettuceConnectionFactory);
    }


}
