package Unit7.GetLast;

import java.util.ArrayList;

public class ListGetLast
{


    public static ArrayList<Integer> go(ArrayList<Integer> ray)
    {
        ArrayList<Integer> newArr = new ArrayList<>();
        int lastNum = ray.get(ray.size() - 1);
        for (int i = 0; i < ray.size(); i++){
            if (ray.get(i) > lastNum){
                newArr.add(ray.get(i));
            }
        }
        return newArr;
    }


}
