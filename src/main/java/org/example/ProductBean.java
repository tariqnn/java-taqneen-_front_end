package org.example;

import jakarta.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.List;


@Component
@ViewScoped
public class ProductBean implements Serializable {

    @Autowired
    private ProductService productService;

    private List<Product> products;

    public void loadProducts() {
        products = productService.getAllProducts();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
