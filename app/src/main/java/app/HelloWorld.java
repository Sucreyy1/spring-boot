package app;

import app.service.UserService;
import app.service.impl.IRedisServiceImpl;
import com.github.pagehelper.PageInfo;
import app.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by hasee on 2017/12/1.
 */
@Controller
public class HelloWorld {

private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    @Autowired
    private UserService userService;
    @Autowired
    private IRedisServiceImpl redisService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public List<User> hello(){
        User user = new User();
        user.setUserName("fuck2");
        user.setAge("13");
        user.setUserSex("女");
        userService.save(user);
        logger.info("save success");
        List<User> all = userService.findAll();
        return all;
    }

    @RequestMapping("/word/{name}")
    public String word(@PathVariable String name){
        Map<String,Object> args = new HashMap<>();
        args.put("name",name);
        args.put("startNum",0);
        args.put("size",1);
        List<User> userList = userService.findByName(args);
        return "word-spring boot "+userList.get(0).getAge();
    }

    @RequestMapping("/showUser")
    public String find(){
        List<User> all = userService.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(all);
        return all.get(0).getUserName();
    }

    @RequestMapping("/redis")
    public String redisTest(){
        redisService.set("name","Nigen");
        return redisService.get("name");
    }
}
