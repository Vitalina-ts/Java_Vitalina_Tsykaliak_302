package repository;

import java.util.*;
import java.util.logging.Logger;

public class GenericRepository<T> {
    private final List<T> items = new ArrayList<>();
    private final IdentityExtractor<T> identityExtractor;
    private static final Logger logger = Logger.getLogger(GenericRepository.class.getName());

    public GenericRepository(IdentityExtractor<T> identityExtractor) {
        this.identityExtractor = identityExtractor;
    }

    public void add(T item) {
        String id = identityExtractor.extractIdentity(item);
        if (findByIdentity(id) != null) {
            logger.warning("Duplicate identity detected: " + id);
        } else {
            items.add(item);
            logger.info("Added: " + item);
        }
    }

    public void remove(T item) {
        items.remove(item);
        logger.info("Removed: " + item);
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public T findByIdentity(String id) {
        for (T item : items) {
            if (identityExtractor.extractIdentity(item).equals(id)) {
                return item;
            }
        }
        return null;
    }
}
