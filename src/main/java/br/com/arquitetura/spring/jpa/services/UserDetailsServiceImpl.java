package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceUsernameNotFoundException;
import br.com.arquitetura.spring.jpa.models.UserModel;
import br.com.arquitetura.spring.jpa.repositories.UserRepository;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Locale;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final MessageSource messageSource;

    public UserDetailsServiceImpl(UserRepository userRepository, MessageSource messageSource) {
        this.userRepository = userRepository;
        this.messageSource = messageSource;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws ResourceUsernameNotFoundException {
        Optional<UserModel> userModel = userRepository.findByUsername(username);
        if (userModel.isPresent()) {
            return new org.springframework.security.core.userdetails.User(userModel.get().getUsername(), userModel.get().getPassword(),
                    userModel.get().getEnabled(), userModel.get().getAccountNonExpired(), userModel.get().getCredentialsNonExpired(), userModel.get().getAccountNonLocked(),
                    new ArrayList<>());
        } else {
               throw ResourceUsernameNotFoundException.withMessage(
            messageSource,"error.user.username.notfound",
            new Object[]{username}, Locale.getDefault());
        }
    }
}
