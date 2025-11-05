package repository;

import java.util.*;
import java.util.logging.Logger;

public class GenericRepository<T> {
    protected List<T> items = new ArrayList<>();
    protected final Logger logger = Logger.getLogger(getClass().getName());

    public void add(T item) {
        items.add(item);
        logger.info("Додано: " + item);
    }

    public List<T> getAll() {
        return items;
    }
}
