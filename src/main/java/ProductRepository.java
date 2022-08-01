public class ProductRepository {

    private PurchaseItem[] items = new PurchaseItem[0];

    public void save(PurchaseItem item) {
        PurchaseItem[] tmp = new PurchaseItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            if (findById(item.getId()) == findById(items[i].getId())) {
                throw new AlreadyExistsException(
                        "Element with id: \" + id + \" is exists"
                );
            }
            tmp[i] = items[i];
        }
        tmp[items.length] = item;
        items = tmp;
    }

    public void removeById(int id) {
        if (id < 0) {
            throw new NegativeIdException(
                    "ID can't be negative: " + id
            );
        }
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: \" + id + \" not found"
            );
        }
        PurchaseItem[] tmp = new PurchaseItem[items.length - 1];
        int copyToIndex = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex += 1;
            }
        }
        items = tmp;
    }

    public PurchaseItem findById(int id) {
        if (id < 0) {
            throw new NegativeIdException(
                    "ID can't be negative: " + id
            );
        }
        for (PurchaseItem item : getItems()) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    public PurchaseItem[] getItems() {
        return items;
    }
}
