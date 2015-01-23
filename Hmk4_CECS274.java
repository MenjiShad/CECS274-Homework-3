import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Hmk4_CECS274
{ 
  protected static linkedList lList = new linkedList();
  protected int SIZE;
  protected Random rng = new Random();
  protected static Scanner userIn = new Scanner(System.in);
  
  // User inputs size of the list
  public void setLinkedListSize()
  {
    System.out.println("How large would you like your array to be?");
    SIZE = userIn.nextInt();
    lList = new linkedList();
    lList = setLinkedList(lList);
    lList.display();
  }
  
  // Fills the list with random numbers
  public linkedList setLinkedList(linkedList list)
  {
   System.out.println("Set the boundaries of your array. The program will generate an array of random numbers for you.");
    boolean isAcceptable;
    int maxValue;
    int minValue;
    
    // User inputs the boundaries
    do
    {
    System.out.println("What is your minimum value?");
    minValue = userIn.nextInt();
    System.out.println("What is your maximum value?");
    maxValue = userIn.nextInt();
    
    if ((maxValue-minValue+1) < SIZE)
    {
      System.out.println("Unacceptable boundaries. Please userIn again.");
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
      list.insertAtStart(element); // Adds the RNG value to the list
      usedNumberStorage.add(element); // Collects previous unique values of the RNG
    }
    return list;
  }
  
  // Finds the element
  public static void elementFinder()
  {
    System.out.println("What integer would you like to search for?");
    Object searchObj = userIn.nextInt();
    if (contains(lList.start,searchObj))
    {
      System.out.println("Your element has been found. (with recursion)");
    } else
    {
      System.out.println("Your element was not found. (with recursion)");
    }
    lList.display();
    if (Contains(searchObj))
    {
      System.out.println("Your element has been found. (with direct links)");
    } else
    {
      System.out.println("Your element was not found. (with direct links)");
    }
    lList.display();
  }
  
  // recursive function to see if an element exists in the list
  private static Boolean contains(Node start, Object obj)
  {
    // false if list is empty
    if (lList.isEmpty())
    {
      System.out.println("Your list is empty.");
      return false;
    }
    // if the object is found
    if (obj.equals(start.getData()))
    {
      return true;
    }
    // recursive call
    // As long as the next Node is not null
    if (start.getLink() != null)
    {
      return contains(start.getLink(), obj);
    } else
    {
      return false; // otherwise, it is false
    }
   }
  
  // directly traverses links
  public static boolean Contains(Object obj)
  {
    boolean doesContain = false;
    // if list is empty, return false
    if (lList.isEmpty())
    {
      System.out.println("Your list is empty.");
      return doesContain;
    } else
    {
      // as long as the next node has a value
      // run the loop
      while (lList.start.getLink() != null)
      {
        // if the element is found, return true
        if (obj.equals(lList.start.getData()))
        {
          doesContain = true;
          break;
        } else // otherwise, move on to the next link
        {
          lList.start = lList.start.getLink();
          doesContain = false;
        }
      }
      return doesContain;
    }
  }
  
  public void info()
  {
    System.out.println("Name: James Dinh");
    System.out.println("Student ID: 011599417");
  }
}
