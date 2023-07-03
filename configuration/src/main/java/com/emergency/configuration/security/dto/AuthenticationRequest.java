package com.emergency.configuration.security.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String userName;
    private String password;
}
