package Unit5.Distance;

class Main
{
    public static void main( String[] args )
    {
        //add test cases
        Distance distance = new Distance(1,1,2,1);

        distance.calcDistance();
        System.out.print("distance == ");
        System.out.printf("%.3f\n", distance.getDistance());

        distance.setCoordinates(1,1,-2,2);
        distance.calcDistance();
        System.out.print("distance == ");
        System.out.printf("%.3f\n", distance.getDistance());

        distance.setCoordinates(1,1,0,0);
        distance.calcDistance();
        System.out.print("distance == ");
        System.out.printf("%.3f\n", distance.getDistance());
    }


}
