package Unit7.MostFreq;

import java.util.*;

public class ListMostFreq
{

    public static int go(ArrayList<Integer> ray)
    {
        int maxNum = 0;
        int maxFrequency = 0;
        for (int i = 0; i < ray.size(); i++){
            int tempNum = ray.get(i);
            int tempCounter = 0;
            for (int j = 0; j < ray.size(); j++){
                if (tempNum == ray.get(j)){
                    tempCounter++;
                }
            }

            if (tempCounter > maxFrequency){
                maxFrequency = tempCounter;
                maxNum = tempNum;
            }

        }
        return maxNum;
    }


}
