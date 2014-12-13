CECS274-Homework-3
==================
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Hmk3
{
  // instance variables
  protected ArrayList<Integer> aList;
  protected int SIZE;
  protected Scanner input = new Scanner(System.in);
  protected Random rng = new Random();
  
  // Set the size of the list
  public void setSize()
  {
    System.out.println("How large would you like your array to be?");
    SIZE = input.nextInt();
    aList = new ArrayList<Integer>(SIZE);
    aList = setList(aList);
    for (int element : aList)
    {
      System.out.print(element + "  ");
    }
    System.out.println();
    int foundIndex = elementFinder(aList);
    if (foundIndex == -1)
    {
     System.out.println("This list does not contain that element."); 
    } else
    {
      System.out.println("This element is located at index: " + foundIndex);
    }
  }
  
  // Find the index of the search element
  public int elementFinder(ArrayList<Integer> list)
  {
    System.out.println("Which element would you like to search for?");
    int element = input.nextInt();
    return list.indexOf(element);
  }
  
  // Put values into list
  public ArrayList<Integer> setList(ArrayList<Integer> list)
  {
    System.out.println("Set the boundaries of your array. The program will generate an array of random numbers for you.");
    boolean isAcceptable;
    int maxValue;
    int minValue;
    
    do
    {
    System.out.println("What is your minimum value?");
    minValue = input.nextInt();
    System.out.println("What is your maximum value?");
    maxValue = input.nextInt();
    
    if ((maxValue-minValue+1) < SIZE)
    {
      System.out.println("Unacceptable boundaries. Please input again.");
      isAcceptable = false;
    } else
    {
      isAcceptable = true;
    }
    } while (!isAcceptable);

    int element; // element holds the RNG value
    boolean isDuplicate = false; // Used to prevent duplicate numbers
    ArrayList<Integer> usedNumberStorage = new ArrayList<Integer>(); // List to hold previous, unique values of the RNG to prevent duplicates
    
    // Loop that adds values to the list
    for (int counter = 0; counter < SIZE; counter++)
    {
      element = rng.nextInt(maxValue) + minValue; // RNG rolls a number from minValue-maxValue
      // duplicate check does not need to run for the first iteration
      if (counter != 0)
      {
        // This block is to prevent duplicate numbers from showing up
        do
        {
          // if a previous element is a duplicate
          // re-roll element
          if (isDuplicate)
          {
            element = rng.nextInt(maxValue) + minValue;
          }
          // compares RNG value to all values in the number storage
          for (int count = 0; count < usedNumberStorage.size(); count++)
          {
            // Once a duplicate is found
            // flip isDuplicate to true
            // and break out of the for-loop
            if (element == usedNumberStorage.get(count))
            {
              isDuplicate = true;
              break;
            } else
            {
              // if no duplicate is found, exit the do-while
              isDuplicate = false;
            }
          }
        } while (isDuplicate); // as long as the RNG value roll matches a previous roll, run the check
      }
      list.add(element); // Adds the RNG value to the list
      usedNumberStorage.add(element); // Collects previous unique values of the RNG
    }
    return list;
  }
}
