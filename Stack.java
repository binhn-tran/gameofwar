package edu.ics211.h07;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Represents a Stack.
 * Received help from ATA James Lau and Elis Diep.
 * @author binhtran
 * @param <E> the type.
 */
public class Stack<E> implements IStack211<E> {
  // creates a private member variable
  private ArrayList<E> data;
  
  /**
   * Constructor.
   * Creates a stack.
   */
  public Stack() {
    // creates an array
    data = new ArrayList<>();
  }


  @Override
  public boolean empty() {
    // check if the stack is empty
    if (data.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }


  @Override
  public E push(E item) {
    // adds to the stack
    data.add(item);
    // returns the item
    return item;
  }


  @Override
  public E peek() {
    // check if empty
    // if empty throw NoSuchElementException
    if (data.isEmpty()) {
      throw new NoSuchElementException();
    } else {
      return data.get(data.size() - 1);
    }
  }


  @Override
  public E pop() {
    // check if it's empty
    // if it's empty throw a NoSuchElementException
    if (data.isEmpty()) {
      throw new NoSuchElementException();
    } else {
      // remember the removed data
      E removedData = data.get(data.size() - 1);
      // removes the data
      data.remove(data.size() - 1);
      // returns the removed data
      return removedData;
    }
  }
}
