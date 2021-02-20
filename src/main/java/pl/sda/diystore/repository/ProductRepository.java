package pl.sda.diystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.diystore.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product>findByPriceBetween(BigDecimal minPrice,BigDecimal maxPrice);
    List<Product> findByName(String name);

}
