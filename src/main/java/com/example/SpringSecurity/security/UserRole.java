package com.example.SpringSecurity.security;

import java.util.Set;

public enum UserRole {

    USER(Set.of()),
    ADMIN(Set.of(
            UserPermission.USER_READ,
            UserPermission.USER_WRITE,
            UserPermission.COURSE_READ,
            UserPermission.COURSE_WRITE
    ));

    private final Set<UserPermission> userPermissionSet;

    UserRole(Set<UserPermission> userPermissionSet) {
        this.userPermissionSet = userPermissionSet;
    }

    public Set<UserPermission> getUserPermissionSet() {
        return userPermissionSet;
    }
}
