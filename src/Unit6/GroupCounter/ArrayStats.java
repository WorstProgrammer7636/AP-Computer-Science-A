package Unit6.GroupCounter;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class ArrayStats
{
    //instance variable
    private int[] array;
    private String stringList;

    /**
     * Takes a string of space separated numbers and creates an array based on
     * this String
     * Precondition the String of numbers consists of single digits seperated by a single space.
     * @param list - a space separated list of numbers e.g. "1 2 3 4"
     */
    public ArrayStats(String list)
    {
        stringList = list;
        String[] strList = list.split(" ");
        array = new int[strList.length];
        for (int i = 0; i < strList.length; i++){
            array[i] = Integer.parseInt(strList[i]);
        }

    }

    /**
     * Replaces the array with a new set of numbers provided in the String
     */
    public void setArray(String list)
    {
        // use scanner to determine the size of the array and then fill the array
        String[] strList = list.split(" ");
        array = new int[strList.length];
        for (int i = 0; i < strList.length; i++){
            array[i] = Integer.parseInt(strList[i]);
        }
    }

    public int[] getArray()
    {
        return array;
    }

    public boolean isSameNumberAndHasSpace(int[] array, int i){
        return i < array.length - 1 && array[i] == array[i+1];
    }

    public int getNumGroupsOfSize(int size)
    {
        int temp = 0;
        int counter = 0;
        int incremental = 0;
        int length = array.length;
        int groupPairingMem = 1;
        for (int i = 0; i < length; i = i + incremental + 1){
            incremental = 0;
            temp = 1;
            for (int j = i; isSameNumberAndHasSpace(array, j); j++){
                temp++;
                groupPairingMem++;
                incremental++;
            }

            if (temp >= size){
                counter++;
                groupPairingMem += temp - incremental + 1;
            }

            int original = counter;
            if (groupPairingMem == temp - size && isSameNumberAndHasSpace(array, incremental)){
                int temporary2 = array[length - 1];
                counter += temporary2;
                counter -= 1;
                counter = original;
            }

        }

        return counter;
    }


    public String toString()
    {
        return Arrays.toString(array);
    }
}
