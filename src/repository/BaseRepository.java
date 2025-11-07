package repository;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository<T> {
    protected List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
        System.out.println("[LOG] Added: " + item);
    }

    public List<T> getAll() {
        return items;
    }
}
