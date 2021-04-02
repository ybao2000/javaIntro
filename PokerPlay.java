import java.util.*;

enum Suit {
  Spade(4),
  Heart(3),
  Diamond(2),
  Club(1);

  int numVal;
  Suit(int num){
    numVal = num;
  }
}

enum Rank {
  RoyalFlush(10),
  StraightFlush(9),
  FourOfAKind(8),
  FullHouse(7),
  Flush(6),
  Straight(5),
  ThreeOfAKind(4),
  TwoPairs(3),
  OnePair(2),
  HighHand(1);

  int numVal;
  Rank(int num){
    numVal = num;
  }
}

class Card implements Comparable<Card> {
  Suit suit;
  Integer number;
  Card (int type, int number){
    switch(type){
      case 4:
        suit = Suit.Spade;
        break;
      case 3:
        suit = Suit.Heart;
        break;
      case 2:
        suit = Suit.Diamond;
        break;
      default:
        suit = Suit.Club;
        break;
    }
    this.number = number;
  }
  String strSuit() {
    switch(suit) {
      case Spade:
        return "\u2660";
      case Heart:
        return "\u2660";
      case Diamond:
        return "\u2660";
      default:
        return "\u2660";      
    }
  }
  String strNumber() {
    if (number == 14){
      return " A";
    }
    else if (number == 13)
    {
      return " K";
    }
    else if (number == 12)
    {
      return " Q";
    }
    else if (number == 11)
    {
      return " J";
    }
    else {
      return String.format("%2d", number);
    }
  }

  public String toString() {
    return strSuit() + strNumber();
  }
  @Override
  public int compareTo(Card o) {
    return o.number - this.number;
  }
}

class Pair implements Comparable<Pair> {
  Integer number;
  Integer count;
  Pair(int number, int count){
    this.number = number;
    this.count = count;
  }
  @Override
  public int compareTo(Pair o) {
    if (this.count != o.count){
      return o.count - this.count;  // reverse
    }
    else{
      return o.number - this.number;
    }
  }
}

class Hand {
  String player;
  ArrayList<Card> cards;
  ArrayList<Pair> groups;
  Rank rank;
  Hand(String player, ArrayList<Card> cards){
    this.player = player;
    this.cards = cards;
  }

  String strCards(){
    ArrayList<String> listStr = new ArrayList<String>();
    for (var card : cards) {
      listStr.add(card.toString());
    }
    return String.join(" ", listStr);
  }

  void makeGroups(){
    HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();
    for(var card : cards){
      if(nums.containsKey(card.number)) {
        nums.put(card.number, nums.get(card.number)+1);
      }
      else{
        nums.put(card.number, 1);
      }
    }
    groups = new ArrayList<Pair>();
    for(Integer number: nums.keySet()){
      groups.add(new Pair(number, nums.get(number)));
    }
    Collections.sort(groups);
  }

  boolean isRoyalFlush(){
    return isStraightFlush() && cards.get(0).number == 14;
  }

  boolean isStraightFlush() {
    return isStraight() && isFlush();
  }

  boolean isFourOfAKind(){
    return groups.get(0).count == 4;
  }

  boolean isFullHouse(){
    return groups.get(0).count == 3 && groups.get(1).count == 2;
  }

  boolean isFlush() {
    Suit suit = cards.get(0).suit;
    for (Card card: cards){
      if (card.suit != suit){
        return false;
      }
    }
    return true;
  }

  boolean isStraight() {
    Integer num = cards.get(0).number + 1;
    for (Card card : cards){
      if (card.number != num-1){
        return false;
      }
      else{
        num--;
      }
    }
    return true;
  }

  boolean isThreeOfAKind(){
    return groups.get(0).count == 3;
  }

  boolean isTwoPairs(){
    return groups.get(0).count == 2 && groups.get(1).count == 2;
  }

  boolean isOnePair() {
    return groups.get(0).count == 2;
  }

  void setRank(){
    makeGroups();
    if(isRoyalFlush()){
      rank = Rank.RoyalFlush;
    }
    else if(isStraightFlush()){
      rank = Rank.StraightFlush;
    }
    else if(isFourOfAKind()){
      rank = Rank.FourOfAKind;
    }
    else if(isFullHouse()){
      rank = Rank.FullHouse;
    }
    else if(isFlush()){
      rank = Rank.Flush;
    }
    else if(isStraight()){
      rank = Rank.Straight;
    }
    else if(isThreeOfAKind()){
      rank = Rank.ThreeOfAKind;
    }
    else if(isTwoPairs()){
      rank = Rank.TwoPairs;
    }
    else if(isOnePair()){
      rank = Rank.OnePair;
    }
    else{
      rank = Rank.HighHand;
    }
  }

  String strRank(){
    return rank.toString();
  }

  void show(){
    System.out.println(String.format("%-10s: %s, %s", player, strCards(), strRank()));
  }
}

public class PokerPlay {
  public static void main(String[] args) {
    ArrayList<Hand> hands = new ArrayList<Hand>();
    for (int i=0; i<4; i++){
      Hand hand = new Hand(String.format("Player %d", i+1), generateCards());
      hand.setRank();
      hand.show();
      hands.add(hand);
    }
    boolean c01 = compareHand(hands.get(0), hands.get(1));
    boolean c02 = compareHand(hands.get(0), hands.get(2));
    boolean c03 = compareHand(hands.get(0), hands.get(3));
    boolean c12 = compareHand(hands.get(1), hands.get(2));
    boolean c13 = compareHand(hands.get(1), hands.get(3));
    boolean c23 = compareHand(hands.get(2), hands.get(3));

    if(c01 && c02 && c03){
      System.out.println(String.format("%s win!", hands.get(0).player));
    }
    else if(!c01 && c12 && c13){
      System.out.println(String.format("%s win!", hands.get(1).player));
    }
    else if(!c02 && !c12 && c23){
      System.out.println(String.format("%s win!", hands.get(2).player));
    }
    else {
      System.out.println(String.format("%s win!", hands.get(3).player));
    }
  }

  public static ArrayList<Card> generateCards(){
    Random rand = new Random();
    ArrayList<Card> cards = new ArrayList<Card>();
    for(int i=0; i<5; i++){
      int type = rand.nextInt(4)+1;   // this is to generate random # between 1 and 4
      int number = rand.nextInt(13) + 2;  // this is to generate random # between 2 and 14
      Card card = new Card(type, number);
      cards.add(card);
    }
    Collections.sort(cards);
    return cards;
  }

  public static boolean compareGroups(ArrayList<Pair> groups1, ArrayList<Pair> groups2){
    int len1 = groups1.size();
    int len2 = groups2.size();
    if (len1 != len2) {
      return len1 < len2;
    }
    else {
      for(int i=0; i<len1; i++){
        if(groups1.get(i).number > groups2.get(i).number){
          return true;
        }
        else if(groups1.get(i).number < groups2.get(i).number){
          return false;
        }
      }
    }
    return true;
  }

  public static boolean compareHand(Hand hand1, Hand hand2){
    if(hand1.rank.numVal > hand2.rank.numVal){
      return true;
    }
    else if(hand1.rank.numVal < hand2.rank.numVal){
      return false;
    }
    else {  // what if same rank
      return compareGroups(hand1.groups, hand2.groups);
    }
  }
}
