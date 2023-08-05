package th.mfu;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    public List<Product> findAll();

    public List<Product> findBypname(String productname);

    public List<Product> findBypnameStartingWith(String prefix);

}
