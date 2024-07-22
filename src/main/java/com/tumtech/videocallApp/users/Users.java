package com.tumtech.videocallApp.users;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Users {
    private String username;
    private String email;
    private String password;
    private String status;
}
