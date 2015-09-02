import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.rules.ExternalResource;
import org.sql2o.*;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;


public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();

  // @Test
  // public void rootTest() {
  //   goTo("http://localhost:4567/");
  //   assertThat(pageSource()).contains("University Registrar");
  // }
  //
  // @Test
  // public void navBarTest() {
  //   goTo("http://localhost:4567/");
  //   assertThat(pageSource()).contains("View and Add Courses");
  // }
  //
  // @Test
  // public void courseListIsDisplayed() {
  //   goTo("http://localhost:4567/courses");
  //   assertThat(pageSource()).contains("Courses");
  // }
  //
  // @Test
  // public void courseIsSavedIntoDatabase() {
  //   goTo("http://localhost:4567/courses");
  //   fill("#course_name").with("French Literature");
  //   fill("#course_number").with("LTFR100");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("French Literature", "LTFR100");
  // }
  //
  // @Test
  // public void courseIsDisplayedOnCoursesPage() {
  //   Course myCourse = new Course("Calculus", "CALC200");
  //   myCourse.save();
  //   goTo("http://localhost:4567/courses");
  //   assertThat(pageSource()).contains("Calculus", "CALC200");
  // }
  //
  // @Test
  // public void courseIsDisplayedOnItsPage() {
  //   Course myCourse = new Course("Calculus", "CALC200");
  //   myCourse.save();
  //   String coursePath = String.format("http://localhost:4567/courses/%d", myCourse.getId());
  //   goTo(coursePath);
  //   assertThat(pageSource()).contains("Calculus", "CALC200");
  // }

}
