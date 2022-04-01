// --== CS400 Project One File Header ==--
// Name: Andrew Schaumberger
// CSL Username: schaumberger
// Email: aschaumberge@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: n/a

import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * This class creates a table of elements where keys and their associated values are put into place
 * using the hash of the keys
 *
 * @param <KeyType>   the generic data type for the keys used in this map
 * @param <ValueType> the generic data type for the values used in this map
 */
public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

  protected int capacity;
  protected int size;
  protected LinkedList<KeyValuePair>[] table;

  /**
   * Parameterized constructor, creates a new HashtableMap with a given capacity
   * 
   * @param capacity the amount of key-value pairs that the HashtableMap will be able to fit without
   *                 needing to expand
   */
  public HashtableMap(int capacity) {
    table = (LinkedList<KeyValuePair>[]) new LinkedList[capacity];
    this.capacity = capacity;
    this.size = 0;
  }

  /**
   * Unparameterized constructor, creates a new HashtableMap with a capacity of 20
   */
  public HashtableMap() {
    table = (LinkedList<KeyValuePair>[]) new LinkedList[20];
    this.capacity = 20;
    this.size = 0;
  }

  /**
   * Puts a new key-value pair into the HashtableMap given that the given key is not null and is not
   * already in the map, and calls the grow() method if the number of items in the map is at least
   * 75% of the total capacity
   * 
   * @param key   the new key to be put into the HashtableMap
   * @param value the new value to be put into the HashtableMap
   * @return true if the new key-value pair is successfully put into the HashtableMap, false
   *         otherwise (if the key to be added is null or already exists in the map)
   */
  @Override
  public boolean put(KeyType key, ValueType value) {
    if (key == null) {
      return false;
    }
    if (table[Math.abs(key.hashCode()) % capacity] == null) {
      table[Math.abs(key.hashCode()) % capacity] = new LinkedList<KeyValuePair>();
    }
    if (containsKey(key)) {
      return false;
    }
    table[Math.abs(key.hashCode()) % capacity].add(new KeyValuePair(key, value));
    size++;
    if (size() >= 0.75 * capacity) {
      grow();
    }
    return true;
  }

  /**
   * Private helper method, expands the hashtable when near capacity by creating a deepcopy of the
   * original table array, replacing the original with one that has double the capacity, and putting
   * all the elements in the table array back into the hashtable, rehashing them in the process
   */
  private void grow() {
    LinkedList<KeyValuePair>[] newTable = (LinkedList<KeyValuePair>[]) new LinkedList[capacity * 2];
    LinkedList<KeyValuePair>[] temp = (LinkedList<KeyValuePair>[]) new LinkedList[capacity];
    temp = table;
    table = newTable;
    size = 0;
    capacity *= 2;
    for (LinkedList<KeyValuePair> i : temp) {
      if (i != null) {
        for (KeyValuePair j : i) {
          put((KeyType) j.getKey(), (ValueType) j.getValue());
        }
      }
    }
  }

  /**
   * Gets the value associated with a given key in the HashtableMap, should the given key exist in
   * the map
   * 
   * @param key the key associated with a value to find
   * @return the value associated with the given key
   * @throws NoSuchElementException if the HashtableMap does not contain the given key
   */
  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    if (containsKey(key)) {
      for (KeyValuePair i : table[Math.abs(key.hashCode()) % capacity]) {
        if (i.getKey().equals(key)) {
          return (ValueType) i.getValue();
        }
      }
    }
    throw new NoSuchElementException();
  }

  /**
   * Gets the size of the HashtableMap
   * 
   * @return the size of the HashtableMap
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Checks to see if a given key exists in the HashtableMap
   * 
   * @param key the key to check if the HashtableMap contains
   * @return true if the HashtableMap contains the key, false otherwise
   */
  @Override
  public boolean containsKey(KeyType key) {
    if (key == null || table[Math.abs(key.hashCode()) % capacity] == null) {
      return false;
    }
    for (KeyValuePair i : table[Math.abs(key.hashCode()) % capacity]) {
      if (i.getKey().equals(key)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Removes a given key from the HashtableMap, should it be in the map already, and returns the
   * value associated with the key
   * 
   * @param key the key to be removed from the HashtableMap
   * @return the value associated with the key if the key exists in the map already, null otherwise
   */
  @Override
  public ValueType remove(KeyType key) {
    ValueType value = null;
    if (containsKey(key)) {
      for (KeyValuePair i : table[Math.abs(key.hashCode()) % capacity]) {
        if (i.getKey().equals(key)) {
          value = (ValueType) i.getValue();
          table[Math.abs(key.hashCode()) % capacity].remove(i);
          size--;
        }
      }
    }
    return value;
  }

  /**
   * Clears the HashtableMap of all contents
   */
  @Override
  public void clear() {
    for (LinkedList<KeyValuePair> i : table) {
      if (i != null) {
        i.clear();
      }
    }
    size = 0;
  }

}
