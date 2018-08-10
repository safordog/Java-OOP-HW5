/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework5a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author safordog
 */
public class Copy {
    
    public Copy() {
        
    }
    
    public File getFile(File fileOne, File fileTwo) throws FileNotFoundException {
       Scanner scOne = new Scanner(fileOne);
       String strOne = scOne.nextLine();
       String[] arrOne = strOne.split(" ");
       Scanner scTwo = new Scanner(fileTwo);
       String strTwo = scTwo.nextLine();
       String[] arrTwo = strTwo.split(" ");
       File result = new File("result.txt");
       try (PrintWriter pw = new PrintWriter(result)) {
       for (int i = 0; i < arrOne.length; i++) {
           for (int j = 0; j < arrTwo.length; j++) {
               if (arrOne[i].equals(arrTwo[j])) {
                   if (!result.exists()) {
                       result.createNewFile();
                   }
                   pw.print(arrOne[i] + " ");
               }
           }
       }
       } catch (IOException ex) {
            Logger.getLogger(Copy.class.getName()).log(Level.SEVERE, null, ex);
        }
       scOne.close();
       scTwo.close();
       return result;
    }
    
}
