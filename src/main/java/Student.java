import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;

public class Student {
  private int id;
  private String name;
  private String enroll_date;
  private int department_id;

  public Student(String name, String enrollDate, int departmentId) {
    this.name = name;
    this.enroll_date = enrollDate;
    this.department_id = departmentId;
  }

  public String getName() {
    return name;
  }

  public String getEnrollDate() {
    return enroll_date;
  }

  public int getId() {
    return id;
  }

  public int getDepartmentId() {
    return department_id;
  }

  public static List<Student> all() {
    String sql = "SELECT * FROM students";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Student.class);
    }
  }

  @Override
  public boolean equals(Object otherStudent) {
    if (!(otherStudent instanceof Student)) {
      return false;
    } else {
      Student newStudent = (Student) otherStudent;
      return this.getName().equals(newStudent.getName()) &&
             this.getEnrollDate().equals(newStudent.getEnrollDate()) &&
             this.getDepartmentId() == newStudent.getDepartmentId() &&
             this.getId() == newStudent.getId();
    }
  }

  public void save() {
    String sql = "INSERT INTO students (name, enroll_date, department_id) VALUES (:name, :enroll_date, :department_id)";
    try(Connection con = DB.sql2o.open()) {
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", name)
        .addParameter("enroll_date", enroll_date)
        .addParameter("department_id", department_id)
        .executeUpdate()
        .getKey();
    }
  }

  public static Student find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM students WHERE id = :id";
      Student student = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Student.class); //why FetchFirst?
      return student;
    }
  }

  public void assignCourse(Course course) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO courses_students (course_id, student_id) VALUES (:course_id, :student_id)";
      con.createQuery(sql)
        .addParameter("course_id", course.getId())
        .addParameter("student_id", this.getId())
        .executeUpdate();
    }
  }

  public ArrayList<Course> getCourses() {
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT course_id FROM courses_students WHERE student_id = :student_id";
      List<Integer> courseIds = con.createQuery(sql)
        .addParameter("student_id", this.getId())
        .executeAndFetch(Integer.class);

      ArrayList<Course> courses = new ArrayList<Course>();

      for (Integer courseId : courseIds) {
          String studentQuery = "SELECT * FROM courses WHERE id = :course_id";
          Course course = con.createQuery(studentQuery)
            .addParameter("course_id", courseId)
            .executeAndFetchFirst(Course.class);
          courses.add(course);
      }
      return courses;
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String deleteQuery = "DELETE FROM students WHERE id = :id";
      con.createQuery(deleteQuery)
        .addParameter("id", id)
        .executeUpdate();

      String joinDeleteQuery = "DELETE FROM courses_students WHERE student_id = :student_id";
      con.createQuery(joinDeleteQuery)
        .addParameter("student_id", this.getId())
        .executeUpdate();
    }
  }


}
