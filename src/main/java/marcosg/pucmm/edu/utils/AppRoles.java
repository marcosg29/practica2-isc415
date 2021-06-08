package marcosg.pucmm.edu.utils;

import io.javalin.core.security.Role;

import java.util.Set;

public enum AppRoles implements Role{
    GUEST,
    LOGGED,
    USER,
    ADMIN
}
