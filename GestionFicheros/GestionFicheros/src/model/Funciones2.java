/*
package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author tommyfigjim
 */

//public class Funciones2 {
//
//    public static void createFolder(String fileName) {
//        File folder = new File(fileName);
//        if (!folder.exists()) {
//            folder.mkdir();
//        }
//    }
//
//    public static void createFile(String path, String fileName, String content) {
//        File file = new File(path, fileName);
//        
//        try {
//           FileWriter writer = new FileWriter(file, true);
//           writer.write(content);
//           writer.close();
//        } catch(IOException e){ 
//        }
//    }
//    
//    public static String[] showListFile(String path) {
//       File folder = new File(path);
//       return folder.exists() ? folder.list() : new String[0];
//    }
//    
//    public static String showFile(String path, String fileName) {
//        
//    }
//}
