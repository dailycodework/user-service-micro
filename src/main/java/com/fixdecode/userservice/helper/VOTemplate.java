package com.fixdecode.userservice.helper;

import com.fixdecode.userservice.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(NON_NULL)
public class VOTemplate {
    private Department department;
    private User user;
   /* protected int statusCode;
    protected HttpStatus status;
    protected String message;
    protected Map<?, ?> data;*/

}
