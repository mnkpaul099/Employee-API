package com.employee.ext.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/myapp")
@Slf4j
public class EmployeeListController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/admin/listEmployees")
	public List<Object> getEmployees() {
		log.info("EmployeeListController");
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("employee-api");
	    List<String> hostPorts =
	        serviceInstances.stream()
	            .map(serviceInstance -> serviceInstance.getHost() + ":" + serviceInstance.getPort())
	            .collect(Collectors.toList());
	    log.info("Instance list :-> {}", hostPorts);

	    ServiceInstance serviceInstance = loadBalancerClient.choose("employee-api");
	    log.info("Loadbalancer chose {}:{}", serviceInstance.getHost(), serviceInstance.getPort());

	    String url =
	        "http://"
	            + serviceInstance.getHost()
	            + ":"
	            + serviceInstance.getPort()
	            + "/admin/getAllEmployee";
		//String url = "http://localhost:8090/getAllEmployee";
		Object[] objects = restTemplate.getForObject(url, Object[].class);
		
		return Arrays.asList(objects);
		
	}
	
}
