package Unit9.MazeSolver;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


class Main
{

    public static void main(String[] args) throws IOException
    {
        // read the file maze.txt
        // for each maze:
        //   create a Maze
        File file = new File("maze.txt");
        Scanner s = new Scanner(file);

        while(s.hasNextLine()){
            String sizeLine = s.nextLine();
            int size = Integer.parseInt(sizeLine);
            String line = s.nextLine();
            Maze maze = new Maze(size, line);

            System.out.println(maze);
        }


    }

}
