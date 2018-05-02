package com.rohitghatol.spring.security.auth;

import com.rohitghatol.spring.security.user.NUser;

public interface AuthService {
	NUser register(NUser userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
