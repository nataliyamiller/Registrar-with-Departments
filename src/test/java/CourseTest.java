import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

public class CourseTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
      assertEquals(Course.all().size(), 0);
  }

  @Test
  public void course_instantiatesCorrectly_true() {
    Course testCourse = new Course("Margarita", "09/25/15", 1);
    assertTrue(testCourse instanceof Course);
  }

  @Test
  public void equals_returnsTrueIfNamesAndEnrollDateAretheSame() {
    Course testCourse = new Course("Jane", "09/01/15", 1);
    Course nextCourse = new Course("Jane", "09/01/15", 1);
    assertTrue(testCourse.equals(nextCourse));
  }

  @Test
  public void save_savesNewCourseToDatabase_true() {
    Course newCourse = new Course("Jane", "09/01/15", 1);
    newCourse.save();
    Course savedCourse = Course.all().get(0);
    assertTrue(savedCourse.equals(newCourse));
  }

  @Test
  public void save_savesIdToObject() {
    Course testCourse = new Course("Joaquin", "08/25/15", 1);
    testCourse.save();
    Course savedCourse = Course.all().get(0);
    assertEquals(testCourse.getId(), savedCourse.getId());
  }

  @Test
  public void find_findsCourseInDatabase() {
    Course testCourse = new Course("Madison", "09/11/15", 1);
    testCourse.save();
    Course savedCourse = Course.find(testCourse.getId());
    assertTrue(testCourse.equals(savedCourse));
  }

  @Test
  public void assignStudent_AssignsStudentToCourse() {
    Course newCourse = new Course ("Math", "MTH110", 1);
    newCourse.save();
    Student newStudent = new Student("Madison", "09/11/15", 2);
    newStudent.save();
    newCourse.assignStudent(newStudent);
    Student savedStudent = newCourse.getStudents().get(0);
    assertTrue(newStudent.equals(savedStudent));
  }

  @Test
  public void getStudents_returnsAllStudentsForCourse_ArrayList() {
    Course myCourse = new Course("Math", "MTH110", 1);
    myCourse.save();
    Student myStudent = new Student("Madison", "09/11/15", 2);
    myStudent.save();
    myCourse.assignStudent(myStudent);
    List savedStudents = myCourse.getStudents();
    assertEquals(savedStudents.size(), 1);
  }

  @Test
    public void delete_deletesAllAssociationsForACourse() {
      Course myCourse = new Course("Math", "MTH110", 1);
      myCourse.save();

      Student myStudent = new Student("Madison", "09/11/15", 2);
      myStudent.save();

      myCourse.assignStudent(myStudent);
      myCourse.delete();
      assertEquals(myStudent.getCourses().size(), 0);
    }

}
