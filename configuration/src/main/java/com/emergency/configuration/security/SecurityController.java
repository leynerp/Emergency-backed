package com.emergency.configuration.security;


import com.emergency.configuration.security.dto.AuthenticationRequest;
import com.emergency.configuration.security.dto.AuthenticationResponse;
import com.emergency.configuration.security.dto.UserClaim;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/auth")
@AllArgsConstructor
public class SecurityController {

    private AuthenticationManager authenticationManager;
    private TokenConfig tokenConfig;

    @Autowired
    private ApplicationContext context;

    @PostMapping()
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));

            if (authentication.isAuthenticated()) {
                LdapUserDetailsImpl ldapUserDetails = (LdapUserDetailsImpl) authentication.getPrincipal();
                UserClaim userClaim=new UserClaim();
                userClaim.setUserName(ldapUserDetails.getUsername());
                userClaim.setDn(ldapUserDetails.getDn());
                userClaim.setRole(ldapUserDetails.getAuthorities().stream().toList().get(0).toString().substring(5));
                Map<String, Object> claims = new HashMap<>();
                claims.put("userData", userClaim);
                claims.put("sub", ldapUserDetails.getUsername());
                String token = tokenConfig.generateToken(ldapUserDetails, claims);
                AuthenticationResponse authenticationResponse=new AuthenticationResponse(token,"","");
                return new ResponseEntity(authenticationResponse, HttpStatus.OK);
            }

        } catch (BadCredentialsException exp) {
            return new ResponseEntity(new AuthenticationResponse(null,"",""),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new AuthenticationResponse(null,"",""),HttpStatus.BAD_REQUEST);
    }
}
