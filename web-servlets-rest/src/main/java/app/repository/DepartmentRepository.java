package app.repository;

import app.model.Department;
import com.fasterxml.jackson.core.type.TypeReference;

import java.nio.file.Path;
import java.util.List;

public class DepartmentRepository extends AbstractFileRepository<Department> {

    public DepartmentRepository(Path file) { super(file); }

    @Override
    protected String getId(Department d) { return d.getId(); }

    @Override
    protected TypeReference<List<Department>> getType() {
        return new TypeReference<>() {};
    }
}
