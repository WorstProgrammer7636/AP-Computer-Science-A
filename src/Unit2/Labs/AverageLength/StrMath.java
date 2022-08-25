package Unit2.Labs.AverageLength;

public class StrMath
{
    String a;
    String b;
    String c;

    public StrMath(){

    }

    public StrMath(String a, String b){
        this.a = a;
        this.b = b;
    }

    public StrMath(String a, String b, String c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    // do not change method signature
    public double average(String a, String b)
    {
        double lenOne = (double)a.length();
        double lenTwo = (double)b.length();

        return (lenOne + lenTwo)/2;
    }

    public double average(String a, String b, String c){
        double lenOne = (double)a.length();
        double lenTwo = (double)b.length();
        double lenThree = (double)c.length();

        return (lenOne + lenTwo + lenThree)/3;
    }



}
