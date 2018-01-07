package app.service.impl;

import app.Entity.UserForFeign;
import app.service.InvokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hasee on 2017/12/26.
 */
@RestController
public class InvokeServiceImpl {

    @Autowired
    private InvokeService invokeService;

    @RequestMapping("/helloFeign")
    public String hello(){
        String s = invokeService.hello("张三");
        return s;
    }

    @RequestMapping("/testFeign")
    public String hello3(){
        UserForFeign user = new UserForFeign();
        user.setName("卢本伟牛逼");
        user.setAge(30);
        String s = invokeService.hello3(user);
        return s;
    }
}
