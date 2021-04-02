import java.util.*;

public class Codeforces1424G {
  static class Tuple implements Comparable<Tuple> {
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

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int n = Integer.parseInt(input.nextLine());
    ArrayList<Tuple> years = new ArrayList<Tuple>();
    for (int i=0; i<n; i++){
      String[] vals = input.nextLine().split(" ");
      years.add(new Tuple(Integer.parseInt(vals[0]), 1));
      years.add(new Tuple(Integer.parseInt(vals[1]), -1));
    }
    Collections.sort(years);
    int max_population =0;
    int max_year = 0;
    int population =0;
    for (var tp : years){
      if (tp.type == -1){
        population--;
      }
      else{
        population++;
        if(population > max_population){
          max_population = population;
          max_year = tp.year;
        }
      }
    }
    System.out.print(max_year + " " + max_population);
  }
}