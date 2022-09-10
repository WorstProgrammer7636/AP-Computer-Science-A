package Unit3.GradeCheck;

import java.util.Scanner;
class Main
{

    public static void main(String[] args)
    {
        // for each test case...

        // create a new Grade object
        // call the Grade object to get the letter grade
        // print out the result
        //  - note you can just print the object which will call toString
        Scanner s = new Scanner(System.in);
        double t1 = 78;
        double t2 = 92.5;
        double t3 = 31;
        double t4 = 89.5;
        double t5 = 89.49;

        Grade g1 = new Grade(t1);
        Grade g2 = new Grade(t2);
        Grade g3 = new Grade(t3);
        Grade g4 = new Grade(t4);
        Grade g5 = new Grade(t5);


        System.out.println(g1.toString());
        System.out.println(g2.toString());
        System.out.println(g3.toString());
        System.out.println(g4.toString());
        System.out.println(g5.toString());
    }
}
