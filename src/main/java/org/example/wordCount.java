package org.example;

import java.io.*;

public class wordCount {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Usage: Java wordCount <file-path>");
        }
        String filePath = args[0];
        int wordCount = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] words = line.split("\\s+");
                wordCount+=words.length;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total word count: "+wordCount);
    }
}
