package marcosg.pucmm.edu.services;

import marcosg.pucmm.edu.objects.Product;
import marcosg.pucmm.edu.objects.User;
import marcosg.pucmm.edu.utils.AppRoles;

import java.util.*;

public class ApiService {

    private static ApiService instance;
    private List<User> users = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private String loggedAs;

    /*
    * Private constructor
    * */
    private ApiService() {
    }

    /*
    * Methods
    * */
    public User authUser(String username, String password) {
        return new User(username, username, password);
    }

    public User findUser(User u) {
        return null;
    }

    /*
    * Getters
    * */

    public static ApiService getInstance() {
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Product> getProducts() {
        return products;
    }
}
