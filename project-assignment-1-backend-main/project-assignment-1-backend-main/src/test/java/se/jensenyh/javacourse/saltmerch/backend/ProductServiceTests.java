package se.jensenyh.javacourse.saltmerch.backend;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;
import se.jensenyh.javacourse.saltmerch.backend.service.ProductService;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTests {

    @Mock
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Test
    public void testGetProduct() {
        Product product = new Product(1, "Paintings", "Bird Painting", "Painting of birds","BirdImg.jpg");
        when(productRepository.getEntireProduct(1)).thenReturn(product);

        Product result = productRepository.getEntireProduct(1);

        assertEquals("Paintings", result.category);
        assertEquals("Bird Painting", result.title);
        assertEquals("Painting of birds", result.description);
        assertEquals("BirdImg.jpg", result.previewImage);
    }


    @Test
    public void testGetAllProductsInCategory() {
        List<Product> database = Arrays.asList(
                new Product(1, "Paintings", "Bird Painting", "Painting of birds","BirdImg.jpg"),
                new Product(2, "Cloths", "T-shirt", "Yellow T-shirt","YellowTshirtImg.jpg")
        );
        when(productRepository.selectAll()).thenReturn(database);

        List<Product> result = productRepository.selectAll();

        assertEquals("Paintings", result.get(0).category);
        assertEquals("Cloths", result.get(1).category);
    }
}
