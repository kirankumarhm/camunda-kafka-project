// package com.example.workflow.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// import org.springframework.context.annotation.Bean;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecuritySecureConfig {

//     @Bean
//     public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception{

  
//                 //        HttpSecurity h = http
//         		// Disable CSRF for this example. CSRF is a security feature that is enabled by default in Spring Boot 2.5.0 and later. 
//         		// CSRF protection is a request that could be forged by a malicious site. 
//         		// CSRF protection is enabled by default with Java configuration. 
//         		// CSRF protection is enabled by default with XML

//         http
//             .httpBasic(Customizer.withDefaults());
//         http
//         		.csrf(c -> c.disable())
//                 .authorizeHttpRequests(
//                         authorizeExchangeSpec -> authorizeExchangeSpec
//                                 .requestMatchers(
//                                 		"/swagger-ui.html", 
//                                 		"/swagger-ui/**", 
//                                 		"/v3/api-docs/**",
//                                         "/swagger-resources/**", 
//                                         "/api-docs/**", 
//                                         "/aggregate/**", "/actuator/**").permitAll()
//                                 // .anyRequest().authenticated()
//                 )
//                 .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
//         return http.build();

//     }
// }