package pl.sda.diystore.web;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.sda.diystore.model.Product;
import pl.sda.diystore.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Transactional
    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.getAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}/product")
    public ResponseEntity<Product> get(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.get(productId));
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @PatchMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return ResponseEntity.ok(productService.update(product));
    }

    @DeleteMapping("/{productId}/product")
    public ResponseEntity<Boolean> delete(@PathVariable Long productId) {
        productService.remove(productId);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/{minPrice}/between/{maxPrice}")
    public ResponseEntity<List<Product>> getByPriceBetween(@PathVariable BigDecimal minPrice,
                                                           @PathVariable BigDecimal maxPrice) {
        return ResponseEntity.ok(productService.findByPriceBetween(minPrice, maxPrice));
    }

    @GetMapping("/{productName}/product")
    public ResponseEntity<List<Product>> get(@PathVariable String productName) {
        return ResponseEntity.ok(productService.findByName(productName));
    }

}
