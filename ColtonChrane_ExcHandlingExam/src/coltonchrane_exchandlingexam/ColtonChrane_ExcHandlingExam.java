package coltonchrane_exchandlingexam;

import java.util.Scanner;

class FormatError extends Exception {

    String s;

    FormatError(String s) {
        this.s =s;
    }

    public String toString() {
        return s;
    }
}//end FormatError class

public class ColtonChrane_ExcHandlingExam {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //name check
        boolean pass = false;
        while (pass == false) {
            boolean namePass = false;
            while (namePass == false) {
                try {
                    //name check
                    String name = "";
                    System.out.print("Enter Name: ");
                    name = in.nextLine();
                    int spaceCount = 0, nonLetterCount = 0;
                    //counts requirement of string
                    for (char c : name.toCharArray()) {
                        if (!Character.isLetter(c)) {
                            nonLetterCount++;
                            if (!Character.isSpaceChar(c)) {
                                //System.out.println("Found: " + c);
                            }
                            if (Character.isSpaceChar(c)) {
                                spaceCount++;
                                nonLetterCount--;
                            }
                        }
                    }
                    if (spaceCount != 1) {
                        throw new FormatError("Name must have 1 space");
                    } else if (nonLetterCount > 0) {
                        throw new FormatError("Name must only have letters");
                    } else {
                        namePass = true;
                    }

                } catch (FormatError e) {
                    System.out.print("Error: ");
                    System.out.println(e.toString());
                    continue;
                }

            }//end user while
            //Phone check
            boolean passwordPass = false;
            while (passwordPass == false) {
                try {
                    String phone = "";
                    System.out.print("Enter a phone number: ");
                    phone = in.nextLine();

                    if (phone.length() != 12) {
                        throw new FormatError("Phone Number must be 12 characters long");
                    }
                    if (phone.charAt(3) != '-' && phone.charAt(7) != '-') {
                        throw new FormatError("Please use this ###-###-### format");
                    }
                    for (int i = 0; i < 3; i++) {
                        if (!Character.isDigit(phone.toCharArray()[i])) {
                            throw new FormatError("Phone Number must be all digits. Found:" + phone.toCharArray()[i] );
                        }
                    }
                    for (int i = 4; i < 7; i++) {
                        if (!Character.isDigit(phone.toCharArray()[i])) {
                            throw new FormatError("Phone Number must be all digits. Found:" + phone.toCharArray()[i]);
                        }
                    }
                    for (int i = 8; i < 12; i++) {
                        if (!Character.isDigit(phone.toCharArray()[i])) {
                            throw new FormatError("Phone Number must be all digits. Found:" + phone.toCharArray()[i]);
                        }
                    }
                    passwordPass = true;
                    pass = true;
                } catch (FormatError e) {
                    System.out.print("Error: ");
                    System.out.println(e.toString());
                    continue;
                }
            }//end password while
        }
System.out.println("Validation Complete!");//end while
    }//end main
}


