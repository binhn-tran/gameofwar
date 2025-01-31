package edu.ics211.h07;

/**
 * Represents GameOfWar.
 * Received help from ATA James Lau, Elis Diep, and Iwalani C.
 * @author binhtran
 *
 */
public class GameOfWar implements IGameOfWar {
  // create member variables
  private Stack<Card> player1;
  private Stack<Card> player2;
  private Stack<Card> stackPile;
  int stackSize = 0;
  boolean play = false;
  private Stack<Card> combine1;
  private Stack<Card> combine2;
  private Stack<Card> stack;
  
  
  /**
   * Constructor.
   * Creates a GameOfWar.
   */
  public GameOfWar() {
    // initializing both player 1 and player 2
    player1 = new Stack<Card>();
    player2 = new Stack<Card>();
    // stack of cards for war
    stackPile = new Stack<Card>();
  }


  @Override
  public void initializeGame(Deck d) {
    // loop until the deck's size is 0 
    while (d.size() > 0) {
      // deal a single card to both player 1 and player 2
      player1.push(d.dealACard());
      player2.push(d.dealACard());
    }
  }


  @Override
  public boolean playARound() {
    // initialize player1Card and player2Card to pop
    Card player1Card = player1.pop();
    Card player2Card = player2.pop();
    // compares both player one's card and player two's card against each other
    if (player1Card.getRank().compareTo(player2Card.getRank()) < 0) {
      // push the card into the stack pile
      stackPile.push(player2Card);
      stackPile.push(player1Card);
      // push the stack pile from war to p2 winner stack pile
      for (int i = 0; i < stackSize; i++) {
        player2.push(stackPile.pop());
      }
      // combine player two's pile
      player2 = combineStacks(player2, stackPile);
      stackSize = 0;
      // both of the players hands are empty
      if (player1.empty() == true || player2.empty() == true) {
        return true;
      }
      return false;
      // compares both player one's card and player two's card against each other
    } else if (player1Card.getRank().compareTo(player2Card.getRank()) > 0) {
      // when it's war push the card into the pile
      stackPile.push(player2Card);
      stackPile.push(player1Card);
      // push the pile from war to the winner's pile
      for (int j = 0; j < stackSize; j++) {
        player1.push(stackPile.pop());
      }
      // combine player one's stack
      player1 = combineStacks(player1, stackPile);
      stackSize = 0;
      // both player one and player two start off empty
      if (player1.empty() == true || player2.empty() == true) {
        return true;
      }
      return false;
    } else {
      // stack the cards into the stack
      stackPile.push(player1Card);
      stackPile.push(player2Card);
      // adds one card to each player
      stackPile.push(player1.pop());
      stackPile.push(player2.pop());
      // adding to the pile 
      stackSize = stackSize + 4;
      playARound();
      return true;
    }
  }

  @Override
  public Stack<Card> playerOnesCards() {
    // return player one's stack of cards
    return player1;
  }


  @Override
  public Stack<Card> playerTwosCards() {
    // return player two's stack of cards
    return player2;
  }


  @Override
  public Stack<Card> combineStacks(Stack<Card> top, Stack<Card> bottom) {
    // initializing combine1, combine2, and stack
    combine1 = new Stack<Card>();
    combine2 = new Stack<Card>();
    stack = new Stack<Card>();
    // adding to the top of the stack
    while (top.empty() != true) {
      combine1.push(top.pop());
      combine2.push(combine1.pop());
    }
    // adding to the bottom of the stack
    while (bottom.empty() != true) {
      combine2.push(bottom.pop());
    }
    // reverse the stacks combinations
    while (combine2.empty() != true) {
      stack.push(combine2.pop());
    }
    // return the stack
    return stack;
  }

}
