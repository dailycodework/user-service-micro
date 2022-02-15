package com.fixdecode.userservice.helper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class RequestTemplate {
    private RestTemplate restTemplate;

    // Getting the user department for a particular user;
    public Department getUserDepartment(String id){
        return restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/departments/" +id,
                Department.class);
    }
}
