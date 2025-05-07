package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Funciones {

    public static void createFolder(String folderTommy) {
        File folder = new File(folderTommy);
        
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    public static void createFile(String path, String fileTommy, String content) {
        File file = new File(path, fileTommy);
        
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(content);
            writer.close();
            } catch (IOException e) {
        }
    }

    public static String[] showListFiles(String path) {
        File folder = new File(path);
        return folder.exists() ? folder.list() : new String[0];
    }

    public static String showFile(String path, String fileName) {
        File file = new File(path + fileName);
        if (file.exists()) {
            try (Scanner scan = new Scanner(file)) {
                StringBuilder content = new StringBuilder();
                while (scan.hasNextLine()) {
                    content.append(scan.nextLine()).append("\n");
                }
                return content.toString();
            } catch (Exception e) {
            }
        }
        return "";
    }

    public static boolean overWriteFile(String path, String fileName, String newContent) {
        File file = new File(path + "/" + fileName);
        if (file.exists()) {
            try (FileWriter writer = new FileWriter(file, false)) {
                writer.write(newContent);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    public static void deleteFile(String path, String fileName) {
        File file = new File(path + "/" + fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    public static int countChars(String path, String fileName) {
        String content = showFile(path, fileName);
        return content.length();
    }

    public static int countWords(String path, String fileName) {
        String content = showFile(path, fileName);
        String[] words = content.split("\\s+");
        return words.length;
    }

    public static String swapWords(String path, String fileName, String oldWord, String newWord) {
        String content = showFile(path, fileName);
        content = content.replace(oldWord, newWord);
        overWriteFile(path, fileName, content);
        return content;
    }
}
