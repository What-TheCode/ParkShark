package com.example.parkshark.security.switchsecure;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityGuard {
    ApiUserRole value() ;

    enum ApiUserRole {
        MANAGER, MEMBER
    }
}
