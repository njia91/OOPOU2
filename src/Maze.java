
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by dv15man on 2016-04-11
 */
public class Maze {

    private char[][] maze;
    private Position start;


    /**
     *
     * @param file reference to the file were the maze is stored.
     * @throws IOException if somethings wrong with file.
     */
    public Maze(java.io.Reader file) throws IOException{

        BufferedReader buffer = new BufferedReader(file);
        Queue<String> queue = new LinkedList<String>();
        String line;
        int lineNr = 0;
        int lineSize = 0;
        int i;
        int lineIndex = 0;
        boolean startExist = false;
        boolean goalExist = false;

        // Read the file and stores each line in an queue.
        while((line = buffer.readLine()) != null){
            if (lineSize < line.length()){
                lineSize = line.length();
            }
            queue.add(line);
            lineNr++;
        }



        maze = new char[lineNr][lineSize];

        // Merging the lines from the file to the maze array.
        while ((line = queue.poll()) != null){
            i = 0;

            while (i < line.length()){
                maze[lineIndex][i] = line.charAt(i);
                i++;
            }
            i = 0 ;
            lineIndex++;
        }

        for (int row = 0; row <lineNr; row++){
            for (int column = 0; column < lineSize; column++){
                System.out.print(maze[row][column]);
                start = new Position(row,column);
                if (maze[row][column] == 'G'){
                    goalExist = true;
                }
                if (maze[row][column] == 'S'){
                    startExist = true;
                }
            }
        }

        if(!goalExist ||  !startExist){
            throw new IOException("Invalid Maze on file")
        }

    }

  //  public boolean  IsMovable(Position p){

  //  }

  //  public boolean isGoal(Position p){

  //  }

  //  public Position getStartPosition(){

   // }
}
