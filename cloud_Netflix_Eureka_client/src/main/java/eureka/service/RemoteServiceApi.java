package eureka.service;

import eureka.Entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hasee on 2017/12/26.
 */
@RequestMapping("/hello-service-remote")
public interface RemoteServiceApi {

    @RequestMapping(value = "/hello1",method = RequestMethod.POST)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hellow2",method = RequestMethod.POST)
    User hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age);

    @RequestMapping(value = "hello3",method = RequestMethod.POST)
    String hello3(@RequestBody(required = false) User user);
}
