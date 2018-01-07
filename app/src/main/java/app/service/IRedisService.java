package app.service;

import redis.clients.jedis.Jedis;

/**
 * Created by hasee on 2017/12/6.
 */
public interface IRedisService {
    public Jedis getResource();

    public void returnResource(Jedis jedis);

    public void set(String key,String value);

    public String get(String key);
}
