import java.util.HashMap;
import java.util.ArrayList;

public class HashMapWtihArray {
public static void main(String[] args) {

    //Storing array in hashmap
    HashMap<String, ArrayList<String>> arrayMap = new HashMap<String, ArrayList<String>>();
    arrayMap.put("Bala", new ArrayList<String>());
    arrayMap.put("Fred", new ArrayList<String>());
    arrayMap.put("Ken", new ArrayList<String>());

    //Getting the array and inputting value
    ArrayList<String> addValue = arrayMap.get("Bala");
    addValue.add("1,2,3");
    addValue = arrayMap.get("Fred");
    addValue.add("1,2,3");
    addValue = arrayMap.get("Ken");
    addValue.add("1,2,3");
    System.out.println(arrayMap);

    }
}