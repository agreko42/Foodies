package com.foodies.backend.security.authentication;

import com.foodies.backend.security.config.JwtService;
import com.foodies.backend.security.user.Role;
import com.foodies.backend.security.user.User;
import com.foodies.backend.security.user.UserPrincipal;
import com.foodies.backend.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var userPrincipal = new UserPrincipal(user);
        var jwToken = jwtService.generateToken(userPrincipal);
        return AuthenticationResponse.builder()
                .token(jwToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        var userPrincipal = new UserPrincipal(user);
        var jwToken = jwtService.generateToken(userPrincipal);
        return AuthenticationResponse.builder()
                .token(jwToken)
                .build();
    }
}
