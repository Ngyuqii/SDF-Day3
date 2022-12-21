import java.util.ArrayList;

public class ArrayListEg {

    public static void main(String[] args) {
        
        System.out.println("Array List Demo");

        //Create an Array List
        ArrayList<String> mylist = new ArrayList<String>();

        mylist.add("apple");
        mylist.add("orange");
        mylist.add("pear");
        mylist.add(2, "grape"); //insert grapes at index 2

        for(String item : mylist) {
            System.out.println("Item is " + item);
        }

        mylist.remove("pear");

        // Print the number of items in the list
        int count = mylist.size();
        System.out.println(count);
        System.out.println(mylist);

    }

}
