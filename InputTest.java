import java.util.Scanner;

public class InputTest {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int B = input.nextInt();
    int P = 5 * B - 400;
    System.out.println(P);
    int a = 0;
    if (P < 100){
      a = 1;
    } 
    else if (P > 100){
      a = -1;
    }
    System.out.println(a);
  }
}
