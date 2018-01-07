package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by hasee on 2017/12/19.
 */
@SpringBootApplication
@EnableConfigServer
public class CloudApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudApp.class);
    }
}
