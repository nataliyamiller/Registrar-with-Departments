import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

public class StudentTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Student.all().size(), 0);
  }

  @Test
  public void student_instantiatesCorrectly_true() {
    Student testStudent = new Student("Margarita", "09/25/15", 1);
    assertTrue(testStudent instanceof Student);
  }

  @Test
  public void equals_returnsTrueIfNamesAndEnrollDateAretheSame() {
    Student testStudent = new Student("Jane", "09/01/15", 1);
    Student nextStudent = new Student("Jane", "09/01/15", 1);
    assertTrue(testStudent.equals(nextStudent));
  }

  @Test
  public void save_savesNewStudentToDatabase_true() {
    Student newStudent = new Student("Jane", "09/01/15", 1);
    newStudent.save();
    Student savedStudent = Student.all().get(0);
    assertTrue(savedStudent.equals(newStudent));
  }

  @Test
  public void save_savesIdToObject() {
    Student testStudent = new Student("Joaquin", "08/25/15", 1);
    testStudent.save();
    Student savedStudent = Student.all().get(0);
    assertEquals(testStudent.getId(), savedStudent.getId());
  }

  @Test
  public void find_findsStudentInDatabase() {
    Student testStudent = new Student("Madison", "09/11/15", 1);
    testStudent.save();
    Student savedStudent = Student.find(testStudent.getId());
    assertTrue(testStudent.equals(savedStudent));
  }

  @Test
  public void assignCourse_AssignsCourseToStudent() {
    Course newCourse = new Course ("Math", "MTH110", 1);
    newCourse.save();
    Student newStudent = new Student("Madison", "09/11/15", 2);
    newStudent.save();
    newStudent.assignCourse(newCourse);
    Course savedCourse = newStudent.getCourses().get(0);
    assertTrue(newCourse.equals(savedCourse));
  }

  @Test
  public void getCourses_returnsAllCoursesForStudent_ArrayList() {
    Course myCourse = new Course("Math", "MTH110", 1);
    myCourse.save();
    Student myStudent = new Student("Madison", "09/11/15", 1);
    myStudent.save();
    myStudent.assignCourse(myCourse);
    List savedCourses = myStudent.getCourses();
    assertEquals(savedCourses.size(), 1);
  }

}
