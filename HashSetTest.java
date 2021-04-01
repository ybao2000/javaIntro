import java.util.*;

public class HashSetTest {
  public static void main(String[] args) {
    Set<String> set = new TreeSet<String>();

    // add
    set.add("cat");
    set.add("dog");
    set.add("bear");

    set.add("bear");  // this won't do anything

    // iteration
    for(var animal : set){
      System.out.println(animal);
    }


  }
}
