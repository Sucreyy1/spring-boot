package app.service;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RedissonService {

    @Value("${spring.redis.host}")
    String redisHost;

    @Value("${spring.redis.port}")
    String redisPort;

    private RedissonClient redisson;

    @PostConstruct
    void initRedisson(){
        Config config = new Config();
        String hostAddress = "redis://"+redisHost+":"+redisPort;
        config.useSingleServer().setAddress(hostAddress);
        redisson = Redisson.create(config);
    }

    public RedissonClient redissonClient(){
        return redisson;
    }
}
