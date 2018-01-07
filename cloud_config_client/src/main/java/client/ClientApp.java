package client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hasee on 2017/12/19.
 */
@SpringBootApplication
@RestController
public class ClientApp {

    @Value("${config.name}")
    String name;

    @RequestMapping("/hi")
    public String get(){
        return this.name;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class);
    }
}
