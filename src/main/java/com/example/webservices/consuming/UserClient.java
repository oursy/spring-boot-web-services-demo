
package com.example.webservices.consuming;


import com.example.webservices.schema.UserRequest;
import com.example.webservices.schema.UserResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.ArrayList;

public class UserClient extends WebServiceGatewaySupport {
    public UserResponse getUsers() {
        UserRequest request = new UserRequest();
        request.setUsers(new ArrayList<UserRequest.Users>() {
            {
                UserRequest.Users users = new UserRequest.Users();
                users.setUserId("1");
                users.setName("a");
                add(users);
            }
        });
        UserResponse response = (UserResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8089/ws/userService", request,
                        new SoapActionCallback(
                                "https://company.example.com/user/schemas/UserRequest"));

        return response;
    }

}
