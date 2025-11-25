package app.servlet;

import app.model.*;
import app.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/api/*")
public class RestApiServlet extends HttpServlet {

    private final ObjectMapper mapper = new ObjectMapper();

    private DepartmentRepository dep;
    private StudentRepository stu;
    private CourseRepository cou;

    @Override
    public void init() {
        dep = (DepartmentRepository) getServletContext().getAttribute("depRepo");
        stu = (StudentRepository) getServletContext().getAttribute("stuRepo");
        cou = (CourseRepository) getServletContext().getAttribute("couRepo");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] parts = req.getPathInfo().split("/");
        String type = parts[1];
        resp.setContentType("application/json");

        switch (type) {
            case "departments" ->
                    mapper.writeValue(resp.getWriter(), dep.findAll());
            case "students" ->
                    mapper.writeValue(resp.getWriter(), stu.findAll());
            case "courses" ->
                    mapper.writeValue(resp.getWriter(), cou.findAll());
        }
    }

    // ----------- POST ------------
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String type = req.getPathInfo().substring(1);

        switch (type) {
            case "departments" -> dep.save(mapper.readValue(req.getReader(), Department.class));
            case "students" -> stu.save(mapper.readValue(req.getReader(), Student.class));
            case "courses" -> cou.save(mapper.readValue(req.getReader(), Course.class));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String[] parts = req.getPathInfo().split("/");
        String type = parts[1];
        String id = parts[2];

        switch (type) {
            case "departments" -> dep.delete(id);
            case "students" -> stu.delete(id);
            case "courses" -> cou.delete(id);
        }
    }
}
