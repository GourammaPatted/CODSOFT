package com.word;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a text or provide a file path:");
        String input = scanner.nextLine();
        
        String text = "";
        if (input.startsWith("file:")) {
            String filePath = input.substring(5);
            try {
                text = readTextFromFile(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                System.exit(1);
            }
        } else {
            text = input;
        }
        
        String[] words = text.split("\\s+|\\p{Punct}");
        int wordCount = words.length;
        
        System.out.println("Total words: " + wordCount);
    }
    
    public static String readTextFromFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);
        
        while (fileScanner.hasNextLine()) {
            content.append(fileScanner.nextLine());
        }
        
        fileScanner.close();
        return content.toString();
    }
}

