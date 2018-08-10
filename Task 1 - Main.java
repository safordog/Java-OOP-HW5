/*
 * Напишите программу, которая скопирует файлы с заранее
 * определенным расширением(например, только doc) из
 * каталога источника в каталог приемник.
 */
package homework5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author safordog
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File folder = new File("data");
        File targetFolder = new File("target");
        folder.mkdirs();
        targetFolder.mkdirs();
        File fileOne = new File("data/doc.doc");
        File fileTwo = new File("data/textOne.txt");
        File fileThree = new File("data/html.html");
        File fileFour = new File("data/textTwo.txt");
        try {
            fileOne.createNewFile();
            fileTwo.createNewFile();
            fileThree.createNewFile();
            fileFour.createNewFile();
        } catch (IOException ex) { 
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        MyFileFilter mFF = new MyFileFilter("txt");
        File[] fileList = folder.listFiles(mFF);
        for (File file : fileList) {
            System.out.println(file);
            try (FileInputStream in = new FileInputStream(file.getAbsolutePath()); 
            FileOutputStream out = new FileOutputStream("target/" + file.getName())) {
            int b = in.read();
            while (b != -1) {
                out.write(b);
                b = in.read();
            }
            } catch (FileNotFoundException ex) {
                    System.out.println("File not found!");
                    } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
