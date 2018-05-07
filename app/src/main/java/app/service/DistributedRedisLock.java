package app.service;

import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class DistributedRedisLock {

    @Autowired
    private RedissonService redissonService;

    public boolean acquire(String lockName){
        RLock lock = redissonService.redissonClient().getLock(lockName);
        lock.lock(1, TimeUnit.MINUTES);
        return true;
    }

    public boolean release(String lockName){
        RLock lock = redissonService.redissonClient().getLock(lockName);
        lock.unlock();
        return true;
    }
}
