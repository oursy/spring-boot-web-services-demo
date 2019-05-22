package com.example.webservices.producing;

import com.example.webservices.schema.User;
import com.example.webservices.schema.UserRequest;
import com.example.webservices.schema.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Slf4j
public class UserEndpoint {
    private static final String NAMESPACE_URI = "https://company.example.com/user/schemas";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UserRequest")
    @ResponsePayload
    public UserResponse handleUserRequest(@RequestPayload UserRequest request) {
        log.info("request User Info :{}",request.getUsers());
        UserResponse userResponse = new UserResponse();
        User user = new User();
        if (!request.getUsers().isEmpty()&& request.getUsers().get(0).getUserId().equals("1")) {
            user.setResponseMsg("ok");
            user.setResponseStatus(0);
        }else {
            user.setResponseMsg("error");
            user.setResponseStatus(1);
        }
        userResponse.setUser(user);
        return userResponse;
    }
}
