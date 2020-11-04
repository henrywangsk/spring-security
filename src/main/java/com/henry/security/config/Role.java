package com.henry.security.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.henry.security.config.Permission.*;

public enum Role {
    STUDENT(Set.of()),
    ADMIN(Set.of(STUDENT_READ, STUDENT_WRITE, COURSE_READ, COURSE_WRITE)),
    ADMIN_TRAINEE(Set.of(STUDENT_READ, COURSE_READ));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<GrantedAuthority> getGrantedAuthorities() {
        final Set<GrantedAuthority> grantedAuthorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toSet());

        // to support role as well - see User.builder().roles() which appends "ROLE_",
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + name()));

        return grantedAuthorities;
    }
}
