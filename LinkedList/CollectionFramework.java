
import java.awt.SystemTray;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class CollectionFramework {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>();
        list.add("is");
        list.add("a");

        list.addFirst("This");
        //add and addlast is same
        list.addLast("list");

        System.out.println(list);

        System.out.println("This size is " +list.size());

        // for(int i=0;i<=list.size();i++){
        //     System.out.print(list.get(i)+"->");
        // }
        // System.out.println("null");

        for(String item:list){
            System.out.print(item +"->");
        }
        System.out.println("null");




        list.removeFirst();
        System.out.println("using removefirst: ");
        System.out.println(list);

        list.remove();
        System.out.println("using removelast: ");
        System.out.println(list);

        list.remove(0);
        System.out.println(list);

    }
}


// | **Method**           | **Output**                           | **Why it is used**                                        | **How it is used**                                                                 |
// |----------------------|--------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------|
// | println(list)        | [This, is, a, list]                  | Quick way to print elements using toString()             | Pass list to println(), works for ArrayList/LinkedList or any class overriding toString() |
// | for / for-each       | This -> is -> a -> list -> null       | Allows custom formatting like arrows or separators      | Use a for loop or for-each loop and print each element manually                   |
// | Node traversal       | This -> is -> a -> list -> null       | Required for custom linked lists implemented with Node  | Traverse nodes using next pointer in a while loop                                  |

