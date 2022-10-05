package Unit7.NumberAnalyzer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;


public class NumberAnalyzer
{
    private ArrayList<Number> list;

    public NumberAnalyzer()
    {

    }

    public NumberAnalyzer(String numbers)
    {
        list = new ArrayList<Number>();
        Scanner s = new Scanner(numbers);
        //s.useDelimiter(" ");
        //s.tokens();
        while (s.hasNext()){
            int higuys = Integer.parseInt(s.next());
            list.add(new Number(higuys));
        }
        s.close();

    }

    public void setList(String numbers)
    {
        list = new ArrayList<Number>();
        Scanner s = new Scanner(numbers);
        s.useDelimiter(" ");
        s.tokens();
        while (s.hasNext()){
            int higuys = Integer.parseInt(s.next());
            list.add(new Number(higuys));
        }
        s.close();
    }

    public int countOdds()
    {
        int oddCount=0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).isOdd()){
                oddCount++;
            }
        }

        return oddCount;
    }

    public int countEvens()
    {
        int evenCount=0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).isEven()){
                evenCount++;
            }
        }

        return evenCount;
    }

    public int countPerfects()
    {
        int perfectCount=0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).isPerfect()){
                perfectCount++;
            }
        }

        return perfectCount;
    }

    public String toString( )
    {
        String str = "[";
        for (int i = 0; i < list.size(); i++){
            int num = list.get(i).getNumber();
            str += num;
            str += ", ";
        }

        String newStr = str.substring(0, str.length() - 2);
        newStr += "]";
        return newStr;
    }

}
