package com.datnq.rediss.service.impl;

import com.datnq.rediss.service.BaseRedisService;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class BaseRedisServiceImpl implements BaseRedisService {
    private final RedisTemplate<String, Object> redisTemplate;

    //private final HashOperations<String, String, Object> hashOperations;

    public BaseRedisServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void setTimeToLive(String key, long timeToLive) {
        redisTemplate.expire(key, timeToLive, TimeUnit.DAYS);
    }

/*    @Override
    public void hashSet(String key, String hashKey, String hashValue) {
        hashOperations.put(key, hashKey, hashValue);
    }

    @Override
    public boolean hashExists(String key, String hashKey) {

        return hashOperations.hasKey(key, hashKey);
    }*/

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void del(String key) {
        redisTemplate.delete(key);
    }
}
