package app.repository;

import app.model.Student;
import com.fasterxml.jackson.core.type.TypeReference;

import java.nio.file.Path;
import java.util.List;

public class StudentRepository extends AbstractFileRepository<Student> {

    public StudentRepository(Path file) { super(file); }

    @Override
    protected String getId(Student s) { return s.getId(); }

    @Override
    protected TypeReference<List<Student>> getType() {
        return new TypeReference<>() {};
    }
}
