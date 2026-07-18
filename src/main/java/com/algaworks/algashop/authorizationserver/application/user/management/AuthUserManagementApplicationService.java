package com.algaworks.algashop.authorizationserver.application.user.management;

import com.algaworks.algashop.authorizationserver.application.user.query.AuthUserOutput;
import com.algaworks.algashop.authorizationserver.domain.model.user.AuthUser;
import com.algaworks.algashop.authorizationserver.domain.model.user.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthUserManagementApplicationService {

    private final PasswordEncoder passwordEncoder;
    private final AuthUserRepository authUserRepository;

    public AuthUserOutput create(AuthUserInput input) {
        if(authUserRepository.existsByEmail(input.getEmail())) {
            throw new AuthUserEmailAlreadyInUseException(input.getEmail());
        }

        String tempPassword = RandomStringUtils.secure().nextAlphabetic(12);

        System.out.println(tempPassword);

        String passwordHash = passwordEncoder.encode(tempPassword);

        AuthUser user = AuthUser.brandNew(
                input.getEmail(),
                input.getName(),
                input.getType(),
                passwordHash
        );

        return AuthUserOutput.from(authUserRepository.save(user));
    }

}
