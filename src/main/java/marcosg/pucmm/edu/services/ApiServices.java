package marcosg.pucmm.edu.services;

import marcosg.pucmm.edu.objects.Product;
import marcosg.pucmm.edu.objects.User;

import java.util.ArrayList;
import java.util.List;

public class ApiServices {

    private static ApiServices instance;
    private List<User> users = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    private ApiServices() {
        System.out.println("----- service initialization ok! -----");
    }

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
