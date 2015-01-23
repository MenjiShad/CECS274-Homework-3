public class linkedList
{
 protected Node start; 
 protected Node end;
 public int size;
 
 public linkedList()
 {
   start = null;
   end = null;
   size = 0;
 }
 
 public boolean isEmpty()
 {
   return start == null;
 }
 
 public int getSize()
 {
   return size;
 }
 
 public void insertAtStart(int value)
 {
   Node newPointer = new Node(value, null);
   size++;
   if (start == null)
   {
     start = newPointer;
     end = start;
   }
   else
   {
     newPointer.setLink(start);
     start = newPointer;
   }
 }
 
 public void display()
 {
   System.out.print("Current LinkedList: [pointer]--> " + " [");
   if (size == 0)
   {
     System.out.print("Empty\n");
     return;
   }
   if (start.getLink() == null)
   {
     System.out.println(start.getData());
     return;
   }
   Node pointer = start;
   System.out.print(start.getData() + "]--> [");
   pointer = start.getLink();
   while (pointer.getLink() != null)
   {
     System.out.print(pointer.getData() + "]--> [");
     pointer = pointer.getLink();
   }
   System.out.print(pointer.getData() + "]--> " + "[NULL]\n");
 }
}
