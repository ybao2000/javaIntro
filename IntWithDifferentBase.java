public class IntWithDifferentBase {
  public static void main(String[] args) {
    int a = 1024;
    String str_bin_a = Integer.toBinaryString(a);
    System.out.println(str_bin_a);

    long b = Long.parseLong(str_bin_a, 2);
    System.out.println(b);

    // hex
    int c = 255;
    String str_hex_c = Integer.toHexString(c);
    System.out.println(str_hex_c);

    int d = Integer.parseInt(str_hex_c, 16);
    System.out.println(d);
  }
}
