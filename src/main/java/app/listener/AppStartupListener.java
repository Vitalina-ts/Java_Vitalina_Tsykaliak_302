package app.listener;

import app.repository.CourseRepository;
import app.repository.DepartmentRepository;
import app.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.nio.file.Path;

@WebListener
public class AppStartupListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(AppStartupListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("AppStartupListener: initializing repositories");
        ServletContext ctx = sce.getServletContext();

        Path base = Path.of(System.getProperty("catalina.base", "."), "webapps", ctx.getContextPath(), "WEB-INF", "data");

        DepartmentRepository deptRepo = new DepartmentRepository(base.resolve("departments.json"));
        StudentRepository studentRepo = new StudentRepository(base.resolve("students.json"));
        CourseRepository courseRepo = new CourseRepository(base.resolve("courses.json"));

        deptRepo.loadAll(deptRepo.getTypeReference());
        studentRepo.loadAll(studentRepo.getTypeReference());
        courseRepo.loadAll(courseRepo.getTypeReference());

        ctx.setAttribute("departments", deptRepo);
        ctx.setAttribute("students", studentRepo);
        ctx.setAttribute("courses", courseRepo);

        logger.info("Repositories initialized and stored in ServletContext attributes.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("AppShutdown: contextDestroyed");
        
    }
}
