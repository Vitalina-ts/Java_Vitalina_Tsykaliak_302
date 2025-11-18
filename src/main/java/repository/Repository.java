package repository;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    protected final List<T> storage = new ArrayList<>();

    public void add(T obj) {
        storage.add(obj);
    }

    public List<T> getAll() {
        return storage;
    }
}
