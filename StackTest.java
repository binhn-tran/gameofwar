package edu.ics211.h07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

  @BeforeEach
  void setUp() throws Exception {
  }


  @Test
  void testStack() {
    // creates a stack
    Stack<String> stacks = new Stack<>();
    stacks.push("one");
    stacks.push("two");
    stacks.push("three");
    stacks.push("four");
    stacks.push("five");
    // testing good and bad values
    assertEquals("five", stacks.pop());
    assertFalse("wrong string", "one" == stacks.peek());
    assertEquals("four", stacks.pop());
    assertFalse("wrong string", "one" == stacks.peek());
    assertEquals("three", stacks.pop());
    assertFalse("wrong string", "one" == stacks.peek());
    assertEquals("two", stacks.pop());
    assertEquals("one", stacks.pop());
    
    
  }


  @Test
  void testEmpty() {
    // creates a stack
    Stack<String> stacks = new Stack<>();
    assertTrue(stacks.empty());
    // creates a second stack
    Stack<String> stacksTwo = new Stack<>();
    // adding to a stack
    stacksTwo.push("one");
    stacksTwo.push("one");
    assertFalse("stack is not empty",stacksTwo.empty() == true);
  }


  @Test
  void testPush() {
    // creates a stack
    Stack<String> stacks = new Stack<>();
    // adding to a stack
    stacks.push("one");
    // testing good values
    assertEquals("one",stacks.peek());
    // testing bad values
    assertFalse("wrong push value", stacks.peek() == "two");
    // adding to another stack
    stacks.push("two");
    assertTrue("did not push",stacks.peek() == "two");
  }


  @Test
  void testPeek() {
    // creates a stack
    Stack<String> stacks = new Stack<>();
    // adding to a stack
    stacks.push("one");
    stacks.push("two");
    stacks.push("three");
    stacks.push("four");
    stacks.push("five");
    // testing bad and good values
    assertEquals("five", stacks.peek());
    assertFalse("peeked the wrong value", stacks.peek() == "three");
  }


  @Test
  void testPop() {
    // creates a stack
    Stack<String> stacks = new Stack<>();
    stacks.push("one");
    stacks.push("two");
    stacks.push("three");
    stacks.push("four");
    stacks.push("five");
    // testing good values
    assertEquals("five",stacks.pop());
    // testing bad values
    assertFalse("should be four", "five" == stacks.pop());
    assertTrue("did not return three","three" == stacks.pop());
    // removing the value
    stacks.pop();
    assertEquals("one", stacks.peek());
  }

}
