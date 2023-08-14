package com.example.first;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
	    return productRepository.save(product);
	}

	@GetMapping
	public List<Product> getAllProducts() {
	    return productRepository.findAll();
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
	    Optional<Product> product = productRepository.findById(productId);
	    return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
	    Optional<Product> existingProduct = productRepository.findById(productId);
	    if (existingProduct.isPresent()) {
	        updatedProduct.setProductId(productId);
	        return ResponseEntity.ok(productRepository.save(updatedProduct));
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
	    productRepository.deleteById(productId);
	    return ResponseEntity.noContent().build();
	}

}
