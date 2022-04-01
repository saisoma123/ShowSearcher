// --== CS400 Project One File Header ==--
// Name: Andrew Schaumberger
// CSL Username: schaumberger
// Email: aschaumberge@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: n/a

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This class tests the different methods within the HashTableSortedSets class for all the required
 * functionalities laid out by the P1W3 AE specification
 */
public class AlgorithmEngineerTests {

  /**
   * Tests the basic functionality of the HashTableSortedSets class by creating a new Hashtable,
   * adding a new value, and getting the List containing the value
   * 
   * @return true if all tests pass without unexpected errors, false otherwise
   */
  public static boolean test1() {
    try {
      HashTableSortedSets<String, String> newTable = new HashTableSortedSets<String, String>();
      if (newTable.capacity != 20 || newTable.size() != 0) {
        return false;
      }
      newTable.add("testKey", "testValue1");
      if (newTable.size() != 1 || !newTable.containsKey("testKey")) {
        return false;
      }
      LinkedList<String> testList = new LinkedList<String>();
      testList.add("testValue1");
      if (!newTable.get("testKey").equals(testList)) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Tests the functionality of the add() method more rigorously by creating a new Hashtable,
   * creating a new List, adding multiple values to the List, adding duplicate values to the List,
   * and attempting to add null keys/values to the List
   * 
   * @return true if all tests pass without unexpected errors, false otherwise
   */
  public static boolean test2() {
    try {
      HashTableSortedSets<String, String> newTable = new HashTableSortedSets<String, String>();
      newTable.add("testKey", "testValue1");
      LinkedList<String> testList = new LinkedList<String>();
      testList.add("testValue1");
      if (newTable.size() != 1 || !newTable.containsKey("testKey")
          || !newTable.get("testKey").equals(testList)) {
        return false;
      }
      newTable.add("testKey", "testValue2");
      testList.add("testValue2");
      if (newTable.size() != 1 || !newTable.containsKey("testKey")
          || !newTable.get("testKey").equals(testList)) {
        return false;
      }
      newTable.add("testKey", "testValue2");
      testList.add("testValue2");
      if (newTable.size() != 1 || !newTable.containsKey("testKey")
          || !newTable.get("testKey").equals(testList)) {
        return false;
      }
      newTable.add(null, "testValue");
      if (newTable.size() != 1 || newTable.containsKey(null) || !newTable.containsKey("testKey")
          || !newTable.get("testKey").equals(testList)) {
        return false;
      }
      newTable.add("testKey", null);
      if (newTable.size() != 1 || !newTable.containsKey("testKey")
          || !newTable.get("testKey").equals(testList)) {
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Tests the functionality of the add() method on Lists manually put into the Hashtable by putting
   * and adding to both LinkedLists and ArrayLists and checking to see if the expected changes are
   * made
   * 
   * @return true if all tests pass without unexpected errors, false otherwise
   */
  public static boolean test3() {
    try {
      HashTableSortedSets<String, String> newTable = new HashTableSortedSets<String, String>();
      LinkedList<String> testList = new LinkedList<String>();
      testList.add("testValue1");
      testList.add("testValue2");
      newTable.put("testKey", testList);
      if (newTable.size() != 1 || !newTable.containsKey("testKey")
          || !newTable.get("testKey").equals(testList)) {
        return false;
      }
      newTable.add("testKey", "testValue3");
      testList.add("testValue3");
      if (newTable.size() != 1 || !newTable.containsKey("testKey")
          || !newTable.get("testKey").equals(testList)) {
        return false;
      }
      ArrayList<String> testArrayList = new ArrayList<String>();
      testArrayList.add("testValue1");
      testArrayList.add("testValue2");
      newTable.put("testKey2", testArrayList);
      if (newTable.size() != 2 || !newTable.containsKey("testKey2")
          || !newTable.get("testKey2").equals(testArrayList)) {
        return false;
      }
      newTable.add("testKey2", "testValue3");
      testArrayList.add("testValue3");
      if (newTable.size() != 2 || !newTable.containsKey("testKey2")
          || !newTable.get("testKey2").equals(testArrayList)) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Tests the functionality of the sorting implementation in add() by both adding one-by-one to a
   * List and adding to a List put into the Hashtable prior, and checking against lists sorted
   * separately
   * 
   * @return true if all tests pass without unexpected errors, false otherwise
   */
  public static boolean test4() {
    try {
      HashTableSortedSets<String, String> newTable = new HashTableSortedSets<String, String>();
      LinkedList<String> testList = new LinkedList<String>();
      newTable.add("testKey", "c");
      newTable.add("testKey", "b");
      newTable.add("testKey", "d");
      newTable.add("testKey", "a");
      newTable.add("testKey", "e");

      testList.add("c");
      testList.add("b");
      testList.add("d");
      testList.add("a");
      testList.add("e");
      Collections.sort(testList);
      if (newTable.size() != 1 || !newTable.containsKey("testKey")
          || !newTable.get("testKey").equals(testList)) {
        return false;
      }
      LinkedList<String> testList2 = new LinkedList<String>();
      testList2.add("c");
      testList2.add("b");
      testList2.add("d");
      testList2.add("a");
      testList2.add("e");
      newTable.put("testKey2", testList2);
      testList2.add("f");
      Collections.sort(testList2);
      newTable.add("testKey2", "f");
      if (newTable.size() != 2 || !newTable.containsKey("testKey2")
          || !newTable.get("testKey2").equals(testList2)) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Tests the functionality of the remove() and clear() methods extended from the original
   * HashtableMap class in order to ensure they work as before
   * 
   * @return true if all tests pass without unexpected errors, false otherwise
   */
  public static boolean test5() {
    try {
      HashTableSortedSets<String, String> newTable = new HashTableSortedSets<String, String>();
      LinkedList<String> testList = new LinkedList<String>();
      newTable.add("testKey", "testValue1");
      newTable.add("testKey", "testValue2");
      testList.add("testValue1");
      testList.add("testValue2");
      if (newTable.size() != 1 || !newTable.containsKey("testKey")
          || !newTable.get("testKey").equals(testList)) {
        return false;
      }
      List<String> removedList = newTable.remove("testKey");
      if (newTable.size() != 0 || newTable.containsKey("testKey")) {
        return false;
      }
      if (!removedList.contains("testValue1") || !removedList.contains("testValue2")) {
        return false;
      }
      newTable.put("testKey", removedList);
      if (newTable.size() != 1 || !newTable.containsKey("testKey")
          || !newTable.get("testKey").equals(testList)) {
        return false;
      }
      newTable.clear();
      if (newTable.size() != 0 || newTable.containsKey("testKey")) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

	// Extra tests added by the FrontendDeveloper
	public static boolean test6() {
		HashTableSortedSets<String, Integer> table = new HashTableSortedSets<String, Integer>();
		LinkedList<Integer> ls1 = new LinkedList<Integer>();
		LinkedList<Integer> ls2 = new LinkedList<Integer>();
		LinkedList<Integer> ls3 = new LinkedList<Integer>();

		ls1.add(5);
		ls2.add(7);
		ls3.add(-3); ls3.add(1);

		table.add("a",5);
		table.add("b",7);
		if(table.size() != 2 || !table.get("a").equals(ls1)) return false;
		table.add("a",2);
		table.add("c",1);
		table.add("c",-3);
		table.remove("a");

		if(table.size() != 2 || !table.get("b").equals(ls2) || !table.get("c").equals(ls3)) return false;

		try {
			table.get("a");
			return false;
		} catch (Exception e) {}

		return true;
	}

	public static boolean test7() {
		HashTableSortedSets<String, Integer> table = new HashTableSortedSets<String, Integer>();
		LinkedList<Integer> ls1 = new LinkedList<Integer>();
		LinkedList<Integer> ls2 = new LinkedList<Integer>();
		LinkedList<Integer> ls3 = new LinkedList<Integer>();

		ls1.add(1); ls1.add(7);
		ls2.add(-2); ls2.add(3); ls2.add(5);
		ls3.add(0);

		table.add("a",7);
		table.add("a",1);
		table.add("b",5);
		table.add("b",-2);
		table.add("b",3);
		table.add("c",0);

		if(table.size() != 3 || !table.get("a").equals(ls1) || !table.get("b").equals(ls2) || !table.get("c").equals(ls3)) return false;
		table.remove("a");
		if(table.size() != 2 || !table.get("b").equals(ls2) || !table.get("c").equals(ls3)) return false;
		table.clear();
		if(table.size() != 0) return false;
		table.add("a",1);
		table.add("a",7);
		if(table.size() != 1 || !table.get("a").equals(ls1) || table.containsKey("b") || table.containsKey("c")) return false;

		return true;
	}
  /**
   * Runs all the above tests at once
   * 
   * @return true if all tests pass without unexpected errors, false otherwise
   */
  public static boolean runAllTests() {
    return test1() && test2() && test3() && test4() && test5() && test6() && test7();
  }

  /**
   * Main method, calls the above method to run all tests and prints the output
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }

}
