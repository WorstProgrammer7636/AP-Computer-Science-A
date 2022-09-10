package Unit5.Triangle;

public class Triangle
{

    private int sideA, sideB, sideC;
    private double area;

    public Triangle()
    {
        // set the object to a default state
    }

    public Triangle(int a, int b, int c)
    {
        // set the sides
        sideA = a;
        sideB = b;
        sideC = c;
    }


    public void setSides(int a, int b, int c)
    {
        // set the sides
        sideA = a;
        sideB = b;
        sideC = c;
    }

    public int getSide(String side)
    {
        // return the side based on the side param:
        //   "A", "B", "C" (case insensitive)
        //   return 0 if not a correct side
        if (side.equalsIgnoreCase("A")){
            return sideA;
        } else if (side.equalsIgnoreCase("B")){
            return sideB;
        } else if (side.equalsIgnoreCase("C")){
            return sideC;
        } else {
            return 0;
        }
    }

    private double calcPerimeter( )
    {
        return sideA + sideB +sideC;
        // private helper method to calc the perimeter - use in calcArea
        // do not change this to public
    }

    public void calcArea( )
    {
        double s = (double)calcPerimeter()/2;
        double inside = s * (s-sideA)*(s-sideB)*(s-sideC);
        area = Math.sqrt(inside);
    }

    public double getArea()
    {
        // get the area
        return area;
    }

    // output the area
    public String toString()
    {
        double roundDbl = Math.round(getArea()*100.0)/100.0;
        return "Triangle: " + sideA + "x" + sideB + "x" + sideC
                + ", has area == " + roundDbl;
    }
}
