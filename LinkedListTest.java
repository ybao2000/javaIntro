import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
  public static void main(String[] args) {
    List<Integer> numbers = new LinkedList<Integer>();
    // adding
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);
    System.out.println(numbers.get(0));

    for (int i=0; i<numbers.size(); i++){
      System.out.println(numbers.get(i));
    }

    numbers.remove(1);
    System.out.println("------------------");
    // for (int i=0; i<numbers.size(); i++){
    //   System.out.println(numbers.get(i));
    // }
    for (var elem : numbers){
      System.out.println(elem);
    }

    // you should use LinkedList for Queue!!!
  }
}
