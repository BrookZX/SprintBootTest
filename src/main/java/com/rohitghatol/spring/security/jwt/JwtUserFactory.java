package com.rohitghatol.spring.security.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import com.rohitghatol.spring.security.user.NUser;
import com.rohitghatol.spring.security.user.SysRole;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(NUser user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                mapToGrantedAuthorities(user.getRoles()),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<SysRole> authorities) {
//        return authorities.stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
    	
        List<GrantedAuthority> auths = new ArrayList<>(); 
        for (SysRole role : authorities) {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }
}

