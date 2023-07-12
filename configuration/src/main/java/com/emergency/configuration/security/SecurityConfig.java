package com.emergency.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebSecurity
public class SecurityConfig {
    @Value("${spring.ldap.userDnPatterns}")
    private String userDnPatterns;

    @Value("${spring.ldap.groupSearchBase}")
    private String groupSearchBase;

    @Value("${spring.ldap.groupSearchFilter}")
    private String groupSearchFilter;
    @Value("${spring.ldap.url}")
    private String url;

    @Value("${spring.ldap.managerDn}")
    private String managerDn;

    @Value("${spring.ldap.managerPassword}")
    private String managerPassword;

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**/auth/**")
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll()
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .cors(cors -> cors.disable())
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

     @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration conf) throws Exception {
        return conf.getAuthenticationManager();
    }

     @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userDnPatterns(this.userDnPatterns)
                .groupSearchBase(this.groupSearchBase)
                .groupSearchFilter(this.groupSearchFilter)
                .contextSource()
                .url(this.url)
                .managerDn(this.managerDn)
                .managerPassword(this.managerPassword);
    }

   /* @Bean
    public WebMvcConfigurer corsConfig(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*");

                WebMvcConfigurer.super.addCorsMappings(registry);
            }
        };
    }*/

}
