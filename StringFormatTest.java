public class StringFormatTest {
  public static void main(String[] args) {
    String name = "Bobbie";
    int age = 8;

    // I want ot print out "My name is ???, and I am ??? year's old";
    System.out.printf("My name is %s, and I am %2d year's old", name, age);

    String text = String.format("My name is %s, and I am %2d year's old", name, age);
    System.out.println(text);
  }
}
