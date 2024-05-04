package com.backendapiproject.searchandservice.infrastructure.service.aspect;

import com.backendapiproject.searchandservice.core.exception.AccessDeniedException;
import com.backendapiproject.searchandservice.infrastructure.annotation.Authorize;
import com.backendapiproject.searchandservice.infrastructure.service.jwt.JwtServiceImpl;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
@RequiredArgsConstructor
public class AuthorizationAspect {

    private final JwtServiceImpl jwtService;

    @Before("@annotation(authorize)")
    public void authorize(JoinPoint joinPoint, Authorize authorize)  {
        boolean authorized = jwtService.checkAuthorization(authorize.value());
        if (!authorized) {
            throw new AccessDeniedException(authorize.message());
        }
    }


}