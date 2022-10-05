package Unit6.RomanNumerals;

class Main {

    public static void main(String[] args)
    {
        RomanNumeral test = new RomanNumeral(10);

        System.out.println(test.toString());

        test.setNumber(100);
        System.out.println(test.toString());

        test.setNumber(1000);
        System.out.println(test.toString());

        test.setNumber(2500);
        System.out.println(test.toString());

        test = new RomanNumeral(1500);
        System.out.println(test.toString());

        test.setNumber(23);
        System.out.println(test.toString());

        test.setNumber(38);
        System.out.println(test.toString());

        test.setNumber(49);
        System.out.println(test.toString());

        test.setRoman("LXXVII");
        System.out.println("LXXVII is " + test.getNumber());

        test.setRoman("XLIX");
        System.out.println("XLIX is " + test.getNumber());

        test.setRoman("XX");
        System.out.println("XX is " + test.getNumber());

        test.setRoman("XXXVIII");
        System.out.println("XXXVIII is " + test.getNumber());
    }
}
