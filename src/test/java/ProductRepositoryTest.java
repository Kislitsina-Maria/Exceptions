import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    PurchaseItem product1 = new PurchaseItem(1, 1, "Marmelad", 500, 2);
    PurchaseItem product2 = new PurchaseItem(2, 2, "Bread", 50, 1);
    PurchaseItem product3 = new PurchaseItem(3, 33, "Milk", 90, 1);


    @Test
    public void addNewItems() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        PurchaseItem[] actual = repository.getItems();

        PurchaseItem[] expected = {product1, product2, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteItems() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);

        Assertions.assertThrows(NegativeIdException.class, () -> {
            repository.removeById(-100);
        });
    }

    @Test
    public void deleteUnknownItems() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(50);
        });
    }


}
