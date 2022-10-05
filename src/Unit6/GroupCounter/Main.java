package Unit6.GroupCounter;

class Main {

    public static void main(String[] args)
    {
        //Add test code here
        String t1 = "3 3 3 3 3 9 4 4 4 5 5 5 5 6 6 7 7 7 8 8 8 8 8 8 8 8";
        ArrayStats a1 = new ArrayStats(t1);
        System.out.println(a1.getNumGroupsOfSize(1));

    }

}
