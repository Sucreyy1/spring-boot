package eureka.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hasee on 2017/12/20.
 */
@RestController
@Component
public class DiscoveryService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private EurekaClient eurekaClient;

    @RequestMapping("/discovery/eureka")
    public String get(){
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("service-hi", false);
        Applications applications = eurekaClient.getApplications();

        return instanceInfo.getHomePageUrl();
    }


    @RequestMapping("/discovery")
    public String doDiscovery(){
        StringBuilder sb = new StringBuilder();
        List<String> services = discoveryClient.getServices();
        if (!CollectionUtils.isEmpty(services)){
            for (String s : services){
                System.out.println("serviceId:"+s);
                List<ServiceInstance> instances = discoveryClient.getInstances(s);
                if(!CollectionUtils.isEmpty(instances)){
                    for (ServiceInstance serviceInstance : instances){
                        sb.append("["+serviceInstance.getServiceId()+" host:"+serviceInstance.getHost());
                    }
                }else {
                    sb.append("no services");
                }
            }
        }
        return sb.toString();
    }
}
