package app.repository;

import app.util.JsonFileUtil;
import com.fasterxml.jackson.core.type.TypeReference;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public abstract class AbstractFileRepository<T> {

    protected final Path file;
    protected final Map<String, T> storage = new ConcurrentHashMap<>();

    protected AbstractFileRepository(Path file) {
        this.file = file;
    }

    protected abstract String getId(T obj);
    protected abstract TypeReference<List<T>> getType();

    public void load() {
        try {
            List<T> list = JsonFileUtil.read(file, getType());
            storage.clear();
            storage.putAll(list.stream()
                .collect(Collectors.toMap(this::getId, x -> x)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> findAll() {
        return List.copyOf(storage.values());
    }

    public Optional<T> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    public void save(T obj) {
        storage.put(getId(obj), obj);
        persist();
    }

    public boolean delete(String id) {
        if (storage.remove(id) != null) {
            persist();
            return true;
        }
        return false;
    }

    public void persist() {
        try {
            JsonFileUtil.write(file, findAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
