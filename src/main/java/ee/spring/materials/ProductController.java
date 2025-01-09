package ee.spring.materials;

import ee.spring.materials.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    Product product = new Product(123, "Coke", 0.9, true);

    @GetMapping("product")
    public Product getProduct() {
        return product;
    }

    @GetMapping("delete-product")
    public void deleteProduct() {
        product = null;
    }

    @GetMapping("set-price")
    public Product setPrice() {
        product.setPrice(product.getPrice() + 0.2);
        return product;
    }

    @GetMapping("set-active")
    public Product setActive() {
        product.setActive(!product.isActive());
        return product;
    }

    @GetMapping("set-name/{name}")
    public Product setName(@PathVariable String name) {
        product.setName(name);
        return product;
    }
}
