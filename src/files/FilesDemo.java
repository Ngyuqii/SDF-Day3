package files;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class FilesDemo {
public static void main(String[] args) {
        
    String inFilePath = "src/files/Demo.txt.";
    ReadFile(inFilePath);
    String outFilePath = "src/files/Output.txt";
    WriteFile(outFilePath);
    
}

public static void ReadFile(String fname) {

    //Path Object
    //Get a path and convert path to file
    File fobj = Paths.get(fname).toFile();
    if(fobj.exists()) {
        System.out.println("File exists.");
    }
    else {
        System.out.println("File not found.");
    }
    
    //Reader Object
    try{
        FileReader fr = new FileReader(fobj);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (null != line) {
            System.out.println("> " + line);
        }

        br.close();
    }

    catch (FileNotFoundException e) {
        System.out.println("File not found. Please check input file: " + e.getMessage());
    }
    catch (IOException e) {
        System.out.println("Unable to read line: " + e.getMessage());
    }
    }

public static void WriteFile(String fname) {
    try {
    FileWriter fw = new FileWriter(fname, false); // append mode / write mode    
    BufferedWriter bfw = new BufferedWriter(fw);
    bfw.write("apple\n");
    bfw.write("orange\n");
    bfw.write("pear\n");
    bfw.flush();
    bfw.close();
    } catch (IOException e) {
        System.out.println("Unable to write line: " + e.getMessage());
        }
    }
}