
public class ArrayTest {
  public static void main(String[] args) {
    // int size = args.length;
    // for (int i=0; i<size; i++){
    //   System.out.println(args[i]);
    // }
    // int size = 10;
    // int[] numbers = new int[size];
    // System.out.println(numbers[0]);

    // for (int i=0; i<size; i++){
    //   numbers[i] = i*i;
    // }

    // for (int i=0; i<size; i++){
    //   System.out.println(numbers[i]);
    // }

    String[] fruits = {"Apple", "Banana", "Cherry", "Durian", "Pear", "Orange"};
    fruits[0] = "Peach";

    for (var fruit : fruits) {
      System.out.println(fruit);
    }
  }
}
