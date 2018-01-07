package app.service;

import app.Entity.UserForFeign;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hasee on 2017/12/26.
 */
@FeignClient(name = "service-hi")
public interface InvokeService {

    @RequestMapping(value = "/hello-service-remote/hello1",method = RequestMethod.POST)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello-service-remote/hello3",method = RequestMethod.POST)
    String hello3(@RequestBody(required = false)UserForFeign user);
}
