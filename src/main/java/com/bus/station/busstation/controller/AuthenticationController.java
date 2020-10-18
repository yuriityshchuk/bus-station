package com.bus.station.busstation.controller;

import com.bus.station.busstation.exception.CustomAuthenticationException;
import com.bus.station.busstation.security.details.UserDetailsImpl;
import com.bus.station.busstation.security.details.UserDetailsServiceImpl;
import com.bus.station.busstation.security.jwt.JwtTokenRequest;
import com.bus.station.busstation.security.jwt.JwtTokenResponse;
import com.bus.station.busstation.security.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

    @Value("${jwt.http.request.header}")
    private String tokenHeader;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil,
                                    UserDetailsServiceImpl userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(value = "${jwt.get.token.uri}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest)
            throws CustomAuthenticationException {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()));

        final UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        JwtTokenResponse jwtTokenResponse = new JwtTokenResponse();

        jwtTokenResponse.setToken(token);
        jwtTokenResponse.setRoles(userDetails.getUser().getRoles());

        return ResponseEntity.ok().body(jwtTokenResponse);
    }

    @GetMapping(value = "${jwt.refresh.token.uri}")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);

        if (jwtTokenUtil.canTokenBeRefreshed(token)) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            JwtTokenResponse jwtTokenResponse = new JwtTokenResponse();
            jwtTokenResponse.setToken(refreshedToken);
            return ResponseEntity.ok(jwtTokenResponse.getToken());
        } else {
            return ResponseEntity.badRequest().body("");
        }
    }

}
