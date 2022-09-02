package Unit4.Labs.DecreasingWord;

public class TriangleOne
{
    private String word;

    public TriangleOne()
    {
        word="";
    }

    public TriangleOne(String s)
    {
        word = s;
    }

    public void setWord(String s)
    {
    }

    public void print( )
    {
        for (int i = word.length(); i >= 0; i--){
            System.out.println(word.substring(0, i));
        }
    }

}
