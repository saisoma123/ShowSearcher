// --== CS400 Project One File Header ==--
// Name: Andrew Schaumberger
// CSL Username: schaumberger
// Email: aschaumberge@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: n/a

/**
 * Helper class which simply contains a key and a value for easier use in a HashtableMap
 * implementation
 *
 * @param <KeyType>   the generic data type for the keys used in a HashtableMap
 * @param <ValueType> the generic data type for the values used in a HashtableMap
 */
public class KeyValuePair<KeyType, ValueType> {

  private KeyType key;
  private ValueType value;

  /**
   * Parameterized constructor, creates a key-value pair with the given key and value
   * 
   * @param key the given key to be used in this key-value pair
   * @param value the given value to be used in this key-value pair
   */
  protected KeyValuePair(KeyType key, ValueType value) {
    this.key = key;
    this.value = value;
  }

  /**
   * Gets the key in this key-value pair
   * 
   * @return the key in this key-value pair
   */
  protected KeyType getKey() {
    return key;
  }

  /**
   * Gets the value in this key-value pair
   * 
   * @return the value in this key-value pair
   */
  protected ValueType getValue() {
    return value;
  }
}
