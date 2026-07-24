package com.algaworks.algashop.authorizationserver.application.security;

import com.algaworks.algashop.authorizationserver.domain.model.user.AuthUserType;

import java.util.UUID;

public interface SecurityCheckApplicationService {
    UUID getAuthenticadeUserId();
    boolean isAuthenticated();
    boolean isMachineAuthenticated();
    boolean canAccessOwnProfile();
    boolean canRegisterUserOfType(AuthUserType registrationType);
}
