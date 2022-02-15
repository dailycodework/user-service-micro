package com.fixdecode.userservice.helper;

import com.fixdecode.userservice.user.User;
import lombok.Data;

@Data
public class UserDepartmentHelper {
    private Department department;
    private User user;
}
