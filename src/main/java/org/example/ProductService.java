package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ProductService {

    private final WebClient webClient;

    @Value("${backend.api.url}")
    private String backendApiUrl;

    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(backendApiUrl).build();
    }

    public Product getProductById(Long id) {
        return this.webClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }

    public List<Product> getAllProducts() {
        return this.webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList()
                .block();
    }
}
