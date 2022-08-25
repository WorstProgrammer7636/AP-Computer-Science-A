package Unit1;

public class Variables {
    public static void main(String[] args)
    {
        //define 1 variable of each of the
        //following data types
        //byte		short		int 		long
        //float		double
        //char      boolean		String

        //decimal variables
        float dec = 10.0f;
        double dec2 = 4.135;

        //other integer types
        byte numOne = 5;
        short numTwo = 2;
        int numThree = 9;
        long numFour = 134242;

        //other types
        boolean bool = true;
        String str = "Hello World";
        char character = 's';

		/*
		System.out.println("/////////////////////////////////");
		System.out.println("*                               *");
		System.out.println("*        integer types          *");
		System.out.println("*                               *");
		System.out.println("*8 bit - byteOne = "+byteOne+"\t\t*");
    */

        System.out.println("Max");
        System.out.println("/////////////////////////////////");
        System.out.println("INTEGER TYPES");
        System.out.println("8 bit - " + numOne);
        System.out.println("16 bit - " + numTwo);
        System.out.println("32 bit - " + numThree);
        System.out.println("64 bit - " + numFour);
        System.out.println();
        System.out.println("OTHER TYPES:");
        System.out.println("boolean: " + bool);
        System.out.println("String - " + str);
        System.out.println("char - " + character);
        System.out.println("float - " + dec);
        System.out.println("double - " + dec2);


    }
}
