package com.fixdecode.userservice.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@RequiredArgsConstructor
public class RequestTemplate {
    private final RestTemplate restTemplate;

    // Getting the user department for a particular user;
    public Department getUserDepartment(String depId) {
        return restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/departments/" + depId,
                Department.class);
    }
}
