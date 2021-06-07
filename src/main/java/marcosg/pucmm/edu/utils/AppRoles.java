package marcosg.pucmm.edu.utils;

import io.javalin.core.security.Role;

public enum AppRoles implements Role {
    GUEST,
    LOGGED,
    USER,
    ADMIN;
}
