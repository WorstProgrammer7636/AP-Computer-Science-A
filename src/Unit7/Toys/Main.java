package Unit7.Toys;

class Main
{

    public static void main(String[] args)
    {
        // test code for Toy
        Toy t = new Toy("game");
        System.out.println(t);
        t.setCount(5);
        System.out.println(t);

        // test code for ToyStore
        ToyStore sto = new ToyStore();
        System.out.println( sto );
        sto.loadToys("sorry bat sorry sorry sorry train train teddy teddy ball ball" );
        sto.addToy("glove");
        System.out.println( sto );
        System.out.println( "max == " + sto.getMostFrequentToyName() );
    }

}
