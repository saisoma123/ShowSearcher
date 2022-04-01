// --== CS400 Project One File Header ==--
// Name: Andrew Schaumberger
// CSL Username: schaumberger
// Email: aschaumberge@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: n/a

import java.util.NoSuchElementException;

/**
 * This class tests the different methods within the HashtableMap class for all the required
 * functionalities laid out by the P1W2 specification
 */
public class HashtableMapTests {

  /**
   * Tests the functionality of both the parameterized and unparameterized constructors to check
   * whether they create a new HashtableMap with the correct size, capacity, and table array size
   * 
   * @return true if all tests pass without unexpected errors, false otherwise
   */
  public static boolean test1() {
    try {
      HashtableMap<String, String> testMap1 = new HashtableMap<String, String>();
      if (testMap1.size != 0 || testMap1.capacity != 20 || testMap1.table.length != 20) {
        return false;
      }
      HashtableMap<String, String> testMap2 = new HashtableMap<String, String>(10);
      if (testMap2.size != 0 || testMap2.capacity != 10 || testMap2.table.length != 10) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Tests the functionality of the put() method by running the command several times with different
   * parameters (as normal, with already-used key, with null key, with null value) and checking both
   * the return of the put() command and the size of the HashtableMap for expected changes
   * 
   * @return true if all tests pass without unexpected errors, false otherwise
   */
  public static boolean test2() {
    try {
      HashtableMap<String, String> testMap = new HashtableMap<String, String>();
      boolean value = testMap.put("sampleKey", "sampleValue");
      if (value != true || testMap.size != 1) {
        return false;
      }
      value = testMap.put("sampleKey", "otherValue");
      if (value != false || testMap.size != 1) {
        return false;
      }
      value = testMap.put(null, "otherValue");
      if (value != false || testMap.size != 1) {
        return false;
      }
      value = testMap.put("otherKey", null);
      if (value != true || testMap.size != 2) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Tests the functionality of the containsKey() and get() methods by running the commands several
   * times with different parameters (as normal, null key, nonexistent key) and checking the returns
   * of the commands for expected results
   * 
   * @return true if all tests pass without unexpected errors, false otherwise
   */
  public static boolean test3() {
    try {
      HashtableMap<String, String> testMap = new HashtableMap<String, String>();
      testMap.put("sampleKey", "sampleValue");
      if (!testMap.containsKey("sampleKey")) {
        return false;
      }
      if (!testMap.get("sampleKey").equals("sampleValue")) {
        return false;
      }
      if (testMap.containsKey(null)) {
        return false;
      }
      if (testMap.containsKey("otherKey")) {
        return false;
      }
      try {
        testMap.get(null);
        return false;
      } catch (NoSuchElementException e) {
      }
      try {
        testMap.get("otherKey");
        return false;
      } catch (NoSuchElementException e) {
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks the functionality of the remove(), size() and clear() methods by running remove()
   * several times with different parameters (as normal, nonexistent key, null key) before using
   * clear(), and using size() and containsKey() to check the results are as expected
   * 
   * @return true if all tests pass without unexpected errors, false otherwise
   */
  public static boolean test4() {
    try {
      HashtableMap<String, String> testMap = new HashtableMap<String, String>();
      if (testMap.size() != 0) {
        return false;
      }
      testMap.put("sampleKey", "sampleValue");
      if (testMap.size() != 1 || !testMap.containsKey("sampleKey")) {
        return false;
      }
      String value = testMap.remove("sampleKey");
      if (testMap.size() != 0 || !value.equals("sampleValue") || testMap.containsKey("sampleKey")) {
        return false;
      }
      testMap.put("sampleKey", "sampleValue");
      if (testMap.size() != 1) {
        return false;
      }
      value = testMap.remove("otherKey");
      if (testMap.size() != 1 || value != null || !testMap.containsKey("sampleKey")) {
        return false;
      }
      value = testMap.remove(null);
      if (testMap.size() != 1 || value != null || !testMap.containsKey("sampleKey")) {
        return false;
      }
      testMap.clear();
      if (testMap.size() != 0 || testMap.containsKey("sampleKey")) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Tests the functionality of the grow() helper method by using put() several times (2 key-value
   * pairs, 3 pairs, and 4 pairs in a map with an original capacity of 3) and checking the capacity
   * and size of the HashtableMap to see if grow() expanded the map
   * 
   * @return true if all tests pass without unexpected errors, false otherwise
   */
  public static boolean test5() {
    try {
      HashtableMap<String, String> testMap = new HashtableMap<String, String>(3);
      testMap.put("sampleKey", "sampleValue");
      testMap.put("otherKey", "otherValue");
      if (testMap.capacity != 3 || testMap.size() != 2 || !testMap.containsKey("sampleKey")
          || !testMap.containsKey("otherKey")) {
        return false;
      }
      testMap.put("someKey", "someValue");
      if (testMap.capacity != 6 || testMap.size() != 3 || !testMap.containsKey("sampleKey")
          || !testMap.containsKey("otherKey") || !testMap.containsKey("someKey")) {
        return false;
      }
      testMap.put("oneMoreKey", "oneMoreValue");
      if (testMap.capacity != 6 || testMap.size() != 4 || !testMap.containsKey("sampleKey")
          || !testMap.containsKey("otherKey") || !testMap.containsKey("someKey")
          || !testMap.containsKey("oneMoreKey")) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Runs all the above tests at once
   * 
   * @return true if all tests pass without unexpected errors, false otherwise
   */
  public static boolean runAllTests() {
    return test1() && test2() && test3() && test4() && test5();
  }

  /**
   * Main method, calls the above method to run all tests and prints the output
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }

}
