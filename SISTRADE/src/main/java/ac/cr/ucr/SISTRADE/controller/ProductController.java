package ac.cr.ucr.SISTRADE.controller;

import ac.cr.ucr.SISTRADE.model.Product;
import ac.cr.ucr.SISTRADE.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product")
public class ProductController  {
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<?> addProduct(@Validated @RequestBody Product product, BindingResult result){
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        Optional<Product> productOp = this.productService.findProductByName(product.getName());

        if(productOp.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product with name "+product.getName()+" already exists!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.saveProduct(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Integer id){
        Optional<Product> productFind = this.productService.findProductById(id);
        if(!productFind.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID "+id+" doesn't exist!");
        }

        return ResponseEntity.ok(productFind);
    }

    @GetMapping
    public ResponseEntity<?> findAllProducts(){

        List<Product> listProducts=this.productService.findAllProducts();
        if (listProducts.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Products stored!");
        }
        return ResponseEntity.ok(listProducts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){

        Optional<Product> productFind = this.productService.findProductById(id);
        if(!productFind.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID "+id+" doesn't exist!");
        }
        this.productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editProduct(@Validated @PathVariable Integer id, @RequestBody Product product, BindingResult result){

        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        Optional<Product> productFind = this.productService.findProductById(id);
        if(!productFind.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID "+id+" doesn't exist!");
        }

        return ResponseEntity.ok(this.productService.editProduct(id, product));
    }
}
