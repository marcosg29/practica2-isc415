package marcosg.pucmm.edu.services;

import marcosg.pucmm.edu.objects.Product;
import marcosg.pucmm.edu.objects.User;

import java.util.ArrayList;
import java.util.List;

public class ApiServices {

    private static ApiServices instance;
    private List<User> users = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    /*
    * Private constructor
    * */
    private ApiServices() {
        System.out.println("----- service initialization ok! -----");
    }

    /*
    * Methods
    * */
    public User authUser(String username, String password) {
        return new User(username, username, password);
    }

    /*
    * Getters
    * */

    public static ApiServices getInstance() {
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Product> getProducts() {
        return products;
    }
}
