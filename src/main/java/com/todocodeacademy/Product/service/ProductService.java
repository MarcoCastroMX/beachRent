package com.todocodeacademy.Product.service;

import com.todocodeacademy.Product.dto.ProductRequestDTO;
import com.todocodeacademy.Product.dto.ProductResponseDTO;
import com.todocodeacademy.Product.model.Product;
import com.todocodeacademy.Product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repo;

    @Autowired
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    // Crear un nuevo producto
    public ProductResponseDTO create(ProductRequestDTO req) {
        Product product = new Product();
        product.setName(req.name());
        product.setCategory(req.category());
        product.setStock(req.stock());
        product.setPricePerHour(req.pricePerHour());
        product.setActive(req.active());
        product = repo.save(product);
        return toResp(product);
    }

    // Actualizar un producto existente por id
    public ProductResponseDTO update(Long id, ProductRequestDTO req) {
        Product product = repo.findById(id).orElse(null);
        if (product == null) return null;
        product.setName(req.name());
        product.setCategory(req.category());
        product.setStock(req.stock());
        product.setPricePerHour(req.pricePerHour());
        product.setActive(req.active());
        return toResp(repo.save(product));
    }

    // Eliminar un producto por id
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // Obtener un producto por id
    public ProductResponseDTO get(Long id) {
        return repo.findById(id).map(this::toResp).orElse(null);
    }

    // Listar todos los productos
    public List<ProductResponseDTO> list() {
        return repo.findAll().stream().map(this::toResp).collect(Collectors.toList());
    }

    // Método auxiliar para mapear Product → ProductResponseDTO
    private ProductResponseDTO toResp(Product product) {
        ProductResponseDTO prodResp = new ProductResponseDTO();
        prodResp.setId(product.getId());
        prodResp.setName(product.getName());
        prodResp.setCategory(product.getCategory());
        prodResp.setStock(product.getStock());
        prodResp.setPricePerHour(product.getPricePerHour());
        prodResp.setActive(product.isActive());
        return prodResp;
    }
}
