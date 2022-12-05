import java.util.HashMap;

public class HashMapEg {

public static void main(String[] args) {
    
    // Hashmap<Key, Value> variable = new HashMap<Key, Value>()
    HashMap<String, Integer> myMap = new HashMap<String, Integer>();

    //add a key and value pair
    myMap.put("Bala", 30);
    myMap.put("Ken", 40);

    String key = "Bala";
    System.out.println("Value for key = " + key + "->" + myMap.get(key));

    myMap.put("Bala", 31);
    System.out.println("New value for key = " + key + "->" + myMap.get(key));

    //Check if key exists in map
    System.out.println("Check if Fred exists: " + myMap.containsKey("Fred"));
    System.out.println("Check if Ken exists: " + myMap.containsKey("Ken"));

    }
}