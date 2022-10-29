package Unit8.Forest;


public class Forest
{
    private static final String[] TYPE_LIST = "cat dog tree rock".split(" ");
    private static final String[] NAME_LIST = "a b c d e f g h i j k l m n o p q r t s u v w x y z".split(" ");
    private static final double MIN_SIZE = 5.0;
    private static final double MAX_SIZE = 35.0;

    private Thing[][] grid;

    /**
     * Create a random Forest by creating random Things based on
     *   random type from the TYPE_LIST
     *   random name from the NAME_LIST
     *   random sizes from MIN_SIZE to MAX_SIZE (e.g. 8.0 to 34.999)
     */
    public Forest(int rows, int cols)
    {
        grid = new Thing[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                String randomType = TYPE_LIST[(int)(Math.random() * TYPE_LIST.length)];
                String randomName = NAME_LIST[(int)(Math.random() * NAME_LIST.length)];
                double temp = (Math.random() * (MAX_SIZE - MIN_SIZE)) + MIN_SIZE;
                double randomSize = Double.parseDouble(String.format("%.2f", temp));
                grid[i][j] = new Thing(randomType, randomName, randomSize);
            }
        }

    }

    /**
     * for testing
     */
    public Forest(Thing[][] grid)
    {
        this.grid = grid;
    }

    /**
     * Iterate through the grid calling isTrapped and setting that spot to null
     * @return the number of animals trapped
     */
    public int setTrappedToNull( )
    {
        //
        int trappedAnimals = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (isTrapped(i, j)){
                    trappedAnimals++;
                    grid[i][j] = null;
                }
            }
        }
        return trappedAnimals;
    }

    /**
     * Determine if an animal is trapped
     *   if location contains an animal && is surrounded by 5 or more trees or rock, each larger or equal to 10
     */
    public boolean isTrapped( int r, int c)
    {
        int i = r;
        int j = c;
        if (grid[i][j].getType().equals("cat") || grid[i][j].getType().equals("dog")){
            //good
            int counter = 0;
            if (inBounds(i + 1, j)) {
                if (grid[i+1][j].getType().equals("rock") && grid[i+1][j].getSize() >= 10){
                    counter++;
                } else if (grid[i+1][j].getType().equals("tree") && grid[i+1][j].getSize() >= 10){
                    counter++;
                }
            }

            if (inBounds(i, j+1)) {
                if (grid[i][j+1].getType().equals("rock") && grid[i][j+1].getSize() >= 10){
                    counter++;
                } else if (grid[i][j+1].getType().equals("tree") && grid[i][j+1].getSize() >= 10){
                    counter++;
                }
            }

            if (inBounds(i-1, j)) {
                if (grid[i-1][j].getType().equals("rock") && grid[i-1][j].getSize() >= 10){
                    counter++;
                } else if (grid[i-1][j].getType().equals("tree") && grid[i-1][j].getSize() >= 10){
                    counter++;
                }
            }

            if (inBounds(i, j-1)) {
                if (grid[i][j-1].getType().equals("rock") && grid[i][j-1].getSize() >= 10){
                    counter++;
                } else if (grid[i][j-1].getType().equals("tree") && grid[i][j-1].getSize() >= 10){
                    counter++;
                }
            }

            if (inBounds(i+1, j+1)) {
                if (grid[i+1][j+1].getType().equals("rock") && grid[i+1][j+1].getSize() >= 10){
                    counter++;
                } else if (grid[i+1][j+1].getType().equals("tree") && grid[i+1][j+1].getSize() >= 10){
                    counter++;
                }
            }

            if (inBounds(i-1, j-1)) {
                if (grid[i-1][j-1].getType().equals("rock") && grid[i-1][j-1].getSize() >= 10){
                    counter++;
                } else if (grid[i-1][j-1].getType().equals("tree") && grid[i-1][j-1].getSize() >= 10){
                    counter++;
                }
            }

            if (inBounds(i+1, j-1)) {
                if (grid[i+1][j-1].getType().equals("rock") && grid[i+1][j-1].getSize() >= 10){
                    counter++;
                } else if (grid[i+1][j-1].getType().equals("tree") && grid[i+1][j-1].getSize() >= 10){
                    counter++;
                }
            }

            if (inBounds(i-1, j+1)) {
                if (grid[i-1][j+1].getType().equals("rock") && grid[i-1][j+1].getSize() >= 10){
                    counter++;
                } else if (grid[i-1][j+1].getType().equals("tree") && grid[i-1][j+1].getSize() >= 10){
                    counter++;
                }
            }

            if (counter >= 5){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }



    }

    // helper method can be called by isTrapped
    private boolean inBounds( int r, int c)
    {

        return (r < grid.length && c < grid[0].length && r >= 0 && c >= 0 && grid[r][c] != null);
    }

    public Thing getThing(int r, int c)
    {
        return grid[r][c];
    }

    /**
     * Return a string rep of the forest in row major order grid of things
     *  thing thing thing
     *  thing thing thing
     * Note: only put spaces between the 'things', not at the end of each row
     */
    public String toString()
    {
        String output = "";

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                output += grid[i][j] + " ";
            }
            output = output.substring(0, output.length() - 1);
            output += "\n";
        }


    /*
    output += "\n";
    output += String.valueOf(setTrappedToNull());
    output += "\n";

    output += "\n";
    for (int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid[0].length; j++){
        output += grid[i][j] + " ";
      }
      output = output.substring(0, output.length() - 1);
      output += "\n";
    }
    output = output.substring(0, output.length() - 1);
    */

        return output;
    }
}


