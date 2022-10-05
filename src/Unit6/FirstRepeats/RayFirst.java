package Unit6.FirstRepeats;

public class RayFirst
{

    public static boolean go(int[] ray)
    {
        if (ray.length == 0){
            return false;
        }
        int one = ray[0];
        for (int i = 1; i < ray.length; i++){
            if (ray[i] == one){
                return true;
            }
        }
        return false;
    }

}
