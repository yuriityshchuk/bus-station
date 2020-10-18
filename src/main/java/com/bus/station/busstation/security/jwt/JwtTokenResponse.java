package com.bus.station.busstation.security.jwt;

import com.bus.station.busstation.model.utility.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class JwtTokenResponse implements Serializable {

    private static final long serialVersionUID = 8317676219297719109L;

    private String token;

    private Set<Role> roles;

}
