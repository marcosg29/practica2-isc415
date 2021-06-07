package marcosg.pucmm.edu.objects;

import marcosg.pucmm.edu.utils.AppRoles;

import java.util.Set;

public class User {
    private String name;
    private String username;
    private String password;
    private Set<AppRoles> roles;


    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User(String name, String username, String password, Set<AppRoles> roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<AppRoles> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppRoles> roles) {
        this.roles = roles;
    }
}
