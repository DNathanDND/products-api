package uk.ac.westminster.products_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductServiceTests {

    @Test
    void startsWithDigitalAndPhysicalProducts() {
        ProductService service = new ProductService();

        assertEquals(2, service.getAllProducts().size());
        assertInstanceOf(DigitalProduct.class, service.getAllProducts().get(0));
        assertInstanceOf(PhysicalProduct.class, service.getAllProducts().get(1));
    }

    @Test
    void assignsIdsAndFindsProductsById() {
        ProductService service = new ProductService();
        Product added = service.addProduct(new Product(null, "Laptop", 899.99));

        assertEquals(3L, added.getId());
        assertTrue(service.getProductById(added.getId()).isPresent());
        assertTrue(service.getProductById(99L).isEmpty());
    }

    @Test
    void searchesByPartOfNameAndDeletesProducts() {
        ProductService service = new ProductService();

        assertEquals(1, service.findByName("Java").size());
        service.deleteProduct(2L);

        assertTrue(service.getProductById(2L).isEmpty());
    }

    @Test
    void readsDigitalProductJsonAsASubclass() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Product product = objectMapper.readValue(
                "{\"name\":\"Sample download\",\"price\":5.0,"
                        + "\"downloadUrl\":\"/sample.pdf\",\"fileSizeMB\":1.5}",
                Product.class);

        DigitalProduct digitalProduct = assertInstanceOf(DigitalProduct.class, product);
        assertEquals("/sample.pdf", digitalProduct.getDownloadUrl());
        assertEquals(1.5, digitalProduct.getFileSizeMB());
    }
}
