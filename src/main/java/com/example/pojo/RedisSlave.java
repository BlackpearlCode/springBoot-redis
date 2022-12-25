package com.example.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedisSlave {
    @Value("${spring.redis.slave-port}")
    private int port;
    @Value("${spring.redis.slave-host}")
    private String host;
    @Value("${spring.redis.password}")
    private String password;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RedisConfig{" +
                "port=" + port +
                ", host='" + host + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
