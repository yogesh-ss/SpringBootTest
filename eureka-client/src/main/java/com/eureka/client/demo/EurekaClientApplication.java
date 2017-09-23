package com.eureka.client.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClientApplication {
	
	public static void main(String[] args) {
	        SpringApplication.run(EurekaClientApplication.class, args);
	}
	 
	    @RequestMapping("/greeting")
	    public String greeting() {
	        return "Hello from EurekaClient!";
	    }
}

@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public String serviceInstancesByApplicationName(@PathVariable String applicationName) {
        return this.discoveryClient.getServices().get(0).toString();
    }
}