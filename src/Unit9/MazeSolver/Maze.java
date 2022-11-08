package Unit9.MazeSolver;

public class Maze
{
    private int[][] maze;
    private boolean exitFound;
    private boolean checked[][];

    /**
     * Create a square maze of size, size using the contents of line to fill the maze
     * @param size - the size of the maze
     * @param line - a space separated string of 0 and 1's for each element of the maze
     */
    public Maze(int size, String line)
    {
        maze = new int[size][size];
        checked = new boolean[size][size];
        exitFound = false;
        int count = 0;
        String numbersOnly = line.replaceAll("[^0-9]", "");
        // create the maze from the data
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                maze[i][j] = Integer.parseInt(String.valueOf(numbersOnly.charAt(count)));
                count++;
            }
        }

        for (int i = 0; i < size; i++){
            hasExitPath(i, 0);
            if (exitFound){
                break;
            }
        }
    }

    public boolean inBounds(int r, int c){
        return r >= 0 && r < maze.length && c >= 0 && c < maze[0].length;
    }

    /**
     * Given a starting point of r,c, recursively check if the maze has an exit path
     * If it does, set exitFound to true
     */
    public void hasExitPath(int r, int c)
    {
        if (maze[r][c] == 1 && c == maze.length - 1){
            exitFound = true;
        }

        if (checked[r][c] == false){
            checked[r][c] = true;
            if (maze[r][c] == 1){
                if (inBounds(r - 1, c)){
                    hasExitPath(r - 1, c);
                }

                if (inBounds(r + 1, c)){
                    hasExitPath(r + 1, c);
                }

                if (inBounds(r, c + 1)){
                    hasExitPath(r, c + 1);
                }

                if (inBounds(r, c - 1)){
                    hasExitPath(r, c - 1);
                }
            }
        }

    }

    /**
     * Print the maze and if the exit has been found
     */
    public String toString()
    {
        String output = "";
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[0].length; j++){
                output += maze[i][j];
                output += " ";
            }
            output = output.substring(0, output.length() - 1);
            output += "\n";
        }
        output += (exitFound?"exit found\n":"exit not found\n");
        return output;
    }
}
