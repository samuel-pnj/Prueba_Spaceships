package com.example.spaceships.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if (authentication == null || !authentication.isAuthenticated() || !(permission instanceof String)) {
            return false;
        }

        User user = (User) authentication.getPrincipal();
        // Aquí implementa la lógica para verificar si el usuario tiene el permiso requerido
        // Puedes usar el targetDomainObject para realizar comprobaciones más específicas según el objeto objetivo
        return user.getUsername().equals("admin") && permission.equals("ADMIN_PERMISSION");
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // Esta implementación no se usa en este ejemplo, puedes dejarla en blanco o lanzar una excepción
        throw new UnsupportedOperationException("Not supported yet.");
    }
}