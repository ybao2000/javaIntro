public class StringTest2 {
  public static void main(String[] args) {
    char[] cs = {'a', 'b', 'c', 'd', 'e', 'f'};
    String str = String.valueOf(cs);
    System.out.println(str);
    String str2 = new String(cs);
    System.out.println(str2);
    char[] cs2 = str2.toCharArray();
    cs2[0] ='z';
    for(int i=0; i<cs2.length; i++){
      System.out.print(cs2[i] + "\t");
    }

    String sss = "I am a happy little bread";
    // let's check how long is sss
    System.out.println(sss.length());
    // what is the character at index 10?
    System.out.println(sss.charAt(10));
    // get a sub string starting from 10
    String sss_sub = sss.substring(10, 14);
    System.out.println(sss_sub);
  }
}
