package marcosg.pucmm.edu.objects;

import java.util.Date;
import java.util.List;

public class ProductSale {
    private long id;
    private Date date;
    private String username;
    private List<Product> productList;

    public ProductSale(long id, Date date, String username, List<Product> productList) {
        this.id = id;
        this.date = date;
        this.username = username;
        this.productList = productList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
