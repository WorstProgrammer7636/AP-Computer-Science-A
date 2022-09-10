package Unit2.ValidSocial;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        //Lab2c Valid Social
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an Social Security Sumber :: ");
        String ssn = input.nextLine();
        System.out.println( Social.valid(ssn) );
    }

}
