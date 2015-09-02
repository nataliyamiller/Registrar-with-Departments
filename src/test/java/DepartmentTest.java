import org.junit.*;
import java.util.Arrays;
import static org.junit.Assert.*;
import java.util.List;

public class DepartmentTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();


  @Test
  public void departemnt_instantiatesCorrectly_true() {
    Department testDepartment = new Department("Languages");
    assertTrue(testDepartment instanceof Department);
  }

  @Test
  public void all_emptyAtFirst() {
      assertEquals(Department.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfDeparmentNamesAretheSame() {
    Department testDepartment = new Department("Languages");
    Department nextDepartment = new Department("Languages");
    assertTrue(testDepartment.equals(nextDepartment));
  }

  @Test
  public void save_savesNewDepartmentToDatabase_true() {
    Department newDepartment = new Department("Languages");
    newDepartment.save();
    Department savedDepartment = Department.all().get(0);
    assertTrue(savedDepartment.equals(newDepartment));
  }

  @Test
  public void find_findsDepartmentInDatabase() {
    Department testDepartment = new Department("Languages");
    testDepartment.save();
    Department savedDepartment = Department.find(testDepartment.getId());
    assertTrue(testDepartment.equals(savedDepartment));
  }

  @Test
  public void getStudents_retrievesAllStudentsFromDatabase_studentList() {
    Department myDepartment = new Department("Languages");
    myDepartment.save();
    Student firstStudent = new Student("Judith Smith", "09/01/15", myDepartment.getId());
    firstStudent.save();
    Student secondStudent = new Student("Feona Minth", "08/31/15", myDepartment.getId());
    secondStudent.save();
    Student[] students = new Student[] {firstStudent, secondStudent};
    assertTrue(myDepartment.getStudents().containsAll(Arrays.asList(students)));
  }

  @Test
  public void getCourses_retrievesAllCoursesFromDatabase_courseList() {
    Department myDepartment = new Department("Languages");
    myDepartment.save();
    Course firstCourse = new Course("French language", "FRCH101", myDepartment.getId());
    firstCourse.save();
    Course secondCourse = new Course("German language", "GRMN101", myDepartment.getId());
    secondCourse.save();
    Course[] courses = new Course[] {firstCourse, secondCourse};
    assertTrue(myDepartment.getCourses().containsAll(Arrays.asList(courses)));
  }

  // @Test
  // public void getStudents_returnsAllStudentsForStudent_ArrayList() {
  //   Department myDepartment = new Department("Languages");
  //   myDepartment.save();
  //   Student myStudent = new Student("Madison", "09/11/15", myDepartment.getId());
  //   myStudent.save();
  //   List savedStudents = myDepartment.getStudents();
  //   assertEquals(savedStudents.size(), 1);
  // }


}
