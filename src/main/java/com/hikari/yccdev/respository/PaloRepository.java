package com.hikari.yccdev.respository;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by gang.xu01@hand-china.com on 2018/11/26
 */
@Repository
public class PaloRepository {

    /*
     *  内存存储palo的部分数据
     */
    public final ConcurrentMap<String, String> paloRepository = new ConcurrentHashMap<>();

    public void save(String key, String value) {
        paloRepository.put(key, value);
    }

    public String get(String key) {
        return paloRepository.get(key);
    }
}
