package com.aks.commons.security.accesstoken;

import com.aks.commons.security.RoleType;
import org.springframework.security.core.userdetails.UserDetails;

public interface Token {

    String generateToken(UserDetails user, RoleType roleType);

    String getUsernameFromToken(String token);

    Boolean validateToken(String token, String userName);
}
