package Unit2.StarsAndStripes;

public class StarsAndStripes
{
    public StarsAndStripes()
    {


    }

    public void printCustomBox(int length, int iterations){
        for (int i = 0; i < iterations; i++){
            printDashes(length);
            printStars(length);

        }
    }

    public void printStars(int length)
    {
        String stars = "";
        for (int i = 0; i < length; i++){
            stars += "*";
        }
        System.out.println(stars);
    }

    public void printDashes(int length)

    {
        String stars = "";
        for (int i = 0; i < length; i++){
            stars += "-";
        }
        System.out.println(stars);
    }
}



