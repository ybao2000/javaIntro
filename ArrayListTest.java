import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
  public static void main(String[] args) {
    // python list
    // in java, List is an interface, you need class to implement the interface
    // the first class is called ArrayList
    // ArrayList is a list, which is implemented as array (array means all elemetns are stored together)
    List<Integer> numbers = new ArrayList<Integer>(); // you don't know the size, leave ()
    // adding
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);

    // how to get it
    // C# can use index, Java has to get method
    System.out.println(numbers.get(0));

    // how to iterate
    for (int i=0; i<numbers.size(); i++){
      System.out.println(numbers.get(i));
    }

    //  how to remove
    numbers.remove(1);
    System.out.println("------------------");
    // for (int i=0; i<numbers.size(); i++){
    //   System.out.println(numbers.get(i));
    // }
    for (var elem : numbers){
      System.out.println(elem);
    }

    //IMPORTANT: ArrayList is an array, remove items at the end is ok
    // but remove items at the beginnin or middle is VERY VERY SLOW, 
    // so you need to avoid remove item in the beginner or middle
    // That means, ArrayList is fine with Stack, but very bad for Queue.
  }
}
