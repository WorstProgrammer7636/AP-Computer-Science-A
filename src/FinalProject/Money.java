package FinalProject;

public class Money{
    private static int currentMoney;
    private int price;
    public Money(){
        currentMoney = 650;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int p){
        price = p;
    }
    /* return true if enough money to buy and
    decrement the current Money by price;
    return false if not rnough money to buy.
    */
    // could sepreate boolean and void out, but might not be needed.
    public boolean buy(int price){
        if (currentMoney >= price){
            currentMoney -= price;
            return true;
        }
        else
            return false;
    }
    public void gainRoundMoney(){
        currentMoney += 100;
    }
    public int getCurrentMoney(){
        return currentMoney;
    }
}
