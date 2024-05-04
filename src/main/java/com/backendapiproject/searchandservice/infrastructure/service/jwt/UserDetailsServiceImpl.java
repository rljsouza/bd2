package com.backendapiproject.searchandservice.infrastructure.service.jwt;

import com.backendapiproject.searchandservice.infrastructure.entity.AccessDataEntity;
import com.backendapiproject.searchandservice.infrastructure.repository.AccessDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccessDataRepository accessDataRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccessDataEntity accessData = accessDataRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
        return new UserDetailsImpl(accessData);
    }

}
