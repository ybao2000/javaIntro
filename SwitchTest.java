public class SwitchTest {
  enum Suit {
    Spade,
    Heart,
    Diamond,
    Club
  };

  public static void main(String[] args) {
    Suit suit = Suit.Heart; // we assuem 1: Spade, 2: Heart, 3: Diamond, 4: Club
    switch(suit){
      case Spade:
        System.out.println("Spade \u2660");
        break;
      case Heart:
        System.out.println("Heart \u2661");
        break; 
      case Diamond :
        System.out.println("Diamond \u2662");
        break;   
      case Club:
        System.out.println("Club \u2663");
        break;
      // default:
      //   System.out.println("Don't fool me!");
    }  
  }
}
