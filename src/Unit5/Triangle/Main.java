package Unit5.Triangle;

import java.util.Scanner;
class Main
{
    public static void main(String[] args)
    {
        // create one Triangle object
        Triangle tri = new Triangle();
        // create a simple UI loop that asks the user for sides A,B,C
        Scanner s = new Scanner(System.in);

        while (true){
            System.out.println("Enter side A :: ");
            int sideA = s.nextInt();

            if (sideA == 0){
                System.out.println("bye");
                System.exit(1);
            }

            System.out.println("Enter side B :: ");
            int sideB = s.nextInt();

            System.out.println("Enter side C :: ");
            int sideC = s.nextInt();

            tri.setSides(sideA, sideB, sideC);
            tri.calcArea();
            System.out.println(tri);
        }

        // Each time around the loop calc the area and then call toString()


    }
}