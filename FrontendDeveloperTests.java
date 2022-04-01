import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FrontendDeveloperTests {
  DroughtFrontend frontend;
  PBackend backend;

  @Before
  public void setUp() {
    backend = new PBackend();
    frontend = new DroughtFrontend(backend);
  }
  @Test
  /**
   * Tests if the quit option works
   */
  public void test1() {
    TextUITester tester = new TextUITester("Q\n");

    DroughtFrontend frontend = new DroughtFrontend(new PBackend());
    frontend.runCommandLoop();
    
    String output = tester.checkOutput();
    assertEquals(output, "Welcome to the Drought Searcher App!\r\n=================================\r\nCommand Menu:\r\n\t1) [S] Search by severity\r\n\t2) [D] Search by date\r\n\t3) [Y] Search by years\r\n\t4) [A] Search for years with highest/lowest drought percentages\r\n\t5) [Q] Quit\r\nChoose a command from the menu above: Thanks for using the Drought Searcher!\r\n");
  }

  @Test
  /**
   * Tests if the severity search works and if multiple options work
   */
  public void test2() {
    TextUITester tester = new TextUITester("S\n1\ns\n0\n1\n2\nQ\n");

    DroughtFrontend frontend = new DroughtFrontend(new PBackend());
    frontend.runCommandLoop();

    String output = tester.checkOutput();
    assertEquals(output,"Welcome to the Drought Searcher App!\r\n=================================\r\nCommand Menu:\r\n\t1) [S] Search by severity\r\n\t2) [D] Search by date\r\n\t3) [Y] Search by years\r\n\t4) [A] Search for years with highest/lowest drought percentages\r\n\t5) [Q] Quit\r\nChoose a command from the menu above: Choose a severity you would like to search for: \r\nFound 1/2310 matches.\r\n1. 2022-02-15, 2022-02-21, 60.82, 47.81, 30.37, 9.9, 1.04\r\nCommand Menu:\r\n\t1) [S] Search by severity\r\n\t2) [D] Search by date\r\n\t3) [Y] Search by years\r\n\t4) [A] Search for years with highest/lowest drought percentages\r\n\t5) [Q] Quit\r\nChoose a command from the menu above: Choose a severity you would like to search for: \r\nFound 1/2310 matches.\r\n1. 2000-01-04, 2000-01-10, 42.71, 19.61, 7.9, 0.0, 0.0\r\nCommand Menu:\r\n\t1) [S] Search by severity\r\n\t2) [D] Search by date\r\n\t3) [Y] Search by years\r\n\t4) [A] Search for years with highest/lowest drought percentages\r\n\t5) [Q] Quit\r\nChoose a command from the menu above: Choose a severity you would like to search for: \r\nFound 1/2310 matches.\r\n1. 2022-02-08, 2022-02-14, 40.34, 59.66, 46.5, 29.58, 9.46\r\nCommand Menu:\r\n\t1) [S] Search by severity\r\n\t2) [D] Search by date\r\n\t3) [Y] Search by years\r\n\t4) [A] Search for years with highest/lowest drought percentages\r\n\t5) [Q] Quit\r\nChoose a command from the menu above: Thanks for using the Drought Searcher!\r\n");
    
  }

  @Test
  /**
   * Tests if the date search works
   */
  public void test3() {
    TextUITester tester = new TextUITester("D\n2022-02-15\nQ\n");

    DroughtFrontend frontend = new DroughtFrontend(new PBackend());
    frontend.runCommandLoop();

    String output = tester.checkOutput();
    assertEquals(output, "Welcome to the Drought Searcher App!\r\n=================================\r\nCommand Menu:\r\n\t1) [S] Search by severity\r\n\t2) [D] Search by date\r\n\t3) [Y] Search by years\r\n\t4) [A] Search for years with highest/lowest drought percentages\r\n\t5) [Q] Quit\r\nChoose a command from the menu above: Choose a date you would like to search for: Found 1/2310 matches.\r\n1. 2022-02-15, 2022-02-21, 60.82, 47.81, 30.37, 9.9, 1.04\r\nCommand Menu:\r\n\t1) [S] Search by severity\r\n\t2) [D] Search by date\r\n\t3) [Y] Search by years\r\n\t4) [A] Search for years with highest/lowest drought percentages\r\n\t5) [Q] Quit\r\nChoose a command from the menu above: Thanks for using the Drought Searcher!\r\n");
  }

  @Test
  /**
   * Tests if the year search works and if multiple options work
   */
  public void test4() {
    TextUITester tester = new TextUITester("Y\n2022\ny\n2000\nQ\n");

    DroughtFrontend frontend = new DroughtFrontend(new PBackend());
    frontend.runCommandLoop();

    String output = tester.checkOutput();
    assertEquals(output, "Welcome to the Drought Searcher App!\r\n=================================\r\nCommand Menu:\r\n\t1) [S] Search by severity\r\n\t2) [D] Search by date\r\n\t3) [Y] Search by years\r\n\t4) [A] Search for years with highest/lowest drought percentages\r\n\t5) [Q] Quit\r\nChoose a command from the menu above: Choose a year you would like to search for: Found 1/2310 matches.\r\n1. 2022-02-15, 2022-02-21, 60.82, 47.81, 30.37, 9.9, 1.04\r\nCommand Menu:\r\n\t1) [S] Search by severity\r\n\t2) [D] Search by date\r\n\t3) [Y] Search by years\r\n\t4) [A] Search for years with highest/lowest drought percentages\r\n\t5) [Q] Quit\r\nChoose a command from the menu above: Choose a year you would like to search for: Found 1/2310 matches.\r\n1. 2000-01-04, 2000-01-10, 42.71, 19.61, 7.9, 0.0, 0.0\r\nCommand Menu:\r\n\t1) [S] Search by severity\r\n\t2) [D] Search by date\r\n\t3) [Y] Search by years\r\n\t4) [A] Search for years with highest/lowest drought percentages\r\n\t5) [Q] Quit\r\nChoose a command from the menu above: Thanks for using the Drought Searcher!\r\n");
  }

  @Test
  /**
   * Tests if the advanced year search works and if multiple options work
   */
  public void test5() {
    TextUITester tester = new TextUITester("A\nH\na\nL\nQ\n");

    DroughtFrontend frontend = new DroughtFrontend(new PBackend());
    frontend.runCommandLoop();

    String output = tester.checkOutput();
    assertEquals(output, "Welcome to the Drought Searcher App!\r\n=================================\r\nCommand Menu:\r\n\t1) [S] Search by severity\r\n\t2) [D] Search by date\r\n\t3) [Y] Search by years\r\n\t4) [A] Search for years with highest/lowest drought percentages\r\n\t5) [Q] Quit\r\nChoose a command from the menu above: Would you like to search for the [h/H]ighest or [l/L]owest?\r\nFound 2/2310 matches.\r\n1. 2000-01-04, 2000-01-10, 42.71, 19.61, 7.9, 0.0, 0.0\r\n2. 2022-01-25, 2022-01-31, 59.41, 46.14, 30.4, 10.2, 1.1\r\nCommand Menu:\r\n\t1) [S] Search by severity\r\n\t2) [D] Search by date\r\n\t3) [Y] Search by years\r\n\t4) [A] Search for years with highest/lowest drought percentages\r\n\t5) [Q] Quit\r\nChoose a command from the menu above: Would you like to search for the [h/H]ighest or [l/L]owest?\r\nFound 1/2310 matches.\r\n1. 2022-02-15, 2022-02-21, 60.82, 47.81, 30.37, 9.9, 1.04\r\nCommand Menu:\r\n\t1) [S] Search by severity\r\n\t2) [D] Search by date\r\n\t3) [Y] Search by years\r\n\t4) [A] Search for years with highest/lowest drought percentages\r\n\t5) [Q] Quit\r\nChoose a command from the menu above: Thanks for using the Drought Searcher!\r\n");
  }



}
