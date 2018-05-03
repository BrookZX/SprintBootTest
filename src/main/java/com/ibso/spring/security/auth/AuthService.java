package com.ibso.spring.security.auth;

import com.ibso.spring.security.user.NUser;

public interface AuthService {
	NUser register(NUser userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
