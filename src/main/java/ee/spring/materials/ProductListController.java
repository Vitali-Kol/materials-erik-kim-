package ee.spring.materials;

import ee.spring.materials.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductListController {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Cola", 1.0, true),
            new Product(2, "fanta", 1.1, true),
            new Product(3, "sprite", 1.2, true),
            new Product(4, "water", 1.5, true),
            new Product(5, "nestea", 1.7, true)
    ));

    @GetMapping("products")
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("remove-product/{index}")
    public List<Product> removeProduct(@PathVariable int index) {
        products.remove(index);
        return products;
    }

    @GetMapping("add-product/{id}/{name}/{price}/{active}")
    public List<Product> addProduct(
            @PathVariable int id,
            @PathVariable String name,
            @PathVariable double price,
            @PathVariable boolean active
    ){
        products.add(new Product(id, name, price, active));
        return products;
    }

    @GetMapping("most-expensive")
    public Product getMostExpensiveProduct() {
        Product mostExpensive = products.get(0);
        for (Product product : products) {
            if (product.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = product;
            }
        }
        return mostExpensive;
    }
}


