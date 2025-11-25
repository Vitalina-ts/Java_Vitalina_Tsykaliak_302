package app.listener;

import app.repository.*;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.nio.file.Path;

public class AppStartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        DepartmentRepository dep = new DepartmentRepository(Path.of("data/departments.json"));
        StudentRepository stu = new StudentRepository(Path.of("data/students.json"));
        CourseRepository cou = new CourseRepository(Path.of("data/courses.json"));

        dep.load();
        stu.load();
        cou.load();

        sce.getServletContext().setAttribute("depRepo", dep);
        sce.getServletContext().setAttribute("stuRepo", stu);
        sce.getServletContext().setAttribute("couRepo", cou);
    }
}
