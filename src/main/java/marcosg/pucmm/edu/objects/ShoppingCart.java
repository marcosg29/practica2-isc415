package marcosg.pucmm.edu.objects;

import java.util.List;

public class ShoppingCart {
    private long id;
    private List<Product> productList;

    public ShoppingCart(long id, List<Product> productList) {
        this.id = id;
        this.productList = productList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
