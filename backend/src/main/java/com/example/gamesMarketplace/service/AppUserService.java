package com.example.gamesMarketplace.service;

import com.example.gamesMarketplace.model.AppUser;
import com.example.gamesMarketplace.registration.token.ConfirmationToken;
import com.example.gamesMarketplace.registration.token.ConfirmationTokenService;
import com.example.gamesMarketplace.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class AppUserService implements UserDetailsService {

    private static final String USER_NOT_FOUND_MSG = "user with email %s not found";

    private final AppUserRepository appUserRepository;
    private final ConfirmationTokenService confirmationTokenService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository,
                          ConfirmationTokenService confirmationTokenService,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.confirmationTokenService = confirmationTokenService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));

        return new User(
                appUser.getEmail(),
                appUser.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if (userExists) {
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        // Trigger event or method to send an email
        return token;
    }

    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
