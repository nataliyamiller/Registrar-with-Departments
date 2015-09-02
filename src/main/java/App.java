import java.util.HashMap;
import java.util.List;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    // /* Index */
    // get("/", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/index.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // /* Index --> Courses list */
    // get("/courses", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("courses", Course.all());
    //   model.put("template", "templates/courses.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // /* Index --> Students list */
    // get("/students", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("students", Student.all());
    //   model.put("template", "templates/students.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // /* Courses list --> POST a new course (displays on course list view) */
    // post("/courses", (request, reponse) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   String course_name = request.queryParams("course_name");
    //   String course_number = request.queryParams("course_number");
    //   Course newCourse = new Course(course_name, course_number);
    //   newCourse.save();
    //   model.put("courses", Course.all());
    //   model.put("template", "templates/courses.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // /* Student list --> POST a new student (displays on student list view) */
    // post("/students", (request, reponse) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   String name = request.queryParams("name");
    //   String enroll_date = request.queryParams("enroll_date");
    //   Student newStudent = new Student(name, enroll_date);
    //   newStudent.save();
    //   model.put("students", Student.all());
    //   model.put("template", "templates/students.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // /* Courses list --> view individual course */
    // get("/courses/:id", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   int id = Integer.parseInt(request.params("id"));
    //   Course course = Course.find(id);
    //   model.put("course", course);
    //   model.put("students", course.getStudents());
    //   model.put("template", "templates/course.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // /* Individual course --> POST a new student (displays on course view) */
    // post("/courses/:id", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   Course course = Course.find(Integer.parseInt(request.params("id")));
    //   model.put("course", course);
    //   String name = request.queryParams("name");
    //   String enroll_date = request.queryParams("enroll_date");
    //   Student newStudent = new Student(name, enroll_date);
    //   newStudent.save();
    //   course.assignStudent(newStudent);
    //   response.redirect("/courses/" + request.params(":id"));
    //   return null;
    // });
    //
    // /* Students list --> view individual student */
    // get("/students/:id", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   int id = Integer.parseInt(request.params("id"));
    //   Student student = Student.find(id);
    //   model.put("student", student);
    //   model.put("courses", student.getCourses());
    //   model.put("template", "templates/student.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // /* Individual student --> POST a new course (displays on student's page view) */
    // post("/students/:id", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   Student student = Student.find(Integer.parseInt(request.params("id")));
    //   model.put("student", student);
    //   String course_name = request.queryParams("course_name");
    //   String course_number = request.queryParams("course_number");
    //   Course newCourse = new Course(course_name, course_number);
    //   newCourse.save();
    //   student.assignCourse(newCourse);
    //   response.redirect("/students/" + request.params(":id"));
    //   return null;
    // });

  }
}
