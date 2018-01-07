package app.service;

import app.Entity.User;
import app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by hasee on 2017/12/5.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findByName(Map<String,Object> name){
//        List<User> userList = userMapper.findByName(name);
        return null;
    }

    public List<User> findAll(){
        return userMapper.findAll();
    }

    public void save(User user){
        userMapper.save(user);
    }

}
