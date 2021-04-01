import java.util.Scanner;

public class CCC21S1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    // how to convert the string into int????
    int N = Integer.parseInt(input.nextLine());
    String[] temp1 = input.nextLine().split(" ");
    String[] temp2 = input.nextLine().split(" ");
    int[] h = new int[N+1];
    int[] w = new int[N];
    for (int i=0; i<=N; i++){
      h[i] = Integer.parseInt(temp1[i]);
    }
    for (int i=0; i<N; i++){
      w[i] = Integer.parseInt((temp2[i]));
    }
    double area = 0;
    for (int i=0; i<N; i++){
      area += (h[i]+h[i+1]) * w[i] / 2.0;
    }
    System.out.println(area);
    input.close();
  }
}
