package Unit2.ValidSocial;

public class Social {

    public static String valid( String social )
    {
        //add code here to solve valid social lab
        int lastFour=0;
        try {
            if (!social.substring(3,4).equals("-") || !social.substring(6,7).equals("-")){
                return "bad";
            }

            int firstSection = Integer.parseInt(social.substring(0,3));



            int secondSection=Integer.parseInt(social.substring(4,6));

            int thirdSection=Integer.parseInt(social.substring(7));
            lastFour=thirdSection;
        } catch (NumberFormatException e){
            return "bad";
        }
        return String.valueOf(lastFour);
    }
}

