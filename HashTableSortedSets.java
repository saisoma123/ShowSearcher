// --== CS400 Project One File Header ==--
// Name: Andrew Schaumberger
// CSL Username: schaumberger
// Email: aschaumberge@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: n/a

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class extends the implementation of the HashtableMap class so that Lists can be stored as
 * values which can then have their contents added to using an add() method
 *
 * @param <KeyType>   the generic data type for the keys used in this hashtable
 * @param <ValueType> the generic data type for the values used in this hashtable
 */
public class HashTableSortedSets<KeyType, ValueType extends Comparable<ValueType>>
    extends HashtableMap<KeyType, List<ValueType>>
    implements IHashTableSortedSets<KeyType, ValueType>, MapADT<KeyType, List<ValueType>> {

  /**
   * Adds a non-null value to a keyed List in the Hashtable, creating a new List if there is none
   * already there
   * 
   * @param key   the key to reference when adding a new value to the List
   * @param value the new value to be put into the List in the Hashtable
   */
  @Override
  public void add(KeyType key, ValueType value) {
    if (value != null && key != null) {
      List<ValueType> valueList;
      try {
	  valueList = get(key);
      } catch (NoSuchElementException e) {
        valueList = new LinkedList<ValueType>();
      }
      valueList.add(value);
      Collections.sort(valueList);
      put(key, valueList);
    }
  }

}
