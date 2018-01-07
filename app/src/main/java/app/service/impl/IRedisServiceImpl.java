package app.service.impl;

import app.service.IRedisService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by hasee on 2017/12/6.
 */
@Service
public class IRedisServiceImpl implements IRedisService {

    private static Logger logger = Logger.getLogger(IRedisServiceImpl.class);

    @Autowired
    private JedisPool jedisPool;

    public Jedis getResource() {
        return jedisPool.getResource();
    }

    public void returnResource(Jedis jedis) {
        if (null != jedis) {
            jedisPool.returnResource(jedis);
        }
    }

    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            jedis.set(key,value);
            logger.info("Redis set success-----key:"+key+",value:"+value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis set error:"+e.getMessage());
        } finally {
            returnResource(jedis);
        }
    }

    public String get(String key) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.get(key);
            logger.info("Redis get success ----key:"+key+",value:"+result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return result;
    }
}
