package Unit6.RomanNumerals;

public class RomanNumeral
{
    private Integer number;
    private String roman;

    private final static int[] NUMBERS= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private final static String[] LETTERS = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public RomanNumeral(String str)
    {
        roman = str;
    }

    public RomanNumeral(Integer orig)
    {
        number = orig;
        roman = "";
        setNumber(orig);

    }

    public void setNumber(Integer num)
    {
        // convert the decimal number to a roman numeral
        number = num;
        roman = "";
        int tempNum = num;
        while (tempNum > 0){
            for (int i = 0; i < NUMBERS.length; i++){
                if (tempNum >= NUMBERS[i]){
                    roman += LETTERS[i];
                    tempNum -= NUMBERS[i];
                    break;
                }
            }



        }
    }

    public int getNumericalValueFromLetter(char letter){
        switch (letter){
            case 'I':
                return 1;
            case 'V':
                return 5;

            case 'X':
                return 10;

            case 'L':
                return 50;

            case 'C':
                return 100;

            case 'D':
                return 500;

            case 'M':
                return 1000;

            default:
                return -1;

        }
    }

    public void setRoman(String rom)
    {
        // convert the roman numeral to a decimal number
        roman = rom;
        number = 0;
        int romLength = roman.length();
        int count = 0;
        for (int i = 0; i < romLength; i++){
            int firstLetter = getNumericalValueFromLetter(roman.charAt(i));
            if (romLength > i + 1){
                int secondLetter = getNumericalValueFromLetter(roman.charAt(i+1));
                if (firstLetter >= secondLetter){
                    count += firstLetter;
                } else {
                    count += secondLetter;
                    count -= firstLetter;
                    i++;
                }
            } else {
                count += firstLetter;
            }
        }
        number = count;

    }

    public Integer getNumber()
    {
        return number;
    }

    public String getRomanNumeral()
    {
        return roman;
    }

    public String toString()
    {
        return number + " == " + roman;
    }
}
