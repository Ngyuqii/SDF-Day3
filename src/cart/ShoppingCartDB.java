package cart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingCartDB {

public static final String login = "login";
public static final String list = "list";
public static final String add = "add";
public static final String save = "save";
public static final String users = "users";
public static final String exit = "exit";
public static final List<String> validCommands = Arrays.asList(login, users, add, save, list, exit);

private CartDBMemory db;
private String currentUser;

public ShoppingCartDB(){
    this.db = new CartDBMemory();
}

public void startShell() {
    System.out.println("Welcome to Multiuser Shopping Cart.");
    Scanner sc = new Scanner(System.in);
    String line;
    boolean stop = false;

    while (!stop) {
        line = sc.nextLine();
        line = line.trim();
        System.out.println(">" + line);

        if(line.equalsIgnoreCase("exit")) {
            System.out.println("Exiting.");
            stop = true;
        }
    
        //Validate command
        if(this.ValidateInput(line)) {
            System.out.println("Processing" + line);
            this.ProcessInput(line);
        } else {
            System.out.println("Invalid Input.");
        }
    }
    sc.close();
}

public boolean ValidateInput(String input) {
    String[] parts = input.split(" ");
    String command = parts[0].trim();
    // Scanner lsc = new Scanner(input);
    // String commad = lsc.next().trim()
    return validCommands.contains(command);
}

// Process command
public void ProcessInput(String input) {
    Scanner sc = new Scanner(input);
    String command = sc.next().trim();
    
    switch (command) {
        case login:
        String username = sc.nextLine().trim();
        this.LoginAction(username);
        break;

        case list:
        this.ListAction();
        break;
        
        case add:
        String[] items = sc.nextLine().trim().split(",");
        this.AddAction(items);
        break;
        
        case save:
        break;
        
        case users:
        break;
        
        default: break;
    }
    
    sc.close();
}

public void LoginAction(String username) {
if (!this.db.myMap.containsKey(username)) {
    this.db.myMap.put(username, new ArrayList<String>());
}
this.currentUser = username;
}

public void AddAction(String[] items) {
for (String item : items) {
    this.db.myMap.get(this.currentUser).add(item.trim());
}
}

public void ListAction() {
for (String item : this.db.myMap.get(this.currentUser)) {
    System.out.println("Item -> " + item);
    }
}
}