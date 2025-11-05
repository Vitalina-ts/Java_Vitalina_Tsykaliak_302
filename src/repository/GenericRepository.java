package repository;

import java.util.*;
import java.util.logging.Logger;

public class GenericRepository<T extends Comparable<T>> {
    protected List<T> items = new ArrayList<>();
    protected final Logger logger = Logger.getLogger(getClass().getName());

    public void add(T item) {
        items.add(item);
        logger.info("Додано: " + item);
    }

    public List<T> getAll() {
        return items;
    }

    // Сортування за "identity" — тобто за natural order (Comparable)
    public void sortByIdentity(String order) {
        logger.info("Сортування за основним полем у порядку: " + order);
        if (order.equalsIgnoreCase("asc")) {
            Collections.sort(items);
        } else if (order.equalsIgnoreCase("desc")) {
            Collections.sort(items, Collections.reverseOrder());
        } else {
            logger.warning("Невідомий тип сортування!");
        }
    }
}
