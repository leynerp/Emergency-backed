package com.emergency.configuration.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthenticationResponse {
    String accessToken;
    String scope;
    String experies;
}
