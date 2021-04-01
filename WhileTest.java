public class WhileTest {
  public static void main(String[] args) {
    int a = 1000;
    int sum = 0;
    while (a <= 100){ // we are going to add from 1 to 100
      sum += a;
      a++;
    }
    System.out.println(sum);
  }
}
