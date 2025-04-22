package com.datnq.rediss.service;

public interface BaseRedisService {
    void set(String key, String value);
    void setTimeToLive(String key, long timeToLive); // thoi gian song
/*    void hashSet(String key, String hashKey, String hashValue);
    boolean hashExists(String key, String hashKey);*/
    Object get(String key);

    void del(String key);

}
