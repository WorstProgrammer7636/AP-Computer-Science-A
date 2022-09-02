package Unit4.Labs.PerfectNumber;


public class Perfect
{
    private int number;

    public Perfect()
    {
    }

    public Perfect(int num)
    {
    }

    public void setNumber(int num)
    {
        number = num;
    }

    public boolean isPerfect()
    {
        int divisorSum = 0;
        for (int i = 1; i < number; i++){
            if (number % i == 0){
                divisorSum += i;
            }
        }

        if (divisorSum == number){
            return true;
        } else {
            return false;
        }
    }

    public String toString()
    {
        if (isPerfect())
            return number + " is perfect.";
        else
            return number + " is not perfect.";
    }

}
