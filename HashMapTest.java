import java.util.*;

public class HashMapTest {
  public static void main(String[] args) {
    Map<Integer, String> map = new HashMap<Integer, String>();
    //  add key:value
    map.put(6, "apple");
    map.put(2, "banana");
    map.put(3, "cherry");
    map.put(2, "pear");

    // get value by key
    String fruit = map.get(4);
    System.out.println(fruit);

    // iterate the map
    for (var entry: map.entrySet()){
      var key = entry.getKey();
      var value = entry.getValue();
      System.out.println("Key: " + key + " value: " + value);
    }
  }
}
