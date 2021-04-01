public class StringComparisonTest {
  public static void main(String[] args) {
    String str1 = new String("abc");
    String str2 = "abc";
    System.out.println(str1==str2);
    System.out.println(str1.equals(str2));
    System.out.println(str1);
    System.out.println(str2);

    String a1 = "apple";
    String a2 = "appie";
    int iResult = a1.compareTo(a2);
    System.out.println(iResult);

    String a3 = a2.replace('p', 's');
    System.out.println(a3);
  }
}
