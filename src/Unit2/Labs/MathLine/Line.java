package Unit2.Labs.MathLine;

public class Line
{
    public static double slope( int x1, int y1, int x2, int y2 )
    {
        double result = ((double)y2 - y1) / ((double)x2 - x1);
        return result;
    }

}
