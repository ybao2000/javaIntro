import random
from enum import Enum

class Suit(Enum):
    Spade=4
    Heart=3
    Diamond=2
    Club=1

class Rank(Enum):
    RoyalFlush = 10
    StraightFlush = 9
    FourOfAKind = 8
    FullHouse = 7
    Flush = 6
    Straight = 5
    ThreeOfAKind = 4
    TwoPairs = 3
    OnePair = 2
    HighHand = 1

class Card:
    def __init__(self, suit: Suit, number: int):
        self.suit = suit
        self.number = number

    @property
    def strSuit(self):
        if self.suit == Suit.Spade.value:
            return '\u2660'
        elif self.suit == Suit.Heart.value:
            return '\u2661'
        elif self.suit == Suit.Diamond.value:
            return '\u2662'
        else:
            return '\u2663'
    @property
    def strNumber(self):
        if self.number == 14:
            return 'A'
        elif self.number == 13:
            return 'K'
        elif self.number == 12:
            return 'Q'
        elif self.number == 11:
            return 'J'
        else:
            return str(self.number)
    def toString(self):
        return "{0} {1:2}".format(self.strSuit, self.strNumber)

class Hand:
    def __init__(self, player, cards):
        self.player = player
        self.cards = cards
    
    @property
    def strCards(self):
        listStr = []
        for card in self.cards:
            listStr.append(card.toString())
        return ' '.join(listStr)
    
    def makeGroups(self):
      nums = {}
      for card in self.cards:
          if card.number in nums:
              nums[card.number] += 1
          else:
              nums[card.number] = 1
      self.groups = sorted(nums.items(), key=lambda x: (x[1], x[0]), reverse=True)

    @property
    def isRoyalFlush(self):
        return self.isStraightFlush and self.cards[0].number == 14

    @property
    def isStraightFlush(self):
        return self.isStraigh and self.isFlush
    
    @property
    def isFourOfAKind(self):
        return self.groups[0][1] == 4

    @property
    def isFullHouse(self):
        return self.groups[0][1] == 3 and self.groups[1][1] == 2

    @property
    def isFlush(self):
        suit = self.cards[0].suit
        for card in self.cards:
            if card.suit != suit:
                return False
        return True

    @property 
    def isStraigh(self):
        num = self.cards[0].number + 1
        for card in self.cards:
            if card.number != num -1:
                return False
            else:
                num -= 1
        return True

    @property
    def isThreeOfAKind(self):
        return self.groups[0][1] == 3

    @property
    def isTwoPairs(self):
      return self.groups[0][1] == 2 and self.groups[1][1] == 2

    @property 
    def isOnePair(self):
        return self.groups[0][1] == 2

    def setRank(self):
      self.makeGroups()
      if self.isRoyalFlush:
          self.rank = Rank.RoyalFlush
      elif self.isStraightFlush:
          self.rank = Rank.StraightFlush
      elif self.isFourOfAKind:
          self.rank = Rank.FourOfAKind
      elif self.isFullHouse:
          self.rank = Rank.FullHouse
      elif self.isFlush:
          self.rank = Rank.Flush
      elif self.isStraigh:
          self.rank = Rank.Straight
      elif self.isThreeOfAKind:
          self.rank = Rank.ThreeOfAKind
      elif self.isTwoPairs:
          self.rank = Rank.TwoPairs
      elif self.isOnePair:
          self.rank = Rank.OnePair
      else:
          self.rank = Rank.HighHand

    @property
    def strRank(self):
        rank = str(self.rank)
        return rank[5:]

    def show(self):
        print("{0:10}: {1}, {2}".format(self.player, self.strCards, self.strRank))

def compareGroups(groups1, groups2):
  len1 = len(groups1)
  len2 = len(groups2)
  if len1 != len2:
    return len1 < len2
  else:
    for i in range(len1):
      if groups1[i] > groups2[i]:
        return True
      elif groups1[i] < groups2[i]:
        return False
  return True

def compareHand(hand1, hand2):
    if hand1.rank.value > hand2.rank.value:
        return True
    elif hand1.rank.value < hand2.rank.value:
        return False
    else:
        return compareGroups(hand1.groups, hand2.groups)

def generateCards():
    cards = []
    for i in range(5):
        num1 = random.randint(1, 4)
        num2 = random.randint(2, 14)
        card = Card(num1, num2)
        cards.append(card)
    cards.sort(key=lambda  x: x.number, reverse=True)
    return cards

hands = []
for i in range(4):
    hand = Hand('Player {0}'.format(i+1), generateCards())
    hand.setRank()
    hand.show()
    hands.append(hand)

c01 = compareHand(hands[0], hands[1])
c02 = compareHand(hands[0], hands[2])
c03 = compareHand(hands[0], hands[3])
c12 = compareHand(hands[1], hands[2])
c13 = compareHand(hands[1], hands[3])
c23 = compareHand(hands[2], hands[3])

if c01 and c02 and c03:
    print("{0} wins!".format(hands[0].player))
elif (not c01) and c12 and c13:
    print("{0} wins!".format(hands[1].player))
elif (not c02) and (not c12) and c23:
    print("{0} wins!".format(hands[2].player))
else:
    print("{0} wins!".format(hands[3].player))    