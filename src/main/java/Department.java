import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;

public class Department {
  private String department_name;
  private int id;


  public String getDepartmentName() {
    return department_name;
  }

  public int getId() {
    return id;
  }

  public Department(String departmentName) {
    this.department_name = departmentName;
  }

  public static List<Department> all() {
    String sql = "SELECT * FROM departments";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Department.class);
    }
  }

  @Override
  public boolean equals(Object otherDepartment) {
    if (!(otherDepartment instanceof Department)) {
      return false;
    } else {
      Department newDepartment = (Department) otherDepartment;
      return this.getDepartmentName().equals(newDepartment.getDepartmentName()) &&
             this.getId() == newDepartment.getId();
    }
  }

  public void save() {
    String sql = "INSERT INTO departments (department_name) VALUES (:department_name)";
    try(Connection con = DB.sql2o.open()) {
      this.id = (int) con.createQuery(sql, true)
        .addParameter("department_name", department_name)
        .executeUpdate()
        .getKey();
    }
  }

  public static Department find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM departments WHERE id = :id";
      Department department = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Department.class); //why FetchFirst?
      return department;
    }
  }

  public List<Student> getStudents() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM students WHERE department_id = :id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Student.class);
    }
  }

  public List<Course> getCourses() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM courses WHERE department_id = :id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Course.class);
    }
  }



}
