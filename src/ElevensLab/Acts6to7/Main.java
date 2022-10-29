package ElevensLab.Acts6to7;


import java.util.List;

public class Main
{

    public static void printCards(ElevensBoard board)
    {
        List<Integer> cIndexes = board.cardIndexes();
        /* Your code goes here. */
        for (int i = 0; i < cIndexes.size(); i++){
            System.out.println(cIndexes.get(i));
        }
    }


    public static void main(String[] args)
    {
        ElevensBoard board = new ElevensBoard();

        System.out.println(board);
        printCards(board);
    }

}
