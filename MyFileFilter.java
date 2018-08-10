/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework5;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author safordog
 */
public class MyFileFilter implements FileFilter {
    
    private String[] arr;

    public MyFileFilter(String... arr) {
        super();
        this.arr = arr;
    }
    
    public MyFileFilter() {
        
    }
    
    private boolean check(String txt) {
        for (String stringTxt : arr) {
            if (stringTxt.equals(txt)) {
                return true;
            }
        } 
        return false;
    }

    @Override
    public boolean accept(File pathname) {
      int pointerIndex = pathname.getName().lastIndexOf(".");
      if (pointerIndex == -1) {
          return false;
      }
      String txt = pathname.getName().substring(pointerIndex + 1);
      return check(txt);  
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }
    
    
}
