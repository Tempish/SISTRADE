package ac.cr.ucr.SISTRADE.repository;

import ac.cr.ucr.SISTRADE.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

}
