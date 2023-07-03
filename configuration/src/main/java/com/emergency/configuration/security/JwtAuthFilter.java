package com.emergency.configuration.security;

import com.emergency.configuration.security.dto.UserClaim;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.ldap.userdetails.LdapAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private TokenConfig tokenConfig;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String bearerToken=request.getHeader("Authorization");
        if (bearerToken!=null && bearerToken.startsWith("Bearer")){
            String token=bearerToken.substring(7);
            String userName=tokenConfig.extractUserName(token);
            if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                Claims claim=tokenConfig.extractClaims(token);
                Map<String, Object> mapClaims=(Map<String, Object>) claim.get("userData");
                UserClaim userClaim= new UserClaim((String) mapClaims.get("userName"),(String) mapClaims.get("role"),(String) mapClaims.get("dn"));
                List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
                LdapAuthority ldapAuthority=new LdapAuthority(userClaim.getRole(),userClaim.getDn());
                grantedAuthorities.add(ldapAuthority);
                User user=new User(userName,"",grantedAuthorities);
                UsernamePasswordAuthenticationToken userAuth=new UsernamePasswordAuthenticationToken(user,null,grantedAuthorities);
                userAuth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(userAuth);
            }
        }
        filterChain.doFilter(request,response);
    }
}
