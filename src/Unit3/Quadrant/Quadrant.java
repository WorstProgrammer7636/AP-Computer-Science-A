package Unit3.Quadrant;

class Quadrant {


    // write static quadrant method here
    public static int quadrant(double a, double b){
        if (a == 0 || b == 0){
            return 0;
        } else if (a > 0 && b > 0){
            return 1;
        } else if (a < 0 && b > 0){
            return 2;
        } else if (a < 0 && b < 0){
            return 3;
        } else {
            return 4;
        }
    }

    public static boolean isVowel(String s){
        if (s.equals("a") || s.equals("e") || s.equals("o") || s.equals("i") || s.equals("u")){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args)
    {
        // test your method here
        System.out.println(quadrant(-4.2, 17.3));
        System.out.println(isVowel("m"));
    }

}
