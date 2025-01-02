package org.example.totgether3.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        var login = SecurityContextHolder.getContext().getAuthentication().getName();
        log.debug("Retrieving user from token with login: {}", login);

        return userRepository.findByLogin(login).orElseThrow(
                () -> new UsernameNotFoundException("Authentication object is invalid or does not contain a login"));
    }
}
