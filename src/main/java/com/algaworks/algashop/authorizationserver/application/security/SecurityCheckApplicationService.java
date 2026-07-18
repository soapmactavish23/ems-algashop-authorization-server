package com.algaworks.algashop.authorizationserver.application.security;

import java.util.UUID;

public interface SecurityCheckApplicationService {
    UUID getAuthenticadeUserId();
    boolean isAuthenticated();
    boolean isMachineAuthenticated();
}
