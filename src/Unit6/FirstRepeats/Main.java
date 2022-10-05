package Unit6.FirstRepeats;

class Main {

    public static void main(String[] args)
    {
        // Add test code here
        int[] a1 = {-99,1,2,3,4,5,6,7,8,9,10,12345};
        System.out.println(RayFirst.go(a1));

        int[] a2 = {10,9,8,7,6,5,4,3,2,1,-99};
        System.out.println(RayFirst.go(a2));

        int[] a3 = {10,20,30,40,50,-11818,40,30,20,10};
        System.out.println(RayFirst.go(a3));

        int[] a4 = {32767};
        System.out.println(RayFirst.go(a4));

        int[] a5 = {7,7,7,7};
        System.out.println(RayFirst.go(a5));

        int[] a6 = {9,10,-88,100,-555,1000};
        System.out.println(RayFirst.go(a6));

        int[] a7 = {10,10,10,11,456};
        System.out.println(RayFirst.go(a7));

        int[] a8 = {-111,1,2,3,9,11,20,30};
        System.out.println(RayFirst.go(a8));

        int[] a9 = {9,8,7,6,5,4,3,2,0,-2,9,9};
        System.out.println(RayFirst.go(a9));

        int[] a10 = {12,15,18,21,23,1000};
        System.out.println(RayFirst.go(a10));

        int[] a11 = {250,19,17,15,13,11,10,9,6,3,2,1,-455};
        System.out.println(RayFirst.go(a11));

        int[] a12 = {};
        System.out.println(RayFirst.go(a12));
    }

}
