import java.util.*;

class Tuple implements Comparable<Tuple> {
  int year;
  int type;
  public Tuple(int year, int type){
    this.year = year;
    this.type = type;
  }
  @Override
  public int compareTo(Tuple o) {
    if (this.year != o.year){
      return this.year - o.year;
    }
    else{
      return this.type - o.type;
    }
  }
}

public class TupleTest {
  public static void main(String[] args) {
    ArrayList<Tuple> years = new ArrayList<Tuple>();
    years.add(new Tuple(3, 1));
    years.add(new Tuple(3, -1));
    years.add(new Tuple(5, 1));
    years.add(new Tuple(5, -1));
    years.add(new Tuple(1, 1));
    years.add(new Tuple(1, -1));
    Collections.sort(years);
    for(var tp : years){
      System.out.println("Year: " + tp.year + ", type: " + tp.type);
    }
  }
}
