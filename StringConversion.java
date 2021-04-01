public class StringConversion {
  public static void main(String[] args) {
    // double d = 3.14;
    // Double D = 3.14;
    // System.out.print(D);
    // String str_d = D.toString();

    String strPi = "3.1415926";
    double pi = Double.parseDouble(strPi);
    String strE = "2.71828";
    double e = Double.parseDouble(strE);
    double sum = pi + e;
    System.out.println(pi);
    System.out.println(e);
    System.out.println(sum);
    String b_string = "sss";
    boolean b = Boolean.parseBoolean(b_string);
    if (b){
      System.out.println("This is true");
    }
    else{
      System.out.println("This is false");
    }
  }
}
