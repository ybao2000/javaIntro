public class DoWhileTest {
  public static void main(String[] args) {
    int a = 1000;
    int sum = 0;
    do {
      sum += a;
      a++;
    } while(a<=100);
    System.out.println(sum);
  }
}
