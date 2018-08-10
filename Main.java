/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework5a;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author safordog
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        File fileOne = new File("one.txt");
        File fileTwo = new File("two.txt");
        fileOne.createNewFile();
        fileTwo.createNewFile();
        try (PrintWriter pwOne = new PrintWriter(fileOne); 
                PrintWriter pwTwo = new PrintWriter(fileTwo)) {
            pwOne.print("Hello world");
            pwTwo.print("Hello new world");
        }
        new Copy().getFile(fileOne, fileTwo);
    }
    
}
