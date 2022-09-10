package Unit3.BiggestDouble;


public class Main
{
    public static void main(String[] args)
    {
        BiggestDouble bd = new BiggestDouble();

        bd.setDoubles(4.5, 6.7, 7.8, 9.0);
        System.out.println(bd);
        System.out.println("biggest = " + bd.getBiggest() + "\n");

        bd.setDoubles(14.51, 6.17, 71.8, 1.0);
        System.out.println(bd);
        System.out.println("biggest = " + bd.getBiggest() + "\n");

        bd.setDoubles(41.15, 816.7, 17.8, 19.0);
        System.out.println(bd);
        System.out.println("biggest = " + bd.getBiggest() + "\n");

        bd.setDoubles(884.5, 16.7, 7.8, 9.0);
        System.out.println(bd);
        System.out.println("biggest = " + bd.getBiggest() + "\n");

        bd.setDoubles(4.5, -456.7, 677.8, 9.0);
        System.out.println(bd);
        System.out.println("biggest = " + bd.getBiggest() + "\n");

        bd.setDoubles(4.5, 16.7, -7.8, -9.0);
        System.out.println(bd);
        System.out.println("biggest = " + bd.getBiggest() + "\n");

        //add the other test cases by calling setDoubles


    }
}
