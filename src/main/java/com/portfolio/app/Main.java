package com.portfolio.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        run();

    }

    public static void run(){

        String filePath = "D:\\java-learning\\my-projects\\for-portfolio\\basics\\MyNotes\\db\\password.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String password = reader.readLine();

            if (password != null){
                login(password);
            }else {
                welcomeAndSetSecurity();
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void login(String password){
        System.out.print("to access this app provide password: ");
        String userInputerPassword = scanner.nextLine();

        if (userInputerPassword.equals(password)){
            System.out.println("You can access this app now!");
            showNotes();
            writeAndSaveNote();
        }else {
            System.out.println("Access denied:(");
        }

    }

    public static void welcomeAndSetSecurity(){

        String filePath4Password = "D:\\java-learning\\my-projects\\for-portfolio\\basics\\MyNotes\\db\\password.txt";
        String filePath4Note = "D:\\java-learning\\my-projects\\for-portfolio\\basics\\MyNotes\\db\\notes.txt";

        System.out.println("Welcome to MyNotes app! Here you can save your notes safely.");
        System.out.println("In order to keep your notes safe you should set password!");
        System.out.print("New password: ");
        String newPassword = scanner.nextLine();

        System.out.print("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        if (newPassword.equals(confirmPassword)){
            System.out.println("Good job! Now you can save your important notes in the app.");

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath4Password));

                writer.write(confirmPassword);
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            
            boolean agreed = true;

        while (agreed){
    
            System.out.print("Want to write note? (yes/no): ");
            String agreeToWrite = scanner.nextLine();

            if (agreeToWrite.equals("yes") || agreeToWrite.equals("y")){

                try {
                    BufferedWriter writerNote = new BufferedWriter(new FileWriter(filePath4Note,true));
    
                    System.out.print("You note: ");
                    String note = scanner.nextLine();

                    writerNote.write(note);
                    writerNote.newLine();
                    writerNote.close();
    
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else {
                agreed = false;
                System.out.println("If you wrote note it will be saved in the database. You can see notes!");
                showNotes();
            }
        }

            
        }else {
            System.out.println("Password don't match. Try again");
        }

    }

    public static void showNotes(){
        String filePath = "D:\\java-learning\\my-projects\\for-portfolio\\basics\\MyNotes\\db\\notes.txt";

        System.out.print("Do you want to see your notes? (yes/no): ");
        String toSee = scanner.nextLine();

        if (toSee.equals("yes") || toSee.equals("y")){

            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("Application terminated.");
        }
    }


    public static void writeAndSaveNote(){
        String filePath4Note = "D:\\java-learning\\my-projects\\for-portfolio\\basics\\MyNotes\\db\\notes.txt";

        boolean agreed = true;

        while (agreed){
    
            System.out.print("Want to write note? (yes/no): ");
            String agreeToWrite = scanner.nextLine();

            if (agreeToWrite.equals("yes") || agreeToWrite.equals("y")){

                try {
                    BufferedWriter writerNote = new BufferedWriter(new FileWriter(filePath4Note, true));
    
                    System.out.print("You note: ");
                    String note = scanner.nextLine();
                    writerNote.write(note);
                    writerNote.newLine();
                    writerNote.close();
                    System.out.println("Note saved successfully!");
                    
    
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else {
                agreed = false;
                System.out.println("Application terminated.");
            }
        }
    }

}




