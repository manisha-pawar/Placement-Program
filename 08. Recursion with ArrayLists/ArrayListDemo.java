import java.util.*;

public class Main {

    public static void main(String[] args) {
        //ArrayLists demo

        //ArrayList creation
        ArrayList < Integer > list = new ArrayList < > ();

        //add elements in list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // System.out.println(list);
        // System.out.println(list.size());

        //get an element
        int ele = list.get(1);
        // System.out.println(ele);

        list.add(100);

        int lastEle = list.get(list.size() - 1);
        // System.out.println(lastEle);

        //set an element
        list.set(1, 75);

        System.out.println(list);

        //remove an element
        list.remove(3);
        System.out.println(list);
    }

}
