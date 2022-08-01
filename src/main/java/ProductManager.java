public class ProductManager {
    public ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(PurchaseItem item) {
        repo.save(item);
    }

    public void delete(int id) {
        repo.removeById(id);
    }

    public PurchaseItem[] getItems() {
        PurchaseItem[] all = repo.getItems();
        PurchaseItem[] reverce = new PurchaseItem[all.length];
        for (int i = 0; i < all.length; i++) {
            reverce[i] = all[all.length - 1 - i];
        }
        return reverce;
    }

    public int getTotal() {
        int sum = 0;
        for (PurchaseItem item : repo.getItems()) {
            sum = sum + item.getCount() + item.getProductPrice();
        }
        return sum;
    }


}
