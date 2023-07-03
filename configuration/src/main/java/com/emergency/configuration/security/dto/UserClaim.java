package com.emergency.configuration.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserClaim {
    private String userName;
    private String role;
    private String dn;
}
