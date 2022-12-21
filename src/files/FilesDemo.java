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
    
        String inFilePath = "src/files/Demo.txt";
        ReadFile(inFilePath);
        String outFilePath = "src/files/Output.txt";
        WriteFile(outFilePath);
    
    }

    //Method to read file
    public static void ReadFile(String fname) {

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

            while (line != null ) {
                System.out.println("> " + line);
                line = br.readLine();
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

    //Method to write file
    public static void WriteFile(String fname) {

        try {
            FileWriter fw = new FileWriter(fname);  
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("This is a new document.\n");
            
            for(Integer i = 2; i < 5; i++ ) {
            bw.write("Line number " + i + ".\n");
            }

            bw.write("End of page.\n");

            bw.flush();
            bw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to write line: " + e.getMessage());
        }
    
    }

}