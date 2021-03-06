import com.uriel.entity.Entity;
import com.uriel.entity.HeapCollection;
import com.uriel.entity.LinkedListCollection;
import com.uriel.entity.OrderedArrayCollection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver
{

    public static void printCollections(OrderedArrayCollection oc, HeapCollection hc, LinkedListCollection llc) {
        System.out.println("printing current status of my collections:\n");

        System.out.println("Ordered Array:");
        oc.printCollection();
        System.out.println();

        System.out.println("Heap:");
        hc.printCollection();
        System.out.println();

        System.out.println("Linked List:");
        llc.printCollection();
        System.out.println();
    }
    public static void add (OrderedArrayCollection oc, HeapCollection hc, LinkedListCollection llc, int value){
            Entity entity = new Entity(value);
            oc.add(entity);
            hc.add(entity);
            llc.add(entity);

    }
    public static void removeMaxValue (OrderedArrayCollection oc, HeapCollection hc, LinkedListCollection llc){
        oc.removeMaxValue();
        hc.removeMaxValue();
        llc.removeMaxValue();
    }

    public static void printMenu(){
        System.out.println("please choose from the following options: \n" +
                "1. Add entity to entity collection.\n" +
                "2. Remove maximal value from entity collection.\n" +
                "3. Print collections. \n" +
                "0. Exit. \n");
    }

    public static void main(String[] args)
    {
        // Declaring implementation objects.
        OrderedArrayCollection  oc  = new OrderedArrayCollection();
        HeapCollection          hc  = new HeapCollection();
        LinkedListCollection    llc = new LinkedListCollection();

        Scanner scanner = new Scanner(System.in);
        int choose= -1;
        int valueOfEntity;

        while(choose != 0 )
        {
            try {
                printMenu();
                choose = scanner.nextInt();

                switch (choose) {
                    case 0:         // Breaking the loop.
                    {
                        System.out.println("Bye Bye");
                        break;
                    }
                    case 1:         // Add new entity.
                    {
                        System.out.println("Please enter number for entity value.");
                        valueOfEntity = scanner.nextInt();
                        add(oc, hc, llc, valueOfEntity);
                        break;
                    }
                    case 2:         // Remove Maximal element.
                    {
                        removeMaxValue(oc, hc, llc);
                        break;
                    }
                    case 3:         // Print all elements in every one of the collections.
                    {
                        System.out.println("Printing the heap implemented by using poll() method. \n" +
                                "which means that if you still want to print the current status of the " +
                                "heap, the heap will be cleared. \nDo you want to continue and print? Y/N ");
                        scanner.nextLine();
                        String answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("y"))
                            printCollections(oc, hc, llc);
                        break;
                    }

                    default:
                    {
                        System.out.println("Not a valid option.");
                        break;
                    }
                }
            }
            catch(InputMismatchException e)
            {
                //e.printStackTrace();
                System.out.println("Bad input!\nplease try again.");
                choose = -1;
                scanner.nextLine();
            }

        }
    }

}
