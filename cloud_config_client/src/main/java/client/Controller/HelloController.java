package client.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hasee on 2017/12/19.
 */
@RestController
public class HelloController {

    @Value("${config.name}")
    private String hello;

    @RequestMapping("/hello")
    public String from(){
        return this.hello;
    }
}
