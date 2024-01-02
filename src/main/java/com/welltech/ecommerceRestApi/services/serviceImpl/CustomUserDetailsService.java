package com.welltech.ecommerceRestApi.services.serviceImpl;

import com.welltech.ecommerceRestApi.exception.UserExistException;
import com.welltech.ecommerceRestApi.exception.UserNotFoundException;
import com.welltech.ecommerceRestApi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

   private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username+" not found"));
    }
}
