/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melayer.camzia.service;

import com.melayer.camzia.domain.MeUser;
import com.melayer.camzia.repository.MeUserRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author aniruddha
 */
@Service
public class MeServiceUserDetails implements UserDetailsService {

    @Autowired
    private MeUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MeUser user = userRepository.findByUserName(username);
        System.out.println("----> User Name - "+user.getUserName());
        System.out.println("----> Password - "+user.getPassword());

        if (user == null) {

            throw new UsernameNotFoundException(username);
        }

        return new MeUserRepositoryUserDetails(user) ;
    }

    private final static class MeUserRepositoryUserDetails extends MeUser implements UserDetails {

        public MeUserRepositoryUserDetails(MeUser user) {

            super(user);

        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return getRoles();
        }

        @Override
        public String getUsername() {
            return getUserName();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
