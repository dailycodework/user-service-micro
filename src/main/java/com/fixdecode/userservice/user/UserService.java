package com.fixdecode.userservice.user;

import com.fixdecode.userservice.helper.Department;
import com.fixdecode.userservice.helper.RequestTemplate;
import com.fixdecode.userservice.helper.UserDepartmentHelper;
import com.fixdecode.userservice.util.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private RequestTemplate requestTemplate;

    public List<User> getAllUsers(){
        return userRepository.findAll()
                .stream().collect(Collectors.toList());
    }

    public User getUserById(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User creatUser(User theUser) {
        return userRepository.save(theUser);
    }

    @Transactional
    public UserDepartmentHelper getUserWithDepartment(String id) {
        log.info("Fetching user with department");
        UserDepartmentHelper UDH = new UserDepartmentHelper();
        User theUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        Department department = requestTemplate.getUserDepartment(theUser.getDepartmentId());
        UDH.setUser(theUser);
        UDH.setDepartment(department);
        return UDH;
    }
}
