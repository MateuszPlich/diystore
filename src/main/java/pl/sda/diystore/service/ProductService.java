package pl.sda.diystore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.diystore.model.Product;
import pl.sda.diystore.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product get(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find material"));
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void remove(Long id) {
        productRepository.delete(get(id));
    }

    public List<Product> findByPriceBetween(BigDecimal minPice, BigDecimal maxPrice) {
        return productRepository.findByPriceBetween(minPice, maxPrice);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }


}
