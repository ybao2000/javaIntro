public class StringConcate {
  public static void main(String[] args) {
    // String s1 = "blah blah blah";
    // String s2 = "is silly";
    // String s3 = s1 + s2;
    // s1.concat(s2);
    // System.out.println(s3);
    // System.out.println(s1);
    String[] ss = {"Apple", "Banana", "Cherry", "Pear", "Peach", "Orange", "Grape"};
    String s = "";
    for(int i=0; i<ss.length; i++){
      s += ss[i];   // this is not good, why?
    }
    System.out.println(s);
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<ss.length; i++){
      sb.append(ss[i]);
    }
    System.out.println(sb.toString());  // this is better

  }
}
