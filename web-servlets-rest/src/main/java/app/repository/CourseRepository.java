package app.repository;

import app.model.Course;
import com.fasterxml.jackson.core.type.TypeReference;

import java.nio.file.Path;
import java.util.List;

public class CourseRepository extends AbstractFileRepository<Course> {

    public CourseRepository(Path file) { super(file); }

    @Override
    protected String getId(Course c) { return c.getId(); }

    @Override
    protected TypeReference<List<Course>> getType() {
        return new TypeReference<>() {};
    }
}
