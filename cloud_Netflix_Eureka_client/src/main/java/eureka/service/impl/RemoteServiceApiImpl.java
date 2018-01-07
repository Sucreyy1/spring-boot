package eureka.service.impl;

import eureka.Entity.User;
import eureka.service.RemoteServiceApi;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by hasee on 2017/12/26.
 */
@RestController
public class RemoteServiceApiImpl implements RemoteServiceApi {

    @Override
    public String hello(@RequestParam("name") String name) {
        return "hello"+name;
    }

    @Override
    public User hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age) {
        try {
            name = URLDecoder.decode(name,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new User(name,age);
    }

    @Override
    public String hello3(@RequestBody(required = false) User user) {
        System.out.println("或许这就是feign吧");
        return user.getName()+" "+user.getAge();
    }
}
