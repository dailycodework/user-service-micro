package com.fixdecode.userservice.user;

import com.fixdecode.userservice.helper.Department;
import com.fixdecode.userservice.helper.RequestTemplate;
import com.fixdecode.userservice.helper.VOTemplate;
import com.fixdecode.userservice.util.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private RequestTemplate requestTemplate;

    public List<User> getAllUsers(){
        return userRepository.findAll().stream().toList();
    }

    public User getUserById(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User creatUser(User theUser) {
        return userRepository.save(theUser);
    }

    @Transactional
    public VOTemplate getUserWithDepartment(String id) {
        log.info("Fetching user with department");
        VOTemplate VOT = new VOTemplate();
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        Department department = requestTemplate.getUserDepartment(user.getDepartmentId());
        VOT.setUser(user);
        VOT.setDepartment(department);
        return VOT;
    }
}
