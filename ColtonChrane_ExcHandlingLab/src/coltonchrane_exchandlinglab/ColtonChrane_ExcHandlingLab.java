package coltonchrane_exchandlinglab;

import java.util.Scanner;

public class ColtonChrane_ExcHandlingLab {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (true) {
            //Username check
            String name = "";
            boolean userPass = false;
            while (userPass == false) {            
                System.out.print("Enter Name: ");
                name = in.nextLine();
                try {
                    userPass = userCheck(name);
                    if (userPass == false) {
                        throw (new FormatError("Error: User name must contain only letters and up to 1 space"));
                    } 
                } catch (FormatError e) {
                    System.out.println(e);
                }
            }//end user while
            //Password check
            boolean passwordPass = false;
            String password = "";           
            while(passwordPass == false){
            System.out.print("Create a password: ");
            password = in.nextLine();
            try {
                passwordPass = passCheck(password);
                if (passwordPass == false) {
                    throw (new FormatError("Error: Password must contain at least 1 uppercase, 1 lowercase, 1 number, and 1 symbol."));
                } else {
                    System.out.println("Great password " + name + ", welcome to the system.");
                }
            } catch (FormatError e) {
                System.out.println(e);
            }
            }//end password while
        }//end while
    }//end main

    public static boolean userCheck(String name) {
        int spaceCount = 0, nonLetterCount = 0;
        //counts requirement of string
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c)) {
                nonLetterCount++;
                if(!Character.isSpaceChar(c))
                    System.out.println("Found: " + c);
                if (Character.isSpaceChar(c)) {
                    spaceCount++;
                    nonLetterCount--;
                }
            }
        }
        //data
//        System.out.println(spaceCount);
//        System.out.println(nonLetterCount);
        //checks reuqirements
        if (spaceCount > 1) {
            return false;
        } else if (nonLetterCount > 0) {
            return false;
        } else {
            return true;
        }
    }//end userCheck method

    public static boolean passCheck(String password) {
        int upperCount = 0, lowerCount = 0, digitCount = 0, symbolCount = 0;
        //counts requirements of string
        for (char p : password.toCharArray()) {
            if (Character.isUpperCase(p)) {
                upperCount++;
            } else if (Character.isLowerCase(p)) {
                lowerCount++;
            } else if (Character.isDigit(p)) {
                digitCount++;
            } else if (!Character.isDigit(p) && !Character.isAlphabetic(p) && !Character.isWhitespace(p)) {
                symbolCount++;
            }
        }
        //data
//        System.out.println(upperCount);
//        System.out.println(lowerCount);
//        System.out.println(digitCount);
//        System.out.println(symbolCount);
//        
        //checks requirements
        if (upperCount < 1) {
            return false;
        } else if (lowerCount < 1) {
            return false;
        } else if (digitCount < 1) {
            return false;
        } else if (symbolCount < 1) {
            return false;
        } else {
            return true;
        }
    }//end passCheck 
}//end public class

class FormatError extends Exception {

    public FormatError(String s) {
        //inherits message works as a toString
        super(s);
    }
}//end FormatError class
