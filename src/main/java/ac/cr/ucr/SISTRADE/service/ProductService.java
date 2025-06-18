package ac.cr.ucr.SISTRADE.service;

import ac.cr.ucr.SISTRADE.model.Product;
import ac.cr.ucr.SISTRADE.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    IProductRepository productRepository;

    public Product saveProduct(Product product){
        return this.productRepository.save(product);
    }

    public Optional<Product> findProductById(Integer id){
        return this.productRepository.findById(id);
    }

    public List<Product> findAllProducts(){
        return this.productRepository.findAll();
    }

    public void deleteProductById(Integer id){
        this.productRepository.deleteById(id);
    }

    public Product editProduct(Integer id, Product product){
        Optional<Product>  productOptional = this.productRepository.findById(id);
        if (productOptional.isEmpty()) {
            return new Product();
        }

        this.productRepository.deleteById(id);
        return this.productRepository.save(product);

    }
}
