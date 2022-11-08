package Unit9.CountEvenDigits;

public class RecursionFunOne
{
    public static int countEvenDigits(int num)
    {
        int digit = num % 10;
        if (num == 0){
            return 0;
        } else if (digit % 2 == 0){
            return countEvenDigits(num/10) + 1;
        } else {
            return countEvenDigits(num/10);
        }

    }
}
