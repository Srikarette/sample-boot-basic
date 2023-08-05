package th.mfu;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    // Create Hashmap for DB
    @Autowired
    private ProductRepository productRepository;

    // Select all Employee
    @GetMapping("/products")
    public Collection<Product> getAllProduct() {
        return productRepository.findAll();
    }

    // Select Employee by ID
    @GetMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable long id) {
        Optional<Product> productElm = productRepository.findById(id);

        if (!productElm.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        Product product = productElm.get();
        return ResponseEntity.ok(product);

    }

    // Create New Employee
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.ok("Product has been created!");
    }

    // update employee
    @PutMapping("/products")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        // check if id not exists
        if (!productRepository.existsById(product.getPid())) {
            // return error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        // update product
        productRepository.save(product);

        // return success message
        return ResponseEntity.ok("Product updated");
    }

    // Delete Employee
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        // check if id not exists
        if (!productRepository.existsById(id)) {
            // return error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        // delete employee
        productRepository.deleteById(id);

        // return success message
        return ResponseEntity.ok("Product deleted");
    }
}
