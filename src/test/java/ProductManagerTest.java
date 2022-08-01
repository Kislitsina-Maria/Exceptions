import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class ProductManagerTest {

    ProductRepository repo = Mockito.mock(ProductRepository.class);
    ProductManager manager = new ProductManager(repo);

    PurchaseItem product1 = new PurchaseItem(1, 1, "Marmelad", 500, 2);
    PurchaseItem product2 = new PurchaseItem(2, 2, "Bread", 50, 1);
    PurchaseItem product3 = new PurchaseItem(3, 33, "Milk", 90, 1);




       @Test
       public void shouldReverseAllItems() {
           PurchaseItem[] items = { product1, product2, product3};
           doReturn(items).when(repo).getItems();
           PurchaseItem[] expected = {product3, product2, product1};
            PurchaseItem[] actual = manager.getItems();

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
    public void shouldReverseSum() {
           PurchaseItem[] items = { product1, product2, product3};
           doReturn(items).when(repo).getItems();
        int expected = 644;
        int actual = manager.getTotal();

        Assertions.assertEquals(expected, actual);

        }



}
