package Unit4.Labs.PerfectNumber;



public class Main
{
    public static void main( String args[] )
    {
        Perfect per = new Perfect();

        // test case 1
        int num = 496;
        per.setNumber(num);
        System.out.println(per);

        int num1 = 45;
        per.setNumber(num1);
        System.out.println(per);

        int num2 = 6;
        per.setNumber(num2);
        System.out.println(per);

        int num3 = 14;
        per.setNumber(num3);
        System.out.println(per);

        int num4 = 8128;
        per.setNumber(num4);
        System.out.println(per);

        int num5 = 1245;
        per.setNumber(num5);
        System.out.println(per);

        int num6 = 33;
        per.setNumber(num6);
        System.out.println(per);

        int num7 = 28;
        per.setNumber(num7);
        System.out.println(per);

        int num8 = 27;
        per.setNumber(num8);
        System.out.println(per);

        int num9 = 33550336;
        per.setNumber(num9);
        System.out.println(per);

    }
}
