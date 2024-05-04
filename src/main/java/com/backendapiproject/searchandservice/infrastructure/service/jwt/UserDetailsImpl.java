package com.backendapiproject.searchandservice.infrastructure.service.jwt;

import com.backendapiproject.searchandservice.infrastructure.entity.AccessDataEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private AccessDataEntity accessData;

    public UserDetailsImpl(AccessDataEntity accessData) {
        this.accessData = accessData;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return accessData.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleType().name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return accessData.getPassword();
    }

    @Override
    public String getUsername() {
        return accessData.getUsername();
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
