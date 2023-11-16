package com.sparrow.spring.cloud.alibaba;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


/**
 * 重新启动微服务和gateway服务，
 * 然后通过网关访问，可以看到可以正常访问，
 * 如果此时把某一台微服务停掉，
 * 访问的时候开始可能会报错，
 * 但是随着健康检查的运行，检测到该服务不可用，
 * 则会把该服务剔除，以后只会访问正常运行的服务。
 * 当宕机的服务重启，健康检查还会把该服务加入到可用服务列表，
 * 下次请求就会再次发送到该服务上。
 * <p>
 * BaseLoadBalancer--> Pinger
 */
public class HealthExamination implements IPing {
    public HealthExamination(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private RestTemplate restTemplate;

    @Override
    public boolean isAlive(Server server) {
        String url = "http://" + server.getId() + "/heath";
        try {
            ResponseEntity<String> heath = restTemplate.getForEntity(url, String.class);
            if (heath.getStatusCode() == HttpStatus.OK) {
                System.out.println("ping " + url + " success and response is " + heath.getBody());
                return true;
            }
            System.out.println("ping " + url + " error and response is " + heath.getBody());
            return false;
        } catch (Exception e) {
            System.out.println("ping " + url + " failed");
            return false;
        }
    }
}
