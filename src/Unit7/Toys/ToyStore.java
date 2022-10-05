package Unit7.Toys;

import java.util.ArrayList;
import java.util.Scanner;

public class ToyStore
{
    private ArrayList<Toy> toyList;

    /**
     * Create an empty toy store
     */
    public ToyStore()
    {
        toyList = new ArrayList<>();
    }

    public void setToString(){
        String mostFrequentToyName = toyList.get(0).getName();
        int maxFrequency = 0;
        for (int i = 0; i < toyList.size(); i++){
            String tempToy = toyList.get(i).getName();
            int tempCounter = 0;
            for (int j = 0; j < toyList.size(); j++){
                if (tempToy.equals(toyList.get(j).getName())){
                    tempCounter++;
                }
            }

            if (tempCounter > maxFrequency){
                maxFrequency = tempCounter;
                mostFrequentToyName = tempToy;
            }

            toyList.get(i).setCount(tempCounter);
        }
    }

    /**
     * load toys into the toy store
     * @param toys - a space seperated string of toy names e.g. "teddy ball ball teddy"
     */
    public void loadToys(String toys)
    {
        Scanner s = new Scanner(toys);
        while (s.hasNext()){
            String toy = s.next();
            Toy t = new Toy(toy);
            toyList.add(t);
        }
        setToString();
    }

    /**
     * add a new toy to the store
     */
    public void addToy(String name)
    {
        Toy toy = new Toy(name);
        toyList.add(toy);
        setToString();
    }

    /**
     * remove a toy from the store, if the resulting count after removal is 0
     * remove the toy from the store
     */
    public void removeToy(String name)
    {
        for (int i = 0; i < toyList.size(); i++){
            if (toyList.get(i).getName().equals(name)){
                toyList.remove(i);
                setToString();
                break;
            }
        }
    }

    public Toy getThatToy(String name)
    {
        for (int i = 0; i < toyList.size(); i++){
            if (toyList.get(i).getName().equals(name)){
                return toyList.get(i);
            }
        }

        return null;
    }

    public String getMostFrequentToyName()
    {
        String mostFrequentToyName = toyList.get(0).getName();
        int maxFrequency = 0;
        for (int i = 0; i < toyList.size(); i++){
            String tempToy = toyList.get(i).getName();
            int tempCounter = 0;
            for (int j = 0; j < toyList.size(); j++){
                if (tempToy.equals(toyList.get(j).getName())){
                    tempCounter++;
                }
            }

            if (tempCounter > maxFrequency){
                maxFrequency = tempCounter;
                mostFrequentToyName = tempToy;
            }

        }
        return mostFrequentToyName;
    }

    /**
     * Display contents of the store (topList)
     */
    public String toString()
    {
        String str = "[";
        ArrayList<String> toyNames = new ArrayList<>();
        ArrayList<Integer> toyCounts = new ArrayList<>();

        for (int i = 0; i < toyList.size(); i++){
            Toy tempToy = toyList.get(i);
            String tempName = toyList.get(i).getName();

            if (!toyNames.contains(tempName)){
                toyNames.add(tempName);
                toyCounts.add(tempToy.getCount());
            }
        }

        for (int i = 0; i < toyNames.size(); i++){
            str += toyNames.get(i);
            str += " ";
            str += toyCounts.get(i);

            if (i != toyNames.size() - 1){
                str += ", ";
            }

        }


        str += "]";

        return str;
    }
}
