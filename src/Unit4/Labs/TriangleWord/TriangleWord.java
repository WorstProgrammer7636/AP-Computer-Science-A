package Unit4.Labs.TriangleWord;


class TriangleWord
{
    private String word;

    public TriangleWord()
    {
    }

    public TriangleWord(String w)
    {
    }

    public void setWord(String w)
    {
        word = w;
    }

    public String toString()
    {
        // do the output here
        String output="";
        int outsideSpace = word.length() - 1;
        int insideSpace = 0;

        //print top line
        for (int j = 0; j < outsideSpace; j++){
            output += " ";
        }

        output += word.charAt(0);
        output += "\n";
        outsideSpace--;
        insideSpace++;

        //print middle
        for (int i = 1; i < word.length() - 1; i++){
            for (int j = 0; j < outsideSpace; j++){
                output += " ";
            }

            output += word.charAt(i);
            for (int j = 0; j < insideSpace; j++){
                output += " ";
            }
            output += word.charAt(i);

            for (int j = 0; j < outsideSpace; j++){
                output += " ";
            }

            outsideSpace --;;
            insideSpace += 2;
            output+="\n";
        }

        //print bottom line
        for (int i = word.length() - 1; i >= 0; i--){
            output += word.charAt(i);
        }

        for (int i = 1; i < word.length(); i++){
            output += word.charAt(i);
        }

        //finish

        return output+"\n";
    }
}

